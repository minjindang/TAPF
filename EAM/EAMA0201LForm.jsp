<!--
程式目的：EAMA02文字
程式代號：EAMA02
程式日期：0950301
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
		<td>
			<display:table class="table_list" name="collection">	
				<display:column title="會計階段代號" property="phaseCode" href="EAMA0206" paramId="id" paramProperty="id"/>
				<display:column title="會計階段名稱"  property="phaseName" paramId="phaseName" paramProperty="phaseName"/>
				<display:column title="會計階段簡稱" property="phaseShortName"/>
			</display:table>
		</td>
	</tr>
</table>
