<!--	APRA1101QForm.jsp
程式目的：APRA1101中央政府登錄公債還本付息結算表列印
程式代號：APRA11
程式日期：0950316
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>銀行名稱</td>
		<td class='table_td'>
			<%pageContext.setAttribute("bankCodeList",tw.gov.nta.system.common.BankCodeManage.getBankF()); %>
			<html:select name='Apra1101Form' property='bankId' onchange="getSelect(this.form)">
				<html:option value="">請選擇</html:option>
				<html:options collection="bankCodeList" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
			<html:hidden name="Apra1101Form" property="bankName" />
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>統計起迄日期</td>
		<td class='table_td'>
			<html:text name='Apra1101Form' property='date(closeSdate)' size='10' maxlength='7' onblur=""/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(closeSdate)",new Integer(0))%>~
			<html:text name='Apra1101Form' property='date(closeEdate)' size='10' maxlength='7' onblur=""/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(closeEdate)",new Integer(1))%>
		</td>
	</tr>
</table>