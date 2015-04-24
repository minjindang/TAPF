<!--	APRA1101QScript.jsp
程式目的：APRA1101中央政府登錄公債還本付息結算表列印
程式代號：APRA11
程式日期：0950316
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">

function doBodyOnLoad(document)
{
  //nothing
}
function getSelect(obj)
{		
	if( obj.bankId.value!="" )
		obj.bankName.value = obj.bankId.options[obj.bankId.selectedIndex].text;
	else
		obj.bankName.value = "";	
}
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
    if("" == form.elements['bankId'].value)
	{
		isValid = false;
		sError += "\n";
        sError += "【銀行名稱】不可空白!!";
	}
    if ("" == form.elements['date(closeSdate)'].value ) 
    {
           isValid = false;
		   sError += "\n";
           sError += "【統計截止日期起】不可空白!!";
    }
    if ("" == form.elements['date(closeEdate)'].value ) 
    {
           isValid = false;
		   sError += "\n";
           sError += "【統計截止日期迄】不可空白!!";
    }
    if (!(CheckValidDate(form.elements['date(closeSdate)'].value)))
    {
    	return false;
    }
    if (!(CheckValidDate(form.elements['date(closeEdate)'].value)))
    {
    	return false;
    }
	if (false == isValid)
    {
    	alert(sError);
    }
	return isValid;
}

</script>
