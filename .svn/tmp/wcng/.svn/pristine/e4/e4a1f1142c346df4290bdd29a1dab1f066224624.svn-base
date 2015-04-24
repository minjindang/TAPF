<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<script language="javascript">

function doBodyOnLoad(document)
{
	//var oNumberMask = new Mask("#,###", "number");
	//var moneyCols = new Array("BigDecimal(buyAmount)","BigDecimal(advanceInterest)","BigDecimal(advanceTax)","BigDecimal(finalAmount)","BigDecimal(buyPremium)");
	//for(var i = 0 ; i < moneyCols.length ; i++)
	//{
		//oNumberMask.attach(document.MainForm.elements[moneyCols[i]]);
		//document.MainForm.elements[moneyCols[i]].value = addMoneyMask(document.MainForm.elements[moneyCols[i]].value);
	//}
}

function checkData(form)
{
	advanceAmount = replaceAll(form.elements['BigDecimal(advanceAmount)'].value,",","");
	advanceRate = form.elements['BigDecimal(advanceRate)'].value;
	advanceDate = form.elements['Date(advanceDate)'].value;
	
	var message = "";
	if(null == advanceAmount || "" == advanceAmount || "0" == advanceAmount)
		message += "[提前買回金額]未輸入!!\n";
	if(null == advanceRate || "" == advanceRate)
		message += "[最低得僄利率]未輸入!!\n";
	if(null == advanceDate || "" == advanceDate)
		message += "[提前買回日期]未輸入!!\n"
		
	if("" == message) {
		return true;
	}else{
		alert(message);
		return false;
	}
}

function checkData1(form)
{
	advanceAmount = form.elements['BigDecimal(advanceAmount)'].value;
	advanceRate = form.elements['BigDecimal(advanceRate)'].value;
	advanceDate = form.elements['Date(advanceDate)'].value;
	
	var message = "";
	if(null == advanceAmount || "" == advanceAmount || "0" == advanceAmount)
		message += "[提前買回金額]未輸入!!\n";
	if(null == advanceRate || "" == advanceRate)
		message += "[最低得僄利率]未輸入!!\n";
	if(null == advanceDate || "" == advanceDate)
		message += "[提前買回日期]未輸入!!\n"
	buyAmount = form.elements['BigDecimal(buyAmount)'].value;
	if("" == message && (null == buyAmount || "" == buyAmount || "0" == buyAmount))
		message += "尚未執行[試算]，請先執行[試算]後，確認各項無誤後，再新增!!";
		
	if("" == message) {
		message += "您輸入的[提前買回金額]為"+advanceAmount+"\n";
		message += "您輸入的[最低得僄利率]為"+advanceRate+"\n";
		message += "您輸入的[提前買回日期]為"+advanceDate+"\n";
		alert(message);
		advanceInterest = form.elements['BigDecimal(advanceInterest)'].value;
		buyPremium = form.elements['BigDecimal(buyPremium)'].value;
		advanceTax = form.elements['BigDecimal(advanceTax)'].value;
		finalAmount = form.elements['BigDecimal(finalAmount)'].value;
		message = "計算後的[買回價款]為"+buyAmount+"\n";
		message += "計算後的[應計利息]為"+advanceInterest+"\n";
		message += "計算後的[買回溢(折)價]為"+buyPremium+"\n";
		message += "計算後的[應扣累計稅款]為"+advanceTax+"\n";
		message += "計算後的[稅後買進金額]為"+finalAmount+"\n";
		message += "請確認計算後各項金額是否正確!!!";
		alert(message);
		return confirm("新增後將無法修改，是否確認新增!!");
	}else{
		alert(message);
		return false;
	}
}
</script>