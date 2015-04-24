<!--	CPRA0201QForm.jsp
程式目的：CPRA0201
程式代號：CPRA0201
程式日期：0950316
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>期別</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.debt.common.IssueManager.getIssueSerial("C"),"issueId",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>銀行別</td>
		<td class='table_td'>
			<html:select name="Cpra0201Form" property="bankId" onblur="getSelectValue(this.form)">
					<html:option value="">請選擇</html:option>
					<html:optionsCollection name="Cpra0201Form"  property="bankCodeList" label="label" value="valuess"/>
			</html:select>
			<html:hidden name="Cpra0201Form" property="bankName"/>
		</td>
	</tr>
</table>