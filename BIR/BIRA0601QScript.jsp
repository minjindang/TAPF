<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<script language="javascript">

function doBodyOnLoad(document)
{
		//do nothing
}

function checkValue(form)
{
	var vlen = form.elements['accountEYear'].value;
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
	return true;
}

</script>