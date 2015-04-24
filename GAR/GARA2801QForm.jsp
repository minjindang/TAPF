<!--	GARA2801QForm.jsp
�{���ت��GGARA2801
�{���N���GGARA2801
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

<%@page import="tw.gov.nta.surplusage.common.GaraNoteManager"%>
<%@page import="tw.gov.nta.sql.debt.GaraNote"%>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>�o��~��</td>
		<td class='table_td'>
			<html:text name="Gara2801Form" property="accountSyear" maxlength="3" size="5" />~
			<html:text name="Gara2801Form" property="accountEyear" maxlength="3" size="5" />
		</td>
	</tr>
	<tr>
		<td class='table_item'>���B���</td>
		<td class='table_td'>
			<logic:notEmpty name="Gara2801Form" property='amountUnit'>
				<bean:define id="amountUnit" name="Gara2801Form" property="amountUnit" type="java.lang.String"/>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("BU"),"amountUnit",amountUnit,"amountUnit","getSelectValue(this.form)")%>
			</logic:notEmpty>
			<logic:empty name="Gara2801Form" property='amountUnit'>
				<%pageContext.setAttribute("collectionCodeDet",tw.gov.nta.system.common.CodeDetManage.getCodeDet("BU")); %>
				<html:select name='Gara2801Form' property='amountUnit'>
					<html:option value="0">�п��</html:option>
					<html:options collection="collectionCodeDet" labelName="valuess" labelProperty='label' property="valuess"/>
				</html:select>
			</logic:empty>
			<html:hidden name='Gara2801Form' property='amountUnitLabel'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�Ƶ�</td>
		<td class='table_td'>
			<%request.setAttribute("memo",((GaraNote)new GaraNoteManager().getGaraNote((String)request.getAttribute("PATH"))).getMemo()); %>
			<input type='hidden' name='path' value='<%=(String)request.getAttribute("PATH") %>'/>
			<textarea name="memo" rows="5" cols="50" ><%=(request.getAttribute("memo")!=null)?request.getAttribute("memo"):""%></textarea>
		</td>
	</tr>
	
</table>