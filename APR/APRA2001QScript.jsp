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
function doBodyOnLoad(document)
{
  //nothing
}
function getSelectDebt(obj)
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
    if ("" == form.debtName.value || 0 == form.debtName.value )
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
</script>
