package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.Service;
import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.central.common.UnitInfo;
import tw.gov.nta.central.form.Hamb0401Form;
import tw.gov.nta.sql.UnitAllocateMain;
import tw.gov.nta.sql.UnitInfoMain;

public class HAMB0405 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO 自動產生方法 Stub
		Hamb0401Form hamb0401form = (Hamb0401Form) form;
		//使用Service:UnitInfo
		//使用 UnitInfo.getUnitInfoMain 查詢單筆
		UnitAllocateMain unitAllocateMain = UnitAllocate.getBean(hamb0401form.getId());

		UnitInfoMain unitInfoMain = UnitInfo.get(hamb0401form.getUnitInfoId());
		unitAllocateMain.setUnitInfo(unitInfoMain);
		//回傳 ActionForm
		hamb0401form.setUnitInfo(unitInfoMain);
		hamb0401form.setUnitAllocateMain(unitAllocateMain);
		hamb0401form.setUnitId( unitInfoMain.getUnitId() );
		hamb0401form.setUnitName( unitInfoMain.getUnitName() );
		hamb0401form.setNotea(ChangeName(unitInfoMain.getNotea(),unitInfoMain.getUnitName(),unitAllocateMain.getAllMoney().setScale(0,BigDecimal.ROUND_HALF_UP).toString()));
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