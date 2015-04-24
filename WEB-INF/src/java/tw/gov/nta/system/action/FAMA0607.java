/* FAMA0207.java
�{���ت��GFAMA02
�{���N���GFAMA02
�{������G0950222
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
*/
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.sql.NationRef;
import tw.gov.nta.system.common.NationCodeManager;
import tw.gov.nta.system.form.Fama0601Form;

/**
 * @author EricChen
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class FAMA0607 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception
	 {
		// TODO �۰ʲ��ͤ�k Stub
		Fama0601Form myform = (Fama0601Form) form;
		
	
		myform.setCreateDate( new Date() );
		myform.setModDate( new Date() );
		myform.setUsrid(this.getUserId(request));
		
		//�ϥ�Service:NationCodeManager
		//�ϥ� NationCodeManager.create �s�W
		NationRef myNation = new NationRef();
		myNation.setNationNo(myform.getNationNo());
		List list = NationCodeManager.isModify(myNation);
		if(null == list || 0 == list.size())
		{	
			NationCodeManager.create(myform.getMyDto());
			setAlertMessage(request,"�s�W���\");
			 return mapping.findForward("sucess");
		}
		else
		{
			setAlertMessage(request,"�s�W����");
			myform.setContinentNo("");
			myform.setNationNo("");
			myform.setNationCname("");
			myform.setNationEname("");
			myform.setRemark("");
			 return mapping.findForward("failure");
		}	
	}
	public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	
    }
}
