<!-- HAMB0201MScript.jsp
�{���ت��GHAMB02�ˬd�O�_����J��
�{���N���GHAMB02
�{������G0950222
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
  document.MainForm.pname.value = '�]�F����w�p';
}
function getHiddenValues()
{
	var	currform	=	document.MainForm;
	var	taxYear		=	currform.taxYear.value;
	var	taxMonth	=	currform.taxMonth.value
	if( ""!=taxYear && ""!=taxMonth )
	{
		currform.action='HAMB0202';
		currform.submit();
	}
}
function checkValue(form)
{	
	if(form.taxMonth.value.length!= 5){
		alert("�i���t�~��j�榡���~!");
		return false;
	}
	var cols = new Array( "taxYear" , "taxMonth" , "monNo" , "bankno" , "monKind" , "pname");
	var colNames = new Array("�i�O�b�~�סj", "�i���t�~��j" , "�i�帹�j" , "�i�״ڦ�渹�j" , "�i�����j" , "�i�״ڤH�m�W�j");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "���i�ť�!!");
	}
	return (result < 0);
}

//-->
</script>
