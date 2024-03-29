<!--
程式目的：EAMA02文字
程式代號：EAMA02
程式日期：0950301
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

<html:hidden name="Eama0202Form" property="accountPhase.id"/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>會計科目名稱</td>
		<td class='table_td'>
			<html:select name='Eama0202Form' property="accountCode.id"  onchange="form.action='EAMA0211';form.submit();">
				<html:option value="">請選擇</html:option>
				<html:optionsCollection name="Eama0202Form" property="allAccountRef" label="accountName" value="id"/>
			</html:select>	
		</td>
	</tr>
	<tr>
		<td class='table_item'>會計科目代號</td>
		<td class='table_td'>
			<bean:write name="Eama0202Form" property="accountCode.accountCode"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>借/貸</td>
		<td class='table_td'>
			<html:radio name="Eama0202Form" property="accountType" value="D"/>借
			<html:radio name="Eama0202Form" property="accountType" value="C"/>貸
		</td>
	</tr>
	<tr>
		<td class='table_item'>備註</td>
		<td class='table_td'>
			<bean:write name="Eama0202Form" property="remark"/>
		</td>
	</tr>
	<tr>
	    <td>抓取公式</td>
		<td class="table_td">
			<html:text name="Eama0202Form" property="formula" size="50"/>
		</td>
	</tr>
</table>
