<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
  //nothing
}
function checkValue(form)
{
	var cols = new Array( "newDueDate");
	var colNames = new Array("�i�����ɴڴ����j");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "���i�ť�!!");
	}
	return (result < 0);
}
function checkDueDate(form)
{
	if (form.elements['newDueDate'].value != ""){
		if (!(CheckValidDate(form.elements['newDueDate'].value))){
			form.elements['newDueDate'].value = "";
		}
		else{
	    	if (form.elements['newDueDate'].value < form.elements['date(dueDate)'].value ){
	        	alert("�����ɴڴ����p���l�ɴڨ���!!");
	        	form.elements['newDueDate'].value = "";
	    	}
	    }
	}
}
//-->
</script>
