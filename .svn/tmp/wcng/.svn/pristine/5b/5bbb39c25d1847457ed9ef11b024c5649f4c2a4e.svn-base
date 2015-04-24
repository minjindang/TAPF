<!--	GARA2501QForm.jsp
程式目的：GARA2501
程式代號：GARA2501
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

<%@page import="tw.gov.nta.surplusage.common.GaraNoteManager"%>
<%@page import="tw.gov.nta.sql.debt.GaraNote"%>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>發行年度區間一</td>
		<td class='table_td'>
			<html:text name="Gara2501Form" property="accountSyear1" maxlength="3" size="5" value='038'/>~
			<html:text name="Gara2501Form" property="accountEyear1" maxlength="3" size="5" value='079'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行年度區間二</td>
		<td class='table_td'>
			<html:text name="Gara2501Form" property="accountSyear2" maxlength="3" size="5" value='080'/>~
			<html:text name="Gara2501Form" property="accountEyear2" maxlength="3" size="5" value='089'/>
		</td>
	</tr>
		<tr>
		<td class='table_item'>發行年度區間三</td>
		<td class='table_td'>
			<html:text name="Gara2501Form" property="accountSyear3" maxlength="3" size="5" value='090'/>~
			<html:text name="Gara2501Form" property="accountEyear3" maxlength="3" size="5" value='095'/>
		</td>
	</tr>
		<tr>
		<td class='table_item'>發行年度區間四</td>
		<td class='table_td'>
			<html:text name="Gara2501Form" property="accountSyear4" maxlength="3" size="5" value='094'/>~
			<html:text name="Gara2501Form" property="accountEyear4" maxlength="3" size="5" value='094'/>
		</td>
	</tr>
		<tr>
		<td class='table_item'>發行年度區間五</td>
		<td class='table_td'>
			<html:text name="Gara2501Form" property="accountSyear5" maxlength="3" size="5" value='095'/>~
			<html:text name="Gara2501Form" property="accountEyear5" maxlength="3" size="5" value='095'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>金額單位</td>
		<td class='table_td'>
			<%pageContext.setAttribute("collectionCodeDet",tw.gov.nta.system.common.CodeDetManage.getCodeDet("BU")); %>
			<html:select name='Gara2501Form' property='amountUnit' onchange="getSelectValue(this.form)">
				<html:option value="">請選擇</html:option>
				<html:options collection="collectionCodeDet" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
			<html:hidden name='Gara2501Form' property='amountUnitLabel'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>備註</td>
		<td class='table_td'>
			<%request.setAttribute("memo",((GaraNote)new GaraNoteManager().getGaraNote((String)request.getAttribute("PATH"))).getMemo()); %>
			<input type='hidden' name='path' value='<%=(String)request.getAttribute("PATH") %>'/>
			<textarea name="memo" rows="5" cols="50" ><%=(request.getAttribute("memo")!=null)?request.getAttribute("memo"):""%></textarea>
		</td>
	</tr>
</table>