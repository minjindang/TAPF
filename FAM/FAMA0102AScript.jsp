<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<script language="javascript">

function doBodyOnLoad(document)
{
	<logic:present name="historyBack">
		window.history.back();
	</logic:present>
}


function clearValue(form)
{
	form.codeNo.value = "";
	form.codeName.value = "";
	return false;
}
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
	if ("" == form.codeNo.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【代碼】不可空白!!";
        form.codeNo.focus();
        alert(sError);
		return isValid;
    }
    if ("" == form.codeName.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【代碼名稱】不可空白!!";
        form.codeName.focus();
        alert(sError);
		return isValid;
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}


</script>