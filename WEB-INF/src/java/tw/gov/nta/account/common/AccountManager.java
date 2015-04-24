package tw.gov.nta.account.common;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.ReportManager;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.sql.account.AccountRef;
import tw.gov.nta.sql.account.VoucherDet;
import tw.gov.nta.sql.account.VoucherMain;
import tw.gov.nta.sql.account.dao.AccountRefDAO;
import tw.gov.nta.sql.account.dao.VoucherMainDAO;
import tw.gov.nta.sql.debt.DebtTypeRef;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;


public class AccountManager {
	 
	private VoucherMainDAO voucherDao = VoucherMainDAO.getInstance();
	
	private AccountRefDAO refDao = AccountRefDAO.getInstance();
	
	private Calendar calendar = Calendar.getInstance();
	
	public void makeVouchers(List voucherList) throws Exception {
		Session session = voucherDao.getSession();
		Transaction tx = session.beginTransaction();
		try {
			for(Iterator iterator=voucherList.iterator();iterator.hasNext();) {
				makeVoucher((VoucherMain)iterator.next(),session);
			}
			tx.commit();
		}catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}
	}

	public void makeVouchers(List voucherList,Session session) throws Exception {
		for(Iterator iterator=voucherList.iterator();iterator.hasNext();)
			makeVoucher((VoucherMain)iterator.next(),session);
	}
	

	public void makeVoucher(VoucherMain voucher,Session session) throws Exception{
		// checkVoucher(voucher,session);
		setVoucherNo(voucher,session);
		for(Iterator iterator = voucher.getVoucherDets().iterator();iterator.hasNext();) {
			((VoucherDet)iterator.next()).setVoucher(voucher);
		}
		session.saveOrUpdate(voucher);

	}
	
	protected void setVoucherNo(VoucherMain voucher)  throws Exception {
		// TODO Auto-generated method stub
		
	}

	protected void setVoucherNo(VoucherMain voucher,Session session)  throws Exception {
		// TODO Auto-generated method stub
		
	}	

	protected void checkVoucher(VoucherMain voucher) throws Exception {
		double balance = 0;
		for(Iterator iterator=voucher.getVoucherDets().iterator();iterator.hasNext();) {
			VoucherDet voucherDet = (VoucherDet)iterator.next();
			if ("C".equals(voucherDet.getAccountType()))
				balance = balance + voucherDet.getAccountAmount().doubleValue();
			else
				balance = balance - voucherDet.getAccountAmount().doubleValue();
		}
		if (Math.round(balance) != 0.0) {
			int issueId = voucher.getIssueId();
			IssueMainDAO issueDao = IssueMainDAO.getInstance();
			IssueMain issue = issueDao.get(issueId);
			throw new AccountException("編號："+issue.getIssueSerial()+"借方與貸方金額不相等，請檢查!");
		}
	}

	protected void checkVoucher(VoucherMain voucher,Session session) throws Exception {
		double balance = 0;
		for(Iterator iterator=voucher.getVoucherDets().iterator();iterator.hasNext();) {
			VoucherDet voucherDet = (VoucherDet)iterator.next();
			if ("C".equals(voucherDet.getAccountType()))
				balance = balance + voucherDet.getAccountAmount().doubleValue();
			else
				balance = balance - voucherDet.getAccountAmount().doubleValue();
		}
		if (Math.round(balance) != 0.0) {
			int issueId = voucher.getIssueId();
			IssueMain issue = (IssueMain)session.get(IssueMain.class,issueId);
			throw new AccountException("編號："+issue.getIssueSerial()+"借方與貸方金額不相等，請檢查!");
		}
	}
	
	public void getVoucherInfo(String voucherNo) {
	}
	public AccountRef getCode(Integer id) throws HibernateException
    {	
		//依照主鍵值找出代碼類別資料
		return refDao.get(id);
    }

    public void createCode(AccountRef accountRef) throws HibernateException
    {
    	//傳入代碼類別資料AccountRef並將資料儲存至資料檔
    	if (checkDuplicCode(accountRef))
    		throw new HibernateException("已有重覆代碼!!");
    	refDao.save(accountRef);
    }

    public boolean updateCode(AccountRef accountRef) throws HibernateException
    {
    	//更新所對應，並以傳入AccountRef更新相關資料
    	if (checkDuplicCode(accountRef))
    		throw new HibernateException("已有重覆代碼!!");
    	
    	refDao.saveOrUpdate(accountRef);
        return true;
    }
    
    public void deleteCode(Integer id) throws HibernateException
    {
    	//以傳入之主鍵值找出對應的代碼類別資料並刪除
    	refDao.delete(id);
    }

    public List queryCode(AccountRef accountRef) throws HibernateException
    {
        Criteria criteria = refDao.getSession().createCriteria(AccountRef.class);
        criteria.add(Expression.eq("debtType",accountRef.getDebtType()));
        
        if ((null != accountRef.getAccountCode()) && (!"".equals(accountRef.getAccountCode().trim())))
            criteria.add(Expression.like("accountCode", accountRef.getAccountCode().trim()+"%"));
        if ((null != accountRef.getAccountName()) && (!"".equals(accountRef.getAccountName().trim())))
            criteria.add(Expression.like("accountName", accountRef.getAccountName().trim()+'%'));
        if ((null != accountRef.getAccountType()) && (!"".equals(accountRef.getAccountType().trim())))
            criteria.add(Expression.eq("accountType", accountRef.getAccountType().trim()));
        criteria.addOrder(Order.asc("accountCode"));
        return criteria.list();

    	//以代碼類別(代碼類別、代碼類別名稱)找出相符的資料
    }	
    
