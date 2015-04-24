<!--
程式目的：中央政府交換公債交換月報總表
程式代號：AIRC07
程式日期：0950308
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='20%'><font color="#ff000">*</font>交換公債代號</td>
		<td class='table_td'>
			<html:select name='Airc0701Form' property="issueSerial" value="issueSerial" >
				<html:option value="">請選擇</html:option>
				<html:optionsCollection name='Airc0701Form' property="issueSerialList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>年月</td>
		<td class='table_td'>
			<html:text name='Airc0701Form' property='limitDate' size='5' maxlength='5'/>
		</td>
	</tr>
</table>