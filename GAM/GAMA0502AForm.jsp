<!-- CIMA0101AForm.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<%@ page import="gov.dnt.tame.util.DateUtil"%>
<html:hidden name='Gama0502Form' property='mainId' />
<html:hidden name='Gama0502Form' property='bigDecimal(lastKeepAmount)' />
<input type='hidden' name='mainAccountYear' value='<%=request.getAttribute("mainAccountYear")%>'>
<html:hidden name='Gama0502Form' property='bigDecimal(oldKeepAmount)' />
<bean:define id="gama0502Form" name="Gama0502Form"  type="tw.gov.nta.surplusage.form.Gama0502Form"/>
<input type='hidden' name='sorSubAmount' value="<%= gama0502Form.getSubAmount() %>">
<input type='hidden' name='sorPludebtAmount' value="<%= gama0502Form.getPlusdebtAmount() %>">
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>年度</td>
		<td class='table_td' colspan="3">
			<html:text name='Gama0502Form' property='accountYear' size='10' maxlength="3" onblur="changeYear(this.form)"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>資料類別</td>
		<td class='table_td'>
			<html:select size="1" name='Gama0502Form' property='dataType' onchange="change(this.form)">
				<html:option value="">請選擇</html:option>
				<html:option value="A">公債</html:option>
				<html:option value="C">中長借</html:option>
			</html:select>
		</td>
		<td class='table_item'><font color="red">*</font>排限/非排限</td>
		<td class='table_td'>
			<html:select size="1" name='Gama0502Form' property='banish' onchange="change(this.form)">
				<html:option value="">請選擇</html:option>
				<html:option value="B">排限</html:option>
				<html:option value="U">非排限</html:option>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>當年增加實際數</td>
		<td class='table_td' >
			<html:text name='Gama0502Form' property='bigDecimal(plusdebtAmount)' size='10' onblur='getKeepAmount(this.form)'/>
		</td>
		<td class='table_item'>累計實際數</td>
		<td class='table_td' >
			<html:text name='Gama0502Form' property='bigDecimal(realAmount)' size='10' onblur='getAuditAmount(this.form)'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>減免數</td>
		<td class='table_td' >
			<html:text name='Gama0502Form' property='bigDecimal(subAmount)' size='10' onblur='getKeepAmount(this.form)'/>
		</td>
		<td class='table_item'>決算數</td>
		<td class='table_td' >
			<html:text name='Gama0502Form' property='bigDecimal(auditAmount)' size='10'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>保留數</td>
		<td class='table_td' >
			<html:text name='Gama0502Form' property='bigDecimal(keepAmount)' size='10' onblur='getAuditAmount(this.form)' onchange="getOldKeepAmount(this.form)"/>
		</td>
		<td class='table_item'>原始保留數</td>
		<td class='table_td' width="30%">
			<div id="oldKeepAmount"><bean:write name='Gama0502Form' property='bigDecimal(oldKeepAmount)' format="#,###"/></div>
		</td>
	</tr>
</table>
