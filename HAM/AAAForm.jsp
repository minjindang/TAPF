<!-- HAMB0301MForm.jsp
程式目的：HAMB03
程式代號：HAMB03
程式日期：0950221
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>案號</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' property='taxYear' size='10' maxlength='10'/>
		</td>
		<!-- 
		<td class='table_td'>
			<SELECT  >
				<OPTION VALUE=""  selected="true"  />--請選擇--
			</SELECT>
		</td> -->
	</tr>
	<tr>
		<td class='table_item'>建立者</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' property='taxYear' size='10' maxlength='10'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>建立時間</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' property='taxYear' size='10' maxlength='10'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>修改者</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' property='taxYear' size='10' maxlength='10'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>修改時間</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' property='taxYear' size='10' maxlength='10'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>案例名稱</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' property='taxYear' size='10' maxlength='10'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>所屬作業</td>
		<td class='table_td'>
			<SELECT  >
				<OPTION VALUE=""  selected="true"  />--請選擇--
			</SELECT>
			<html:text name='Hamb0301Form' property='taxYear' size='20' maxlength='20' value="作業1,作業2"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>案例內容</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' property='taxYear' size='10' maxlength='10'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>停用</td>
		<td class='table_td'>
			是否停用<input type="checkbox" name="bondType" value="on">
		</td>
	</tr>
	<tr>
		<td class='table_item'>停用原因</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' property='taxYear' size='10' maxlength='10'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>停用日期</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' property='taxYear' size='10' maxlength='10'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>案件相關檔案列表及上傳</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' property='taxYear' size='20' maxlength='20'/>
			<html:submit styleClass='formcss_rbutton' property='doCount' value='上傳'/>檔案1,檔案2
		</td>
	</tr>
	<tr>
		<td class='table_item'>說明</td>
		<td class='table_td'>
			<html:textarea name='Hamb0301Form' property='taxYear' rows="5" cols="30"/>
		</td>
	</tr>
</table>
<!-- 
<table class="table_list"  width='100%'>
	<thead>
		<th>案號</th>
		<th>案例名稱</th>
		<th>停用</th>
		<th>案例內容</th>
	</thead>
	<tbody>
		<tr class="odd">
			<td>xxxxxxxxxxxx</td>
			<td>xxxxxxxxxxxx</td>
			<td></td>
			<td>xxxxxxxxxxxx</td>
		</tr>
		<tr class="odd">
			<td>xxxxxxxxxxxx</td>
			<td>xxxxxxxxxxxx</td>
			<td></td>
			<td>xxxxxxxxxxxx</td>
		</tr>
		<tr class="odd">
			<td>xxxxxxxxxxxx</td>
			<td>xxxxxxxxxxxx</td>
			<td></td>
			<td>xxxxxxxxxxxx</td>
		</tr>
		<tr class="odd">
			<td>xxxxxxxxxxxx</td>
			<td>xxxxxxxxxxxx</td>
			<td></td>
			<td>xxxxxxxxxxxx</td>
		</tr>
		<tr class="odd">
			<td>xxxxxxxxxxxx</td>
			<td>xxxxxxxxxxxx</td>
			<td></td>
			<td>xxxxxxxxxxxx</td>
		</tr>
		<tr class="odd">
			<td>xxxxxxxxxxxx</td>
			<td>xxxxxxxxxxxx</td>
			<td></td>
			<td>xxxxxxxxxxxx</td>
		</tr>
		<tr class="odd">
			<td>xxxxxxxxxxxx</td>
			<td>xxxxxxxxxxxx</td>
			<td></td>
			<td>xxxxxxxxxxxx</td>
		</tr>
		<tr class="odd">
			<td>xxxxxxxxxxxx</td>
			<td>xxxxxxxxxxxx</td>
			<td></td>
			<td>xxxxxxxxxxxx</td>
		</tr>
		<tr class="odd">
			<td>xxxxxxxxxxxx</td>
			<td>xxxxxxxxxxxx</td>
			<td></td>
			<td>xxxxxxxxxxxx</td>
		</tr>
		<tr class="odd">
			<td>xxxxxxxxxxxx</td>
			<td>xxxxxxxxxxxx</td>
			<td></td>
			<td>xxxxxxxxxxxx</td>
		</tr>
	</tbody>
</table>
-->
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doCount' value='新增'/>
			<html:submit styleClass='formcss_rbutton' property='doCount' value='清除'/>
			<html:submit styleClass='formcss_rbutton' property='doCount' value='回查詢'/>
		</td>
	</tr>
</table>
