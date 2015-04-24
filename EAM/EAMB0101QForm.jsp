<!-- EAMB0101QForm.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>�o��~��</td>
		<td class='table_td'>
			<html:text name="Eamb0101Form" property="accountYear" maxlength="5" size="30"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�o����</td>
		<td class='table_td'>
			<html:text name="Eamb0101Form" property="month" maxlength="5" size="30"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>����</td>
		<td class='table_td' colspan="3">
			<html:text name="Eamb0101Form" property="serialNo" maxlength="5" size="30"/>	
		</td>
	</tr>
	<tr>
		<td class='table_item'>�w��O</td>
		<td class='table_td' colspan="3">
			<html:select name="Eamb0101Form" property="budgetCode" >
				<html:option value="">  �����w��O   </html:option>
				<html:optionsCollection name="Eamb0101Form" property="allBudgetCode" label="budgetName" value="id"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�ŰȧO</td>
		<td class='table_td'>
			<html:select name="Eamb0101Form" property="debtCode" >
				<html:option value="">  �����ŰȧO    </html:option>
				<html:optionsCollection name="Eamb0101Form" property="allDebtCode" label="debitName" value="id"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�ŰȦW��</td>
		<td class='table_td' colspan="3">
			<html:text name="Eamb0101Form" property="debtName" maxlength="30" size="30"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�o����</td>
		<td class='table_td' colspan="3">
			<html:text name="Eamb0101Form" property="startIssueDate" maxlength="7" size="30"/>
			 �� 
			<html:text name="Eamb0101Form" property="endIssueDate" maxlength="7" size="30"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�v�I���</td>
		<td class='table_td' colspan="3">
			<html:text name="Eamb0101Form" property="startRepayDate" maxlength="7" size="30"/>
			 �� 
			<html:text name="Eamb0101Form" property="endRepayDate" maxlength="7" size="30"/>
		</td>
	</tr>	
	<tr>
		<td class='table_item'>������</td>
		<td class='table_td' colspan="3">
			<html:text name="Eamb0101Form" property="startDueDate" maxlength="7" size="30"/>
			 �� 
			<html:text name="Eamb0101Form" property="endDueDate" maxlength="7" size="30"/>
		</td>
	</tr>
	<c:if test='${sessionScope.debtTypeCode eq "A"}'>
		<tr>
			<td class='table_item'>�ഫ���</td>
			<td class='table_td' colspan="3">
				<html:text name="Eamb0101Form" property="startExchangeDate" maxlength="7" size="30"/>
			 	�� 
				<html:text name="Eamb0101Form" property="endExchangeDate" maxlength="7" size="30"/>
			</td>
		</tr>
	</c:if>
	<c:if test='${sessionScope.debtTypeCode eq "A"}'>
		<tr>
			<td class='table_item'>�o��Φ�</td>
			<td class='table_td' colspan="3">
				<html:select name="Eamb0101Form" property="issueKind">
					<html:option value="">�п��</html:option>
					<html:option value="0">�n��</html:option>
					<html:option value="1">�Ų�</html:option>
				</html:select>
			</td>
		</tr>
		<c:if test='${(sessionScope.voucherType eq 3) or (sessionScope.voucherType eq 4) }'>
			<tr>
				<td class='table_item'>����O�}�����O</td>
				<td class='table_td' colspan="3">
					<html:select name="Eamb0101Form" property="chargeType">
						<html:option value="1">���I����O�ǲ�</html:option>
						<html:option value="2">�v�I����O�ǲ�</html:option>
					</html:select>
				</td>
			</tr>
		</c:if>
	</c:if>
</table>
