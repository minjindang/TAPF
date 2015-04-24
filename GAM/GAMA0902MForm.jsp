<!-- GAMA0902MForm.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<html:hidden name="Cima0101Form" property="id"/>
	<tr>
		<td class='table_item' width='10%'><font color="red">*</font>������O</td>
		<td class='table_td' colspan='5'>
			<html:select name='Cima0101Form' property='showType' onchange="changeDate(this.form)">
				<html:option value="0">�п��</html:option>
				<html:optionsCollection  name="Cima0101Form" property="typeList" value="valuess" label="label"/>
			</html:select>	
		</td>	
	</tr>
	<tr>
		<td class='table_item'>�~��</td>
		<td class='table_td' width='23%'>
			<html:hidden name='Cima0101Form' property='accountYear'/>
			<bean:write name='Cima0101Form' property='accountYear'/>
		</td>	
		<td class='table_item' width='10%'>����</td>
		<td class='table_td' width='23%' colspan="3">
			<html:hidden name='Cima0101Form' property='serialNo'/>
			<bean:write name='Cima0101Form' property='serialNo'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width='10%'>���O</td>
		<td class='table_td' colspan='5'>
			<html:hidden name='Cima0101Form' property='issueSerial'/>
			<bean:write name='Cima0101Form' property='issueSerial'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' nowrap>�ٶŭɴڦW��</td>
		<td class='table_td' colspan='5'>
			<html:text name='Cima0101Form' property='debtName' size='45' maxlength='50'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�ɴڴ���</td>
		<td class='table_td'>
		<html:hidden name='Cima0101Form' property='date(oldIssueDate)' />
		<html:hidden name='Cima0101Form' property='date(oldDueDate)' />
			<html:text name='Cima0101Form' property='date(issueDate)' size='7' maxlength='7' onblur ="changeDate(this.form)" />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(issueDate)",new Integer(0))%>~
			<html:text name='Cima0101Form' property='date(dueDate)' size='7' maxlength='7' onblur="changeDate(this.form)"/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(dueDate)",new Integer(1))%>
		</td>	
		<td class='table_item'><font color="red">*</font>�ɴڤѴ�</td>
		<html:hidden name='Cima0101Form' property='labelCount'/>
		<html:hidden name='Cima0101Form' property='textCount'/>
		<td class='table_td' id='dayid' colspan="3">
			<bean:write name='Cima0101Form' property='textCount'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�w�p�ɴڪ��B</td>
		<td class='table_td' colspan='5'>
			<html:text name='Cima0101Form' style="text-align: right" property='bigDecimal(expectAmount)' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>��ڭɴڪ��B</td>
		<td class='table_td' >
			<html:hidden name='Cima0101Form' property='bigDecimal(issueAmount)'/>
			<p align="right"><bean:write name='Cima0101Form' property='bigDecimal(issueAmount)' format="#,##0"/></p>
		</td>
		<td class='table_td' colspan="4">&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td class='table_item'>�v�v���B</td>
		<td class='table_td'>
			<html:hidden name='Cima0101Form' property='bigDecimal(capitalAmount)'/>
			<html:hidden name='Cima0101Form' property='bigDecimal(interestAmount)'/>
			<p align="right"><bean:write name='Cima0101Form' property='bigDecimal(capitalAmount)' format="#,##0"/></p>
		</td>
		<td class='table_item'>�[�v�����Q�v</td>
		<td class='table_td' colspan="3">
			<html:hidden name='Cima0101Form' property='bigDecimal(averageRate)'/>
			<logic:notEmpty name='Cima0101Form' property='averageRate'>
				<bean:define id="averageRate" name='Cima0101Form' property='averageRate' type="java.math.BigDecimal" /> 
			<p align="right"><%=averageRate.setScale(3,4)%></p>
			</logic:notEmpty>
			<logic:empty name='Cima0101Form' property='averageRate'>
				<%=0%>
			</logic:empty>
		</td>
	</tr>
	<tr>
		<td class='table_item'>���v���B</td>
		<td class='table_td'>
			<bean:define id="issueAmount" name="Cima0101Form" property="bigDecimal(issueAmount)" type="java.math.BigDecimal"/>
			<bean:define id="capitalAmount" name="Cima0101Form" property="bigDecimal(capitalAmount)" type="java.math.BigDecimal"/>
			<p align="right"><%=new java.text.DecimalFormat("#,##0").format(issueAmount.subtract(capitalAmount))%></p>
		</td>
		<td class='table_item'>�ثe�[�v�����Q�v</td>
		<td class='table_td' colspan="3">
			<html:hidden name='Cima0101Form' property='bigDecimal(nowAverageRate)'/>
			<logic:notEmpty name='Cima0101Form' property='nowAverageRate'>
				<bean:define id="nowAverageRate" name='Cima0101Form' property='nowAverageRate' type="java.math.BigDecimal" /> 
			<p align="right"><%=nowAverageRate.setScale(3,4)%></p>
			</logic:notEmpty>
			<logic:empty name='Cima0101Form' property='nowAverageRate'>
				<%=0%>
			</logic:empty>
		</td>
	</tr>
	<tr>
		<td class='table_item'>������O</td>
		<td class='table_td'>
			<html:select name='Cima0101Form' property='issueKind'>
				<html:option value="">�п��</html:option>
				<html:optionsCollection  name="Cima0101Form" property="issueKindList" value="codeNo" label="codeName"/>
			</html:select>	
		</td>	
		<td class='table_item'>������</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' property='date(finishDate)' size='7' maxlength='7' />
			<a href="javascript: myCalendar.setCallBackObj('date(finishDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="��ܤ��"/></a>
		</td>
		<td class='table_item'>���v�_</td>
		<td class='table_td'>
			<logic:notEmpty name="Cima0101Form" property="bondType">
				<bean:define id="bondType" name="Cima0101Form" property="bondType" type="java.lang.String"/>
				<input type="checkbox" name='bondType' <%="1".equals(bondType)?"checked":"2"%> />
			</logic:notEmpty>	
			<logic:empty name="Cima0101Form" property="bondType">
				<html:checkbox name='Cima0101Form' property='bondType'/>
			</logic:empty>	
		</td>
	</tr>
	<tr>
		<td class='table_item'>�Ƶ�</td>
		<td class='table_td' colspan='5'>
			<html:textarea name='Cima0101Form' property='remark' cols="50" rows="5"/>
		</td>
	</tr>
</table>