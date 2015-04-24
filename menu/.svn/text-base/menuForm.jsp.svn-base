<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<%@ page import="java.util.*" %>
<STYLE type=text/css>
a       { font-family: "Verdana", "Arial", "Helvetica", "sans-serif"; font-size: 13px; color: #003399; text-decoration: none}
a:link  { color: #003399; text-decoration: none}
a:hover { color: #FF0066; text-decoration: none}
.itemMenu { font-family: "Verdana"; font-size: 15px; color: #663399; text-decoration: none} 
.titleMenu { color: #000000; font-weight: bold; font-size: 18px;CURSOR: hand;}
body { background-image:url(../assets/images/bg.gif); }
 
</STYLE>
<script language="Javascript">
<!--
function change(div)
{
	var d = document.getElementById(div).style;
	if(d.display=='block')
	{

<%
	List hlist = (List) request.getAttribute("titleList");
	if( hlist!=null )
	{
		for (Iterator hit = hlist.iterator();hit.hasNext();)
		{
			Map hmap = (Map) hit.next();
			out.print("document.getElementById('list"+hmap.get("ID").toString()+"').style.display='none';\r\n");
		}
	}

%>
	}else {
<%
	if( hlist!=null )
	{
		for (Iterator hit2 = hlist.iterator();hit2.hasNext();)
		{
			Map hmap = (Map) hit2.next();
			out.print("document.getElementById('list"+hmap.get("ID").toString()+"').style.display='none';\r\n");
		}
	}

%>
	d.display='block';
	}
}
//-->
</script>
	
<%
	List list = (List) request.getAttribute("titleList");
	if( list!=null )
	{
		boolean b = true;
		for (Iterator it = list.iterator();it.hasNext();)
		{
%>
	<table width="100%" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#EBEBEB" bgcolor="#FFFFFF">
		<tr>
			<td>
<%
			Map map = (Map) it.next();
			String titleID = map.get("ID").toString();
			out.print("<div class=\"titleMenu\" onClick=\"change('list"+titleID+"');\">\r\n");
			out.print( "<img src=\"../assets/images/menu/b011.gif\" width=\"18\" height=\"18\" valign=\"center\" align=\"center\">&nbsp;"+map.get("NAME")+"\r\n" );
			out.print("</div>\r\n");
%>
			</td>
		</tr>
	</table>

<%
	List mlist = (List) request.getAttribute("menuList");
	if( mlist!=null )
	{
		if(b)
			out.print("<div ID=\"list"+titleID+"\" style=\"display:block;\">\r\n");
		else
			out.print("<div ID=\"list"+titleID+"\" style=\"display:none;\">\r\n");
		b = false;
		out.print("<table width=\"100%\">\r\n");
		for (Iterator itl = mlist.iterator();itl.hasNext();)
		{
			Map mmap = (Map) itl.next();
			String PM0002ID = mmap.get("PM0002ID").toString();
			
			if( (titleID).equals(PM0002ID) )
			{
%>
		<tr>
			<td class="title">
				<table width="100%" border="1" cellpadding="1" cellspacing="1" bordercolor="#EBEBEB" bgcolor="#FFFFFF">
					<tr>
						<td>
							<img src="../assets/images/menu/arrow_r.gif" width="7" height="7">
<%
				out.print("<a href=\"/tapf/do/"+mmap.get("PATH")+"\"");

				if( "PM5001".equals(mmap.get("PATH")) )
					out.print(" target=\"_blank\" ");
				
				out.print(">");
				out.print("<font size='3'>"+mmap.get("NAME")+"</font>");
				out.print("</a>");
				out.print("("+mmap.get("PATH")+")");
%>
						</td>
					</tr>
				</table>
			</td>
		</tr>
<%
			}
		}
		out.print("</table>\r\n");
		out.print("</div>\r\n");
	}
%>
<%
		}
	}
%>

<logic:notPresent name="titleList">
</logic:notPresent>