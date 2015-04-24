<!-- APRA1501QForm.jsp
程式目的：APRA15文字
程式代號：APRA15
程式日期：0950221
程式作者：Andrew Sung
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
		<td class='table_item'><font color="red">*</font>公債名稱</td>
		<td class='table_td'>
			<%pageContext.setAttribute("debtNameList",gov.dnt.tame.util.ListToolManager.getList("select id, debtName from IssueMain where debtType='A' and issueKind = '1' order by debt_name , account_year")); %>
			<html:select name='Apra2101Form' property='issueId' onchange="getDebtName(this.form)">
				<html:option value="">請選擇</html:option>
				<html:options collection="debtNameList" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
			<html:hidden name="Apra2101Form" property='debtName'/>
		</td>
	</tr>
</table>
