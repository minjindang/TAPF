<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>

<display:table class="table_list" name="requestScope.collection" id="row" defaultsort="1">
	<logic:notEmpty name="row">
		<bean:write name='row' property='id' scope="page"/>
		<font size="2">
		<display:column title="債務代碼"  style="font-size:13px;width: 20" property="issueId" decorator="tw.gov.nta.account.form.IssueDecorator" />
		<display:column title="傳票號碼" property="voucherNo" style="font-size:13px"/>
		<display:column title="傳票日期" property="voucherDate" style="font-size:13px" decorator="tw.gov.nta.account.form.ROCDateDecorator"/>
		<display:column title="摘要" style="font-size:13px;width: 25%" property="remark"/> 
		<display:column title="過帳否" style="font-size:13px" >
			<logic:notEmpty name="row" property="postDate">
				是
			</logic:notEmpty>
		</display:column>
		<logic:notEmpty name="row" property="voucherDets">
			<bean:define id="voucher" name="row" property="voucherDets"/>
			<display:column title="會計科目　　　　　　　　　　　　借方金額　　　　　　　　　貸方金額">
				<table class="table_list" border="2">

				<logic:iterate id="detail" name="voucher">
					<tr>
						<td>
							<logic:equal value="C" name="detail" property="accountType">　</logic:equal>
							<font size="2"><bean:write name="detail" property="account.accountName"/></font>
							
						</td>
						<td align="right">
							<div align="right">
							<font size="2">
								<logic:equal value="D" name="detail" property="accountType">
									<bean:write name="detail" property="accountAmount" format="####,###"/>
								</logic:equal>
							</font>
							</div>
						</td>
						<td>
							<div align="right">
							<font size="2">
								<logic:equal value="C" name="detail" property="accountType">
									<bean:write name="detail" property="accountAmount" format="####,###"/>
								</logic:equal>
							</font>
							</div>
						</td>
					</tr>
				</logic:iterate>
				</table>
			</display:column>	
		</logic:notEmpty>	
		</font>
	</logic:notEmpty> 
</display:table>
