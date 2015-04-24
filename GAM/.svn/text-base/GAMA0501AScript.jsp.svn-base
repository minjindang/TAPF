<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<script language="javascript">
function doBodyOnLoad(document)
{
	//calculate(document.MainForm);如果沒按公式規定更新值,跑此會看不到更新後最新的資料
}

function checkForm(form)
{
	var cols = new Array("accountYear","budgetCode","debtCode","boundCode","inoutType");
	var colNames = new Array("年度","預算別","債務別","自償否","內外債別");
	for (var k = 0 ; k < cols.length ; k++){
		if (form.elements[cols[k]].value == ""){
			alert("【"+colNames[k]+"】未輸入!!");
			return false;
		}
	}
	if (isNaN(form.accountYear.value))
	{
		alert("請輸入數字");
		form.accountYear.value="";
		form.accountYear.focus();
		return false;
	}
	return true;
}

function calculate(form)
{
	var types = new Array("budget","audit","real","keep");
	for(var i = 0 ; i < types.length ; i++)
	{
		var cols = new Array("Bamount1","Pamount1","Ramount1","Uamount1","Bamount2","Pamount2","Ramount2","Uamount2");
		for(var j = 0 ; j < cols.length ; j++)
		{
			var amount = form.elements['bigDecimal('+types[i]+cols[j]+')'].value;
			amount = replaceAll(amount, "," , "" );
			if( isBlank( TrimAll( amount ) ) )	amount = String(0);
			form.elements['bigDecimal('+types[i]+cols[j]+')'].value = addMoneyMask( String( amount ) );
		}
	}

	form.elements['bigDecimal(auditBamount1)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realBamount1)'].value, "," , "" )) + Number(replaceAll(form.elements['bigDecimal(keepBamount1)'].value, "," , "" )))
	form.elements['bigDecimal(auditUamount1)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realUamount1)'].value, "," , "" )) + Number(replaceAll(form.elements['bigDecimal(keepUamount1)'].value, "," , "" )))
	form.elements['bigDecimal(auditPamount1)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realPamount1)'].value, "," , "" )) + Number(replaceAll(form.elements['bigDecimal(keepPamount1)'].value, "," , "" )))
	form.elements['bigDecimal(auditRamount1)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realRamount1)'].value, "," , "" )) + Number(replaceAll(form.elements['bigDecimal(keepRamount1)'].value, "," , "" )))
	form.elements['bigDecimal(auditBamount2)'].value =addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realBamount2)'].value, "," , "" )) + Number(replaceAll(form.elements['bigDecimal(keepBamount2)'].value, "," , "" )))
	form.elements['bigDecimal(auditUamount2)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realUamount2)'].value, "," , "" )) + Number(replaceAll(form.elements['bigDecimal(keepUamount2)'].value, "," , "" )))
	form.elements['bigDecimal(auditPamount2)'].value =addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realPamount2)'].value, "," , "" )) + Number(replaceAll(form.elements['bigDecimal(keepPamount2)'].value, "," , "" )))
	form.elements['bigDecimal(auditRamount2)'].value =addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realRamount2)'].value, "," , "" )) + Number(replaceAll(form.elements['bigDecimal(keepRamount2)'].value, "," , "" )))
	form.elements['bigDecimal(realBuamount1)'].value =addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realBamount1)'].value, "," , "" )) + Number(replaceAll(form.elements['bigDecimal(realUamount1)'].value, "," , "" )))
	form.elements['bigDecimal(realBuamount2)'].value =addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realBamount2)'].value, "," , "" )) + Number(replaceAll(form.elements['bigDecimal(realUamount2)'].value, "," , "" )))	
}
function change(form,key)
{
	if(form.accountYear.value != "" && form.budgetCode.value != "" && form.debtCode.value != "" && form.boundCode.value != "" && form.inoutType.value != ""){
		key = "GAMA0500"+key
		doAction(key);
	}
}
</script>