<!--	電子郵件接收紀錄維護
程式目的：HAMB07文字
程式代號：HAMB07
程式日期：0950223
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<%@ page import="gov.dnt.tame.util.DateUtil" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>記帳年度</td>
		<td class='table_td'>
			<bean:write name='Hamb0701Form' property='allYear'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>撥款月份</td>
		<td class='table_td'>
			<bean:write name='Hamb0701Form' property='allMonth'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>受分配單位</td>
		<td class='table_td'>
			<bean:write name='Hamb0701Form' property='unitName' />
		</td>
	</tr>
	<tr>
		<td class='table_item'>寄送日期</td>
		<td class='table_td'>
			<logic:notEmpty name="Hamb0701Form" property="sendDate">
				<bean:define id="sendDate" name="Hamb0701Form" property="sendDate" type="java.util.Date"/>
					<%=DateUtil.toDateTimeRoc(sendDate)%>
			</logic:notEmpty>
			<logic:empty name="Hamb0701Form" property="sendDate">
					<%="0000000 00:00:00"%>
			</logic:empty>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>回條接收日期</td>
		<td class='table_td'>
			<html:text name='Hamb0701Form' property='date(recvDate)' size='7' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(recvDate)")%>
			*時分秒(6碼)<html:text name='Hamb0701Form' property='houMinSec' size='6' maxlength='6'/>			
		</td>
	</tr>
	<html:hidden name='Hamb0701Form' property='id'/>
	<html:hidden name='Hamb0701Form' property='qryallYear' />
	<html:hidden name='Hamb0701Form' property='qryallMonth' />
	<html:hidden name='Hamb0701Form' property='qryunitId' />
	<html:hidden name='Hamb0701Form' property='qryunitName' />
	<html:hidden name='Hamb0701Form' property='unitName' />
</table>
