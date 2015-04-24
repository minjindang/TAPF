package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.Eama0301Form;
import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.sql.debt.DebtMain;

public class EAMA0302 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
	// TODO Auto-generated method stub
//	        Eama0101Form eama0101Form =  form;
        //�N�d�߱����J��Ʈw�����������
        //�ϥ�DebitCodeManage.query���J�����(Dto)�@�d��
		DebtManager manager = new DebtManager();
		Eama0301Form myform = (Eama0301Form)form;
		DebtMain debt = myform.getDebtMain();
		myform.setDebtMain(manager.getBean(debt.getId()));
	}

}
