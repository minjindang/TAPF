package tw.gov.nta.account.form;

import gov.dnt.tame.common.SupportForm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import tw.gov.nta.sql.account.AccountRef;
import tw.gov.nta.sql.account.VoucherDet;
import tw.gov.nta.sql.account.VoucherMain;
import tw.gov.nta.sql.account.dao.AccountRefDAO;
import tw.gov.nta.sql.debt.DebtTypeRef;
import tw.gov.nta.sql.debt.IssueMain;

public class Eamb0104Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	private VoucherDet voucherDet = new VoucherDet();
	private AccountRefDAO refDao = AccountRefDAO.getInstance();
	private VoucherMain voucher = new VoucherMain();
	private IssueMain issueMain = new IssueMain();
	
	/**
	 * @return Returns the issueMain.
	 */
	public IssueMain getIssueMain() {
		return issueMain;
	}

	/**
	 * @param issueMain The issueMain to set.
	 */
	public void setIssueMain(IssueMain issueMain) {
		this.issueMain = issueMain;
	}

	public Eamb0104Form(){
		AccountRef accountRef = new AccountRef();
		accountRef.setDebtType(new DebtTypeRef());
		setAccount(accountRef);
		setVoucher(voucher);
	}

	public List getAllAccountCode() {
		Session session = refDao.createNewSession();
		Criteria criteria = session.createCriteria(AccountRef.class);
		criteria.add(Expression.eq("debtType",getAccount().getDebtType()));
		List accountList =  criteria.list();
		if (accountList == null)
			accountList = new ArrayList();
		session.close();
		return accountList;
	}
	/**
	 * @return Returns the voucherDet.
	 */
	public VoucherDet getVoucherDet() {
		return voucherDet;
	}
	/**
	 * @param voucherDet The voucherDet to set.
	 */
	public void setVoucherDet(VoucherDet voucherDet) {
		this.voucherDet = voucherDet;
	}
	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherDet#getAccount()
	 */
	public AccountRef getAccount() {
		AccountRef accountRef = voucherDet.getAccount();
	    if (accountRef.getAccountCode()==null) {
	    	if (accountRef.getId()!=null && accountRef.getId() != 0) {
		    	Session session = AccountRefDAO.getInstance().createNewSession();
		    	accountRef = (AccountRef)session.load(AccountRef.class,accountRef.getId());
		    	session.close(); 
		    	voucherDet.setAccount(accountRef);
	    	}
	    }   
	    return accountRef;
	}
	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherDet#getVoucher()
	 */
	public VoucherMain getVoucher() {
		return voucherDet.getVoucher();
	}
	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherDet#setAccount(tw.gov.nta.sql.account.AccountRef)
	 */
	public void setAccount(AccountRef account) {
		voucherDet.setAccount(account);
	}
	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherDet#setVoucher(tw.gov.nta.sql.account.VoucherMain)
	 */
	public void setVoucher(VoucherMain voucher) {
		voucherDet.setVoucher(voucher);
	}	
	/**
	 * @return Returns the voucherDate.
	 */
	public Date getVoucherDate() {
		return getVoucher().getVoucherDate();
	}
	/**
	 * @param voucherDate The voucherDate to set.
	 */
	public void setVoucherDate(Date voucherDate) {
		getVoucher().setVoucherDate(voucherDate);
	}
	/**
	 * @return Returns the voucherType.
	 */
	public Integer getVoucherType() {
		return getVoucher().getVoucherType();
	}
	/**
	 * @param voucherType The voucherType to set.
	 */
	public void setVoucherType(int voucherType) {
		getVoucher().setVoucherType(voucherType);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherDet#getAccountAmount()
	 */
	public BigDecimal getAccountAmount() {
		return voucherDet.getAccountAmount();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherDet#getId()
	 */
	public Integer getId() {
		return voucherDet.getId();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherDet#setAccountAmount(java.math.BigDecimal)
	 */
	public void setAccountAmount(BigDecimal accountAmount) {
		voucherDet.setAccountAmount(accountAmount);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherDet#setId(java.lang.Integer)
	 */
	public void setId(Integer id) {
		voucherDet.setId(id);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherDet#setAccountType(java.lang.String)
	 */
	public void setAccountType(String accountType) {
		voucherDet.setAccountType(accountType);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherDet#getAccountType()
	 */
	public String getAccountType() {
		return voucherDet.getAccountType();
	}
}
