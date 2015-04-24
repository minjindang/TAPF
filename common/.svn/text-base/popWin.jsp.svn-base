<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ page import="gov.dnt.tame.util.CommonFun" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%	
	String sql = request.getParameter("sql");
	String showColumnCount=request.getParameter("count");
	int showCount=0;
	try
	{
		showCount = Integer.parseInt(showColumnCount);
	}
	catch(Exception e)
	{
		 showCount=0;
	}

	List list=CommonFun.getList(sql);
	Object [] object=null;	
	if(list!=null && list.size()>0)
	{
		Map map = (Map) list.get(0);
		if(map!=null)
		{
			Set set = map.keySet();	

			if(set!=null)
				object = set.toArray();
		}
	}
	
/*	if(object!=null)out.print("object.length:"+object.length);
	else out.print("object is null");
	for(int j=0;j<object.length;j++){
				if(object[j].toString()!=null){
				out.print("object:"+object[j].toString());
				}
	}*/
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/tapf/assets/styles/stod.css">
<link rel="stylesheet" type="text/css" href="/tapf/assets/styles/xtree.css">
<title></title>
</head>
<script language="javascript">
<!--
<%if(list==null ||list.size()<1){%>
alert("查無資料");
window.close();
<%}%>


function setData(point) 
{
	var index=point;
	var currform = document.MainForm;
    var Cform=window.opener.MainForm;
	<%
	if(object!=null){
		for(int i=0;i<list.size();i++){
			out.print("\tif(index=='"+i+"'){\r\n");			
			for(int j=0;j<object.length;j++){
				if(object[j].toString()!=null){
					String textName="";
					if(object[j]!=null)textName=object[j].toString();
					String textValue="";
					if(textName!=null){
						if(list.get(i)!=null && ((Map)list.get(i)).get(textName)!=null && ((Map)list.get(i)).get(textName).toString()!=null)textValue=((Map)list.get(i)).get(textName).toString();
					}
					if(textValue==null)textValue="";
					out.print("\t\tCform."+textName.toUpperCase()+".value = '"+textValue+"'; \r\n");
				}
			}					
			out.print("\t } \r\n");
		}
	}
	%>
	
    window.close();
}
//-->
</script>
<body>
<div class="title" align="center"></div>

<div align="top">
  <center>
  <form name="MainForm" method="post">
    <table class="table_1" width="98%">
<%
for(int i=0;i<list.size();i++){
	Map map=(Map)list.get(i);
	out.print("<tr>\r\n");
	out.print("<td class='table_item'>"+new Integer(i+1)+"</td>");
	
	int iCount=0;
	//for(int j=0;j<object.length;j++){	
	for(int j=(object.length-1);j>-1;j--){	
		iCount++;		
		if(showCount>0 && iCount>showCount)break;
		String textValue="";
		if(object[j].toString()!=null){
			String textName=object[j].toString();
					if(textName!=null){
						if(list.get(i)!=null && ((Map)list.get(i)).get(textName)!=null && ((Map)list.get(i)).get(textName).toString()!=null)textValue=((Map)list.get(i)).get(textName).toString();
					}			
			else textValue="";
			if(textValue==null)textValue="";
			else if(textValue.length()<1)textValue="";
		}
%>	
		<td class="table_td" align="center"  height="20">
			<a onclick="setData('<%=i%>');" href="#" STYLE="Text-decoration: underline">
				<%=textValue%>
			</a>
		</td>
<%	
	}
	out.print("</tr>\r\n");
}

%>

</table>
  </form>
  </center>
</div>
</body>
</html>