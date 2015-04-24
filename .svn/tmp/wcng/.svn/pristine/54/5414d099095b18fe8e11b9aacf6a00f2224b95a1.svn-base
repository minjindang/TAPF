<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<script language="javascript">
function doBodyOnLoad(document)
{
	oNumberMask = new Mask("###.000", "number");
	moneyCols = new Array("BigDecimal(averageRate)");
	for(var i = 0 ; i < moneyCols.length ; i++)
	{
		oNumberMask.attach(document.MainForm.elements[moneyCols[i]]);
		document.MainForm.elements[moneyCols[i]].value = addMoneyMask(document.MainForm.elements[moneyCols[i]].value);
	}
}

function checkForm(form)
{
	var cols = new Array("issueSerial" , "bondKind", "bondType", "issueKind", "budgetCode", "debtCode", "accountYear", "debtName", "Date(issueDate)", "BigDecimal(issueAmount)", "issueInterval", "rateKind", "BigDecimal(averageRate)", "Date(firstInterestDate)", "interestAlternate", "Date(firstRepayDate)", "repayAlternate", "payLimit");
	var colNames = new Array("公債代號", "公債發行種類", "公債識別碼", "公債型式", "預算別", "債務別", "會計年度", "公債名稱", "發行日期", "發行額", "期限", "利率變動別", "利率年息", "首次付息日期", "付息次數", "首次還本日期", "還本次數", "有效兌付期限");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("【" + colNames[result] + "】，未輸入!!");
		form.focus(cols[result]);
	}
	
	return result < 0;
}

function count(form){
	if(form.elements["interestAlternate"].value != 0)
		document.getElementById("repayInterestInterval").innerHTML = ((form.elements["issueInterval"].value * 12) / form.elements["interestAlternate"].value) + "月";
	if(form.elements["repayAlternate"].value != 0)
		document.getElementById("repayCapitalInterval").innerHTML = ((form.elements["issueInterval"].value * 12) / form.elements["repayAlternate"].value) + "月";
}

function doBlur(form){
	form.action="AIMA0100M";
	form.submit();
}

function changeList(form)
{
	doAction("AIMA0101MList");
}
</script>