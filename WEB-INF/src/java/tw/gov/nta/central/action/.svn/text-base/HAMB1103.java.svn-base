package tw.gov.nta.central.action;
import gov.dnt.tame.common.DefaultAction;
import java.math.BigDecimal;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.Taxaction101;
import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.central.form.Hamb1101Form;
import tw.gov.nta.sql.TaxactionDet101;

public class HAMB1103 extends DefaultAction {
	private final static String NO_SUITABLE_VALUE = "查無符合記帳年度和分配年月的資料!!";
	private final static BigDecimal DEFAULT_BIGDECIMAL = new BigDecimal(0).setScale(0);

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Hamb1101Form myform = (Hamb1101Form) form;
		//myform.setTaxKind("1"); //測試用 loadpage 時捉的

		TaxactionDet101 myDet = Taxaction101.getByYear(myform.getTaxYear(),myform.getTaxMonth());
		if( null == myDet )
		{
			setAlertMessage(request,NO_SUITABLE_VALUE);
			myform.setId(0);
			myform.setNationTax(DEFAULT_BIGDECIMAL);
			myform.setIntTax(DEFAULT_BIGDECIMAL);
			myform.setFillAmount(DEFAULT_BIGDECIMAL);
			myform.setTotMon(DEFAULT_BIGDECIMAL);
			myform.setNationRate(DEFAULT_BIGDECIMAL);
			myform.setLocalRate(DEFAULT_BIGDECIMAL);
			myform.setIntRate(DEFAULT_BIGDECIMAL);
			//1~12月
			int nowMonth = -1;
			try{
				nowMonth = Integer.parseInt(myform.getTaxMonth().substring(3,5));
			}catch(Exception e){
				setAlertMessage(request,NO_SUITABLE_VALUE);
			}
			if(nowMonth <= 12 && nowMonth > 0){
				BigDecimal financial = Taxaction101.GetFinancialByTaxyear(myform.getTaxYear());
				if(financial!= null && !financial.equals(DEFAULT_BIGDECIMAL))
				{
					myform.setFinancial(financial.divide(new BigDecimal(12)).setScale(0,BigDecimal.ROUND_HALF_UP));
					myform.setFinancialCheck("Y");
				}else
				{
					myform.setFinancialCheck("N");
					myform.setFinancial(DEFAULT_BIGDECIMAL);
				}
			}
			else
			{
				myform.setFinancialCheck("N");
				myform.setFinancial(DEFAULT_BIGDECIMAL);
			}
		}
		else
		{
			myform.setTaxactionDet(myDet);
			//myform.setTotMon(UnitAllocate.SrcAccount(myform.getTaxYear(),myform.getTaxMonth()));
		}
	}
}
