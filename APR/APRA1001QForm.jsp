<!--	APRA1001Q.jsp
�{���ت��GAPRA10�����F���n�����Ůֵ��֭p��C�L
�{���N���GAPRA10
�{������G0950331
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>���ŦW��</td>
		<td class='table_td'>
			<bean:define id="debtNameList" name="Apra1001Form" property="debtNameList" type="java.util.List"/>
			<html:select name='Apra1001Form' property='debtName'>
				<html:option value="">�п��</html:option>
				<html:options collection="debtNameList" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�Ȧ�W��</td>
		<td class='table_td'>
			<%pageContext.setAttribute("bankCodeList",tw.gov.nta.system.common.BankCodeManage.getBankF()); %>
			<html:select name='Apra1001Form' property='bankId' onchange="getSelect(this.form);">
				<html:option value="">�п��</html:option>
				<html:options collection="bankCodeList" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
			<html:hidden name="Apra1001Form" property="bankName" />
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�έp�I����</td>
		<td class='table_td'>
			<html:text name='Apra1001Form' property='date(closeDate)' size='10' maxlength='7' onblur=""/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(closeDate)",new Integer(0))%>
		</td>
	</tr>
</table>