<!--	GARA3501QScript.jsp
�{���ت��GGARA3501
�{���N���GGARA3501
�{������G0950611
�{���@�̡GLeo Lee
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
	if( obj.amountUnit_options.value!="" )
		obj.amountUnitLabel.value = obj.amountUnit_options.options[obj.amountUnit_options.selectedIndex].text;
	else
		obj.amountUnitLabel.value = "";
}
function checkValue(form)
{

	var cols = new Array("accountYear");
	var colNames = new Array("�i�~�סj");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "���i�ť�!!");
	}
	return (result < 0);
	
}

//-->
</script>
