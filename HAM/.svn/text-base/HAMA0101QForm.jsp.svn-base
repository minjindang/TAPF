<!--
程式目的：受分配單位資料維護
程式代號：HAMA01
程式日期：0950218
程式作者：JackDu
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' colspan="20%">受分配單位代號</td>
		<td class='table_td' colspan="80%">
			<html:text name='Hama0101Form' property='qryUnit' size='20' maxlength='10'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' colspan="20%">受分配單位名稱</td>
		<td class='table_td' colspan="80%">
			<logic:notEmpty name="Hama0101Form" property='qryUnitId'>
				<bean:define id="qryUnitId" name="Hama0101Form" property="qryUnitId" type="java.lang.String"/>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.central.common.UnitInfo.getUnitInfoMain(),"qryUnitId",qryUnitId,10,false)%>
			</logic:notEmpty>
			<logic:empty name="Hama0101Form" property='qryUnitId'>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.central.common.UnitInfo.getUnitInfoMain(),"qryUnitId",10,false)%>
			</logic:empty>
		</td>
	</tr>
	<tr>
		<td class='table_item' colspan="20%">分配年度</td>
		<td class='table_td' colspan="80%">
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.central.common.UnitPercent.getYearLabelList(),"qryTyear",10,false)%>
		</td>
	</tr>
</table>