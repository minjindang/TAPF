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
    /*
    if ("" == form.startYear.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【發行年度】不可空白!!";
        form.startYear.focus();
        alert(sError);
        return isValid;
    }
    if ("" == form.endYear.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【發行年度】不可空白!!";
        form.endYear.focus();
        alert(sError);
        return isValid;
    }
    */
    if ("0" == form.amountUnit.value)
    {
    	form.amountUnit.value = "1";
    }
	return isValid;
}
//-->
</script>
