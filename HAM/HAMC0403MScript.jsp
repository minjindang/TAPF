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
	var colNames = new Array("�O�b�~��","���t�~��","�����t���N��",
			"�����t���B","�k���ԭɴ�",
			"�N���a��س]���","�������I���B");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("�i" + colNames[result] + "�j�A����J!!");
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
		alert("[�k���ԭɴ�]+[�N���a��س]���] ���i�j�� [�����t���B]");
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
	var lastFound = replaceAll(form.elements['bigDecimal(lastFound)'].value,",","");//�W�~�ר����t���B
	var srcMoney = replaceAll(form.elements['bigDecimal(srcMoney)'].value,",","");//�����t���B
	var founda = replaceAll(form.elements['bigDecimal(founda)'].value,",","");//�k���ԭɴ�
	if(null == lastFound || "" == lastFound)
	{
		lastFound = 0;
		form.elements['bigDecimal(lastFound)'].value = 0;
	}else{
		if(lastFound > 0){
			var nowFound = srcMoney - lastFound - founda;
			form.elements['bigDecimal(nowFound)'].value = nowFound;//���~�ר����t���B
			form.elements['bigDecimal(allMoney)'].value = srcMoney - founda;//�������I���B
		}else{
			form.elements['bigDecimal(nowFound)'].value = srcMoney - founda;//���~�ר����t���B
			var allMoney = srcMoney - (lastFound*-1) - founda;
			form.elements['bigDecimal(allMoney)'].value = allMoney;//�������I���B
		}
	}
	var allMoney = replaceAll(form.elements['bigDecimal(allMoney)'].value,",","");//�k���ԭɴ�
	if(allMoney<0)
	{
		alert("[�k���ԭɴ�] ���i�j�� [�����t���B]");
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
