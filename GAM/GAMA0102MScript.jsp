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
}
function changeValue(form)
{	
	form.action = "GAMA0102MLOAD";
	form.submit();
}
function changeAmount(form)
{
	form.action = "GAMA0102MCOUNT";
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
function checkValue(form)
{
 	var cols = new Array("budgetYear","budgetCodeDebt" , "debtCodeDebt", "bankCode" , "bigDecimal(compareAmount)" , "bigDecimal(compareRate)" , "bigDecimal(issueAmountDet)");
	var colNames = new Array("�i�w��~�סj","�i�w��O�j", "�i�ŰȧO�j", "�i�Ȧ�s���j" , "�i������B�j" ,  "�i��ЧQ�v�j" , "�i�o�Ъ��B�j");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "���i�ť�!!");
	}
	if("" == form.bankId.value && result < 0 )
    {
    	alert("�i�Ȧ�W�١j���i�ť�!");
    	result = 1;
    }
    if (form.elements['date(dueDate)'].value < form.elements['date(issueDate)'].value )
    {
        alert("�ɴڰ_�餣�i�j��ɴڨ���!!");
        result = 1;
    }
    if("" == form.elements['bigDecimal(originInterestAmount)'].value && result < 0)
    {
    	alert("�i�Q���j���i�ť�!");
    	 result = 1;
    }
    if("" == form.elements['bigDecimal(totalAmount)'].value && result < 0)
    {
    	alert("�i�����X�p�j���i�ť�!");
    	 result = 1;
    }
	return result < 0;
}

//-->
</script>
