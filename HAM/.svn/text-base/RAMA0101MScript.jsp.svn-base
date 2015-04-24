<!-- RAMA0101MScript.jsp
程式目的：RAMA01檢查是否有輸入值
程式代號：RAMA01
程式日期：1001005
程式作者：Powen Hsueh
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">

//確認
function checkValue1(form)
{
	
}

function doBodyOnLoad(document)
	{
	  //nothing
	   
	}
	
function setRowIndex(x)
{
	var clickedRowIndex = document.getElementById("clickedRowIndex");
	clickedRowIndex.value = x.rowIndex;
	//alert("Row index is: " + clickedRowIndex.value);
}

function checkPermission(typeId)
{
	//alert(document.MainForm.elements.length);
	var clickedRowIndex = document.getElementById("clickedRowIndex").value;
	var	currform	=	document.MainForm;
	var currentUserDeptId = currform.CurrentUserDeptId.value;
	//var repayDate = document.getElementsByName('repayDate');
	var repayHandle = document.getElementsByName('repayHandle');
	var repayNumber = document.getElementsByName('repayNumber');
	var accountDate = document.getElementsByName('accountDate');
	var accountNumber = document.getElementsByName('accountNumber');
	var fundNumber = document.getElementsByName('fundNumber');
	var secretaryDate = document.getElementsByName('secretaryDate');
	/*alert(clickedRowIndex);
	alert(repayHandle[clickedRowIndex-3].value);
	alert(repayNumber[clickedRowIndex-3].value);
	alert(accountDate[clickedRowIndex-3].value);
	alert(accountNumber[clickedRowIndex-3].value);
	alert(fundNumber[clickedRowIndex-3].value);
	alert(secretaryDate[clickedRowIndex-3].value);
	alert(fundNumber[clickedRowIndex-3].value);
	alert(rowIndex);
	alert(document.getElementById("grid"));
	alert(document.getElementById("grid").rows[rowIndex].cells[2]);*/
	//var cel= document.getElementById("grid").rows[rowIndex].getElementsByName("fundNumber").value;
	
    //alert(cel);
   
	//alert("currentUserDeptId : " + currentUserDeptId);
	//alert("typeId : " + typeId);
	//第三組
	if( (currentUserDeptId ==  8|| currentUserDeptId == 10) && typeId == 1){
		if(secretaryDate[clickedRowIndex-3].value){
			alert('秘書室輸入資料後,不可再修改!!');
			currform.action='RAMA01';
			currform.submit();	
			return "";
		}
	}
	//會計室
	else if ((currentUserDeptId == 2 || currentUserDeptId == 21) && typeId == 2){
		if(secretaryDate[clickedRowIndex-3].value){
			alert('秘書室輸入資料後,不可再修改!!');
			currform.action='RAMA01';
			currform.submit();	
			return "";
		}else if(!repayHandle[clickedRowIndex-3].value || !repayNumber[clickedRowIndex-3].value){
			alert('第3組使用者未輸入資料前不可輸入!!');
			currform.action='RAMA01';
			currform.submit();	
			return "";
		}
	}
	//秘書室
	else if (currentUserDeptId == 22 && typeId == 3){
		if(!accountDate[clickedRowIndex-3].value || !fundNumber[clickedRowIndex-3].value){
			alert('會計室使用者輸入資料前,不可輸入!!');
			currform.action='RAMA01';
			currform.submit();	
			return "";
		}
	}
	else{
		alert('無權限編輯!!');
		//secretaryDate[0].focus();
		currform.action='RAMA01';
		currform.submit();
		return "";
	}
	
		//currform.action='RAMA02';
		//currform.submit();
	
}

</script>
