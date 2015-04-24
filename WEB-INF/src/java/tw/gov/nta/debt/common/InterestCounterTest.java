package tw.gov.nta.debt.common;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import tw.gov.nta.sql.debt.DebtRateDet;

import junit.framework.TestCase;

public class InterestCounterTest extends TestCase {

	/*
	 * Test method for 'tw.gov.nta.debt.common.InterestCounter.countInterest(Date, Date, List, double, int)'
	 */
	public void testCountInterest() {
		InterestCounter counter = new InterestCounter();
		Date issueDate = new Date(106,9,25);
		Date dueDate = new Date(109,3,25);
		List tempRateList = new ArrayList();
		DebtRateDet tempRateDet = new DebtRateDet();
		//tempRateDet.setDebt(debt);
		tempRateDet.setDebtRate(new BigDecimal(1.6));
		tempRateDet.setDeleteMark("N");
		tempRateDet.setEffectiveDate(issueDate);
		tempRateDet.setGroupId(1);
		tempRateDet.setSuspendDate(dueDate);
		tempRateList.add(tempRateDet);
		BigDecimal originInterestAmount = counter.countInterest(issueDate,dueDate,tempRateList,5000000000d,3);
		System.out.print(originInterestAmount.doubleValue());
		assertTrue(originInterestAmount.equals(240000000));
	}

}
