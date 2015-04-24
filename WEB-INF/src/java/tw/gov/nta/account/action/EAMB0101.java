/**
 * @author LinusTseng
 * @date 2006/3/8
 * 處理新增程式，並導向清單
 */

package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;

import tw.gov.nta.account.form.Eamb0101Form;
import tw.gov.nta.debt.account.common.DebtAccountManager;
import tw.gov.nta.sql.debt.DebtTypeRef;
import tw.gov.nta.sql.debt.dao.DebtTypeRefDAO;

/**
 * 到查詢
 * @author Administrator
 *
 */
public class EAMB0101 extends DefaultAction
{

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
	}

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.AuthQueryAction#initialize(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void initialize(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		super.initialize(mapping, form, request, response);
		String parameter = mapping.getParameter();
		HttpSession session = request.getSession();
		session.setAttribute("SYSID",parameter);
		String debtTypeCode = String.valueOf(parameter.charAt(1));
		DebtTypeRefDAO dao = DebtTypeRefDAO.getInstance();
		Criteria criteria = dao.getSession().createCriteria(DebtTypeRef.class);
		criteria.add(Expression.eq("typeCode",debtTypeCode));
		DebtTypeRef debtType = (DebtTypeRef)criteria.list().get(0);
		session.setAttribute("debtType",debtType);
		session.setAttribute("debtTypeId",debtType.getId());
		session.setAttribute("debtTypeCode",debtTypeCode);
		
		int voucherType = 0;
		String sysType = String.valueOf(parameter.charAt(5));
	    
		/**
		 * 系統代號第六碼為1的為經售(舉借類)傳票編製
		 *              2   經付(償付類)
		 *              3   特殊傳票
		 *              4   手續費
		 */
		if ("1".equals(sysType))
			voucherType = DebtAccountManager.Sell;
		else if ("2".equals(sysType))
			voucherType = DebtAccountManager.Pay;
		else if ("3".equals(sysType))
			voucherType = 0;
		else if ("4".equals(sysType))
			voucherType = DebtAccountManager.Charge;
		
		session.setAttribute("voucherType",voucherType);
		
		setFormInitialize(form,voucherType);
		

	}

	private void setFormInitialize(ActionForm form,int voucherType) {
		// TODO Auto-generated method stub
		if (form instanceof Eamb0101Form) {
			Eamb0101Form myform = (Eamb0101Form)form;
			
	
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.set(Calendar.DATE,1);
			
			if(voucherType == DebtAccountManager.Sell) {
				myform.setStartIssueDate(DateUtil.date2ROCStr(calendar.getTime()));
				myform.setEndIssueDate(DateUtil.date2ROCStr(DateUtil.getLastDateOfMonth(calendar.getTime())));
			}else if(voucherType == DebtAccountManager.Pay){
				myform.setStartRepayDate(DateUtil.date2ROCStr(calendar.getTime()));
				myform.setEndRepayDate(DateUtil.date2ROCStr(DateUtil.getLastDateOfMonth(calendar.getTime())));		
			}else if(voucherType == DebtAccountManager.Charge){
				if (calendar.get(Calendar.MONTH) < 6) {
					calendar.set(calendar.get(Calendar.YEAR),0,1);
					myform.setStartRepayDate(DateUtil.date2ROCStr(calendar.getTime()));
					calendar.set(calendar.get(Calendar.YEAR),5,30);
					myform.setEndRepayDate(DateUtil.date2ROCStr(calendar.getTime()));
				}else {
					calendar.set(calendar.get(Calendar.YEAR),6,1);
					myform.setStartRepayDate(DateUtil.date2ROCStr(calendar.getTime()));
					calendar.set(calendar.get(Calendar.YEAR),11,31);
					myform.setEndRepayDate(DateUtil.date2ROCStr(calendar.getTime()));
				}
				
			}
		}
	}


}
