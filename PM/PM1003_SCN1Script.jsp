<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>

<!-- roleToFunScript.jsp -->

<script type="text/javascript" src="<html:rewrite page="/assets/scripts/xtree/xtree.js"/>"></script>
<script type="text/javascript" src="<html:rewrite page="/assets/scripts/x/x_core.js"/>"></script>
<script type="text/javascript" src="<html:rewrite page="/assets/scripts/x/x_dom.js"/>"></script>
<script type="text/javascript" src="<html:rewrite page="/assets/scripts/x/x_event"/>"></script>
<script type="text/javascript" src="<html:rewrite page="/assets/scripts/x/x_slide.js"/>"></script>
<script type="text/javascript" src="<html:rewrite page="/assets/scripts/CollapsibleCheckboxMenu.js"/>"></script>

<script language="javascript">

	function doBodyOnLoad(document)
	{
         menuInit('theMenu', false);
	}
	
	function checkForm(form)
	{
		var roleid = form.GCODE.value;	
		if( isBlank(roleid) )
		{
			alert("�п�ܡi�ϥΪ̡j!");
			return false;
		}
		
		var group = form.PM0004ID.value;		
		if( isBlank(group) )
		{
			alert("�п�ܡi�s�աj!");
			return false;
		}
		
		return true;
	}
</script>