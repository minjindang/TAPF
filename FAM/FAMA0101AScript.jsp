<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<script language="javascript">

function doBodyOnLoad(document)
{
	<logic:present name="historyBack">
		window.history.back();
	</logic:present>
}
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
	if ("" == form.kindNo.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【類別代碼】不可空白!!";
        form.kindNo.focus();
        alert(sError);
		return isValid;
    }
    if ("" == form.kindName.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【類別名稱】不可空白!!";
        form.kindName.focus();
        alert(sError);
		return isValid;
    }
  	return isValid;
}


</script>