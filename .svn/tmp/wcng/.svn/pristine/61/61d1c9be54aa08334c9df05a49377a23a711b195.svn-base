<!-- BIMA0102AForm.jsp
程式目的：BIMA01
程式代號：BIMA01
程式日期：0950301
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<html:hidden name='Bima0102Form' property='id'/>
<html:hidden name='Bima0102Form' property='issueId'/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>面額種類:</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("MY"),"ticketAmount"," ","","getTotalAmount()",10)%>
		</td>
	</tr>	
	<tr>	
		<td class='table_item'>張數:</td>
		<td class='table_td'>
			<html:text name='Bima0102Form' property='ticketCount' size='50' maxlength='10' onblur="getTotalAmount()"/>
		</td>
	</tr>
	<tr>	
		<td class='table_item'>金額:</td>
		<td class='table_td'>
			<html:text name='Bima0102Form' property='bigDecimal(totalAmount)' size='50' maxlength='20' readonly='ture'/>
		</td>
	</tr>
</talbe>
