<!--	APRA1001QScript.jsp
�{���ت��GAPRA10�����F���n�����Ůֵ��֭p��C�L
�{���N���GAPRA10
�{������G0950331
�{���@�̡GERIC CHEN
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
	if( obj.bankId.value!="" )
		obj.bankName.value = obj.bankId.options[obj.bankId.selectedIndex].text;
	else
		obj.bankName.value = "";	
}
function checkValue(form)
{
    var isValid = true;
    var sError = "";
    if ("" == form.elements['debtName'].value ) 
    {
           isValid = false;
		   sError += "\n";
           sError += "�i���ŦW�١j���i�ť�!!";
    }
    if("" == form.elements['bankId'].value)
	{
		isValid = false;
		sError += "\n";
        sError += "�i�Ȧ�W�١j���i�ť�!!";
	}
    if ("" == form.elements['date(closeDate)'].value ) 
    {
           isValid = false;
		   sError += "\n";
           sError += "�i�έp�I�����j���i�ť�!!";
    }
    if (!(CheckValidDate(form.elements['date(closeDate)'].value)))
    {
    	return false;
    }
	if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
	
}

//-->
</script>
