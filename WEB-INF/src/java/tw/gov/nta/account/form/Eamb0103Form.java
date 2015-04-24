package tw.gov.nta.account.form;

import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.DateUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.debt.account.common.DebtAccountManager;
import tw.gov.nta.sql.account.VoucherDet;
import tw.gov.nta.sql.account.VoucherMain;
import tw.gov.nta.sql.dao.DebitRefDAO;
import tw.gov.nta.sql.debt.DebtTypeRef;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.account.AccountPhaseMain;

public class Eamb0103Form extends SupportForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VoucherMain voucherMain = new VoucherMain();
	private int phaseId = 0;
	private String issueKind = "";
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

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#getId()
	 */
	public Integer getId() {
		return voucherMain.getId();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#getModDate()
	 */
	public Date getModDate() {
		return voucherMain.getModDate();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#getPhase()
	 */
	public AccountPhaseMain getPhase() {
		return voucherMain.getPhase();
	}


	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#getSourceType()
	 */
	public String getSourceType() {
		return voucherMain.getSourceType();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#getUsrid()
	 */
	public String getUsrid() {
		return voucherMain.getUsrid();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#getVoucherDate()
	 */
	public Date getVoucherDate() {
		return voucherMain.getVoucherDate();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#getVoucherDets()
	 */
	public Set<VoucherDet> getVoucherDets() {
		return voucherMain.getVoucherDets();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#getVoucherNo()
	 */
	public String getVoucherNo() {
		return voucherMain.getVoucherNo();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#getVoucherType()
	 */
	public Integer getVoucherType() {
		return voucherMain.getVoucherType();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#isDelete()
	 */
	public boolean isDelete() {
		return voucherMain.isDelete();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#isUsered()
	 */
	public String getUsered() {
		if (voucherMain.getPostDate() != null)
			return "是";
		else
			return "否";
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#setDelete(boolean)
	 */
	public void setDelete(boolean delete) {
		voucherMain.setDelete(delete);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#setId(java.lang.Integer)
	 */
	public void setId(Integer id) {
		voucherMain.setId(id);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#setModDate(java.util.Date)
	 */
	public void setModDate(Date modDate) {
		voucherMain.setModDate(modDate);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#setPhase(tw.gov.nta.sql.debt.account.AccountPhaseMain)
	 */
	public void setPhase(AccountPhaseMain phase) {
		voucherMain.setPhase(phase);
	}


	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#setSourceType(java.lang.String)
	 */
	public void setSourceType(String sourceType) {
		voucherMain.setSourceType(sourceType);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#getDebtType()
	 */
	public DebtTypeRef getDebtType() {
		return voucherMain.getDebtType();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#getIssueId()
	 */
	public Integer getIssueId() {
		return issueMain.getId();
	}


	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#getVoucherSer()
	 */
	public Integer getVoucherSer() {
		return voucherMain.getVoucherSer();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#setIssueId(java.lang.Integer)
	 */
	public void setIssueId(Integer issueId) {
		voucherMain.setIssueId(issueId);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#setVoucherSer(java.lang.Integer)
	 */
	public void setVoucherSer(Integer voucherSer) {
		voucherMain.setVoucherSer(voucherSer);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#setUsrid(java.lang.String)
	 */
	public void setUsrid(String usrid) {
		voucherMain.setUsrid(usrid);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#setVoucherDate(java.util.Date)
	 */
	public void setVoucherDate(Date voucherDate) {
		voucherMain.setVoucherDate(voucherDate);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#setVoucherDets(java.util.Set)
	 */
	public void setVoucherDets(Set<VoucherDet> voucherDets) {
		voucherMain.setVoucherDets(voucherDets);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#setVoucherNo(java.lang.String)
	 */
	public void setVoucherNo(String voucherNo) {
		voucherMain.setVoucherNo(voucherNo);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#setVoucherType(java.lang.String)
	 */
	public void setVoucherType(Integer voucherType) {
		voucherMain.setVoucherType(voucherType);
	}

	/**
	 * @return Returns the voucherMain.
	 */
	public VoucherMain getVoucherMain() {
		return voucherMain;
	}

	/**
	 * @param voucherMain The voucherMain to set.
	 */
	public void setVoucherMain(VoucherMain voucherMain) {
		this.voucherMain = voucherMain;
	}	
	
	public Map getPhaseTypes() {
		Map<String,String> phaseMap = new TreeMap<String,String>();
		String debtKind;
//		Session session =  IssueMainDAO.getInstance().createNewSession();
//		int debtTypeId = getVoucher().getDebtType();
//		debtKind = ((DebtTypeRef)session.load(DebtTypeRef.class,debtTypeId)).getType(); 
		debtKind = getIssueMain().getDebtType();
		if (debtKind.trim().matches("[AB]")) {
			phaseMap.put(DebtAccountManager.Sell.toString(),"經售類");
			phaseMap.put(DebtAccountManager.Pay.toString(),"經付類");
			phaseMap.put(DebtAccountManager.Charge.toString(),"手續費撥付");
			if("A".equals(debtKind.trim())){
				phaseMap.put(DebtAccountManager.PayCharge.toString(),"手續費償付");
			}	
		}else {
			phaseMap.put(DebtAccountManager.Sell.toString(),"舉借類");
			phaseMap.put(DebtAccountManager.Pay.toString(),"償付類");
		}
		
		return phaseMap;
	}

	public List getDebtCodeList() {
		Integer issueId = getIssueId();
		StringBuffer queryString = new StringBuffer();
		queryString.append("from DebitRef debitRef where debitRef.id <> 35 and exists ");
		queryString.append(" (select 1 from  DebtMain debt where debt.debtCode = debitRef.id and debt.issue.id = ?)");
		Session session = DebitRefDAO.getInstance().getSession();
		Query query = session.createQuery(queryString.toString());
		query.setParameter(0,issueId);
		
		return query.list();
	}	

	public List getPhaseList() {
		StringBuffer queryString = new StringBuffer();
		queryString.append("from AccountPhaseMain phase where phase.debtType.id = ? ");
		if(getVoucherType()!=null) {
			queryString.append(" and phase.phaseType = ?");
		}
		
		Session session = DebitRefDAO.getInstance().getSession();
//		Criteria criteria = session.createCriteria(AccountPhaseMain.class);
		Query query = session.createQuery(queryString.toString());
		
		int debtTypeId = 0;
		if (getDebtType() == null) {
			String debtTypeCode = issueMain.getDebtType().trim();
			if("A".equals(debtTypeCode)) {
				debtTypeId = 1;
			}else if("B".equals(debtTypeCode)) {
				debtTypeId = 2;
			}else if("C".equals(debtTypeCode)) {
				debtTypeId = 3;
			}else if("D".equals(debtTypeCode)) {
				debtTypeId = 4;
			}
		}else {
			debtTypeId = getDebtType().getId();
		}
		
		query.setParameter(0,debtTypeId);
		if(getVoucherType()!=null) {
			query.setParameter(1,getVoucherType());
		}
		List phaseList = query.list();
		return phaseList;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		setVoucherDate(new Date());
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#getPostDate()
	 */
	public Date getPostDate() {
		return voucherMain.getPostDate();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#getPostUsr()
	 */
	public String getPostUsr() {
		return voucherMain.getPostUsr();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#setDebtType(tw.gov.nta.sql.debt.DebtTypeRef)
	 */
	public void setDebtType(DebtTypeRef debtType) {
		voucherMain.setDebtType(debtType);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#setPostDate(java.util.Date)
	 */
	public void setPostDate(Date postDate) {
		voucherMain.setPostDate(postDate);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#setPostUsr(java.lang.String)
	 */
	public void setPostUsr(String postUsr) {
		voucherMain.setPostUsr(postUsr);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#getRemark()
	 */
	public String getRemark() {
		return voucherMain.getRemark();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#setRemark(java.lang.String)
	 */
	public void setRemark(String remark) {
		voucherMain.setRemark(remark);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#getBudgetCode()
	 */
	public Integer getBudgetCode() {
		return voucherMain.getBudgetCode();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#getDebtCode()
	 */
	public Integer getDebtCode() {
		return voucherMain.getDebtCode();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#setBudgetCode(java.lang.Integer)
	 */
	public void setBudgetCode(Integer budgetCode) {
		voucherMain.setBudgetCode(budgetCode);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.account.base.BaseVoucherMain#setDebtCode(java.lang.Integer)
	 */
	public void setDebtCode(Integer debtCode) {
		voucherMain.setDebtCode(debtCode);
	}


	/**
	 * @return Returns the phaseId.
	 */
	public int getPhaseId() {
		return phaseId;
	}

	/**
	 * @param phaseId The phaseId to set.
	 */
	public void setPhaseId(int phaseId) {
		this.phaseId = phaseId;
	}


	/**
	 * @return Returns the makeDate.
	 */
	public String getMakeDate() {
		return DateUtil.date2ROCStr(getVoucherDate());
	}

	/**
	 * @return Returns the issueKind.
	 */
	public String getIssueKind() {
		return issueKind;
	}

	/**
	 * @param issueKind The issueKind to set.
	 */
	public void setIssueKind(String issueKind) {
		this.issueKind = issueKind;
	}

	
}
