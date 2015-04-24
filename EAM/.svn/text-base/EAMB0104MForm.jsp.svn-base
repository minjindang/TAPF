<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

</head>


<body>

<%@ page language="java" contentType="text/html;charset=Big5"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/displaytag" prefix="display"%>
<html:hidden property="account.debtType.id" name="Eamb0104Form"/>
<html:hidden property="issueMain.id" name="Eamb0104Form"/>
<html:hidden property="voucherType" name="Eamb0104Form"/>
<html:hidden property="issueMain.debtType" name="Eamb0104Form"/>
<html:hidden name="Eamb0104Form" property="voucher.voucherType"/>
<input type="hidden" name="date(voucherDate)" value="<%=request.getAttribute("date(voucherDate)") %>"/>
<input type="hidden" name="remark" value="<%=request.getAttribute("remark") %>"/>
<input type="hidden" name="phaseId" value="<%=request.getAttribute("phaseId") %>"/>
<input type="hidden" name="issueKind" value="<%=request.getAttribute("issueKind") %>"/>
	<table class="table_1" width="100%">
		<tbody>
			<tr>
	
				<td class="table_item">會計科目代號</td>
	
				<td class="table_td">
					<html:select name="Eamb0104Form" property="account.id" onchange="form.action='EAMB0112';form.submit();">
						<html:option value="">請選擇</html:option>
						<html:optionsCollection name="Eamb0104Form" property="allAccountCode" label="accountName" value="id"/>
					</html:select>
				</td>
	
			</tr>
	
			<tr>
	
				<td class="table_item">會計科目名稱</td>
	
				<td class="table_td">
					<bean:write name="Eamb0104Form" property="account.accountName"/>
					<logic:equal name="Eamb0104Form" property="account.accountType" value="D">(借方科目)</logic:equal>
					<logic:equal name="Eamb0104Form" property="account.accountType" value="C">(貸方科目)</logic:equal>
				</td>
	
			</tr>
			<tr>
	
				<td class="table_item">科目性質</td>
	
				<td class="table_td">
					<html:radio name="Eamb0104Form" property="accountType" value="D">借方</html:radio>
					<html:radio name="Eamb0104Form" property="accountType" value="C">貸方</html:radio>					
				</td>
	
			</tr>
			<tr>
	
				<td class="table_item">備註</td>
	
				<td class="table_td">
					<bean:write name="Eamb0104Form" property="account.remark"/>		
				</td>
	
			</tr>
			<tr>
	
				<td class="table_item">金額</td>
	
				<td class="table_td">
					<html:text name="Eamb0104Form" property="BigDecimal(accountAmount)" size="50" maxlength="50" value="0"/>
	
				</td>
	
			</tr>
		</tbody>
	</table>
</body>
</html>