<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<script language="javascript">

function doBodyOnLoad(document)
{

}

function checkValue(form)
{
 	var isValid = true;
    var sError = "";
    if ("" == form.accountYear.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【年度】不可空白!!";
    }
	if ("" == form.budgetCode.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【預算別】不可空白!!";
    }
    if ("" == form.debtCode.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【債務別】不可空白!!";
    }
    if ("" == form.debtType.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【債種】不可空白!!";
    }
    if ("" == form.boundCode.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【試別碼】不可空白!!";
    }
    if ("" == form.accountKind.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【金額種類】不可空白!!";
    }
    if ("" == form.elements['bigDecimal(issueAmount)'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【借款金額】不可空白!!";
    }
  	if ("" == form.elements['bigDecimal(payAmount)'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【還款金額】不可空白!!";
    }
    if ("" == form.elements['bigDecimal(remainAmount)'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【未償還餘額】不可空白!!";
    }
    if ("" == form.elements['bigDecimal(interestAmount)'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【利息金額】不可空白!!";
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}


</script>