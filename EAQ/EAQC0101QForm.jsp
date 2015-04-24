<!--
程式目的：總分類帳
程式代號：EARD01
程式日期：0950317
程式作者：
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@taglib uri="/tags/struts-bean" prefix="bean" %>
<%@taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 

<html:hidden name="AccountQueryForm" property="debtType.id"/>
<html:hidden name="AccountQueryForm" property="debtType.typeCode"/>
<html:hidden name="AccountQueryForm" property="debtType.type"/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>債務名稱</td>
		<td class='table_td'>
			<input type="text" name="issueYear" value='<c:out value="${AccountQueryForm.issueYear}"/>' onchange="form.action='<c:out value="${SYSID}"/>'; form.submit();" />
			<html:select name="AccountQueryForm" property="issueId">
				<html:option value="0">全部</html:option>
				<html:optionsCollection name='AccountQueryForm' property='issueList' label="debtName" value="id" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>會計類別</td>
		<td class='table_td'>
			<html:select name="AccountQueryForm" property="voucherType">
				<html:option value="0">全部</html:option>
				<html:optionsCollection name='AccountQueryForm' property='phaseTypes' label="value" value="key" />
				<logic:equal name="AccountQueryForm" property="debtType.type" value="A">
					<html:option value="3">手續費</html:option>
				</logic:equal>
			</html:select>
		</td>
	</tr>	
	<tr>
		<td class='table_item'>傳票年度</td>
		<td class='table_td'>
			<input type="text" name="accountYear" value='<c:out value="${AccountQueryForm.accountYear}"/>' />
		</td> 
	</tr>

	<tr>
		<td class='table_item'>傳票月份</td>
		<td class='table_td'>	
			<select name="month" >	
				<option value="0">全部</option>	    
				<c:forEach var="month" begin="1" end="12">
					<c:if test="${month lt 10}">
						<c:set var="month" value="0${month}"/>
					</c:if>
					<c:choose>
					    <c:when test="${month eq AccountQueryForm.month}">
					    	<option value='<c:out value="${month}"/>' selected = true>
						</c:when>
					    <c:otherwise>
			        		<option value='<c:out value="${month}"/>'>
						</c:otherwise>
					</c:choose>
					<c:out value="${month}"/>
					</option>		 
				</c:forEach>		
			</select>
		</td>
	</tr>		
	<tr>
		<td class='table_item'>發行日期</td>
		<td class='table_td'>
			<html:text name='AccountQueryForm' property='date(startIssueDate)' size='7' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(startIssueDate)", new Integer(0))%>
			 ~ 
			<html:text name='AccountQueryForm' property='date(endIssueDate)' size='7' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(endIssueDate)", new Integer(1))%>
		</td>
	</tr>	
	<tr>
		<td class='table_item'>傳票號碼</td>
		<td class='table_td'>
			<input type="text" name="voucherNo" value='' />
		</td> 
	</tr>	
	
	<tr>
		<td class='table_item'>是否已過帳</td>
		<td class='table_td'>
			<html:select name="AccountQueryForm" property="isPost">
				<html:option value="">全部</html:option>
				<html:option value="Y">是</html:option>
				<html:option value="N">否</html:option>
			</html:select>
		</td>
	</tr>	
	<tr>
		<td class='table_item'>排序方式</td>
		<td class='table_td'>
			<html:select name="AccountQueryForm" property="sortType">
				<html:option value="1">依發行順序</html:option>
				<html:option value="2">依傳票日期</html:option>
			</html:select>
		</td>
	</tr>		
</table>