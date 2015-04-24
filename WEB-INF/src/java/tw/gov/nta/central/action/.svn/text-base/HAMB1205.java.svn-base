package tw.gov.nta.central.action;
import gov.dnt.tame.common.DefaultAction;
import java.math.BigDecimal;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.Service;
import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.central.common.UnitInfo;
import tw.gov.nta.central.form.Hamb1201Form;
import tw.gov.nta.sql.UnitAllocateMain;
import tw.gov.nta.sql.UnitInfoMain;

public class HAMB1205 extends DefaultAction {
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO 自動產生方法 Stub
		Hamb1201Form hamb1201form = (Hamb1201Form) form;
		//使用Service:UnitInfo
		//使用 UnitInfo.getUnitInfoMain 查詢單筆
		UnitAllocateMain unitAllocateMain = UnitAllocate.getBean(hamb1201form.getId());

		UnitInfoMain unitInfoMain = UnitInfo.get(hamb1201form.getUnitInfoId());
		unitAllocateMain.setUnitInfo(unitInfoMain);
		
		java.math.BigDecimal financial = tw.gov.nta.central.common.UnitPercent101.getByYear(unitInfoMain,hamb1201form.getQryAllYear()).getFinancial();
		if(financial.equals(new BigDecimal(0)))
			hamb1201form.setFinancialPerMonth(financial);
		else
			hamb1201form.setFinancialPerMonth(financial.divide(new BigDecimal(12),0,BigDecimal.ROUND_HALF_UP));
		//System.out.println("financial : " + financial);
		//回傳 ActionForm
		hamb1201form.setUnitInfo(unitInfoMain);
		hamb1201form.setUnitAllocateMain(unitAllocateMain);
		hamb1201form.setUnitId( unitInfoMain.getUnitId() );
		hamb1201form.setUnitName( unitInfoMain.getUnitName() );
		hamb1201form.setNotea(ChangeName(unitInfoMain.getNotea(),unitInfoMain.getUnitName(),unitAllocateMain.getAllMoney().setScale(0,BigDecimal.ROUND_HALF_UP).toString()));
	}
	public String ChangeName(String pData,String pUnitName,String pAmount){
		//$1政府中央統籌分配款$2元
		System.out.println(pData.length());
		String newData = "";
		newData += pData.substring(0,pData.indexOf("$1"))+pUnitName+pData.substring(pData.indexOf("$1")+2,pData.indexOf("$2"))+new java.text.DecimalFormat("#,###").format(new BigDecimal(pAmount))+pData.substring(pData.indexOf("$2")+2,pData.length());
		System.out.println(newData);
		return newData;
	}
}
