package tw.gov.nta.central.action;
import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.math.BigDecimal;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.Taxaction101;
import tw.gov.nta.central.form.Hamb1101Form;
import tw.gov.nta.sql.TaxactionDet101;


public class HAMB1102 extends DefaultAction{
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// 取得 formBean
		Hamb1101Form myform = (Hamb1101Form) form;
		TaxactionDet101 myDet = new TaxactionDet101();
		//myform.setTaxKind("2"); //loadpage時讀的要使用者登入時去get的
		//使用Service:Taxactioin101
		//使用 Taxaction101.updateformoney 更新
		if(null != myform.getId() && 0 != myform.getId())
		{	
			try{
				Taxaction101.allocate(myform.getTaxYear(),myform.getTaxMonth(),myform.getNationTax(),myform.getIntTax(),myform.getNationRate(),myform.getLocalRate(),myform.getIntRate(),this.getUserId(request),new BigDecimal(0),new BigDecimal(0),myform.getFinancial());
				Taxaction101.updateformoney(myDet.getId(),myform.getNationTax(),myform.getFinancial(),myform.getFinancialCheck(),myform.getIntTax(),myform.getFillAmount(),myform.getNationRate(),myform.getLocalRate(),myform.getIntRate(),myform.getTotMon());
				setAlertMessage(request,Messages.SUCCESS_MODIFY);
			}catch(Exception e){
					setAlertMessage(request,"本月份已確認，禁止重新分配!!");
			}
		}
		else
		{	
			Taxaction101.create(myform.getTaxYear(),myform.getTaxMonth());
			myDet = Taxaction101.getByYear(myform.getTaxYear(),myform.getTaxMonth());
			Taxaction101.updateformoney(myDet.getId(),myform.getNationTax(),myform.getFinancial(),myform.getFinancialCheck(),myform.getIntTax(),myform.getFillAmount(),myform.getNationRate(),myform.getLocalRate(),myform.getIntRate(),myform.getTotMon());
			setAlertMessage(request,Messages.SUCCESS_ADD);
		}
	}
}
