<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ page import="gov.dnt.tame.util.CommonFun" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%	
	request.setCharacterEncoding("ISO-8859-1");

	String sql = request.getParameter("sql");	
	String para = new String(((String) request.getParameter("para")).getBytes("ISO-8859-1"), "Big5");	
	String dType = request.getParameter("dType");	
	boolean isNum=true;
	if(sql==null)sql="";
	if(para==null)para="";
	if(dType==null)dType="S";
	
	if(dType.equals("'N'"))
	{	
		//ÀË¬d¬O§_¼Æ¦r
		int iNum=0;
		try
		{
			iNum = Integer.parseInt(para);
		}
		catch(Exception e)
		{
			isNum = false;
		}		
		sql += iNum;
	}
	else
		sql=sql+"'"+para+"'";	
%>
<script language="JScript" type="text/javascript">		
						
<%
if(isNum)
{
	List list = CommonFun.getList(sql);	
	Object [] object=null;	
	if(list!=null && list.size()>0)
	{
		Map map = (Map) list.get(0);
		if(map!=null)
		{
			Set set = map.keySet();	
			if(set!=null)
			{
				object = set.toArray() ;
				for(int j=0;j<object.length;j++)
				{
					if( object[j]!=null )
					{
						String textName = object[j].toString();
						
						String textValue = "";
						if(textName!=null)
						{
							if(map!=null && map.get(textName)!=null && map.get(textName).toString()!=null)
								textValue = map.get(textName).toString();

							if( textName.equalsIgnoreCase("APPOINT_WAY") )
							{
								if( textValue!=null )
								{
									if( textValue.equals("1") )
										out.print("\t\tparent.MainForm."+textName.toUpperCase()+"[2].checked = 'true'; \r\n");
									else if( textValue.equals("2") )
										out.print("\t\tparent.MainForm."+textName.toUpperCase()+"[1].checked = 'true'; \r\n");									
									else if( textValue.equals("3") )
										out.print("\t\tparent.MainForm."+textName.toUpperCase()+"[0].checked = 'true'; \r\n");
								}
//								if(textValue!=null && (textValue.equals("1") || textValue.equals("2") || textValue.equals("3")) )
//									out.print("\t\tparent.MainForm."+textName.toUpperCase()+"["+((new Integer(textValue)).intValue()-1)+"].checked = 'true'; \r\n");
							}
							else
							{
								if(textValue==null)
									textValue="";
						
								out.print("\t\tparent.MainForm."+textName.toUpperCase()+".value = '"+textValue+"'; \r\n");
							}
						}
					}
				}			
			}
		}
	}	
}
%>			  
</script>