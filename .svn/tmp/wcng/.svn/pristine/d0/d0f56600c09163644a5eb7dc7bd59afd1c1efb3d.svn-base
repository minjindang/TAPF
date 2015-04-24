<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">
<!--
function doBodyOnLoad(document)
{
  //nothing
}

function checkForm(form)
{
	var alertMessage = "";
<%
	String[] txtparam = {"【記帳年度】"};

	for (int j = 0; j < txtparam.length; j++)
	{
		out.print("\t\tif( isBlank(ele"+j+") )\r");
		out.print("\t\t\talertMessage += \""+txtparam[j]+"，不可空白!\\r\";\r");
	}
%>
	if(alertMessage!="")
	{
		alert(alertMessage);
		return false;
	}
	else
		return true;
}

function checkForm2(form)
{
	var alertMessage = "";
<%
	String[] param2 = {"qryYear","filePath"};
	String[] txtparam2 = {"記帳年度","檔案路徑"};

	for (int k = 0; k < param2.length; k++)
	{
		out.print("\t\tvar ele"+k+" = form.elements['"+param2[k]+"'].value;\r");
	}

	for (int j = 0; j < txtparam2.length; j++)
	{
		out.print("\t\tif( isBlank(ele"+j+") )\r");
		out.print("\t\t\talertMessage += \""+txtparam2[j]+"，未輸入!\\r\";\r");
	}
%>
	if(alertMessage!="")
	{
		alert(alertMessage);
		return false;
	}
	else
		return true;
}
//-->
</script>
