<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<script language="javascript">
function doBodyOnLoad(document)
{
	//do nothing
}

function checkForm(form)
{
	var cols = new Array("budgetCode" , "debtCode", "issueAmountx");
	var colNames = new Array("公債代號", "債務別", "發行額");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("【" + colNames[result] + "】，未輸入!!");
	}
	return result < 0;
}

function changeList(form)
{
	form.action = "AIMA0102MLIST" ;
	form.submit() ;
}
function total(form)
{
	issueAmount = <bean:write name='Aima0102MForm' property='issueAmount'/>
	totalIssueAmount = <%= request.getAttribute("totalIssueAmount") %> - <bean:write name='Aima0102MForm' property='issueAmountx'/>;
	
	issueAmountx = replaceAll(form.elements['BigDecimal(issueAmountx)'].value,",","");
	if( parseFloat(totalIssueAmount)+parseFloat(issueAmountx) <= issueAmount)
	{
		document.MainForm.elements['BigDecimal(issueAmountx)'].value = addMoneyMask(issueAmountx);
	}
	else
	{
		alert("總發行額大於發行金額，請重新輸入!");
		document.MainForm.elements['BigDecimal(issueAmountx)'].value = "0";
		return false;
	}
}
function checkAmount(form)
{
	issueRealAmount = <%= request.getAttribute("issueRealAmount") %>;
	totalRealAmount = <%= request.getAttribute("totalRealAmount") %> -  <bean:write name='Aima0102MForm' property='realAmount'/>;
	issueAmount = replaceAll(form.elements['BigDecimal(issueAmountx)'].value,",","");
	realAmount = replaceAll(form.elements['BigDecimal(realAmount)'].value,",","");
	//if( Number(issueAmount) < Number(realAmount))
	//{
		//alert("實收額大於發行金額，請重新輸入!");
		//document.MainForm.elements['BigDecimal(realAmount)'].value = "0";
		//return false;
	//}
	if( Number(realAmount) + Number(totalRealAmount) > Number(issueRealAmount)){
		alert("總實收額大於實收額，請重新輸入!");
		document.MainForm.elements['BigDecimal(realAmount)'].value = "0";
		return false;
	}
}
</script>