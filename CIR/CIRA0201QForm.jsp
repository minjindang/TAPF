<!--	CIRA0201QForm.jsp
程式目的：CIRA0201中長期借款比價概況表
程式代號：CIRA0201
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
		<td class='table_item'><font color="red">*</font>期別</td>
		<td class='table_td'>
			<html:select name='Cira0201Form' property="issueSerial" value="issueSerial" >
					<html:optionsCollection name='Cira0201Form'  property="serialNoList" label="issueSerial" value="issueSerial" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>金額單位</td>
		<td class='table_td'>
			<%pageContext.setAttribute("collectionCodeDet",tw.gov.nta.system.common.CodeDetManage.getCodeDet("BU")); %>
			<html:select name='Cira0201Form' property='baseUnit' onchange="getSelectValue(this.form)">
				<html:option value="">請選擇</html:option>
				<html:options collection="collectionCodeDet" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
			<html:hidden name='Cira0201Form' property='baseUnitLabel'/>
		</td>
	</tr>
</table>