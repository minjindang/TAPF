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

function checkValue(form)
{
 	var isValid = true;
    var sError = "";
	if ("" == form.titlea.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【未扣墊借】主旨不可空白!!";
        form.titlea.focus();
        alert(sError);
		return isValid;
    }
    if ("" == form.titleb.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【已扣墊借】主旨不可空白!!";
        form.titleb.focus();
        alert(sError);
		return isValid;
    }
    if ("" == form.contenta.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【未扣墊借】內容不可空白!!";
        form.contenta.focus();
        alert(sError);
		return isValid;
    }
    if ("" == form.contentb.value)
    {
    	isValid = false;
		sError += "\n";
        sError += "【已扣墊借】內容不可空白!!";
        form.contentb.focus();
        alert(sError);
		return isValid;
    }
	return isValid;
}


</script>