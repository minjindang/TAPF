/* $Id: DefaultAuthContext.java,v 1.1 2006/04/25 03:43:36 william Exp $ */
package gov.dnt.tame.common;

import javax.servlet.http.HttpServletRequest;

import com.kangdainfo.ast.security.auth.AuthContextImpl;

/**
 * @author rayt
 *
 */
public class DefaultAuthContext extends AuthContextImpl 
{
    /**
     * �b��
     */
    private String userAccount;
    /**
     * �ϥΪ̳��id
     */
    private Integer unitId;
    /**
     * �ϥΪ̳��N�X
     */
    private String unitCode;
    /**
     * �ϥΪ̳��W��
     */
    private String unitName;
    /**
     * �ϥΪ̧��Oid
     */
    private Integer deptId;
    /**
     * �ϥΪ̧��O�N�X
     */
    private String deptCode;
    /**
     * �ϥΪ̧��O�W��
     */
    private String deptName;
    /**
     * �ϥΪ̼h��
     */
    private String level;
     
	/**
	 * @param request
	 */
	public DefaultAuthContext(HttpServletRequest request) {
		super(request);
	}	
    /**
     * @return Returns the userAccount.
     */
    public String getUserAccount()
    {
        return userAccount;
    }
    /**
     * @param userAccount The userAccount to set.
     */
    public void setUserAccount(String userAccount)
    {
        this.userAccount = userAccount;
    }
    /**
     * @return Returns the unitId.
     */
    public Integer getUnitId()
    {
        return unitId;
    }
    /**
     * @param unitId The unitId to set.
     */
    public void setUnitId(Integer unitId)
    {
        this.unitId = unitId;
    }
    
    /**
     * @return Returns the deptCode.
     */
    public String getDeptCode()
    {
        return deptCode;
    }
    /**
     * @param deptCode The deptCode to set.
     */
    public void setDeptCode(String deptCode)
    {
        this.deptCode = deptCode;
    }
    /**
     * @return Returns the deptId.
     */
    public Integer getDeptId()
    {
        return deptId;
    }
    /**
     * @param deptId The deptId to set.
     */
    public void setDeptId(Integer deptId)
    {
        this.deptId = deptId;
    }
    /**
     * @return Returns the deptName.
     */
    public String getDeptName()
    {
        return deptName;
    }
    /**
     * @param deptName The deptName to set.
     */
    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }
    /**
     * @return Returns the unitCode.
     */
    public String getUnitCode()
    {
        return unitCode;
    }
    /**
     * @param unitCode The unitCode to set.
     */
    public void setUnitCode(String unitCode)
    {
        this.unitCode = unitCode;
    }
    /**
     * @return Returns the unitName.
     */
    public String getUnitName()
    {
        return unitName;
    }
    /**
     * @param unitName The unitName to set.
     */
    public void setUnitName(String unitName)
    {
        this.unitName = unitName;
    }
	/**
	 * @return �Ǧ^ level�C
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * @param level �n�]�w�� level�C
	 */
	public void setLevel(String level) {
		this.level = level;
	}
}
