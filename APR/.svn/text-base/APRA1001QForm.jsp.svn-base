<!--	APRA1001Q.jsp
程式目的：APRA10中央政府登錄公債核結累計表列印
程式代號：APRA10
程式日期：0950331
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>公債名稱</td>
		<td class='table_td'>
			<bean:define id="debtNameList" name="Apra1001Form" property="debtNameList" type="java.util.List"/>
			<html:select name='Apra1001Form' property='debtName'>
				<html:option value="">請選擇</html:option>
				<html:options collection="debtNameList" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>銀行名稱</td>
		<td class='table_td'>
			<%pageContext.setAttribute("bankCodeList",tw.gov.nta.system.common.BankCodeManage.getBankF()); %>
			<html:select name='Apra1001Form' property='bankId' onchange="getSelect(this.form);">
				<html:option value="">請選擇</html:option>
				<html:options collection="bankCodeList" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
			<html:hidden name="Apra1001Form" property="bankName" />
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>統計截止日期</td>
		<td class='table_td'>
			<html:text name='Apra1001Form' property='date(closeDate)' size='10' maxlength='7' onblur=""/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(closeDate)",new Integer(0))%>
		</td>
	</tr>
</table>