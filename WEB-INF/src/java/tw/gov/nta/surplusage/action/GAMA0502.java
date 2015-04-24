package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.UserStatisticsMain;
import tw.gov.nta.surplusage.common.UserStatisticsManager;
import tw.gov.nta.surplusage.form.Gama0501Form;

public class GAMA0502 extends DefaultAction {
	private final static String Collection_Name = "collection";

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Gama0501Form myForm = (Gama0501Form) form;

		String qryStartYear = "".equals( myForm.getQryStartYear() )?"":myForm.getQryStartYear();
		String qryEndYear = "".equals( myForm.getQryEndYear() )?"":myForm.getQryEndYear();
		Integer qryBudgetCode = (myForm.getQryBudgetCode()==null || myForm.getQryBudgetCode()==0)?null:myForm.getQryBudgetCode();
		Integer qryDebtCode = (myForm.getQryDebtCode()==null || myForm.getQryDebtCode()==0)?null:myForm.getQryDebtCode();
		String qryBoundCode = "".equals( myForm.getQryBoundCode() )?"":myForm.getQryBoundCode();
		String qryInoutType = "".equals(myForm.getQryInoutType())?"":myForm.getQryInoutType();;

		String[] clos = {"accountYear","accountYear","budgetCode","debtCode","boundCode","inoutType"};
		Object[] values={ qryStartYear, qryEndYear, qryBudgetCode, qryDebtCode, qryBoundCode, qryInoutType };
		String[] cond={">=","<=","=","=","=","="};
		String[] orderby={"accountYear"};

		UserStatisticsManager manager = new UserStatisticsManager();
		List<UserStatisticsMain> collection = manager.search(clos,values,cond,orderby);
		request.setAttribute( Collection_Name, collection);
	}
}
