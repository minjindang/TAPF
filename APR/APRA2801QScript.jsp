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
    if ("" == form.payYearMonth.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�٥��I���~��j���i�ť�!!";
        form.payYearMonth.focus();
        alert(sError);
        return isValid;
    }
	if (5 != form.payYearMonth.value.length)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�٥��I���~��j�榡�����T!!";
        form.payYearMonth.focus();
        alert(sError);
        return isValid;
    }
	return isValid;
}
//-->
</script>
