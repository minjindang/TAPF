<!-- APRA1501AScript.jsp
�{���ت��GAPRA15�ˬd�O�_����J��
�{���N���GAPRA15
�{������G0950221
�{���@�̡GAndrew Sung
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
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
        sError += "�i�o����O�j���i�ť�!!";
        form.elements['date(issueSdate)'].focus();  
    }
     if ("" ==  form.elements['date(issueEdate)'].value)
    {
		sError += "\n";
        sError += "�i�o����O�j���i�ť�!!";
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
		        sError += "�i�P������j���i�ť�!!";
		        form.elements['date(destDate)'].focus();
		    }
		    if (!(CheckValidDate(form.elements['date(destDate)'].value)))
		    {
				sError += "\n";
		        sError += "�i�P������j�榡�����T!!";
		    	form.elements['date(destDate)'].select();
		    }
		    if ("" == form.elements['destArea'].value)
		    {
				sError += "\n";
		        sError += "�i�P���a�I�j���i�ť�!!";
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
