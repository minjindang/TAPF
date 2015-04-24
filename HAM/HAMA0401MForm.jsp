<!--
程式目的：受分配單位資料維護
程式代號：HAMA04
程式日期：1000920
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
<%@ page import="gov.dnt.tame.util.Converter"%>
<%
	java.util.List list = new java.util.LinkedList();
	list.add(0, new gov.dnt.tame.common.LabelValueBean("","請選擇"));
	list.add(1, new gov.dnt.tame.common.LabelValueBean("T","是"));
	list.add(2, new gov.dnt.tame.common.LabelValueBean("F","否"));

	pageContext.setAttribute("isMailList", list);
%>

<html:hidden name='Hama0401Form' property='id'/>
<html:hidden name='Hama0401Form' property='usrid'/>
<html:hidden name='Hama0401Form' property='groupid'/>
<html:hidden name='Hama0401Form' property='date(createDate)'/>
<html:hidden name='Hama0401Form' property='qryTyear'/>
<html:hidden name='Hama0401Form' property='qryUnitId'/>
<html:hidden name='Hama0401Form' property='qryUnit'/>
<html:hidden name="Hama0401Form" property="page"/>
<html:hidden name="Hama0401Form" property="seqNo"/>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>受分配單位代號</td>
		<td class='table_td' colspan='3'>
			<html:text name='Hama0401Form' property='unitId' size='10' maxlength='10' readonly='true' />
		</td>
	</tr>
	<tr>
		<td class='table_item'>受分配單位名稱</td>
		<td class='table_td' colspan='3'>
			<html:text name='Hama0401Form' property='unitName' size='20' maxlength='100'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>受分配比例</td>
		<td class='table_td'>
			<bean:write name='Hama0401Form' property='tpercent'/>
			<logic:notEmpty name="Hama0401Form" property='qryTyear'>
				(分配年度<bean:write name='Hama0401Form' property='qryTyear'/>年)
			</logic:notEmpty>
		</td>
	</tr>
</table>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' colspan='7'>[解款行資料]</td>
	</tr>
	<tr>
		<td class='table_item'>中央統籌款</td>
		<td class='table_item'>行名</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='sbank1' size='20' maxlength='100'/>
		</td>
		<td class='table_item'>分支單位</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='sbranch1' size='20' maxlength='100'/>
		</td>
		<td class='table_item'>行號</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='sno1' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>專案補助</td>
		<td class='table_item'>行名</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='sbank2' size='20' maxlength='100'/>
		</td>
		<td class='table_item'>分支單位</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='sbranch2' size='20' maxlength='100'/>
		</td>
		<td class='table_item'>行號</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='sno2' size='20' maxlength='20'/>
		</td>
	</tr>
</table>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' colspan='5'>[收款單位資料]</td>
	</tr>
	<tr>
		<td class='table_item'>中央統籌款</td>
		<td class='table_item'>戶名</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='tbank1' size='50' maxlength='100'/>
		</td>
		<td class='table_item'>帳號</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='tacct1' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>專案補助</td>
		<td class='table_item'>戶名</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='tbank2' size='50' maxlength='100'/>
		</td>
		<td class='table_item'>帳號</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='tacct2' size='20' maxlength='20'/>
		</td>
	</tr>
</table>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' colspan='6'>[收款單位]</td>
	</tr>
	<tr>
		<td class='table_item'>承辦人姓名</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='tname' size='20' maxlength='20'/>
		</td>
		<td class='table_item'>聯絡電話</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='ttel' size='30' maxlength='30'/>
		</td>
		<td class='table_item'>傳真</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='tfax' size='30' maxlength='30'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>是否發送郵件</td>
		<td class='table_td' colspan='2'>
			<html:select name="Hama0401Form" property="mail">
				<html:options collection="isMailList" property="valuess" labelProperty="label"/>
			</html:select>
		</td>
		<td class='table_item'>收款單位—電子郵件信箱</td>
		<td class='table_td' colspan='2'>
			<html:text name='Hama0401Form' property='temail' size='20' maxlength='100'/>
		</td>
	</tr>
</table>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' colspan='2'>[附言編輯]</td>
	</tr>
	<tr>
		<td class='table_item'>中央統籌款</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='notea' size='50' maxlength='255'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>專案補助</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='noteb' size='50' maxlength='255'/>
		</td>
	</tr>
</table>
