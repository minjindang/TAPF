<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<%@ page import="gov.dnt.tame.util.DateUtil" %>

<logic:present name="collection">
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
					<bean:define id="folder" name="row" property="folder" type="java.lang.String"/>
				<display:column title="檔案名稱" >
					<bean:define id="ID" name="row" property="ID" type="java.lang.Integer"/>
					<bean:define id="filename" name="row" property="filename" type="java.lang.String"/>
					
					<%
						String	myLink	=	"EARF0106?";
						myLink	+= "ID=" + ID;
						myLink  += "&folder=" + folder;
						myLink  += "&fileName=" + filename;
				
					%>
					<A href="<%=myLink%>">
						<bean:write name='row' property='filename'/>.XML
					</A>
				</display:column>
				
				<display:column title="會計年度" >

					<%out.print(folder.substring(0,3)); %>
				</display:column>
				<display:column title="會計月份" >

					<%out.println(folder.substring(3,5)); %>
				</display:column>
				
				<display:column title="異動人員" >
					<bean:write name='row' property='MOD_USR'/>
				</display:column>
				<display:column title="異動時間" >
					<bean:define id="MOD_DATE" name="row" property="MOD_DATE" type="java.util.Date"/>
					<% 	out.print(DateUtil.date2ROCStr(MOD_DATE,"yyy/MM/dd"));%>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
</logic:present>