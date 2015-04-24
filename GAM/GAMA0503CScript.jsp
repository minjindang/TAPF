<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<script language="javascript">
function doBodyOnLoad(document)
{
		//do nothing
}
function changeKeepAmount(form){
	var key = "";
	var keepUamount1 = form.elements['BigDecimal(keepUamount1)'].value;
	var keepUamount2 = form.elements['BigDecimal(keepUamount2)'].value;
	var keepBamount1 = form.elements['BigDecimal(keepBamount1)'].value;
	var keepBamount2 = form.elements['BigDecimal(keepBamount2)'].value;
	var oddKeepUamount1 = form.elements['BigDecimal(oddKeepUamount1)'].value;
	var oddKeepUamount2 = form.elements['BigDecimal(oddKeepUamount2)'].value;
	var oddKeepBamount1 = form.elements['BigDecimal(oddKeepBamount1)'].value;
	var oddKeepBamount2 = form.elements['BigDecimal(oddKeepBamount2)'].value;
	var bAmount = replaceAll(form.elements['BigDecimal(keepBamount)'].value,",","");
	var uAmount = replaceAll(form.elements['BigDecimal(keepUamount)'].value,",","");
	if(form.changeKey1.checked == true)
		key = "1";
	else if(form.changeKey2.checked == true)
		key = "2";	
	if(key == "1"){
		document.getElementById("keepUamount1").innerHTML = addMoneyMask(parseInt(keepUamount1) - parseInt(uAmount));
		document.getElementById("keepUamount2").innerHTML = addMoneyMask(parseInt(keepUamount2) + parseInt(uAmount));
		document.getElementById("keepBamount1").innerHTML = addMoneyMask(parseInt(keepBamount1) - parseInt(bAmount));
		document.getElementById("keepBamount2").innerHTML = addMoneyMask(parseInt(keepBamount2) + parseInt(bAmount));
		
		document.getElementById("oddKeepUamount1").innerHTML = addMoneyMask(parseInt(oddKeepUamount1) - parseInt(uAmount));
		document.getElementById("oddKeepUamount2").innerHTML = addMoneyMask(parseInt(oddKeepUamount2) + parseInt(uAmount));
		document.getElementById("oddKeepBamount1").innerHTML = addMoneyMask(parseInt(oddKeepBamount1) - parseInt(bAmount));
		document.getElementById("oddKeepBamount2").innerHTML = addMoneyMask(parseInt(oddKeepBamount2) + parseInt(bAmount));
	}
	else if(key == "2"){
		document.getElementById("keepUamount1").innerHTML = addMoneyMask(parseInt(keepUamount1) + parseInt(uAmount));
		document.getElementById("keepUamount2").innerHTML = addMoneyMask(parseInt(keepUamount2) - parseInt(uAmount));
		document.getElementById("keepBamount1").innerHTML = addMoneyMask(parseInt(keepBamount1) + parseInt(bAmount));
		document.getElementById("keepBamount2").innerHTML = addMoneyMask(parseInt(keepBamount2) - parseInt(bAmount));
		
		document.getElementById("oddKeepUamount1").innerHTML = addMoneyMask(parseInt(oddKeepUamount1) + parseInt(uAmount));
		document.getElementById("oddKeepUamount2").innerHTML = addMoneyMask(parseInt(oddKeepUamount2) - parseInt(uAmount));
		document.getElementById("oddKeepBamount1").innerHTML = addMoneyMask(parseInt(oddKeepBamount1) + parseInt(bAmount));
		document.getElementById("oddKeepBamount2").innerHTML = addMoneyMask(parseInt(oddKeepBamount2) - parseInt(bAmount));
	}
	else{
		document.getElementById("keepUamount1").innerHTML = addMoneyMask(keepUamount1);
		document.getElementById("keepUamount2").innerHTML = addMoneyMask(keepUamount2);
		document.getElementById("keepBamount1").innerHTML = addMoneyMask(keepBamount1);
		document.getElementById("keepBamount2").innerHTML = addMoneyMask(keepBamount2);
		document.getElementById("oddKeepUamount1").innerHTML = addMoneyMask(oddKeepUamount1);
		document.getElementById("oddKeepUamount2").innerHTML = addMoneyMask(oddKeepUamount2);
		document.getElementById("oddKeepBamount1").innerHTML = addMoneyMask(oddKeepBamount1);
		document.getElementById("oddKeepBamount2").innerHTML = addMoneyMask(oddKeepBamount2);
	}
}
function checkKey1(form){
	if(form.changeKey1.checked == true)
		form.changeKey2.checked = false;
	changeKeepAmount(form);
}
function checkKey2(form){
	if(form.changeKey2.checked == true)
		form.changeKey1.checked = false;
	changeKeepAmount(form);
}
</script>