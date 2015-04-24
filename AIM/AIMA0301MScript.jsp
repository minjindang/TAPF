<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<script language="javascript">

function doBodyOnLoad(document)
{
		//do nothing
}
function countMoney(form)
{
	var issueAmount = form.elements['BigDecimal(issueAmount)'].value;
	var getPrice = form.elements['BigDecimal(getPrice)'].value;
	var sellAmount = form.elements['BigDecimal(sellAmount)'];
	if(null != issueAmount && "" != issueAmount && null != getPrice && "" != getPrice )
	{
		sellAmount.value =  addMoneyMask(Number(replaceAll(issueAmount,",","")) * (Number(replaceAll(getPrice,",","")) / 100) - Number(replaceAll(issueAmount,",",""))) ;
	}
}
function checkForm(form)
{
	var cols = new Array(     "issueSerial" , "debtName",  "bondType",   "budgetCode", "debtCode", "serialNo", "issueDate", "issueAmount", "Date(issueDate)", "BigDecimal(issueAmount)" ,"issueInterval", "BigDecimal(averageRate)", "BigDecimal(backRate)", "BigDecimal(saleRate)", "BigDecimal(originalPrice)", "BigDecimal(getPrice)", "BigDecimal(foreignCapital)", "exchangeStockCode", "bankCode");
	var colNames = new Array("���ťN��",       "���ŦW��", "�����ѧO�X", "�w��O",     "�ŰȧO",   "���Ŵ���", "�o����",  "�o���B",      "�o����",        "�o���B",                  "����",          "�Q�v�~��",                "���^���q�v",           "��^���q�v",           "��l�洫����",              "�o�л���",             "�~��o�ФW��",               "�洫�Ъ�",          "�A�ȳB�z���c");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("�i" + colNames[result] + "�j�A����J!!");
	}
	return result < 0;
}

function count(form){
	var issueDate = form.elements["Date(issueDate)"].value;
	var issueInterval = form.elements["issueInterval"].value;
	if(issueDate == null || issueInterval == null || issueDate.length != 7 || issueInterval == "")
		return;
	var year = Number(issueDate.substring(0, 3)) + Number(issueInterval);
	var date = year + issueDate.substring(3);
	
	for(var i = 0 ; i < 7 - date.length ; i++)
		date = "0" + date;
	//document.getElementById("dueDate").innerHTML = date;
	document.MainForm.elements["Date(dueDate)"].value = date;
}
function count2(form){
	var issueDate = form.elements["Date(issueDate)"].value;
	var dueDate = form.elements["Date(dueDate)"].value;
	if(issueDate == null || dueDate == null || issueDate.length != 7 || dueDate.length != 7 )
		return;
	var issueInterval = Number(dueDate.substring(0, 3)) - Number(issueDate.substring(0, 3));
	document.MainForm.elements["issueInterval"].value = issueInterval;
}
function changeList(form)
{
	doAction("AIMA0301MList");
}
</script>