package tw.gov.nta.account.form;

import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.CommonFun;
import gov.dnt.tame.util.DateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.debt.account.common.DebtAccountManager;
import tw.gov.nta.sql.account.AccountRef;
import tw.gov.nta.sql.account.dao.AccountRefDAO;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtTypeRef;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.DebtMainDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;
import tw.gov.nta.surplusage.form.GaraBaseForm;

public class AccountQueryForm extends GaraBaseForm {
	private static final long serialVersionUID = 1L;
	private String accountYear;
	private String month;
	private DebtTypeRef debtType;
	private String issueYear;
	private String issueMonth;
	private int issueId;
	private int debtId;
	private int accountId;
	private int voucherType;
	private Date startIssueDate;
	private Date endIssueDate;
	private Date queryDate;
	private String isPost;
	private String issueKind;
	private String reportType;		//會計月報
	private String isClose;			//是否已結清
	private String sortType;		//排序方式 1：依發行 2.依傳票日期	
	private String voucherNo;
	private String ip;
	private String opening;			//選項：0：一般/1：期初
	private int budgetCode;
	private String startDate;		//開始會計年度
	private String endDate;			//結束會計年度
	
	public int getBudgetCode() {
		return budgetCode;
	}
	public void setBudgetCode(int budgetCode) {
		this.budgetCode = budgetCode;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getVoucherNo() {
		return voucherNo;
	}
	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}
	/**
	 * @return Returns the isPost.
	 */
	public String getIsPost() {
		return isPost;
	}
	/**
	 * @param isPost The isPost to set.
	 */
	public void setIsPost(String isPost) {
		this.isPost = isPost;
	}
	/**
	 * @return Returns the queryDate.
	 */
	public Date getQueryDate() {
		return queryDate;
	}
	/**
	 * @param queryDate The queryDate to set.
	 */
	public void setQueryDate(Date queryDate) {
		this.queryDate = queryDate;
	}
	/**
	 * @return Returns the voucherType.
	 */
	public int getVoucherType() {
		return voucherType;
	}
	/**
	 * @param voucherType The voucherType to set.
	 */
	public void setVoucherType(int voucherType) {
		this.voucherType = voucherType;
	}
	/**
	 * @param accountId The accountId to set.
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	/**
	 * @param issueId The issueId to set.
	 */
	public void setIssueId(int issueId) {
		if (issueId !=0) {
			IssueMain issue = IssueMainDAO.getInstance().get(issueId);
			if(null == getIssueKind() || "".equals(getIssueKind()))
			{	
				setIssueKind(issue.getIssueKind());
			}	
		}
		this.issueId = issueId;
	}
	/**
	 * @param month The month to set.
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		super.reset(mapping, request);
		
		setDebtType(new DebtTypeRef());
		String systemDate = DateUtil.getSystemDate();
		setAccountYear(systemDate.substring(0,3));
		setIssueYear(systemDate.substring(0,3));
		setMonth(systemDate.substring(3,5));
		
	}

	/**
	 * @return Returns the accountYear.
	 */
	
	public String getAccountYear() {
		return accountYear;
	}
	/**
	 * @param accountYear The accountYear to set.
	 */
	public void setAccountYear(String accountYear) {
		if (accountYear.trim().length() ==2)
			accountYear = "0"+accountYear.trim();
		
		this.accountYear = accountYear;
	}
	/**
	 * @return Returns the debtType.
	 */
	public DebtTypeRef getDebtType() {
		return debtType;
	}
	/**
	 * @param debtType The debtType to set.
	 */
	public void setDebtType(DebtTypeRef debtType) {
		this.debtType = debtType;
	}

