<!--
程式目的：HAMB12文字
程式代號：HAMB12
程式日期：1000929
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
			<bean:write name="Hamb1201Form" property="qryAllYear"/>
		</td>
		<td class='table_item' width='20%'>本次撥付</td>
		<td class='table_td' width='30%'>
			<bean:write name="Hamb1201Form" property="qryTotal" format='#,##0'/>元
		</td>
	</tr>
	<tr>
		<td class='table_item'>分配年月</td>
		<td class='table_td' colspan='3'>
			<bean:write name="Hamb1201Form" property="qryAllMonth" />
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
					<bean:define id="qryAllYear" name="Hamb1201Form" property="qryAllYear" type="java.lang.String"/>
					<bean:define id="qryAllMonth" name="Hamb1201Form" property="qryAllMonth" type="java.lang.String"/>
					<bean:define id="qryUnitId" name="Hamb1201Form" property="qryUnitId" type="java.lang.String"/>
					<bean:define id="qryUnitName" name="Hamb1201Form" property="qryUnitName" type="java.lang.String"/>
					<bean:define id="unitFinancial" name="row" property="unitInfo"  type="tw.gov.nta.sql.UnitInfoMain"/>
					<bean:define id="srcMoney" name="row" property="srcMoney"  type="java.math.BigDecimal"/>
					<bean:define id="pageL" name="Hamb1201Form" property="page" type="java.lang.Integer"/>
					<%
						java.math.BigDecimal financial = tw.gov.nta.central.common.UnitPercent101.getByYear(unitFinancial,qryAllYear).getFinancial();
						java.text.NumberFormat formatter = new java.text.DecimalFormat("#,###");
						java.util.Map paramMap = new java.util.HashMap();
							paramMap.put("id",id);
							paramMap.put("qryAllYear",qryAllYear);
							paramMap.put("qryAllMonth",qryAllMonth);
							paramMap.put("qryUnitId",qryUnitId);
							paramMap.put("qryUnitName",java.net.URLEncoder.encode(qryUnitName));
							paramMap.put("page",pageL);
							paramMap.put("unitInfoId",unitInfoId);
							paramMap.put("financial",(financial != null && !financial.toString().equals("0E-16"))?formatter.format(financial.divide(new java.math.BigDecimal(12),0,java.math.BigDecimal.ROUND_HALF_UP)):"0");
							paramMap.put("unitInfoId",unitInfoId);
						pageContext.setAttribute("paramMap", paramMap);
					%>
					<html:link action='/HAMB1205' name='paramMap'>
						<bean:write name="row" property="unitInfo.unitName"/>
					</html:link>
				</display:column>
				<display:column title="按公式分配金額">
					<bean:write name="row" property="srcMoney" format='#,###'/>
				</display:column>
				<display:column title="財源保障彌補金額">
					<bean:define id="unitFinancial" name="row" property="unitInfo"  type="tw.gov.nta.sql.UnitInfoMain"/>
					<bean:define id="qryAllYear" name="Hamb1201Form" property="qryAllYear" type="java.lang.String"/>
					<%
						java.math.BigDecimal financial = tw.gov.nta.central.common.UnitPercent101.getByYear(unitFinancial,qryAllYear).getFinancial();
						java.text.NumberFormat formatter = new java.text.DecimalFormat("#,###");
						out.print((financial != null && !financial.toString().equals("0E-16"))?formatter.format(financial.divide(new java.math.BigDecimal(12),0,java.math.BigDecimal.ROUND_HALF_UP)):"0");
					%>
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
