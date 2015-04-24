<!-- HAMB0301MForm.jsp
程式目的：HAMB03
程式代號：HAMB03
程式日期：0950221
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
<bean:define id="taxKind" name="Hamb0301Form" property="taxKind" type="java.lang.String"/>
<%=gov.dnt.tame.util.CommonFun.checkOfConfirm(tw.gov.nta.central.common.Taxaction.getAlloted(taxKind),"valuess","tValue","checkAlloted","本月已分配，是否重新分配?")%>

<%=gov.dnt.tame.util.CommonFun.checkOfAlert(tw.gov.nta.central.common.UnitAllocate.getAllotedByIsOkList(taxKind),"valuess","xValue","checkIsOk","本月已確認撥付")%>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>記帳年度</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' property='taxYear' size='3' maxlength='3'
				onblur=";getHiddenValues();"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>分配年月</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' property='taxMonth' size='5' maxlength='5'
				onblur="this.value=parseMonth(this.value);getHiddenValues();"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>國稅收入</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' style="text-align: right" property='bigDecimal(nationTax)' size='15' />元
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>地方稅收入</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' style="text-align: right" property='bigDecimal(localTax)' size='15' />元
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>利息收入</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' style="text-align: right" property='bigDecimal(intTax)' size='15' />元
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>分配金額</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' style="text-align: right" size='15' property='bigDecimal(totMon)' readonly = "true"/>元
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>調減比率</td>
		<td class='table_item' align="right">直轄市</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' style="text-align: right" property='bigDecimal(nationRate)' size='5'/>%
		</td>
		<td class='table_item' align="right">縣市</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' style="text-align: right" property='bigDecimal(localRate)' size='5'/>%
		</td>
		<td class='table_item' align="right">鄉鎮市</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' style="text-align: right" property='bigDecimal(intRate)' size='5'/>%
		</td>
	</tr>	
	<tr>
		<td class='table_item'><font color="red">*</font>調減後撥付金額</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' style="text-align: right" size='15' property='bigDecimal(fillAmount)' readonly = "true"/>元
		</td>
	</tr>
	<html:hidden name="Hamb0301Form" property="taxKind"/>
	<html:hidden name="Hamb0301Form" property="id"/>
</table>
