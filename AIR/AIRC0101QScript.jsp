<%@ page pageEncoding="Big5" %>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
  //nothing
}

function checkForm(form)
{
 	var isValid = true;
    var sError = "";
    if ("" != form.elements['date(issueSDate)'].value && 
        "" != form.elements['date(issueEDate)'].value)
    {
      if (form.elements['date(issueSDate)'].value>
              form.elements['date(issueEDate)'].value)
         {
           isValid = false;
		   sError += "\n";
           sError += "【發行日期】起 不可大於 迄!!";
         }
    }
    else
    {
    	alert("【日期】不可空白!!");
    	return false;
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}

//-->
</script>
