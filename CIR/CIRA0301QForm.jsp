<!--	CIRA0301QForm.jsp
�{���ت��GCIRA0301�������ɴڶŰȷ��p�`��
�{���N���GCIRA0301
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
		<td class='table_item'><font color="red">*</font>�v�٪��A</td>
		<td class='table_td'>
			<logic:notEmpty name="Cira0301Form" property='status'>
				<bean:define id="status" name="Cira0301Form" property="status" type="java.lang.String"/>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("RS"),"status",status,10,false)%>
			</logic:notEmpty>
			<logic:empty name="Cira0301Form" property='status'>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("RS"),"status",10,false)%>
			</logic:empty>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�~�װ_��</td>
		<td class='table_td'>
			<html:text name='Cira0301Form' property='startYear' size='10' maxlength='3'/>~
			<html:text name='Cira0301Form' property='endYear' size='10' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�ɴڤ���_��</td>
		<td class='table_td'>
			<html:text name='Cira0301Form' property='date(startDate)' size='10' maxlength='7'/>~
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(startDate)",new Integer(0))%>
			<html:text name='Cira0301Form' property='date(endDate)' size='10' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(endDate)",new Integer(1))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>���O</td>
		<td class='table_td'>
			<html:text name='Cira0301Form' property='startSerial' size='10' maxlength='5'/>~
			<html:text name='Cira0301Form' property='endSerial' size='10' maxlength='5'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>���B���</td>
		<td class='table_td'>
			<%pageContext.setAttribute("collectionCodeDet",tw.gov.nta.system.common.CodeDetManage.getCodeDet("BU")); %>
			<html:select name='Cira0301Form' property='baseUnit' onchange="getSelectValue(this.form)">
				<html:option value="">�п��</html:option>
				<html:options collection="collectionCodeDet" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
			<html:hidden name='Cira0301Form' property='baseUnitValue'/>
		</td>
	</tr>
</table>