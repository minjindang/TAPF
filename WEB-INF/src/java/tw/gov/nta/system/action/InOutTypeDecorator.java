/**
*
* @author Andrew Sung
* @createDate 2006/6/28
*/
package tw.gov.nta.system.action;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

import tw.gov.nta.sql.CodeDet;
import tw.gov.nta.sql.dao.CodeDetDAO;

public class InOutTypeDecorator implements DisplaytagColumnDecorator {

	public Object decorate(Object arg0, PageContext arg1, MediaTypeEnum arg2) throws DecoratorException {
		if( arg0==null)
			return "";
		else{
			Session session = new CodeDetDAO().getSession();
	        Criteria tCodeDetCriteria = session.createCriteria(CodeDet.class);
	        Criteria tCodeMainCriteria = tCodeDetCriteria.createCriteria("kind");
	        tCodeMainCriteria.add(Restrictions.eq("kindNo", "IO"));
	        tCodeDetCriteria.add(Expression.eq("codeNo",arg0.toString()));
	        if(tCodeDetCriteria.list().size()>0)
	        	return ((CodeDet)tCodeDetCriteria.list().get(0)).getCodeName();
	        else
	        	return "";
		}
	}

}
