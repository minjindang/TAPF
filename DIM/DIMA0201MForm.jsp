<!-- DIMA0102MForm.jsp
程式目的：DIMA02
程式代號：DIMA02
程式日期：0950223
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
<html:hidden name='Dima0201Form' property='id'/>
<html:hidden name="Dima0201Form" property="qryAccountYear"/>
<html:hidden name="Dima0201Form" property="qrySerialNo"/>
<html:hidden name="Dima0201Form" property="qryId"/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>年度</td>
		<td class='table_td'>
			<bean:write name='Dima0201Form' property='accountYear'/>
			<html:hidden name='Dima0201Form' property='accountYear'/>
		</td>
		<td class='table_item'>期次</td>
		<td class='table_td' colspan="5">
			<bean:write name='Dima0201Form' property='serialNo'/>
			<html:hidden name='Dima0201Form' property='serialNo'/>
		</td>
	<tr>
		<td class='table_item'><font color="red">*</font>預算別</td>
		<td class='table_td'>
			<bean:define id='budgetCode' name='Dima0201Form' property='budgetCode' type="java.lang.Integer"/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode",(budgetCode).toString(),"","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
		<td class='table_item'><font color="red">*</font>債務別</td>
		<td class='table_td' colspan="5">
			<bean:define id='debtCode' name='Dima0201Form' property='debtCode' type="java.lang.Integer"/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(budgetCode),"debtCode",(debtCode).toString(),false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>期別</td>
		<td class='table_td'>
			<bean:write name='Dima0201Form' property='issueSerial'/>
			<html:hidden name='Dima0201Form' property='issueSerial'/>
		</td>
		<td class='table_item'>名稱</td>
		<td class='table_td' colspan="5">
			<html:text name='Dima0201Form' property='debtName' size='50' maxlength='50'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>借款期間</td>
		<td class='table_td'>
			<html:text name='Dima0201Form' property='date(issueDate)' size='10' onblur="getDays()"/>
			<a href="javascript: myCalendar.setCallBackObj('Date(issueDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/></a>
			~<html:text name='Dima0201Form' property='date(dueDate)'  size='10' onblur="getDays()"/>
			<a href="javascript: myCalendar.setCallBackObj('Date(dueDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/></a>
		</td>
		<td class='table_item'>天數</td><html:hidden name='Dima0201Form' property='days'/>
		<td class='table_td' id="dayid">
			<bean:write name='Dima0201Form' property='days' />
		</td>
		<td class='table_item'>預計借款金額</td>
		<td class='table_td' colspan="3">
			<html:text name='Dima0201Form' property='bigDecimal(expectAmount)' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>實際借款金額</td>
		<td class='table_td'>
			<bean:write name='Dima0201Form' property='issueAmount' format='###,##0' />
			<html:hidden name='Dima0201Form' property='issueAmount' />
		</td>
		<td class='table_item'>已償金額</td>
		<td class='table_td'>
			<bean:write name='Dima0201Form' property='capitalAmount' format='###,##0'/>
			<html:hidden name='Dima0201Form' property='capitalAmount' />
		</td>
		<td class='table_item'>未償金額</td>
		<td class='table_td'>
			<bean:write name='Dima0201Form' property='nonAmount' format='###,##0'/>
		</td>
		<td class='table_item'>加權平均利率</td>
		<td class='table_td'>
			<bean:write name='Dima0201Form' property='bigDecimal(averageRate)' format='###,##0.000'/>
			<html:hidden name='Dima0201Form' property='bigDecimal(averageRate)' />
		</td>
	</tr>
	<tr>
		<td class='table_item'>備註</td>
		<td class='table_td' colspan="7">
			<!--html:text name='Dima0201Form' property='remark' size='50'/-->
			<html:textarea name='Dima0201Form' property='remark' cols="50" rows="5"/>
		</td>
	</tr>
</table>
