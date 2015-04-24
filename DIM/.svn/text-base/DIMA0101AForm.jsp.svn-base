<!-- DIMA0101AForm.jsp
程式目的：DIMA01
程式代號：DIMA01
程式日期：0950223
程式作者：Eric.Chen
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
<html:hidden name="Dima0101Form" property='qrycontractyear'/>
<html:hidden name="Dima0101Form" property='qrybankcode'/>
	<tr>
		<td class='table_item'><font color="red">*</font>年度</td>
		<td class='table_td'>
			民國
			<html:text name='Dima0101Form' property='contractYear' size='5' maxlength='3'/>
			年
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>銀行編號</td>
		<td class='table_td'>
			<html:select name="Dima0101Form" property="bankId">
				<html:option value="">請選擇</html:option>
				<html:optionsCollection name="Dima0101Form" property="bankList" label="name" value="id"/>
			</html:select>
		</td>
	</tr>
	
	<tr>
	<td class='table_item'><font color="red">*</font>借款總額</td>
	<td class='table_td'>
		
		<html:text name='Dima0101Form' style="text-align: right" property='bigDecimal(contractAmount)' size='20' value=""/>
		
	</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>簽約日期</td>
		<td class='table_td'>
			<html:text name='Dima0101Form' property='Date(contractDate)' size='7' maxlength='7' onblur=''/>
			<!-- a href="javascript: myCalendar.setCallBackObj('Date(contractDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/--></a>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(contractDate)",new Integer(0))%>
		</td>
	</tr>
</table>
