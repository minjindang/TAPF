<!-- APRA1501QForm.jsp
�{���ت��GAPRA15��r
�{���N���GAPRA15
�{������G0950221
�{���@�̡GAndrew Sung
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>���ŦW��</td>
		<td class='table_td'>
			<%pageContext.setAttribute("debtNameList",gov.dnt.tame.util.ListToolManager.getList("select id, debtName from IssueMain where debtType='A' and issueKind = '1' order by debt_name , account_year")); %>
			<html:select name='Apra2301Form' property='issueId' onchange="getDebtName(this.form)">
				<html:option value="">�п��</html:option>
				<html:options collection="debtNameList" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
			<html:hidden name="Apra2301Form" property='debtName'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�P����</td>
		<td class='table_td'>
			<html:text name='Apra2301Form' property='date(killDate)' size='10' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(killDate)",new Integer(0))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�P��a�I</td>
		<td class='table_td'>
			<html:text name='Apra2301Form' property='killPlace' size='10' maxlength='10' />
		</td>
	</tr>
</table>