<!--
�{���ت��G�����F�����ŵo��ε���{�p��
�{���N���GAIRB10
�{������G0950317
�{���@�̡Gicefire
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
    if ("" == form.elements['Date(limitDate)'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�I�������i�ť�!!";
    }
    if (!CheckValidDate(form.elements['Date(limitDate)'].value)){
		form.elements['Date(limitDate)'].value = "";
		return false;
	}
	if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}

//-->
</script>
