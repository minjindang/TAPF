<!-- APRA1501AScript.jsp
程式目的：APRA15檢查是否有輸入值
程式代號：APRA15
程式日期：0950221
程式作者：Andrew Sung
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
    if ("" == form.elements['date(repaySdate)'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【應還本付息日期起日】不可空白!!";
        form.elements['date(repaySdate)'].focus();
        alert(sError);
        return isValid;
    }
     if ("" == form.elements['date(repayEdate)'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【應還本付息日期迄日】不可空白!!";
        form.elements['date(repayEdate)'].focus();
        alert(sError);
        return isValid;
    }
    if (!(CheckValidDate(form.elements['date(repaySdate)'].value)))
    {
    	isValid = false;
    	form.elements['date(repaySdate)'].select();
		return isValid;
    }
     if (!(CheckValidDate(form.elements['date(repayEdate)'].value)))
    {
    	isValid = false;
    	form.elements['date(repayEdate)'].select();
		return isValid;
    }
	return isValid;
}
//-->
</script>
