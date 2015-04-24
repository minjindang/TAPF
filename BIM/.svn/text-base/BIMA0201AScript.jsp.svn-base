<!-- BIMA0201AScript.jsp
程式目的：BIMA02
程式代號：BIMA02
程式日期：0950223
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ page import="gov.dnt.tame.util.DateUtil" %>
<%@ page import="java.util.Date" %>
<script language="Javascript">
function doBodyOnLoad(document)
{
	<logic:empty name='Bima0201Form' property='repayDate' >
  		document.MainForm.elements['date(repayDate)'].value =<%out.println("'"+DateUtil.date2ROCStr(new Date())+"'");%>;
  	</logic:empty>
  	document.MainForm.elements['date(modDate)'].value =<%out.println("'"+DateUtil.date2ROCStr(new Date())+"'");%>;
  	//document.MainForm.elements['date(createDate)'].value =<%out.println("'"+DateUtil.date2ROCStr(new Date())+"'");%>;
}
function checkValue(form)
{
	var isValid = true;
    var sError = "";
	if ("" == form.issueId.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "原始發行期別不可空白!!";
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}
function changeAmount(form){
	if(form.buyStatus.value == "0")
		form.elements['bigDecimal(buyAmount)'].value = 0;
}
function getIssue(form){
	if(form.issueId.value != "" )
		doAction('BIMA0204C')
}
function setIssue2(form)
{
	if("" != form.elements['bigDecimal(balanceCapitalAmount)'].value && "" != form.elements['bigDecimal(capitalAmount)'].value)
	{
		//document.getElementById("issue2").innerHTML = addMoneyMask(
		//Number(replaceAll(form.elements['bigDecimal(issueAmount)'].value,",",""))
		//- Number(replaceAll(form.elements['bigDecimal(balanceCapitalAmount)'].value,",","")) );
	}	
}
//-->
</script>
