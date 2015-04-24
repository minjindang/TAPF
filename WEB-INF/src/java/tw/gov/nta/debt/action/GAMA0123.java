/* GAMA0115.java
 �{���ت��GGAMA01
 �{���N���GGAMA01
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
			setAlertMessage(request,"�ק令�\");
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
