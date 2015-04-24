/* Eama0201Form.java
程式目的：EAMA02
程式代號：EAMA02
程式日期：0950306
程式作者：Linus.Tseng
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.account.form;

import gov.dnt.tame.common.SupportForm;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.sql.account.AccountRef;
import tw.gov.nta.sql.account.dao.AccountRefDAO;
import tw.gov.nta.sql.debt.DebtTypeRef;
import tw.gov.nta.sql.debt.account.AccountPhaseDet;
import tw.gov.nta.sql.debt.account.AccountPhaseMain;

public class Eama0202Form extends SupportForm {
	private static final long serialVersionUID = 1L;

		private AccountPhaseDet phaseDet = new AccountPhaseDet();
		public Eama0202Form(){
			AccountPhaseMain accountPhaseMain = new AccountPhaseMain();
			AccountRef accountRef = new AccountRef();
			DebtTypeRef debtType = new DebtTypeRef();
			accountPhaseMain.setDebtType(debtType);
			accountRef.setDebtType(debtType);
			setAccountRef(accountRef);
			setAccountPhase(accountPhaseMain);
		}
		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseDet#getAccountCode()
		 */
		public AccountRef getAccountRef() {
			AccountRef ref = phaseDet.getAccountCode();
			if (ref.getId() == null)
				return ref;
			else
				return AccountRefDAO.getInstance().get(ref.getId());
		}

		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseDet#getAccountPhase()
		 */
		public AccountPhaseMain getAccountPhase() {
			return phaseDet.getAccountPhase();
		}

		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseDet#getId()
		 */
		public Integer getId() {
			return phaseDet.getId();
		}

		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseDet#setAccountCode(tw.gov.nta.sql.account.AccountRef)
		 */
		public void setAccountRef(AccountRef accountCode) {
			phaseDet.setAccountCode(accountCode);
		}

		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseDet#setAccountPhase(tw.gov.nta.sql.debt.account.AccountPhaseMain)
		 */
		public void setAccountPhase(AccountPhaseMain accountPhase) {
			phaseDet.setAccountPhase(accountPhase);
		}


		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseDet#setId(java.lang.Integer)
		 */
		public void setId(Integer id) {
			phaseDet.setId(id);
		}

		/**
		 * @return Returns the phaseDet.
		 */
		public AccountPhaseDet getPhaseDet() {
			return phaseDet;
		}
		/**
		 * @param phaseDet The phaseDet to set.
		 */
		public void setPhaseDet(AccountPhaseDet phaseDet) {
			this.phaseDet = phaseDet;
		}
		
		public List getAllAccountRef(){
			AccountRefDAO dao = new AccountRefDAO();
			Criteria criteria = dao.getSession().createCriteria(AccountRef.class);
			criteria.add(Expression.eq("debtType",getDebtType()));
			criteria.addOrder(Order.desc("accountCode"));
			return criteria.list();
		}

		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.account.base.BaseAccountRef#getAccountName()
		 */
		public String getAccountName() {
			return phaseDet.getAccountCode().getAccountName();
		}
		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.account.base.BaseAccountRef#getAccountType()
		 */
		public String getAccountType() {
			return phaseDet.getAccountType();			
		}
		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.account.base.BaseAccountRef#getRemark()
		 */
		public String getRemark() {
			return phaseDet.getAccountCode().getRemark();
		}

		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseDet#getAccountCodeId()
		 */
		
		public void setDebtType(DebtTypeRef debtType) {
			AccountPhaseMain phase = getAccountPhase();
			phase.setDebtType(debtType);
		}
		
		public DebtTypeRef getDebtType() {
			AccountPhaseMain phase = getAccountPhase();
			return phase.getDebtType();
		}
		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseDet#getAccountCode()
		 */
		public AccountRef getAccountCode() {
			return phaseDet.getAccountCode();
		}
		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseDet#getFormula()
		 */
		public String getFormula() {
			return phaseDet.getFormula();
		}
		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseDet#setAccountCode(tw.gov.nta.sql.account.AccountRef)
		 */
		public void setAccountCode(AccountRef accountCode) {
			phaseDet.setAccountCode(accountCode);
		}
		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseDet#setFormula(java.lang.String)
		 */
		public void setFormula(String formula) {
			phaseDet.setFormula(formula);
		}
		
		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseDet#setAccountType(java.lang.String)
		 */
		public void setAccountType(String accountType) {
			phaseDet.setAccountType(accountType);
		}
}
