<!--	APRA1101QForm.jsp
�{���ت��GAPRA1101�����F���n�������٥��I�������C�L
�{���N���GAPRA11
�{������G0950316
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>�Ȧ�W��</td>
		<td class='table_td'>
			<%pageContext.setAttribute("bankCodeList",tw.gov.nta.system.common.BankCodeManage.getBankF()); %>
			<html:select name='Apra1101Form' property='bankId' onchange="getSelect(this.form)">
				<html:option value="">�п��</html:option>
				<html:options collection="bankCodeList" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
			<html:hidden name="Apra1101Form" property="bankName" />
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�έp�_�����</td>
		<td class='table_td'>
			<html:text name='Apra1101Form' property='date(closeSdate)' size='10' maxlength='7' onblur=""/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(closeSdate)",new Integer(0))%>~
			<html:text name='Apra1101Form' property='date(closeEdate)' size='10' maxlength='7' onblur=""/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(closeEdate)",new Integer(1))%>
		</td>
	</tr>
</table>