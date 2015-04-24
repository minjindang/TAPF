package tw.gov.nta.account.form;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;

import tw.gov.nta.sql.BudgetRef;
import tw.gov.nta.sql.dao.BudgetRefDAO;

public class BudgetCodeNameDecorator implements DisplaytagColumnDecorator {

	public Object decorate(Object arg0, PageContext arg1, MediaTypeEnum arg2)
			throws DecoratorException {
		BudgetRefDAO dao = BudgetRefDAO.getInstance();
		BudgetRef ref = dao.get((Integer)arg0);
		String budgetName = ( ref==null )?"":ref.getBudgetName();
		return budgetName;
	}
}
