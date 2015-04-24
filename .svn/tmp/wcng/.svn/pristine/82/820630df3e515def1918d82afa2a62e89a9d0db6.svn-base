<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color='red'>*</font>期別</td>
		<td class='table_td'>
			<%pageContext.setAttribute("collectionIssuecode",tw.gov.nta.debt.common.IssueManager.getDebtNameLabelList("B")); %>
			<html:select name='Bira1001Form' property='issueId'>
					<html:option value="">請選擇</html:option>
					<html:options collection="collectionIssuecode" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>	
		</td>
	</tr>
	 
	<%-- 
	<tr>
		<td class='table_item'><font color='red'>*</font>預定買回日</td>
		<td class='table_td'>
			<html:text name='Bira1001Form' property='date(repayDate)' size='7' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(repayDate)", new Integer(1))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color='red'>*</font>試算利率</td>
		<td class='table_td'>
			<font color = 'blue'>01.</font><html:text name='Bira1001Form' property='BigDecimal(accountRate)' size='7' maxlength='7'/><font>%</font>
			<font color = 'blue'>02.</font><html:text name='Bira1001Form' property='BigDecimal(accountRate)' size='7' maxlength='7'/><font>%</font>
			<font color = 'blue'>03.</font><html:text name='Bira1001Form' property='BigDecimal(accountRate)' size='7' maxlength='7'/><font>%</font>
			<font color = 'blue'>04.</font><html:text name='Bira1001Form' property='BigDecimal(accountRate)' size='7' maxlength='7'/><font>%</font>
			<font color = 'blue'>05.</font><html:text name='Bira1001Form' property='BigDecimal(accountRate)' size='7' maxlength='7'/><font>%</font>
		</td>
	</tr>
	<tr>
		<td class='table_item'></td>
		<td class='table_td'>
			<font color = 'blue'>06.</font><html:text name='Bira1001Form' property='BigDecimal(accountRate)' size='7' maxlength='7'/><font>%</font>
			<font color = 'blue'>07.</font><html:text name='Bira1001Form' property='BigDecimal(accountRate)' size='7' maxlength='7'/><font>%</font>
			<font color = 'blue'>08.</font><html:text name='Bira1001Form' property='BigDecimal(accountRate)' size='7' maxlength='7'/><font>%</font>
			<font color = 'blue'>09.</font><html:text name='Bira1001Form' property='BigDecimal(accountRate)' size='7' maxlength='7'/><font>%</font>
			<font color = 'blue'>10.</font><html:text name='Bira1001Form' property='BigDecimal(accountRate)' size='7' maxlength='7'/><font>%</font>
		</td>
	</tr>
	<tr>
		<td class='table_item'></td>
		<td class='table_td'>
			<font color = 'blue'>11.</font><html:text name='Bira1001Form' property='BigDecimal(accountRate)' size='7' maxlength='7'/><font>%</font>
			<font color = 'blue'>12.</font><html:text name='Bira1001Form' property='BigDecimal(accountRate)' size='7' maxlength='7'/><font>%</font>
			<font color = 'blue'>13.</font><html:text name='Bira1001Form' property='BigDecimal(accountRate)' size='7' maxlength='7'/><font>%</font>
			<font color = 'blue'>14.</font><html:text name='Bira1001Form' property='BigDecimal(accountRate)' size='7' maxlength='7'/><font>%</font>
			<font color = 'blue'>15.</font><html:text name='Bira1001Form' property='BigDecimal(accountRate)' size='7' maxlength='7'/><font>%</font>
		</td>
	</tr>
	<tr>
		<td class='table_item'>分離課稅率</td>
		<td class='table_td'>
			<html:text name='Bira1001Form' property='BigDecimal(departRate)' size='13' maxlength='13'/>%
		</td>
	</tr>
	--%>
	
</table>