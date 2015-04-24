<!-- CPMA0101QForm.jsp
程式目的：CPMA01
程式代號：CPMA01
程式日期：0950306
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
			<html:text name='Cpma0101Form' property='qryaccountYear' size='5' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>中長期借款名稱</td>
		<td class='table_td'>
			<html:select name='Cpma0101Form' property='qrydebtName'>
				<html:option value="">請選擇</html:option>
				<html:optionsCollection name="Cpma0101Form" property="qryDebtNameList" 
					label="label" value="valuess"/>
			</html:select>
		</td>
	</tr>
</table>
