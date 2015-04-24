<!--
程式目的：HAMB07文字
程式代號：HAMB07
程式日期：0950223
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
<html:hidden name="Hamb0701Form" property="monKind" value="1"/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' colspan="20%"><font color="red">*</font>記帳年度</td>
		<td class='table_td' colspan="80%">
			<html:select name="Hamb0701Form" property="qryallYear" onchange="form.action='HAMB07'; form.submit();">
				<html:option value="">請選擇</html:option>
				<html:optionsCollection name="Hamb0701Form" property="qryAllYearList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item' colspan="20%">撥款年月</td>
		<td class='table_td' colspan="80%">
			<html:select name="Hamb0701Form" property="qryallMonth">
				<html:option value="">請選擇</html:option>
				<html:optionsCollection name="Hamb0701Form" property="qryAllMonthList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item' colspan="20%">受分配單位代號</td>
		<td class='table_td' colspan="80%">
			<html:text name='Hamb0701Form' property='qryunitId' size='10' maxlength='7'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' colspan="20%">受分配單位</td>
		<td class='table_td' colspan="80%">
		
			<logic:notEmpty name="Hamb0701Form" property='qryunitName'>
					<bean:define id="qryunitName" name="Hamb0701Form" property="qryunitName" type="java.lang.String"/>
					<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.central.common.UnitInfo.getUnitName(),"qryunitName",qryunitName,10,false)%>
			</logic:notEmpty>
			<logic:empty name="Hamb0701Form" property='qryunitName'>
					<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.central.common.UnitInfo.getUnitName(),"qryunitName",10,false)%>
			</logic:empty>
		
		</td>
	</tr>
</table>