	/**
	 * 債務名稱 列表
	 */
	public List getIssueList() {
		IssueMainDAO dao = IssueMainDAO.getInstance();
		List issueList = new ArrayList();
/*		if("A".equals(debtType.getTypeCode().trim())) {
			StringBuffer queryString = new StringBuffer();
			queryString.append("from DebtMain debt where debt.issue.debtType = :debtType");
			if (getIssueYear()!=null && !"".equals(getIssueYear())) {
				queryString.append(" and debt.issue.accountYear = :accountYear");
			}else {
				queryString.append(" and 1 = 2");
			}			
			if (getIssueMonth()!=null&&!"".equals(getIssueMonth())) {
				queryString.append(" and exists(select 1 from IssueMain issue where issue.id = debt.issue.sourceIssueId ");
				queryString.append("                  and issue.issueDate between :monthStartDate and :monthEndDate)");
			}
			Query query = dao.getSession().createQuery(queryString.toString());
			
			if (getIssueYear()!=null && !"".equals(getIssueYear())) {
				query.setString("accountYear",getIssueYear());
			}
			if (getIssueMonth()!=null&&!"".equals(getIssueMonth())) {
				Date monthStartDate = DateUtil.str2Date(getIssueYear()+getIssueMonth()+"01");
				Date monthEndDate = DateUtil.getLastDateOfMonth(monthStartDate);
				query.setDate("monthStartDate",monthStartDate);
				query.setDate("monthEndDate",monthEndDate);
			}
			issueList = query.list();
			
		}else { */
			Criteria criteria = dao.getSession().createCriteria(IssueMain.class);
			
			criteria.add(Expression.eq("debtType",getDebtType().getTypeCode().trim()));
			
			if (getIssueYear()!=null && !"".equals(getIssueYear())) {
				criteria.add(Expression.eq("accountYear",getIssueYear()));
			}else {
				return new ArrayList();
			}
			
			if (getIssueMonth()!=null&&!"".equals(getIssueMonth())) {
				Date monthStartDate = DateUtil.str2Date(getIssueYear()+getIssueMonth()+"01");
				Date monthEndDate = DateUtil.getLastDateOfMonth(monthStartDate);
				criteria.add(Expression.ge("issueDate",monthStartDate));
				criteria.add(Expression.le("issueDate",monthEndDate));
			}
			if(!this.debtType.getTypeCode().trim().equals("D"))
				criteria.add(Expression.ne("budgetCode",4));
			else
				criteria.add(Expression.ne("debtCode",25));
			
			//criteria.add(Expression.ne("budgetCode",4));
			criteria.addOrder(Order.asc("accountYear"));
			criteria.addOrder(Order.asc("serialNo"));
			
			issueList = criteria.list();
//		}
		if (issueList.size() > 0 && getIssueId() == 0) {
			setIssueId(((IssueMain)issueList.get(0)).getId());	
		}
		return issueList;
	}

	/**
	 *  列表
	 */
	public List getAllDebtList() {
		Session session = DebtMainDAO.getInstance().getSession();
		StringBuffer queryString = new StringBuffer();
		
		queryString.append("from DebtMain d where d.issue.	debtType = :debtType ");
//		queryString.append(" and d.issue.accountYear = :accountYear and d.budgetCode <> 4");
		//097/5/26 公債會計莊育小姐要求顯示debtCode為4的資料
		queryString.append(" and d.issue.accountYear = :accountYear order by d.issue.accountYear, d.issue.serialNo, d.issue.sourceIssueId  asc");
		//queryString.append(" and d.issue.issueDate between :startIssueDate and :endIssueDate ");
		
		Query query = session.createQuery(queryString.toString());
		
		query.setString("debtType",getDebtType().getTypeCode().trim());
		query.setString("accountYear",getIssueYear());

//		Date startDate = null;
//		Date endDate = null;
//		if(getIssueMonth() == null || "".equals(getIssueMonth())) {
//			startDate = DateUtil.str2Date(getIssueYear()+"0101");
//			endDate = DateUtil.str2Date(getIssueYear()+"1231");
//		}else {
//			startDate = DateUtil.str2Date(getIssueYear()+getIssueMonth()+"01");
//			endDate = DateUtil.str2Date(getLastDate());
//		}
		
		//query.setDate("startIssueDate",startDate);
		//query.setDate("endIssueDate",endDate);

		
		List debtList = query.list();

		return debtList;
	}	
	
	/**
	 * 借款 債務別 列表
	 */
	public List getDebtList() {
		Session session = DebtMainDAO.getInstance().getSession();
		Criteria criteria = session.createCriteria(DebtMain.class);
		criteria.add(Expression.eq("issue.id",getIssueId()));
		List debtList = criteria.list();
		return debtList;
	}	
	
	//會計月報 報表類別
	public List getReportTypeList() throws SQLException, NamingException {
		String debtKind = getDebtType().getTypeCode().trim();
		String sqlStr = "select NAME, PATH from PM0003_DB where path like 'E"+debtKind+"RE%' and path not like '%01'";
		return CommonFun.getList(sqlStr);
	}

	public List getAccountList() {
		AccountRefDAO dao = AccountRefDAO.getInstance();
		Criteria criteria = dao.getSession().createCriteria(AccountRef.class);
		criteria.add(Expression.eq("debtType",getDebtType()));
		return criteria.list();
	}

	/**
	 * @return Returns the issueYear.
	 */
	public String getIssueYear() {
		return issueYear;
	}
	/**
	 * @param issueYear The issueYear to set.
	 */
	public void setIssueYear(String issueYear) {
		if(issueYear.trim().length() == 2) 
			this.issueYear = "0" + issueYear;
		else
			this.issueYear = issueYear;
	}

	public Map getPhaseTypes() {
		Map<String,String> phaseMap = new TreeMap<String,String>();

		if ("A".equals(getDebtType().getType())) {
			phaseMap.put(DebtAccountManager.Pay.toString(),"經付類");
			phaseMap.put(DebtAccountManager.Sell.toString(),"經售類");
		}else {
			phaseMap.put(DebtAccountManager.Pay.toString(),"償付類");
			phaseMap.put(DebtAccountManager.Sell.toString(),"舉借類");
		}
		
		return phaseMap;
	}
	/**
	 * @return Returns the accountId.
	 */
	public int getAccountId() {
		return accountId;
	}
	/**
	 * @return Returns the issueId.
	 */
	public int getIssueId() {
		return issueId;
	}
	/**
	 * @return Returns the month.
	 */
	public String getMonth() {
		return month;
	}
	
