<!-- HARC0801PScript.jsp
�{���ت��GHARC08�ˬd�O�_����J��
�{���N���GHARC08
�{������G0950221
�{���@�̡GEric.Chen
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
    var year
    var month = form.supMonth.value ;
    /*if (month > 13 || month = 0)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i���ڤ���j���~!!";
    }*/
	if ("" == form.supYear.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�O�b�~�סj���i�ť�!!";
    }
    if ("" == form.supMonth.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i���ڤ���j���i�ť�!!";
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}

//-->
</script>
