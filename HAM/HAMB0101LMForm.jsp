<!-- HAMB0101LMFrom.jsp
�{���ت��GHAMB01��r
�{���N���GHAMB01
�{������G0950220
�{���@�̡GEric.Chen
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
	<td>�X�p:<%= new java.text.DecimalFormat("#,###").format(new java.math.BigDecimal(request.getAttribute("totalAmount").toString())) %></td>
	</tr>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="unitAllocateMain">
				<display:column title="�����t���W��">
					<bean:define id="unitInfo" name="unitAllocateMain" property="unitInfo" type="tw.gov.nta.sql.UnitInfoMain"/>
					<bean:write name='unitInfo' property='unitName'/>
				</display:column>
				<display:column title="�����t���B">
					<bean:define id='srcMoney' name='unitAllocateMain' property='srcMoney' type='java.math.BigDecimal'/></p>
					<%= new java.text.DecimalFormat("#,##0").format(srcMoney.setScale(0,4))%>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
