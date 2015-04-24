<!-- BIMA0201QScript.jsp
程式目的：BIMA02
程式代號：BIMA02
程式日期：0950301
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
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
	if ("" == form.qryIssueId.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "原始發行期不可空白!!";
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}

//-->
</script>
