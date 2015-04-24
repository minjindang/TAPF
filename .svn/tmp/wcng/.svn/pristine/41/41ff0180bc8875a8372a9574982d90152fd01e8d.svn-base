
<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
  //nothing
}
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
/*
    if("" == form.budgetCode.value || 0 == form.budgetCode.value)
    {
    	isValid = false;
    	sError = sError + "【預算別】不可空白!!";
    	alert(sError);
    	return isValid;
    }
    if("" == form.debtCode.value || 0 == form.debtCode.value)
    {
    	isValid = false;
    	sError = sError + "【債務別】不可空白!!";
    	alert(sError);
    	return isValid;
    }
*/
    if(form.elements['date(startDate)'].value != "" || form.elements['date(endDate)'].value != "")
   	{
   		if (!(CheckValidDate(form.elements['date(startDate)'].value)))
    	{
	    	isValid = false;
	    	form.elements['date(startDate)'].select();
			return isValid;
   		 }
   		 if (!(CheckValidDate(form.elements['date(endDate)'].value)))
    	{
	    	isValid = false;
	    	form.elements['date(endDater)'].select();
			return isValid;
   		 }
   	
   	}
	return isValid;
}

//-->
</script>
