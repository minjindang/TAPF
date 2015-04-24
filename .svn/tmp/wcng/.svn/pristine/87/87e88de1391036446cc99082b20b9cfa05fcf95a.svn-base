<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<script language="javascript">

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

function doBodyOnLoad(document)
{

}
function total(form)
{
	issueAmount = <bean:write name='Aima0202MForm' property='issueAmount'/>
	totalIssueAmount = <%= request.getAttribute("totalIssueAmount") %>- <bean:write name='Aima0202MForm' property='issueAmountx'/>;;
	issueAmountx = replaceAll(form.elements['BigDecimal(issueAmountx)'].value,",","");
	if( Number(issueAmountx) + Number(totalIssueAmount) <= issueAmount)
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
	totalRealAmount = <%= request.getAttribute("totalRealAmount") %> -  <bean:write name='Aima0202MForm' property='realAmount'/>;
	issueAmount = Number(replaceAll(form.elements['BigDecimal(issueAmountx)'].value,",",""));
	realAmount = Number(replaceAll(form.elements['BigDecimal(realAmount)'].value,",",""));	
	
	if( Number(realAmount) + Number(totalRealAmount) > Number(issueRealAmount)){
		alert("總實收額大於實收額，請重新輸入!");
		document.MainForm.elements['BigDecimal(realAmount)'].value = "0";
		return false;
	}
}
</script>