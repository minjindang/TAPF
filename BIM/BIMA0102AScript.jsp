<!-- BIMA0102AScript.jsp
程式目的：BIMA01
程式代號：BIMA01
程式日期：0950303
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
  //nothing
}
function getTotalAmount()
{
	var	currform	=	document.MainForm;
	var	ticketAmount		=	currform.ticketAmount.value;
	var	ticketCount 	=	currform.ticketCount.value
	
	if (ticketAmount != "" && ticketCount != "")
	{
		currform.elements['bigDecimal(totalAmount)'].value =ticketAmount*ticketCount;
	}
}
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
    if ("" == form.ticketAmount.value )
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
