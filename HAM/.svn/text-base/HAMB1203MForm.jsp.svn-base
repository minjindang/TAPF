<!--
程式目的：HAMB12文字
程式代號：HAMB12
程式日期：1000929
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

<html:hidden name='Hamb1201Form' property='qryAllYear'/>
<html:hidden name='Hamb1201Form' property='qryAllMonth'/>
<html:hidden name='Hamb1201Form' property='qryUnitId'/>
<html:hidden name='Hamb1201Form' property='qryUnitName'/>
<html:hidden name='Hamb1201Form' property='usrid'/>
<html:hidden name='Hamb1201Form' property='id'/>
<html:hidden name='Hamb1201Form' property='date(createDate)'/>
<html:hidden name='Hamb1201Form' property='monKind'/>
<html:hidden name='Hamb1201Form' property='unitInfoId'/>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width="20%">記帳年度</td>
		<td class='table_td'>
			<bean:write name='Hamb1201Form' property='allYear'/>
			<html:hidden name='Hamb1201Form' property='allYear'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%">分配年月</td>
		<td class='table_td'>
			<bean:write name='Hamb1201Form' property='allMonth'/>
			<html:hidden name='Hamb1201Form' property='allMonth'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%">受分配單位代號</td>
		<td class='table_td'>
			<bean:write name='Hamb1201Form' property='unitId'/>
			<html:hidden name='Hamb1201Form' property='unitId'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%">受分配單位</td>
		<td class='table_td'>
			<bean:write name='Hamb1201Form' property='unitName'/>
			<html:hidden name='Hamb1201Form' property='unitName'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%">財源保障彌補金額</td>
		<td class='table_td'>
			<bean:write name='Hamb1201Form' property='financialPerMonth' format="#,##0"/>
			<html:hidden name='Hamb1201Form' property='financialPerMonth'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%">按公式分配金額</td>
		<td class='table_td'>
			<bean:write name='Hamb1201Form' property='bigDecimal(srcMoney)' format="#,##0"/>
			<html:hidden name='Hamb1201Form' property='bigDecimal(srcMoney)'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%">調減金額</td>
		<td class='table_td'>
			<bean:write name='Hamb1201Form' property='bigDecimal(lastFound)' format="#,##0"/>
			<html:hidden name='Hamb1201Form' property='bigDecimal(lastFound)'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%"><font color='red'>*</font>歸扣墊借款</td>
		<td class='table_td'>
			<html:text name='Hamb1201Form' property='bigDecimal(founda)' size='15' maxlength='15' onblur="countTotal(this.form);"/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%"><font color='red'>*</font>代扣地方建設基金</td>
		<td class='table_td'>
			<html:text name='Hamb1201Form' property='bigDecimal(foundb)' size='15' maxlength='15' onblur="countTotal(this.form);"/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%">本次撥付金額</td>
		<td class='table_td'>
			<html:text name='Hamb1201Form' property='bigDecimal(nowFound)' size='15' maxlength='15' readonly="true"/>
			<html:hidden name='Hamb1201Form' property='bigDecimal(allMoney)'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%">附言</td>
		<td class='table_td'>
			<html:text name='Hamb1201Form' property='notea' size='50'/>
		</td>
	</tr>
</table>
