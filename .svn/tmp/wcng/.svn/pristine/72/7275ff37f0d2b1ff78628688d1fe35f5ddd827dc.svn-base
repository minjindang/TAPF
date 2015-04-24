<!-- DIMA0101AScript.jsp
程式目的：DIMA01
程式代號：DIMA01
程式日期：0950223
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">
function doBodyOnLoad(document)
{
  //document.MainForm.elements('bigDecimal(contractAmount)').value = "00000000";
}
//function getSelectValue(form)
//{	
//	obj = form.bankCode_options;
//	getBankRefId(form.bankCode.value);
//	if( obj.value!="" )
//		return obj.options[obj.selectedIndex].text;
//	else
//		return "";
//}
function checkValue(form)
{
	var cols = new Array("contractYear" , "bankCode", "bankName", "bigDecimal(contractAmount)");
	var colNames = new Array("【年度】", "【銀行編號】", "【銀行名稱】", "【借款總額】");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
	}
	return result < 0;
}

</script>
