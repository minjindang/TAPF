<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<html:hidden name='Bima0101Form' property='id'/>
<html:hidden name='Bima0101Form' property='issueSerial'/>
<html:hidden name='Bima0101Form' property='qrydebtCode'/>
<html:hidden name='Bima0101Form' property='qrybudgetCode'/>
<html:hidden name='Bima0101Form' property='qryaccountYear'/>
<html:hidden name='Bima0101Form' property='qrydebtName'/>
<html:hidden name='Bima0101Form' property='debtType'/>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='15%'><font color="red">*</font>發行年度</td>
		<td class='table_td'>
			<html:text name='Bima0101Form' property='accountYear' size='3' readonly='true' />
		</td>
		<td class='table_item' width='15%'><font color="red">*</font>期次</td>
		<td class='table_td'>
			<html:text name='Bima0101Form' property='serialNo' size='2' readonly='true' />
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>預算別</td>
		<td class='table_td'>
			<bean:define id='budgetCode' name='Bima0101Form' property='budgetCode' type="java.lang.Integer"/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode",(budgetCode).toString(),"","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
		<td class='table_item'><font color="red">*</font>債務別</td>
		<td class='table_td'>
			<bean:define id='debtCode' name='Bima0101Form' property='debtCode' type="java.lang.Integer"/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(),"debtCode",(debtCode).toString(),false)%>
		</td>
	</tr>
	
	<tr>
		<td class='table_item'>國庫券名稱</td>
		<td class='table_td' colspan='3'>
			<html:text name='Bima0101Form' property='debtName' size='60' maxlength='120' />
		</td>
	</tr>
	<tr>
		<td class='table_item'>國庫券型式</td>
		<td class='table_td'>
			<bean:define id='issueKind' name='Bima0101Form' property='issueKind' type="java.lang.String"/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("IK"),"issueKind",issueKind,false)%>
		</td>
		<td class='table_item'><font color="red">*</font>發行日期</td>
		<td class='table_td'>
			<html:text name='Bima0101Form' property='date(issueDate)' size='8' maxlength='7' onblur="getDays()"/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(issueDate)",new Integer(0))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>到期日期</td>
		<td class='table_td'>
			<html:text name='Bima0101Form' property='date(dueDate)' size='8' maxlength='7' onblur="getDays()"/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(dueDate)",new Integer(1))%>
		</td>
		<td class='table_item'>發行天數</td>
		<td class='table_td' id="dayid">
			<html:hidden name='Bima0101Form' property='days'/>
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
			<html:text name='Bima0101Form' property='bigDecimal(expectAmount)' size='20' maxlength='20' />
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>實收額</td>
		<td class='table_td'>
			<html:text name='Bima0101Form' property='bigDecimal(realAmount)' size='20' maxlength='20' />
		</td>
		<td class='table_item'>到期兌付金額</td>		
		<td class='table_td' id="issueAmount" colspan="3">
			<html:hidden name='Bima0101Form' property='bigDecimal(issueAmount)'/>
			<bean:write name='Bima0101Form' property='bigDecimal(issueAmount)' format="#,###"/>
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
		<bean:define id='sellStatus' name='Bima0101Form' property='sellStatus' type="java.lang.String"/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("SS"),"sellStatus",sellStatus,false)%>
		</td>
		<td class='table_item'>落標金額</td>
		<td class='table_td'>
			<html:text name='Bima0101Form' property='bigDecimal(sellAmount)' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>最新更正日期</td>
		<td class='table_td'>
			<script language="Javascript">
			    document.write(addDateMask("<bean:write name='Bima0101Form' property='modDate' />"));
			</script>
		</td>
		<td class='table_item'>建檔日期</td>
		<td class='table_td'>
			<script language="Javascript">
			    document.write(addDateMask("<bean:write name='Bima0101Form' property='createDate' />"));
			</script>
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
