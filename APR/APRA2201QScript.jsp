<!-- APRA2201AScript.jsp
�{���ت��GAPRA22�ˬd�O�_����J��
�{���N���GAPRA22
�{������G0950404
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
    if ("" == form.killYear.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�~�סj���i�ť�!!";
        form.killYear.focus();
        alert(sError);
        return isValid;
    }
    if (form.killYear.value.length <3)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�~�סj�榡���~!!";
        form.killYear.select();
        alert(sError);
        return isValid;
    }
    return isValid;
}
/*function checkForm(form)
{
	var cols = new Array("issueId");
	var colNames = new Array("���ŦW��");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "�A����J!!");
	}
	return result < 0;
}*/

//-->
</script>
