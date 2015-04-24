<%@ page language="java" contentType="text/html;charset=Big5"%>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
  	var oNumberMask = new Mask("#,###", "number");
	var moneyCols = new Array("bigDecimal(srcMoney)","bigDecimal(founda)","bigDecimal(foundb)","bigDecimal(allMoney)");
	for(var i = 0 ; i < moneyCols.length ; i++)
	{
		oNumberMask.attach(document.MainForm.elements[moneyCols[i]]);
		document.MainForm.elements[moneyCols[i]].value = addMoneyMask(document.MainForm.elements[moneyCols[i]].value);
	}
}
function checkForm(form)
{
	var cols = new Array("allYear","allMonth","unitId",
		"bigDecimal(srcMoney)","bigDecimal(founda)",
		"bigDecimal(foundb)","bigDecimal(allMoney)");
	var colNames = new Array("記帳年度","分配年月","受分配單位代號",
			"受分配金額","歸扣墊借款",
			"代扣地方建設基金","本次撥付金額");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("【" + colNames[result] + "】，未輸入!!");
	}
	return result < 0;
}

function countTotal(form)
{
	var srcMoney = replaceAll(form.elements['bigDecimal(srcMoney)'].value,",","");
	var founda = replaceAll(form.elements['bigDecimal(founda)'].value,",","");
	var foundb = replaceAll(form.elements['bigDecimal(foundb)'].value,",","");
	var lastFound = replaceAll(form.elements['bigDecimal(lastFound)'].value,",","");
	var allMoney = allMoney-founda-foundb-lastFound;
	var nowFound = nowFound-founda-foundb-lastFound;
	if(allMoney<0)
	{
		alert("[歸扣墊借款]+[代扣地方建設基金] 不可大於 [受分配金額]");
		document.MainForm.elements['bigDecimal(allMoney)'].value = 0;
		//document.MainForm.elements['bigDecimal(nowFound)'].value = 0;
	}
	else
	{
		document.MainForm.elements['bigDecimal(allMoney)'].value = addMoneyMask(allMoney);
		//document.MainForm.elements['bigDecimal(nowFound)'].value = addMoneyMask(allMoney);
	}
}

function countFound(form)
{
	var lastFound = replaceAll(form.elements['bigDecimal(lastFound)'].value,",","");//上年度受分配金額
	var srcMoney = replaceAll(form.elements['bigDecimal(srcMoney)'].value,",","");//受分配金額
	var founda = replaceAll(form.elements['bigDecimal(founda)'].value,",","");//歸扣墊借款
	if(null == lastFound || "" == lastFound)
	{
		lastFound = 0;
		form.elements['bigDecimal(lastFound)'].value = 0;
	}else{
		if(lastFound > 0){
			var nowFound = srcMoney - lastFound - founda;
			form.elements['bigDecimal(nowFound)'].value = nowFound;//本年度受分配金額
			form.elements['bigDecimal(allMoney)'].value = srcMoney - founda;//本次撥付金額
		}else{
			form.elements['bigDecimal(nowFound)'].value = srcMoney - founda;//本年度受分配金額
			var allMoney = srcMoney - (lastFound*-1) - founda;
			form.elements['bigDecimal(allMoney)'].value = allMoney;//本次撥付金額
		}
	}
	var allMoney = replaceAll(form.elements['bigDecimal(allMoney)'].value,",","");//歸扣墊借款
	if(allMoney<0)
	{
		alert("[歸扣墊借款] 不可大於 [受分配金額]");
		document.MainForm.elements['bigDecimal(allMoney)'].value = 0;
		//document.MainForm.elements['bigDecimal(nowFound)'].value = 0;
	}
	else
	{
		document.MainForm.elements['bigDecimal(allMoney)'].value = addMoneyMask(allMoney);
		//document.MainForm.elements['bigDecimal(nowFound)'].value = addMoneyMask(allMoney);
	}
}
//-->
</script>
