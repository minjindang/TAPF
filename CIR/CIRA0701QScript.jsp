<!--	CIRA0701QScript.jsp
�{���ت��GCIRA0701
�{���N���GCIRA0701
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
		obj.baseUnitValue.value = obj.baseUnit.options[obj.baseUnit.selectedIndex].text;
	else
		obj.baseUnitValue.value = "";
}
function checkValue(form)
{
	var cols = new Array("startYear" ,  "endYear" , "baseUnit");
	var colNames = new Array("�i�~�װ_�j" , "�i�~�ר��j" , "�i���B���j");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "���i�ť�!!");
	}
	return (result < 0);
}

//-->
</script>
