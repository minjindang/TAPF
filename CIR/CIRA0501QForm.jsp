<!--	CIRA0501QForm.jsp
程式目的：CIRA0501
程式代號：CIRA0501
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
			<%pageContext.setAttribute("statusList",tw.gov.nta.system.common.CodeDetManage.getCodeDet("RS")); %>
			<html:select name='Cira0501Form' property='status'>
				<html:option value="">請選擇</html:option>
				<html:options collection="statusList" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>年度起迄</td>
		<td class='table_td'>
			<html:text name='Cira0501Form' property='startYear' size='10' maxlength='3'/>~
			<html:text name='Cira0501Form' property='endYear' size='10' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>預算別</td>
		<td class='table_td'>
			<html:select name='Cira0501Form' property='budgetCode' onchange="changeValue(this.form)">
					<html:option value="">請選擇</html:option>
					<html:optionsCollection name="Cira0501Form" property="budgetList" label="budgetName" value="id"/>
			</html:select>
			<html:hidden name="Cira0501Form" property="budgetLabel" />
		</td>
	</tr>
	<tr>
		<td class='table_item'>債務別</td>
		<td class='table_td'>
			<html:select name='Cira0501Form' property='debtCode' onchange="getLabel(this.form)">
					<html:option value="">請選擇</html:option>
					<logic:notEmpty name="Cira0501Form" property="debtCodeList">
						<html:optionsCollection name="Cira0501Form" property="debtCodeList" label="debitName" value="id"/>
					</logic:notEmpty>
			</html:select>
			<html:hidden name="Cira0501Form" property="debtLabel" />
		</td>
	</tr>
	<tr>
		<td class='table_item'>期別</td>
		<td class='table_td'>
			<html:text name='Cira0501Form' property='startSerial' size='10' maxlength='5'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>銀行別</td>
		<td class='table_td'>
			<%pageContext.setAttribute("bankCodeList",tw.gov.nta.system.common.BankCodeManage.getBankInfo()); %>
			<html:select name='Cira0501Form' property='bankCode'>
				<html:option value="">請選擇</html:option>
				<html:options collection="bankCodeList" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>利率基準日</td>
		<td class='table_td'>
			<html:text name='Cira0501Form' property='date(baseDate)' size='10' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(baseDate)",new Integer(2))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>金額單位</td>
		<td class='table_td'>
			<%pageContext.setAttribute("collectionCodeDet",tw.gov.nta.system.common.CodeDetManage.getCodeDet("BU")); %>
			<html:select name='Cira0501Form' property='baseUnit' onchange="getSelectValue(this.form)">
				<html:option value="">請選擇</html:option>
				<html:options collection="collectionCodeDet" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
			<html:hidden name='Cira0501Form' property='baseUnitValue'/>
		</td>
	</tr>
</table>