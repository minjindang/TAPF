<!-- APRA2201QForm.jsp
程式目的：APRA22文字
程式代號：APRA22
程式日期：0950404
程式作者：Andrew Sung
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
		<td class='table_item'><font color="red">*</font>年度</td>
		<td class='table_td'>
			<html:text name='Apra2201Form' property='killYear' size='10' maxlength='3'/>
		</td>
	</tr>
</table>
