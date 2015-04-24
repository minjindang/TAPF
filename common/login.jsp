<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ page import="gov.dnt.tame.common.Constants" %>

<html:html>
<head>
	<title>°????T??§? ?X?i?f?t°????z???f?~?????t??</title>
	<meta content="mshtml 6.00.2800.1106" name=generator>
	<meta http-equiv="content-type" content="text/html; charset=big5">
	<link rel="stylesheet" href="../assets/styles/login.css" type="text/css">
	<script src="../assets/scripts/button.js"></script>
	<script language="javascript">
		function doBodyOnLoad()
		{
	   		<logic:equal name="passWordError" value="<%=Constants.PASSWORD_ERROR%>">
				alert("<bean:message key="prompt.passWordError"/>");
			</logic:equal>
	   		<logic:equal name="noUser" value="<%=Constants.NO_USER%>">
				alert("<bean:message key="prompt.noUser"/>");
			</logic:equal>
			currform = document.smuserForm;
			currform.usrId.focus();
		}

		function checkElements()
		{
			currform = document.smuserForm;
			if ("" == currform.usrId.value)
			{
				alert("?????J??????±b??!!");
				currform.usrId.focus();
				return false;
			}

			if ("" == currform.passWd.value)
			{
				alert("?????J±K?X!!");
				currform.passWd.focus();
				return false;
			}
			currform.submit();
			return true;
		}

		function keydown()
		{
			if ("13" == event.keyCode)
			{
				checkElements();
			}
		}

		function reset()
		{
			currform = document.smuserForm;
			currform.reset();
		}
	</script>
</head>
<body text=#000000 vlink=#ffffff alink=#ff0000 link=#ffffff bgcolor=#ffffff
		leftmargin=0 topmargin=0
		onload="javascript:MM_preloadImages('../assets/images/main/login/icon_login.gif',
		'../assets/images/main/login/icon_reset.gif');doBodyOnLoad();">
<center>
	<table cellspacing=0 cellpadding=0 width=778 border=0>
		<tbody>
			<tr>
				<td height=63>&nbsp;</td>
				<td height=63>&nbsp;</td>
				<td height=63>&nbsp;</td>
				<td height=63>&nbsp;</td>
			</tr>
			<tr>
				<td width=90><img src="../assets/images/main/login/login1.gif" height=86 width=90></td>
				<td width=333 background="../assets/images/main/login/login2.gif"></td>
				<td width=152><img src="../assets/images/main/login/login3.gif" height=86 width=152></td>
				<td width=203><img src="../assets/images/main/login/login4.gif" height=86 width=203></td>
			</tr>
		</tbody>
	</table>
	<table cellspacing=0 cellpadding=0 width=778 border=0>
		<html:form action="" method="post" target="_top">
			<tbody>
		  		<tr valign=top>
		    		<td width=270>
		      			<table cellspacing=0 cellpadding=0 width=270 border=0>
		        			<tbody>
		        				<tr>
		          					<td background="../assets/images/main/login/login5.gif" width=270 height=141>
		            					<table cellspacing=0 cellpadding=2 width=200 align=center border=0>
											<tbody>
		              							<tr>
		                							<td class=text_red align=middle>?@

													</td>
												</tr>
		              							<tr>
		                							<td>
		                  								<table cellspacing=0 cellpadding=2 width=200 border=0>
		                    								<tbody>
		                    									<tr>
		                      										<td align=middle width=56>
																		<img height=20 src="../assets/images/main/login/account.gif" width=36>
																	</td>
		                      										<td width=144>
																	  	<html:text styleClass="form" size='12' maxlength='10' property="usrId"/>
																	</td>
																</tr>
											                    <tr>
											                      	<td align=middle width=56>
																	  	<img height=20 src="../assets/images/main/login/password.gif" width=36>
																	</td>
											                      	<td width=144>
																	  	<html:password styleClass="form" size='12' maxlength='10' property="passWd"
																		  	onkeydown="javascript:keydown(this);"/>
																	</td>
																</tr>
											                    <tr>
		                      										<td width=56>&nbsp;</td>
		                      										<td align=middle width=144>
																		<img src="../assets/images/main/login/icon_login.gif"
																		height=15 width=43 border=0 name=image11
																		onclick="javascript:return(checkElements(this));">
																		<img height=15 src="../assets/images/main/login/icon_reset.gif"
																		width=43 border=0 name=image12
																		onclick="javascript:return(reset(this));">
																	</td>
																</tr>
															</tbody>
														</table>
													</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
		        				<tr>
		          					<td class=bestview>
									  	&nbsp;&nbsp;&nbsp;&nbsp;best view with ie6.0+ and 800*600
									</td>
								</tr>
							</tbody>
						</table>
		    			<td width=125>
							<img height=205 src="../assets/images/main/login/login6.gif" width=125>
						</td>
		    			<td width=360>
							<table cellspacing=0 cellpadding=0 width=360 border=0>
								<tbody>
									<tr>
										<td><img src="../assets/images/main/login/login7.gif"
											height=101 width=180><img
											src="../assets/images/main/login/login8.gif" height=101 width=180></td>
									</tr>
      								<tr>
										<td class=text background="../assets/images/main/login/login11.gif" valign=top height=95>
                    						<marquee class=textcss onmouseover=scrollamount=1
												style="border-right: #1e90ff 1px dotted; border-top: #1e90ff 1px dotted; border-left: #1e90ff 1px dotted; line-height: 200%; border-bottom: #1e90ff 1px dotted"
												onmouseout=scrollamount=1 scrollamount=1 direction=up width=355
												height=95 align="center">
												<span id=post1 style="display: block"><img src="../assets/images/main/login/item_1.gif">
													<div style="padding-right: 15px; padding-left: 15px; line-height: 150%">
														<logic:present name="DescList">
															<logic:iterate id="DescList" name="DescList">
																<br><bean:write name="DescList" property="label"/><br>
															</logic:iterate>
														</logic:present>
													</div>
												</span>
											</marquee>
										</td>
									</tr>
         							<tr>
										<td><img height=9 src="../assets/images/main/login/login10.gif" width=360></td>
									</tr>
								</tbody>
							</table>
						</td>
						<td>
							<img height=205 src="../assets/images/main/login/login9.gif" width=23>
						</td>
					</td>
				</tr>
			</tbody>
		</html:form>
	</table>
</center>
</body>
</html:html>