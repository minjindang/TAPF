<!--
�{���ت��G�ּ����ť���������Ӫ�(�̹w��O)
�{���N���GAPRA02
�{������G0950308
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
		<td class='table_item'><font color="red">*</font>�٥��I�����</td>
		<td class='table_td'>
			<html:text name='Apra0201Form' property='date(repaySdate)' size='10' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(repaySdate)", new Integer(0))%>~
			<html:text name='Apra0201Form' property='date(repayEdate)' size='10' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(repayEdate)", new Integer(1))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�w��O</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode",20,false)%>
		</td>
	</tr>
</table>