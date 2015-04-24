<!-- BIMA0102MScript.jsp
程式目的：BIMA01
程式代號：BIMA01
程式日期：0950302
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<bean:define id="ticketAmount" name="Bima0102Form" property="ticketAmount" type="java.math.BigDecimal"/>
<bean:define id="ticketCount" name="Bima0102Form" property="ticketCount" type="java.lang.Long"/>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
  	var ticketAmount = <%=ticketAmount%>;
	var ticketCount = <%=ticketCount%>;
	document.MainForm.elements['bigDecimal(totalAmount)'].value = addMoneyMask(ticketAmount*ticketCount);
	//document.MainForm.elements['bigDecimal(ticketAmount)'].selectedIndex = 1;
	document.MainForm.elements['bigDecimal(ticketAmount)'].value = ticketAmount;
}
function getTotalAmount()
{
	var	currform	=	document.MainForm;
	var	ticketAmount		=	currform.elements['bigDecimal(ticketAmount)'].value;
	var	ticketCount 	=	currform.ticketCount.value
	
	if (ticketAmount != "" && ticketCount != "")
	{
		currform.elements['bigDecimal(totalAmount)'].value = addMoneyMask(Number(replaceAll(ticketAmount,",",""))* Number(replaceAll(ticketCount,",","")));
	}
}
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
    if ("" == form.elements['bigDecimal(ticketAmount)'].value )
    {
    	isValid = false;
		sError += "\n";
        sError += "面額種類不可空白!!";
    }
     if ("" == form.ticketCount.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "張數不可空白!!";
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}
//-->
</script>