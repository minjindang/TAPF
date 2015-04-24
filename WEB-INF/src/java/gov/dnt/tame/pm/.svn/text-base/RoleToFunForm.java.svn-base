package gov.dnt.tame.pm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class RoleToFunForm extends ActionForm
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;															//ID
	private String roleid;														//®§¶‚
    private String roleName;         	                                     	//®§¶‚Name
    private String programid;													//fun id
    private String[] items;
    private String stream;

	public String getId()
 	{
  		return this.id;
	}

	public void setId(String id)
	{
 		this.id = id;
   	}

    public boolean hasId()
 	{
  		if ((null == this.getId()) ||
    		(0 == this.getId().length()))
    	{
     		return false;
       	}
       	return true;
  	}

	public String getRoleid()
	{
		return this.roleid;
	}

	public void setRoleid(String roleid)
	{
		this.roleid = roleid;
	}

    public boolean hasRoleId()
 	{
  		if ((null == this.getRoleid()) ||
    		(0 == this.getRoleid().length()))
    	{
     		return false;
       	}
       	return true;
  	}

	public String getRoleName()
	{
		return this.roleName;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

	public String getProgramid()
	{
		return programid;
	}

	public void setProgramid(String value)
	{
		programid = value;
	}

	public String[] getItems()
	{
		return this.items;
	}

	public void setItems(String[] items)
	{
		this.items = items;
	}

	public boolean hasItems()
 	{
  		if (null == this.getItems())
		{
			return false;
		}
		if (0 == this.getItems().length)
		{
			return false;
		}
		return true;
  	}

	public String getStream()
	{
		return this.stream;
	}

	public void setStream(String stream)
	{
		this.stream = stream;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request)
	{
		this.id = null;
		this.roleid = null;
		this.roleName = null;
		this.programid = null;
	}

	/**public ActionErrors validate(ActionMapping mapping,
								 HttpServletRequest request)
	{
		donothing
	}**/
}
