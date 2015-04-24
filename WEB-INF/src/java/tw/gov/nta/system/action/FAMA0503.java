package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.system.common.BankCodeManage;
import tw.gov.nta.system.form.Fama0501Form;

/**
 * @author AndrewSungs
 */
public class FAMA0503 extends DefaultAction
{
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	Fama0501Form fama0501Form = (Fama0501Form) form;
    	fama0501Form.setBankRef(BankCodeManage.get(fama0501Form.getId()));
    }
}
