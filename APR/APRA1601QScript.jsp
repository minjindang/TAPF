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
<script language="Javascript" src="/tapf/assets/scripts/DateUtil.js"></script>
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
    if (!(CheckValidDate(form.elements['date(closeSdate)'].value)))
    {
    	isValid = false;
    	return isValid;
		
    }
    if (!(CheckValidDate(form.elements['date(closeEdate)'].value)))
    {
    	isValid = false;
    	return isValid;
		
    }
	if ("" == form.elements['date(closeSdate)'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�_��j���i�ť�!!";
    }
    if ("" == form.elements['date(closeEdate)'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i����j���i�ť�!!";
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}

//-->
</script>