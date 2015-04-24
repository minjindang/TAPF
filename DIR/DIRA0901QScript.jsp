<!--
程式目的：
程式代號：DIRA12
程式日期：0950317
程式作者：icefire
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
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
	if ("" == form.startAccountYear.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【年度(起)】不可空白!!";
        form.startAccountYear.focus();
        alert(sError);
        return isValid;
    }
    if ("" == form.endAccountYear.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【年度(迄)】不可空白!!";
        form.endAccountYear.focus();
        alert(sError);
        return isValid;
    }
	return isValid;
}

//-->
</script>
