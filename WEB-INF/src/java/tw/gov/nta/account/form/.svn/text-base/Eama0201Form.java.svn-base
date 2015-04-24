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
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import tw.gov.nta.debt.account.common.DebtAccountManager;
import tw.gov.nta.debt.account.common.DebtVoucherFactory;
import tw.gov.nta.sql.debt.DebtTypeRef;
import tw.gov.nta.sql.debt.account.AccountPhaseDet;
import tw.gov.nta.sql.debt.account.AccountPhaseMain;
import tw.gov.nta.sql.debt.account.dao.AccountPhaseMainDAO;

public class Eama0201Form extends SupportForm {
	private static final long serialVersionUID = 1L;
	
	private AccountPhaseMain accountPhase = new AccountPhaseMain();
	private DebtTypeRef debtType = new DebtTypeRef();

		/* (non-Javadoc)
		 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
		 */
		@Override
		public void reset(ActionMapping mapping, HttpServletRequest request) {
			// TODO Auto-generated method stub
			setDebtType(debtType);
			setPhaseCode("");
			setPhaseName("");
			setPhaseShortName("");
			setPhaseType(null);
			super.reset(mapping, request);

		}



		/**
		 * @return Returns the accountPhase.
		 */
		

		public AccountPhaseMain getAccountPhase() {
			return accountPhase;
		}

		/**
		 * @param accountPhase The accountPhase to set.
		 */
		public void setAccountPhase(AccountPhaseMain accountPhase) {
			this.accountPhase = accountPhase;
		}

		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#addToaccountPhaseDets(tw.gov.nta.sql.debt.account.AccountPhaseDet)
		 */
		public void addToaccountPhaseDets(AccountPhaseDet accountPhaseDet) {
			accountPhase.addToaccountPhaseDets(accountPhaseDet);
		}



		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#getAccountPhaseDets()
		 */
		public Set<AccountPhaseDet> getAccountPhaseDets() {
			return accountPhase.getAccountPhaseDets();
		}

		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#getId()
		 */
		public Integer getId() {
			return accountPhase.getId();
		}


		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#getPhaseCode()
		 */
		public String getPhaseCode() {
			return accountPhase.getPhaseCode();
		}

		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#getPhaseName()
		 */
		public String getPhaseName() {
			return accountPhase.getPhaseName();
		}

		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#getPhaseShortName()
		 */
		public String getPhaseShortName() {
			return accountPhase.getPhaseShortName();
		}

		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#setAccountPhaseDets(java.util.Set)
		 */
		public void setAccountPhaseDets(Set<AccountPhaseDet> accountPhaseDets) {
			accountPhase.setAccountPhaseDets(accountPhaseDets);
		}

		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#setId(java.lang.Integer)
		 */
		public void setId(Integer id) {
			accountPhase.setId(id);
		}


		public void setPhaseCode(String phaseCode) {
			accountPhase.setPhaseCode(phaseCode);
		}

		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#setPhaseName(java.lang.String)
		 */
		public void setPhaseName(String phaseName) {
			accountPhase.setPhaseName(phaseName);
		}

		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#setPhaseShortName(java.lang.String)
		 */
		public void setPhaseShortName(String phaseShortName) {
			accountPhase.setPhaseShortName(phaseShortName);
		}


		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#getDebtType()
		 */
		public DebtTypeRef getDebtType() {
			return accountPhase.getDebtType();
		}

		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#setDebtType(tw.gov.nta.sql.debt.DebtTypeRef)
		 */
		public void setDebtType(DebtTypeRef debtType) {
			accountPhase.setDebtType(debtType);
		}



		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#compareTo(java.lang.Object)
		 */
		public int compareTo(Object obj) {
			return accountPhase.compareTo(obj);
		}


		public List getAllDebtTypes(){
			tw.gov.nta.sql.debt.dao.DebtTypeRefDAO dao = new tw.gov.nta.sql.debt.dao.DebtTypeRefDAO();
			return dao.findAll();
		}
		
		public List getOtherAccountPhases(){
			AccountPhaseMainDAO dao = new AccountPhaseMainDAO();
			List list = dao.findAll();
			list.remove(getAccountPhase());
			return list;
		}



		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#getIssueKind()
		 */
		public String getIssueKind() {
			return accountPhase.getIssueKind();
		}



		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#getPhaseType()
		 */
		public Integer getPhaseType() {
			return accountPhase.getPhaseType();
		}



		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#setIssueKind(java.lang.String)
		 */
		public void setIssueKind(String issueKind) {
			accountPhase.setIssueKind(issueKind);
		}



		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#setPhaseType(java.lang.Integer)
		 */
		public void setPhaseType(Integer phaseType) {
			accountPhase.setPhaseType(phaseType);
		}

		public Map getPhaseTypes() {
			Map<String,String> phaseMap = new TreeMap<String,String>();
			int debtKind;
			debtKind = getDebtType().getId();
			if (debtKind == 1 || debtKind == 2) {
				if(1 == debtKind){
					phaseMap.put(DebtAccountManager.PayCharge.toString(),"手續費償付");
				}	
				phaseMap.put(DebtAccountManager.Charge.toString(),"手續費經付");
				phaseMap.put(DebtAccountManager.Pay.toString(),"經付類");
				phaseMap.put(DebtAccountManager.Sell.toString(),"經售類");
			}else {
				phaseMap.put(DebtAccountManager.Pay.toString(),"償付類");
				phaseMap.put(DebtAccountManager.Sell.toString(),"舉借類");
			}
			
			return phaseMap;
		}



		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#getExecWhen()
		 */
		public String getExecWhen() {
			return accountPhase.getExecWhen();
		}



		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#getGetTable()
		 */
		public String getGetTable() {
			return accountPhase.getGetTable();
		}



		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#setExecWhen(java.lang.String)
		 */
		public void setExecWhen(String execWhen) {
			accountPhase.setExecWhen(execWhen);
		}



		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#setGetTable(java.lang.String)
		 */
		public void setGetTable(String getTable) {
			accountPhase.setGetTable(getTable);
		}



		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#getPhaseSerial()
		 */
		public Integer getPhaseSerial() {
			return accountPhase.getPhaseSerial();
		}



		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#getVoucherDateRule()
		 */
		public Integer getVoucherDateRule() {
			return accountPhase.getVoucherDateRule();
		}

		public Map getDateRules() {
			Map<Integer,String> ruleMap = new TreeMap<Integer,String>();
			ruleMap.put(DebtVoucherFactory.VoucherDateIssueDay,"發行日");
			ruleMap.put(DebtVoucherFactory.VoucherDateSourceMakeDay,"付款日期");
			ruleMap.put(DebtVoucherFactory.VoucherDateMonthFirstDay,"當月初");
			ruleMap.put(DebtVoucherFactory.VoucherDateMonthLastDay,"當月底");
			ruleMap.put(DebtVoucherFactory.VoucherDateDueDay,"到期日");
			ruleMap.put(DebtVoucherFactory.VoucherDateCashDueDay,"截止兌付日");
	
			return ruleMap;
		}		


		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#setPhaseSerial(java.lang.Integer)
		 */
		public void setPhaseSerial(Integer phaseSerial) {
			accountPhase.setPhaseSerial(phaseSerial);
		}



		/* (non-Javadoc)
		 * @see tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain#setVoucherDateRule(java.lang.Integer)
		 */
		public void setVoucherDateRule(Integer voucherDateRule) {
			accountPhase.setVoucherDateRule(voucherDateRule);
		}

}
