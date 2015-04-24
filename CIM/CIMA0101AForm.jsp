<!-- CIMA0101AForm.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<%@ page import="gov.dnt.tame.util.DateUtil"%>

<html:hidden name='Cima0101Form' property='issueSerial'/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='15%'><font color="red">*</font>������O</td>
		<td class='table_td' colspan="5">
			<html:select name='Cima0101Form' property='showType' onchange="changeDate(this.form)">
				<html:option value="0">�п��</html:option>
				<html:optionsCollection  name="Cima0101Form" property="typeList" value="valuess" label="label"/>
			</html:select>	
		</td>	
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�~��</td>
		<td class='table_td' width='30%'>
			<html:text name='Cima0101Form' property='accountYear' size='10' maxlength='3' onblur="getIssueSerial((3 > this.form.accountYear.value.length?'0'+this.form.accountYear.value:this.form.accountYear.value),'C');changeYear(this.form);"/>
		</td>
		<td class='table_item' width='15%'><font color="red">*</font>����</td>
		<td class='table_td' colspan="3">
			<html:text name='Cima0101Form' property='serialNo' size='10' maxlength='2' onblur="getIssueSerial(this.form.accountYear.value,'C');"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>���O</td>
		<td class='table_td' id='issueSerialid' colspan="5">
			<bean:write name='Cima0101Form' property='issueSerial'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' nowrap>�������ɴڦW��</td>
		<td class='table_td' colspan="5">
			<html:text name='Cima0101Form' property='debtName' size='50' maxlength='50' />
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�ɴڴ���</td>
		<td class='table_td' >
			<html:text name='Cima0101Form' property='date(issueDate)' size='7' maxlength='7' onblur ="changeDate(this.form)" />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(issueDate)",new Integer(0))%>~
			<html:text name='Cima0101Form' property='date(dueDate)' size='7' maxlength='7' onblur="changeDate(this.form)"/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(dueDate)",new Integer(1))%>
		</td>
		<td class='table_item'><font color="red">*</font>�ɴڤѴ�</td>
		<html:hidden name='Cima0101Form' property='textCount'/>
		<html:hidden name='Cima0101Form' property='labelCount'/>
		<td class='table_td' id='dayid' colspan="3">
			<bean:write name='Cima0101Form' property='textCount'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' nowrap><font color="red">*</font>�w�p�ɴڪ���</td>
		<td class='table_td' colspan="5">
			<html:text name='Cima0101Form' style="text-align: right" property='bigDecimal(expectAmount)' size='10' maxlength='26' value=""/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>������O</td>
		<td class='table_td'>
			<html:select name='Cima0101Form' property='issueKind'>
				<html:option value="0">�п��</html:option>
				<html:optionsCollection  name="Cima0101Form" property="issueKindList" value="codeNo" label="codeName"/>
			</html:select>	
		</td>
		<td class='table_item'>������</td>
		<td class='table_td' width='15%'>
			<html:text name='Cima0101Form' property='date(finishDate)' size='7' maxlength='7' onblur=""/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(finishDate)",new Integer(2))%>
		</td>
		<td class='table_item'>���v�_</td>
		<td class='table_td' width='15%'>
			<html:checkbox name='Cima0101Form' property='bondType'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�Ƶ�</td>
		<td class='table_td' colspan="5">
			<html:textarea name='Cima0101Form' property='remark' cols="50" rows="5"/>
		</td>
	</tr>
</table>
