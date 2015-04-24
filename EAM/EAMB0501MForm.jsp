<!--
程式目的：EAMA03文字
程式代號：EAMA03
程式日期：0950301
程式作者：Linus
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<%@ include file="/common/taglibs.jsp"%>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>會計年度</td>
		<td class='table_td'>
			<html:text name="Eamb0501Form" property="accountYear" maxlength="3" size="10" value='<%=gov.dnt.tame.util.DateUtil.date2ROCStr(new java.util.Date()).substring(0,3)%>'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>過帳月份</td>
		<td class='table_td'>	
			<html:select name="Eamb0501Form" property="accountMonth" value="<%=String.valueOf(java.util.Calendar.getInstance().get(java.util.Calendar.MONTH) + 1)%>">
			<%
				for(int i = 0;i<12;i++){
			%>
				<html:option value="<%=String.valueOf(i+1)%>"/>
			<%}%>
			</html:select>
		</td>
	</tr>
	<c:if test='${sessionScope.debtTypeId eq 1}' >
		<tr>
			<td class='table_item'>債務名稱</td>
			<td class='table_td'>	
				<input type="text" name="issueYear" size="4" maxlenght="3" value='<c:out value="${Eamb0501Form.issueYear}"/>' onchange="form.action='<c:out value="${SYSID}"/>'; form.submit();" />
				<html:select name="Eamb0501Form" property="issueId">
					<html:option value="0">全部</html:option>
					<html:optionsCollection name='Eamb0501Form' property='issueList' label="debtName" value="id" />
				</html:select>
			</td>
		</tr>		
	</c:if>
</table>
