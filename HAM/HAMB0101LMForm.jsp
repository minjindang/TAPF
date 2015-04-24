<!-- HAMB0101LMFrom.jsp
程式目的：HAMB01文字
程式代號：HAMB01
程式日期：0950220
程式作者：Eric.Chen
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
	<td>合計:<%= new java.text.DecimalFormat("#,###").format(new java.math.BigDecimal(request.getAttribute("totalAmount").toString())) %></td>
	</tr>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="unitAllocateMain">
				<display:column title="受分配單位名稱">
					<bean:define id="unitInfo" name="unitAllocateMain" property="unitInfo" type="tw.gov.nta.sql.UnitInfoMain"/>
					<bean:write name='unitInfo' property='unitName'/>
				</display:column>
				<display:column title="受分配金額">
					<bean:define id='srcMoney' name='unitAllocateMain' property='srcMoney' type='java.math.BigDecimal'/></p>
					<%= new java.text.DecimalFormat("#,##0").format(srcMoney.setScale(0,4))%>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
