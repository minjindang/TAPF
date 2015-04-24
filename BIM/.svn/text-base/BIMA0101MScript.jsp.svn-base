<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<bean:define id= 'issueDate' name='Bima0101Form' property='date(issueDate)' type="java.lang.String"/>
<bean:define id= 'dueDate' name='Bima0101Form' property='date(dueDate)' type="java.lang.String"/>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
	var oNumberMask = new Mask("0.###", "number");
	var moneyCols = new Array("bigDecimal(averageRate)","bigDecimal(chargeRate)");
	for(var i = 0 ; i < moneyCols.length ; i++)
	{
		oNumberMask.attach(document.MainForm.elements[moneyCols[i]]);
		document.MainForm.elements[moneyCols[i]].value = addMoneyMask(document.MainForm.elements[moneyCols[i]].value);
	}
  	/*var toDay = new Date();
	var Day=(toDay.getYear()-1911);
	if (Day<100)
	{
		Day="0"+(toDay.getYear()-1911);
	}
	else
	{
		Day =(toDay.getYear()-1911);
	}
	if ((toDay.getMonth()+1)<10)
		Day += "0"+(toDay.getMonth()+1);
	else Day+=toDay.getMonth()+1;
	if (toDay.getDate()<10)
		Day += "0"+toDay.getDate();
	else Day +=toDay.getDate();

	document.MainForm.elements['date(modDate)'].value = Day;
	var issueDate = '<%=issueDate%>';
	var dueDate = '<%=dueDate%>';
	document.MainForm.days.value = daycount(issueDate,dueDate,"C");
	document.getElementById("days").innerHTML = daycount(issueDate,dueDate,"C");*/
}
function checkCapitalAmount()
{
  	var	currform	=	document.MainForm;
	var	expectAmount		=	currform.elements['bigDecimal(expectAmount)'].value;
	var	capitalAmount 	=	currform.elements['bigDecimal(capitalAmount)'].value
	currform.elements['bigDecimal(issueAmount)'].value = expectAmount;
	document.getElementById("issueAmount").innerHTML = addMoneyMask(expectAmount) ;
	if(parseInt(capitalAmount)>parseInt(expectAmount))
	{
		currform.elements['bigDecimal(capitalAmount)'].value = "";
		alert("實收額不得大於發行額");
	}	
}
function getDays()
{
	var	currform	=	document.MainForm;
	var	issueDate		=	currform.elements['date(issueDate)'].value;
	var	dueDate 	=	currform.elements['date(dueDate)'].value
	
	if (!(CheckValidDate(issueDate)))
    {
    	return false;
    }
    else
    {
    	var cashDueDate = parseInt(issueDate.substr(0, 3),10)+5;
    	if(cashDueDate<100)
    		cashDueDate = "0"+cashDueDate
    	currform.elements['date(cashDueDate)'].value = cashDueDate+dueDate.substr(3, 4);
    }
	if (!(CheckValidDate(dueDate)))
    {
    	return false;
    }
   	else if (issueDate !="" && dueDate != "")
   	{
		currform.days.value = daycount(issueDate,dueDate,"C");
		document.getElementById("dayid").innerHTML = daycount(issueDate,dueDate,"C") ;
	}
}

function checkValue(form)
{
	var	cols = new Array(
		"accountYear","issueSerial","budgetCode_options","debtCode_options","date(issueDate)",
		"date(dueDate)","bigDecimal(expectAmount)","bigDecimal(capitalAmount)","bigDecimal(averageRate)","bigDecimal(chargeRate)" );
	var colNames = new Array(
		"發行年度","發行期別","預算別","債務別","發行日期",
		"到期日期","發行額","實收額","貼現率","手續費比例");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("【" + colNames[result] + "】未輸入!!");
	}
	return result < 0;
}
//-->
</script>
