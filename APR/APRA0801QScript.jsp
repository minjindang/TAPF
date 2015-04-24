<!--	APRA0801QScript.jsp
程式目的：APRA08中央政府登錄公債還本付息核結數額表
程式代號：APRA08
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
function checkValue(form)
{
	var cols = new Array( "date(closeSdate)","date(closeEdate)");
	var colNames = new Array("【啟始日期】","【結束日期】");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");	
	}
	if (form.elements['date(closeEdate)'].value < form.elements['date(closeSdate)'].value)
    {
        alert("結束日期不可小於啟始日期!!");
        result = 1;
    }
	return (result < 0);
}

//-->
</script>
