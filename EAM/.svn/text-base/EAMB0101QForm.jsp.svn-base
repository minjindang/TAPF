<!-- EAMB0101QForm.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>發行年度</td>
		<td class='table_td'>
			<html:text name="Eamb0101Form" property="accountYear" maxlength="5" size="30"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行月份</td>
		<td class='table_td'>
			<html:text name="Eamb0101Form" property="month" maxlength="5" size="30"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>期次</td>
		<td class='table_td' colspan="3">
			<html:text name="Eamb0101Form" property="serialNo" maxlength="5" size="30"/>	
		</td>
	</tr>
	<tr>
		<td class='table_item'>預算別</td>
		<td class='table_td' colspan="3">
			<html:select name="Eamb0101Form" property="budgetCode" >
				<html:option value="">  全部預算別   </html:option>
				<html:optionsCollection name="Eamb0101Form" property="allBudgetCode" label="budgetName" value="id"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>債務別</td>
		<td class='table_td'>
			<html:select name="Eamb0101Form" property="debtCode" >
				<html:option value="">  全部債務別    </html:option>
				<html:optionsCollection name="Eamb0101Form" property="allDebtCode" label="debitName" value="id"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>債務名稱</td>
		<td class='table_td' colspan="3">
			<html:text name="Eamb0101Form" property="debtName" maxlength="30" size="30"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行日期</td>
		<td class='table_td' colspan="3">
			<html:text name="Eamb0101Form" property="startIssueDate" maxlength="7" size="30"/>
			 至 
			<html:text name="Eamb0101Form" property="endIssueDate" maxlength="7" size="30"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>償付日期</td>
		<td class='table_td' colspan="3">
			<html:text name="Eamb0101Form" property="startRepayDate" maxlength="7" size="30"/>
			 至 
			<html:text name="Eamb0101Form" property="endRepayDate" maxlength="7" size="30"/>
		</td>
	</tr>	
	<tr>
		<td class='table_item'>到期日期</td>
		<td class='table_td' colspan="3">
			<html:text name="Eamb0101Form" property="startDueDate" maxlength="7" size="30"/>
			 至 
			<html:text name="Eamb0101Form" property="endDueDate" maxlength="7" size="30"/>
		</td>
	</tr>
	<c:if test='${sessionScope.debtTypeCode eq "A"}'>
		<tr>
			<td class='table_item'>轉換日期</td>
			<td class='table_td' colspan="3">
				<html:text name="Eamb0101Form" property="startExchangeDate" maxlength="7" size="30"/>
			 	至 
				<html:text name="Eamb0101Form" property="endExchangeDate" maxlength="7" size="30"/>
			</td>
		</tr>
	</c:if>
	<c:if test='${sessionScope.debtTypeCode eq "A"}'>
		<tr>
			<td class='table_item'>發行形式</td>
			<td class='table_td' colspan="3">
				<html:select name="Eamb0101Form" property="issueKind">
					<html:option value="">請選擇</html:option>
					<html:option value="0">登錄</html:option>
					<html:option value="1">債票</html:option>
				</html:select>
			</td>
		</tr>
		<c:if test='${(sessionScope.voucherType eq 3) or (sessionScope.voucherType eq 4) }'>
			<tr>
				<td class='table_item'>手續費開立類別</td>
				<td class='table_td' colspan="3">
					<html:select name="Eamb0101Form" property="chargeType">
						<html:option value="1">撥付手續費傳票</html:option>
						<html:option value="2">償付手續費傳票</html:option>
					</html:select>
				</td>
			</tr>
		</c:if>
	</c:if>
</table>
