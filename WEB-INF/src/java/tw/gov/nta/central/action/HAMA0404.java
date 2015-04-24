package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.UnitInfo;
import tw.gov.nta.central.form.Hama0401Form;
import tw.gov.nta.sql.UnitInfoMain;
public class HAMA0404 extends DefaultAction {
	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		//���o formBean
		Hama0401Form hama0401form = (Hama0401Form) form;

		UnitInfoMain unitInfoMain = new UnitInfoMain();
		BeanUtils.copyProperties(unitInfoMain, hama0401form);

		// setModDate �g�J�ק���
		unitInfoMain.setModDate(new Date());

		//�ϥ�Service:UnitInfo
		//�ϥ� UnitInfo.update ��s
		UnitInfo.update(unitInfoMain);
		setAlertMessage(request, "��s���\");
	}
}
