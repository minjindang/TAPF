<!-- GARA3901QScript.jsp -->
<%@ page pageEncoding="Big5" %>

<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
	var curdate = new Date();
	var year = String(curdate.getFullYear()-1911);
	if( year.length==2 )
		year = "0" + year;
	document.MainForm.year.value = year;
}
function checkForm(form)
{
	var cols = new Array("year","reportType");
	var colNames = new Array("統計年度","報表種類");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("【" + colNames[result] + "】，未輸入!!");
	}

	if( form.reportType.value=='2' )
	{
		if( form.debtType.value=='' )
		{
			alert("【債種】，未選擇!!");
		}
	}


	return result < 0;
}

function changeReportType(form)
{
	if( form.reportType.value=='1' )
	{
		form.debtType.value='';
		form.debtType_options.value='';
		form.debtType_options.disabled=true;
	}
	else
	{
		form.debtType_options.disabled=false;
	}
}
//-->
</script>
