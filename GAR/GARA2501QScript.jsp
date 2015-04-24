<!--	GARA1201QScript.jsp
程式目的：GARA1201
程式代號：GARA1201
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
function getSelectValue(obj)
{
	if( obj.amountUnit.value!="" )
		obj.amountUnitLabel.value = obj.amountUnit.options[obj.amountUnit.selectedIndex].text;
	else
		obj.amountUnitLabel.value = "";
}
function checkValue(form)
{
	var cols = new Array("accountSyear1" , "accountEyear1" , "accountSyear2" , "accountEyear2" , "accountSyear3" , "accountEyear3" , "accountSyear4" , "accountEyear4" , "accountSyear5" , "accountEyear5", "amountUnit");
	var colNames = new Array("【發行年度區間一(起)】","【發行年度區間一(訖)】","【發行年度區間二(起)】","【發行年度區間二(訖)】","【發行年度區間三(起)】","【發行年度區間三(訖)】","【發行年度區間四(起)】","【發行年度區間四(訖)】","【發行年度區間五(起)】","【發行年度區間五(訖)】", "【金額單位】");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
	}
	return (result < 0);
}

//-->
</script>
