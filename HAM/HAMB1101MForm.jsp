<!-- HAMB1101MForm.jsp
程式目的：HAMB11
程式代號：HAMB11
程式日期：1000922
程式作者：Powen Hsueh
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>

<%=gov.dnt.tame.util.CommonFun.checkOfConfirm(tw.gov.nta.central.common.Taxaction101.getAlloted(),"valuess","tValue","checkAlloted","本月已分配，是否重新分配?")%>

<%=gov.dnt.tame.util.CommonFun.checkOfAlert(tw.gov.nta.central.common.UnitAllocate.getAllotedByIsOkList(),"valuess","xValue","checkIsOk","本月已確認撥付")%>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>記帳年度</td>
		<td class='table_td'>
			<html:text name='Hamb1101Form' property='taxYear' size='3' maxlength='3'
				onblur=";getHiddenValues();"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>分配年月</td>
		<td class='table_td'>
			<html:text name='Hamb1101Form' property='taxMonth' size='5' maxlength='5'
				onblur="this.value=parseMonth(this.value);getHiddenValues();"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>國稅收入</td>
		<td class='table_td'>
			<html:text name='Hamb1101Form' style="text-align: right" property='bigDecimal(nationTax)' size='15' />元
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>財源保障彌補勾選</td>
		<td class='table_td'>
			<html:radio name='Hamb1101Form' property="financialCheck" value="Y"/>是:
			<html:radio name='Hamb1101Form' property="financialCheck" value="N"/>否
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>財源保障彌補金額</td>
		<td class='table_td'>
			<html:text name='Hamb1101Form' style="text-align: right" property='bigDecimal(financial)' size='15' />元
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>利息收入</td>
		<td class='table_td'>
			<html:text name='Hamb1101Form' style="text-align: right" property='bigDecimal(intTax)' size='15' />元
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>按公式分配金額</td>
		<td class='table_td'>
			<html:text name='Hamb1101Form' style="text-align: right" size='15' property='bigDecimal(fillAmount)' readonly = "true"/>元
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>調減比率</td>
		<td class='table_item' align="right">直轄市</td>
		<td class='table_td'>
			<html:text name='Hamb1101Form' style="text-align: right" property='bigDecimal(nationRate)' size='5'/>%
		</td>
		<td class='table_item' align="right">縣市</td>
		<td class='table_td'>
			<html:text name='Hamb1101Form' style="text-align: right" property='bigDecimal(localRate)' size='5'/>%
		</td>
		<td class='table_item' align="right">鄉鎮市</td>
		<td class='table_td'>
			<html:text name='Hamb1101Form' style="text-align: right" property='bigDecimal(intRate)' size='5'/>%
		</td>
	</tr>	
	<tr>
		<td class='table_item'><font color="red">*</font>調減後撥付金額</td>
		<td class='table_td'>
			<html:text name='Hamb1101Form' style="text-align: right" size='15' property='bigDecimal(totMon)' readonly = "true"/>元
		</td>
	</tr>

	<html:hidden name="Hamb1101Form" property="id"/>
</table>
