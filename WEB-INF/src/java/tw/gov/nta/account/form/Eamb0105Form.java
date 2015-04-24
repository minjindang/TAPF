package tw.gov.nta.account.form;

import java.math.BigDecimal;

import gov.dnt.tame.common.SupportForm;
import tw.gov.nta.sql.account.AccountRef;
import tw.gov.nta.sql.account.VoucherDet;
import tw.gov.nta.sql.account.VoucherMain;

public class Eamb0105Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	private VoucherDet voucherDet = new VoucherDet();
	private VoucherMain voucher = new VoucherMain();
	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherDet#getAccount()
	 */
	public AccountRef getAccount() {
		return voucherDet.getAccount();
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
	 * @see tw.gov.nta.sql.account.base.BaseVoucherDet#setVoucher(tw.gov.nta.sql.account.VoucherMain)
	 */
	public void setVoucher(VoucherMain voucher) {
		voucherDet.setVoucher(voucher);
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

	public String getAccountType() {
		String accountType = getAccount().getAccountType();
		if ("D".equals(accountType))
			return "­É";
		else
			return "¶U";
	}
}
