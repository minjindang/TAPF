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
	form.debitType.value = "";
	form.debitName.value = "";
	form.budgetCode.value = "";
	form.remark.value = "";
	return false;
}
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
	if ("" == form.debitType.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�ŰȧO�j���i�ť�!!";
    }
    if ("" == form.debitName.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�ŰȧO�W�١j���i�ť�!!";
    }
    if ("" == form.budgetCode.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�п�� �i���ݹw��O�j!!";
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}
//-->
</script>
