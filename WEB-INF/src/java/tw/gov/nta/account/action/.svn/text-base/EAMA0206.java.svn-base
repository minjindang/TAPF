/*
 * 在 2006/2/22 建立
 */
package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.hibernate.Session;

import tw.gov.nta.account.form.Eama0201Form;
import tw.gov.nta.account.form.Eama0202Form;
import tw.gov.nta.sql.debt.account.AccountPhaseDet;
import tw.gov.nta.sql.debt.account.AccountPhaseMain;
import tw.gov.nta.sql.debt.account.dao.AccountPhaseMainDAO;

/**
 * @author AndrewSung
 */
public class EAMA0206 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
//      Eama0101Form eama0101Form =  form;
        //將查詢條件放入資料庫中對應之欄位
        //使用DebitCodeManage.query對輸入之資料(Dto)作查詢
    	Session session = AccountPhaseMainDAO.getInstance().getSession();
		AccountPhaseMain accountPhaseMain;
		Eama0202Form eama0202FormSource = (Eama0202Form)request.getAttribute("Eama0202Form");
		
		if (eama0202FormSource != null)
			accountPhaseMain = (AccountPhaseMain)session.load(AccountPhaseMain.class,eama0202FormSource.getAccountPhase().getId());
		else
			accountPhaseMain = (AccountPhaseMain)session.load(AccountPhaseMain.class,((Eama0201Form)form).getId());

	    ((Eama0201Form)form).setAccountPhase(accountPhaseMain);
	    Set accountPhaseDets = accountPhaseMain.getAccountPhaseDets();
	    List<Eama0202Form> eama0202FormList = new ArrayList<Eama0202Form>();
	    for(Iterator iterator = accountPhaseDets.iterator();iterator.hasNext();){
	    	Eama0202Form eama0202Form = new Eama0202Form();
	    	BeanUtils.copyProperties(eama0202Form,(AccountPhaseDet)iterator.next());
	    	eama0202FormList.add(eama0202Form);
	    }
	    
    	request.setAttribute("collection",eama0202FormList);
    	session.close();
    }

}
