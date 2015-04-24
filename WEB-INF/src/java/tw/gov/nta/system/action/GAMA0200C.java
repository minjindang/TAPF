/**
*
* @author Andrew Sung
* @createDate 2006/6/15
*/
package tw.gov.nta.system.action;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.sql.NationRef;
import tw.gov.nta.sql.dao.NationDebitMainDAO;
import tw.gov.nta.sql.dao.NationRefDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;
import tw.gov.nta.system.form.Gama0201Form;

import gov.dnt.tame.common.DefaultAction;

public class GAMA0200C extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gama0201Form myForm = (Gama0201Form) form;
		int accountYear = Integer.parseInt(myForm.getAccountYear());
		String key = "";
		String year = String.valueOf(Integer.parseInt(myForm.getAccountYear())-3);
		NationRef nationRef = new NationRefDAO().get(myForm.getNationRefId());
		if(accountYear < 89)
			key = "gnpAmount";
		else
			key = "gnpYearAmount";
		if(year.length() < 3)
			year = "0" + year ;
		if(year.length() < 2)
			year = "00" + year ;
		Session session = new NationDebitMainDAO().getSession();
//		StringBuffer hqlStr = new StringBuffer("select sum("+key+") from NationDebitMain where 1=1");
//		hqlStr.append(" and nationCode =  "+nationRef);
		StringBuffer hqlStr = new StringBuffer("select isNull(sum(NDM."+key+")/3,0)");
		hqlStr.append(" from NationDebitMain NDM where 1 = 1");
		hqlStr.append(" and NDM.nationCode.id =" + myForm.getNationRefId());
		hqlStr.append(" and NDM.accountYear < '" + myForm.getAccountYear()+"'");
		hqlStr.append(" and NDM.accountYear >= '" + year+"'");
		Query query = session.createQuery(hqlStr.toString());
		List list = query.list();
		session.close();
		System.out.println("hqlStr:"+hqlStr.toString());
		if(list!=null && !list.isEmpty()){
			myForm.setPergnpAmount(new BigDecimal(list.iterator().next().toString()));
			System.out.println("ензб:"+myForm.getPergnpAmount());
		}
	}
}
