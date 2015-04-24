<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
  //nothing
}
function getSelectValue(obj)
{
	if( obj.issueId.value!="" )
		obj.debtName.value = obj.issueId.options[obj.issueId.selectedIndex].text;
	else
		obj.debtName.value = "";
	
}
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
    if ("" == form.elements['date(queryDate)'].value ) 
    {
           isValid = false;
		   sError += "\n";
           sError += "【查詢日期】不可空白!!";
    }
    
	if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}

//-->
</script>
