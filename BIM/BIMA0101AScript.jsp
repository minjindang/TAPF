<%@ page pageEncoding="Big5" %>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
	try{
		var toDay = new Date();
		var Day=(toDay.getYear()-1911);
		if (Day<100)
		{
			Day="0"+(toDay.getYear()-1911);
			document.MainForm.accountYear.value = Day;
			getIssueSerial(Day,'B');
		}
		else
		{
			Day =(toDay.getYear()-1911);
			document.MainForm.accountYear.value = Day;
			getIssueSerial(Day,'B');
		}
		if ((toDay.getMonth()+1)<10)
			Day += "0"+(toDay.getMonth()+1);
		else Day+=toDay.getMonth()+1;
		if (toDay.getDate()<10)
			Day += "0"+toDay.getDate();
		else Day +=toDay.getDate();
			document.MainForm.elements['date(issueDate)'].value = Day;
	
		var cashDueDate = parseInt(Day.substr(0, 3),10)+5;
    	if(cashDueDate<100)
    		cashDueDate = "0"+cashDueDate
    	document.MainForm.elements['date(cashDueDate)'].value = cashDueDate+Day.substr(3, 4);
    	document.MainForm.elements['bigDecimal(chargeRate)'].value = "0.3";
	}catch(e){alert(e.message);}
	//document.MainForm.elements['bigDecimal(expectAmount)'].value = "00000000";
	//document.MainForm.elements['bigDecimal(capitalAmount)'].value = "00000000";
}

function checkCapitalAmount(form)
{
	var	expectAmount	=	replaceAll(form.elements['bigDecimal(expectAmount)'].value,",","");
	var	realAmount 	=	replaceAll(form.elements['bigDecimal(realAmount)'].value,",","");

	document.MainForm.elements['bigDecimal(issueAmount)'].value = expectAmount ;
	document.getElementById("issueAmount").innerHTML = addMoneyMask(expectAmount) ;
	if(expectAmount != "" && realAmount != "")
	{
		if( parseInt(realAmount) > parseInt(expectAmount) )
		{
			document.MainForm.elements['bigDecimal(realAmount)'].value = "";
			alert("�ꦬ�B���o�j��o���B");
		}
	}
}

function getDays(form)
{
	var	currform	=	document.MainForm;
	var	issueDate	=	currform.elements['date(issueDate)'].value;
	var	dueDate 	=	currform.elements['date(dueDate)'].value
	
	if (!(CheckValidDate(dueDate)))
    {
    	return false;
    }
    else
    {
    
    	var cashDueDate = parseInt(dueDate.substr(0, 3),10)+5;
    	if(issueDate != "" && dueDate != "")
    	{
	    	if(cashDueDate<100)
	    		cashDueDate = "0"+cashDueDate
	    	currform.elements['date(cashDueDate)'].value = cashDueDate+dueDate.substr(3, 4);
    	}
    	
    }
	if (!(CheckValidDate(dueDate)))
    {
    	return false;
    }
   	else if (issueDate !="" && dueDate != "")
   	{
		//currform.days.value = daycount(issueDate,dueDate,"C")
		var bigDate = currform.elements['date(issueDate)'].value ;
		var endDate = currform.elements['date(dueDate)'].value ;
		if("" != bigDate && null != bigDate && "" != endDate && null != endDate )
		{
			form.days.value = daycount(bigDate,endDate,"C") ;
			document.getElementById("dayid").innerHTML = daycount(bigDate,endDate,"C") ;
		}
	}
}
function checkValue(form)
{
	var	cols = new Array(
		"accountYear","issueSerial","budgetCode_options","debtCode_options","date(issueDate)",
		"date(dueDate)","bigDecimal(expectAmount)","bigDecimal(capitalAmount)","bigDecimal(averageRate)","bigDecimal(chargeRate)","issueKind_options","bondType_options" );
	var colNames = new Array(
		"�o��~��","�o����O","�w��O","�ŰȧO","�o����",
		"������","�o���B","�ꦬ�B","�K�{�v","����O���",
		"��w�髬��","����");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("�i" + colNames[result] + "�j����J!!");
	}
	return result < 0;
}

function getDebtName(form)
{
	var accountYear = form.accountYear.value;
	var serialNo = form.serialNo.value;
	
	document.MainForm.debtName.value = '�]�F����w��' + Number(accountYear) + '�~�ײ�F' + Number(accountYear)+"-"+Number(serialNo) + '��';
}
//-->
</script>