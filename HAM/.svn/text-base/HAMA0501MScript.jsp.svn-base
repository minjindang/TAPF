<!-- HAMA0501MScript.jsp
程式目的：HAMA05法定分配比例資料維護
程式代號：HAMA05
程式日期：1001118
程式作者：Powen Hsueh
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">

function checkForm(form)
{
	var cols = new Array("nation","interest");
	var colNames = new Array("地方政府比例","利息比例");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("【" + colNames[result] + "】，未輸入!!");
		form.focus(cols[result]);
	}
	return result < 0;
}

function doBodyOnLoad(document)
{
	  //nothing
}
	

</script>
