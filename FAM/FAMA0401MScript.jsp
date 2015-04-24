<!-- FAMA0601AScript.jsp
程式目的：FAMA06
程式代號：FAMA06
程式日期：0950222
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
function clearValue(form)
{
	form.stockId.value = "";
	form.stockName.value = "";
	return false;
}
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
	if ("" == form.stockId.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【交換標的代號】不可空白!!";
    }
    if ("" == form.stockName.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【交換標的名稱】不可空白!!";
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}
//-->
</script>
