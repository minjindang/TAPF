<!-- CIMA0101MForm.jsp
程式目的：CIMA01
程式代號：CIMA01
程式日期：0950306
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
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
		<td class='table_item'><font color="red">*</font>預算年度</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' property='budgetYear' maxlength='3' size='5' />
		</td>
	</tr>	
	<tr>
		<td class='table_item'><font color="red">*</font>預算別</td>
		<td class='table_td'>
			<html:select name='Cima0101Form' property='budgetCodeDebt' onchange="changeValue(this.form)">
					<html:option value="0">請選擇</html:option>
					<html:optionsCollection name="Cima0101Form" property="budgetList" label="budgetName" value="id"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>債務別</td>
		<td class='table_td'>
			<html:select name='Cima0101Form' property='debtCodeDebt' >
					<html:option value="0">請選擇</html:option>
					<logic:notEmpty name="Cima0101Form" property="debtList">
						<html:optionsCollection name="Cima0101Form" property="debtList" label="debitName" value="id"/>
					</logic:notEmpty>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>銀行編號<br><font color="red">*</font>銀行名稱</br></td>
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
		<td class='table_item'><font color="red">*</font>比價金額</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' style="text-align: right" property='bigDecimal(compareAmount)' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>利率</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' style="text-align: right" property='bigDecimal(compareRate)' size='20' maxlength='20' onmousemove="rateLimit(this.form)"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>得標金額</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' style="text-align: right" property='bigDecimal(issueAmountDet)' size='20' maxlength='50' onblur="changeAmount(this.form)"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>利息</td>
		<td class='table_td'>
			<p align="right"><bean:write name='Cima0101Form' property='bigDecimal(originInterestAmount)' format='#,##0'/></p>
		</td>
	</tr>
	<html:hidden name='Cima0101Form' property='bigDecimal(originInterestAmount)'/>
	<tr>
		<td class='table_item' width="25%">本息合計</td>
		<td class='table_td' width="15%" id="totalAmountid" align="right">
			<p align="right"><bean:write name='Cima0101Form' property='bigDecimal(totalAmount)'/></p>
		</td>
		<td width="60%"></td>
	</tr>
	<html:hidden name='Cima0101Form' property='bigDecimal(totalAmount)'/>	
</table>
