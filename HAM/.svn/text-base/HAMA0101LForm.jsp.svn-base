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

<table class="table_1" width="100%">
<tr>
	<td>
		<display:table class="table_list" name="collection" id="row">	
			<display:column title="受分配單位代號">
				<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
				<bean:define id="qryUnitId" name="Hama0101Form" property="qryUnitId" type="java.lang.String"/>
				<bean:define id="qryUnit" name="Hama0101Form" property="qryUnit" type="java.lang.String"/>
				<bean:define id="qryTyear" name="Hama0101Form" property="qryTyear" type="java.lang.String"/>
				<bean:define id="pageL" name="Hama0101Form" property="page" type="java.lang.Integer"/>
				<bean:define id="unitInfo" name="row" type="tw.gov.nta.sql.UnitInfoMain"/>
				<%
						java.util.Map paramMap = new java.util.HashMap();
							paramMap.put("id",id);
							paramMap.put("qryUnitId",qryUnitId);
							paramMap.put("qryUnit",qryUnit);
							paramMap.put("page",pageL);
							paramMap.put("qryTyear",qryTyear);
							paramMap.put("tpercent",tw.gov.nta.central.common.UnitPercent.getByYear(unitInfo,qryTyear).getTpercent());
						pageContext.setAttribute("paramMap", paramMap);
				%>  
				<html:link action='/HAMA0101' name='paramMap'>
					<bean:write name='row' property='unitId'/>
				</html:link>
			</display:column>
			<display:column title="受分配單位名稱">
				<bean:write name='row' property='unitName'/>
			</display:column>
			<display:column title="受分配比例">
				<bean:define id="unitInfo" name="row" type="tw.gov.nta.sql.UnitInfoMain"/>
				<bean:define id="qryYear" name="Hama0101Form" property="qryTyear" type="java.lang.String"/>
				<%
					java.math.BigDecimal percent = tw.gov.nta.central.common.UnitPercent.getByYear(unitInfo,qryYear).getTpercent();
					out.print((percent != null)?percent:new java.math.BigDecimal(0).setScale(0));
				%>
			
			</display:column>
		</display:table>
	</td>
</tr>
</table>