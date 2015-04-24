<!--	APRA1401QForm.jsp
程式目的：APRA1401實體公債轉換登錄公債半年報表列印
程式代號：APRA14
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
		<td class='table_item'><font color="red">*</font>日期</td>
		<td class='table_td'>
			<html:text name='Apra1401Form' property='date(closeSdate)' size='10' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(closeSdate)",new Integer(0))%>~
			
			<html:text name='Apra1401Form' property='date(closeEdate)' size='10' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(closeEdate)",new Integer(1))%>
			
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>清算銀行</td>
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