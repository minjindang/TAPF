<!-- DIMA0101QForm.jsp
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
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>年度</td>
		<td class='table_td'>
			<html:text name='Dima0101Form' property='qrycontractyear' size='5' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>銀行編號</td>
		<td class='table_td'>
			<html:select name="Dima0101Form" property="bankId">
				<html:option value="">請選擇</html:option>
				<html:optionsCollection name="Dima0101Form" property="bankList" label="name" value="id"/>
			</html:select>
		</td>
	</tr>
</table>
