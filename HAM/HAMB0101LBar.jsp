<!-- HAMB0101LBar.jsp
程式目的：HAMB01文字
程式代號：HAMB01
程式日期：0950220
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
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
		<logic:notEmpty name="collection">
			<bean:define id="ok" name="Hamb0101Form" property="ok" type="java.lang.Boolean "/>
			<logic:notEqual name="ok" value="true">
				<html:submit styleClass='formcss_rbutton' property='doUpd' value='確認' onclick='return checkForm(this.form);'/>	
			</logic:notEqual>
					

		</logic:notEmpty>	
			<html:submit styleClass='formcss_rbutton' property='goQry' value='回查詢' />
		</td>
	</tr>
</table>
