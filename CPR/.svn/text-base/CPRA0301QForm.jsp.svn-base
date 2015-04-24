<!--	CPRA0301QForm.jsp
程式目的：CPRA0301
程式代號：CPRA0301
程式日期：0950316
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>期別</td>
		<td class='table_td'>
			<html:select name="Cpra0301Form" property="issueId" onchange="getSelectItem(this.form)" >
					<html:option value="">請選擇</html:option>
					<html:optionsCollection name="Cpra0301Form" property="serialNoList" label="label" value="valuess" />
			</html:select>
			<html:hidden name="Cpra0301Form" property="issueSerial" />
		</td>
	</tr>
	<tr>
		<td class='table_item'>付息日期</td>
		<td class='table_td'>
			<html:select name="Cpra0301Form" property="date(payDate)">
					<html:option value="">請選擇</html:option>
					<html:optionsCollection name="Cpra0301Form" property="payDateList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item' rowspan="2">利息備註</td>
		<td class='table_td'>
			<html:radio name="Cpra0301Form" property="note" value="固定計息,按年支付,每年依各貸款行牌告基本放款固定利率調整一次."/>固定計息,按年支付,每年依各貸款行牌告基本放款固定利率調整一次.
		</td>
	</tr>
	<tr>
		<td class='table_td'>
			<html:radio name="Cpra0301Form" property="note" value="固定計息,按年支付,每年依中華郵政公司牌告一年期定期儲蓄存款固定利率調整一次."/>固定計息,按年支付,每年依中華郵政公司牌告一年期定期儲蓄存款固定利率調整一次.
		</td>
	</tr>			
</table>