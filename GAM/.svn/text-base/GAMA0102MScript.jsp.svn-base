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
	var colNames = new Array("【預算年度】","【預算別】", "【債務別】", "【銀行編號】" , "【比價金額】" ,  "【投標利率】" , "【得標金額】");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
	}
	if("" == form.bankId.value && result < 0 )
    {
    	alert("【銀行名稱】不可空白!");
    	result = 1;
    }
    if (form.elements['date(dueDate)'].value < form.elements['date(issueDate)'].value )
    {
        alert("借款起日不可大於借款迄日!!");
        result = 1;
    }
    if("" == form.elements['bigDecimal(originInterestAmount)'].value && result < 0)
    {
    	alert("【利息】不可空白!");
    	 result = 1;
    }
    if("" == form.elements['bigDecimal(totalAmount)'].value && result < 0)
    {
    	alert("【本息合計】不可空白!");
    	 result = 1;
    }
	return result < 0;
}

//-->
</script>
