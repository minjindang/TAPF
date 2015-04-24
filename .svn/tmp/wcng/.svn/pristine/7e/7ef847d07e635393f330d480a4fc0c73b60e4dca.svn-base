<%@ page language="java" contentType="text/html;charset=MS950" %>
<%@ page import="gov.dnt.tame.util.CommonFun" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%
	String	para	=	request.getParameter("para");
%>
<script language="JScript" type="text/javascript">
<%
	String	sqlstr	=	"SELECT ";
			sqlstr	+=	" A.BANK_CODE AS bankCode, ";
			sqlstr	+=	" A.BANK_NAME AS bankName ";
			sqlstr	+=	" FROM BANK_REF A ";
			sqlstr	+=	" WHERE A.BANK_CODE='"+para+"'";

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

						String textValue = "";
						if(textName!=null)
						{
							if(map!=null && map.get(textName)!=null && map.get(textName).toString()!=null)
								textValue = map.get(textName).toString();

							if(textValue==null)
								textValue="";
							
							if( "bankname".equals( textName ) )
								out.print("\t\tparent.MainForm.bankName.value = '"+textValue+"'; \r\n");
							if( "bankcode".equals( textName ) )
								out.print("\t\tparent.MainForm.bankCode.value = '"+textValue+"'; \r\n");
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
		out.print("\t\t\tparent.MainForm.bankCode.value='';\r\n");
		out.print("\t\t\tparent.MainForm.bankName.value='';\r\n");
		out.print("\t\t\tparent.MainForm.qryBankCode.value='';\r\n");
		out.print("\t\t\tparent.MainForm.qryBankName.value='';\r\n");
		out.print("\t\t}catch(e){}\r\n");
	}
%>
</script>