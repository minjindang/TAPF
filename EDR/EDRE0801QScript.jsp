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
    if ("" == form.elements['accountYear'].value ) 
    {
           isValid = false;
		   sError += "\n";
           sError += "【發行年度】不可空白!!";
    }
    if ("" == form.elements['month'].value ) 
    {
           isValid = false;
		   sError += "\n";
           sError += "【發行月份】不可空白!!";
    }
	if(!isValid)
	{
		alert(sError);
	}
    return isValid;
}
//-->
</script>
