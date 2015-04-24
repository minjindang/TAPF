<!--
�{���ت��GHAMB12��r
�{���N���GHAMB12
�{������G1000929
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='20%'>�O�b�~��</td>
		<td class='table_td' width='30%'>
			<bean:write name="Hamb1201Form" property="qryAllYear"/>
		</td>
		<td class='table_item' width='20%'>�������I</td>
		<td class='table_td' width='30%'>
			<bean:write name="Hamb1201Form" property="qryTotal" format='#,##0'/>��
		</td>
	</tr>
	<tr>
		<td class='table_item'>���t�~��</td>
		<td class='table_td' colspan='3'>
			<bean:write name="Hamb1201Form" property="qryAllMonth" />
		</td>
	</tr>
</table>

<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="�����t���N��">
					<bean:write name="row" property="unitInfo.unitId"/>
				</display:column>
				<display:column title="�����t���">
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
				<display:column title="���������t���B">
					<bean:write name="row" property="srcMoney" format='#,###'/>
				</display:column>
				<display:column title="�]���O�����ɪ��B">
					<bean:define id="unitFinancial" name="row" property="unitInfo"  type="tw.gov.nta.sql.UnitInfoMain"/>
					<bean:define id="qryAllYear" name="Hamb1201Form" property="qryAllYear" type="java.lang.String"/>
					<%
						java.math.BigDecimal financial = tw.gov.nta.central.common.UnitPercent101.getByYear(unitFinancial,qryAllYear).getFinancial();
						java.text.NumberFormat formatter = new java.text.DecimalFormat("#,###");
						out.print((financial != null && !financial.toString().equals("0E-16"))?formatter.format(financial.divide(new java.math.BigDecimal(12),0,java.math.BigDecimal.ROUND_HALF_UP)):"0");
					%>
				</display:column>
				<display:column title="�մ���B">
					<bean:write name="row" property="lastFound" format='#,###'/>
				</display:column>
				<display:column title="�k���ԭɴ�">
					<bean:write name="row" property="founda" format='#,###'/>
				</display:column>
				<display:column title="�N���a��س]���">
					<bean:write name="row" property="foundb" format='#,###'/>
				</display:column>
				<display:column title="���I���B">
					<bean:write name="row" property="nowFound" format='#,###'/>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
