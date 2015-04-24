<!--	GARA1701QScript.jsp
程式目的：GARA1701
程式代號：GARA1701
程式日期：0950316
程式作者：ERIC CHEN
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
	var cols = new Array("issueYear" , "amountUnit");
	var colNames = new Array("【發行年度】", "【金額單位】");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
	}
	if (isNaN(form.elements['issueYear'].value))
 	{
 		sError = "請輸入數字";
 		form.elements['issueYear'].value="";
 		form.elements['issueYear'].focus();
 		alert(sError);
 		return false;
 	}
	if ("0" == form.amountUnit.value)
    {
    	form.amountUnit.value = "1";
    }
   
	return (result < 0);
}

//-->
</script>
