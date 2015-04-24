<!--
程式目的：EAMA02文字
程式代號：EAMA02
程式日期：0950301
程式作者：FormBean Generator
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
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doQry' value='查詢'/>
			<logic:notEmpty name="collection">
				<%	//特殊傳票不進行批次產生傳票
					if (!"3".equals(String.valueOf(((String)session.getAttribute("SYSID")).charAt(5)))){%>
					<html:submit styleClass='formcss_rbutton' property='batchMakeVoucher' value='批次產生傳票'/>
				<%}%>
			</logic:notEmpty>
			<html:reset  styleClass='formcss_rbutton' property='reset' value='清除'/>
		</td>
	</tr>
</table>
