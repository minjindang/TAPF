<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<script language="javascript">
function doBodyOnLoad(document)
{
	var oNumberMask = new Mask("#,###", "number");
	var moneyCols = new Array("ticketCount");
	for(var i = 0 ; i < moneyCols.length ; i++)
	{
		oNumberMask.attach(document.MainForm.elements[moneyCols[i]]);
		document.MainForm.elements[moneyCols[i]].value = addMoneyMask(document.MainForm.elements[moneyCols[i]].value);
	}
}

function countTotalAmount(form){
	document.getElementById("totalAmount").innerHTML =  addMoneyMask(replaceAll(form.ticketAmount.value,",","") * replaceAll(form.elements["ticketCount"].value,",","") )+ "元";
}

function total(form)
{
	issueAmount = <bean:write name='Aima0103MForm' property='issueAmount'/>
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