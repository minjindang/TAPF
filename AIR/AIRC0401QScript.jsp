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
	if ("" == form.elements['date(limitDate)'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�I�����j����J!!";
    }
    if ("" != form.elements['date(issueSDate)'].value && 
        "" != form.elements['date(issueEDate)'].value)
    {
      if (form.elements['date(issueSDate)'].value>
              form.elements['date(issueEDate)'].value)
         {
           isValid = false;
		   sError += "\n";
           sError += "�i�o�����j�_ ���i�j�� ��!!";
         }
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}

//-->
</script>
