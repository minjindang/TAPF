/*
 * Created on 2004/10/29
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package gov.dnt.tame.common;

import javax.servlet.http.HttpServletRequest;

import com.kangdainfo.ast.security.auth.AuthContext;

/**
 * @author bhung
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class AuthContextFactory
{
    public static AuthContext getAuthContext(HttpServletRequest request)
    {
        return new MockedAuthContext(request);
    }
}
