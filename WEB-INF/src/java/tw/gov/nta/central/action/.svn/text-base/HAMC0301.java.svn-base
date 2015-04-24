package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.Taxaction;
import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.central.form.Hamb0301Form;
import tw.gov.nta.sql.TaxactionDet;

public class HAMC0301 extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// 取得 formBean
		Hamb0301Form myform = (Hamb0301Form) form;
		TaxactionDet myDet = new TaxactionDet();
		myform.setModDate(new Date());
		//使用Service:Taxaction
		//使用 Taxaction.tryAccount 計算
		myform.setTaxKind("2"); //loadpage時讀的要使用者登入時去get的
		myform.setUsrid(this.getUserId(request));

		//回傳 總計
		myform.setTotMon(
				Taxaction.tryAccountNoUpd(myform.getTaxYear(),
				myform.getTaxMonth(),myform.getTaxKind(),myform.getNationTax()
				,myform.getLocalTax(),myform.getIntTax(),myform.getUsrid(),myform.getFillAmount()
				,new BigDecimal(0), new BigDecimal(0), new BigDecimal(0))
				);
	}
}
