<!-- DIMA0101AScript.jsp
程式目的：DIMA01
程式代號：DIMA01
程式日期：0950223
程式作者：Andrew Sung
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
	/*toDay = new Date();
	Day=(toDay.getYear()-1911);
	if (Day<100)
		Day="0"+(toDay.getYear()-1911);
	if ((toDay.getMonth()+1)<10)
		Day += "0"+(toDay.getMonth()+1);
	else Day += toDay.getMonth()+1;
	if (toDay.getDate()<10)
		Day += "0"+toDay.getDate() ;
	else Day += toDay.getDate();
	document.MainForm.elements('Date(repayDate)').value = Day;*/
}

function checkValue(form)
{
	var cols = new Array("id_options", "Date(repayDate)");
	var colNames = new Array("短期借款名稱", "償還日期");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("【" + colNames[result] + "】未輸入!!");
	}
	else
	{
		if (!(CheckValidDate(form.elements['Date(repayDate)'].value)))
	    {
	    	isValid = false;
	    	form.elements['Date(repayDate)'].select();
	    	return false;
	    }
	}	
	return result < 0;
 	
}

function checkDate(form)
{
	if(form.id.value !="" && form.elements('Date(repayDate)').value !="")
	{
		if (CheckValidDate(form.elements('Date(repayDate)').value))
	    {
	    	doAction("DPMA0107");
	    }
	    else
	    {
	    	form.payType.value = "";
	    	form.elements('Date(repayDate)').select();
	    }
	}
}

//-->
</script>
