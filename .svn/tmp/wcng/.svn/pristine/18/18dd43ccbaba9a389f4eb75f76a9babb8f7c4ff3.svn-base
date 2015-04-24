<!--
程式目的：配合GBA補轉入會計傳票
程式代號：EARE14
程式日期：0961210
程式作者：
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@taglib uri="/tags/struts-bean" prefix="bean" %>
<%@taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 

<table class='table_1' width='100%'>
	<tr>
		
		<td class='table_item'>傳票轉入時間</td>		
		<td class='table_td'>
			<input type="text" name="convertDate" value='<c:out value="${Eare1401Form.convertDate}"/>' />2008/06/04
		</td> 
		 
	</tr>
	<tr>
		<td class='table_item'>選擇折溢價</td>
		<td class='table_td'>
			<select name="convertType"><option value="">請選擇</option>
				<option value="A">溢價</option>	
				<option value="B">折價</option></select>
		</td>
	</tr>

	<tr>
		<td class='table_item'>傳票轉入種類</td>
		<td class='table_td'>
			<select name="convertTiming"><option value="">請選擇</option>
				<option value="1">發行</option>	
				<option value="2">攤銷</option></select>
		</td>
	</tr>
	
		<tr>
		<td class='table_item'>處理溢折價或是發行成本額</td>
		<td class='table_td'>
			<select name="convertKind"><option value="">請選擇</option>
				<option value="3">溢折價</option>	
				<option value="4">發行成本額</option></select>
		</td>
	</tr>

</table>