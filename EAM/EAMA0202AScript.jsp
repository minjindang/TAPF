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
	form.codeNo.value = "";
	form.codeName.value = "";
	return false;
}
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
    if ("" == form.kindCode.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i���O�N�X�j���i�ť�!!";
    }
	if ("" == form.codeNo.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�N�X�j���i�ť�!!";
    }
    if ("" == form.codeName.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�N�X�W�١j���i�ť�!!";
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}


</script>