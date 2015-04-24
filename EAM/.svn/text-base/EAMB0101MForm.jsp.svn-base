<!-- EAMB0101MForm.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<html:hidden name='Eamb0102Form' property='issueMain.id' />
<html:hidden name='Eamb0102Form' property='issueMain.debtType' />
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>發行代號</td>
            <td class='table_td'>
			<bean:write name="Eamb0102Form" property="issueSerial"/>
		</td>
		
		<c:if test='${Eamb0102Form.debtType eq "A"}' >
			<td class='table_item'>識別碼</td>
			<td class='table_td'>
				<bean:write name="Eamb0102Form" property="bondType"/>
			</td>
		</c:if>
		
		<td class='table_item'>預算別</td>
		<td class='table_td'>
			<bean:write name="Eamb0102Form" property="budgetCode"/>
		</td>
		
		<td class='table_item'>債務別	</td>
		<td class='table_td'>		
			<bean:write name="Eamb0102Form" property="debtCode"/>
		</td>
	</tr>

	<tr>
		<td class='table_item'>發行年度</td>
		<td class='table_td'>	
			<bean:write name="Eamb0102Form" property="accountYear"/>
		</td>		
		
		<td class='table_item'>發行期次</td>
		<td class='table_td'>
			<bean:write name="Eamb0102Form" property="serialNo"/>
		</td>
		
		<c:if test='${Eamb0102Form.debtType eq "A"}' >
			<td class='table_item'>發行種類</td>
			<td class='table_td'>
				<bean:write name="Eamb0102Form" property="bondKind"/>
			</td>
		</c:if>
		<c:if test='${Eamb0102Form.debtType eq "A"|| Eamb0102Form.debtType eq "B"}' >
			<td class='table_item'>發行形式</td>
			<td class='table_td'>
				<bean:write name="Eamb0102Form" property="issueKind"/>
			</td>
		</c:if>
	</tr>
	<tr>
		<td class='table_item'>
        	債務名稱 
		</td>
		<td class='table_td' colspan="7">
        	<bean:write name="Eamb0102Form" property="debtName"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行日期</td>
		<td class='table_td'>
			<bean:define name="Eamb0102Form" property="issueDate" id="issueDate"/>
			<%=gov.dnt.tame.util.DateUtil.date2ROCStr((java.util.Date)issueDate,"yyy/mm/dd")%>	
		</td>
		
		<td class='table_item'>到期日</td>
		<td class='table_td'>
			<bean:define name="Eamb0102Form" property="dueDate" id="dueDate"/>
			<%=gov.dnt.tame.util.DateUtil.date2ROCStr((java.util.Date)dueDate,"yyy/mm/dd")%>
		</td>
		<c:if test='${Eamb0102Form.debtType eq "A"}' >
			<td class='table_item'>期限</td>
			<td class='table_td'>
				<bean:write name='Eamb0102Form' property='issueInterval'/>年
			</td>
		</c:if>
		
		<c:if test='${Eamb0102Form.debtType eq "B" || Eamb0102Form.debtType eq "D" }' >
			<c:set var="dueDate" value="${Eamb0102Form.dueDate}"/>
			<td class='table_item'>天期</td>
			<td class='table_td'>
				<%=gov.dnt.tame.util.DateUtil.getDays((java.util.Date)issueDate,(java.util.Date)dueDate) %>天
			</td>
		</c:if>
	</tr>
	<tr>
		<td class='table_item'>發行額</td>
		<td class='table_td'>
			<bean:write name="Eamb0102Form" property="issueAmount" format="####,###"/>		
		</td>
		
		<c:if test='${Eamb0102Form.debtType eq "A"}' >
			<td class='table_item'>利率變動別</td>
			<td class='table_td'>
				<bean:write name='Eamb0102Form' property='rateKind'/>
			</td>
		</c:if>
		
		<td class='table_item'>利率年息</td>
		<td class='table_td'>
			<bean:write name='Eamb0102Form' property='averageRate' format="##.###"/>
		</td>
	</tr>
	
	<c:if test='${Eamb0102Form.debtType eq "A"}' >
		<tr>
			<td class='table_item'>首次付息日期</td>
			<td class='table_td'>
				<logic:notEmpty name="Eamb0102Form" property="firstInterestDate">
		        	<bean:define name="Eamb0102Form" property="firstInterestDate" id="firstInterestDate"/>
					<%=gov.dnt.tame.util.DateUtil.date2ROCStr((java.util.Date)firstInterestDate,"yyy/MM/dd")%>
	  			</logic:notEmpty>
	  		</td>
			<td class='table_item'>付息次數</td>
			<td class='table_td'> 
	        	<bean:write name="Eamb0102Form" property="interestAlternate"/>
			</td>
		</tr>
		<tr>
			<td class='table_item'>首次還本日期</td>
			<td class='table_td'>
				<logic:notEmpty name="Eamb0102Form" property="firstRepayDate">
		       		<bean:define name="Eamb0102Form" property="firstRepayDate" id="firstRepayDate"/>
					<%=gov.dnt.tame.util.DateUtil.date2ROCStr((java.util.Date)firstRepayDate,"yyy/MM/dd")%> 
	  			</logic:notEmpty>
	  		</td>
	  		
			<td class='table_item'>還本次數</td>
			<td class='table_td'>
	        	<bean:write name="Eamb0102Form" property='repayAlternate'/>
			</td>
		</tr>
		<tr>
			<td class='table_item'>有效兌付期限</td>
			<td class='table_td'>
	        	<bean:write name='Eamb0102Form' property='payLimit'/>年
	  		</td>
			<td class='table_item'>截止兌付日期</td>
			<td class='table_td'>
				<logic:notEmpty name="Eamb0102Form" property="cashDueDate">
	       			<bean:define name="Eamb0102Form" property="cashDueDate" id="cashDueDate"/>
					<%=gov.dnt.tame.util.DateUtil.date2ROCStr((java.util.Date)cashDueDate,"yyy/mm/dd")%> 
				</logic:notEmpty>
			</td>
		</tr>
	</c:if>
</table>
