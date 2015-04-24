<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<script language="javascript">

var calendar = 
function doBodyOnLoad(document)
{
	document.MainForm.elements['payLimit'].value = "5";
}


function checkForm(form)
{
	var cols = new Array("issueSerial" , "bondKind", "bondType", "issueKind", "accountYear", "debtName", "Date(issueDate)", "BigDecimal(issueAmount)", "issueInterval", "rateKind", "BigDecimal(averageRate)", "Date(firstInterestDate)", "interestAlternate", "Date(firstRepayDate)", "repayAlternate", "payLimit");
	var colNames = new Array("公債代號", "公債發行種類", "公債識別碼", "公債型式", "會計年度", "公債名稱", "發行日期", "發行額", "期限", "利率變動別", "利率年息", "首次付息日期", "付息次數", "首次還本日期", "還本次數", "有效兌付期限");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("【" + colNames[result] + "】，未輸入!!");
	}
	return result < 0;
}

function count(form){
	if(form.elements["interestAlternate"].value != 0)
		document.getElementById("repayInterestInterval").innerHTML = ((form.elements["issueInterval"].value * 12) / form.elements["interestAlternate"].value) + "月";
	if(form.elements["repayAlternate"].value != 0)
		document.getElementById("repayCapitalInterval").innerHTML = ((form.elements["issueInterval"].value * 12) / form.elements["repayAlternate"].value) + "月";
}

function changeList(form)
{
	doAction("AIMA0101ALIST");
}
function changeIssueSerial(form){
	if(form.serialNo.value != ""){
		serialNo = form.serialNo.value;
		if(parseInt(serialNo) < 10)
			serialNo = "0"+serialNo;
		document.MainForm.issueSerial.value = form.accountYear.value+"-"+serialNo;
		document.getElementById("issueSerialLabel").innerHTML = form.accountYear.value+"-"+serialNo;
	}
}
</script>