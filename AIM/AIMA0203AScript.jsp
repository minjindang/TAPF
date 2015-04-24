<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<script language="javascript">
function doBodyOnLoad(document)
{
		//do nothing
}

function calculateAmount(form){
	document.getElementById("totalAmount").innerHTML = addMoneyMask(form.elements("ticketAmount").value * form.elements("ticketCount").value) + "元";
}
function total(form)
{
	issueAmount = <bean:write name='Aima0203MForm' property='issueAmount'/>
	totalIssueAmount = <%= request.getAttribute("totalIssueAmount") %>;
	ticketAmount = replaceAll(form.elements['ticketAmount'].value,",","");
	ticketCount = replaceAll(form.elements['ticketCount'].value,",","")
	if(ticketAmount != "" && ticketCount!=""){
		if( parseInt(ticketAmount) * parseInt(ticketCount) + parseInt(totalIssueAmount) <= parseInt(issueAmount))
		{
			document.MainForm.elements['ticketAmount'].value = ticketAmount;
		}
		else
		{
			answer = confirm("總發行額大於發行金額，是否繼續?");
			if (answer)
				document.MainForm.elements['ticketCount'].value = ticketCount;
			else{
				document.MainForm.elements['ticketCount'].value = "0";
				document.getElementById("totalAmount").innerHTML = "0元";
			}
		}
	}
}
</script>