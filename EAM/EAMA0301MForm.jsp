<!--
程式目的：EAMA01文字
程式代號：EAMA01
程式日期：0950306
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>


<html:hidden name='Eama0301Form' property='debtMain.id' />
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>公債代號</td>
            <td class='table_td'>
			<bean:write name="Eama0301Form" property="debtSerial"/>
		</td>

		<td class='table_item'>公債識別碼</td>
		<td class='table_td'>
			<bean:write name="Eama0301Form" property="issue.bondType"/>
		</td>
		<td class='table_item'>預算別</td>
		<td class='table_td'>
			<bean:write name="Eama0301Form" property="budgetCode"/>
		</td>
		
		<td class='table_item'>債務別	</td>
		<td class='table_td'>		
			<bean:write name="Eama0301Form" property="debtCode"/>
		</td>
	</tr>

	<tr>
		<td class='table_item'>發行年度</td>
		<td class='table_td'>	
			<bean:write name="Eama0301Form" property="issue.accountYear"/>
		</td>		
		<td class='table_item'>發行期次</td>
		<td class='table_td'>
			<bean:write name="Eama0301Form" property="issue.serialNo"/>
		</td>
		<td class='table_item'>公債發行種類</td>
		<td class='table_td'>
			<bean:write name="Eama0301Form" property="bondKind"/>
		</td>
		<td class='table_item'>發行形式</td>
		<td class='table_td'>
			<bean:write name="Eama0301Form" property="issueKind"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>
        	公債名稱 
		</td>
		<td class='table_td' colspan="7">
        	<bean:write name="Eama0301Form" property="issue.debtName"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行日期</td>
		<td class='table_td'>
			<bean:write name="Eama0301Form" property="issue.issueDate" format="yyyy/MM/dd" />
		</td>
		<td class='table_item'>期限</td>
		<td class='table_td'>
			<bean:write name='Eama0301Form' property='issue.issueInterval'/>年
		</td>
		<td class='table_item'>到期日</td>
		<td class='table_td'>
			<bean:write name='Eama0301Form' property='issue.dueDate' format="yyyy/MM/dd" />
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行額</td>
		<td class='table_td'>
			<bean:write name="Eama0301Form" property="issueAmount" format="#,###.##"/>		
		</td>
		
		<td class='table_item'>實收額</td>
		<td class='table_td'>
			<bean:write name="Eama0301Form" property="realAmount" format="#,###.##"/>		
		</td>
		
		<td class='table_item'>溢(折)價金額</td>
		<td class='table_td'>
			<bean:write name="Eama0301Form" property="diversityAmount" format="#,###.##"/>	
		</td>
	</tr>
	<tr>
		<td class='table_item'>利率變動別</td>
		<td class='table_td'>
			<bean:write name='Eama0301Form' property='issue.rateKind'/>
		</td>
		<td class='table_item'>利率年息</td>
		<td class='table_td'>
			<bean:write name='Eama0301Form' property='issue.averageRate'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>首次付息日期</td>
		<td class='table_td'>
        	<bean:write name='Eama0301Form' property='issue.firstInterestDate' format="yyyy/MM/dd" />
  		</td>
		<td class='table_item'>付息次數</td>
		<td class='table_td'> 
        	<bean:write name="Eama0301Form" property="issue.interestAlternate"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>首次還本日期</td>
		<td class='table_td'>
       		<bean:write name='Eama0301Form' property='issue.firstRepayDate' format="yyyy/MM/dd" />
  		</td>
		<td class='table_item'>還本次數</td>
		<td class='table_td'>
        	<bean:write name="Eama0301Form" property='issue.repayAlternate'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>有效兌付期限</td>
		<td class='table_td'>
        	<bean:write name='Eama0301Form' property='issue.payLimit'/>年
  		</td>
		<td class='table_item'>截止兌付日期</td>
		<td class='table_td'>
			<bean:write name='Eama0301Form' property="issue.cashDueDate" format="yyyy/MM/dd" />
		</td>
	</tr>
	<tr>
		<td class='table_item'>預估應付利息</td>
		<td class='table_td'>
			<bean:write name='Eama0301Form' property="originInterestAmount" format="#,###.##" />
		</td>
		
		<td class='table_item'>增額應付利息金額</td>
		<td class='table_td'>
			<bean:write name='Eama0301Form' property="payableInterestAmount" format="#,###.##" />
		</td>
	</tr>
</table>
