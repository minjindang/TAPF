<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<script language="javascript">

function doBodyOnLoad(document)
{
		//do nothing
}


function checkForm(form)
{
	if(form.issueMainId.value == ""){
		alert("�i�п�ܤ��ŦW�١j");
		return false;
	}
	return true;
}
</script>