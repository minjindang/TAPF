<!-- CIMA0101MForm.jsp
�{���ت��GCIMA01
�{���N���GCIMA01
�{������G0950306
�{���@�̡GEric.Chen
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
		<html:hidden name='Cima0101Form' property='id'/>
		<html:hidden name='Cima0101Form' property='qryaccountYear'/>
		<html:hidden name='Cima0101Form' property='qryserialNo'/>
		<html:hidden name='Cima0101Form' property='qryissueSerial'/>
		<html:hidden name='Cima0101Form' property='qrydebtName'/>
		<html:hidden name='Cima0101Form' property='date(issueDate)'/>
		<html:hidden name='Cima0101Form' property='date(dueDate)'/>	
		<html:hidden name='Cima0101Form' property='bankId'/>	
		<html:hidden name='Cima0101Form' property='debtId'/>	
	<tr>
		<td class='table_item'><font color="red">*</font>�w��~��</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' property='budgetYear' maxlength='3' size='5' />
		</td>
	</tr>	
	<tr>
		<td class='table_item'><font color="red">*</font>�w��O</td>
		<td class='table_td'>
			<html:select name='Cima0101Form' property='budgetCodeDebt' onchange="changeValue(this.form)">
					<html:option value="0">�п��</html:option>
					<html:optionsCollection name="Cima0101Form" property="budgetList" label="budgetName" value="id"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�ŰȧO</td>
		<td class='table_td'>
			<html:select name='Cima0101Form' property='debtCodeDebt' >
					<html:option value="0">�п��</html:option>
					<logic:notEmpty name="Cima0101Form" property="debtList">
						<html:optionsCollection name="Cima0101Form" property="debtList" label="debitName" value="id"/>
					</logic:notEmpty>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�Ȧ�s��<br><font color="red">*</font>�Ȧ�W��</br></td>
		<td class='table_td'>
			<logic:notEmpty name="Cima0101Form" property='bankCode'>
				<bean:define id="bankCode" name="Cima0101Form" property="bankCode" type="java.lang.String"/>
					<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BankCodeManage.getBankCodeDIM(),"bankCode",bankCode,"bankCode","getSelectValue(this.form)")%>
			</logic:notEmpty>
			<logic:empty name="Cima0101Form" property='bankCode'>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BankCodeManage.getBankCodeDIM(),"bankCode","","bankCode","getSelectValue(this.form)")%>
			</logic:empty>
			<html:hidden name='Cima0101Form' property='bankName'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>������B</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' style="text-align: right" property='bigDecimal(compareAmount)' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�Q�v</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' style="text-align: right" property='bigDecimal(compareRate)' size='20' maxlength='20' onmousemove="rateLimit(this.form)"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�o�Ъ��B</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' style="text-align: right" property='bigDecimal(issueAmountDet)' size='20' maxlength='50' onblur="changeAmount(this.form)"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�Q��</td>
		<td class='table_td'>
			<p align="right"><bean:write name='Cima0101Form' property='bigDecimal(originInterestAmount)' format='#,##0'/></p>
		</td>
	</tr>
	<html:hidden name='Cima0101Form' property='bigDecimal(originInterestAmount)'/>
	<tr>
		<td class='table_item' width="25%">�����X�p</td>
		<td class='table_td' width="15%" id="totalAmountid" align="right">
			<p align="right"><bean:write name='Cima0101Form' property='bigDecimal(totalAmount)'/></p>
		</td>
		<td width="60%"></td>
	</tr>
	<html:hidden name='Cima0101Form' property='bigDecimal(totalAmount)'/>	
</table>