//  以id找出相符的資料
    public AccountRef queryCode(Integer id) throws HibernateException
    {
        return refDao.get(id); 

    	
    }
    
    public boolean checkDuplicCode(AccountRef ref){
    	Criteria criteria = refDao.getSession().createCriteria(AccountRef.class);
    	criteria.add(Expression.eq("accountCode",ref.getAccountCode()));
    	criteria.add(Expression.eq("debtType",ref.getDebtType()));
    	criteria.add(Expression.ne("id",ref.getId()));
    	if (criteria.list().size() > 0)
    		return true;
    	else
    		return false;
    	
    }
    
    public VoucherMain getVoucher(int voucherId) {
    	Session session = voucherDao.getSession();
    	VoucherMain voucher = voucherDao.get(voucherId,session);
    	Hibernate.initialize(voucher);
    	Hibernate.initialize(voucher.getVoucherDets());
    	session.close();
    	return voucher;
    }
    
    public void cancelVoucher(int voucherId) throws AccountException {
    	VoucherMain voucher = voucherDao.get(voucherId);
    	if (voucher.getPostDate() != null)
			throw new AccountException("此傳票已過帳，無法刪除!");

    	
    	voucherDao.delete(voucherId);
    }
    
    public void addVoucherDet(VoucherMain voucher,VoucherDet voucherDet,int addMode) throws AccountException {
    	boolean isTheSameDet=false;
    	
    	//取得目前傳票明細
    	Set<VoucherDet> currentVoucherDets = voucher.getVoucherDets();
    	
    	int voucherId = voucherDet.getAccount().getId();
    	String accountType = voucherDet.getAccountType();
    	
    	if (voucherId == 0)
    		throw new AccountException("輸入傳票明細有誤!無會計編號");
	    
    	//如果有重覆的會計科目且科目類別不同就新增金額而不新增一筆資料
    	//新增規則  addMode = 1 =>新增金額(add)
    	//        addMode = 2 =>覆蓋新的(replace)
	    if (currentVoucherDets != null) {	    	
	    	for(Iterator iterator=currentVoucherDets.iterator();iterator.hasNext();) {
	    		VoucherDet detInVoucher = (VoucherDet)iterator.next();
	    		if (detInVoucher.getAccount().getId() == voucherId ) {
	    			if(addMode == 1) {	
	    				if (accountType.equals(detInVoucher.getAccountType())) {
	    					detInVoucher.setAccountAmount(detInVoucher.getAccountAmount().add(voucherDet.getAccountAmount()));
	    				}
	    			}else if(addMode == 2) {
    					detInVoucher.setAccountAmount(voucherDet.getAccountAmount());
    					detInVoucher.setAccountType(voucherDet.getAccountType());
	    			}
	    			isTheSameDet = true;
	    			break;
	    		}
	    	}
    	}
	     
	     //	   如果沒有明細，就直接新增一筆
    	if (!isTheSameDet || currentVoucherDets==null) {
	   	     if (currentVoucherDets == null)
		    	 currentVoucherDets = new TreeSet<VoucherDet>();
	   	     
    		voucherDet.setVoucher(voucher);
    		currentVoucherDets.add(voucherDet);
    	}
    	
    	currentVoucherDets = sortVoucherDet(currentVoucherDets);

    	voucher.setVoucherDets(currentVoucherDets);   	
    	
    }
    
    static public Set<VoucherDet> sortVoucherDet(Set<VoucherDet> voucherDets) {
		//將傳票排序
		Set<VoucherDet> voucherDetSet = new TreeSet<VoucherDet>(
				new Comparator<VoucherDet>() 
				{
					public int compare(VoucherDet o1, VoucherDet o2)  {
						if (o1.getAccountType().compareTo(o2.getAccountType()) > 0) {
							return -1;
						}else if(o1.getAccountType().compareTo(o2.getAccountType()) < 0) {
							return 1;
						}else {
							if (o1.getAccount().getAccountCode().compareTo(o2.getAccount().getAccountCode()) > 0) {
								return 1;
							}else {
								return -1;
							}
						}
	
					}
				}
		);	
		
		if (voucherDets == null)
			voucherDets = new TreeSet<VoucherDet>();
		
		voucherDetSet.addAll(voucherDets);
		return voucherDetSet;
    }
    
    public void postToLedger(String accountROCYear,String accountMonth,DebtTypeRef debtType,String postUsr,String issueYear,int issueId) throws AccountException,IllegalAccessException, InvocationTargetException {
    	int accountYear = Integer.parseInt(accountROCYear) + 1911;
		int month = Integer.parseInt(accountMonth);
    	HandlePost("Post",accountYear,month,debtType,postUsr,issueYear,issueId);
    }
    
    public void cancelPost(String accountROCYear,String accountMonth,DebtTypeRef debtType,String postUsr,String issueYear,int issueId) throws AccountException,IllegalAccessException, InvocationTargetException {
    	Session session = voucherDao.getSession();
    	Criteria criteria = session.createCriteria(VoucherMain.class);

		int accountYear = Integer.parseInt(accountROCYear) + 1911;
		int month = Integer.parseInt(accountMonth);
		calendar.set(accountYear,month,1);
		calendar.add(Calendar.DATE,-1);
		
		criteria.add(Expression.eq("debtType",debtType));
		criteria.add(Expression.ge("voucherDate",calendar.getTime()));
		criteria.add(Expression.isNotNull("postDate"));
		if (criteria.list().size()>0) {
			throw new AccountException("下個月有已過帳傳票，本月不可取消過帳!");
		}else {
			HandlePost("Cancel",accountYear,month,debtType,postUsr,issueYear,issueId);
		}
    	
    }
    
    /**
     * 
     * @param action       "Post" =>過帳 "Cancel"=>取消過帳
     * @param accountYear  過帳年度(西元年)
     * @param accountMonth 過帳月份
     * @param debtType     債種
     * @param postUsr      過帳人
     * @param issue_id 
     * @param issue_year 
     * @throws AccountException
     */
    private void HandlePost(String action,int accountYear,int accountMonth,DebtTypeRef debtType,String postUsr, String issueYear, int issueId) throws AccountException {
    	Session session = voucherDao.getSession();
    	Criteria criteria = session.createCriteria(VoucherMain.class);
    	
    	//取得月初及月末日期
    	calendar.set(accountYear,accountMonth-1,1);
    	calendar.add(Calendar.DATE, -1);
    	Date monthStartDate = calendar.getTime();
    	calendar.add(Calendar.DATE, 1);
		Date monthLastDate = DateUtil.getLastDateOfMonth(calendar.getTime());
		criteria.add(Expression.eq("debtType",debtType));
		
		if("Cancel".equals(action)) {
			criteria.add(Expression.gt("voucherDate",monthStartDate));
		}
		
		//user要求僅針對該月份做過帳處裡
		if(debtType.getType().equals("A")){
			criteria.add(Expression.ge("voucherDate",monthStartDate));
			criteria.add(Expression.le("voucherDate",monthLastDate));
		}
		else
			criteria.add(Expression.lt("voucherDate",monthLastDate));
		
		if ("Post".equals(action))
			criteria.add(Expression.isNull("postDate"));		
		else if ("Cancel".equals(action))
			criteria.add(Expression.isNotNull("postDate"));		
		
		if(issueId != 0 ){
			String addSql ="(exists(select 1 from issue_main n " +
						"where {alias}.issue_id = n.id " +
						" and n.id = "+issueId;
			
			if(issueYear!=null && !("".equals(issueYear.trim()))){
				addSql = addSql + "and n.account_year ='"+issueYear+"'";
			}
			addSql = addSql +" )) ";
	
			criteria.add(Expression.sql(addSql));
		}
		List voucherList = criteria.list();
		
		Date postDate = null;
		
		if ("Post".equals(action))
			postDate = new Date();
		else if("Cancel".equals(action))
			postDate = null;
		
		for(Iterator iterator=voucherList.iterator();iterator.hasNext();) {
			VoucherMain voucher = (VoucherMain)iterator.next();
			voucher.setPostDate(postDate);
			voucher.setPostUsr(postUsr);
			voucher.setModDate(new Date());
			session.saveOrUpdate(voucher);
		}
		
		Transaction trans = session.beginTransaction();
		trans.begin();
		session.flush();
		trans.commit();	
		session.close();         	
    }
    
    public File printVoucher(String path) {
    	ReportManager reportManager = new ReportManager("Voucher",new HashMap(),path);

    	File voucher = new File("ABC");
    	return voucher;
    }
    
}
 
