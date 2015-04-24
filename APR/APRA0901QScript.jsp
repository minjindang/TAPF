<!--	APRA0901QScript.jsp
程式目的：APRA09中央政府登錄公債核結統計表列印
程式代號：APRA09
程式日期：0950331
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
  	var isValid = true;
    var sError = "";
    if ("" == form.elements['debtName'].value ) 
    {
           isValid = false;
		   sError += "\n";
           sError += "【公債名稱】不可空白!!";
    }
    if ("" == form.elements['date(closeDate)'].value ) 
    {
           isValid = false;
		   sError += "\n";
           sError += "【統計截止日期】不可空白!!";
    }
    if (!(CheckValidDate(form.elements['date(closeDate)'].value)))
    {
    	return false;
    }
	if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}

//-->
</script>
