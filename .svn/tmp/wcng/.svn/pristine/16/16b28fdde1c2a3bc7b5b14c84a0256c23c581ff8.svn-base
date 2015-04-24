<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<%@page import="tw.gov.nta.surplusage.common.GaraNoteManager"%>
<%@page import="tw.gov.nta.sql.debt.GaraNote"%>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>發行年度</td>
		<td class='table_td'>
			<html:text name='Gara0601Form' property='startYear' size='4' maxlength='3'/>
			 ~ 
			<html:text name='Gara0601Form' property='endYear' size='4' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>金額單位</td>
		<td class='table_td'>
			<%pageContext.setAttribute("collectionCodeDet",tw.gov.nta.system.common.CodeDetManage.getCodeDet("BU")); %>
			<html:select name='Gara0601Form' property='amountUnit'>
				<html:option value="0">請選擇</html:option>
				<html:options collection="collectionCodeDet" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>備註</td>
		<td class='table_td'>
		<%request.setAttribute("memo",((GaraNote)new GaraNoteManager().getGaraNote((String)request.getAttribute("PATH"))).getMemo()); %>
		<input type='hidden' name='path' value='<%=(String)request.getAttribute("PATH") %>'/>
			<html:textarea name='Gara0601Form' property='memo' cols="50" rows="5"/>
		</td>
	</tr>
</table>