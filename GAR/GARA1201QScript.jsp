<!--	GARA1201QScript.jsp
�{���ت��GGARA1201
�{���N���GGARA1201
�{������G0950316
�{���@�̡GERIC CHEN
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
	var cols = new Array("issueYear" , "amountUnit");
	var colNames = new Array("�i�o��~�סj", "�i���B���j");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "���i�ť�!!");
	}
	if (!CheckValidDate(form.elements['date(createDate)'].value)){
		form.elements['date(createDate)'].value = "";
		return false;
	}
	if ("0" == form.amountUnit.value)
    {
    	form.amountUnit.value = "1";
    }
	return (result < 0);
}

//-->
</script>
