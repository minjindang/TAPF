<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='15%'><font color="red">*</font>年度</td>
		<td class='table_td'>
			<html:text name='Gama0501Form' property='accountYear' size='3' maxlength='3' onblur="change(this.form,'A');"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>預算別</td>
		<td class='table_td'>
			<logic:empty name='Gama0501Form' property='budgetCode' >
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode","","","getDebtCode(this.form.budgetCode.value,'debtCode');change(this.form,'A');",10,false)%>
			</logic:empty>
			<logic:notEmpty name='Gama0501Form' property='budgetCode' >
				<bean:define id='budgetCode' name='Gama0501Form' property='budgetCode' type='java.lang.Integer'/>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode",budgetCode.toString(),"","getDebtCode(this.form.budgetCode.value,'debtCode');change(this.form,'A');",10,false)%>
			</logic:notEmpty>
		</td>
	</tr>
	<tr>
		<td class='table_item' width='20%'><font color="#ff0000">*</font>債務別</td>
		<td class='table_td'>
			<logic:empty name='Gama0501Form' property='debtCode' >
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(0),"debtCode","","","change(this.form,'A');",10,false)%>
			</logic:empty>
			<logic:notEmpty name='Gama0501Form' property='budgetCode' >
				<logic:notEmpty name='Gama0501Form' property='budgetCode' >
					<bean:define id='budgetCode' name='Gama0501Form' property='budgetCode' type='java.lang.Integer'/>
					<bean:define id='debtCode' name='Gama0501Form' property='debtCode' type='java.lang.Integer'/>
					<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(budgetCode),"debtCode",debtCode.toString(),"","change(this.form,'A');",10,false)%>
				</logic:notEmpty>
			</logic:notEmpty>
		</td>
	</tr>
	<tr>
		<td class='table_item' width='20%'><font color="#ff0000">*</font>自償否</td>
		<td class='table_td'>
			<logic:empty name='Gama0501Form' property='boundCode' >
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("BT"),"boundCode","","","change(this.form,'A');",10,false)%>
			</logic:empty>
			<logic:notEmpty name='Gama0501Form' property='boundCode' >
				<bean:define id='boundCode' name='Gama0501Form' property='boundCode' type='java.lang.String'/>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("BT"),"boundCode",boundCode,"","change(this.form,'A');",10,false)%>
			</logic:notEmpty>
		</td>
	</tr>
	<tr>
		<td class='table_item' width='20%'><font color="#ff0000">*</font>內外債別</td>
		<td class='table_td'>
			<logic:empty name='Gama0501Form' property='inoutType' >
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("IO"),"inoutType","","","change(this.form,'A');",10,false)%>
			</logic:empty>
			<logic:notEmpty name='Gama0501Form' property='inoutType' >
				<bean:define id='inoutType' name='Gama0501Form' property='inoutType' type='java.lang.String'/>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("IO"),"inoutType",inoutType,"","change(this.form,'A');",10,false)%>
			</logic:notEmpty>
		</td>
	</tr>
	<tr>
		<td class='table_item' width='20%'>統計決算數</td>
		<td class='table_td'>
			<logic:notEmpty name="Gama0501Form" property="accountType">
				<bean:define id="accountType" name="Gama0501Form" property="accountType" type="java.lang.String"/>
				<input type="checkbox" name="accountType" <%="Y".equals(accountType)?"checked":"N"%>/>
			</logic:notEmpty>	
			<logic:empty name="Gama0501Form" property="accountType">
				<input type="checkbox" name="accountType" checked="checked" value="Y"/>
			</logic:empty>
		</td>
	</tr>
</table>

