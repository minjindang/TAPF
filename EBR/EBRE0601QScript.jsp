
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
    if ("" == form.elements['debt_name'].value ) 
    {
           isValid = false;
		   sError += "\n";
           sError += "���ŦW�� ���i�ť�!!";
    }
    if ("" == form.elements['accountYear'].value ) 
    {
           isValid = false;
		   sError += "\n";
           sError += "�i�o��~�סj���i�ť�!!";
    }
    
	if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}

//-->
</script>
