<%@ page language="java" contentType="text/html;charset=MS950" %>
<%@ page import="gov.dnt.tame.common.LabelValueBean"%>
<%@ page import="java.util.*" %>
<script language="JScript" type="text/javascript">
<%
	Integer	budgetCode	= new Integer(Integer.parseInt(request.getParameter("budgetCode")));
	String debtCode = (String)request.getParameter("debtCodeOption");
	List list = new LinkedList();
	list = tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(budgetCode);
	if(list.size()!=0)
	{
		out.print("parent.MainForm."+debtCode+".value =\"\";");
		out.print("parent.MainForm."+debtCode+"_options.length = 0;");
		out.print("parent.MainForm."+debtCode+"_options.options[0] = new Option(\"請選擇\", \"\");");
		int i = 1;
		for (Iterator it = list.iterator(); it.hasNext();)
        {
			LabelValueBean bean = (LabelValueBean)it.next();
			//out.print("parent.MainForm.debtCode.options["+i+"].value = "+bean.getValuess()+";");
			//out.print("parent.MainForm.debtCode.options["+i+"].label = "+bean.getLabel()+";");
			out.print("parent.MainForm."+debtCode+"_options.options["+i+"] = new Option(\""+bean.getLabel()+"\", \""+bean.getValuess()+"\");");
			i++;
		}
	}
	else
	{
		out.print("parent.MainForm."+debtCode+".value =\"\";");
		out.print("parent.MainForm."+debtCode+"_options.length = 0;");
		out.print("parent.MainForm."+debtCode+"_options.options[0] = new Option(\"請選擇\", \"\");");
	}
%>
</script>