/* CIMA0115.java
 �{���ت��GCIMA01
 �{���N���GCIMA01
 �{������G0950307
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;

public class CIMA0123 extends DefaultAction {

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

			DebtPlanDet tempCap = (DebtPlanDet)BeanUtils.cloneBean(checkDecimal((DebtPlanDet)caplist.get(myform.getNowindex()-1)));
			DebtPlanDet oldCap = new DebtPlanDet();
			DebtPlanDet newCap = new DebtPlanDet();
			
			BeanUtils.copyProperties(oldCap,tempCap);	
			oldCap.setDeleteMark("Y");
			newcaplist.add(oldCap);
			request.getSession().setAttribute("newcaplist",newcaplist);
			
			newCap.setRepayDate(myform.getRepayDate());
			newCap.setIssueId(tempCap.getIssueId());
			newCap.setCapitalSerial(0);
			newCap.setInterestSerial(0);
			newCap.setCapitalAmount(myform.getCapitalAmount());
			newCap.setDeleteMark("N");
			newCap.setDebt(tempCap.getDebt());
			
			caplist.set(myform.getNowindex()-1,checkDecimal(newCap));
			
			Date repayDate = null;
			Date repayedDate = null;
			DebtPlanDet temp = null;
			
			for(int i=0;i<caplist.size();i++)
			{
				repayDate = ((DebtPlanDet)caplist.get(i)).getRepayDate();
				for(int j=i+1;j<caplist.size();j++)
				{	
					repayedDate = ((DebtPlanDet)caplist.get(j)).getRepayDate();
					if(repayDate.after(repayedDate))
					{
						temp = ((DebtPlanDet)caplist.get(i));
						caplist.set(i,((DebtPlanDet)caplist.get(j)));
						caplist.set(j,temp);
					}
				}	
			}	
			
			request.getSession().setAttribute("caplist",caplist);
			setAlertMessage(request,"�ק令�\");

			PlanManager planManager = new PlanManager();
			planManager.confirm(newcaplist);
			planManager.confirm(caplist);
			
		}
		else
		{
			setAlertMessage(request,"�L�����");
		}	
	}
	//�]�����Ψ�BeanUtils.copyProperties�ҥH�n���h��bigDecimal��null����
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
