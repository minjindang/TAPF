<!-- RAMA0101QScript.jsp
程式目的：RAMA01
程式代號：RAMA01
程式日期：1001011
程式作者：Powen Hsueh
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">

function doBodyOnLoad(document)
{

}

function checkForm(form)
{
	var cols = new Array("repayDateS","repayDateE");
	var colNames = new Array("到期日區間(起)","到期日區間(迄)");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("【" + colNames[result] + "】，未輸入!!");
		form.focus(cols[result]);
	}
	return result < 0;
}


</script>
