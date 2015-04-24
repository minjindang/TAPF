<%@ page pageEncoding="Big5" %>
<script language="javascript">
function doBodyOnLoad(document)
{
	//countDay(document.MainForm);
}

function checkForm(form)
{
	var cols = new Array("addSourceIssueId_options","Date(issueDate)","issueSerial","bondType_options","debtName","issueKind_options","bondSellStatus","rateKind_options","BigDecimal(issueAmount)","BigDecimal(realAmount)");
	var colNames = new Array("原始發行公債名稱","增額發行日期","增額公債代號","增額公債識別碼","增額公債名稱","增額公債形式","可分割公債","利率變動別","發行額","實收數");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("【" + colNames[result] + "】，未輸入!!");
		form.focus(cols[result]);
	}
	return result < 0;
}

function changeList(form)
{
	form.action = "AIMA0201AList" ;
	form.submit() ;
}

function countDay(form)
{
	//var newDate = form.elements['Date(issueDate)'].value;
	//var oldDate = form.elements['Date(sourceIssueDate)'].value;
	//if("" != newDate && "" != oldDate)
	//{
	//	document.getElementById('diff').innerHTML = daycount(oldDate,newDate,'C');
	//}	
}	
function count(form){
	if(form.elements["interestAlternate"].value != 0)
		document.getElementById("repayInterestInterval").innerHTML = ((form.elements["issueInterval"].value * 12) / form.elements["interestAlternate"].value) + "月";
	if(form.elements["repayAlternate"].value != 0)
		document.getElementById("repayCapitalInterval").innerHTML = ((form.elements["issueInterval"].value * 12) / form.elements["repayAlternate"].value) + "月";
}
</script>