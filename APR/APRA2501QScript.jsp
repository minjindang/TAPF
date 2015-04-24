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
function getSelect(obj)
{
	if( obj.budgetCode.value!="" )
		obj.budgetName.value = obj.budgetCode.options[obj.budgetCode.selectedIndex].text;
	else
		obj.budgetName.value = "總表";	
	
}
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
    if ("" == form.elements['date(limitDate)'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【銷毀日期】不可空白!!";
        form.elements['date(limitDate)'].focus();
        alert(sError);
        return isValid;
    }
    if (!(CheckValidDate(form.elements['date(limitDate)'].value)))
    {
    	isValid = false;
    	form.elements['date(limitDate)'].select();
		return isValid;
    }
	return isValid;
}
//-->
</script>
