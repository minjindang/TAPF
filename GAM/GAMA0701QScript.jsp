<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<script language="javascript">
function doBodyOnLoad(document)
{
	
}
function checkForm(form)
{
	if (isNaN(form.qryAccountYear.value))
	{
		alert("�п�J�Ʀr");
		form.qryAccountYear.value="";
		form.qryAccountYear.focus();
		return false;
	}
}
</script>