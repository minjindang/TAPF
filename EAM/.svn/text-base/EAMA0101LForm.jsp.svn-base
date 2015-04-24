<!--
程式目的：EAMB01文字
程式代號：EAMB01
程式日期：0950310
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
			<display:table class="table_list" name="collection" id="row" >
				<display:column title="科目代號" property="accountCode" href="EAMA0103" paramId="id" paramProperty="id"/>
				<display:column title="科目名稱" property="accountName"/>
				<display:column title="科目性質">
					<logic:equal name="row" property="accountType" value="D">
						借方
					</logic:equal>
					<logic:equal name="row" property="accountType" value="C">
						貸方
					</logic:equal>
				</display:column>
				<display:column title="備註" property="remark" />
			</display:table>
		</td>
	</tr>
</table>
