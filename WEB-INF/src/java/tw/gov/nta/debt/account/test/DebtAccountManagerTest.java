package tw.gov.nta.debt.account.test;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.debt.account.common.DebtAccountManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.sql.account.AccountRef;
import tw.gov.nta.sql.account.VoucherDet;
import tw.gov.nta.sql.account.VoucherMain;
import tw.gov.nta.sql.debt.DebtTypeRef;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.account.AccountPhaseDet;
import tw.gov.nta.sql.debt.account.AccountPhaseMain;
import tw.gov.nta.sql.debt.dao.DebtTypeRefDAO;

public class DebtAccountManagerTest extends TestCase {
	IssueManager issueManager = new IssueManager();
	DebtAccountManager accountManager = new DebtAccountManager();
	IssueMain issueMain;
	AccountPhaseMain phase;
	protected void setUp() throws Exception {
		super.setUp();		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		issueManager.cancel(issueMain.getId());
		List<AccountRef> accountCodeList = new ArrayList<AccountRef>();
		for(Iterator iterator = phase.getAccountPhaseDets().iterator();iterator.hasNext();)
			accountCodeList.add(((AccountPhaseDet)iterator.next()).getAccountCode());
		accountManager.deletePhase(phase.getId());
		
		for(Iterator iterator = accountCodeList.iterator();iterator.hasNext();)
			accountManager.deleteCode(((AccountRef)iterator.next()).getId());
	}

	/*
	 * Test method for 'tw.gov.nta.debt.account.common.DebtAccountManager.getPhase(Integer)'
	 */
//	public void testGetPhase() {
//
//	}
//
//	/*
//	 * Test method for 'tw.gov.nta.debt.account.common.DebtAccountManager.createPhase(AccountPhaseMain)'
//	 */
//	public void testCreatePhase() {
//
//	}
//
//	/*
//	 * Test method for 'tw.gov.nta.debt.account.common.DebtAccountManager.updatePhase(AccountPhaseMain)'
//	 */
//	public void testUpdatePhase() {
//
//	}
//
//	/*
//	 * Test method for 'tw.gov.nta.debt.account.common.DebtAccountManager.deletePhase(Integer)'
//	 */
//	public void testDeletePhase() {
//
//	}
//
//	/*
//	 * Test method for 'tw.gov.nta.debt.account.common.DebtAccountManager.queryPhase(AccountPhaseMain)'
//	 */
//	public void testQueryPhase() {
//
//	}
//
//	/*
//	 * Test method for 'tw.gov.nta.debt.account.common.DebtAccountManager.getPhaseDet(Integer)'
//	 */
//	public void testGetPhaseDet() {
//
//	}
//
//	/*
//	 * Test method for 'tw.gov.nta.debt.account.common.DebtAccountManager.createPhaseDet(AccountPhaseDet)'
//	 */
//	public void testCreatePhaseDet() {
//
//	}
//
//	/*
//	 * Test method for 'tw.gov.nta.debt.account.common.DebtAccountManager.updatePhaseDet(AccountPhaseDet)'
//	 */
//	public void testUpdatePhaseDet() {
//
//	}
//
//	/*
//	 * Test method for 'tw.gov.nta.debt.account.common.DebtAccountManager.deletePhaseDet(Integer)'
//	 */
//	public void testDeletePhaseDet() {
//
//	}
//
//	/*
//	 * Test method for 'tw.gov.nta.debt.account.common.DebtAccountManager.queryPhaseDet(AccountPhaseDet)'
//	 */
//	public void testQueryPhaseDet() {
//
//	}
//
//	/*
//	 * Test method for 'tw.gov.nta.account.common.AccountManager.makeVouchers(List)'
//	 */
//	public void testMakeVouchers() {
//
//	}
	
