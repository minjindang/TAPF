<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<script language="javascript">

function doBodyOnLoad(document)
{
	//var oNumberMask = new Mask("#,###", "number");
	//var moneyCols = new Array("BigDecimal(buyAmount)","BigDecimal(advanceInterest)","BigDecimal(advanceTax)","BigDecimal(finalAmount)","BigDecimal(buyPremium)");
	//for(var i = 0 ; i < moneyCols.length ; i++)
	//{
		//oNumberMask.attach(document.MainForm.elements[moneyCols[i]]);
		//document.MainForm.elements[moneyCols[i]].value = addMoneyMask(document.MainForm.elements[moneyCols[i]].value);
	//}
}

function checkData(form)
{
	advanceAmount = replaceAll(form.elements['BigDecimal(advanceAmount)'].value,",","");
	advanceRate = form.elements['BigDecimal(advanceRate)'].value;
	advanceDate = form.elements['Date(advanceDate)'].value;
	
	var message = "";
	if(null == advanceAmount || "" == advanceAmount || "0" == advanceAmount)
		message += "[���e�R�^���B]����J!!\n";
	if(null == advanceRate || "" == advanceRate)
		message += "[�̧C�oܸ�Q�v]����J!!\n";
	if(null == advanceDate || "" == advanceDate)
		message += "[���e�R�^���]����J!!\n"
		
	if("" == message) {
		return true;
	}else{
		alert(message);
		return false;
	}
}

function checkData1(form)
{
	advanceAmount = form.elements['BigDecimal(advanceAmount)'].value;
	advanceRate = form.elements['BigDecimal(advanceRate)'].value;
	advanceDate = form.elements['Date(advanceDate)'].value;
	
	var message = "";
	if(null == advanceAmount || "" == advanceAmount || "0" == advanceAmount)
		message += "[���e�R�^���B]����J!!\n";
	if(null == advanceRate || "" == advanceRate)
		message += "[�̧C�oܸ�Q�v]����J!!\n";
	if(null == advanceDate || "" == advanceDate)
		message += "[���e�R�^���]����J!!\n"
	buyAmount = form.elements['BigDecimal(buyAmount)'].value;
	if("" == message && (null == buyAmount || "" == buyAmount || "0" == buyAmount))
		message += "�|������[�պ�]�A�Х�����[�պ�]��A�T�{�U���L�~��A�A�s�W!!";
		
	if("" == message) {
		message += "�z��J��[���e�R�^���B]��"+advanceAmount+"\n";
		message += "�z��J��[�̧C�oܸ�Q�v]��"+advanceRate+"\n";
		message += "�z��J��[���e�R�^���]��"+advanceDate+"\n";
		alert(message);
		advanceInterest = form.elements['BigDecimal(advanceInterest)'].value;
		buyPremium = form.elements['BigDecimal(buyPremium)'].value;
		advanceTax = form.elements['BigDecimal(advanceTax)'].value;
		finalAmount = form.elements['BigDecimal(finalAmount)'].value;
		message = "�p��᪺[�R�^����]��"+buyAmount+"\n";
		message += "�p��᪺[���p�Q��]��"+advanceInterest+"\n";
		message += "�p��᪺[�R�^��(��)��]��"+buyPremium+"\n";
		message += "�p��᪺[�����֭p�|��]��"+advanceTax+"\n";
		message += "�p��᪺[�|��R�i���B]��"+finalAmount+"\n";
		message += "�нT�{�p���U�����B�O�_���T!!!";
		alert(message);
		return confirm("�s�W��N�L�k�ק�A�O�_�T�{�s�W!!");
	}else{
		alert(message);
		return false;
	}
}
</script>