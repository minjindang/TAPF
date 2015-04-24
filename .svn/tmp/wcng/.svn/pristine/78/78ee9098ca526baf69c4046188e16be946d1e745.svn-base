<!-- CIMA0102AScript.jsp
程式目的：CIMA01
程式代號：CIMA01
程式日期：0950306
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
  document.getElementById("totalAmountid").innerHTML =  
  addMoneyMask(Number(replaceAll(document.forms[0].elements['bigDecimal(issueAmountDet)'].value,",","")) +  
  Number(replaceAll(document.forms[0].elements['bigDecimal(originInterestAmount)'].value,",",""))) ;
  document.forms[0].elements['bigDecimal(totalAmount)'].value =  
  Number(replaceAll(document.forms[0].elements['bigDecimal(issueAmountDet)'].value,",","")) +  
  Number(replaceAll(document.forms[0].elements['bigDecimal(originInterestAmount)'].value,",","")) ;
}
function changeValue(form)
{
	form.action = "CIMA0107";
	form.submit();
}
function changeAmount(form)
{
	form.action = "CIMA0102ACOUNT";
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
function compareValue(form)
{
	if("" != form.budgetYear.value && 0 != form.budgetCodeDebt.value && 0 != form.debtCodeDebt.value)
	{
		form.action = "CIMA0133";
		form.submit();
	}	
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
function moreThanPlan(form)
{
	var planAmount = Number(replaceAll(form.elements['bigDecimal(planAmount)'].value,",",""))
	var compare = Number(replaceAll(form.elements['bigDecimal(issueAmountDet)'].value,",",""))
	if(planAmount < compare && compare > 0)
	{
		return confirm("金額超過計劃,是否確定新增?");
	}
	else
	{
		return true;
	}
}
function checkValue(form)
{
	var compare = Number(replaceAll(form.elements['bigDecimal(issueAmountDet)'].value,",",""));
	var compared = Number(replaceAll(form.elements['bigDecimal(compareAmount)'].value,",",""));
	if(compare == 0)
	{
		var cols = new Array("bankCode" , "bigDecimal(compareAmount)" , "bigDecimal(compareRate)" , "bigDecimal(issueAmountDet)");
		var colNames = new Array("【銀行編號】","【比價金額】" ,  "【投標利率】" , "【得標金額】");
		if("" != form.budgetYear.value )
		{
			alert("【預算年度】不可有值");
			return false;
		}
		if(0 != form.budgetCodeDebt.value)
		{
			alert("【預算別】不可有值");
			return false;
		}
		if(0 != form.debtCodeDebt.value)
		{
			alert("【債務別】不可有值");
			return false;
		}
	}
	else
	{
		var cols = new Array("budgetYear","budgetCodeDebt" , "debtCodeDebt", "bankCode" , "bigDecimal(compareAmount)" , "bigDecimal(compareRate)" , "bigDecimal(issueAmountDet)");
		var colNames = new Array("【預算年度】","【預算別】", "【債務別】", "【銀行編號】","【比價金額】" ,  "【投標利率】" , "【得標金額】");
		if(0 == form.budgetCodeDebt.value)
		{
			alert("【預算別】不可空白");
			return false;
		}
		if(0 == form.debtCodeDebt.value)
		{
			alert("【債務別】不可空白");
			return false;
		}
	}
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
		return false;
	}
	if("" == form.bankId.value && form.bankId.value < 0 )
    {
    	alert("【銀行名稱】不可空白!");
    	result = false;
    }
    if (form.elements['date(dueDate)'].value < form.elements['date(issueDate)'].value )
    {
        alert("借款起日不可大於借款迄日!!");
        result = false;
    }
    if("" == form.elements['bigDecimal(originInterestAmount)'].value && form.elements['bigDecimal(originInterestAmount)'].value < 0 )
    {
    	alert("【利息】不可空白!");
    	result = false;
    }
    if("" == form.elements['bigDecimal(totalAmount)'].value && form.elements['bigDecimal(totalAmount)'].value < 0)
    {
    	alert("【本息合計】不可空白!");
    	 result = false;
    }
    if(compare > compared)
    {
    	alert("得標金額不可大於比價金額!");
    	return false;
    }
	return moreThanPlan(form);
}

//-->
</script>
