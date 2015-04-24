<!-- DIMA0101MForm.jsp
程式目的：DIMA01
程式代號：DIMA01
程式日期：0950223
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
<html:hidden name='Dima0101Form' property='bigDecimal(borrowAmount)' />
<html:hidden name='Dima0101Form' property='bigDecimal(enableborrow)'/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>年度</td>
		<td class='table_td'>
			民國
			<bean:write name='Dima0101Form' property='contractYear'/>
			<html:hidden name='Dima0101Form' property='contractYear'/>
			年
		</td>
	</tr>
	<tr>
		<td class='table_item'>銀行編號</td>
		<td class='table_td'>
			<bean:write name='Dima0101Form' property='bank.bankCode'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>銀行名稱</td>
		<td class='table_td'>
			<bean:write name='Dima0101Form' property='bank.bankName'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>借款總額</td>
		<td class='table_td'>
			<logic:notEmpty name='Dima0101Form' property='contractAmount' >
				<bean:define id="contractAmount" name='Dima0101Form' property='contractAmount' type="java.math.BigDecimal"/>
				<%request.setAttribute("contractAmount",contractAmount);%>
			</logic:notEmpty>
			<logic:empty name='Dima0101Form' property='contractAmount'>
				<%request.setAttribute("contractAmount",new java.math.BigDecimal(0));%>
			</logic:empty>
			<input type="text" name="bigDecimal(contractAmount)" style="text-align: right" size='25' maxlength='20'  value="<%=(java.math.BigDecimal)(request.getAttribute("contractAmount"))%>" onblur="javascript:return(countValue(this.form));" />
		</td>
	</tr>
	
	<tr>
		<td class='table_item'>目前己借額度</td>
		<td class='table_td'>
			<logic:notEmpty name='Dima0101Form' property='borrowAmount' >
				<bean:define id="borrowAmount" name='Dima0101Form' property='borrowAmount' type="java.math.BigDecimal"/>
				<%request.setAttribute("borrowAmount",borrowAmount);%>
				<bean:write name='Dima0101Form' property='bigDecimal(borrowAmount)' format='#,##0'/>
			</logic:notEmpty>
			<logic:empty name='Dima0101Form' property='borrowAmount'>
				<%request.setAttribute("borrowAmount",new java.math.BigDecimal(1));%>
				<bean:write name='Dima0101Form' property='bigDecimal(borrowAmount)' format='#,##0'/>
			</logic:empty>
		</td>
	</tr>
	
	<tr>
		<td class='table_item'>目前可借額度</td>
		<td class='table_td' id="enableborrowid">
			<bean:define id="contractYear" name='Dima0101Form' property='contractYear' type="java.lang.String"/>
			<bean:define id="contractAmount" name="Dima0101Form" property="contractAmount" type="java.math.BigDecimal"/>
			<bean:define id="borrowAmount" name="Dima0101Form" property="borrowAmount" type="java.math.BigDecimal"/>
			<% 
				if (Integer.parseInt(contractYear)< new java.util.Date().getYear()-11 )
					out.println(0);
				else
					out.println(new java.text.DecimalFormat("#,###").format((contractAmount.subtract(borrowAmount).doubleValue()< 0)? new java.math.BigDecimal("0") :contractAmount.subtract(borrowAmount)));
			%>
		</td>
		<td></td>
		<html:hidden name='Dima0101Form' property="id"/>
		<html:hidden name='Dima0101Form' property="bankId"/>
		<html:hidden name='Dima0101Form' property="qrycontractyear"/>
		<html:hidden name='Dima0101Form' property="qrybankcode"/>
	</tr>
	<tr>
		<td class='table_item'>簽約日期</td>
		<td class='table_td'>
			<html:text name='Dima0101Form' property='Date(contractDate)' size='7' maxlength='7' />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(contractDate)",new Integer(0))%>
		</td>
	</tr>
</table>
