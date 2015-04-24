/**
*
* @author Andrew Sung
* @createDate 2006/9/26
*/
package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.UserStatisticsMain;
import tw.gov.nta.surplusage.common.UserStatisticsManager;
import tw.gov.nta.surplusage.form.Gama0501Form;
import tw.gov.nta.surplusage.form.Gama0503Form;

public class GAMA0512 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gama0501Form myForm = (Gama0501Form)form;
		Gama0503Form gama0503Form = new Gama0503Form();
		gama0503Form.setMainId(myForm.getId());
		UserStatisticsMain mainDto = new UserStatisticsManager().get(myForm.getId());
		gama0503Form.setOddKeepBamount1(mainDto.getOddKeepBamount1());
		gama0503Form.setOddKeepBamount2(mainDto.getOddKeepBamount2());
		gama0503Form.setOddKeepUamount1(mainDto.getOddKeepUamount1());
		gama0503Form.setOddKeepUamount2(mainDto.getOddKeepUamount2());
		gama0503Form.setKeepBamount1(mainDto.getKeepBamount1());
		gama0503Form.setKeepBamount2(mainDto.getKeepBamount2());
		gama0503Form.setKeepUamount1(mainDto.getKeepUamount1());
		gama0503Form.setKeepUamount2(mainDto.getKeepUamount2());
		request.setAttribute("Gama0503Form",gama0503Form);
	}

}
