<!--	GARA1801QForm.jsp
程式目的：GARA1801
程式代號：GARA1801
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
<!-- 沒用到, 暫時先mark 起來
	<tr>
		<td class='table_item'>截止年月</td>
		<td class='table_td'>
			<html:text name="Gara1801Form" property="issueSyear" maxlength="5" size="5" />~
			<html:text name="Gara1801Form" property="issueEyear" maxlength="5" size="5" />
		</td>
	</tr>
 -->
 	<tr>
		<td class='table_item'>截止年月日</td>
		<td class='table_td'>
			<html:text name="Gara1801Form" property="issueYearMonth" maxlength="7" size="7" />
		</td>
	</tr>
	<tr>
		<td class='table_item'>金額單位</td>
		<td class='table_td'>
			<%pageContext.setAttribute("collectionCodeDet",tw.gov.nta.system.common.CodeDetManage.getCodeDet("BU")); %>
			<html:select name='Gara1801Form' property='amountUnit'>
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