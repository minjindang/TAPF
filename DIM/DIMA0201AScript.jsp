<!-- DIMA0101AScript.jsp
�{���ت��GDIMA01
�{���N���GDIMA01
�{������G0950223
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
	
	document.MainForm.debtName.value = Number(document.MainForm.accountYear.value)+"�~�ײ�  ���u���ɴ�";
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
		if(serialNo.charAt(0)== '��'){
			serialTemp = "��";
			serialNo = serialNo.substr(1,serialNo.length);
		}
		if(serialNo.charAt(0)== '��'){
			serialTemp = "��";
			serialNo = serialNo.substr(1,serialNo.length);
		}
		currform.issueSerial.value = accountYear+"-"+currform.serialNo.value
		currform.debtName.value = Number(accountYear)+"�~��"+serialTemp+"��"+Number(serialNo)+"���u���ɴ�"
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
        sError += "�i�~�סj���i�ť�!!";
    }
    if ("" == form.serialNo.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�����j���i�ť�!!";
    }
    if ("" == form.debtCode.value )
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�w��O�j���i�ť�!!";
    }
    if ("" == form.budgetCode.value )
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�ŰȧO�j���i�ť�!!";
    }
    if ("" == form.elements['date(issueDate)'].value )
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�ɴڰ_��j���i�ť�!!";
    }
    if ("" == form.elements['date(dueDate)'].value )
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�ɴڨ���j���i�ť�!!";
    }
    /*if ("" == form.debtName.value )
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�W�١j���i�ť�!!";
    }*/
    if ("" == form.elements['bigDecimal(expectAmount)'].value )
    {
    	isValid = false;
		sError += "\n";
        sError += "�i�w�p�ɴڪ��B�j���i�ť�!!";
    }
    if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}
//-->
</script>
