<%@ page language="java" contentType="text/html;charset=MS950" %>
<%@ page import="gov.dnt.tame.util.CommonFun" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%
	String	accountYear	=	request.getParameter("para");
	
	String	debtType	=	"B";
%>
<script language="JScript" type="text/javascript">
<%
	if(Integer.parseInt(accountYear) < 95)
	{
		System.out.println("1231123");
		out.print("\t\tparent.MainForm.elements['bigDecimal(chargeRate)'].value = '0.00045'; \r\n");
	}
	String	sqlstr	=	"SELECT TOP 1 ";
			sqlstr	+=	" A.SERIAL_NO AS serialNo";
			sqlstr	+=	"  FROM ISSUE_MAIN A ";
			sqlstr	+=	" WHERE A.DEBT_TYPE='"+debtType+"'";
			sqlstr	+=	"   AND A.ACCOUNT_YEAR='"+accountYear+"'";
			sqlstr	+=	" ORDER BY CONVERT(NUMERIC,A.SERIAL_NO) desc ";

	List list = CommonFun.getList(sqlstr);

	Object [] object=null;
	if(list!=null && !list.isEmpty())
	{
		Map map = (Map) list.get(list.size()-1);

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

						if(map!=null && map.get(textName)!=null && map.get(textName).toString()!=null)
							textValue = map.get(textName).toString();
						if(textValue==null)
							textValue="";
						if( "serialno".equals( textName ) )
						{
							String serialNo;
							if("".equals(textValue))
							{
								serialNo = "01";
							}
							else
							{
								Integer serial = new Integer(Integer.parseInt(textValue)+1);
								serialNo= serial.toString();
								if(serial.intValue()<10)
									serialNo = "0"+serialNo;
							}

							out.print("\t\tparent.MainForm.debtName.value = '財政部國庫券"+Integer.parseInt(accountYear)+"年度第F"+Integer.parseInt(accountYear)+"-"+Integer.parseInt(serialNo)+"期'; \r\n");
							out.print("\t\tparent.MainForm.serialNo.value = '"+serialNo+"'; \r\n");
							out.print("\t\tparent.MainForm.issueSerial.value = 'F"+accountYear+"_"+serialNo+"'; \r\n");
						}
					}
				}
			}
		}
	}
	else
	{
		out.print("\t\tparent.MainForm.issueSerial.value = 'F"+accountYear+"_"+"01'; \r\n");
		out.print("\t\tparent.MainForm.debtName.value = '財政部國庫券"+Integer.parseInt(accountYear)+"年度第F"+Integer.parseInt(accountYear)+"-1期'; \r\n");
		out.print("\t\tparent.MainForm.serialNo.value = '01'; \r\n");
	}
%>
</script>