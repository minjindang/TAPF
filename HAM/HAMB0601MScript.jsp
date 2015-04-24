<!-- Andrew Sung -->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<script language="javascript">

function doBodyOnLoad(document)
{
	<logic:present name="historyBack">
		window.history.back();
	</logic:present>
}


function checkForm(form)
{
	var isValid = true;
    var sError = "";
	if( form.SUP_YEAR.value == "")
	{
		isValid = false;
		sError += "\n";
        sError += "【記帳年度】不可空白!!";
        form.SUP_YEAR.focus();
        alert(sError);
		return isValid;

	}
	if( form.SUP_MONTH.value == "")
	{
		isValid = false;
		sError += "\n";
        sError += "【撥款月份】不可空白!!";
        form.SUP_MONTH.focus();
        alert(sError);
		return isValid;
	}
	if( form.SUP_DATE.value == "")
	{
		isValid = false;
		sError += "\n";
        sError += "【匯款日期】不可空白!!";
        form.SUP_DATE.focus();
        alert(sError);
		return isValid;
	}
	if( form.supCount.value == "")
	{
		isValid = false;
		sError += "\n";
        sError += "【撥款次數】不可空白!!";
        form.supCount.focus();
        alert(sError);
		return isValid;
	}
	if (!(CheckValidDate(form.SUP_DATE.value)))
    {
    	isValid = false;
    	form.SUP_DATE.select();
		return isValid;
    }
	return isValid;	
}


</script>