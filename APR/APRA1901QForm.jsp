<!-- APRA1501QForm.jsp
�{���ت��GAPRA15��r
�{���N���GAPRA15
�{������G0950221
�{���@�̡GAndrew Sung
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>���ŦW��</td>
		<td class='table_td'>
			<html:select name='Apra1901Form' property='issueId' onchange="getSelectDebt(this.form)">
				<logic:notEmpty name="Apra1901Form" property="debtNameList">
					<html:option value="">�п��</html:option>
					<html:optionsCollection name="Apra1901Form" property="debtNameList" label="label" value="valuess"/>
				</logic:notEmpty>
			</html:select>	
		</td>
		<html:hidden name="Apra1901Form" property="debtName" />
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�Ȧ�O</td>
		<td class='table_td'>
		<%pageContext.setAttribute("bankList",tw.gov.nta.system.common.BankCodeManage.getBankF());%>
			<html:select name='Apra1901Form' property='bankId' onchange="getSelectBank(this.form)">
				<html:option value="">�п��</html:option>
				<html:options collection="bankList" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
		</td>
		<html:hidden name="Apra1901Form" property="bankName"/>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�I����</td>
		<td class='table_td'>
			<html:text name='Apra1901Form' property='date(closeDate)' size='10' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(closeDate)")%>
		</td>
	</tr>
</table>
