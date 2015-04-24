/**
*
* @author Andrew Sung
* @createDate 2006/6/12
*/
package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.exchequer.form.Bima0201Form;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class BIMA0200 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Bima0201Form myForm = (Bima0201Form)form;
		IssueMain issueMain = new IssueManager().getBean(myForm.getIssueId());
		myForm.setDebtName(issueMain.getDebtName());
		//myForm.setManageCapitalAmount(issueMain.getIssueAmount().subtract(issueMain.getRealAmount()));
		myForm.setIssueAmount(issueMain.getIssueAmount());
		if(myForm.getRepayDate() == null)
			myForm.setRepayDate(new Date());
		myForm.setIssueDate(issueMain.getIssueDate());
		myForm.setDueDate(issueMain.getDueDate());
		myForm.setInterestDays(DateUtil.getDays(myForm.getRepayDate(),issueMain.getDueDate()));
		myForm.setCapitalAmount(issueMain.getRealAmount());
		
		
		//System.out.println(myForm.getManageCapitalAmount());
		
		List payList = new PayManager().getDataByIssue(issueMain.getId());
		String interestSerialTemp = "";
		if (payList.size()==0)
		{
			interestSerialTemp = "1";
		}
		else
		{
			for(Iterator it=payList.iterator();it.hasNext();)
			{
				PaymentMain paymentMainDto = (PaymentMain)it.next();
				//capitalSerialTemp = String.valueOf((char)(((int)(paymentMainDto.getInterestSerial().charAt(0)))+1));\
				if(null != paymentMainDto.getInterestSerial())
				{	
					interestSerialTemp = String.valueOf(Integer.parseInt(paymentMainDto.getInterestSerial())+1) ;
				}
				myForm.setPlan(paymentMainDto.getPlan());
			}
		}
		myForm.setInterestSerial(interestSerialTemp);

	}
}
