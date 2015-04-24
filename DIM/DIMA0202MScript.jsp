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
<bean:define id='bank' name="Dima0202Form" property="bank" type="tw.gov.nta.sql.debt.BankRef"/>
<bean:define id='bankCode' name='bank' property='bankCode' type="java.lang.String" />
<bean:define id='issueAmount' name='Dima0202Form' property='issueAmount' type="java.math.BigDecimal" />
<bean:define id='originInterestAmount' name='Dima0202Form' property='originInterestAmount' type="java.math.BigDecimal" />
<bean:define id= 'issueDate' name='Dima0202Form' property='date(issueDate)' type="java.lang.String"/>
<bean:define id= 'dueDate' name='Dima0202Form' property='date(dueDate)' type="java.lang.String"/>
<script language="Javascript" src="/tapf/assets/scripts/getDataBankId.js"></script>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
	
}
function getAmount()
{
	var	currform	=	document.MainForm;
	var	issueAmount		=	replaceAll(currform.elements['bigDecimal(issueAmount)'].value,",","");
	var	compareRate		=	replaceAll(currform.elements['bigDecimal(compareRate)'].value,",","");
	var	days		=	currform.days.value.substring(0,((currform.days.value).length));
	var	originInterestAmount=0;
	if( 0 !=issueAmount  && 0!=compareRate)
	{	//issueAmount * compareRate/100*days/365;
		var issueDate = '<%=issueDate%>';
		var dueDate = '<%=dueDate%>';
		var bascDate = 365;

		var year1 = 1911+parseInt(issueDate.substring(0,3),10);
		var mon1 = parseInt(issueDate.substring(3,5),10);
		var day1 = parseInt(issueDate.substring(5,7),10);
		var year2 = 1911+parseInt(dueDate.substring(0,3),10);
		var mon2 = parseInt(dueDate.substring(3,5),10);
		var day2 = parseInt(dueDate.substring(5,7),10);
		
		var begMyDate = new Date(year1, mon1, day1);
		var EbegMyDate = new Date(year1, 12, 31);
		var endMyDate = new Date(year2, mon2, day2);
		var SbegMyDate = new Date(year2, 1, 1);
		
		if (parseInt(year1)-parseInt(year2)==0)
		{
		bascDate = ((endMyDate-begMyDate) / 86400000 + 1 );
		}
		else
		{
		bascDate = ((EbegMyDate-begMyDate) / 86400000 + 1 )+((endMyDate-SbegMyDate) / 86400000 + 1 );
		}
		
		originInterestAmount = Math.round((parseFloat(issueAmount) * (parseFloat(compareRate)/100)*parseFloat(days))/bascDate);
		currform.elements['bigDecimal(originInterestAmount)'].value = Math.round(parseFloat(originInterestAmount));
		currform.elements['bigDecimal(allAmount)'].value = Math.round(parseFloat(originInterestAmount)+parseFloat(issueAmount));
		
	}
}
function getTotalAmount()
{
	var	currform	=	document.MainForm;
	var	issueAmount		=	replaceAll(currform.elements['bigDecimal(issueAmount)'].value,",","");
	var	originInterestAmount = replaceAll(currform.elements['bigDecimal(originInterestAmount)'].value,",","");
	//var day = new Day();
	if( 0 !=issueAmount  && 0!=originInterestAmount)
	{
		currform.elements['bigDecimal(allAmount)'].value =  addMoneyMask(Math.round(parseFloat(originInterestAmount)+parseFloat(issueAmount)));
		//return currform.allAmount.value;
	}
}
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
	if ("" == form.bankCode.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【銀行編號】不可空白!!";
    }
    if ("" == form.elements['bigDecimal(compareAmount)'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【比價金額】不可空白!!";
    }
    if ("" == form.elements['bigDecimal(compareRate)'].value )
    {
    	isValid = false;
		sError += "\n";
        sError += "【利率】不可空白!!";
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}

//-->
</script>
