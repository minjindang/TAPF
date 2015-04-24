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
	var colNames = new Array("【利率生效日期】", "【利率終止日期】" , "【利率】");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
	}
	if (form.elements['date(effectiveDate)'].value > form.elements['date(suspendDate)'].value)
    {
        alert("利率生效日期不可大於利率終止日期!!");
        result = 1 ;
    }
	return (result < 0);
}

</script>
