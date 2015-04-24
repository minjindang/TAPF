package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.Taxaction;
import tw.gov.nta.central.form.Hamb0301Form;
import tw.gov.nta.sql.TaxactionDet;

public class HAMC0302 extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// 取得 formBean
		Hamb0301Form myform = (Hamb0301Form) form;
		myform.setUsrid(this.getUserId(request));
		TaxactionDet myDet = new TaxactionDet();
		myform.setTaxKind("2"); //loadpage時讀的要使用者登入時去get的
		myform.setModDate(new Date());
		//myform.setId(1);	 	//此值由javascript去得取(測試用)
		
		//使用Service:Taxactioin
		//使用 Taxaction.updateformoney 更新
		if(null != myform.getId() && 0 != myform.getId())
		{	
			try{
				myform.setTotMon(
						Taxaction.tryAccount(myform.getTaxYear(),
						myform.getTaxMonth(),myform.getTaxKind(),myform.getNationTax()
						,myform.getLocalTax(),myform.getIntTax(),myform.getUsrid(),myform.getFillAmount()
						,new BigDecimal(0), new BigDecimal(0), new BigDecimal(0))
						);
				Taxaction.updateformoney(myform.getId(),myform.getNationTax(),myform.getLocalTax(),myform.getIntTax()
						,myform.getFillAmount(), new BigDecimal(0), new BigDecimal(0), new BigDecimal(0));
				setAlertMessage(request,Messages.SUCCESS_MODIFY);
			}catch(Exception e){
					setAlertMessage(request,"本月份已確認，禁止重新分配!!");
			}
		}
		else
		{	
			myform.setCreateDate(new Date());
			Taxaction.create(myform.getTaxYear(),myform.getTaxMonth(),myform.getTaxKind(),myform.getUsrid());
			myDet = Taxaction.getByYear(myform.getTaxYear(),myform.getTaxMonth(),myform.getTaxKind());
			Taxaction.updateformoney(myDet.getId(),myform.getNationTax(),myform.getLocalTax(),myform.getIntTax(),myform.getFillAmount(),
					myform.getNationRate(),myform.getLocalRate(),myform.getIntRate());
			setAlertMessage(request,Messages.SUCCESS_ADD);
		}
	}
}
