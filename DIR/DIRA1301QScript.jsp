<!--
程式目的：年度各銀行貸款概況報表
程式代號：DIRA13
程式日期：0980303
程式作者：chris
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
    if ("" == form.elements['accountYear'].value ) 
    {
           isValid = false;
		   sError += "\n";
           sError += "年度不可空白!!";
    }
    
	if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}

//-->
</script>
