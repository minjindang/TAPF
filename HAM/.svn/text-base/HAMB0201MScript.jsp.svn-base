<!-- HAMB0201MScript.jsp
程式目的：HAMB02檢查是否有輸入值
程式代號：HAMB02
程式日期：0950222
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
  document.MainForm.pname.value = '財政部國庫署';
}
function getHiddenValues()
{
	var	currform	=	document.MainForm;
	var	taxYear		=	currform.taxYear.value;
	var	taxMonth	=	currform.taxMonth.value
	if( ""!=taxYear && ""!=taxMonth )
	{
		currform.action='HAMB0202';
		currform.submit();
	}
}
function checkValue(form)
{	
	if(form.taxMonth.value.length!= 5){
		alert("【分配年月】格式錯誤!");
		return false;
	}
	var cols = new Array( "taxYear" , "taxMonth" , "monNo" , "bankno" , "monKind" , "pname");
	var colNames = new Array("【記帳年度】", "【分配年月】" , "【批號】" , "【匯款行行號】" , "【種類】" , "【匯款人姓名】");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
	}
	return (result < 0);
}

//-->
</script>
