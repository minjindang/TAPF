<!--
程式目的：HAMB04文字
程式代號：HAMB04
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

<html:hidden name='Hamb0401Form' property='monKind'/>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' colspan="20%">*記帳年度</td>
		<td class='table_td' colspan="80%">
			<bean:define id = 'qryAllYear' name = 'Hamb0401Form' property = 'qryAllYear' type='java.lang.String'/>
			<html:select name="Hamb0401Form" property="qryAllYear" onchange="form.action='HAMC04'; form.submit();">
				<html:optionsCollection name="Hamb0401Form" property="qryAllYearList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item' colspan="20%">*分配年月</td>
		<td class='table_td' colspan="80%">
			<bean:define id = 'qryAllMonth' name = 'Hamb0401Form' property = 'qryAllMonth' type='java.lang.String'/>
			<html:select name="Hamb0401Form" property="qryAllMonth">
				<html:optionsCollection name="Hamb0401Form" property="qryAllMonthList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	
	<tr>
		<td class='table_item' colspan="20%">受分配單位代號</td>
		<td class='table_td' colspan="80%">
			<html:text name='Hamb0401Form' property='qryUnitId' size='10' maxlength='7'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' colspan="20%">受分配單位</td>
		<td class='table_td' colspan="80%">
		
			<logic:notEmpty name="Hamb0401Form" property='qryUnitName'>
					<bean:define id="qryUnitName" name="Hamb0401Form" property="qryUnitName" type="java.lang.String"/>
					<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.central.common.UnitInfo.getUnitName(),"qryUnitName",qryUnitName,10,false)%>
			</logic:notEmpty>
			<logic:empty name="Hamb0401Form" property='qryUnitName'>
					<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.central.common.UnitInfo.getUnitName(),"qryUnitName",10,false)%>
			</logic:empty>
		</td>
	</tr>
</table>
