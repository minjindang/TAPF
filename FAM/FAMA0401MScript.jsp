<!-- FAMA0601AScript.jsp
�{���ت��GFAMA06
�{���N���GFAMA06
�{������G0950222
�{���@�̡GEric.Chen
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
function clearValue(form)
{
	form.stockId.value = "";
	form.stockName.value = "";
	return false;
}
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
	if ("" == form.stockId.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�洫�Ъ��N���j���i�ť�!!";
    }
    if ("" == form.stockName.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�洫�Ъ��W�١j���i�ť�!!";
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}
//-->
</script>
