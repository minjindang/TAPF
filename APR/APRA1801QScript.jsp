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
function getSelectValue(obj)
{
	if( obj.issueId.value!="" )
		obj.debtName.value = obj.issueId.options[obj.issueId.selectedIndex].text;
	else
		obj.debtName.value = "";
	
}
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
    if (!(CheckValidDate(form.elements['date(closeDate)'].value)))
    {
    	isValid = false;
    	return isValid;
    }
	if ("" == form.elements['date(closeDate)'].value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�I�����j���i�ť�!!";
    }
    if ("" == form.debtName.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i���ŦW�١j���i�ť�!!";
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}

//-->
</script>
