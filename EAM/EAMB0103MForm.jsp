<!-- EAMB0103MForm.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<%@page import="java.math.BigDecimal"%>
<%@page import="tw.gov.nta.sql.account.VoucherDet"%>

<% 
    char sysId =  ((String)session.getAttribute("SYSID")).charAt(5);
    String sysType = String.valueOf(sysId).trim();
    if ("3".equals(sysType)){
%>
   	�ǲ�����G<input type="text" name="date(voucherDate)" maxlength="7" value="<%=request.getAttribute("date(voucherDate)")%>"/> 
   	�ǲ������G 
   	<html:select name="Eamb0103Form" property="voucherType" onchange="form.action='EAMB0115';form.submit();">
		<html:optionsCollection name="Eamb0103Form" property="phaseTypes" label="value" value="key" />
	</html:select>
	�ŰȧO�G
   	<html:select name="Eamb0103Form" property="debtCode">
		<html:optionsCollection name="Eamb0103Form" property="debtCodeList" label="debitName" value="id" />
	</html:select>
	<br>
	�@�@�K�n�G
	<input type="textarea" name="remark" size="100" value="<%=request.getAttribute("remark") %>" />
	<br>
	�|�p���q�G
   	<html:select name="Eamb0103Form" property="phaseId" onchange="form.action='EAMB0115';form.submit();">
   		<html:option value="">�п��</html:option>
		<html:optionsCollection name="Eamb0103Form" property="phaseList" label="phaseName" value="id" />
	</html:select>
	<input type="hidden" name="mark" value="1" />
	<c:if test="${sessionScope.debtTypeCode eq 'A' }">
		�o��覡�G
	   	<html:select name="Eamb0103Form" property="issueKind">
			<html:option value="0">�n��</html:option>
			<html:option value="1">�Ų�</html:option>
		</html:select>	
	</c:if>
<%	}%>

<html:hidden name="Eamb0103Form" property="issueMain.id"/>
<html:hidden name="Eamb0103Form" property="issueMain.debtType"/>

<display:table class="table_list" name="sessionScope.voucherList" id="row">
	<logic:notEmpty name="row">
		<bean:write name='row' property='id' scope="page"/>
			<%if (!"3".equals(sysType)){%>
				<display:column>
					<input type="checkbox" name="mark" checked="checked" value="<bean:write name="row" scope="page" property="voucherSer"/>" />
				</display:column>
				<display:column title="�ǲ����" style="width: 20">
					<bean:define id="voucherDate" name="row" property="voucherDate"/>
					<%
						String voucherROCDate = gov.dnt.tame.util.DateUtil.date2ROCStr((java.util.Date)voucherDate);
					%>
					<input type="text" name="date(voucherDate)" value='<%=voucherROCDate %>' size='7' />
				</display:column>
				<display:column title="�K�n" style="width: 30%"> 
					<html:textarea name="row" property="remark" cols="35" rows="4"/>
				</display:column>
			<%}else{%>
				<display:column title="" />
			<%}%>
		<logic:notEmpty name="row" property="voucherDets">
			<bean:define id="voucher" name="row" property="voucherDets"/>
			<display:column>
			    <font size="8">
					<table class="table_list" border="2">
					<tr>
						<th><font size="2">�|�p���</font></th>
						<th><font size="2">�ɤ���B</font></th>
						<th><font size="2">�U����B</font></th>
						</font>
					</tr>
					<% BigDecimal balance = new BigDecimal(0);%>
					<logic:iterate id="detail" name="voucher">
						<tr>
							<td>
								
								<logic:equal value="C" name="detail" property="accountType">�@</logic:equal>
								<font size="2">
								<%if ("3".equals(sysType)){%>
									<a href="EAMB0111?account=<c:out value='${detail.account.id}'/>
									         &issueMain.id=<c:out value='${Eamb0103Form.issueMain.id}'/>
									         &issueMain.debtType=<c:out value='${Eamb0103Form.issueMain.debtType}'/>
									         &phaseId=<c:out value='${Eamb0103Form.phaseId}'/>
									         &voucherType=<c:out value='${Eamb0103Form.voucherType}'/>
									         &date(voucherDate)=<c:out value='${Eamb0103Form.makeDate}'/>
									         &remark=<c:out value='${Eamb0103Form.remark}'/>" >
								<%} %>
								<bean:write name="detail" property="account.accountName" />
								<%if ("3".equals(sysType)){%>
								</a>
								<%} %>
								</font>

							</td>
							<td align="right">
								<div align="right">
									<% 	
											VoucherDet voucherDet = (VoucherDet)detail;
											BigDecimal accountAmount = voucherDet.getAccountAmount();
									%>
									<logic:equal value="D" name="detail" property="accountType">
										<font size="2"><bean:write name="detail" property="accountAmount" format="####,###"/></font>
										<%
											balance = balance.add(accountAmount);
										%>
									</logic:equal>
								</div>
							</td>
							<td>
								<div align="right">
									<logic:equal value="C" name="detail" property="accountType">
										<font size="2"><bean:write name="detail" property="accountAmount" format="####,###"/></font>
										<% 
											balance = balance.subtract(accountAmount);
										%>
									</logic:equal>
								</div>
							</td>
						</tr>
					</logic:iterate>
					<tr>
						<td align="right"><font size="2">�l�B</font></td>
						<%if (balance.compareTo(new BigDecimal(0)) >= 0){ %>
							<td><div align="right"><font size="2"><%=java.text.DecimalFormat.getInstance().format(balance.doubleValue())%></font></div></td>
							<td></td>
						<%}else{%>
							<td></td>
							<td><div align="right"><font size="2"><%=java.text.DecimalFormat.getInstance().format(balance.abs().doubleValue())%></font></div></td>
						<%}%>
					</tr>
					</table>
				</font>
			</display:column>
		</logic:notEmpty>
	</logic:notEmpty> 
</display:table>
