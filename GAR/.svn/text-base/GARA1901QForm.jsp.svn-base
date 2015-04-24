<!--	GARA1901QForm.jsp
程式目的：GARA1901
程式代號：GARA1901
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
		<td class='table_item'>年度</td>
		<td class='table_td'>
			<html:text name="Gara1901Form" property="accountYear" size='3' maxlength='3'/>
		</td> 
	</tr>
	<tr>
		<td class='table_item'>月份</td>
		<td class='table_td'>
			<html:select name="Gara1901Form" property="accountMonth" >
				<html:option value="01">01</html:option>
				<html:option value="02">02</html:option>
				<html:option value="03">03</html:option>
				<html:option value="04">04</html:option>
				<html:option value="05">05</html:option>
				<html:option value="06">06</html:option>
				<html:option value="07">07</html:option>
				<html:option value="08">08</html:option>
				<html:option value="09">09</html:option>
				<html:option value="10">10</html:option>
				<html:option value="11">11</html:option>
				<html:option value="12">12</html:option>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>金額單位</td>
		<td class='table_td'>
			<%pageContext.setAttribute("collectionCodeDet",tw.gov.nta.system.common.CodeDetManage.getCodeDet("BU")); %>
			<html:select name='Gara1901Form' property='amountUnit'>
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
			<textarea name="memo" rows="5" cols="50" ><%=(request.getAttribute("memo")!=null)?request.getAttribute("memo"):""%></textarea>
		</td>
	</tr>
</table>