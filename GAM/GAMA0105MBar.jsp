<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doModDebtPlan' value='��s' onclick="javascript:return(checkValue(this.form));"/>
			<html:submit styleClass='formcss_rbutton' property='doDelDebtPlan' value='�R��'/>
			<html:button styleClass='formcss_rbutton' property='doClear' value='�M�e��' onclick="clearForm(this.form)"/>
			<html:submit styleClass='formcss_rbutton' property='goUp' value='�^�W�@��'/>
		</td>
	</tr>
</table>