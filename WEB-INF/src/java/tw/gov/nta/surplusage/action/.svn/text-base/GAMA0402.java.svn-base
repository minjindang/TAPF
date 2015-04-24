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

public class GAMA0402 extends DefaultAction {
	private final static String Collection_Name = "collection";
	
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gama0401Form myForm = (Gama0401Form) form;
		YearAmountRef dto = new YearAmountRef();

		dto.setAccountYear( myForm.getQryYear() );
		dto.setBudgetCode( myForm.getQryBudgetCode() );
		dto.setDebtCode( myForm.getQryDebtCode() );
		dto.setDataType(myForm.getQryDataType());
		YearAmountManager manager = new YearAmountManager();
		List<YearAmountRef> collection = manager.query(dto);
		BigDecimal budgetAmount = new BigDecimal(0);
		BigDecimal auditAmount = new BigDecimal(0);
		BigDecimal realAmount = new BigDecimal(0);
		BigDecimal keepAmount = new BigDecimal(0);
		for(Iterator it = collection.iterator();it.hasNext();){
			dto = (YearAmountRef)it.next();
			budgetAmount = (dto.getBudgetAmount()!= null)?budgetAmount.add(dto.getBudgetAmount()):budgetAmount.add(new BigDecimal(0));
			auditAmount = (dto.getAuditAmount()!= null)?auditAmount.add(dto.getAuditAmount()):auditAmount.add(new BigDecimal(0));
			realAmount = (dto.getRealAmount()!= null)?realAmount.add(dto.getRealAmount()):realAmount.add(new BigDecimal(0));
			keepAmount = (dto.getKeepAmount()!= null)?keepAmount.add(dto.getKeepAmount()):keepAmount.add(new BigDecimal(0));
		}
		request.setAttribute( "budgetAmount", budgetAmount);
		request.setAttribute( "auditAmount", auditAmount);
		request.setAttribute( "realAmount", realAmount);
		request.setAttribute( "keepAmount", keepAmount);
		request.setAttribute( Collection_Name, collection);
	}
}
