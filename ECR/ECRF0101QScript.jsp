<%@ page pageEncoding="Big5" %>

<script language="Javascript">

function doBodyOnLoad(document)
{
  //nothing
}
function checkValue(form)
{
 	var isValid = true;
 	if("" != form.reportType.value)
 	{
		if("依期別" == form.reportType.value)
		{
		 	if(null == form.issueId.value || 0 == form.issueId.value || "" == form.issueId.value)
		 	{
		 		alert("請選擇一期債務名稱!");
		 		isValid = false;
		 	}
		}
		else if("依年度" == form.reportType.value)
		{
			if(null == form.issueYear.value || "" == form.issueYear.value)
		 	{
		 		alert("請輸入年度!");
		 		isValid = false;
		 	}
		}	
	}
	else
	{
		alert("請選擇報表顯示方式!");
		isValid = false;
	} 	
	return isValid;
}
</script>
