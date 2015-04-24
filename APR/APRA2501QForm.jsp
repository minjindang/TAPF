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
		<td class='table_item'><font color="red">*</font>截止日期</td>
		<td class='table_td'>
			<html:text name='Apra2501Form' property='date(limitDate)' size='10' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(limitDate)")%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>預算別</td>
		<td class='table_td'>
			<%pageContext.setAttribute("budgetNameList",tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo()); %>
			<html:select name='Apra2501Form' property='budgetCode' onchange="getSelect(this.form)">
				<html:option value="">請選擇</html:option>
				<html:options collection="budgetNameList" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
			<html:hidden name="Apra2501Form" property="budgetName" value="總表" />
		</td>
	</tr>
</table>
