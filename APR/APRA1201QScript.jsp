<!--	APRA1101QScript.jsp
�{���ت��GAPRA1101�����F���n�������٥��I�������C�L
�{���N���GAPRA11
�{������G0950316
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

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
    if ("" == form.elements['debtName'].value ) 
    {
           isValid = false;
		   sError += "\n";
           sError += "�i���ŦW�١j���i�ť�!!";
    }
    if ("" == form.elements['date(closeSdate)'].value ) 
    {
           isValid = false;
		   sError += "\n";
           sError += "�i����_�j���i�ť�!!";
    }
    if ("" == form.elements['date(closeEdate)'].value ) 
    {
           isValid = false;
		   sError += "\n";
           sError += "�i������j���i�ť�!!";
    }
    if (!(CheckValidDate(form.elements['date(closeSdate)'].value)))
    {
    	return false;
    }
    if (!(CheckValidDate(form.elements['date(closeEdate)'].value)))
    {
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
