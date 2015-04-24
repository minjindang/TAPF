package tw.gov.nta.debt.common;

import java.util.Iterator;
import java.util.List;

public abstract class IManager {
//	public abstract Object getBean(int pId);
	public abstract void confirm(Object pDto)throws Exception;
	protected abstract boolean checkBean(Object pBean);

	public  void confirm(List pBeanList) throws Exception{
		if(pBeanList == null || pBeanList.size() == 0)
			throw new Exception();
		Iterator tIterator = pBeanList.iterator();
		while(tIterator.hasNext())
			confirm(tIterator.next());
	}
}
 
