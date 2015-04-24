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

<display:table class="table_list" name="collection" id="row" defaultsort="3">
		<display:column title="會計代號" property="accountCode.accountCode"  href="EAMA0210" paramId="id" paramProperty="id" />
		<display:column title="會計名稱" property="accountName"/>
		<display:column title="科目類別">
			<logic:equal name="row" property="accountType" value="D">
				借方
			</logic:equal>
			<logic:equal name="row" property="accountType" value="C">
				貸方
			</logic:equal>		
		</display:column>
		<display:column title="備註" property="remark"/>
</display:table>

