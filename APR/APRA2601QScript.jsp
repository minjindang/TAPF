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
    if ("" == form.elements['date(dueSdate)'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�I�I�����_��j���i�ť�!!";
        form.elements['date(dueSdate)'].focus();
        alert(sError);
        return isValid;
    }
    if (!(CheckValidDate(form.elements['date(dueSdate)'].value)))
    {
    	isValid = false;
    	form.elements['date(dueSdate)'].select();
		return isValid;
    }
    if ("" == form.elements['date(dueEdate)'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�I�I��������j���i�ť�!!";
        form.elements['date(dueEdate)'].focus();
        alert(sError);
        return isValid;
    }
    if (!(CheckValidDate(form.elements['date(dueEdate)'].value)))
    {
    	isValid = false;
    	form.elements['date(dueEdate)'].select();
		return isValid;
    }
	return isValid;
}
//-->
</script>
