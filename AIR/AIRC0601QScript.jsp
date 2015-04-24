<%@ page pageEncoding="Big5" %>
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
    if ("" == form.elements['issueSerial'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【債券代號】未輸入!!";
    }
	if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}

//-->
</script>
