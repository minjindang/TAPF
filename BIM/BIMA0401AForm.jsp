<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='15%'>發行年度</td>
		<td class='table_td'>
			<html:text name='Bima0401Form' property='accountYear' size='3' maxlength='3' />
		</td>
		<td class='table_item' width='15%'>買回期別</td>
		<td class='table_td' colspan="3">
			<html:text name='Bima0401Form' property='issueSerial' size='7' maxlength='5' />
		</td>
	</tr>
	<tr>
		<td class='table_item' width='15%'>檔案代號</td>
		<td class='table_td'>
			<html:text name='Bima0401Form' property='fileNo' size='10' maxlength='10' />
		</td>
		<td class='table_item' width='15%'>國庫券名稱</td>
		<td class='table_td' colspan="3">
			<%pageContext.setAttribute("collectionIssuecode",tw.gov.nta.debt.common.IssueManager.getDebtNameLabelList("B")); %>
			<html:select name='Bima0401Form' property='issueId'>
					<html:option value="">請選擇</html:option>
					<html:options collection="collectionIssuecode" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>	
		</td>
	</tr>
	<tr>
		<td class='table_item' width='15%'>發行日期</td>
		<td class='table_td'>
			<html:text name='Bima0401Form' property='date(issueDate)' size='7' maxlength='7' onblur="getDays(form)"/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(issueDate)",new Integer(0))%>
		</td>
		<td class='table_item' width='15%'>到期日期</td>
		<td class='table_td' colspan="3">
			<html:text name='Bima0401Form' property='date(dueDate)' size='7' maxlength='7' onblur="getDays(form)"/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(dueDate)",new Integer(1))%>
		</td>
	</tr>
	<tr>
		<td class='table_item' width='15%'>發行天數</td>
		<td class='table_td' id="issueDays" colspan="6">
			
		</td>
	</tr>
	<tr>
		<td class='table_item' width='15%'>買回日期</td>
		<td class='table_td'>
			<html:text name='Bima0401Form' property='date(aheadDate)' size='7' maxlength='7' onblur=""/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(aheadDate)",new Integer(3))%>
		</td>
		<td class='table_item' width='15%'>買回種類</td>
		<td class='table_td' colspan="3">
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("IK"),"bondType",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item' width='15%'>發行金額</td>
		<td class='table_td'>
			<html:text name='Bima0401Form' property='bigDecimal(issueAmount)' size='15'/>
		</td>
		<td class='table_item' width='15%'>報價總面額</td>
		<td class='table_td'>
			<html:text name='Bima0401Form' property='bigDecimal(bidAmount)' size='15'/>
		</td>
		<td class='table_item' width='15%'>底價利率</td>
		<td class='table_td'>
			<html:text name='Bima0401Form' property='bigDecimal(bidRate)' size='15' />%
		</td>
	</tr>
	<tr>
		<td class='table_item' width='15%'>買回總面額</td>
		<td class='table_td'>
			<html:text name='Bima0401Form' property='bigDecimal(gotbidAmount)' size='15' />
		</td>
		<td class='table_item' width='15%'>原始成本</td>
		<td class='table_td'>
			<html:text name='Bima0401Form' property='bigDecimal(orgissueAmount)' size='15' />
		</td>
		<td class='table_item' width='15%'>利息總額</td>
		<td class='table_td'>
			<html:text name='Bima0401Form' property='bigDecimal(interestAmount)' size='15' />
		</td>
	</tr>
	<tr>
		<td class='table_item' width='15%'>最高買回利率</td>
		<td class='table_td'>
			<html:text name='Bima0401Form' property='bigDecimal(hightRate)' size='15' />%
		</td>
		<td class='table_item' width='15%'>最低買回利率</td>
		<td class='table_td'>
			<html:text name='Bima0401Form' property='bigDecimal(lowRate)' size='15' />%
		</td>
		<td class='table_item' width='15%'>加權平均利率</td>
		<td class='table_td'>
			<html:text name='Bima0401Form' property='bigDecimal(averageRate)' size='15'  />%
		</td>
	</tr>
</table>
