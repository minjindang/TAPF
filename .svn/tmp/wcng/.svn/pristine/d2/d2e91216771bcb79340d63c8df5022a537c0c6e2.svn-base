<!-- CIMA0101QForm.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>年度</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' property='qryaccountYear' size='3' maxlength='3' onblur="changeYear(this.form);"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>期次</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' property='qryserialNo' size='3' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>期別</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' property='qryissueSerial' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>名稱</td>
		<td class='table_td'>
			<html:select name='Cima0101Form' property='qrydebtName'>
					<html:option value="">請選擇</html:option>
					<html:optionsCollection name="Cima0101Form" property="qryDebtNameList" 
					label="label" value="valuess"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>比價類別</td>
		<td class='table_td'>
			<html:select name='Cima0101Form' property='issueKind'>
				<html:option value="">請選擇</html:option>
				<html:optionsCollection  name="Cima0101Form" property="issueKindList" value="codeNo" label="codeName"/>
			</html:select>	
		</td>
	</tr>
	<tr>
		<td class='table_item'>預算別</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode","1","","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>債務別</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(new Integer(1)),"debtCode",false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>自償否</td>
		<td class='table_td'>
			<html:select name='Cima0101Form' property='bondType'>
					<html:option value="">請選擇</html:option>
					<html:option value="1">是</html:option>
					<html:option value="2">否</html:option>
			</html:select>
		</td>
	</tr>	
</table>
