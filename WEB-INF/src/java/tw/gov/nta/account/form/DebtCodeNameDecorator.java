package tw.gov.nta.account.form;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;

import tw.gov.nta.sql.DebitRef;
import tw.gov.nta.sql.dao.DebitRefDAO;

public class DebtCodeNameDecorator implements DisplaytagColumnDecorator {

	public Object decorate(Object arg0, PageContext arg1, MediaTypeEnum arg2)
			throws DecoratorException {
		DebitRefDAO dao = DebitRefDAO.getInstance();
		DebitRef ref = dao.get((Integer)arg0);
		String debitName = (ref==null)?"":ref.getDebitName();
		return debitName;
	}
}
