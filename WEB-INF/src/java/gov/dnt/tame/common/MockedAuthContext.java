package gov.dnt.tame.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kangdainfo.ast.common.BeanNames;

public class MockedAuthContext extends DefaultAuthContext 
{
	public MockedAuthContext(HttpServletRequest request) {
		super(request);
		HttpSession session = request.getSession(true);
				
		if (null != session.getAttribute(BeanNames.USER_NAME_BEAN))
		    setUserName(session.getAttribute(BeanNames.USER_NAME_BEAN).toString());
		
		if (null != session.getAttribute("ACCOUNT"))
			setUserId(session.getAttribute("ACCOUNT").toString());
		if (null != session.getAttribute("DEPTID"))
			setDeptId(new Integer(session.getAttribute("DEPTID").toString()));
		if (null != session.getAttribute("DEPT"))
			setDeptName(session.getAttribute("DEPT").toString());
		if (null != session.getAttribute("LEVEL"))
		    setLevel(session.getAttribute("LEVEL").toString());
		if (null != session.getAttribute("NAME"))
		    setUserName(session.getAttribute("NAME").toString());

	}
}
