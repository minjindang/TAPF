<!--
程式目的：中央政府公債各年度公債付息數額明細表
程式代號：AIRB04
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
    if ("" != form.elements['repay_SDate'].value && 
        "" != form.elements['repay_EDate'].value)
    {
      if (form.elements['repay_SDate'].value>
              form.elements['repay_EDate'].value)
         {
           isValid = false;
		   sError += "\n";
           sError += "付息年度起 不可大於 迄!!";
         }
    }
    if ("" == form.elements['repay_SDate'].value )
    {
           isValid = false;
		   sError += "\n";
           sError += "付息年度起 不可空白!!";
    }
    if ("" == form.elements['repay_EDate'].value )
    {
           isValid = false;
		   sError += "\n";
           sError += "付息年度迄 不可空白!!";
    }
	if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}

//-->
</script>
