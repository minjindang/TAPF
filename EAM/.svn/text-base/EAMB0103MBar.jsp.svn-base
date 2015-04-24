<!-- EAMB0103MBar.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<%if ("03".equals(((String)session.getAttribute("SYSID")).substring(4,6))){%>
				<html:submit styleClass='formcss_rbutton' value='新增傳票明細' property="doAddVoucherDet"/>
			<%}
			else{%>
			<html:button styleClass='formcss_rbutton' value='全選' property='selectAll' onclick='checkedAll(this.form);' />
			<html:button styleClass='formcss_rbutton' value='全不選' property='cancelAll' onclick='notCheckedAll(this.form);' />
			<%}%>
			<html:submit styleClass='formcss_rbutton' property='doMakeVoucher' value='製作傳票'/>
			<%if (!"A".equals((String)session.getAttribute("debtTypeCode"))){ %>
				<html:submit styleClass='formcss_rbutton' property='doMakeAndPrintVoucher' value='製作並列印傳票'/>
			<%} %>
			<html:submit styleClass='formcss_rbutton' property='backList' value='回上一頁'/>
		</td>
	</tr>
</table>
