<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<script language="javascript">
function doBodyOnLoad(document)
{
	<logic:present name="historyBack">
		window.history.back();
	</logic:present>
	/*var toDay = new Date();
	var Day=(toDay.getYear()-1911);
	if (Day<100)
	{
		Day="0"+(toDay.getYear()-1911);
		document.MainForm.accountYear.value = Day;
	}
	else
	{
		Day =(toDay.getYear()-1911);
		document.MainForm.accountYear.value = Day;
	}
	document.MainForm.elements['bigDecimal(gdpAmount)'].value = 0;
	document.MainForm.elements['bigDecimal(gnpAmount)'].value = 0;
	document.MainForm.elements['bigDecimal(pergnpAmount)'].value = 0;
	document.MainForm.elements['bigDecimal(budgetAmount)'].value = 0;
	document.MainForm.elements['bigDecimal(remainRate)'].value = 0;
	document.MainForm.elements['bigDecimal(borrowAmount)'].value = 0;*/
}

function checkForm(form)
{
	var cols = new Array(
		"accountYear","nationRefId","bigDecimal(gdpAmount)","bigDecimal(gnpAmount)","bigDecimal(pergnpAmount)",
		"bigDecimal(remainRate)","bigDecimal(borrowAmount)","bigDecimal(budgetAmount)",
		"bigDecimal(nopayAmount)");
	var colNames = new Array(
		"年度","國別","GDP","GNP","前三年平均GNP",
		"債務餘額/GDP比例","公債賒借發行總額","歲出總額(預算數)",
		"未償餘額");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("【" + colNames[result] + "】，未輸入!!");
	}
	return result < 0;
}
function checkDate(form)
{
	if(form.nationRefId.value !="" && form.accountYear.value !="")
	{
		doAction("GAMA0201A");
	}
}
</script>