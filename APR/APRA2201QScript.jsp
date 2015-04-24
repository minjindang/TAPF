<!-- APRA2201AScript.jsp
程式目的：APRA22檢查是否有輸入值
程式代號：APRA22
程式日期：0950404
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
    if ("" == form.killYear.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【年度】不可空白!!";
        form.killYear.focus();
        alert(sError);
        return isValid;
    }
    if (form.killYear.value.length <3)
    {
    	isValid = false;
		sError += "\n";
        sError += "【年度】格式錯誤!!";
        form.killYear.select();
        alert(sError);
        return isValid;
    }
    return isValid;
}
/*function checkForm(form)
{
	var cols = new Array("issueId");
	var colNames = new Array("公債名稱");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "，未輸入!!");
	}
	return result < 0;
}*/

//-->
</script>
