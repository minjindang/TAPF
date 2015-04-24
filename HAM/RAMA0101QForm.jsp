<!-- RAMA0101QMForm.jsp
程式目的：RAMA01
程式代號：RAMA01
程式日期：1001027
程式作者：Powen Hsueh
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
		<td class='table_item'>到期日區間</td>
		<td class='table_td'>
			<html:text name='Rama0101Form' property='repayDateS' size='10' maxlength='7'/>
			<a href="javascript: myCalendar.setCallBackObj('repayDateS');myCalendar.show();">
			<img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/>
			</a>
			~
			<html:text name='Rama0101Form' property='repayDateE' size='10' maxlength='7' />
			<a href="javascript: myCalendar.setCallBackObj('repayDateE');myCalendar.show();">
			<img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/>
			</a>
		</td>
	</tr>
</table>
