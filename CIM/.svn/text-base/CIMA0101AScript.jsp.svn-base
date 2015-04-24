<!-- CIMA0101AScript.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ page import="gov.dnt.tame.util.DateUtil"%>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
	clearForm(document.forms[0]);
	document.getElementById("issueSerialid").innerHTML = "";
	document.getElementById("dayid").innerHTML = "";
	getSerial(document.forms[0]);
	document.forms[0].elements['date(issueDate)'].value = <%="'"+DateUtil.ROCDate()+"'"%>;
	document.forms[0].elements['bigDecimal(expectAmount)'].value = '00,000,000';
}

function changeValue(form)
{
	form.action = "CIMA01" ;
	form.submit() ;
}
function changeYear(form)
{
	if(100 > Number(form.accountYear.value) && 0 != Number(form.accountYear.value))
	{
		if(3 > form.accountYear.value.length)
		{
			form.accountYear.value = "0" + form.accountYear.value;
		}	
	}
}
function changeDate(form)
{		
		var bigDate = form.elements['date(issueDate)'].value ;
		var endDate = form.elements['date(dueDate)'].value ;
		var showType = form.showType.value;
		if("" != bigDate && null != bigDate && "" != endDate && null != endDate && "" != showType && null != showType)
		{
			form.textCount.value = daycount(bigDate,endDate,form.showType.value) ;
			document.getElementById("dayid").innerHTML = daycount(bigDate,endDate,form.showType.value) ;
		}
}
function getSerial(form)
{
	if("" != form.accountYear.value 
	&& "" != form.serialNo.value 
	&& null != form.accountYear.value 
	&& null != form.serialNo.value )
	{
		document.getElementById("issueSerialid").innerHTML = Number(form.accountYear.value) + "-" + form.serialNo.value ;
		form.issueSerial.value = Number(form.accountYear.value) + "-" + form.serialNo.value ;
		form.debtName.value = Number(form.accountYear.value) + "-" + form.serialNo.value + "中長期借款";
	}
}
function checkValue(form)
{
	var cols = new Array("showType" , "accountYear", "serialNo", "issueSerial" , "date(issueDate)" , "date(dueDate)" , "bigDecimal(expectAmount)" );
	var colNames = new Array("【顯示類別】", "【年度】", "【期次】", "【期別】" , "【借款起日】" ,  "【借款迄日】" , "【預計借款金額】" );
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
	}
    if (form.elements['date(dueDate)'].value < form.elements['date(issueDate)'].value )
    {
        alert("借款起日不可大於借款迄日!!");
        result = 1;
    }
    if("" == form.textCount.value && result < 0)
    {
    	alert("借款天期不可空白!!");
        result = 1;
    }
	return result < 0;
}

//-->
</script>
