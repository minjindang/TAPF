package tw.gov.nta.central.action;
import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.UnitInfo;
import tw.gov.nta.central.common.UnitPercent;
import tw.gov.nta.central.common.UnitPercent101;
import tw.gov.nta.central.form.Hama0401Form;

public class HAMA0401 extends DefaultAction {
	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		//���o formBean
		Hama0401Form hama0401form = (Hama0401Form) form;

		//�ϥ�Service:UnitInfo
		//�ϥ� UnitInfo.getUnitInfoMain �d�߳浧
		//�^�� ActionForm
		hama0401form.setUnitInfoMain(UnitInfo.get(hama0401form.getId()));
		if(hama0401form.getQryTyear().trim().length() == 0){
			hama0401form.setQryTyear(UnitPercent101.getMaxYear(hama0401form.getUnitInfoMain()));
		}
	}
}
