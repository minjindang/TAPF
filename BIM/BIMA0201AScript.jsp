<!-- BIMA0201AScript.jsp
�{���ت��GBIMA02
�{���N���GBIMA02
�{������G0950223
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
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
        sError += "��l�o����O���i�ť�!!";
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
