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
	String[] txtparam = {"�i�O�b�~�סj"};

	for (int j = 0; j < txtparam.length; j++)
	{
		out.print("\t\tif( isBlank(ele"+j+") )\r");
		out.print("\t\t\talertMessage += \""+txtparam[j]+"�A���i�ť�!\\r\";\r");
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
	String[] txtparam2 = {"�O�b�~��","�ɮ׸��|"};

	for (int k = 0; k < param2.length; k++)
	{
		out.print("\t\tvar ele"+k+" = form.elements['"+param2[k]+"'].value;\r");
	}

	for (int j = 0; j < txtparam2.length; j++)
	{
		out.print("\t\tif( isBlank(ele"+j+") )\r");
		out.print("\t\t\talertMessage += \""+txtparam2[j]+"�A����J!\\r\";\r");
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
