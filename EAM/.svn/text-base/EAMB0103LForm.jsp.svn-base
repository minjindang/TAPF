<!--
程式目的：AIMA01文字
程式代號：AIMA01
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

<table class='table_1'>
<tr>
	<th class='table_item'>科目代號</th>
	<th class='table_item'>科目名稱</th>
	<th class='table_item'>借方金額</th>
	<th class='table_item'>貸方金額</th>
</tr>
<logic:iterate id="detail" name="Eamb0103Form" property="voucherDets">
	<tr>
		<td class='table_td'>
			<bean:write name="detail" property="account.accountCode"/>
		</td>
		<td class='table_td'>
			<bean:write name="detail" property="account.accountName"/>
		</td>
		<td class='table_td'>
			<div align="right">
				<logic:equal value="D" name="detail" property="accountType">
					<bean:write name="detail" property="accountAmount" format="#,###"/>
				</logic:equal> 	　
			</div>
			　
		</td>
		<td class='table_td'>
			<div align="right">
				<logic:equal value="C" name="detail" property="accountType">
					<bean:write name="detail" property="accountAmount" format="#,###"/>
				</logic:equal> 
			</div>
			　
		</td>
	</tr>
</logic:iterate>
</table>
