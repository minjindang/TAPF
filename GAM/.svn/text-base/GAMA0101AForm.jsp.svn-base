<!-- CIMA0101AForm.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<%@ page import="gov.dnt.tame.util.DateUtil"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='20%'>顯示類別</td>
		<td class='table_td' colspan='3'>
			<html:select name='Cima0101Form' property='showType' onchange="changeDate(this.form)">
				<html:option value="0">請選擇</html:option>
				<html:optionsCollection  name="Cima0101Form" property="typeList" value="valuess" label="label"/>
			</html:select>	
		</td>	
	</tr>
	<tr>
		<td class='table_item'>年度</td>
		<td class='table_td' >
			<html:text name='Cima0101Form' property='accountYear' size='10'value=""   maxlength='3' onblur="getIssueSerial(this.form.accountYear.value,'E');"/>
		</td>
		<td class='table_item'>期次</td>
		<td class='table_td' colspan='3'>
			<html:text name='Cima0101Form' property='serialNo' size='10' value="" maxlength='2' onblur="getIssueSerial(this.form.accountYear.value,'E');"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>期別</td>
		<td class='table_td' colspan='5'>
			<html:text name='Cima0101Form' property='issueSerial' value=""/>&nbsp;
		</td>
	</tr>
	<tr>
		<td class='table_item'>預算別</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode","1","","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
		<td class='table_item'>債務別</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(new Integer(1)),"debtCode",false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item' nowrap>概括承接債務名稱</td>
		<td class='table_td' colspan='5'>
			<html:text name='Cima0101Form' property='debtName' size='30' value=""/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>借款期間</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' property='date(issueDate)' size='7' maxlength='7' onblur ="changeDate(this.form)" value="<%= DateUtil.getSystemDate()%>" />
			<a href="javascript: myCalendar.setCallBackObj('date(issueDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/></a> ~
			<html:text name='Cima0101Form' property='date(dueDate)' size='7' maxlength='7' onblur="changeDate(this.form)"/>
			<a href="javascript: myCalendar.setCallBackObj('date(dueDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/></a>
		</td>
		<td class='table_item'>借款天期</td>
		<html:hidden name='Cima0101Form' property='textCount'/>
		<html:hidden name='Cima0101Form' property='labelCount'/>
		<td class='table_td' id='dayid' colspan='3'>
			<bean:write name='Cima0101Form' property='textCount'/>&nbsp;
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>承接日期</td>
		<td class='table_td' colspan='5'>
			<html:text name='Cima0101Form' property='date(continueDate)' size='7' maxlength='7' value="" onblur ="" />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(continueDate)",new Integer(3))%>
		</td>
	</tr>
	<tr>
		<td class='table_item' nowrap><font color="red">*</font>預計借款金款</td>
		<td class='table_td' >
			<html:text name='Cima0101Form' style="text-align: right" property='bigDecimal(expectAmount)' size='30' maxlength='30' value=""/>
		</td>
		<td class='table_item'>自償否</td>
		<td class='table_td'>
			<html:checkbox name='Cima0101Form' property='bondType'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>備註</td>
		<td class='table_td' colspan='5'>
			<html:textarea name='Cima0101Form' property='remark' cols="50" rows="5"/>
		</td>
	</tr>
</table>
