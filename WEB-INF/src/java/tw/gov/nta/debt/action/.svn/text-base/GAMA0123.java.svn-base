/* GAMA0115.java
 程式目的：GAMA01
 程式代號：GAMA01
 程式日期：0950307
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.DebtPlanDet;

public class GAMA0123 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myform = (Cima0101Form)form;
		List caplist = (List)request.getSession().getAttribute("caplist");	
		List newcaplist = new LinkedList();
		List tempList = (List)request.getSession().getAttribute("newcaplist");
		if(null != tempList && 0 != tempList.size())
		{
			newcaplist = tempList;
		}	
		if( myform.getNowindex() <= caplist.size())
		{
			DebtPlanDet oldCap = new DebtPlanDet();
			DebtPlanDet newCap  = new DebtPlanDet();
			DebtPlanDet tempCap = checkDecimal((DebtPlanDet)caplist.get(myform.getNowindex()-1));

			BeanUtils.copyProperties(oldCap,tempCap);
			BeanUtils.copyProperties(newCap,tempCap);
			
			oldCap.setDeleteMark("Y");
			
			newCap.setId(null);
			newCap.setRepayDate(myform.getRepayDate());
			newCap.setCapitalAmount(myform.getCapitalAmount());
			newCap.setDeleteMark("N");

			caplist.set(myform.getNowindex()-1,newCap);
			newcaplist.add(oldCap);
			
			request.getSession().setAttribute("caplist",caplist);
			request.getSession().setAttribute("newcaplist",newcaplist);
			setAlertMessage(request,"修改成功");
		}
		else
		{
			setAlertMessage(request,"無此資料");
		}	
	}
	//因為有用到BeanUtils.copyProperties所以要先去除bigDecimal為null的值
	public DebtPlanDet checkDecimal(DebtPlanDet tempDet)
	{
		if(null == tempDet.getCapitalAmount())
		{
			tempDet.setCapitalAmount(new BigDecimal(0));
		}
		if(null == tempDet.getChargeAmount())
		{
			tempDet.setChargeAmount(new BigDecimal(0));
		}
		if(null == tempDet.getInterestAmount())
		{
			tempDet.setInterestAmount(new BigDecimal(0));
		}
		if(null == tempDet.getOriginInterestAmount())
		{
			tempDet.setOriginInterestAmount(new BigDecimal(0));
		}
		if(null == tempDet.getTransferCapitalAmount())
		{
			tempDet.setTransferCapitalAmount(new BigDecimal(0));
		}
		if(null == tempDet.getTransferInterestAmount())
		{
			tempDet.setTransferInterestAmount(new BigDecimal(0));
		}
		return tempDet;
	}
}
