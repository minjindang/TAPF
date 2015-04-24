<!--
程式目的：年度付息明細表(償債基金)
程式代號：AIRB09
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
	if ("" == form.elements['repaydate'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "付息到期年度不可空白!!";
    }
    
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}

//-->
</script>
