<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<table class='table_2' width='100%'>
	<tr>
		<td colspan='5'>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="提前買回金額">
					<div align="right"><bean:write name='row' property='capitalAmount' format='#,###'/> 元</div>
				</display:column>
				<display:column title="最低得標利率">
					<div align="right"><bean:write name='row' property='averageRate' format='###.####'/> %</div>
				</display:column>
				<display:column title="提前買回日期">
					<div align="right"><bean:write name='row' property='repayDate' format='yyyy/MM/dd'/></div>
				</display:column>
				<display:column title="應計利息">
					<div align="right"><bean:write name='row' property='advanceTax' format='#,###'/> 元</div>
				</display:column>
				<display:column title="買回溢(折)價">
					<div align="right"><bean:write name='row' property='buyPremium' format='#,###'/> 元</div>
				</display:column>
				<display:column title="買回價款">
					<div align="right"><bean:write name='row' property='buyAmount' format='#,###'/> 元</div>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
