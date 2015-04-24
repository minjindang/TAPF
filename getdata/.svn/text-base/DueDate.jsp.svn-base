<%@ page language="java" contentType="text/html;charset=MS950" %>
<%@ page import="gov.dnt.tame.util.CommonFun" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="gov.dnt.tame.util.DateUtil" %>
<%
	String	para	=	request.getParameter("para");
	String	para2	=	request.getParameter("para2");
%>
<script language="Javascript" src="/tapf/assets/scripts/DateUtil.js"></script>
<script language="JScript" type="text/javascript">
<%
	/*
	String	sqlstr	=	"SELECT ";
			sqlstr	+=	" A.DUE_DATE AS dueDate, ";
			sqlstr	+=	" A.ISSUE_DATE AS issueDate ";
			sqlstr	+=	" FROM ISSUE_MAIN A ";
			sqlstr	+=	" WHERE A.ID='"+para+"'";
	List list = CommonFun.getList(sqlstr);
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

						Date textValue = new Date();
						if(textName!=null)
						{
							if(map!=null && map.get(textName)!=null )
								textValue = (Date) map.get(textName);

							if( "duedate".equals( textName ) )
							{
								String dueDate = DateUtil.date2ROCStr(textValue);
								out.print("\t\tparent.MainForm.elements['date(dueDate)'].value = '"+dueDate+"'; \r\n");
								
								Date payDate = DateUtil.str2Date(para2);
								if(payDate.equals(textValue))
									out.print("\t\tparent.MainForm.payType.value ='0 正常還款'; \r\n");
								if(payDate.after(textValue))
									out.print("\t\tparent.MainForm.payType.value ='1 延後還款'; \r\n");
								if(payDate.before(textValue))
									out.print("\t\tparent.MainForm.payType.value ='2 提前還款'; \r\n");
							}
							if( "issuedate".equals( textName ) )
							{
								String issueDate = DateUtil.date2ROCStr(textValue);
								Date payDate = DateUtil.str2Date(para2);
								out.print("\t\tparent.MainForm.repayDays.value = daycount('"+issueDate+"','"+para2+"',\"C\"); \r\n");
							}
						}
					}
				}
			}
		}
	}
	else
	{
		out.print("\t\talert('查無資料!'); \r\n");
		out.print("\t\ttry{\r\n");
		out.print("\t\t\tparent.MainForm.id.value='';\r\n");
		out.print("\t\t}catch(e){}\r\n");
	}*/
%>
</script>