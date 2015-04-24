<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<bean:define id= 'issueDate' name='Dpma0101Form' property='date(issueDate)' type="java.lang.String"/>
<bean:define id= 'dueDate' name='Dpma0101Form' property='date(dueDate)' type="java.lang.String"/>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{	
	var capitalAmount = document.getElementsByName("capitalAmountPay");
	var interestAmount = document.getElementsByName("interestAmountPay");
	var totalAmount = document.getElementsByName("bigDecimal(totalAmount)");
}

function countTotal(num)
{
	var currform = document.MainForm;
	var capitalAmount = replaceAll(currform.elements['debtPlanDet['+num+'].capitalAmount'].value,",","");
	var interestAmount = replaceAll(currform.elements['debtPlanDet['+num+'].interestAmount'].value,",","");

	if(isNaN(parseFloat(capitalAmount)))
		capitalAmount = "0";
	if(isNaN(parseFloat(interestAmount)))
		interestAmount = "0";

	if( isValidAmount(capitalAmount) && isValidAmount(interestAmount) ){
		currform.elements['debtPlanDet['+num+'].totalCount'].value = addMoneyMask(parseFloat(capitalAmount)+parseFloat(interestAmount));
	}
	else{
		currform.elements['debtPlanDet['+num+'].totalCount'].value = 0;
	}
}
//回復沒有千分位才可做確認 否則會有 BeanUtil 的問題
function changeMoneyMark()
{
	var capitalAmount = document.getElementsByName("capitalAmountPay");
	var interestAmount = document.getElementsByName("interestAmountPay");
	for(i = 0 ; i < capitalAmount.length ; i++){
		capitalAmount[i].value = Number(replaceAll(capitalAmount[i].value,",","")); 
		interestAmount[i].value = Number(replaceAll(interestAmount[i].value,",",""));
	}
}
function changeInterestAmount(form)
{
	changeMoneyMark();
	form.action = "DPMA0101Calculate";
	form.submit() ;
}
//-->
</script>
