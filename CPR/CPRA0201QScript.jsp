<!--	CPRA0201QScript.jsp
�{���ت��GCPRA0201
�{���N���GCPRA0201
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
	if( obj.bankId.options.value!="" )
		obj.bankName.value = obj.bankId.options[obj.bankId.options.selectedIndex].text;
	else
		obj.bankName.value = "";
}
function checkValue(form)
{

	var result = true
	var error = "";
	if(form.issueId.value == ""){
		error = "�i���O�j���i�ť�!!\n" 
		result = false
	}
	if(form.bankId.value == ""){
	
		error = error + "�i�Ȧ�O�j���i�ť�!!"
		result = false
	}
	if(!result)
	{
		alert(error);
	}
	return result;
}

//-->
</script>
