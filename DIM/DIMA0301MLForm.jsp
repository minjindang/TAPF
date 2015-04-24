<!-- DIMA0301MLForm.jsp
程式目的：DIMA03
程式代號：DIMA03
程式日期：0950224
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
		<td>
			<display:table class="table_list" name="Dima0301Form.debtMains" id="row">
				<display:column title="銀行代號">
					<logic:notEmpty name='row' property='bank'>
						<bean:write name='row' property='bank.bankCode'/>
					</logic:notEmpty>
				</display:column>
				<display:column title="銀行名稱">
					<logic:notEmpty name='row' property='bank'>
						<bean:write name='row' property='bank.bankName'/>
					</logic:notEmpty>	
				</display:column>
				<display:column title="得標金額">
					<logic:notEmpty name='row' property='issueAmount'>
						<p align="right"><bean:write name='row' property='issueAmount' format='#,###'/></p>
					</logic:notEmpty >	
				</display:column>
				<display:column title="比價金額">
					<logic:notEmpty name='row' property='compareAmount'>
						<p align="right"><bean:write name='row' property='compareAmount' format='#,###'/></p>
					</logic:notEmpty >	
				</display:column>
				<display:column title="收款否">
					<logic:notEmpty name='row' property='id'>
						<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
						<input type="hidden" name="debtMain[<%=row_rowNum%>].id" value="<%=id%>">
						<logic:notEmpty name='row' property='accrue'>
							<logic:notEmpty name='row' property='get'>
								<bean:define id="get" name="row" property="get" type="java.lang.String"/>
								<logic:equal name="row" property="get" value="Y">			
									<%="已收款"%>
									<input type="hidden" name="debtMain[<%=row_rowNum%>].get" value="on">
								</logic:equal>
								<logic:notEqual name="row" property="get" value="Y">
									<input type="checkbox" name="debtMain[<%=row_rowNum%>].get" <%="Y".equals(get)?"checked":"N"%>>
								</logic:notEqual>
							</logic:notEmpty>	
							<logic:empty name='row' property='get'>
								<input type="checkbox" name="debtMain[<%=row_rowNum%>].get" >
							</logic:empty>
						</logic:notEmpty>
					</logic:notEmpty >	
				</display:column>
				<display:column title="收款日期">
					<logic:notEmpty name="row" property="accrueDate">
						<bean:define id="accrueDate" name="row" property="accrueDate" type="java.util.Date"/>
						<input type="text" name="debtMain[<%=row_rowNum%>].accrueDate" value="<%=gov.dnt.tame.util.DateUtil.date2ROCStr(accrueDate)%>" size='7' maxlength='7'>
					</logic:notEmpty>
					<logic:empty name="row" property="accrueDate">
						<input type="text" name="debtMain[<%=row_rowNum%>].accrueDate" value="" size='7' maxlength='7'>
					</logic:empty>
					<%=gov.dnt.tame.util.CommonFun.addCalendar("debtMain["+row_rowNum+"].accrueDate",row_rowNum)%>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>