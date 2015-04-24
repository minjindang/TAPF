<%@ page language="java" contentType="text/html;charset=MS950" %>
<%@ page import="tw.gov.nta.sql.debt.IssueMain" %>
<%@ page import="tw.gov.nta.sql.debt.PaymentMain" %>
<%@ page import="tw.gov.nta.debt.common.PayManager" %>
<%@ page import="gov.dnt.tame.util.DateUtil" %>
<%@ page import="java.util.*" %>
<script language="JScript" type="text/javascript">
<%
	Integer	issueId	= Integer.parseInt(request.getParameter("issueId"));
	String	repayDate	=	request.getParameter("repayDate");
	String	capitalSerial	=	request.getParameter("capitalSerial");
	if(issueId != 0)
	{
		IssueMain issueMain = new tw.gov.nta.debt.common.IssueManager().getBean(issueId);
		String days = DateUtil.getDays(issueMain.getIssueDate(),DateUtil.str2Date(repayDate)).toString();
		out.print("\t\tparent.MainForm.debtName.value ='"+issueMain.getDebtName()+"'; \r\n");
		out.print("\t\tparent.document.getElementById(\"debt\").innerHTML ='"+issueMain.getDebtName()+"'; \r\n");
		//out.print(tw.gov.nta.exchequer.action.BIMA0200.getIssueData(issueId));
		out.print("\t\tparent.MainForm.elements['date(issueDate)'].value = '"+issueMain.getIssueDate()+"'; \r\n");
		out.print("\t\tparent.MainForm.interestDays.value = \""+days+"\"; \r\n");
		if(issueMain.getIssueAmount() != null)
		{
			//out.print("\t\tparent.MainForm.elements['bigDecimal(issueAmount)'].value = '"+issueMain.getIssueAmount()+"'; \r\n");
			//out.print("\t\tparent.MainForm.issueAmount2.value = '"+issueMain.getIssueAmount()+"'; \r\n");
			out.print("\t\tparent.document.getElementById(\"issue\").innerHTML ='"+issueMain.getIssueAmount()+"'; \r\n");
			out.print("\t\tparent.document.getElementById(\"issue2\").innerHTML ='"+issueMain.getIssueAmount()+"'; \r\n");
		}
		else
		{
			//out.print("\t\tparent.MainForm.elements['bigDecimal(issueAmount)'].value = ''; \r\n");
			//out.print("\t\tparent.MainForm.issueAmount2.value = ''; \r\n");
			out.print("\t\tparent.document.getElementById(\"issue\").innerHTML =''; \r\n");
			out.print("\t\tparent.document.getElementById(\"issue2\").innerHTML =''; \r\n");
		}
		List payList = new PayManager().getDataByIssue(issueMain.getId());
		String capitalSerialTemp = null;
		if (payList.size()==0)
		{
			capitalSerialTemp = "A";
		}
		else
		{
			for(Iterator it=payList.iterator();it.hasNext();)
			{
				PaymentMain paymentMainDto = (PaymentMain)it.next();
				capitalSerialTemp = String.valueOf((char)(((int)(paymentMainDto.getCapitalSerial().charAt(0)))+1));
			}
		}
		out.print("\t\tparent.MainForm.capitalSerial.value = '"+ capitalSerialTemp+"'; \r\n");
	}
	else
	{
		out.print("\t\tparent.MainForm.debtName.value =''; \r\n");
		out.print("\t\tparent.document.getElementById(\"debt\").innerHTML ='&nbsp;'; \r\n");
		out.print("\t\tparent.MainForm.elements['date(issueDate)'].value = ''; \r\n");
		out.print("\t\tparent.MainForm.interestDays.value = \"\"; \r\n");
		//out.print("\t\tparent.MainForm.elements['bigDecimal(issueAmount)'].value = ''; \r\n");
		//out.print("\t\tparent.MainForm.issueAmount2.value = ''; \r\n");
		out.print("\t\tparent.MainForm.capitalSerial.value = ''; \r\n");
		out.print("\t\tparent.document.getElementById(\"issue\").innerHTML ='&nbsp;'; \r\n");
		out.print("\t\tparent.document.getElementById(\"issue2\").innerHTML ='&nbsp;'; \r\n");
	}
%>
</script>