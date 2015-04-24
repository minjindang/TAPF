<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<%tw.gov.nta.sql.debt.IssueMain sourceIssueMain = (tw.gov.nta.sql.debt.IssueMain)request.getAttribute("sourceIssueMain"); %>
<bean:define id="issueMain" name="Aima0201MForm" property='issueMain' type="tw.gov.nta.sql.debt.IssueMain"/>
<html:hidden name='Aima0201MForm' property='issueMainId' />
<html:hidden name='Aima0201MForm' property='Date(issueDate)'/>
<html:hidden name='Aima0201MForm' property='budgetCode' value='0'/>
<html:hidden name='Aima0201MForm' property='debtCode' value='0'/>
<html:hidden name='Aima0201MForm' property='issueInterval'/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='20%'>��l�o�椽�ŦW��</td>
		<td class='table_td'><%= sourceIssueMain.getDebtName()%>&nbsp;</td>
		<td class='table_item'><font color="#ff0000">*</font>�W�B�o����</td>
		<td class='table_td' colspan="3">
			<html:text name='Aima0201MForm' property='Date(issueDate)' size='7' maxlength='7' onblur="doAction('AIMA0200M');"/>
			<a href="javascript: myCalendar.setCallBackObj('Date(issueDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="��ܤ��"/></a>
		</td>
	</tr>
	<tr>
		<td class='table_item' width='20%'><font color="#ff0000">*</font>�|�p�~��</td>
		<td class='table_td'><html:text name='Aima0201MForm' property='accountYear' size='5' maxlength='4'/></td>
		<td class='table_item'><font color="#ff0000">*</font>����</td>
		<td class='table_td' colspan="3"><bean:write name='Aima0201MForm' property='issueInterval'/>�~&nbsp;</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>���Ŵ���</td>
		<td class='table_td'><bean:write name='Aima0201MForm' property='serialNo'/>&nbsp;</td>
		<td class='table_item'><font color="#ff0000">*</font>�����}�I��</td>
		<td class='table_td' colspan="3">
			<bean:write name='Aima0201MForm' property='dateFormat(finishDate)'/>&nbsp;
		</td>
	</tr>
	<tr>
		<td class='table_item' width='20%'><font color="#ff0000">*</font>�W�B���ťN��</td>
		<td class='table_td'><html:text name='Aima0201MForm' property='issueSerial' size='10' maxlength='10'/></td>
		<td class='table_item'><font color="#ff0000">*</font>������</td>
		<td class='table_td' colspan="3">
			<bean:write name='Aima0201MForm' property='dateFormat(dueDate)'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>�W�B�����ѧO�X</td>
		<td class='table_td'>		
			<bean:define id='bondType' name='Aima0201MForm' property='bondType' type='java.lang.String'/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("BT"),"bondType",bondType,"",10, false)%>&nbsp;
		</td>
		<td class='table_item'><font color="#ff0000">*</font>���ħI�I����</td>
		<td class='table_td' colspan="3"><html:text name='Aima0201MForm' property='payLimit' value='5' size='3' maxlength='2'/>�~&nbsp;</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>�W�B���ŦW��</td>
		<td class='table_td'>
			<html:text name='Aima0201MForm' property='debtName' size='60' maxlength='120'/>
		</td>
		<td class='table_item'>�I��I�I���</td>
		<td class='table_td' colspan="3">
			<bean:write name='Aima0201MForm' property='dateFormat(cashDueDate)'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>�W�B���ŧΦ�</td>
		<td class='table_td'>
			<bean:define id='issueKind' name='Aima0201MForm' property='issueKind' type='java.lang.String'/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("IK"),"issueKind",issueKind,"",10, false)%>
		</td>
		<td class='table_item'><font color="#ff0000">*</font>�����Q�v</td>
		<td class='table_td' colspan="3">�~��<bean:write name='Aima0201MForm' property='averageRate' format='##0.000'/>�H&nbsp;</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>�i���Τ���</td>
		<td class='table_td'>
			<html:select name='Aima0201MForm' property='bondSellStatus'>
				<html:option value='Y'>�O</html:option>
				<html:option value='N'>�_</html:option>
			</html:select>
		</td>
		<td class='table_item'><font color="#ff0000">*</font>�Q�v�ܰʧO</td>
		<td class='table_td' colspan="3">
			<bean:define id='rateKind' name='Aima0201MForm' property='rateKind' type='java.lang.String'/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("RK"),"rateKind",rateKind,"",10, false)%>&nbsp;
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>�o���B</td>
		<td class='table_td'><html:text name='Aima0201MForm' property='BigDecimal(issueAmount)' size='20' maxlength='25' onblur="doAction('AIMA0200M');"/>��</td>
		<td class='table_item' width='20%'>�P��l���ŵo�����۶Z</td>
		<td class='table_td' colspan="3">
			<div id='diff'>
			<logic:notEmpty name='Aima0201MForm' property='diffOriginDay'>
				<bean:write name='Aima0201MForm' property='diffOriginDay'/>��
			</logic:notEmpty>
			</div>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>�ꦬ��</td>
		<td class='table_td'><html:text name='Aima0201MForm' property='BigDecimal(realAmount)' size='20' maxlength='20' />��</td>
		<td class='table_item' width='20%'>���p�Q��</td>
		<td class='table_td' colspan="3">
			<logic:notEmpty name='Aima0201MForm' property='repayInterestAmount'>
				<bean:define id="repayInterestAmount" name='Aima0201MForm' property='repayInterestAmount' type="java.lang.String"/>
					<% 
					  java.math.BigDecimal Interest =new java.math.BigDecimal(Double.parseDouble(repayInterestAmount));
					%>
				<%=new java.text.DecimalFormat("#,##0").format(Interest)%>��	
			</logic:notEmpty>
			<logic:empty name='Aima0201MForm' property='repayInterestAmount'>
					<%=0%>��
			</logic:empty>
		</td>
	</tr>
	<tr>
	<tr>
		<td class='table_item'>�����I�����</td>
		<td class='table_td'>
			<html:text name='Aima0201MForm' property='date(firstInterestDate)' size='10'/>
		</td>
		<td class='table_item'>�I������</td>
		<td class='table_td'><html:text name='Aima0201MForm' property='interestAlternate' size='5' onblur="count(form)"/>&nbsp;</td>
		<td class='table_item'>�I�����Z</td>
		<td class='table_td' id="repayInterestInterval"><bean:write name='Aima0201MForm' property='repayInterestInterval'/>��&nbsp;</td>
	</tr>
	<tr>
		<td class='table_item'>�����٥����</td>
		<td class='table_td' width='15%'>
			<html:text name='Aima0201MForm' property='date(firstRepayDate)' size='10'/>
		</td>
		<td class='table_item'>�٥�����</td>
		<td class='table_td' width='15%'><html:text name='Aima0201MForm' property='repayAlternate' size='5' onblur="count(form)"/>&nbsp;</td>
		<td class='table_item'>�٥����Z</td>
		<td class='table_td' width='15%' id="repayCapitalInterval"><bean:write name='Aima0201MForm' property='repayCapitalInterval'/>��&nbsp;</td>
	</tr>
</table>