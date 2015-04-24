<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<html:hidden name='Bima0101Form' property='id'/>
<html:hidden name='Bima0101Form' property='issueSerial'/>

<input type='hidden' name='Add' value='Y'>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='15%'><font color="red">*</font>發行年度</td>
		<td class='table_td'>
			<html:text name='Bima0101Form' property='accountYear' size='3' maxlength='3' onblur="getIssueSerial(this.form.accountYear.value,'B');"/>
		</td>
		<td class='table_item' width='15%'><font color="red">*</font>期次</td>
		<td class='table_td'>
			<html:text name='Bima0101Form' property='serialNo' size='2' maxlength='2' onblur="getDebtName(this.form);"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>預算別</td>
		<td class='table_td'>
			<!-- 連動方法說明: getDebtCode(this.form.budgetCode.value,'debtCode') 
				參數1預算別的值,參數2為債務別選單的名稱
			-->
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode","1","","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
		<td class='table_item'><font color="red">*</font>債務別</td>
		<td class='table_td'>
		<!-- 讓service去撈沒用的資料 -->
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(1),"debtCode","24",false)%>
		</td>
	</tr>
	</tr>
	<tr>
		<td class='table_item'>國庫券名稱</td>
		<td class='table_td' colspan='3'>
			<html:text name='Bima0101Form' property='debtName' size='60' maxlength='120' />
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>國庫券型式</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("IK"),"issueKind",10,false)%>
		</td>
		<td class='table_item'><font color="red">*</font>發行日期</td>
		<td class='table_td'>
			<html:text name='Bima0101Form' property='date(issueDate)' size='8' maxlength='7' onblur="getDays(this.form)" />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(issueDate)",new Integer(0))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>到期日期</td>
		<td class='table_td'>
			<html:text name='Bima0101Form' property='date(dueDate)' size='8' maxlength='7' onblur="getDays(this.form)"/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(dueDate)",new Integer(1))%>
		</td>
		<td class='table_item'>發行天數</td>
		<html:hidden name='Bima0101Form' property='days'/>
		<td class='table_td' id="dayid">
			
			<bean:write name='Bima0101Form' property='days' />
		</td>
	</tr>
	<tr>
		<td class='table_item'>有效兌付日期</td>
		<td class='table_td'>
			<html:text name='Bima0101Form' property='date(cashDueDate)' size='8' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(cashDueDate)",new Integer(2))%>
		</td>
		<td class='table_item'><font color="red">*</font>發行額</td>
		<td class='table_td'>
			<html:text name='Bima0101Form' property='bigDecimal(expectAmount)' size='20' maxlength='20' onblur="checkCapitalAmount(this.form);"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>實收額</td>
		<td class='table_td'>
			<html:text name='Bima0101Form' property='bigDecimal(realAmount)' size='20' maxlength='20' onblur="checkCapitalAmount(this.form);"/>
		</td>
		<td class='table_item'>到期兌付金額</td>
		<td class='table_td'>
			<div id='issueAmount'><bean:write name='Bima0101Form' property='bigDecimal(issueAmount)' format="#,###"/></div>
			<html:hidden name='Bima0101Form' property='bigDecimal(issueAmount)'/>			
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>貼現率</td>
		<td class='table_td'>
			<html:text name='Bima0101Form' property='bigDecimal(averageRate)' size='13' maxlength='13'/>%
		</td>
		<td class='table_item'><font color="red">*</font>手續費比例</td>
		<td class='table_td'>
			<html:text name='Bima0101Form' property='bigDecimal(chargeRate)' size='13' maxlength='13'/><img src="../assets/images/thousandth.gif" border="0" align="absmiddle" width="26" height="26"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>標售狀況</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("SS"),"sellStatus",10,false)%>
		</td>
		<td class='table_item'>落標金額</td>
		<td class='table_td'>
			<html:text name='Bima0101Form' property='bigDecimal(sellAmount)' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>種類</td>
		<td class='table_td' colspan="3">
			<logic:empty name='Bima0101Form' property='bondType' >
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("BT2"),"bondType",10,false)%>
			</logic:empty>
			<logic:notEmpty name='Bima0101Form' property='bondType' >
				<bean:define id ='bondType' name='Bima0101Form' property='bondType' type='java.lang.String'/>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("BT2"),"bondType",bondType,10,false)%>
			</logic:notEmpty>
		</td>
	</tr>
	<tr>
		<td class='table_item'>備註</td>
		<td class='table_td' colspan="3">
			<html:text name='Bima0101Form' property='remark' size='60' maxlength='120'/>
		</td>
	</tr>
</table>
