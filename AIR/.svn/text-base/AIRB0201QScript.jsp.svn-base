<!--
程式目的：中央政府公債發行與還本概況表
程式代號：AIRB02
程式日期：0950317
程式作者：icefire
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">

function doBodyOnLoad(form)
{
  //nothing
}
function checkValue(form)
{ 
 	var isValid = true;
    var sError = "";
    
    if ("" == form.elements['repay_SDate'].value)
    {
      isValid = false;
	  sError += "\n";
      sError += "還本年度起 不可空白!!";
    }
    
    if ("" == form.elements['repay_EDate'].value)
    {
      isValid = false;
	  sError += "\n";
      sError += "還本年度迄 不可空白!!";
    }
    
    if ("" != form.elements['repay_SDate'].value && 
        "" != form.elements['repay_EDate'].value)
    {
      if (form.elements['repay_SDate'].value>
              form.elements['repay_EDate'].value)
         {
           isValid = false;
		   sError += "\n";
           sError += "還本年度起 不可大於 迄!!";
         }
    }
    if (!CheckValidDate(form.elements['date(issue_SDate)'].value)){
		form.elements['date(issue_SDate)'].value = "";
		return false;
	}
	if (!CheckValidDate(form.elements['date(issue_EDate)'].value)){
		form.elements['date(issue_EDate)'].value = "";
		return false;
	}
    if (form.elements['date(issue_SDate)'].value > form.elements['date(issue_EDate)'].value)
    {
           isValid = false;
		   sError += "\n";
           sError += "發行日期起 不可大於 迄!!";
    }
	if (false == isValid)
    {
    	alert(sError);
    }
		return isValid;
}

</script>
