<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<script language="javascript">
function doBodyOnLoad(document)
{
	oNumberMask = new Mask("###.000", "number");
	moneyCols = new Array("BigDecimal(averageRate)");
	for(var i = 0 ; i < moneyCols.length ; i++)
	{
		oNumberMask.attach(document.MainForm.elements[moneyCols[i]]);
		document.MainForm.elements[moneyCols[i]].value = addMoneyMask(document.MainForm.elements[moneyCols[i]].value);
	}
}

function checkForm(form)
{
	var cols = new Array("issueSerial" , "bondKind", "bondType", "issueKind", "budgetCode", "debtCode", "accountYear", "debtName", "Date(issueDate)", "BigDecimal(issueAmount)", "issueInterval", "rateKind", "BigDecimal(averageRate)", "Date(firstInterestDate)", "interestAlternate", "Date(firstRepayDate)", "repayAlternate", "payLimit");
	var colNames = new Array("���ťN��", "���ŵo�����", "�����ѧO�X", "���ū���", "�w��O", "�ŰȧO", "�|�p�~��", "���ŦW��", "�o����", "�o���B", "����", "�Q�v�ܰʧO", "�Q�v�~��", "�����I�����", "�I������", "�����٥����", "�٥�����", "���ħI�I����");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("�i" + colNames[result] + "�j�A����J!!");
		form.focus(cols[result]);
	}
	
	return result < 0;
}

function count(form){
	if(form.elements["interestAlternate"].value != 0)
		document.getElementById("repayInterestInterval").innerHTML = ((form.elements["issueInterval"].value * 12) / form.elements["interestAlternate"].value) + "��";
	if(form.elements["repayAlternate"].value != 0)
		document.getElementById("repayCapitalInterval").innerHTML = ((form.elements["issueInterval"].value * 12) / form.elements["repayAlternate"].value) + "��";
}

function doBlur(form){
	form.action="AIMA0100M";
	form.submit();
}

function changeList(form)
{
	doAction("AIMA0101MList");
}
</script>