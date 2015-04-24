<!--	APRA1401QScript.jsp
程式目的：APRA1401實體公債轉換登錄公債半年報表列印
程式代號：APRA1401
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
 	var cols = new Array("date(closeSdate)" , "date(closeEdate)" , "bankName_options" );
	var colNames = new Array("【日期起日】", "【日期迄日】" , "【清算銀行】");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
	}
    if (form.elements['date(closeEdate)'].value < form.elements['date(closeSdate)'].value)
    {
        alert("核結日期迄日不可小於核結日期起日!!");
        result = 1 ;
    }
		return (result < 0);
}

//-->
</script>
