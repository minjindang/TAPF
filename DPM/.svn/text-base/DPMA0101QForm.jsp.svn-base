<!-- DIMA0101AForm.jsp
程式目的：DIMA01
程式代號：DIMA01
程式日期：0950223
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>年度</td>
		<td class='table_td'>
			<html:text name='Dpma0101Form' property='accountYear' size='3' maxlength='3' />
		</td>
	</tr>
	<tr>
		<td class='table_item'>短期借款名稱</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(gov.dnt.tame.util.ListToolManager.getList("select id, debtName from IssueMain where debtType='D' order by accountYear desc,serialNo desc"),"id",10,false)%>
		</td>
	</tr>
</table>
