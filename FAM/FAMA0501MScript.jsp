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
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
    if ("" !=form.elements['date(combinationDate)'].value && !(CheckValidDate(form.elements['date(combinationDate)'].value)))
    {
    	isValid = false;
    	return isValid;
		
    }
	if ("" == form.bankCode.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�Ȧ�N���j���i�ť�!!";
    }
    if ("" == form.bankName.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�Ȧ�W�١j���i�ť�!!";
    }
     if ("" == form.shortBankName.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�Ȧ�²�١j���i�ť�!!";
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}
//-->
</script>
