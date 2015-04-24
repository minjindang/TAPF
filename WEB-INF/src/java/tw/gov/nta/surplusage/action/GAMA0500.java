/**
*
* @author Andrew Sung
* @createDate 2006/6/16
*/
package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.UserStatisticsMain;
import tw.gov.nta.surplusage.common.UserStatisticsManager;
import tw.gov.nta.surplusage.form.Gama0501Form;

public class GAMA0500 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gama0501Form myForm = (Gama0501Form)form;
		UserStatisticsManager manager = new UserStatisticsManager();

		String lastAccountYear = String.valueOf(Integer.parseInt(myForm.getAccountYear()) - 1);
		if(Integer.parseInt(lastAccountYear)<10)
			lastAccountYear = "00"+lastAccountYear;
		if(Integer.parseInt(lastAccountYear)<100)
			lastAccountYear = "0"+lastAccountYear;
		String[] clos = {"accountYear","budgetCode","debtCode","boundCode","inoutType"};
		Object[] values={ lastAccountYear, myForm.getBudgetCode(), myForm.getDebtCode(),  myForm.getBoundCode(),myForm.getInoutType() };
		String[] cond={"=","=","=","=","="};
		String[] orderby={"accountYear"};
		BigDecimal budgetRamount1 = new BigDecimal(0);
		BigDecimal budgetRamount2 = new BigDecimal(0);
		BigDecimal auditRamount1 = new BigDecimal(0);
		BigDecimal auditRamount2 = new BigDecimal(0);
		BigDecimal keepRamount1 = new BigDecimal(0);
		BigDecimal keepRamount2 = new BigDecimal(0);
		BigDecimal realRamount1 = new BigDecimal(0);
		BigDecimal realRamount2 = new BigDecimal(0);
		List<UserStatisticsMain> collection = manager.search(clos,values,cond,orderby);
		for(Iterator it = collection.iterator();it.hasNext();){
			UserStatisticsMain dto =  (UserStatisticsMain) it.next();
			budgetRamount1 = budgetRamount1.add((dto.getBudgetRamount1()!=null)?dto.getBudgetRamount1():new BigDecimal(0));
			budgetRamount2 = budgetRamount2.add((dto.getBudgetRamount2()!=null)?dto.getBudgetRamount1():new BigDecimal(0));
			auditRamount1 = auditRamount1.add((dto.getAuditRamount1()!=null)?dto.getAuditRamount1():new BigDecimal(0));
			auditRamount2 = auditRamount2.add((dto.getAuditRamount2()!=null)?dto.getAuditRamount2():new BigDecimal(0));
			keepRamount1 = keepRamount1.add((dto.getKeepRamount1()!=null)?dto.getKeepRamount1():new BigDecimal(0));
			keepRamount2 = keepRamount2.add((dto.getKeepRamount2()!=null)?dto.getKeepRamount2():new BigDecimal(0));
			realRamount1 = realRamount1.add((dto.getRealRamount1()!=null)?dto.getRealRamount1():new BigDecimal(0));
			realRamount2 = realRamount2.add((dto.getRealRamount2()!=null)?dto.getRealRamount2():new BigDecimal(0));
			
		}
//		List<UserStatisticsMain> collection = manager.search(clos,values,cond,orderby);
//		UserStatisticsMain dto =  collection.iterator().next();
		myForm.setBudgetRamount1(budgetRamount1.add(myForm.getBudgetBamount1()).add(myForm.getBudgetUamount1()).add(myForm.getBudgetPamount1()));
		myForm.setBudgetRamount2(budgetRamount2.add(myForm.getBudgetBamount2()).add(myForm.getBudgetUamount2()).add(myForm.getBudgetPamount2()));
		myForm.setAuditRamount1(auditRamount1.add(myForm.getAuditBamount1()).add(myForm.getAuditUamount1()).add(myForm.getAuditPamount1()));
		myForm.setAuditRamount2(auditRamount2.add(myForm.getAuditBamount2()).add(myForm.getAuditUamount2()).add(myForm.getAuditPamount2()));
		myForm.setKeepRamount1(keepRamount1.add(myForm.getKeepBamount1()).add(myForm.getKeepUamount1()).add(myForm.getKeepPamount1()));
		myForm.setKeepRamount2(keepRamount2.add(myForm.getKeepBamount2()).add(myForm.getKeepUamount2()).add(myForm.getKeepPamount2()));
		myForm.setRealRamount1(realRamount1.add(myForm.getRealBamount1()).add(myForm.getRealUamount1()).add(myForm.getRealPamount1()));
		myForm.setRealRamount2(realRamount2.add(myForm.getRealBamount2()).add(myForm.getRealUamount2()).add(myForm.getRealPamount2()));
	}
}
