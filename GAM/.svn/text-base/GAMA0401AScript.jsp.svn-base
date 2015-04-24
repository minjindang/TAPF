<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<script language="javascript">
function doBodyOnLoad(document)
{
	
}

function getTotal(form)
{
	var budgetAmount = 0;
	if( form.elements['budgetYn'].checked )
	{
		budgetAmount = form.elements['bigDecimal(budgetAmount)'].value;
		budgetAmount = replaceAll(budgetAmount, "," , "" );
		budgetAmount = Number(budgetAmount);
	}

	var auditAmount = 0;
	if( form.elements['auditYn'].checked )
	{
		auditAmount = form.elements['bigDecimal(auditAmount)'].value;
		auditAmount = replaceAll(auditAmount, "," , "" );
		auditAmount = Number(auditAmount);
	}

	var realAmount = 0;
	if( form.elements['realYn'].checked )
	{
		realAmount = form.elements['bigDecimal(realAmount)'].value;
		realAmount = replaceAll(realAmount, "," , "" );
		realAmount = Number(realAmount);
	}

	var keepAmount = 0;
	if( form.elements['keepYn'].checked )
	{
		keepAmount = form.elements['bigDecimal(keepAmount)'].value;
		keepAmount = replaceAll(keepAmount, "," , "" );
		keepAmount = Number(keepAmount);
	}

	var total = document.getElementById('total');
	if( total!=null )
		total.innerHTML = addMoneyMask( String( budgetAmount + auditAmount + realAmount + keepAmount) );
}

function checkForm(form)
{
	var cols = new Array("accountYear","budgetCode_options","debtCode_options","dataType_options");
	var colNames = new Array("年度","預算別","債務別","類別");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("【" + colNames[result] + "】，未輸入!!");
		form.focus(cols[result]);
	}
	return result < 0;
}

function calculate(form)
{
	var types = new Array("budget","audit","real","keep");
	for(var i = 0 ; i < types.length ; i++)
	{
		var amount = form.elements['bigDecimal('+types[i]+'Amount)'].value;
		amount = replaceAll(amount, "," , "" );
		if( isBlank( TrimAll( amount ) ) )	amount = String(0);

		var damount = form.elements['bigDecimal('+types[i]+'Damount)'].value;
		damount = replaceAll(damount, "," , "" );
		if( isBlank( TrimAll( damount ) ) )	damount = String(0);

		form.elements['bigDecimal('+types[i]+'Amount)'].value = addMoneyMask( String( amount ) );
		form.elements['bigDecimal('+types[i]+'Damount)'].value = addMoneyMask( String( damount ) );
		form.elements['bigDecimal('+types[i]+'Uamount)'].value = addMoneyMask( String( amount - damount ) );
	}
	form.elements['bigDecimal(auditAmount)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realAmount)'].value, "," , "" )) + Number(replaceAll(form.elements['bigDecimal(keepAmount)'].value, "," , "" )))
	form.elements['bigDecimal(auditDamount)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realDamount)'].value, "," , "" )) + Number(replaceAll(form.elements['bigDecimal(keepDamount)'].value, "," , "" )))
	form.elements['bigDecimal(auditUamount)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realUamount)'].value, "," , "" )) + Number(replaceAll(form.elements['bigDecimal(keepUamount)'].value, "," , "" )))

}


function calculate2(form)
{
	var types = new Array("budget","audit","real","keep");
	for(var i = 0 ; i < types.length ; i++)
	{
		var uamount = form.elements['bigDecimal('+types[i]+'Uamount)'].value;
		uamount = replaceAll(uamount, "," , "" );
		if( isBlank( TrimAll( uamount ) ) )	uamount = String(0);

		var damount = form.elements['bigDecimal('+types[i]+'Damount)'].value;
		damount = replaceAll(damount, "," , "" );
		if( isBlank( TrimAll( damount ) ) )	damount = String(0);

		form.elements['bigDecimal('+types[i]+'Amount)'].value = addMoneyMask( String( uamount -  damount) );
		form.elements['bigDecimal('+types[i]+'Damount)'].value = addMoneyMask( String( damount ) );
		form.elements['bigDecimal('+types[i]+'Uamount)'].value = addMoneyMask( String( uamount ) );
	}
	form.elements['bigDecimal(auditAmount)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realAmount)'].value, "," , "" )) + Number(replaceAll(form.elements['bigDecimal(keepAmount)'].value, "," , "" )))
	form.elements['bigDecimal(auditDamount)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realDamount)'].value, "," , "" )) + Number(replaceAll(form.elements['bigDecimal(keepDamount)'].value, "," , "" )))
	form.elements['bigDecimal(auditUamount)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realUamount)'].value, "," , "" )) + Number(replaceAll(form.elements['bigDecimal(keepUamount)'].value, "," , "" )))

}
function checkBudget(form)
{
	if(form.budgetYn.checked == true ){
		form.auditYn.checked =false;
		form.realYn.checked =false;
	}
}
function checkAudit(form)
{
	if(form.auditYn.checked == true ){
		form.budgetYn.checked =false;
		form.realYn.checked =false;
	}
}
function checkReal(form)
{
	if(form.auditYn.checked == true ){
		form.budgetYn.checked =false;
		form.auditYn.checked =false;
	}
}


</script>