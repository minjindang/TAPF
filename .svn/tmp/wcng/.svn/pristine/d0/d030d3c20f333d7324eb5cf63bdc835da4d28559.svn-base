<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<script language="javascript">
function doBodyOnLoad(document)
{

}
function total(form)
{
	issueAmount = <bean:write name='Aima0202MForm' property='issueAmount'/>
	totalIssueAmount = <%= request.getAttribute("totalIssueAmount") %>;
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
	totalRealAmount = <%= request.getAttribute("totalRealAmount") %>;
	issueAmount = Number(replaceAll(form.elements['BigDecimal(issueAmountx)'].value,",",""));
	realAmount = Number(replaceAll(form.elements['BigDecimal(realAmount)'].value,",",""));
	if( Number(realAmount) + Number(totalRealAmount) > Number(issueRealAmount)){
		alert("總實收額大於實收額，請重新輸入!");
		document.MainForm.elements['BigDecimal(realAmount)'].value = "0";
		return false;
	}
}
</script>