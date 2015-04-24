<!--	APRA1201QForm.jsp
程式目的：APRA1201中央政府登錄公債還本付息結算總表列印
程式代號：APRA12
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
		<td class='table_item'><font color="red">*</font>公債名稱</td>
		<td class='table_td'>
			<bean:define id="debtNameList" name="Apra1201Form" property="debtNameList" type="java.util.List"/>
			<html:select name='Apra1201Form' property='debtName'>
				<html:option value="">請選擇</html:option>
				<html:options collection="debtNameList" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>日期</td>
		<td class='table_td'>
			<html:text name='Apra1201Form' property='date(closeSdate)' size='10' maxlength='7' onblur=""/>
 			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(closeSdate)",new Integer(0))%>~
			<html:text name='Apra1201Form' property='date(closeEdate)' size='10' maxlength='7'onblur=""/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(closeEdate)",new Integer(1))%>
		</td>
	</tr>
	
</table>