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
	form.debitType.value = "";
	form.debitName.value = "";
	form.budgetCode.value = "";
	form.remark.value = "";
	return false;
}
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
	if ("" == form.debitType.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【債務別】不可空白!!";
    }
    if ("" == form.debitName.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【債務別名稱】不可空白!!";
    }
    if ("" == form.budgetCode.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "請選擇 【所屬預算別】!!";
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}
//-->
</script>
