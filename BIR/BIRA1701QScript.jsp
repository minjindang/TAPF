<!-- BIRA1701AScript.jsp
程式目的：BIRA17檢查是否有輸入值
程式代號：BIRA17
程式日期：0950522
程式作者：Avery Yeh
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
    if ("" == form.elements["date(issueSdate)"].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【發行日期】不可空白!!";
        form.elements["date(issueSdate)"].focus();
        alert(sError);
        return isValid;
    }
    if ("" == form.elements["date(issueEdate)"].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【發行日期】不可空白!!";
        form.form.elements["date(issueEdate)"].focus();
        alert(sError);
        return isValid;
    }
    if ("0" == form.amountUnit.value )
    {
    	form.amountUnit.value = "1";
    }    
	return isValid;
	
}
//-->
</script>