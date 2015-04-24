<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<script language="javascript">

function doBodyOnLoad(document)
{
		//do nothing
}

function checkForm(form)
{
	var cols = new Array("budgetCode" , "debtCode", "BigDecimal(issueAmountx)");
	var colNames = new Array("預算別", "債務別", "發行額");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("【" + colNames[result] + "】，未輸入!!");
	}
	return result < 0;
}
function changeList(form)
{
	form.action = "AIMA0302AList" ;
	form.submit() ;
}
</script>