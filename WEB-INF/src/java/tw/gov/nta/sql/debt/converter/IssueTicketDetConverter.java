package tw.gov.nta.sql.debt.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import tw.gov.nta.sql.debt.IssueTicketDet;
import tw.gov.nta.sql.debt.virtual.IssueTicketDetVirtual;

public class IssueTicketDetConverter {

	public static List convert(List pIssueTicketDetList){
		ArrayList tList = new ArrayList();
		if(pIssueTicketDetList != null && pIssueTicketDetList.size() != 0){
			for(Iterator tIterator = pIssueTicketDetList.iterator(); tIterator.hasNext();)
				tList.add(convert((IssueTicketDet)tIterator.next()));	
		}
		return tList;
	}
	
	public static IssueTicketDetVirtual convert(IssueTicketDet pIssueTicket){
		return new IssueTicketDetVirtual(pIssueTicket);
	}
}
