package tw.gov.nta.account.form;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.sql.debt.IssueMain;

public class IssueDecorator implements DisplaytagColumnDecorator {

	public Object decorate(Object arg0, PageContext arg1, MediaTypeEnum arg2)
			throws DecoratorException {
		// TODO Auto-generated method stub
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//		String result = dateFormat.format((Date)arg0);
//		return result;
		if (arg0 == null)
			return "";
		
		int issueId = new Integer(arg0.toString()).intValue();
		IssueMain issueMain = new IssueManager().getBean(issueId);
		return issueMain.getIssueSerial();
	}

}
