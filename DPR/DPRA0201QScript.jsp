<!-- APRA1501AScript.jsp
�{���ت��GAPRA15�ˬd�O�_����J��
�{���N���GAPRA15
�{������G0950221
�{���@�̡GAndrew Sung
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
    if ("" == form.issueId.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i���O�j���i�ť�!!";
        form.issueId_options.focus();
        alert(sError);
        return isValid;
    }
    if (!(CheckValidDate(form.elements['date(payDate)'].value)))
    {
    	isValid = false;
    	form.elements['date(payDate)'].select();
		return isValid;
    }
	return isValid;
}

//-->
</script>
