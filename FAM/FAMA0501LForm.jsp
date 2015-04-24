<!--
程式目的：FAMA04文字
程式代號：FAMA04
程式日期：0950223
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
<%@page import="tw.gov.nta.sql.debt.dao.BankRefDAO"%>
<%@page import="gov.dnt.tame.util.DateUtil"%>
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="銀行代號">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<bean:define id="qryBankCode" name="Fama0501Form" property="qryBankCode" type="java.lang.String"/>
					<bean:define id="qryBankName" name="Fama0501Form" property="qryBankName" type="java.lang.String"/>
					<bean:define id="qryShortBankName" name="Fama0501Form" property="qryShortBankName" type="java.lang.String"/>
					<bean:define id="qryBelongToBankId" name="Fama0501Form" property="qryBelongToBankId" type="java.lang.Integer"/>
					<bean:define id="qryCombinationBankId" name="Fama0501Form" property="qryCombinationBankId" type="java.lang.Integer"/>
					
					<%			
						String myLink = "FAMA0503?";
						myLink += "id=" + id;
						myLink += "&qryBankCode=" + qryBankCode;
						myLink += "&qryBankName=" + qryBankName;
						myLink += "&qryShortBankName=" + qryShortBankName;
						myLink += "&qryBelongToBankId=" + qryBelongToBankId;
						myLink += "&qryCombinationBankId=" + qryCombinationBankId;
					%>
					
					<A href="<%=myLink%>">
						<bean:write name='row' property='bankCode'/>
					</A>
				</display:column>
				<display:column title="銀行名稱">
					<bean:write name='row' property='bankName'/>
				</display:column>
				<display:column title="銀行簡稱">
					<bean:write name='row' property='shortBankName'/>
				</display:column>
				<display:column title="所屬銀行編號">
					<logic:notEqual name="row" property='belongToBankId' value="0">
						<bean:define id='belongToBankId' name='row' property='belongToBankId' type="java.lang.Integer"/>
						<%= new BankRefDAO().get(belongToBankId).getBankName() %>
					</logic:notEqual>
				</display:column>
				<display:column title="合併銀行編號">
					<logic:notEqual name="row" property='combinationBankId' value="0">
						<bean:define id='combinationBankId' name='row' property='combinationBankId' type="java.lang.Integer"/>
						<%= new BankRefDAO().get(combinationBankId).getBankName() %>
					</logic:notEqual>
				</display:column>
				<display:column title="合併日期">
					<logic:notEmpty name='row' property="combinationDate">
						<bean:define id="combinationDate" name='row' property='combinationDate' type="java.util.Date"/>
						<%= DateUtil.date2ROCStr(combinationDate,"yyy/MM/dd") %>
					</logic:notEmpty>
				</display:column>
				<display:column title="儲匯銀行代號">
					<bean:write name='row' property='tpsbankCode'/>
				</display:column>
				<display:column title="備註">
					<bean:write name='row' property='remark'/>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
