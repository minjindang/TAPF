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
function doBodyOnLoad(document)
{
  //nothing
}
function getSelectDebt(obj)
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
    if ("" == form.debtName.value || 0 == form.debtName.value )
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
</script>
