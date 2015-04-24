<!-- HAMB0301MScript.jsp
程式目的：HAMB11檢查是否有輸入值
程式代號：HAMB11
程式日期：1000922
程式作者：Powen Hsueh
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
	//add Money Mask
	//patterm(#,###) => 123,456,789
	//patterm($#,###.000) => $123,456,789.000
	var oNumberMask = new Mask("#,###", "number");
	var moneyCols = new Array("bigDecimal(nationTax)","bigDecimal(financial)","bigDecimal(intTax)","bigDecimal(totMon)");
	for(var i = 0 ; i < moneyCols.length ; i++)
	{
		oNumberMask.attach(document.MainForm.elements[moneyCols[i]]);
		document.MainForm.elements[moneyCols[i]].value = addMoneyMask(document.MainForm.elements[moneyCols[i]].value);
	}
	var oNumberMask1 = new Mask("#,##", "number");
	var moneyCols1 = new Array("bigDecimal(nationRate)", "bigDecimal(localRate)", "bigDecimal(intRate)");
	for(var i = 0 ; i < moneyCols1.length; i++)
	{
		oNumberMask.attach(document.MainForm.elements[moneyCols1[i]]);
		document.MainForm.elements[moneyCols1[i]].value = addMoneyMask(document.MainForm.elements[moneyCols1[i]].value);
	}
}
//試算
function checkValue(form)
{
	var cols = new Array( "taxYear" , "taxMonth" , "bigDecimal(nationTax)" , "bigDecimal(financial)" , "bigDecimal(intTax)" , "bigDecimal(totMon)");
	var colNames = new Array("【記帳年度】", "【分配年月】" , "【國稅收入】" , "【財源保障彌補金額】" , "【利息收入】" , "【預定撥付】");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
	}
	return (result < 0);
}
//分配確認
function checkValue1(form)
{
	var cols = new Array( "taxYear" , "taxMonth" , "bigDecimal(nationTax)" , "bigDecimal(financial)" , "bigDecimal(intTax)" , "bigDecimal(totMon)");
	var colNames = new Array("【記帳年度】", "【分配年月】" , "【國稅收入】" , "【財源保障彌補金額】" , "【利息收入】" , "【預定撥付】");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
	}
	if (result < 0){
		//if (!checkIsOk(form.taxYear.value+form.taxMonth.value)){
			return checkAlloted(form.taxYear.value+form.taxMonth.value);
		//}
		//	return false;	
	}
	return (result < 0);
}

function getHiddenValues()
{
	var	currform	=	document.MainForm;
	var	taxYear		=	currform.taxYear.value;
	var	taxMonth	=	currform.taxMonth.value
	if( ""!=taxYear && ""!=taxMonth )
	{
		currform.action='HAMB1103';
		currform.submit();
	}
}
//-->
</script>
