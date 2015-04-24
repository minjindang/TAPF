<!-- CPMA0101AForm.jsp
程式目的：CPMA01
程式代號：CPMA01
程式日期：0950306
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
	<tr>
		<td class='table_item'><font color="red">*</font>中長期借款名稱</td>
		<td class='table_td'>
			<html:select name='Cpma0101Form' property='debtName' onchange="changeList(this.form)">
				<html:option value="">請選擇</html:option>
				<html:optionsCollection name="Cpma0101Form" property="debtNameList" 
					label="label" value="valuess"/>
			</html:select>
		</td>	
		<html:hidden name="Cpma0101Form" property='issueId' />
		<html:hidden name="Cpma0101Form" property='oklist' />
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>預計償還日期</td>
		<td class='table_td'>
			<%  
					String value = new String(); 
					if(null != request.getAttribute("oklist"))
					{
						value = request.getAttribute("oklist").toString();
					}
					tw.gov.nta.debt.common.PlanManager list = new tw.gov.nta.debt.common.PlanManager();
					java.util.List newlist = new java.util.LinkedList();
					if(null != value && !"".equals(value) && !" ".equals(value))
					{	
						newlist =  list.getPlan(value);
					}	
					pageContext.setAttribute("collectionList",newlist); 
			%>
			<html:select name='Cpma0101Form' property='date(planRepayDate)' onblur="showType(this.form)" >
				<html:option value="">請選擇</html:option>
				<html:options collection="collectionList" labelName="label" labelProperty='valuess' property="valuess"/>
			</html:select>	
		</td>	
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>實際償還日期</td>
		<td class='table_td'>
			<input type=""text"" name='date(qryrepayDate)' size='10' maxlength='7' 
			value="<%=gov.dnt.tame.util.DateUtil.date2ROCStr(new java.util.Date())%>" onblur="showType(this.form)"/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(qryrepayDate)")%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>償還方式</td>
		<td class='table_td' id="debtTypeid">
			<bean:write name='Cpma0101Form' property='debtType'/>
		</td>
		<html:hidden name='Cpma0101Form' property='debtType'/>
	</tr>
</table>
