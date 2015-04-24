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
<script language="Javascript" src="/tapf/assets/scripts/DateUtil.js"></script>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
  //nothing
}
function getSelectValue(obj)
{
	if( obj.bankId.value!="" )
		obj.bankName.value = obj.bankId.options[obj.bankId.selectedIndex].text;
	else
		obj.bankName.value = "";
}
function checkValue(form)
{
	var cols = new Array("date(closeDate)","bankId");
	var colNames = new Array("【截止日期】","【清算銀行】");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
	}
	if (!(CheckValidDate(form.elements['date(closeDate)'].value)))
    {
    	isValid = false;
    	return isValid;
    }
	return (result < 0);	
}

//-->
</script>
