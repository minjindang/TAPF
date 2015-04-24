<!--	電子郵件接收紀錄維護
程式目的：HAMB07文字
程式代號：HAMB07
程式日期：0950223
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
  //nothing
}
function checkValue(form)
{
 	var isValid = true;
    var sError = "";
    var str1 = form.houMinSec.value ;
	var str2 = form.elements['date(recvDate)'].value;
    
    if ("" == form.elements['date(recvDate)'].value || (form.elements['date(recvDate)'].value.length) < 7 )
    {
    	isValid = false;
		sError += "\n";
        sError += "請輸入7碼回條接收日期!!";
    }
    if ("" == form.houMinSec.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【回條接收時間】不可空白!!";
    }
	else
	{	
		switch(str1.length)
		{	
			case 1 :	
					str1 = "0" + str1 + "0000" ;	
					break;
			case 2 :	
					str1 = str1 + "0000" ;	
					break;
			case 3 :	
					str1 = str1 + "000" ;	
					break;
			case 4 :	
					str1 = str1 + "00" ;	
					break;
			case 5 :	
					str1 = str1 + "0" ;	
					break;				
		}
	}
    if (false == isValid)
    {
    	alert(sError);
    }
    else 
    {
    	form.elements['date(recvDate)'].value = str2 + str1 ;
    }
		return isValid;
}

//-->
</script>
