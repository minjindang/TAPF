<%@ page pageEncoding="Big5" %>
<script language="javascript">
function doBodyOnLoad(document)
{
	//do nothing
}

function checkForm(form)
{
	var cols = new Array(
		"accountYear","nationRefId","bigDecimal(gdpAmount)","bigDecimal(gnpAmount)","bigDecimal(pergnpAmount)",
		"bigDecimal(remainRate)","bigDecimal(borrowAmount)","bigDecimal(budgetAmount)",
		"bigDecimal(nopayAmount)");
	var colNames = new Array(
		"�~��","��O","GDP","GNP","�e�T�~����GNP",
		"�ŰȾl�B/GDP���","���Ż��ɵo���`�B","���X�`�B(�w���)",
		"���v�l�B");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("�i" + colNames[result] + "�j�A����J!!");
	}
	return result < 0;
}
function checkDate(form)
{
	if(form.nationRefId.value !="" && form.accountYear.value !="")
	{
		doAction("GAMA0201M");
	}
}
</script>