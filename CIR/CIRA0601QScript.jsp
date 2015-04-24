<!--	CIRA0601QScript.jsp
程式目的：CIRA0601
程式代號：CIRA0601
程式日期：0950316
程式作者：ERIC CHEN
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
function changeValue(form)
{
	getLabel(form);
	form.action = "CIRA06";
	form.submit();
}
function getSelectValue(obj)
{
	if( obj.baseUnit.value!="" )
		obj.baseUnitValue.value = obj.baseUnit.options[obj.baseUnit.selectedIndex].text;
	else
		obj.baseUnitValue.value = "";
}
function getLabel(obj)
{
	if( obj.debtCode.value!="" )
		obj.debtLabel.value = obj.debtCode.options[obj.debtCode.selectedIndex].text;
	else
		obj.debtLabel.value = "";
		
	if( obj.budgetCode.value!="" )
		obj.budgetLabel.value = obj.budgetCode.options[obj.budgetCode.selectedIndex].text;
	else
		obj.budgetLabel.value = "";	
}
function checkValue(form)
{
	var cols = new Array("status" ,  "date(baseDate)" , "baseUnit");
	var colNames = new Array("【償還狀態】" , "【利率基準日】" , "【金額單位】");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
	}
	 if (form.elements['date(endDate)'].value < form.elements['date(startDate)'].value)
    {
        alert("結束日期不可小於啟始日期!!");
        result = 1 ; 
    }
	return (result < 0);
}

//-->
</script>
