<!--
程式目的：中央政府交換公債交換月報總表
程式代號：AIRC10
程式日期：0950308
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
function checkValue(form)
{
	var cols = new Array( "issueSerial" , "limitDate");
	var colNames = new Array("【公債代號】", "【年月】");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
	}
	return (result < 0);
}

//-->
</script>
