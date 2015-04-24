<!-- HAMB0101QScript.jsp
程式目的：HAMB01檢查是否有輸入值
程式代號：HAMB01
程式日期：0950220
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

function checkValue(form)
{
	var cols = new Array( "allYear" , "allMonth");
	var colNames = new Array("【記帳年度】", "【分配年月】");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
	}
	return (result < 0);
}

//-->
</script>
