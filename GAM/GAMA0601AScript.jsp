<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<script language="javascript">
function doBodyOnLoad(document)
{
	
}
function checkForm(form)
{
	var cols = new Array("issueId_options");
	var colNames = new Array("���O");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("�i" + colNames[result] + "�j�A����J!!");
		form.focus(cols[result]);
	}
	return result < 0;
}
</script>