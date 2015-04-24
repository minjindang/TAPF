<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@taglib uri="/tags/struts-bean" prefix="bean" %>
<%@taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>發行日期</td>
		<td class='table_td'>
			<html:text name='AccountQueryForm' property='date(startIssueDate)' size='7' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(startIssueDate)", new Integer(0))%>
		</td> 
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>預算別</td>
		<td class='table_td'>
			<!-- 連動方法說明: getDebtCode(this.form.budgetCode.value,'debtCode') 
				參數1預算別的值,參數2為債務別選單的名稱
			-->
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode","0","","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
	</tr>

	
</table>