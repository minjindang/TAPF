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
		form.debtName.value = form.accountYear.value + "-" + form.serialNo.value + "���A�ӱ��Ű�";
	}
}
function checkValue(form)
{
	var cols = new Array("showType" , "accountYear", "serialNo", "issueSerial" , "bigDecimal(expectAmount)" );
	var colNames = new Array("�i������O�j", "�i�~�סj", "�i�����j", "�i���O�j"  , "�i�w�p�ɴڪ��B�j" );
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "���i�ť�!!");
	}
	if (form.elements['date(dueDate)'].value !='' &&  form.elements['date(issueDate)'].value != '' ){
	    if (form.elements['date(dueDate)'].value < form.elements['date(issueDate)'].value )
	    {
	        alert("�ɴڰ_�餣�i�j��ɴڨ���!!");
	        result = 1;
	    }
	    if("" == form.textCount.value && result < 0)
	    {
	    	alert("�ɴڤѴ����i�ť�!!");
	        result = 1;
	    }
	}
	return result < 0;
}

//-->
</script>
