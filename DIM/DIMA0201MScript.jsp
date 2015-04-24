<!-- DIMA0101AScript.jsp
程式目的：DIMA01
程式代號：DIMA01
程式日期：0950223
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<bean:define id= 'issueDate' name='Dima0201Form' property='date(issueDate)' type="java.lang.String"/>
<bean:define id= 'dueDate' name='Dima0201Form' property='date(dueDate)' type="java.lang.String"/>
<script language="Javascript">
<!--
var days;
function doBodyOnLoad(document)
{	
	var issueDate = '<%=issueDate%>';
	var dueDate = '<%=dueDate%>';
	document.MainForm.days.value = daycount(issueDate,dueDate,"C");
	document.getElementById("dayid").innerHTML = daycount(issueDate,dueDate,"C") ;
}
function getIssueSerial()
{
	var	currform	=	document.MainForm;
	var	accountYear		=	currform.accountYear.value;
	var	serialNo	=	currform.serialNo.value;
	if( ""!=accountYear && ""!=serialNo )
	{
		currform.issueSerial.value = accountYear+"-"+serialNo
		return currform.issueSerial.value;
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
	if (!(CheckValidDate(dueDate)))
    {
    	return false;
    }
	days = daycount(issueDate,dueDate,"C")
	document.getElementById("dayid").innerHTML = daycount(issueDate,dueDate,"C") ;
	currform.days.value = days
}
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
	if ("" == form.accountYear.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【年度】不可空白!!";
    }
    if ("" == form.serialNo.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【期次】不可空白!!";
    }
    if ("" == form.debtCode.value )
    {
    	isValid = false;
		sError += "\n";
        sError += "【預算別】不可空白!!";
    }
    if ("" == form.budgetCode.value )
    {
    	isValid = false;
		sError += "\n";
        sError += "【債務別】不可空白!!";
    }
    if ("" == form.elements['date(issueDate)'].value )
    {
    	isValid = false;
		sError += "\n";
        sError += "【借款起日】不可空白!!";
    }
    if ("" == form.elements['date(dueDate)'].value )
    {
    	isValid = false;
		sError += "\n";
        sError += "【借款迄日】不可空白!!";
    }
    if ("" == form.debtName.value )
    {
    	isValid = false;
		sError += "\n";
        sError += "【名稱】不可空白!!";
    }
    if ("" == form.elements['bigDecimal(expectAmount)'].value )
    {
    	isValid = false;
		sError += "\n";
        sError += "【預計借款金額】不可空白!!";
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}
function getAmount(num)
{
	var	currform	=	document.MainForm;
	var	issueAmount		=	replaceAll(currform.elements['debtMain['+num+'].issueAmount'].value,",","");
	var	compareRate		=	replaceAll(document.getElementById('compareRate['+num+']').innerHTML,",","");
	var	days		=	currform.days.value.substring(0,((currform.days.value).length)-1);
	if( 0 !=issueAmount  && 0!=compareRate)
	{
		originInterestAmount = issueAmount * compareRate/100*days/365;
		document.getElementById('originInterestAmount['+num+']').innerHTML = addMoneyMask(Math.round(parseFloat(originInterestAmount)));
		document.getElementById('totalAmount['+num+']').innerHTML = addMoneyMask(Math.round(parseFloat(originInterestAmount)+parseFloat(issueAmount)));
		currform.elements['debtMain['+num+'].originInterestAmount'].value = Math.round(originInterestAmount);
		//return currform.allAmount.value;
	}
}
//-->
</script>
