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
    if ("" == form.elements['date(repaySdate)'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i���٥��I������_��j���i�ť�!!";
        form.elements['date(repaySdate)'].focus();
        alert(sError);
        return isValid;
    }
     if ("" == form.elements['date(repayEdate)'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i���٥��I���������j���i�ť�!!";
        form.elements['date(repayEdate)'].focus();
        alert(sError);
        return isValid;
    }
    if (!(CheckValidDate(form.elements['date(repaySdate)'].value)))
    {
    	isValid = false;
    	form.elements['date(repaySdate)'].select();
		return isValid;
    }
     if (!(CheckValidDate(form.elements['date(repayEdate)'].value)))
    {
    	isValid = false;
    	form.elements['date(repayEdate)'].select();
		return isValid;
    }
	return isValid;
}
//-->
</script>
