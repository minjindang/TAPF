<!-- CIMA0101AScript.jsp -->
<%@ page pageEncoding="Big5" %>
<script language="Javascript">
function doBodyOnLoad(document)
{

}
function checkForm(form)
{
	var cols = new Array("accountYear","dataType","banish");
	var colNames = new Array("年度","資料類別","排限/非排限");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("【" + colNames[result] + "】，未輸入!!");
		form.focus(cols[result]);
	}
	return result < 0;
}
function getAuditAmount(form)
{
	var keepAmount = parseFloat(replaceAll(form.elements['bigDecimal(keepAmount)'].value,",",""));
	var realAmount = parseFloat(replaceAll(form.elements['bigDecimal(realAmount)'].value,",",""));
	var auditAmount = keepAmount + realAmount;
	auditAmount = auditAmount.toFixed(3);
	form.elements['bigDecimal(auditAmount)'].value = addMoneyMask(auditAmount);
}

function getKeepAmount(form)
{
	var mainAccountYear = "<%=request.getAttribute("mainAccountYear")%>";
	var subAmount = parseFloat(replaceAll(form.elements['bigDecimal(subAmount)'].value,",",""));
	var keepAmount = parseFloat(replaceAll(form.elements['bigDecimal(oldKeepAmount)'].value,",",""));
	var plusdebtAmount = parseFloat(replaceAll(form.elements['bigDecimal(plusdebtAmount)'].value,",",""));//當年增加實際數
	if(mainAccountYear==form.elements['accountYear'].value)
		keepAmount = keepAmount - subAmount;
	else
		keepAmount = keepAmount - subAmount - plusdebtAmount;
	if(keepAmount < 0){
		alert("保留數小於0請先執行轉移作業!!");
		form.elements['bigDecimal(keepAmount)'].value = addMoneyMask(form.elements['bigDecimal(oldKeepAmount)'].value);
		form.elements['bigDecimal(subAmount)'].value = addMoneyMask(form.elements['sorSubAmount'].value) ;
		form.elements['bigDecimal(plusdebtAmount)'].value = addMoneyMask(form.elements['sorPludebtAmount'].value) ;
	}
	else{
		keepAmount = keepAmount.toFixed(3);
		form.elements['bigDecimal(keepAmount)'].value = addMoneyMask(keepAmount);
		getAuditAmount(form);
	}
}
function changeYear(form)
{
	if(form.accountYear.value != "")
		doAction("GAMA0502M2");
}
</script>
