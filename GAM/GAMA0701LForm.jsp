<!-- CIMA0101MLForm.jsp
�{���ت��GCIMA01
�{���N���GCIMA01
�{������G0950306
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
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="�~��">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<bean:define id="qryAccountYear" name="Gama0701Form" property="qryAccountYear" type="java.lang.String"/>
					<%			
						String myLink = "GAMA0702?";
						myLink += "id=" + id;
						myLink += "&qryAccountYear="+qryAccountYear;
					%>
					<A href="<%=myLink%>">
						<bean:write name='row' property='accountYear'/>
					</A>
				</display:column>
				<display:column title="�j���٥����B">
					<p align="right"><bean:write name='row' property='budgetCapital' format='#,###'/></p>
				</display:column>
				<display:column title="�I�����B">
					<p align="right"><bean:write name='row' property='interestPayed' format='#,###'/></p>
				</display:column>
				<display:column title="���X�`�B(�`�w��ίS�O�w��)">
					<p align="right"><bean:write name='row' property='yearAmount' format='#,###'/></p>
				</display:column>
				<display:column title="�ŰȰ������٥���">
					<p align="right"><bean:write name='row' property='fundationCapital' format='#,###'/></p>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>

