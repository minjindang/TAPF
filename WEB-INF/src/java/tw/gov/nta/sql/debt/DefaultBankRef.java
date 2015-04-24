package tw.gov.nta.sql.debt;

public class DefaultBankRef extends BankRef {
	private static final long serialVersionUID = 1L;

	public void addTodebtMains (tw.gov.nta.sql.debt.DebtMain debtMain) {
		if (null == getDebtMains()) setDebtMains(new java.util.TreeSet<tw.gov.nta.sql.debt.DebtMain>());
		getDebtMains().add(debtMain);
	}

	public void addTocontractBankMains (tw.gov.nta.sql.debt.ContractBankMain contractBankMain) {
		if (null == getContractBankMains()) setContractBankMains(new java.util.TreeSet<tw.gov.nta.sql.debt.ContractBankMain>());
		getContractBankMains().add(contractBankMain);
	}
}
