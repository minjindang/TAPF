<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<html:hidden name='Gama0201Form' property='id'/>
<html:hidden name='Gama0201Form' property='qryAccountYear'/>
<html:hidden name='Gama0201Form' property='qryNationCode'/>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width="20%"><font color="#ff0000">*</font>�~��</td>
		<td class='table_td'>
			<html:text name='Gama0201Form' property='accountYear' size='3' maxlength='3' onblur='checkDate(this.form)'/>
		</td>
		<td class='table_item' width="20%"><font color="#ff0000">*</font>��O</td>
		<td class='table_td'>
			<logic:notEmpty name="Gama0201Form" property="nationCode">
				<bean:define id="nationCode" name="Gama0201Form" property="nationCode" type="tw.gov.nta.sql.NationRef"/>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.NationCodeManager.getNationInfo(),"nationRefId",nationCode.getId().toString(),"","checkDate(this.form)",10,false)%>
			</logic:notEmpty>
			<logic:empty name="Gama0201Form" property="nationCode">
			<bean:define id="nationCode" name="Gama0201Form" property="nationRefId" type="java.lang.Integer"/>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.NationCodeManager.getNationInfo(),"nationRefId",nationCode.toString(),"","checkDate(this.form)",10,false)%>
			</logic:empty>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>GDP</td>
		<td class='table_td'>
			<html:text name='Gama0201Form' property='bigDecimal(gdpAmount)' size='20' maxlength='20' />
		</td>
		<td class='table_item'><font color="#ff0000">*</font>�|�p�~��GNP</td>
		<td class='table_td'>
			<html:text name='Gama0201Form' property='bigDecimal(gnpAmount)' size='20' maxlength='20' />
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>���~��GNP</td>
		<td class='table_td'>
			<html:text name='Gama0201Form'property='bigDecimal(gnpYearAmount)' size='20' maxlength='20' />
		</td>
		<td class='table_item'><font color="#ff0000">*</font>�e�T�~����GNP</td>
		<td class='table_td'>
			<html:text name='Gama0201Form' property='bigDecimal(pergnpAmount)' size='20' maxlength='20' />
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>���X�`�B(�w���)</td>
		<td class='table_td'>
			<html:text name='Gama0201Form'property='bigDecimal(budgetAmount)' size='20' maxlength='20' />
		</td>
		<td class='table_item'><font color="#ff0000">*</font>�ŰȾl�B/GDP���</td>
		<td class='table_td'>
			<html:text name='Gama0201Form' property='bigDecimal(remainRate)' size='20' maxlength='20' />
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>���Ż��ɵo���`�B</td>
		<td class='table_td'>
			<html:text name='Gama0201Form' property='bigDecimal(borrowAmount)' size='20' maxlength='20'/>
		</td>
		<td class='table_item'><font color="#ff0000">*</font>���v�l�B</td>
		<td class='table_td'>
			<html:text name='Gama0201Form' property='bigDecimal(nopayAmount)' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�U��̦s��</td>
		<td class='table_td' >
			<html:text name='Gama0201Form' property='bigDecimal(caseRate)' size='20' maxlength='20'/>
		</td>
		<td class='table_item'>���v�l�B/��(��)�X���</td>
		<td class='table_td' >
			<html:text name='Gama0201Form' property='bigDecimal(remainPayRate)' size='20' maxlength='20'/>
		</td>
	</tr>
	<logic:equal name="Gama0201Form" property="accountYear"  value="089">
		<tr>
			<td class='table_item'>�|�p�~��GNP</td>
			<td class='table_td' colspan="3">
				<html:text name='Gama0201Form' property='bigDecimal(gnpYearAmount1)' size='20' maxlength='20'/>
			</td>
		</tr>
	</logic:equal>
</table>
