<!-- CIMA0101AForm.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<%@ page import="gov.dnt.tame.util.DateUtil"%>
<html:hidden name='Gama0503Form' property='mainId' />
<html:hidden name='Gama0503Form' property='BigDecimal(keepUamount1)' />
<html:hidden name='Gama0503Form' property='BigDecimal(keepUamount2)' />
<html:hidden name='Gama0503Form' property='BigDecimal(keepBamount1)' />
<html:hidden name='Gama0503Form' property='BigDecimal(keepBamount2)' />
<html:hidden name='Gama0503Form' property='BigDecimal(oddKeepUamount1)' />
<html:hidden name='Gama0503Form' property='BigDecimal(oddKeepUamount2)' />
<html:hidden name='Gama0503Form' property='BigDecimal(oddKeepBamount1)' />
<html:hidden name='Gama0503Form' property='BigDecimal(oddKeepBamount2)' />
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' colspan="6">
			<html:checkbox name='Gama0503Form' property='changeKey1'  onchange="checkKey1(this.form)"/>公債轉中長借
		</td>
	</tr>
	<tr>
		<td class='table_item' colspan="6">
			<html:checkbox name="Gama0503Form" property='changeKey2'  onchange="checkKey2(this.form)"/>中長借轉公債
		</td>
	</tr>
	<tr>
		<td class='table_item' width="10%">非排限金額</td>
		<td class='table_td' colspan="5">
			<html:text name='Gama0503Form' property='BigDecimal(keepUamount)' onblur="changeKeepAmount(this.form)"/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="10%">排限金額</td>
		<td class='table_td' colspan="5">
			<html:text name='Gama0503Form' property='BigDecimal(keepBamount)' onblur="changeKeepAmount(this.form)"/>
		</td>
	</tr>
	<tr>
		<td class='table_item' colspan='10'><hr/></td>
	</tr>
	<tr>
		<td class='table_item' rowspan='2'>保<br>留<br>數</td>
		<td class='table_item'width="10%">公債</td>
		<td class='table_item'width="10%">非排限</td>
		<td class='table_td'><div id="keepUamount1"><bean:write name='Gama0503Form' property='BigDecimal(keepUamount1)' format="#,##0"/></div></td>
		<td class='table_item'width="10%">排限</td>
		<td class='table_td'><div id="keepBamount1"><bean:write name='Gama0503Form' property='BigDecimal(keepBamount1)' format="#,##0"/></div></td>
	</tr>
	<tr>
		<td class='table_item'width="10%">中長期借款</td>
		<td class='table_item'width="10%">非排限</td>
		<td class='table_td'><div id="keepUamount2"><bean:write name='Gama0503Form' property='BigDecimal(keepUamount2)' format="#,##0"/></div></td>
		<td class='table_item'width="10%">排限</td>
		<td class='table_td'><div id="keepBamount2"><bean:write name='Gama0503Form' property='BigDecimal(keepBamount2)' format="#,##0"/></div></td>
	</tr>
	<tr>
		<td class='table_item' colspan='10'><hr/></td>
	</tr>
	<tr>
		<td class='table_item' rowspan='2'>剩<br>餘<br>保<br>留<br>數</td>
		<td class='table_item'width="10%">公債</td>
		<td class='table_item'width="10%">非排限</td>
		<td class='table_td'><div id="oddKeepUamount1"><bean:write name='Gama0503Form' property='BigDecimal(oddKeepUamount1)' format="#,##0"/></div></td>
		<td class='table_item'width="10%">排限</td>
		<td class='table_td'><div id="oddKeepBamount1"><bean:write name='Gama0503Form' property='BigDecimal(oddKeepBamount1)' format="#,##0"/></div></td>
	</tr>
	<tr>
		<td class='table_item'width="10%">中長期借款</td>
		<td class='table_item'width="10%">非排限</td>
		<td class='table_td'><div id="oddKeepUamount2"><bean:write name='Gama0503Form' property='BigDecimal(oddKeepUamount2)' format="#,##0"/></div></td>
		<td class='table_item'width="10%">排限</td>
		<td class='table_td'><div id="oddKeepBamount2"><bean:write name='Gama0503Form' property='BigDecimal(oddKeepBamount2)' format="#,##0"/></div></td>
	</tr>
</table>
