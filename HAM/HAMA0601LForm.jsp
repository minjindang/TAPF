<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>

<table class="table_1" width="100%">
<tr>
	<td>
		<logic:present name="collection">
			<display:table class="table_list" name="collection" id="row">	
				<display:column title="�����t���N��">
					<bean:write name='row' property='unitId'/>
				</display:column>
				<display:column title="�����t���W��">
					<bean:write name='row' property='unitName'/>
				</display:column>
				<display:column title="�����t���">
					<bean:define id="unitInfo" name="row" type="tw.gov.nta.sql.UnitInfoMain"/>
					<bean:define id="qryYear" name="Hama0601Form" property="qryYear" type="java.lang.String"/>
					<%
						java.math.BigDecimal percent = tw.gov.nta.central.common.UnitPercent101.getByYear(unitInfo,qryYear).getTpercent();
						out.print((percent != null)?percent:new java.math.BigDecimal(0).setScale(0));
					%>
				</display:column>
				<display:column title="�]���O�٤����ɪ��B">
					<bean:define id="unitInfo" name="row" type="tw.gov.nta.sql.UnitInfoMain"/>
					<bean:define id="qryYear" name="Hama0601Form" property="qryYear" type="java.lang.String"/>
					<%
						java.math.BigDecimal financial = tw.gov.nta.central.common.UnitPercent101.getByYear(unitInfo,qryYear).getFinancial();
						java.text.NumberFormat formatter = new java.text.DecimalFormat("#,###");
						out.print((financial != null && !financial.toString().equals("0E-16"))?formatter.format(financial):"0");
					%>
				</display:column>
			</display:table>
		</logic:present>
	</td>
</tr>
</table>