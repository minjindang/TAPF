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
    if ("" == form.elements['date(issueDate)'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�I�����j���i�ť�!!";
        form.elements['date(issueDate)'].focus();
        alert(sError);
        return isValid;
    }
    if (!(CheckValidDate(form.elements['date(issueDate)'].value)))
    {
    	isValid = false;
    	form.elements['date(issueDate)'].select();
		return isValid;
    }
	return isValid;
}
//-->
</script>
