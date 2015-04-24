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

public class GAMA0513 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gama0503Form myForm = (Gama0503Form)form;
		String key = "";
		UserStatisticsMain userStatisticsMain = new UserStatisticsManager().get(myForm.getMainId());
		if(myForm.getChangeKey1()!=null)
			key = "1";
		else if(myForm.getChangeKey2()!=null)
			key = "2";
		if(key == "1"){
			userStatisticsMain.setKeepUamount1(userStatisticsMain.getKeepUamount1().subtract(myForm.getKeepUamount()));
			userStatisticsMain.setKeepUamount2(userStatisticsMain.getKeepUamount2().add(myForm.getKeepUamount()));
			userStatisticsMain.setKeepBamount1(userStatisticsMain.getKeepBamount1().subtract(myForm.getKeepBamount()));
			userStatisticsMain.setKeepBamount2(userStatisticsMain.getKeepBamount2().add(myForm.getKeepBamount()));
			userStatisticsMain.setOddKeepUamount1(userStatisticsMain.getOddKeepUamount1().subtract(myForm.getKeepUamount()));
			userStatisticsMain.setOddKeepUamount2(userStatisticsMain.getOddKeepUamount2().add(myForm.getKeepUamount()));
			userStatisticsMain.setOddKeepBamount1(userStatisticsMain.getOddKeepBamount1().subtract(myForm.getKeepBamount()));
			userStatisticsMain.setOddKeepBamount2(userStatisticsMain.getOddKeepBamount2().add(myForm.getKeepBamount()));
		}
		else if(key == "2"){
			userStatisticsMain.setKeepUamount1(userStatisticsMain.getKeepUamount1().add(myForm.getKeepUamount()));
			userStatisticsMain.setKeepUamount2(userStatisticsMain.getKeepUamount2().subtract(myForm.getKeepUamount()));
			userStatisticsMain.setKeepBamount1(userStatisticsMain.getKeepBamount1().add(myForm.getKeepBamount()));
			userStatisticsMain.setKeepBamount2(userStatisticsMain.getKeepBamount2().subtract(myForm.getKeepBamount()));
			userStatisticsMain.setOddKeepUamount1(userStatisticsMain.getOddKeepUamount1().add(myForm.getKeepUamount()));
			userStatisticsMain.setOddKeepUamount2(userStatisticsMain.getOddKeepUamount2().subtract(myForm.getKeepUamount()));
			userStatisticsMain.setOddKeepBamount1(userStatisticsMain.getOddKeepBamount1().add(myForm.getKeepBamount()));
			userStatisticsMain.setOddKeepBamount2(userStatisticsMain.getOddKeepBamount2().subtract(myForm.getKeepBamount()));
		}
		new UserStatisticsManager().update(userStatisticsMain);
		Gama0501Form mainForm = new Gama0501Form();
		mainForm.setUserStatisticsMain(new UserStatisticsManager().get(myForm.getMainId()));
		request.setAttribute("Gama0501Form",mainForm);
		setAlertMessage(request, "Âà²¾§¹¦¨!!");
	}

}
