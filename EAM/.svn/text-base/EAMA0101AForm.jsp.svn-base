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

<input type="hidden" name="debtType.id" value="<%=((tw.gov.nta.sql.debt.DebtTypeRef)(session.getAttribute("debtType"))).getId()%>">
<table class="table_1" width="100%">

	<tbody>
		
		<tr>

			<td class="table_item">會計科目代號</td>

			<td class="table_td"><html:text name="Eama0101Form"
				property="accountCode" size="50" maxlength="10">
			</html:text></td>

		</tr>

		<tr>

			<td class="table_item">會計科目名稱</td>

			<td class="table_td"><html:text name="Eama0101Form"
				property="accountName" size="50" maxlength="50">
			</html:text></td>

		</tr>
	<tr>
		<td class='table_item'>借/貸</td>
		<td class='table_td'>
			<html:radio name="Eama0101Form" property="accountType" value="D"/>借
			<html:radio name="Eama0101Form" property="accountType" value="C"/>貸
		</td>
	</tr>
		<tr>

			<td class="table_item">備註</td>

			<td class="table_td">
			   <html:textarea name="Eama0101Form" property="remark" rows="4" cols="50" />
			</td>

		</tr>
	</tbody>
</table>

</body>
</html>
