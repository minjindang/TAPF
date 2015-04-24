<!-- CIMA0101AScript.jsp -->
<%@ page pageEncoding="Big5" %>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
	getSerial(document.forms[0]);
	document.forms[0].elements['bigDecimal(expectAmount)'].value = '00,000,000';
}

function changeValue(form)
{
	form.action = "GAMA01" ;
	form.submit() ;
}

function changeDate(form)
{		
		var bigDate = form.elements['date(issueDate)'].value ;
		var endDate = form.elements['date(dueDate)'].value ;
		var showType = form.showType.value;
		if(showType == 0){
			showType = "C";
		}
		if("" != bigDate && null != bigDate && "" != endDate && null != endDate && "" != showType && null != showType)
		{
			form.textCount.value = daycount(bigDate,endDate,showType) ;
			document.getElementById("dayid").innerHTML = daycount(bigDate,endDate,showType) ;
		}
}
function getSerial(form)
{
	if("" != form.accountYear.value 
	&& "" != form.serialNo.value 
	&& null != form.accountYear.value 
	&& null != form.serialNo.value )
	{
		document.getElementById("issueSerialid").innerHTML = form.accountYear.value + "-" + form.serialNo.value ;
		form.issueSerial.value = form.accountYear.value + "-" + form.serialNo.value ;
		form.debtName.value = form.accountYear.value + "-" + form.serialNo.value + "概括承接債務";
	}
}
function checkValue(form)
{
	var cols = new Array("showType" , "accountYear", "serialNo", "issueSerial" , "bigDecimal(expectAmount)" );
	var colNames = new Array("【顯示類別】", "【年度】", "【期次】", "【期別】"  , "【預計借款金額】" );
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
	}
	if (form.elements['date(dueDate)'].value !='' &&  form.elements['date(issueDate)'].value != '' ){
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
	}
	return result < 0;
}

//-->
</script>
