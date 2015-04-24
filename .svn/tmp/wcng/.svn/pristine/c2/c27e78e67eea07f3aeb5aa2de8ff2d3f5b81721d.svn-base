<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">
function doBodyOnLoad(document)
{
  //nothing
	changeDate(document.forms[0]);
}
function changeList(form)
{
	form.action = "CIMA0101MLIST" ;
	form.submit() ;
}
function changeDate(form)
{		
		var bigDate = form.elements['date(issueDate)'].value ;
		var endDate = form.elements['date(dueDate)'].value ;
		var type = form.showType.value;
		if("" != bigDate && null != bigDate && "" != endDate && null != endDate && "" != type && null != type)
		{
			form.textCount.value = daycount(bigDate,endDate,form.showType.value) ;
			document.getElementById("dayid").innerHTML = daycount(bigDate,endDate,form.showType.value) ;
		}
}
function checkAccrue(form)
{
	var accrue = document.getElementsByName("accrue");
	var ischeck = document.getElementsByName("ischeck");
	var isok = false ;
	for(i = 0 ; i < accrue.length ; i++){
		if( true == accrue[i].checked)
		{
			isok = true ;
			ischeck[i].value = accrue[i].value;
		}
		else
		{
			ischeck[i].value = 0;
		}
	}
	if(false == isok)
	{
		alert("無勾選得標資料!!");
	}
	return true ;
}
function checkValue(form)
{
	var cols = new Array("showType"  , "date(issueDate)" , "date(dueDate)" , "bigDecimal(expectAmount)");
	var colNames = new Array("【顯示類別】" , "【借款起日】" ,  "【借款迄日】" , "【預計借款金額】");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert(colNames[result] + "不可空白!!");
	}
    if (form.elements['date(dueDate)'].value < form.elements['date(issueDate)'].value )
    {
        alert("借款起日不可大於借款迄日!!");
        result = 1;
    }
    if("" == form.textCount.value && result < 0)
    {
    	alert("借款天期不可空白!!");
        result = 1;
    }
	return result < 0;
}
</script>