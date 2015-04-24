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
function getDebtName(obj)
{
	if( obj.issueId.value!="" )
		obj.debtName.value = obj.issueId.options[obj.issueId.selectedIndex].text;
	else
		obj.debtName.value = "";
}
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
    if ("" == form.issueId.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【公債名稱】不可空白!!";
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}
function checkForm(form)
{
	var cols = new Array("issueId");
	var colNames = new Array("公債名稱");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "，未輸入!!");
	}
	return result < 0;
}

//-->
</script>
