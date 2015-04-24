<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ page import="gov.dnt.tame.util.CommonFun" %>
<%@ page import="gov.dnt.tame.util.Converter"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="gov.dnt.tame.common.LabelValueBean" %>

<script language="JScript" type="text/javascript">		
<%
	String current = "parent.MainForm." + request.getParameter("selectName");
	String sql = request.getParameter("sqlstr");
 
	List list = Converter.getCodeListBySql(sql);
	int i = 0;
	
	out.print("var count = " + current + ".length;");
	out.print("for( k = 0 ; k < count  ; k++)\n");
	out.print("{\n");
	out.print(current + ".remove(0);\n");
	out.print("}\n");
	
    out.print(current + ".options.add(parent.document.createElement(\"OPTION\"));\n");
    out.print(current + ".options[0].text=\"½Ð¿ï¾Ü..\";\n");
    out.print(current + ".options[0].value=\"\";\n");
	
	if(list!=null && !list.isEmpty() )
	{
		for (Iterator it = list.iterator();it.hasNext();)
		{
			LabelValueBean param = (LabelValueBean) it.next();
	        out.print(current + ".options.add(parent.document.createElement(\"OPTION\"));\n");
    	    out.print(current + ".options["+(i+1)+"].text=\""+ (String)param.getLabel()+"\";\n");
        	out.print(current + ".options["+(i+1)+"].value=\""+ (String)param.getValuess()+"\";\n");
        	i++;
		}	

	}
%>			  
</script>