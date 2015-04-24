/**
*
* @author Andrew Sung
* @createDate 2006/8/23
*/
package tw.gov.nta.surplusage.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.CentralStatisticsMain;
import tw.gov.nta.sql.UserStatisticsMain;
import tw.gov.nta.surplusage.common.UserStatisticsManager;
import tw.gov.nta.surplusage.form.Gama0502Form;

import gov.dnt.tame.common.DefaultAction;

public class GAMA0502Change extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gama0502Form myForm = (Gama0502Form)form;
		UserStatisticsMain dto = new UserStatisticsManager().get(myForm.getMainId());
		if(myForm.getDataType().equals("A")){
			if(myForm.getBanish().equals("U")){
				myForm.setAuditAmount(dto.getAuditUamount1());
				myForm.setKeepAmount(dto.getOddKeepUamount1());
				myForm.setRealAmount(dto.getRealUamount1());
				myForm.setLastKeepAmount(dto.getOddKeepUamount1());
				myForm.setOldKeepAmount(dto.getOddKeepUamount1());
	    	}else if(myForm.getBanish().equals("B")){
	    		myForm.setRealAmount(dto.getRealBamount1());
	    		myForm.setAuditAmount(dto.getAuditBamount1());
				myForm.setKeepAmount(dto.getOddKeepBamount1());
				myForm.setLastKeepAmount(dto.getOddKeepBamount1());
				myForm.setOldKeepAmount(dto.getOddKeepBamount1());
	    	}
		}
		if(myForm.getDataType().equals("C")){
			if(myForm.getBanish().equals("U")){
				myForm.setAuditAmount(dto.getAuditUamount2());
				myForm.setKeepAmount(dto.getOddKeepUamount2());
				myForm.setRealAmount(dto.getRealUamount2());
				myForm.setLastKeepAmount(dto.getOddKeepUamount2());
				myForm.setOldKeepAmount(dto.getOddKeepUamount2());
	    	}else if(myForm.getBanish().equals("B")){
	    		myForm.setAuditAmount(dto.getAuditBamount2());
				myForm.setKeepAmount(dto.getOddKeepBamount2());
				myForm.setLastKeepAmount(dto.getOddKeepBamount2());
				myForm.setRealAmount(dto.getRealBamount2());
				myForm.setOldKeepAmount(dto.getOddKeepBamount2());
			}
		}
		request.setAttribute("mainAccountYear",dto.getAccountYear());
	}
}
