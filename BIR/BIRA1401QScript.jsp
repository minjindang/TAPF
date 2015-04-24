<!-- BIRA1001AScript.jsp
程式目的：BIRA17檢查是否有輸入值
程式代號：BIRA17
程式日期：0950529
程式作者：Avery Yeh
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">

function doBodyOnLoad(document)
{
  //nothing
}

function checkValue(form)
{
	var isValid = true;
	var sError = "";
	if (isNaN(form.elements['accountSYear'].value))
 	{
 		isValid = false;
 		sError = "請輸入數字";
 		form.elements['accountSYear'].value="";
 		form.elements['accountSYear'].focus();
 		alert(sError);
 		return isValid;
 	}

	if (isNaN(form.elements['accountEYear'].value))
 	{
 		isValid = false;
 		sError = "請輸入數字";
 		form.elements['accountEYear'].value="";
 		form.elements['accountEYear'].focus();
 		alert(sError);
 		return isValid;
 	}
	return isValid;
}

</script>