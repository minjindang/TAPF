<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<table class="table_1" width="100%">
	<tr>
		<td class="table_function" align="right">
			<html:submit styleClass="formcss_rbutton" property="doAdd" value="新增" onclick="return checkForm(this.form);"/>
			<html:reset styleClass="formcss_rbutton" property="reset" value="清除"/>
			<html:submit styleClass="formcss_rbutton" property="goQry" value="到查詢"/>
		</td>
	</tr>
</table>
