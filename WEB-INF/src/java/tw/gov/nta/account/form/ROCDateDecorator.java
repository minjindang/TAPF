package tw.gov.nta.account.form;

import gov.dnt.tame.util.DateUtil;

import java.util.Date;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;

public class ROCDateDecorator implements DisplaytagColumnDecorator {

	public Object decorate(Object arg0, PageContext arg1, MediaTypeEnum arg2)
			throws DecoratorException {
		// TODO Auto-generated method stub
		Date sourceDate = (Date)arg0;
		
		return DateUtil.date2ROCStr(sourceDate,"yyy/mm/dd");

	}

}