	public List<Integer> getMonthsOfYear(){
		List<Integer> months = new ArrayList<Integer>();
		
		for (int i=1;i<=12;i++) {
			months.add(i);
		}
		
		return  months;
	}
	/**
	 * @return Returns the endIssueDate.
	 */
	public Date getEndIssueDate() {
		return endIssueDate;
	}
	/**
	 * @param endIssueDate The endIssueDate to set.
	 */
	public void setEndIssueDate(Date endIssueDate) {
		this.endIssueDate = endIssueDate;
	}
	/**
	 * @return Returns the startIssueDate.
	 */
	public Date getStartIssueDate() {
		return startIssueDate;
	}
	/**
	 * @param startIssueDate The startIssueDate to set.
	 */
	public void setStartIssueDate(Date startIssueDate) {
		this.startIssueDate = startIssueDate;
	}
	/**
	 * @return Returns the issueMonth.
	 */
	public String getIssueMonth() {
		return issueMonth;
	}
	/**
	 * @param issueMonth The issueMonth to set.
	 */
	public void setIssueMonth(String issueMonth) {
		this.issueMonth = issueMonth;
	}

	public String getSQLAccountYear() {
		return String.valueOf(Integer.parseInt(getAccountYear())+1911);
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	/**
	 * 取得會計月份的最後一天(日期) 
	 * 如果沒有指定月份，則傳回12/31
	 * ex:094.1   return "0940131"
	 * ex:094     return "0941231"
	 * @return
	 */	
	public String getLastDate() {
		String year = getAccountYear();
		String month = getMonth();
		if ("".equals(month) || month == null)
			month = "12";
		
		return DateUtil.getLastDateOfMonth(year,month);
	}
	
	/**
	 * 取得該年度最後一天yyymmdd
	 * 因為可能會在getLastDate判斷是否為假日，所以不直接傳1231
	 * @return
	 */
	public String getYearLastDate() {
		setMonth("");
		return getLastDate();
	}

	/**
	 * 取得該年度最後一天(SQL用)yyyymmdd
	 * 因為可能會在getSQLLastDate判斷是否為假日，所以不直接傳1231
	 * @return
	 */
	public String getSQLYearLastDate() {
		setMonth("");
		return getSQLLastDate();
	}	
	
	/**
	 * 取得會計月份的最後一天(日期) 供SQL用
	 * ex.094.12   return 2005/12/31
	 * @return
	 */
	public String getSQLLastDate() {	
		String ROCDate = getLastDate();
		return getSQLAccountYear() + "/" + ROCDate.substring(3,5) +"/" + ROCDate.substring(5,7);

	}
	
	/**
	 * 取得會計月份的最後一天
	 * ex.94.12  return "30"
	 * @return
	 */
	public String getLastDay() {
		return getLastDate().substring(5,7);
	}
	/**
	 * @return Returns the debtId.
	 */
	public int getDebtId() {
		if (debtId == 0) {
			Session session = DebtMainDAO.getInstance().getSession();
			Criteria criteria = session.createCriteria(DebtMain.class);
			criteria.add(Expression.eq("issue.id",getIssueId()));
			List debtList = criteria.list();
			if (debtList != null && debtList.size()!=0) {
				int tempDebtId = ((DebtMain)debtList.get(0)).getId();
				if (tempDebtId != 0) {
					setDebtId(tempDebtId);
				}
			}
			
		}
		return debtId;
	}
	/**
	 * @param debtId The debtId to set.
	 */
	public void setDebtId(int debtId) {
		if (debtId !=0) {
			DebtMain debt = DebtMainDAO.getInstance().get(debtId);
			if(issueId ==0) {
				IssueMain issue = debt.getIssue();
				setIssueId(issue.getId());
			}
		}
		this.debtId = debtId;
	}
	/**取得報表類別 0=>登錄形式
	 *            1=>債票形式
	 * @return Returns the issueKind.
	 */
	public String getIssueKind() {
		return issueKind;
	}
	/**設計報表類別 0=>登錄形式
	 *            1=>債票形式
	 * @param issueKind The issueKind to set.
	 */
	public void setIssueKind(String issueKind) {
		this.issueKind = issueKind;
	}
	/**
	 * @return Returns the isClose.
	 */
	public String getIsClose() {
		return isClose;
	}
	/**
	 * @param isClose The isClose to set.
	 */
	public void setIsClose(String isClose) {
		this.isClose = isClose;
	}
	/**
	 * @return Returns the sortType.
	 */
	public String getSortType() {
		return sortType;
	}
	/**
	 * @param sortType The sortType to set.
	 */
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	public String getOpening() {
		return opening;
	}
	public void setOpening(String opening) {
		this.opening = opening;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
}
