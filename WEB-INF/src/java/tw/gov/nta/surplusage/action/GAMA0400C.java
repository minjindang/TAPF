/**
*
* @author Andrew Sung
* @createDate 2006/6/20
*/
package tw.gov.nta.surplusage.action;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.YearAmountRef;
import tw.gov.nta.surplusage.common.YearAmountManager;
import tw.gov.nta.surplusage.form.Gama0401Form;

import gov.dnt.tame.common.DefaultAction;

public class GAMA0400C extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gama0401Form myForm = (Gama0401Form) form;
		YearAmountManager manager = new YearAmountManager();
//		myForm.setYearAmountRef( manager.get( myForm.getId() ) );
		YearAmountRef dto = new YearAmountRef();
		dto.setAccountYear(myForm.getYearAmountRef().getAccountYear());
		dto.setBudgetCode(new Integer(0));
		dto.setDebtCode(new Integer(0));
		List list = manager.query(dto);
		BigDecimal totalAmount = new BigDecimal(0);
		BigDecimal totalDAmount = new BigDecimal(0);
		BigDecimal totalUAmount = new BigDecimal(0);
		for(Iterator it = list.iterator();it.hasNext();){
			dto = (YearAmountRef)it.next();
			if(dto.isAuditYn()){
				totalAmount = totalAmount.add((dto.getAuditAmount()!= null)?dto.getAuditAmount():new BigDecimal(0));
				totalDAmount = totalDAmount.add((dto.getAuditDamount()!= null)?dto.getAuditDamount():new BigDecimal(0));
				totalUAmount = totalUAmount.add((dto.getAuditUamount()!= null)?dto.getAuditUamount():new BigDecimal(0));
			}
			if(dto.isBudgetYn()){
				totalAmount = totalAmount.add((dto.getBudgetAmount()!= null)?dto.getBudgetAmount():new BigDecimal(0));
				totalDAmount = totalDAmount.add((dto.getBudgetDamount()!= null)?dto.getBudgetDamount():new BigDecimal(0));
				totalUAmount = totalUAmount.add((dto.getBudgetUamount()!= null)?dto.getBudgetUamount():new BigDecimal(0));
			}
			if(dto.isKeepYn()){
				totalAmount = totalAmount.add((dto.getKeepAmount()!= null)?dto.getKeepAmount():new BigDecimal(0));
				totalDAmount = totalDAmount.add((dto.getKeepDamount()!= null)?dto.getKeepDamount():new BigDecimal(0));
				totalDAmount = totalUAmount.add((dto.getKeepUamount()!= null)?dto.getKeepUamount():new BigDecimal(0));
			}
			if(dto.isRealYn()){
				totalAmount = totalAmount.add((dto.getRealAmount()!= null)?dto.getRealAmount():new BigDecimal(0));
				totalDAmount = totalDAmount.add((dto.getRealDamount()!= null)?dto.getRealDamount():new BigDecimal(0));
				totalUAmount = totalUAmount.add((dto.getRealUamount()!= null)?dto.getRealUamount():new BigDecimal(0));
			}
		}
		request.setAttribute("totalAmount",totalAmount);
		request.setAttribute("totalDAmount",totalDAmount);
		request.setAttribute("totalUAmount",totalUAmount);
	}

}
