<!-- HAMB0701MScript.jsp
程式目的：HAMB07檢查是否有輸入值
程式代號：HAMB07
程式日期：0950222
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
function getSelectValue(obj)
{
	if( obj.value!="" )
		return obj.options[obj.selectedIndex].text;
	else
		return "";
}
function checkValue(form)
{
 	var cols = new Array( "qryallYear");
	var colNames = new Array("【記帳年度】" );
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
	}
	return (result < 0);
}

//-->
</script>
