<!-- BIMA0201AScript.jsp
�{���ت��GBIMA02
�{���N���GBIMA02
�{������G0950223
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
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
//-->
</script>