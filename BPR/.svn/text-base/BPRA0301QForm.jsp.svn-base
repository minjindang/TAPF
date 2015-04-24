<!-- APRA1501QForm.jsp
程式目的：APRA15文字
程式代號：APRA15
程式日期：0950221
程式作者：Andrew Sung
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%
	String code = (String)request.getAttribute("code");
%>
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<input type='hidden' name='code' value='<%=code %>'/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>發行日期</td>
		<td class='table_td'>
			<html:text name='Bpra0301Form' property='date(issueSdate)' size='7' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(issueSdate)", new Integer(0))%>
			 ~ 
			<html:text name='Bpra0301Form' property='date(issueEdate)' size='7' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(issueEdate)", new Integer(1))%>
		</td>
	</tr>
<% 
	if(code.equals("BPRA04"))
	{
%>
		<tr>
			<td class='table_item'><font color="red">*</font>銷毀日期</td>
			<td class='table_td'>
				<html:text name='Bpra0301Form' property='date(destDate)' size='10' maxlength='7' onblur=''/>
    			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(destDate)", new Integer(3))%>
			</td>
		</tr>
		<tr>
			<td class='table_item'><font color="red">*</font>銷毀地點</td>
			<td class='table_td'>
				<html:text name='Bpra0301Form' property='destArea' size='53' maxlength='50'/>
			</td>
		</tr>
<% 
	}
%>
	<tr>
		<td class='table_item'>金額單位</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("BU"),"amountUnit",10,false)%>
		</td>
	</tr>
</table>
