<!--	CPRA0301QScript.jsp
�{���ت��GCPRA0301
�{���N���GCPRA0301
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
function getSelectItem(form)
{
	if( form.issueId.value != "" && form.issueId.value != 0)
		form.issueSerial.value = form.issueId.options[form.issueId.selectedIndex].text;
	else
		form.issueSerial.value = "";
		
	form.action = "CPRA03";
	form.submit();	
}
function checkValue(form)
{
	var cols = new Array("issueId");
	var colNames = new Array("�i���O�j");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "���i�ť�!!");
	}
	return (result < 0);
}

//-->
</script>
