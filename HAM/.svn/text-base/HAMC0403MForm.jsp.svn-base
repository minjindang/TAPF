<!--
程式目的：HAMB04文字
程式代號：HAMB04
程式日期：0950223
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>

<html:hidden name='Hamb0401Form' property='qryAllYear'/>
<html:hidden name='Hamb0401Form' property='qryAllMonth'/>
<html:hidden name='Hamb0401Form' property='qryUnitId'/>
<html:hidden name='Hamb0401Form' property='qryUnitName'/>
<html:hidden name='Hamb0401Form' property='usrid'/>
<html:hidden name='Hamb0401Form' property='id'/>
<html:hidden name='Hamb0401Form' property='date(createDate)'/>
<html:hidden name='Hamb0401Form' property='monKind'/>
<html:hidden name='Hamb0401Form' property='unitInfoId'/>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width="20%">記帳年度</td>
		<td class='table_td'>
			<bean:write name='Hamb0401Form' property='allYear'/>
			<html:hidden name='Hamb0401Form' property='allYear'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%">分配年月</td>
		<td class='table_td'>
			<bean:write name='Hamb0401Form' property='allMonth'/>
			<html:hidden name='Hamb0401Form' property='allMonth'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%">受分配單位代號</td>
		<td class='table_td'>
			<bean:write name='Hamb0401Form' property='unitId'/>
			<html:hidden name='Hamb0401Form' property='unitId'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%">受分配單位</td>
		<td class='table_td'>
			<bean:write name='Hamb0401Form' property='unitName'/>
			<html:hidden name='Hamb0401Form' property='unitName'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%">受分配金額</td>
		<td class='table_td'>
			<bean:write name='Hamb0401Form' property='bigDecimal(srcMoney)' format="#,##0"/>
			<html:hidden name='Hamb0401Form' property='bigDecimal(srcMoney)'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%">上年度受分配金額</td>
		<td class='table_td'>
			<html:text name='Hamb0401Form' property='bigDecimal(lastFound)' size='15' maxlength='15' onblur="countFound(this.form);"/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%">本年度應撥補數</td>
		<td class='table_td'>
			<html:text name='Hamb0401Form' property='bigDecimal(nowFound)' size='15' maxlength='15' readonly="true"/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%"><font color='red'>*</font>歸扣墊借款</td>
		<td class='table_td'>
			<html:text name='Hamb0401Form' property='bigDecimal(founda)' size='15' maxlength='15' onblur="countFound(this.form);"/>
		</td>
	</tr>
	<html:hidden name='Hamb0401Form' property='bigDecimal(foundb)'/>
	<!-- 20100421 林里珍小姐要求去除
	<tr>
		<td class='table_item' width="20%"><font color='red'>*</font>代扣地方建設基金</td>
		<td class='table_td'>
			<html:text name='Hamb0401Form' property='bigDecimal(foundb)' size='15' maxlength='15' onblur="countTotal(this.form);"/>
		</td>
	</tr>
	 -->
	<tr>
		<td class='table_item' width="20%">本次撥付金額</td>
		<td class='table_td'>
			<html:text name='Hamb0401Form' property='bigDecimal(allMoney)' size='15' maxlength='15' readonly="true"/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%">附言</td>
		<td class='table_td'>
			<html:text name='Hamb0401Form' property='notea' size='50'/>
		</td>
	</tr>
</table>
