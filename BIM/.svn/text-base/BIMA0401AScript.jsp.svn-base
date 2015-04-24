<%@ page pageEncoding="Big5" %>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
	
}

function getDays(form)
{
	var	currform	=	document.MainForm;
	var	issueDate		=	currform.elements['date(issueDate)'].value;
	var	dueDate 	=	currform.elements['date(dueDate)'].value
	
	if (!(CheckValidDate(issueDate)) || !(CheckValidDate(dueDate)))
    {
    	return false;
    }
   	else if (issueDate !="" && dueDate != "")
   	{
		var bigDate = currform.elements['date(issueDate)'].value ;
		var endDate = currform.elements['date(dueDate)'].value ;
		if("" != bigDate && null != bigDate && "" != endDate && null != endDate )
		{
			document.getElementById("issueDays").innerHTML = daycount(bigDate,endDate,"C") ;
		}
	}
}
//-->
</script>