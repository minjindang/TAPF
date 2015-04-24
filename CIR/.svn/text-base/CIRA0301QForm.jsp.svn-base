<!--	CIRA0301QForm.jsp
程式目的：CIRA0301中長期借款債務概況總表
程式代號：CIRA0301
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
		<td class='table_item'><font color="red">*</font>償還狀態</td>
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
		<td class='table_item'>年度起迄</td>
		<td class='table_td'>
			<html:text name='Cira0301Form' property='startYear' size='10' maxlength='3'/>~
			<html:text name='Cira0301Form' property='endYear' size='10' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>借款日期起迄</td>
		<td class='table_td'>
			<html:text name='Cira0301Form' property='date(startDate)' size='10' maxlength='7'/>~
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(startDate)",new Integer(0))%>
			<html:text name='Cira0301Form' property='date(endDate)' size='10' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(endDate)",new Integer(1))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>期別</td>
		<td class='table_td'>
			<html:text name='Cira0301Form' property='startSerial' size='10' maxlength='5'/>~
			<html:text name='Cira0301Form' property='endSerial' size='10' maxlength='5'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>金額單位</td>
		<td class='table_td'>
			<%pageContext.setAttribute("collectionCodeDet",tw.gov.nta.system.common.CodeDetManage.getCodeDet("BU")); %>
			<html:select name='Cira0301Form' property='baseUnit' onchange="getSelectValue(this.form)">
				<html:option value="">請選擇</html:option>
				<html:options collection="collectionCodeDet" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
			<html:hidden name='Cira0301Form' property='baseUnitValue'/>
		</td>
	</tr>
</table>