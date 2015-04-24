<!-- CPMA0102AScript.jsp
程式目的：CPMA01
程式代號：CPMA01
程式日期：0950306
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">
function doBodyOnLoad(document)
{	
	var capitalAmount = document.getElementsByName("capitalAmountPay");
	var interestAmount = document.getElementsByName("interestAmountPay");
	var totalAmount = document.getElementsByName("bigDecimal(totalAmount)");
	for(i = 0 ; i < capitalAmount.length ; i++){
		totalAmount[i].value = Number(replaceAll(capitalAmount[i].value,",","")) 
		+ Number(replaceAll(interestAmount[i].value,",",""));
		totalAmount[i].value = addMoneyMask(totalAmount[i].value);
	}
}
function changeValue()
{	
	var capitalAmount = document.getElementsByName("capitalAmountPay");
	var interestAmount = document.getElementsByName("interestAmountPay");
	var totalAmount = document.getElementsByName("bigDecimal(totalAmount)");
	for(i = 0 ; i < capitalAmount.length ; i++){
		totalAmount[i].value = Number(replaceAll(capitalAmount[i].value,",","")) 
		+ Number(replaceAll(interestAmount[i].value,",",""));
		totalAmount[i].value = addMoneyMask(totalAmount[i].value);
	}
}
//回復沒有千分位才可做確認 否則會有 BeanUtil 的問題
function changeMoneyMark()
{
	var capitalAmount = document.getElementsByName("capitalAmountPay");
	var interestAmount = document.getElementsByName("interestAmountPay");
	for(i = 0 ; i < capitalAmount.length ; i++){
		capitalAmount[i].value = Number(replaceAll(capitalAmount[i].value,",","")) 
		interestAmount[i].value = Number(replaceAll(interestAmount[i].value,",",""));
	}
}
function checkValue(form)
{
	changeMoneyMark();
	var ischeck = document.getElementsByName("ischeck");
	var isok = false ;
	for(i = 0 ; i < ischeck.length ; i++){
		if( true == ischeck[i].checked)
		{
			isok = true ;
		}	
	}
	if(false == isok)
	{
		alert("無勾選償還資料!!");
	}
	return isok ;
}
function changeInterestAmount(form)
{
	changeMoneyMark();
	form.action = "CPMA0101Calculate";
	form.submit() ;
}
</script>
