<!--
程式目的：核撥公債本息基金明細表(總表)
程式代號：APRA01
程式日期：0950308
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>還本付息日期</td>
		<td class='table_td'>
			<html:text name='Apra0101Form' property='date(repaySdate)' size='10' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(repaySdate)", new Integer(0))%>~
			<html:text name='Apra0101Form' property='date(repayEdate)' size='10' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(repayEdate)", new Integer(1))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>預算別</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode","","","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>甲類或乙類</td>
		<td class='table_td'>
			<html:select name="Apra0101Form" property="bondType">	
				<html:option value="">請選擇</html:option>
				<html:option value="1">甲類</html:option>	
				<html:option value="2">乙類</html:option>		
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>債務別</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(new Integer(0)),"debtCode",false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>報表種類</td>
		<td class='table_td'>
			<html:select name="Apra0101Form" property="reportType">
				<html:option value="1">核撥公債本息基金明細表</html:option>	
				<html:option value="2">核撥公債本息基金彙總表</html:option>		
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>是否顯示提前買回資訊</td>
		<td class='table_td'>
			<html:select name="Apra0101Form" property="display">
				<html:option value="1">是</html:option>	
				<html:option value="2">否</html:option>
			</html:select>
		</td>
	</tr>
</table>