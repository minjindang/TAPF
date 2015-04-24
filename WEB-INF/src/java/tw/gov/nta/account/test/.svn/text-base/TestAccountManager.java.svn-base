package tw.gov.nta.account.test;

import java.util.Date;

import junit.framework.TestCase;
import tw.gov.nta.account.common.AccountException;
import tw.gov.nta.account.common.AccountManager;
import tw.gov.nta.debt.account.common.DebtAccountManager;
import tw.gov.nta.sql.account.VoucherMain;
import tw.gov.nta.sql.account.dao.VoucherMainDAO;

public class TestAccountManager extends TestCase {
	private AccountManager manager = new AccountManager();
	private VoucherMainDAO dao = new VoucherMainDAO();
	private VoucherMain voucher;
	private int id = 9999;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		dao.initialize();
		voucher = makeVoucher();
		dao.save(voucher);
	}


	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}

	public VoucherMain makeVoucher() {
		VoucherMain newVoucher = new VoucherMain();
		id = id + 1;
		System.out.print("id" + id);
		newVoucher.setVoucherDate(new Date());
		newVoucher.setVoucherNo("ABCDE");
		newVoucher.setModDate(new Date());
		newVoucher.setSourceType(DebtAccountManager.Issue);
//		newVoucher.setSourceId(1);
		newVoucher.setUsrid("SA");
		newVoucher.setVoucherType(DebtAccountManager.Sell);
		return newVoucher;
	}
	public void testCancelVoucher() {
		int vid = voucher.getId();
		try {
			manager.cancelVoucher(vid);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		VoucherMain getVoucher = null;
		getVoucher = manager.getVoucher(vid);

		assertNull(getVoucher);
	}
}
