<!-- DIMA0101MScript.jsp
�{���ت��GDIMA01
�{���N���GDIMA01
�{������G0950223
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
function countValue(form)
{
	if( 0 <= replaceAll(form.elements['bigDecimal(contractAmount)'].value,",","") )
	{
		form.elements['bigDecimal(enableborrow)'].value = (
		Number(replaceAll(form.elements['bigDecimal(contractAmount)'].value,",",""))  - 
		Number(replaceAll(form.elements['bigDecimal(borrowAmount)'].value,",","")));
		document.getElementById("enableborrowid").innerHTML =  addMoneyMask((
		Number(replaceAll(form.elements['bigDecimal(contractAmount)'].value,",",""))  - 
		Number(replaceAll(form.elements['bigDecimal(borrowAmount)'].value,",",""))));
	}	
	else
	{
		form.elements['bigDecimal(enableborrow)'].value = "";
		form.elements['bigDecimal(contractAmount)'].value = "";
		document.getElementById("enableborrowid").innerHTML = "";
	}
	return false;
}
function checkValue(form)
{
	var cols = new Array("bigDecimal(contractAmount)");
	var colNames = new Array("�i�ɴ��`�B�j");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "���i�ť�!!");
	}
	return result < 0;
}

//-->
</script>
