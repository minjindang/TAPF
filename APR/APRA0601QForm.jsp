<!--	APRA0601QForm.jsp
程式目的：APRA06中央政府債務基金專戶轉帳支付授權書
程式代號：APRA06
程式日期：0950316
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
		<td class='table_item' width="20%"><font color="red">*</font>還本付息年月</td>
		<td class='table_td'>
			<html:text name='Apra0601Form' property='repayDate' size='10' maxlength='7' onblur=''/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%">是否顯示文字<br>"本月留底不蓋印章"</td>
		<td class='table_td'><html:checkbox name='Apra0601Form' property='showType' /></td>
	</tr>
</table>