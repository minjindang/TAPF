<!--	CIRA0201QScript.jsp
�{���ت��GCIRA0201�������ɴڤ�����p��
�{���N���GCIRA0201
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
function getSelectValue(obj)
{
	if( obj.baseUnit.value!="" )
		obj.baseUnitLabel.value = obj.baseUnit.options[obj.baseUnit.selectedIndex].text;
	else
		obj.baseUnitLabel.value = "";
}
function checkValue(form)
{
	var cols = new Array("issueSerial" , "baseUnit");
	var colNames = new Array("�i���O�j", "�i���B���j");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "���i�ť�!!");
	}
	return (result < 0);
}

//-->
</script>
