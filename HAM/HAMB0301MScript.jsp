<!-- HAMB0301MScript.jsp
�{���ت��GHAMB03�ˬd�O�_����J��
�{���N���GHAMB03
�{������G0950221
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
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
	var colNames = new Array("�i�O�b�~�סj", "�i���t�~��j" , "�i��|���J�j" , "�i�a�覬�J�j" , "�i�Q�����J�j" , "�i�w�w���I�j");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "���i�ť�!!");
	}
	return (result < 0);
}

function checkValue1(form)
{
	var cols = new Array( "taxYear" , "taxMonth" , "bigDecimal(nationTax)" , "bigDecimal(localTax)" , "bigDecimal(intTax)" , "bigDecimal(totMon)");
	var colNames = new Array("�i�O�b�~�סj", "�i���t�~��j" , "�i��|���J�j" , "�i�a�覬�J�j" , "�i�Q�����J�j" , "�i�w�w���I�j");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "���i�ť�!!");
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