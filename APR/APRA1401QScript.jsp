<!--	APRA1401QScript.jsp
�{���ت��GAPRA1401���餽���ഫ�n�����ťb�~����C�L
�{���N���GAPRA1401
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
 	var cols = new Array("date(closeSdate)" , "date(closeEdate)" , "bankName_options" );
	var colNames = new Array("�i����_��j", "�i�������j" , "�i�M��Ȧ�j");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "���i�ť�!!");
	}
    if (form.elements['date(closeEdate)'].value < form.elements['date(closeSdate)'].value)
    {
        alert("�ֵ�������餣�i�p��ֵ�����_��!!");
        result = 1 ;
    }
		return (result < 0);
}

//-->
</script>