<table class='table_1' width='100%'>

	<tr>
		<td class='table_item' colspan='10'><hr/></td>
	</tr>
	<tr>
		<td class='table_item' rowspan='2'>預<br>算<br>數</td>
		<td class='table_item'>公債</td>
		<td class='table_item'>非排限</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(budgetUamount1)' size='20' maxlength='20' onkeyup=""/></td>
		<td class='table_item'>排限</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(budgetBamount1)' size='20' maxlength='20' onkeyup=""/></td>
		<td class='table_item'>還款<br>金額</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(budgetPamount1)' size='20' maxlength='20' onkeyup=""/></td>
		<td class='table_item'>未償還<br>餘額</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(budgetRamount1)' size='20' maxlength='20' onkeyup=""/></td>
	</tr>
	<tr>
		<td class='table_item'>中長期<br>借款</td>
		<td class='table_item'>非排限</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(budgetUamount2)' size='20' maxlength='20' onkeyup=""/></td>
		<td class='table_item'>排限</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(budgetBamount2)' size='20' maxlength='20' onkeyup=""/></td>
		<td class='table_item'>還款<br>金額</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(budgetPamount2)' size='20' maxlength='20' onkeyup=""/></td>
		<td class='table_item'>未償還<br>餘額</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(budgetRamount2)' size='20' maxlength='20' onkeyup=""/></td>
	</tr>
	<tr>
		<td class='table_item' colspan='10'><hr/></td>
	</tr>
	<tr>
		<td class='table_item' rowspan='2'>決<br>算<br>數</td>
		<td class='table_item'>公債</td>
		<td class='table_item'>非排限</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(auditUamount1)' size='20' maxlength='20' onkeyup=""/></td>
		<td class='table_item'>排限</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(auditBamount1)' size='20' maxlength='20' onkeyup=""/></td>
		<td class='table_item'>還款<br>金額</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(auditPamount1)' size='20' maxlength='20' onkeyup=""/></td>
		<td class='table_item'>未償還<br>餘額</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(auditRamount1)' size='20' maxlength='20' onkeyup=""/></td>
	</tr>
	<tr>
		<td class='table_item'>中長期<br>借款</td>
		<td class='table_item'>非排限</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(auditUamount2)' size='20' maxlength='20' onkeyup=""/></td>
		<td class='table_item'>排限</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(auditBamount2)' size='20' maxlength='20' onkeyup=""/></td>
		<td class='table_item'>還款<br>金額</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(auditPamount2)' size='20' maxlength='20' onkeyup=""/></td>
		<td class='table_item'>未償還<br>餘額</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(auditRamount2)' size='20' maxlength='20' onkeyup=""/></td>
	</tr>
	<tr>
		<td class='table_item' colspan='10'><hr/></td>
	</tr>
	<tr>
		<td class='table_item' rowspan='4'>實<br>際<br>數</td>
		<td class='table_item' rowspan='2'>公債</td>
		<td class='table_item'>非排限</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(realUamount1)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
		<td class='table_item'>排限</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(realBamount1)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
		<td class='table_item'>還款<br>金額</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(realPamount1)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
		<td class='table_item'>未償還<br>餘額</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(realRamount1)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
	</tr>
	<tr>
		<td class='table_item'>總數</td>
		<td class='table_td' colspan='7'><html:text name='Gama0501Form' property='bigDecimal(realBuamount1)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
	</tr>
	<tr>
		<td class='table_item' rowspan='2'>中長期<br>借款</td>
		<td class='table_item'>非排限</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(realUamount2)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
		<td class='table_item'>排限</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(realBamount2)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
		<td class='table_item'>還款<br>金額</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(realPamount2)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
		<td class='table_item'>未償還<br>餘額</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(realRamount2)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
	</tr>
	<tr>
		<td class='table_item'>總數</td>
		<td class='table_td' colspan='7'><html:text name='Gama0501Form' property='bigDecimal(realBuamount2)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
	</tr>
	<tr>
		<td class='table_item' colspan='10'><hr/></td>
	</tr>
	<tr>
		<td class='table_item' rowspan='2'>保<br>留<br>數</td>
		<td class='table_item'>公債</td>
		<td class='table_item'>非排限</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(keepUamount1)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
		<td class='table_item'>排限</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(keepBamount1)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
		<td class='table_item'>還款<br>金額</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(keepPamount1)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
		<td class='table_item'>未償還<br>餘額</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(keepRamount1)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
	</tr>
	<tr>
		<td class='table_item'>中長期<br>借款</td>
		<td class='table_item'>非排限</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(keepUamount2)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
		<td class='table_item'>排限</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(keepBamount2)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
		<td class='table_item'>還款<br>金額</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(keepPamount2)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
		<td class='table_item'>未償還<br>餘額</td>
		<td class='table_td'><html:text name='Gama0501Form' property='bigDecimal(keepRamount2)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
	</tr>
	<tr>
		<td class='table_item' colspan='10'><hr/></td>
	</tr>
</table>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='15%'>備註</td>
		<td class='table_td'>
			<html:text name='Gama0501Form' property='remark' size='80' maxlength='200' />
		</td>
	</tr>
</table>