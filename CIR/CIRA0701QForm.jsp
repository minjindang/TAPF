<!--	CIRA0701QForm.jsp
�{���ت��GCIRA0701
�{���N���GCIRA0701
�{������G0950316
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>�~�װ_��</td>
		<td class='table_td'>
			<html:text name='Cira0701Form' property='startYear' size='10' maxlength='3'/>~
			<html:text name='Cira0701Form' property='endYear' size='10' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>���B���</td>
		<td class='table_td'>
			<%pageContext.setAttribute("collectionCodeDet",tw.gov.nta.system.common.CodeDetManage.getCodeDet("BU")); %>
			<html:select name='Cira0701Form' property='baseUnit' onchange="getSelectValue(this.form)">
				<html:option value="">�п��</html:option>
				<html:options collection="collectionCodeDet" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
			<html:hidden name='Cira0701Form' property='baseUnitValue'/>
		</td>
	</tr>
</table>