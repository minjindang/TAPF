<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<script language="javascript">

function doBodyOnLoad(document)
{
	<logic:present name="historyBack">
		window.history.back();
	</logic:present>
}


function clearValue(form)
{
	form.titlea.value = "";
	form.titleb.value = "";
	return false;
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
    }
    if ("" == form.kindName.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【類別名稱】不可空白!!";
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}


</script>