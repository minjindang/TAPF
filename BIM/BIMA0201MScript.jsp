<!-- BIMA0201AScript.jsp
程式目的：BIMA02
程式代號：BIMA02
程式日期：0950223
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ page import="gov.dnt.tame.util.DateUtil" %>
<%@ page import="java.util.Date" %>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
}
function checkValue(form)
{
	var isValid = true;
    var sError = "";
	if ("" == form.issueId.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "原始發行期別不可空白!!";
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}
function setDueIssueAmount(form){
	form.elements['bigDecimal(dueIssueAmount)'].value = addMoneyMask(
		Number(replaceAll(form.elements['bigDecimal(issueAmount)'].value,",",""))
		- Number(replaceAll(form.elements['bigDecimal(balanceCapitalAmount)'].value,",","")) );	
}
//-->
</script>
