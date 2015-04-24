<!--	CPRB0301QForm.jsp
程式目的：CPRB0301
程式代號：CPRB0301
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
		<td class='table_item'><font color="red">*</font>計算基準年月</td>
		<td class='table_td'>
			<html:select name="Cprb0301Form" property="issueSerial" value="issueSerial" >
					<html:optionsCollection name="Cprb0301Form"  property="serialNoList" label="issueSerial" value="issueSerial" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>計算起日</td>
		<td class='table_td'>
			<html:text name="Cprb0301Form" property="date(startDate)" size="10" maxlength="7"/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(startDate)")%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>計算迄日</td>
		<td class='table_td'>
			<html:text name="Cprb0301Form" property="date(endDate)" size="10" maxlength="7"/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(endDate)")%>
		</td>
	</tr>
</table>