<!--	APRA0701Q.jsp
�{���ت��GAPRA07�����F�����餽���٥��I���ֵ����B��
�{���N���GAPRA07
�{������G0950316
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
function checkValue(form)
{
	var cols = new Array( "date(closeSdate)","date(closeEdate)");
	var colNames = new Array("�i�ҩl����j","�i��������j");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "���i�ť�!!");
	}
    if (form.elements['date(closeEdate)'].value < form.elements['date(closeSdate)'].value)
    {
        alert("����������i�p��ҩl���!!");
    }
	return (result < 0);
}

//-->
</script>