<!--	APRA1401QForm.jsp
�{���ت��GAPRA1401���餽���ഫ�n�����ťb�~����C�L
�{���N���GAPRA14
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

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>���</td>
		<td class='table_td'>
			<html:text name='Apra1401Form' property='date(closeSdate)' size='10' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(closeSdate)",new Integer(0))%>~
			
			<html:text name='Apra1401Form' property='date(closeEdate)' size='10' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(closeEdate)",new Integer(1))%>
			
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�M��Ȧ�</td>
		<td class='table_td'>
			<logic:notEmpty name="Apra1401Form" property='bankName'>
				<bean:define id="bankName" name="Apra1401Form" property="bankName" type="java.lang.String"/>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BankCodeManage.getBankF(),"bankName",bankName,10,false)%>
			</logic:notEmpty>
			<logic:empty name="Apra1401Form" property='bankName'>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BankCodeManage.getBankF(),"bankName",10,false)%>
			</logic:empty>
		</td>
	</tr>
</table>