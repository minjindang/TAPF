<!-- APRA1501AScript.jsp
程式目的：APRA15檢查是否有輸入值
程式代號：APRA15
程式日期：0950221
程式作者：Andrew Sung
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%
	String code = (String)request.getAttribute("code");
%>
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
/*
    if ("" == form.elements['date(issueSdate)'].value)
    {
		sError += "\n";
        sError += "【發行期別】不可空白!!";
        form.elements['date(issueSdate)'].focus();  
    }
     if ("" ==  form.elements['date(issueEdate)'].value)
    {
		sError += "\n";
        sError += "【發行期別】不可空白!!";
        form.elements['date(issueEdate)'].focus();  
    }
*/
    <% 
		if(code.equals("BPRA04"))
		{
	%>
			if ("" == form.elements['date(destDate)'].value)
		    {
				sError += "\n";
		        sError += "【銷毀日期】不可空白!!";
		        form.elements['date(destDate)'].focus();
		    }
		    if (!(CheckValidDate(form.elements['date(destDate)'].value)))
		    {
				sError += "\n";
		        sError += "【銷毀日期】格式不正確!!";
		    	form.elements['date(destDate)'].select();
		    }
		    if ("" == form.elements['destArea'].value)
		    {
				sError += "\n";
		        sError += "【銷毀地點】不可空白!!";
		        form.elements['destArea'].focus();
		    }
	<% 
		}
	%>
	
	
		if(sError!="")
	{
		alert(sError);
		return false;
	}
	else
		return true;
}
//-->
</script>
