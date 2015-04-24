<!-- APRA1501QForm.jsp
程式目的：APRA15文字
程式代號：APRA15
程式日期：0950221
程式作者：Andrew Sung
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
			<html:select name='Apra1801Form' property='issueId' onchange="getSelectValue(this.form)">
				<logic:notEmpty name="Apra1801Form" property="debtNameList">
					<html:option value="">請選擇</html:option>
					<html:optionsCollection name="Apra1801Form" property="debtNameList" label="label" value="valuess"/>
				</logic:notEmpty>
			</html:select>	
		</td>
		<html:hidden name="Apra1801Form" property="debtName" />
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>截止日期</td>
		<td class='table_td'>
			<html:text name='Apra1801Form' property='date(closeDate)' size='10' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(closeDate)",new Integer(0))%>
		</td>
	</tr>
</table>
