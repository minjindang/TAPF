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
function getSelect(obj)
{
	if( obj.budgetCode.value!="" )
		obj.budgetName.value = obj.budgetCode.options[obj.budgetCode.selectedIndex].text;
	else
		obj.budgetName.value = "�`��";	
	
}
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
    if ("" == form.elements['date(limitDate)'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�P������j���i�ť�!!";
        form.elements['date(limitDate)'].focus();
        alert(sError);
        return isValid;
    }
    if (!(CheckValidDate(form.elements['date(limitDate)'].value)))
    {
    	isValid = false;
    	form.elements['date(limitDate)'].select();
		return isValid;
    }
	return isValid;
}
//-->
</script>
