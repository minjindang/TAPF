<!-- DIMA0101MScript.jsp
程式目的：DIMA01
程式代號：DIMA01
程式日期：0950223
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
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
	var colNames = new Array("【借款總額】");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
	}
	return result < 0;
}

//-->
</script>
