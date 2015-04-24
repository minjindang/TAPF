<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<script language="javascript">

function doBodyOnLoad(document)
{
		//do nothing
}

function checkValue(form)
{
	
	if (!CheckValidDate(form.elements['date(issueSdate)'].value)){
		form.elements['date(issueSdate)'].value = "";
		return false;
	}
	if (!CheckValidDate(form.elements['date(issueEdate)'].value)){
		form.elements['date(issueEdate)'].value = "";
		return false;
	}
	if (form.elements['date(issueSdate)'].value > form.elements['date(issueEdate)'].value){
		alert("發行日期起需小於等於發行日期迄");
		form.elements['date(issueSdate)'].value = "";
		form.elements['date(issueEdate)'].value = "";
		return false;
	}
	return true;
}

</script>