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

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='20%'>記帳年度</td>
		<td class='table_td' width='30%'>
			<bean:write name="Hamb0401Form" property="qryAllYear"/>
		</td>
		<td class='table_item' width='20%'>本次撥付</td>
		<td class='table_td' width='30%'>
			<bean:write name="Hamb0401Form" property="qryTotal" format='#,##0'/>元
		</td>
	</tr>
	<tr>
		<td class='table_item'>分配年月</td>
		<td class='table_td' colspan='3'>
			<bean:write name="Hamb0401Form" property="qryAllMonth" />
		</td>
	</tr>
</table>

<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="受分配單位代號">
					<bean:write name="row" property="unitInfo.unitId"/>
				</display:column>
				<display:column title="受分配單位">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<bean:define id="unitInfoId" name="row" property="unitInfo.id" type="java.lang.Integer"/>
					<bean:define id="qryAllYear" name="Hamb0401Form" property="qryAllYear" type="java.lang.String"/>
					<bean:define id="qryAllMonth" name="Hamb0401Form" property="qryAllMonth" type="java.lang.String"/>
					<bean:define id="qryUnitId" name="Hamb0401Form" property="qryUnitId" type="java.lang.String"/>
					<bean:define id="qryUnitName" name="Hamb0401Form" property="qryUnitName" type="java.lang.String"/>
					<bean:define id="pageL" name="Hamb0401Form" property="page" type="java.lang.Integer"/>
					<%
						java.util.Map paramMap = new java.util.HashMap();
							paramMap.put("id",id);
							paramMap.put("qryAllYear",qryAllYear);
							paramMap.put("qryAllMonth",qryAllMonth);
							paramMap.put("qryUnitId",qryUnitId);
							paramMap.put("qryUnitName",java.net.URLEncoder.encode(qryUnitName));
							paramMap.put("page",pageL);
							paramMap.put("unitInfoId",unitInfoId);
						pageContext.setAttribute("paramMap", paramMap);
					%>
					<html:link action='/HAMB0405' name='paramMap'>
						<bean:write name="row" property="unitInfo.unitName"/>
					</html:link>
				</display:column>
				<display:column title="受分配金額">
					<bean:write name="row" property="srcMoney" format='#,###'/>
				</display:column>
				<display:column title="調減金額">
					<bean:write name="row" property="lastFound" format='#,###'/>
				</display:column>
				<display:column title="歸扣墊借款">
					<bean:write name="row" property="founda" format='#,###'/>
				</display:column>
				<display:column title="代扣地方建設基金">
					<bean:write name="row" property="foundb" format='#,###'/>
				</display:column>
				<display:column title="撥付金額">
					<bean:write name="row" property="nowFound" format='#,###'/>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