	public IssueMain makeNewIssue(String debtType) throws Exception{
		tw.gov.nta.sql.debt.base._BaseRootDAO.initialize();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
//		IssueMain issueMain = new IssueMain();
		IssueMain issueMain = issueManager.createBean(debtType);
		try {
			issueMain.setBudgetCode(1);
			issueMain.setIssueAmount(new BigDecimal(3000000));
			issueMain.setSerialNo("1");
			issueMain.setIssueSerial("1");
			issueMain.setAccountYear(String.valueOf(Calendar.getInstance().get(Calendar.YEAR) - 1911));
			issueMain.setDebtCode(1);
			issueMain.setDebtName("測試公債");
			issueMain.setAverageRate(new BigDecimal(3));	
			issueMain.setIssueDate(dateFormat.parse("2006/10/10"));
			issueMain.setDueDate(dateFormat.parse("2010/10/10"));
			issueMain.setCashDueDate(dateFormat.parse("2015/10/10"));
			issueMain.setIssueKind("0");
			issueMain.setChargeRate(new BigDecimal(0));
			issueMain.setBondSellStatus("0");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			issueManager.confirm(issueMain);
		} catch (Exception e) {
//			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return issueMain;
	}
//	public void testMakeVouchersByIssue(){
//		
//		
//	}

	public void testGenerateVouchersByIssue(){
		try {
			
			issueMain = makeNewIssue("A");
			makeAccountPhase(issueMain.getDebtType());
			List vouchers = accountManager.generateVoucherByIssue(issueMain.getId(),DebtAccountManager.Sell,"Linus",false,new DebtTypeRef(1));
			
			assertEquals(vouchers.size(),1);
//			assertEquals(vouchers.contains("ABC"),true);
//			assertEquals(vouchers.contains("CDE"),true);
//			assertEquals(vouchers.contains("EFG"),true);
			
			for (Iterator mainIterator = vouchers.iterator();mainIterator.hasNext();){
				VoucherMain voucher = (VoucherMain)mainIterator.next();
				//assertEquals(voucher.getVoucherDate(),new Date());
				assertNull(voucher.getPostDate());
				assertNull(voucher.getPostUsr());
				assertFalse(voucher.isDelete());
				assertEquals(voucher.getSourceType(),DebtAccountManager.Issue);
				assertEquals(voucher.getVoucherType(),DebtAccountManager.Sell);
//				assertEquals(voucher.getSourceId(),issueMain.getId());
				assertEquals(voucher.getPhase(),phase);
				
				Set voucherDets = voucher.getVoucherDets();
		
				assertEquals(voucherDets.size(),phase.getAccountPhaseDets().size());
				//assertTrue(voucherDets.containsAll(phase.getAccountPhaseDets()));
				for (Iterator detIterator = voucherDets.iterator();detIterator.hasNext();){
					VoucherDet account = (VoucherDet)detIterator.next();
					assertEquals(account.getAccountAmount(),issueMain.getIssueAmount());
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	/*
	 * Test method for 'tw.gov.nta.account.common.AccountManager.makeVoucher(VoucherBean)'
	 */
//	public void testMakeVoucher() {
//
//	}

private void makeAccountPhase(String debtTypeCode) {
	// TODO Auto-generated method stub
	DebtTypeRefDAO typeDao = new DebtTypeRefDAO();
	Session session = typeDao.createNewSession();
	Query query = session.createQuery("from DebtTypeRef where typeCode =?");
	query.setString(0,debtTypeCode);
	DebtTypeRef debtType= (DebtTypeRef)query.list().get(0);
	
	AccountRef accountCode1 = new AccountRef();
	accountCode1.setAccountCode("C"+debtTypeCode);
	accountCode1.setAccountName(debtType.getTypeName()+"會計試用(借方)");

	accountCode1.setDebtType(debtType);
	accountCode1.setRemark("測試");
	accountCode1.setAccountType("C");

	accountManager.createCode(accountCode1);
	
	AccountRef accountCod2 = new AccountRef();
	accountCod2.setAccountCode("D"+debtTypeCode);
	accountCod2.setAccountName(debtType.getTypeName()+"會計試用(貸方)");
	accountCod2.setDebtType(debtType);
	accountCod2.setRemark("測試");
	accountCod2.setAccountType("D");
	accountManager.createCode(accountCod2);	
	
	this.phase= new AccountPhaseMain();
	phase.setDebtType(debtType);
	phase.setGetTable("IssueMain");
	phase.setIssueKind("0"); //登錄形式 
	phase.setPhaseCode("P"+debtTypeCode);
	phase.setPhaseName(debtType.getTypeName()+"會計階段測試");
	phase.setPhaseShortName(phase.getPhaseName());
	phase.setPhaseType(DebtAccountManager.Sell);
	phase.setGetTable("IssueMain");
	phase.setExecWhen("$issueDate=$issueDate");
	AccountPhaseDet phaseDet1 = new AccountPhaseDet();
	phaseDet1.setAccountPhase(phase);
	phaseDet1.setFormula("issueAmount");
	phaseDet1.setAccountCode(accountCode1);
	
	AccountPhaseDet phaseDet2 = new AccountPhaseDet();
	phaseDet2.setAccountPhase(phase);
	phaseDet2.setFormula("issueAmount");
	phaseDet2.setAccountCode(accountCod2);
	
	phase.addToaccountPhaseDets(phaseDet1);
	phase.addToaccountPhaseDets(phaseDet2);
	
	accountManager.createPhase(phase);
	
	
}

}
