<!-- GARA1001QScript.jsp
�{���ت��GGARA1001Q�ˬd�O�_����J��
�{���N���GGARA10
�{������G0950518
�{���@�̡GAvery Yeh
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
  //nothing
}

function checkValue(form)
{
 	var isValid = true;
    var sError = "";
    if ("" == form.startYear.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�o��~�סj���i�ť�!!";
        form.startYear.focus();
        alert(sError);
        return isValid;
    }
    if ("" == form.endYear.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�o��~�סj���i�ť�!!";
        form.endYear.focus();
        alert(sError);
        return isValid;
    }
    if ("0" == form.amountUnit.value)
    {
    	form.amountUnit.value = "1";
    }
	return isValid;
}
//-->
</script>
