<!-- CIMA0101AForm.jsp -->
<%@ page language="java" pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<%@ page import="gov.dnt.tame.util.DateUtil"%>
<html:hidden name='Gama0502Form' property='mainId' />
<html:hidden name='Gama0502Form' property='id' />
<html:hidden name='Gama0502Form' property='bigDecimal(lastKeepAmount)' />
<html:hidden name='Gama0502Form' property='bigDecimal(oldKeepAmount)' />
<input type='hidden' name='mainAccountYear' value='<%=request.getAttribute("mainAccountYear")%>'>
<bean:define id="gama0502Form" name="Gama0502Form"  type="tw.gov.nta.surplusage.form.Gama0502Form"/>
<input type='hidden' name='sorSubAmount' value="<%= gama0502Form.getSubAmount() %>">
<input type='hidden' name='sorPludebtAmount' value="<%= gama0502Form.getPlusdebtAmount() %>">
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width="15%"><font color="red">*</font>�~��</td>
		<td class='table_td' colspan="3">
			<html:text name='Gama0502Form' property='accountYear' size='10' maxlength="3" onblur="changeYear(this.form)"/>
		</td>
	</tr>	
	<tr>
		<td class='table_item'><font color="red">*</font>������O</td>
		<td class='table_td' colspan="3">
			<html:select size="1" name='Gama0502Form' property='dataType'>
				<html:option value="">�п��</html:option>
				<html:option value="A">����</html:option>
				<html:option value="C">������</html:option>
			</html:select>
		</td>
	</tr>	
	<tr>
		<td class='table_item' width="15%"><font color="red">*</font>�ƭ�/�D�ƭ�</td>
		<td class='table_td' colspan="3">
			<html:select size="1" name='Gama0502Form' property='banish'>
				<html:option value="">�п��</html:option>
				<html:option value="B">�ƭ�</html:option>
				<html:option value="U">�D�ƭ�</html:option>
			</html:select>
		</td>
	</tr>
	</tr>
	<tr>
		<td class='table_item'>��~�W�[��ڼ�</td>
		<td class='table_td' colspan="3">
			<html:text name='Gama0502Form' property='bigDecimal(plusdebtAmount)' size='10' onblur='getKeepAmount(this.form)'/>
		</td>
		<!-- td class='table_item'>�֭p��ڼ�</td>
		<td class='table_td' >
			<html:text name='Gama0502Form' property='bigDecimal(realAmount)' size='10' onblur='getAuditAmount(this.form)'/>
		</td-->
	</tr>
	<tr>
		<td class='table_item'>��K��</td>
		<td class='table_td' colspan="3">
			<html:text name='Gama0502Form' property='bigDecimal(subAmount)' size='10' onblur='getKeepAmount(this.form)'/>
		</td>
		<!-- td class='table_item'>�M���</td>
		<td class='table_td' >
			<html:text name='Gama0502Form' property='bigDecimal(auditAmount)' size='10'/>
		</td-->
	</tr>
	<tr>
		<td class='table_item'>�O�d��</td>
		<td class='table_td' colspan="3">
			<html:text name='Gama0502Form' property='bigDecimal(keepAmount)' size='10' onblur='getAuditAmount(this.form)'/>
		</td>
		<!-- td class='table_item'>��l�O�d��</td>
		<td class='table_td' >
			<div id="oldKeepAmount"><bean:write name='Gama0502Form' property='oldKeepAmount' format="#,###"/>  </div>
		</td-->
	</tr>
</table>
