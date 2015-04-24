<!-- DIMA0101AScript.jsp
程式目的：DIMA01
程式代號：DIMA01
程式日期：0950223
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
	var toDay = new Date();
	var Day=(toDay.getYear()-1911);
	if (Day<100)
	{
		Day="0"+(toDay.getYear()-1911);
		document.MainForm.accountYear.value = Day;
	}
	else
	{
		Day =(toDay.getYear()-1911);
		document.MainForm.accountYear.value = Day;
	}
	if ((toDay.getMonth()+1)<10)
		Day += "0"+(toDay.getMonth()+1);
	else Day+=toDay.getMonth()+1;
	if (toDay.getDate()<10)
		Day += "0"+toDay.getDate();
	else Day +=toDay.getDate();
	
	document.MainForm.debtName.value = Number(document.MainForm.accountYear.value)+"年度第  期短期借款";
	document.MainForm.elements['date(issueDate)'].value = Day;
	document.MainForm.elements['date(dueDate)'].value = "";
	document.MainForm.days.value = 0;
	document.MainForm.elements['bigDecimal(expectAmount)'].value = "";
	document.MainForm.serialNo.value = "";
	document.MainForm.issueSerial.value = "";
	document.MainForm.elements('bigDecimal(expectAmount)').value = "";
}
function getIssueSerial()
{
	var	currform	=	document.MainForm;
	var	accountYear		=	currform.accountYear.value;
	var	serialNo	=	currform.serialNo.value;
	if( ""!=accountYear && ""!=serialNo )
	{
		var serialTemp = "";
		if(serialNo.charAt(0)== '公'){
			serialTemp = "公";
			serialNo = serialNo.substr(1,serialNo.length);
		}
		if(serialNo.charAt(0)== '債'){
			serialTemp = "債";
			serialNo = serialNo.substr(1,serialNo.length);
		}
		currform.issueSerial.value = accountYear+"-"+currform.serialNo.value
		currform.debtName.value = Number(accountYear)+"年度"+serialTemp+"第"+Number(serialNo)+"期短期借款"
		return currform.issueSerial.value;
	}
}
function getDays()
{
	var	currform	=	document.MainForm;
	var	issueDate		=	currform.elements['date(issueDate)'].value;
	var	dueDate 	=	currform.elements['date(dueDate)'].value
	
	if (!(CheckValidDate(issueDate)))
    {
    	return false;
    }
	if (!(CheckValidDate(dueDate)))
    {
    	return false;
    }
    if(issueDate !="" && dueDate!="")
   	{
		currform.days.value = daycount(issueDate,dueDate,"C")
		document.getElementById("dayid").innerHTML = daycount(issueDate,dueDate,"C") ;
	}
}
function getDaysByChange()
{
	var	currform	=	document.MainForm;
	var	issueDate		=	currform.elements['date(issueDate)'].value;
	var	dueDate 	=	currform.elements['date(dueDate)'].value

	if ((CheckValidDate(issueDate))&&(CheckValidDate(dueDate)))
    {
    	currform.days.value = daycount(issueDate,dueDate,"C")
		document.getElementById("dayid").innerHTML = daycount(issueDate,dueDate,"C") ;
    }
}
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
	if ("" == form.accountYear.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【年度】不可空白!!";
    }
    if ("" == form.serialNo.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【期次】不可空白!!";
    }
    if ("" == form.debtCode.value )
    {
    	isValid = false;
		sError += "\n";
        sError += "【預算別】不可空白!!";
    }
    if ("" == form.budgetCode.value )
    {
    	isValid = false;
		sError += "\n";
        sError += "【債務別】不可空白!!";
    }
    if ("" == form.elements['date(issueDate)'].value )
    {
    	isValid = false;
		sError += "\n";
        sError += "【借款起日】不可空白!!";
    }
    if ("" == form.elements['date(dueDate)'].value )
    {
    	isValid = false;
		sError += "\n";
        sError += "【借款迄日】不可空白!!";
    }
    /*if ("" == form.debtName.value )
    {
    	isValid = false;
		sError += "\n";
        sError += "【名稱】不可空白!!";
    }*/
    if ("" == form.elements['bigDecimal(expectAmount)'].value )
    {
    	isValid = false;
		sError += "\n";
        sError += "【預計借款金額】不可空白!!";
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}
//-->
</script>
