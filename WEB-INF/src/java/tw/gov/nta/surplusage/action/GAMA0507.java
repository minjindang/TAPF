package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.CentralStatisticsMain;
import tw.gov.nta.sql.UserStatisticsDet;
import tw.gov.nta.sql.UserStatisticsMain;
import tw.gov.nta.surplusage.common.UserStatisticsDetManager;
import tw.gov.nta.surplusage.common.UserStatisticsManager;
import tw.gov.nta.surplusage.form.Gama0501Form;
import tw.gov.nta.surplusage.form.Gama0502Form;
import tw.gov.nta.system.common.CentralStatisticsManager;

public class GAMA0507 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Gama0501Form myForm = (Gama0501Form) form;
		Gama0502Form gama0502Form = new Gama0502Form();
		gama0502Form.setMainId(myForm.getId());
		List list = new UserStatisticsDetManager().getBeanByMainMaxYear(myForm.getId());
		if(list != null && list.size()>0){
			for(Iterator it = list.iterator();it.hasNext();){
				 UserStatisticsDet dto = (UserStatisticsDet) it.next();
				 gama0502Form.setAccountYear(dto.getAccountYear());
//				 gama0502Form.setKeepAmount(dto.getKeepAmount());
				 gama0502Form.setDataType(dto.getDataType());
				 gama0502Form.setLastKeepAmount(dto.getKeepAmount());
				 gama0502Form.setAuditAmount(dto.getKeepAmount());
//				 gama0502Form.setOldKeepAmount(dto.getKeepAmount());
		    }
//			request.setAttribute("key","2");//調度資料已存在
		}
//		else{
//			request.setAttribute("key", "1");//目前無調度資料
//		}
		request.setAttribute("mainAccountYear", myForm.getAccountYear());
		UserStatisticsMain mainDto = new UserStatisticsManager().get(myForm.getId());
		BigDecimal realAmount = new BigDecimal(0);
		list = new CentralStatisticsManager().search(new String[]{"accountYear","budgetCode","debtCode","boundCode","inoutType","accountKind"}, new Object[]{(gama0502Form.getAccountYear()!=null)?gama0502Form.getAccountYear():mainDto.getAccountYear(),mainDto.getBudgetCode(),mainDto.getDebtCode(),mainDto.getBoundCode(),mainDto.getInoutType(),"4"}, new String[]{"<","=","=","=","=","="}, null);
		for(Iterator it = list.iterator();it.hasNext();){
			CentralStatisticsMain csMain = (CentralStatisticsMain)it.next();
			realAmount = realAmount.add(csMain.getIssueAmount());
		}
		gama0502Form.setRealAmount(realAmount);
		list = new CentralStatisticsManager().search(new String[]{"accountYear","budgetCode","debtCode","boundCode","inoutType","accountKind"}, new Object[]{(gama0502Form.getAccountYear()!=null)?gama0502Form.getAccountYear():mainDto.getAccountYear(),mainDto.getBudgetCode(),mainDto.getDebtCode(),mainDto.getBoundCode(),mainDto.getInoutType(),"4"}, new String[]{"=","=","=","=","=","="}, null);
		BigDecimal issueAmount = new BigDecimal(0);
		if(list != null && list.size()>0){
			for(Iterator it = list.iterator();it.hasNext();){
				CentralStatisticsMain tCentralStatisticsMain = (CentralStatisticsMain)it.next();
				issueAmount = issueAmount.add(tCentralStatisticsMain.getIssueAmount());
			}
			gama0502Form.setPlusdebtAmount(issueAmount);
		}
		request.setAttribute("Gama0502Form",gama0502Form);
	}
}
