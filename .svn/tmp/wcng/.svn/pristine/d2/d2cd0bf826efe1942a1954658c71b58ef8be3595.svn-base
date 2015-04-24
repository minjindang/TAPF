<!--
程式目的：HARA04文字
程式代號：HARA04
程式名稱：HARA0401LForm.jsp
程式日期：0950221
程式作者：Andrew Sung
程式內容：受分配單位分配比例資料查詢列印
程式說明：提供使用者查詢及列印各分配單位的分配比例
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="unitPercentDet">
				<display:column title="記帳年度">
					<bean:write name='unitPercentDet' property='tyear'/>
				</display:column>
				<display:column title="受分配單位名稱">
					<bean:define id="unitInfo" name="unitPercentDet" property="unitInfo" type="tw.gov.nta.sql.UnitInfoMain"/>
					<bean:write name='unitInfo' property='unitName'/>
				</display:column>
				<display:column title="比例">
					<bean:write name='unitPercentDet' property='tpercent'/>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
