<!-- HARB0801PForm.jsp
程式目的：HARB08文字
程式代號：HARB08
程式日期：0950221
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
<html:hidden name='Harb0801Form' property='monKind'/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' colspan="20%"><font color="red">*</font>記帳年度</td>
		<td class='table_td' colspan="80%">
			<html:select name="Harb0801Form" property="allYear" onchange="form.action='HARB08'; form.submit();">
				<html:option value = "">請選擇</html:option>
				<html:optionsCollection name="Harb0801Form" property="allYearList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item' colspan="20%">撥款月份</td>
		<td class='table_td' colspan="80%">
			<html:select name="Harb0801Form" property="allMonth">
				<html:option value = "">請選擇</html:option>
				<html:optionsCollection name="Harb0801Form" property="allMonthList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item' colspan="20%">受分配單位</td>
		<td class='table_td' colspan="80%">
			<html:text name='Harb0801Form' property='unitId' size='10' maxlength='7'/>
		</td>		
	</tr>
	<tr>
		<td class='table_item' colspan="20%">受分配單位名稱</td>
		<td class='table_td' colspan="80%">
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.central.common.UnitInfo.getUnitName(),"unitName",10,false)%>
		</td>  
	</tr>
	<tr>
		<td class='table_item' colspan="20%">回條接收日期</td>
		<td class='table_td' colspan="80%">
			<html:text name='Harb0801Form' property='date(recvSdate)' size='10' maxlength='7' onblur=""/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(recvSdate)",new Integer(0))%>
			~
			<html:text name='Harb0801Form' property='date(recvEdate)' size='10' maxlength='7' onblur=""/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(recvEdate)",new Integer(1))%>
		</td>
	</tr>
</table>
