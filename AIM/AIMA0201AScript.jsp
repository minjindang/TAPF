<%@ page pageEncoding="Big5" %>
<script language="javascript">
function doBodyOnLoad(document)
{
	//countDay(document.MainForm);
}

function checkForm(form)
{
	var cols = new Array("addSourceIssueId_options","Date(issueDate)","issueSerial","bondType_options","debtName","issueKind_options","bondSellStatus","rateKind_options","BigDecimal(issueAmount)","BigDecimal(realAmount)");
	var colNames = new Array("��l�o�椽�ŦW��","�W�B�o����","�W�B���ťN��","�W�B�����ѧO�X","�W�B���ŦW��","�W�B���ŧΦ�","�i���Τ���","�Q�v�ܰʧO","�o���B","�ꦬ��");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("�i" + colNames[result] + "�j�A����J!!");
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
		document.getElementById("repayInterestInterval").innerHTML = ((form.elements["issueInterval"].value * 12) / form.elements["interestAlternate"].value) + "��";
	if(form.elements["repayAlternate"].value != 0)
		document.getElementById("repayCapitalInterval").innerHTML = ((form.elements["issueInterval"].value * 12) / form.elements["repayAlternate"].value) + "��";
}
</script>