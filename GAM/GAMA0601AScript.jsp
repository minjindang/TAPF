<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<script language="javascript">
function doBodyOnLoad(document)
{
	
}
function checkForm(form)
{
	var cols = new Array("issueId_options");
	var colNames = new Array("期別");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("【" + colNames[result] + "】，未輸入!!");
		form.focus(cols[result]);
	}
	return result < 0;
}
</script>