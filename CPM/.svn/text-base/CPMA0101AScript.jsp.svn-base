<!-- CPMA0101AScript.jsp
程式目的：CPMA01
程式代號：CPMA01
程式日期：0950306
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">

function doBodyOnLoad(document)
{
  //nothing
}
function changeList(form)
{
	if( form.debtName.value!= "" )
	{
		form.issueId.value = form.debtName.options.value ;
	}	
	else
	{
		form.issueId.value = 0;
	}
	form.action = "CPMA0101LIST";
	form.submit() ;
}
function showType(form)
{	
	if (form.elements['date(planRepayDate)'].value > form.elements['date(qryrepayDate)'].value)
	{
		form.debtType.value = "2提前還款" ;
		document.getElementById("debtTypeid").innerHTML = "2提前還款" ;
	}
	else if  (form.elements['date(planRepayDate)'].value == form.elements['date(qryrepayDate)'].value)
	{	
		form.debtType.value = "0正常還款" ;
		document.getElementById("debtTypeid").innerHTML = "0正常還款" ;
	}
	else if  (form.elements['date(planRepayDate)'].value < form.elements['date(qryrepayDate)'].value )
	{
		form.debtType.value = "1延後還款" ;
		document.getElementById("debtTypeid").innerHTML = "1延後還款" ;
	}
}
function checkValue(form)
{
	var cols = new Array( "debtName" , "date(planRepayDate)" , "date(qryrepayDate)" );
	var colNames = new Array("【中長期借款名稱】" , "【預期償還日期】" , "【實際償還日期】");
	var result = checkFormEmpty(form, cols);
	if(result >= 0)
	{
		alert(colNames[result] + "不可空白!!");
	}
	if ("0" == form.debtName.value )
    {
        alert("中長期借款名稱不可空白!!");
        result = 1 ;
    }
    if ("0" == form.elements['date(planRepayDate)'].value)
    {
        alert("預期償還日期不可空白!!");
        result = 1 ;
    }
	return (result < 0);
}
</script>
