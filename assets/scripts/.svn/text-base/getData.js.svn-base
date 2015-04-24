function getBankRef(val)
{
	if(val!=""){
	    frames['reqfram'].location.href = "/tapf/getdata/BankRef.jsp?para="+val;
	}
}

function getUnitInfoMain(val)
{
	if(val!=""){
	    frames['reqfram'].location.href = "/tapf/getdata/UnitInfoMain.jsp?para="+val;
	}
}

function getBankRefId(val)
{
	if(val!=""){
	    frames['reqfram'].location.href = "/tapf/getdata/BankRefId.jsp?para="+val;
	}
	else{
		document.MainForm.bankId.value = "";
	}
}
function getDueDate(form)
{
	payDate = form.repayDate.value;
	id = form.id.value;
	if(id!="" && payDate !=""){
	    frames['reqfram'].location.href = "/tapf/getdata/DueDate.jsp?para="+id+"&para2="+payDate;
	}
}
function getIssueSerial(val,debtType)
{
	if(val!="" && debtType!="")
	{
		switch(debtType)
		{
			case 'B':
				frames['reqfram'].location.href = "/tapf/getdata/IssueSerialB.jsp?para="+val;
				break;
			case 'C':
				frames['reqfram'].location.href = "/tapf/getdata/IssueSerialC.jsp?para="+val;
				break;
			case 'E':
			frames['reqfram'].location.href = "/tapf/getdata/IssueSerialE.jsp?para="+val;
			break;
			default:
				alert(" getIssueSerial error!");
		}
	}
}
function getIssueData(form)
{
	issueId = form.issueId.value;
	repayDate = form.elements['date(repayDate)'].value;
	capitalSerial  = form.capitalSerial.value;
	//alert(issueId);
	if(issueId == "")
		issueId = 0 ;
	frames['reqfram'].location.href = "/tapf/getdata/IssueData.jsp?issueId="+issueId+"&repayDate="+repayDate+"&capitalSerial="+capitalSerial;
}
function getDebtCode(val,val2)
{
	if(val == "")
		val = 0;
	    frames['reqfram'].location.href = "/tapf/getdata/DebtCode.jsp?budgetCode="+val+"&debtCodeOption="+val2;
}
/*function getPayInterest(num,capitalAmount,startDate,endDate,debtId)
{	
	if(num != "" && capitalAmount != "" )
	    frames['reqfram'].location.href = "/tapf/getdata/GetPayInterest.jsp?num="+num+"&capitalAmount="+capitalAmount+"&startDate="+startDate+"&endDate="+endDate+"&debtId="+debtId;
}*/
function getPayInterest(num,capitalAmount,repayDays,debtId,rate)
{	
	if(num != "" && capitalAmount != "" )
	    frames['reqfram'].location.href = "/tapf/getdata/GetPayInterest.jsp?num="+num+"&capitalAmount="+capitalAmount+"&repayDays="+repayDays+"&debtId="+debtId+"&rate="+rate;
}

/*function doAction(pAction)
{
	var xmlHttpObj = new ActiveXObject("Microsoft.XMLHTTP");
	var tOrgForm = document.getElementsByTagName('form')[0];
	xmlHttpObj.open("POST","/tapf/do/" + pAction, false);
	xmlHttpObj.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlHttpObj.send(collectFormData(tOrgForm));
	var tBody = document.createElement("<body>");
 
	tBody.innerHTML = xmlHttpObj.responseText;
	var tForm = tBody.getElementsByTagName('form')[0];	
	//var tOrgObj = tOrgForm.all;
	//var tNewObj = tForm.all;
	try{
		tOrgForm.innerHTML = tForm.innerHTML;
		//prompt('aa',tOrgForm.innerHTML);
	}
	catch(exception){
		alert("???~?T??:" + exception);
		alert(xmlHttpObj.responseText);
	}
	
	//for(var j = 0 ; j < tOrgObj.length ; j++){
	//	if(tOrgObj[j].name){
	//		tForm.elements(tOrgObj[j].name).swapNode(tOrgObj[j]);
	//	}
	}
}*/
function doAction(pAction){
		document.MainForm.action = pAction;
		document.MainForm.submit();
}
function collectFormData(pThisForm){
	var tVariable = "";

	var tObjs = pThisForm.all;

	for(var i = 0 ; i < tObjs.length ; i++){
		if(tObjs.item(i).name != null && tObjs.item(i).name != ""){
			tVariable += tObjs.item(i).name + "=" + tObjs.item(i).value + "&";
		}
	}
	return tVariable.substring(0, tVariable.length - 1);
}