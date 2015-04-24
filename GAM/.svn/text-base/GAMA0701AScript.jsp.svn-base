<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<script language="javascript">
function doBodyOnLoad(document)
{
	
}
function checkForm(form)
{
	var cols = new Array("accountYear" );
	var colNames = new Array("【年度】");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
		return false;
	}
	if (isNaN(form.accountYear.value))
	{
		alert("請輸入數字");
		form.accountYear.value="";
		form.accountYear.focus();
		return false;
	}
}
</script>