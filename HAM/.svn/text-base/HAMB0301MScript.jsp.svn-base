<!-- HAMB0301MScript.jsp
程式目的：HAMB03檢查是否有輸入值
程式代號：HAMB03
程式日期：0950221
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
	//add Money Mask
	//patterm(#,###) => 123,456,789
	//patterm($#,###.000) => $123,456,789.000
	var oNumberMask = new Mask("#,###", "number");
	var moneyCols = new Array("bigDecimal(nationTax)","bigDecimal(localTax)","bigDecimal(intTax)","bigDecimal(totMon)");
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

function checkValue(form)
{
	var cols = new Array( "taxYear" , "taxMonth" , "bigDecimal(nationTax)" , "bigDecimal(localTax)" , "bigDecimal(intTax)" , "bigDecimal(totMon)");
	var colNames = new Array("【記帳年度】", "【分配年月】" , "【國稅收入】" , "【地方收入】" , "【利息收入】" , "【預定撥付】");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
	}
	return (result < 0);
}

function checkValue1(form)
{
	var cols = new Array( "taxYear" , "taxMonth" , "bigDecimal(nationTax)" , "bigDecimal(localTax)" , "bigDecimal(intTax)" , "bigDecimal(totMon)");
	var colNames = new Array("【記帳年度】", "【分配年月】" , "【國稅收入】" , "【地方收入】" , "【利息收入】" , "【預定撥付】");
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
		currform.action='HAMB0303';
		currform.submit();
	}
}
//-->
</script>
