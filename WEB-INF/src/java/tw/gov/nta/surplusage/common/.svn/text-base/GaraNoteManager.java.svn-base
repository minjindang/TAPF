package tw.gov.nta.surplusage.common;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import tw.gov.nta.sql.debt.GaraNote;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.GaraNoteDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;

public class GaraNoteManager {
	private GaraNoteDAO dao;

	public GaraNoteManager() {
		dao = new GaraNoteDAO();
	}
	public void confirm(GaraNote pGaraNote) throws Exception {
		dao.saveOrUpdate(pGaraNote);
	}
	public void cancel(int pGaraNoteId) throws Exception{
		dao.delete(pGaraNoteId);
	}
	public GaraNote getGaraNote(String path){
		Session tSession = dao.getSession();
		Criteria criteria = tSession.createCriteria(GaraNote.class);
		criteria.add(Expression.eq("path", path));
		List tList = criteria.list();
		tSession.close();
		if(tList.size()>0)
			return (GaraNote)tList.get(0);
		else
			return new GaraNote();
	}
}
