<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
  //nothing
  document.getElementById("totalAmountid").innerHTML =  
  addMoneyMask(Number(replaceAll(document.forms[0].elements['bigDecimal(issueAmountDet)'].value,",","")) +  
  Number(replaceAll(document.forms[0].elements['bigDecimal(originInterestAmount)'].value,",","")) );
  document.forms[0].elements['bigDecimal(totalAmount)'].value =  
  Number(replaceAll(document.forms[0].elements['bigDecimal(issueAmountDet)'].value,",","")) +  
  Number(replaceAll(document.forms[0].elements['bigDecimal(originInterestAmount)'].value,",","")) ;
  document.forms[0].budgetYear.value = replaceAll(document.forms[0].budgetYear.value," ","");
  if(" "== document.forms[0].budgetYear.value)
  {
  	 document.forms[0].budgetYear.value = "";
  }
}
function changeValue(form)
{	
	form.action = "GAMA0902MLOAD";
	form.submit();
}
function changeAmount(form)
{
	form.action = "GAMA0902MCOUNT";
	form.submit();
}
function getSelectValue(form)
{	
	obj = form.bankCode_options;
	getBankRefId(form.bankCode.value);
	if( obj.value!="" )
		return obj.options[obj.selectedIndex].text;
	else
		return "";
}
function rateLimit(form)
{
	var tempValue = 0;
    var tempCount = form.elements['bigDecimal(compareRate)'].value;
    var tempLength = tempCount.length;
    if( tempCount.indexOf(".")< 0 )
    {
        tempValue = 0 ;
    }	
    else
    {
        tempValue = tempCount.indexOf(".") - 3 ;
    }
    form.elements['bigDecimal(compareRate)'].value = tempCount.substring(tempValue,tempLength);
   
}
function checkCompareValue(form)
{
   var length = form.sumCapitalAmountFuture.length;
   var sumValue = 0;
   for(var i =0;i<length;i++)
   {
   		sumValue = Number(sumValue) + Number(replaceAll(document.forms[0].elements['sumCapitalAmountFuture'][i].value,",","")) ;
   }
   if(Number(replaceAll(form.elements['bigDecimal(issueAmountDet)'].value,",","")) != sumValue)
   {
   		alert("�w�p�٥����B����o�Ъ��B!");
   		return false;
   }
   else
   {
   		return true;
   }
}
function moreThanPlan(form)
{
	var planAmount = Number(replaceAll(form.elements['bigDecimal(planAmount)'].value,",",""))
	var compare = Number(replaceAll(form.elements['bigDecimal(issueAmountDet)'].value,",",""))
	//if(planAmount < compare && compare > 0)
	//{
		//return confirm("���B�W�L�p��,�O�_�T�w�s�W?");
	//}
	//else
	//{
		//return true;
	//}
}
function compareValue(form)
{
	if("" != form.budgetYear.value && 0 != form.budgetCodeDebt.value && 0 != form.debtCodeDebt.value )
	{
		form.action = "GAMA0903";
		form.submit();
	}	
}
function checkValue(form)
{
 	var compare = Number(replaceAll(form.elements['bigDecimal(issueAmountDet)'].value,",",""));
 	var compared = Number(replaceAll(form.elements['bigDecimal(compareAmount)'].value,",",""));
	if(compare == 0)
	{
		var cols = new Array("bankCode" , "bigDecimal(compareAmount)" , "bigDecimal(compareRate)" , "bigDecimal(issueAmountDet)");
		var colNames = new Array("�i�Ȧ�s���j","�i������B�j" ,  "�i��ЧQ�v�j" , "�i�o�Ъ��B�j");
		if("" != form.budgetYear.value )
		{
			alert("�i�w��~�סj���i����");
			return false;
		}
		if(0 != form.budgetCodeDebt.value)
		{
			alert("�i�w��O�j���i����");
			return false;
		}
		if(0 != form.debtCodeDebt.value)
		{
			alert("�i�ŰȧO�j���i����");
			return false;
		}
	}
	else
	{
		var cols = new Array("budgetYear","budgetCodeDebt" , "debtCodeDebt", "bankCode" , "bigDecimal(compareAmount)" , "bigDecimal(compareRate)" , "bigDecimal(issueAmountDet)");
		var colNames = new Array("�i�w��~�סj","�i�w��O�j", "�i�ŰȧO�j", "�i�Ȧ�s���j","�i������B�j" ,  "�i��ЧQ�v�j" , "�i�o�Ъ��B�j");
		if(0 == form.budgetCodeDebt.value)
		{
			alert("�i�w��O�j���i�ť�");
			return false;
		}
		if(0 == form.debtCodeDebt.value)
		{
			alert("�i�ŰȧO�j���i�ť�");
			return false;
		}
	}
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "���i�ť�!!");
		return false;
	}
	if("" == form.bankId.value && result < 0 )
    {
    	alert("�i�Ȧ�W�١j���i�ť�!");
    	return false;
    }
    if (form.elements['date(dueDate)'].value < form.elements['date(issueDate)'].value )
    {
        alert("�ɴڰ_�餣�i�j��ɴڨ���!!");
        return false;
    }
    if("" == form.elements['bigDecimal(originInterestAmount)'].value && result < 0)
    {
    	alert("�i�Q���j���i�ť�!");
    	return false;
    }
    if("" == form.elements['bigDecimal(totalAmount)'].value && result < 0)
    {
    	alert("�i�����X�p�j���i�ť�!");
    	return false;
    }
    //if(compare > compared)
    //{
    	//alert("�o�Ъ��B���i�j�������B!");
    	//return false;
    //}
	return moreThanPlan(form);
}
function checkRate(form)
{
	var rate = Number(form.elements['bigDecimal(compareRate)'].value) ;
	var compareRate = document.getElementsByName("commitFirstRate");

	if(rate != Number(compareRate[0].value))
	{
		alert("�i�Q���j���~!");
		return false;
	}
	return true;
}
//-->
</script>
