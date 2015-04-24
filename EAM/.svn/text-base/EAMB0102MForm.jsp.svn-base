<!-- EAMB0102MForm.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<html:hidden name='Eamb0103Form' property='id' />
<html:hidden name="Eamb0102Form" property="issueMain.id"/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>傳票編號</td>
            <td class='table_td'>
			<bean:write name="Eamb0103Form" property="voucherNo"/>
		</td>
	</tr>
	
	<logic:notEmpty name="Eamb0103Form" property="phase">
		<tr>
			<td class='table_item'>會計階段</td>
			<td class='table_td'>	
				<bean:write name="Eamb0103Form" property="phase.phaseName"/>
			</td>		
		</tr>
	</logic:notEmpty>
	<tr>
		<td class='table_item'>傳票日期</td>
		<td class='table_td''>
        	<bean:write name="Eamb0103Form" property="voucherDate" format="yyyy/MM/dd"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>摘要</td>
		<td class='table_td''>
        	<bean:write name="Eamb0103Form" property="remark"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>是否已過帳</td>
		<td class='table_td'>
			<bean:write name="Eamb0103Form" property="usered"/>
		</td>
	</tr>
</table>
