<!-- FAMA0201LFrom.jsp
�{���ت��GFAMA02
�{���N���GFAMA02
�{������G0950222
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
<html:hidden name="Fama0201Form" property="qrybudgetType" />
<html:hidden name="Fama0201Form" property="qrybudgetName" />
<html:hidden name="Fama0201Form" property="id" />
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="�w��O">
					<bean:write name='row' property='budgetType'/>
				</display:column>
				<display:column title="�w��O�W��">
				<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
				<bean:define id="qrybudgetType" name="Fama0201Form" property="qrybudgetType" type="java.lang.String"/>
				<bean:define id="qrybudgetName" name="Fama0201Form" property="qrybudgetName" type="java.lang.String"/>
				<%
						java.util.Map paramMap = new java.util.HashMap();
							paramMap.put("id",id);
							paramMap.put("qrybudgetType",qrybudgetType);
							paramMap.put("qrybudgetName",java.net.URLEncoder.encode(qrybudgetName));
						pageContext.setAttribute("paramMap", paramMap);
				%>  
				<html:link action='/FAMA0204' name='paramMap'>
					<bean:write name='row' property='budgetName'/>
				</html:link>    
				</display:column>
				<display:column title="�Ƶ�">
						<bean:write name='row' property='remark'/>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>

