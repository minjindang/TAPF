/**
*
* @author Andrew Sung
* @createDate 2006/8/23
*/
package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.CentralStatisticsMain;
import tw.gov.nta.sql.UserStatisticsMain;
import tw.gov.nta.surplusage.common.UserStatisticsDetManager;
import tw.gov.nta.surplusage.common.UserStatisticsManager;
import tw.gov.nta.surplusage.form.Gama0502Form;
import tw.gov.nta.system.common.CentralStatisticsManager;

public class GAMA0502Change2 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gama0502Form myForm = (Gama0502Form)form;
		BigDecimal realAmount = new BigDecimal(0);   //�֭p��ڼ�
		BigDecimal plusdebtAmount = new BigDecimal(0);//��~�W�[��ڼ�
		UserStatisticsMain dto = new UserStatisticsManager().get(myForm.getMainId());
		//�H�Űȸ�ƪ��w��O+�ŰȧO+���v�_+���~�ŧ�X�ӵ��ի׸�Ƥ��e�~���o��ƪ��X�p
		List list = new CentralStatisticsManager().search(new String[]{"accountYear","budgetCode","debtCode","boundCode","inoutType","accountKind"}, new Object[]{myForm.getAccountYear(),dto.getBudgetCode(),dto.getDebtCode(),dto.getBoundCode(),dto.getInoutType(),"4"}, new String[]{"<","=","=","=","=","="}, null);
		for(Iterator it = list.iterator();it.hasNext();){
			CentralStatisticsMain csMain = (CentralStatisticsMain)it.next();
			realAmount = realAmount.add(csMain.getIssueAmount());
		}
		myForm.setRealAmount(realAmount);
//		�H�Űȸ�ƪ��w��O+�ŰȧO+���v�_+���~��+�~�ק�X�ӵ��ի׸�ƪ��o��ƪ��X�p
		list = new CentralStatisticsManager().search(new String[]{"accountYear","budgetCode","debtCode","boundCode","inoutType","accountKind"}, new Object[]{myForm.getAccountYear(),dto.getBudgetCode(),dto.getDebtCode(),dto.getBoundCode(),dto.getInoutType(),"4"}, new String[]{"=","=","=","=","=","="}, null);
		for(Iterator it = list.iterator();it.hasNext();){
			CentralStatisticsMain csMain = (CentralStatisticsMain)it.next();
			plusdebtAmount = plusdebtAmount.add(csMain.getIssueAmount());
		}
		myForm.setPlusdebtAmount(plusdebtAmount);
		request.setAttribute("mainAccountYear",dto.getAccountYear());
		
	}
}
