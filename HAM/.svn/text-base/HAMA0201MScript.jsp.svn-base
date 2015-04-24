<%@ page language="java" contentType="text/html;charset=Big5" %>
<script language="Javascript">
<!--
	function doBodyOnLoad(document)
	{
		//do nothing
	}

	function checkForm(form)
	{
		var alertMessage = "";
<%
	String[] param = {"bigDecimal(nationa)","bigDecimal(nationb)","bigDecimal(nationc)",
		"bigDecimal(locala)","bigDecimal(localb)","bigDecimal(localc)",
		"bigDecimal(inta)","bigDecimal(intb)","bigDecimal(intc)"};
	String[] txtparam = {"【國稅_直轄市比例】","【國稅_縣市比例】","【國稅_鄉鎮市比例】",
			"【地方稅_直轄市比例】","【地方稅_縣市比例】","【地方稅_鄉鎮市比例】",
			"【利息_直轄市比例】","【利息_縣市比例】","【利息_鄉鎮市比例】"};

	for (int k = 0; k < param.length; k++)
	{
		out.print("\t\tvar ele"+k+" = form.elements['"+param[k]+"'].value;\r");
	}

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
//-->
</script>
