<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">

function doBodyOnLoad(document)
{
  //nothing
}
function rateLimit(form)
{
	var tempValue = 0;
    var tempCount = form.elements['bigDecimal(debtRate)'].value;
    var tempLength = tempCount.length;
    if( tempCount.indexOf(".")< 0 )
    {
        tempValue = 0 ;
    }	
    else
    {
        tempValue = tempCount.indexOf(".") - 3 ;
    }
    form.elements['bigDecimal(debtRate)'].value = tempCount.substring(tempValue,tempLength);
   
}
function checkValue(form)
{
 	var cols = new Array( "date(effectiveDate)" , "date(suspendDate)" , "bigDecimal(debtRate)");
	var colNames = new Array("�i�Q�v�ͮĤ���j", "�i�Q�v�פ����j" , "�i�Q�v�j");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "���i�ť�!!");
	}
	if (form.elements['date(effectiveDate)'].value > form.elements['date(suspendDate)'].value)
    {
        alert("�Q�v�ͮĤ�����i�j��Q�v�פ���!!");
        result = 1 ;
    }
	return (result < 0);
}

</script>
