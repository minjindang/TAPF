<!-- FAMA0201QForm.jsp
程式目的：FAMA02
程式代號：FAMA02
程式日期：0950222
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
		<td class='table_item'>預算別</td>
		<td class='table_td'>
			<html:text name='Fama0201Form' property='qrybudgetType' size='50' maxlength='2'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>預算別名稱</td>
		<td class='table_td'>
			<html:text name='Fama0201Form' property='qrybudgetName' size='50' maxlength='50'/>
		</td>
	</tr>
</table>
