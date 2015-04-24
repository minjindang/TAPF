<!-- CIMA0101AForm.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<%@ page import="gov.dnt.tame.util.DateUtil"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='20%'>������O</td>
		<td class='table_td' colspan='3'>
			<html:select name='Cima0101Form' property='showType' onchange="changeDate(this.form)">
				<html:option value="0">�п��</html:option>
				<html:optionsCollection  name="Cima0101Form" property="typeList" value="valuess" label="label"/>
			</html:select>	
		</td>	
	</tr>
	<tr>
		<td class='table_item'>�~��</td>
		<td class='table_td' >
			<html:text name='Cima0101Form' property='accountYear' size='10'value=""   maxlength='3' onblur="getIssueSerial(this.form.accountYear.value,'E');"/>
		</td>
		<td class='table_item'>����</td>
		<td class='table_td' colspan='3'>
			<html:text name='Cima0101Form' property='serialNo' size='10' value="" maxlength='2' onblur="getIssueSerial(this.form.accountYear.value,'E');"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>���O</td>
		<td class='table_td' colspan='5'>
			<html:text name='Cima0101Form' property='issueSerial' value=""/>&nbsp;
		</td>
	</tr>
	<tr>
		<td class='table_item'>�w��O</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode","1","","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
		<td class='table_item'>�ŰȧO</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(new Integer(1)),"debtCode",false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item' nowrap>���A�ӱ��ŰȦW��</td>
		<td class='table_td' colspan='5'>
			<html:text name='Cima0101Form' property='debtName' size='30' value=""/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�ɴڴ���</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' property='date(issueDate)' size='7' maxlength='7' onblur ="changeDate(this.form)" value="<%= DateUtil.getSystemDate()%>" />
			<a href="javascript: myCalendar.setCallBackObj('date(issueDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="��ܤ��"/></a> ~
			<html:text name='Cima0101Form' property='date(dueDate)' size='7' maxlength='7' onblur="changeDate(this.form)"/>
			<a href="javascript: myCalendar.setCallBackObj('date(dueDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="��ܤ��"/></a>
		</td>
		<td class='table_item'>�ɴڤѴ�</td>
		<html:hidden name='Cima0101Form' property='textCount'/>
		<html:hidden name='Cima0101Form' property='labelCount'/>
		<td class='table_td' id='dayid' colspan='3'>
			<bean:write name='Cima0101Form' property='textCount'/>&nbsp;
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�ӱ����</td>
		<td class='table_td' colspan='5'>
			<html:text name='Cima0101Form' property='date(continueDate)' size='7' maxlength='7' value="" onblur ="" />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(continueDate)",new Integer(3))%>
		</td>
	</tr>
	<tr>
		<td class='table_item' nowrap><font color="red">*</font>�w�p�ɴڪ���</td>
		<td class='table_td' >
			<html:text name='Cima0101Form' style="text-align: right" property='bigDecimal(expectAmount)' size='30' maxlength='30' value=""/>
		</td>
		<td class='table_item'>���v�_</td>
		<td class='table_td'>
			<html:checkbox name='Cima0101Form' property='bondType'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�Ƶ�</td>
		<td class='table_td' colspan='5'>
			<html:textarea name='Cima0101Form' property='remark' cols="50" rows="5"/>
		</td>
	</tr>
</table>
