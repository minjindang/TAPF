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
				<display:column title="受分配單位代號">
					<bean:write name='row' property='unitId'/>
				</display:column>
				<display:column title="受分配單位名稱">
					<bean:write name='row' property='unitName'/>
				</display:column>
				<display:column title="受分配比例">
					<bean:define id="unitInfo" name="row" type="tw.gov.nta.sql.UnitInfoMain"/>
					<bean:define id="qryYear" name="Hama0301Form" property="qryYear" type="java.lang.String"/>
					<%
						java.math.BigDecimal percent = tw.gov.nta.central.common.UnitPercent.getByYear(unitInfo,qryYear).getTpercent();
						out.print((percent != null)?percent:new java.math.BigDecimal(0).setScale(0));
					%>
				</display:column>
			</display:table>
		</logic:present>
	</td>
</tr>
</table>