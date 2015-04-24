<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@taglib uri="/tags/struts-bean" prefix="bean" %>
<%@taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>債務名稱</td>
		<td class='table_td'>
			<input type="text" name="issueYear" value='<c:out value="${AccountQueryForm.issueYear}"/>' onchange="form.action='<c:out value="${SYSID}"/>'; form.submit();" SIZE = "3" />年
			<select name="issueMonth" onchange="form.action='<c:out value="${SYSID}"/>'; form.submit();">
			<%
				for(int i = 0;i<12;i++){
					int j = i+1;
					String s = String.valueOf(j);
					if (j<10)
						s = "0" + s;
					out.print("<option value="+s);
					String monthValue = ((tw.gov.nta.account.form.AccountQueryForm)request.getAttribute("AccountQueryForm")).getIssueMonth();

					if (s.equals(monthValue)){
						out.print(" selected=Y");
					}			
					out.println(">"+s+"</option>");		
				}
			%>

			</select>月
			<html:select name="AccountQueryForm" property="issueId">
				<html:optionsCollection name='AccountQueryForm' property='issueList' label="debtName" value="id" />
			</html:select>
		</td>
	</tr>
	
</table>