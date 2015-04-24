<!--	CIRA0701QForm.jsp
程式目的：CIRA0701
程式代號：CIRA0701
程式日期：0950316
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>年度起迄</td>
		<td class='table_td'>
			<html:text name='Cira0701Form' property='startYear' size='10' maxlength='3'/>~
			<html:text name='Cira0701Form' property='endYear' size='10' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>金額單位</td>
		<td class='table_td'>
			<%pageContext.setAttribute("collectionCodeDet",tw.gov.nta.system.common.CodeDetManage.getCodeDet("BU")); %>
			<html:select name='Cira0701Form' property='baseUnit' onchange="getSelectValue(this.form)">
				<html:option value="">請選擇</html:option>
				<html:options collection="collectionCodeDet" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
			<html:hidden name='Cira0701Form' property='baseUnitValue'/>
		</td>
	</tr>
</table>