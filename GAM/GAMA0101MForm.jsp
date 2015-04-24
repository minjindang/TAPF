<!-- CIMA0101MForm.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<html:hidden name='Cima0101Form' property='id'/>
<html:hidden name='Cima0101Form' property='qryaccountYear'/>
<html:hidden name='Cima0101Form' property='qryserialNo'/>
<html:hidden name='Cima0101Form' property='qryissueSerial'/>
<html:hidden name='Cima0101Form' property='qrydebtName'/>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='10%'><font color="red">*</font>������O</td>
		<td class='table_td' colspan='3'>
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
		<td class='table_td' width='23%' >
			<html:hidden name='Cima0101Form' property='serialNo'/>
			<bean:write name='Cima0101Form' property='serialNo'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width='10%'>���O</td>
		<td class='table_td' colspan='5'>
			<html:text name='Cima0101Form' property='issueSerial'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�w��O</td>
		<td class='table_td'>
			<logic:notEmpty name='Cima0101Form' property='budgetCode'>
				<bean:define id='budgetCode' name='Cima0101Form' property='budgetCode' type="java.lang.Integer"/>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode",(budgetCode).toString(),"","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
			</logic:notEmpty>
			<logic:empty name='Cima0101Form' property='budgetCode'>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode","","","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
			</logic:empty>
			
		</td>
		<td class='table_item'>�ŰȧO</td>
		<td class='table_td' colspan="5">
			<logic:notEmpty name='Cima0101Form' property='debtCode'>
				<bean:define id='budgetCode' name='Cima0101Form' property='budgetCode' type="java.lang.Integer"/>
				<bean:define id='debtCode' name='Cima0101Form' property='debtCode' type="java.lang.Integer"/>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(budgetCode),"debtCode",debtCode.toString(),false)%>
			</logic:notEmpty>
			<logic:empty name='Cima0101Form' property='debtCode'>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(new Integer(1)),"debtCode","",false)%>
			</logic:empty>
			
		</td>
	</tr>
	<tr>
		<td class='table_item' nowrap>���A�ӱ��ŰȦW��</td>
		<td class='table_td' colspan='3'>
			<html:text name='Cima0101Form' property='debtName' size='45' maxlength='50'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�ɴڴ���</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' property='date(issueDate)' size='7' maxlength='7' onblur="changeDate(this.form)"/>
			<a href="javascript: myCalendar.setCallBackObj('date(dueDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="��ܤ��"/></a> ~
			<html:text name='Cima0101Form' property='date(dueDate)' size='7' maxlength='7' onblur='changeDate(this.form)' />
			<a href="javascript: myCalendar.setCallBackObj('date(dueDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="��ܤ��"/></a>
		</td>	
		<td class='table_item'>�ɴڤѴ�</td>
		<html:hidden name='Cima0101Form' property='labelCount'/>
		<html:hidden name='Cima0101Form' property='textCount'/>
		<td class='table_td' id='dayid' >
			<bean:write name='Cima0101Form' property='textCount'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�ӱ����</td>
		<td class='table_td' colspan='5'>
			<html:text name='Cima0101Form' property='date(continueDate)' size='7' maxlength='7' onblur ="" />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(continueDate)",new Integer(3))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�w�p�ɴڪ��B</td>
		<td class='table_td' >
			<html:text name='Cima0101Form' style="text-align: right" property='bigDecimal(expectAmount)' size='20' maxlength='20'/>
		</td>
		<td class='table_item'>��ڭɴڪ��B</td>
		<td class='table_td' >
			<html:hidden name='Cima0101Form' property='bigDecimal(issueAmount)'/>
			<p align="right"><bean:write name='Cima0101Form' property='bigDecimal(issueAmount)' format="#,##0"/></p>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�v�v���B</td>
		<td class='table_td'>
			<html:hidden name='Cima0101Form' property='bigDecimal(capitalAmount)'/>
			<p align="right"><bean:write name='Cima0101Form' property='bigDecimal(capitalAmount)' format="#,##0"/></p>
		</td>
		<td class='table_item'>�[�v�����Q�v</td>
		<td class='table_td'>
			<html:hidden name='Cima0101Form' property='bigDecimal(averageRate)'/>
			<p align="right"><bean:write name='Cima0101Form' property='averageRate' format="#0.000"/></p>
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
		<td class='table_td'>
			<html:hidden name='Cima0101Form' property='bigDecimal(nowAverageRate)'/>
			<p align="right"><bean:write name='Cima0101Form' property='nowAverageRate' format="#0.000"/></p>
		</td>
	</tr>
	<tr>
		<td class='table_item'>���v�_</td>
		<td class='table_td' colspan='3'>
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
		<td class='table_td' colspan='3'>
			<html:textarea name='Cima0101Form' property='remark' cols="50" rows="5"/>
		</td>
	</tr>
</table>
