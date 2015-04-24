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
			<display:table class="table_list" name="collection" id="row">
				<display:column title="會計代號" property="accountCode.accountCode"  href="EAMA0210" paramId="id" paramProperty="id"/>
				<display:column title="會計名稱" property="accountCode.accountName"/>
				<display:column title="借/貸方">
					<bean:define id="dc" name="row" property="accountType"/>
					<logic:equal name="dc" value="D">
						借
					</logic:equal>
					<logic:equal name="dc" value="C">
						貸
					</logic:equal>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
