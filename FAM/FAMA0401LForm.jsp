<!--
�{���ت��GFAMA04��r
�{���N���GFAMA04
�{������G0950223
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
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="�洫�Ъ��N��">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<bean:define id="qryStockId" name="Fama0401Form" property="qryStockId" type="java.lang.String"/>
					<bean:define id="qryStockName" name="Fama0401Form" property="qryStockName" type="java.lang.String"/>
					
					<%			
						String myLink = "FAMA0403?";
						myLink += "id=" + id;
						myLink += "&qryStockId=" + qryStockId;
						myLink += "&qryStockName=" + qryStockName;
					%>
					
					<A href="<%=myLink%>">
						<bean:write name='row' property='stockId'/>
					</A>
				</display:column>
				<display:column title="�洫�Ъ��W��">
					<bean:write name='row' property='stockName'/>
				</display:column>
				<display:column title="�Ƶ�">
					<bean:write name='row' property='remark'/>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
