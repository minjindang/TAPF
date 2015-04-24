package tw.gov.nta.surplusage.common;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.sql.BudgetRef;
import tw.gov.nta.sql.CentralStatisticsMain;
import tw.gov.nta.sql.DebitRef;
import tw.gov.nta.sql.UserStatisticsMain;
import tw.gov.nta.sql.dao.UserStatisticsMainDAO;
import tw.gov.nta.system.common.BudgetCodeManager;
import tw.gov.nta.system.common.CentralStatisticsManager;
import tw.gov.nta.system.common.DebitCodeManage;

public class UserStatisticsManager
{
	private UserStatisticsMainDAO dao;

	public UserStatisticsManager() {
		dao = new UserStatisticsMainDAO();
	}

	public UserStatisticsMain get(Integer id) throws HibernateException
    {	
		return dao.get(id);
    }

    public Integer create(UserStatisticsMain dto) throws HibernateException
    {
    	setAuditAmount(dto);
    	syncCentralStatisticsMain(dto);
		return dao.save(dto);
    }

    public void update(UserStatisticsMain dto) throws HibernateException
    {
    	setAuditAmount(dto);
    	syncCentralStatisticsMain(dto);
    	dao.saveOrUpdate(dto);
    }
    public UserStatisticsMain setAuditAmount(UserStatisticsMain dto){
    	dto.setAuditBamount1(dto.getRealBamount1().add(dto.getKeepBamount1()));
    	dto.setAuditUamount1(dto.getRealUamount1().add(dto.getKeepUamount1()));
    	dto.setAuditPamount1(dto.getRealPamount1().add(dto.getKeepPamount1()));
    	dto.setAuditRamount1(dto.getRealRamount1().add(dto.getKeepRamount1()));
    	dto.setAuditBamount2(dto.getRealBamount2().add(dto.getKeepBamount2()));
    	dto.setAuditUamount2(dto.getRealUamount2().add(dto.getKeepUamount2()));
    	dto.setAuditPamount2(dto.getRealPamount2().add(dto.getKeepPamount2()));
    	dto.setAuditRamount2(dto.getRealRamount2().add(dto.getKeepRamount2()));
    	return dto;
    }
    public void delete(Integer id) throws HibernateException
    {
    	dao.delete(id);
    }
    
    public void syncCentralStatisticsMain(UserStatisticsMain dto) throws HibernateException
    {
		String[] clos = {"accountYear","budgetCode","debtCode","boundCode","inoutType"};
		Object[] values={dto.getAccountYear(),dto.getBudgetCode(),dto.getDebtCode(),dto.getBoundCode(),dto.getInoutType()};
		String[] cond={"=","=","=","=","="};
		String[] orderby={};

		List<CentralStatisticsMain> list = (List<CentralStatisticsMain>) CentralStatisticsManager.search(clos,values,cond,orderby);
		System.out.println( "create:"+list.size() );
		for(CentralStatisticsMain centralStatisticsMain : list )
		{
			CentralStatisticsManager.delete(centralStatisticsMain.getId());
		}	
		
		CentralStatisticsMain csMain = new CentralStatisticsMain();
		
		DebitCodeManage debtManager= new DebitCodeManage();
		String debitRemark = ((DebitRef)debtManager.get(dto.getDebtCode())).getRemark();
		if(debitRemark == null)
			debitRemark="";
		csMain.setAccount( false );	//預設值
		if(debitRemark.trim().length() > 0  && (debitRemark.length() >= 12)?"90年度以後新增特別預算".equals(debitRemark.substring(0,12)):false)
		{
			csMain.setAccount( true );
		}
		csMain.setInoutType(dto.getInoutType());
		csMain.setAccountYear( dto.getAccountYear() );	//年度
		csMain.setBudgetCode( dto.getBudgetCode() );	//預算別
		csMain.setDebtCode( dto.getDebtCode() );		//債務別
		csMain.setBoundCode( dto.getBoundCode() );		//自償否債種
		//固定值
		csMain.setInterestAmount( new BigDecimal(0.0) );	//利息金額 = 0
		csMain.setYearKind( "0" );	//年度類別 = "不分"
		//csMain.setAccount( true );	//是否列入支出總比例計算 = "Y"
		csMain.setInoutType(dto.getInoutType());	//內外債別
		
		//預算數	公債	列入債限
		csMain.setAccountKind( "1" );						//金額種類 = 預算數
		csMain.setDebtType( "A" );							//債種 = 公債
		csMain.setDebt( false );								//是否排限 = "N"
		csMain.setIssueAmount( dto.getBudgetBamount1() );	//借款金額 = 列入債限
		csMain.setPayAmount( dto.getBudgetPamount1() );		//還款金額 = 還款數額
		csMain.setRemainAmount( dto.getBudgetRamount1() );	//未償還餘額 = 未償還餘額
		csMain.setId( null );
		csMain.setAccountType("Y".equals(dto.getAccountType())?"N":"Y");
		CentralStatisticsManager.create( csMain );

		//預算數	公債	不列入債限
		csMain.setAccountKind( "1" );						//金額種類 = 預算數
		csMain.setDebtType( "A" );							//債種 = 公債
		csMain.setDebt( true );							//是否債限 = "Y"
		csMain.setIssueAmount( dto.getBudgetUamount1() );	//借款金額 = 不列入債限
		csMain.setPayAmount( new BigDecimal(0.0) );			//還款金額 = 0
		csMain.setRemainAmount( new BigDecimal(0.0) );		//未償還餘額 = 0
		csMain.setId( null );
		CentralStatisticsManager.create( csMain );

		//預算數	中長借	列入債限
		csMain.setAccountKind( "1" );						//金額種類 = 預算數
		csMain.setDebtType( "C" );							//債種 = 中長借
		csMain.setDebt( false );								//是否債限 = "N"
		csMain.setIssueAmount( dto.getBudgetBamount2() );	//借款金額 = 列入債限
		csMain.setPayAmount( dto.getBudgetPamount2() );		//還款金額 = 還款數額
		csMain.setRemainAmount( dto.getBudgetRamount2() );	//未償還餘額 = 未償還餘額
		csMain.setId( null );
		CentralStatisticsManager.create( csMain );

		//預算數	中長借	不列入債限
		csMain.setAccountKind( "1" );						//金額種類 = 預算數
		csMain.setDebtType( "C" );							//債種 = 中長借
		csMain.setDebt( true );							//是否債限 = "Y"
		csMain.setIssueAmount( dto.getBudgetUamount2() );	//借款金額 = 不列入債限
		csMain.setPayAmount( new BigDecimal(0.0) );			//還款金額 = 0
		csMain.setRemainAmount( new BigDecimal(0.0) );		//未償還餘額 = 0
		csMain.setId( null );
		CentralStatisticsManager.create( csMain );

		//決算數	公債	列入債限
		csMain.setAccountKind( "2" );						//金額種類 = 決算數
		csMain.setDebtType( "A" );							//債種 = 公債
		csMain.setDebt( false );								//是否債限 = "N"
		csMain.setIssueAmount( dto.getAuditBamount1() );	//借款金額 = 列入債限
		csMain.setPayAmount( dto.getAuditPamount1() );		//還款金額 = 還款數額
		csMain.setRemainAmount( dto.getAuditRamount1() );	//未償還餘額 = 未償還餘額
		csMain.setId( null );
		csMain.setAccountType("Y".equals(dto.getAccountType())?"Y":"N");
		CentralStatisticsManager.create( csMain );

		//決算數	公債	不列入債限
		csMain.setAccountKind( "2" );						//金額種類 = 決算數
		csMain.setDebtType( "A" );							//債種 = 公債
		csMain.setDebt( true );							//是否債限 = "Y"
		csMain.setIssueAmount( dto.getAuditUamount1() );	//借款金額 = 不列入債限
		csMain.setPayAmount( new BigDecimal(0.0) );			//還款金額 = 0
		csMain.setRemainAmount( new BigDecimal(0.0) );		//未償還餘額 = 0
		csMain.setId( null );
		CentralStatisticsManager.create( csMain );

		//決算數	中長借	列入債限
		csMain.setAccountKind( "2" );						//金額種類 = 決算數
		csMain.setDebtType( "C" );							//債種 = 中長借
		csMain.setDebt( false );								//是否債限 = "N"
		csMain.setIssueAmount( dto.getAuditBamount2() );	//借款金額 = 列入債限
		csMain.setPayAmount( dto.getAuditPamount2() );		//還款金額 = 還款數額
		csMain.setRemainAmount( dto.getAuditRamount2() );	//未償還餘額 = 未償還餘額
		csMain.setId( null );
		CentralStatisticsManager.create( csMain );

		//決算數	中長借	不列入債限
		csMain.setAccountKind( "2" );						//金額種類 = 決算數
		csMain.setDebtType( "C" );							//債種 = 中長借
		csMain.setDebt( true );							//是否債限 = "Y"
		csMain.setIssueAmount( dto.getAuditUamount2() );	//借款金額 = 不列入債限
		csMain.setPayAmount( new BigDecimal(0.0) );			//還款金額 = 0
		csMain.setRemainAmount( new BigDecimal(0.0) );		//未償還餘額 = 0
		csMain.setId( null );
		CentralStatisticsManager.create( csMain );

		//實際數	公債	列入債限
		csMain.setAccountKind( "4" );						//金額種類 = 實際數
		csMain.setDebtType( "A" );							//債種 = 公債
		csMain.setDebt( false );								//是否債限 = "N"
		csMain.setIssueAmount( dto.getRealBamount1() );		//借款金額 = 列入債限
		csMain.setPayAmount( dto.getRealPamount1() );		//還款金額 = 還款數額
		csMain.setRemainAmount( dto.getRealRamount1() );	//未償還餘額 = 未償還餘額
		csMain.setId( null );
		csMain.setAccountType("N");
		CentralStatisticsManager.create( csMain );

		//實際數	公債	不列入債限
		csMain.setAccountKind( "4" );						//金額種類 = 實際數
		csMain.setDebtType( "A" );							//債種 = 公債
		csMain.setDebt( true );							//是否債限 = "Y"
		csMain.setIssueAmount( dto.getRealUamount1() );		//借款金額 = 不列入債限
		csMain.setPayAmount( new BigDecimal(0.0) );			//還款金額 = 0
		csMain.setRemainAmount( new BigDecimal(0.0) );		//未償還餘額 = 0
		csMain.setId( null );
		CentralStatisticsManager.create( csMain );

		//實際數	中長借	列入債限
		csMain.setAccountKind( "4" );						//金額種類 = 實際數
		csMain.setDebtType( "C" );							//債種 = 中長借
		csMain.setDebt( false );								//是否債限 = "N"
		csMain.setIssueAmount( dto.getRealBamount2() );		//借款金額 = 列入債限
		csMain.setPayAmount( dto.getRealPamount2() );		//還款金額 = 還款數額
		csMain.setRemainAmount( dto.getRealRamount2() );	//未償還餘額 = 未償還餘額
		csMain.setId( null );
		CentralStatisticsManager.create( csMain );

		//實際數	中長借	不列入債限
		csMain.setAccountKind( "4" );						//金額種類 = 實際數
		csMain.setDebtType( "C" );							//債種 = 中長借
		csMain.setDebt( true );							//是否債限 = "Y"
		csMain.setIssueAmount( dto.getRealUamount2() );		//借款金額 = 不列入債限
		csMain.setPayAmount( new BigDecimal(0.0) );			//還款金額 = 0
		csMain.setRemainAmount( new BigDecimal(0.0) );		//未償還餘額 = 0
		csMain.setId( null );
		CentralStatisticsManager.create( csMain );

		//保留數	公債	列入債限
		csMain.setAccountKind( "3" );						//金額種類 = 保留數
		csMain.setDebtType( "A" );							//債種 = 公債
		csMain.setDebt( false );								//是否債限 = "N"
		csMain.setIssueAmount( dto.getKeepBamount1() );		//借款金額 = 列入債限
		csMain.setPayAmount( dto.getKeepPamount1() );		//還款金額 = 還款數額
		csMain.setRemainAmount( dto.getKeepRamount1() );	//未償還餘額 = 未償還餘額
		csMain.setId( null );
		CentralStatisticsManager.create( csMain );

		//保留數	公債	不列入債限
		csMain.setAccountKind( "3" );						//金額種類 = 保留數
		csMain.setDebtType( "A" );							//債種 = 公債
		csMain.setDebt( true );							//是否債限 = "Y"
		csMain.setIssueAmount( dto.getKeepUamount1() );		//借款金額 = 不列入債限
		csMain.setPayAmount( new BigDecimal(0.0) );			//還款金額 = 0
		csMain.setRemainAmount( new BigDecimal(0.0) );		//未償還餘額 = 0
		csMain.setId( null );
		CentralStatisticsManager.create( csMain );

		//保留數	中長借	列入債限
		csMain.setAccountKind( "3" );						//金額種類 = 保留數
		csMain.setDebtType( "C" );							//債種 = 中長借
		csMain.setDebt( false );								//是否債限 = "N"
		csMain.setIssueAmount( dto.getKeepBamount2() );		//借款金額 = 列入債限
		csMain.setPayAmount( dto.getKeepPamount2() );		//還款金額 = 還款數額
		csMain.setRemainAmount( dto.getKeepRamount2() );	//未償還餘額 = 未償還餘額
		csMain.setId( null );
		CentralStatisticsManager.create( csMain );

		//保留數	中長借	不列入債限
		csMain.setAccountKind( "3" );						//金額種類 = 保留數
		csMain.setDebtType( "C" );							//債種 = 中長借
		csMain.setDebt( true );							//是否債限 = "Y"
		csMain.setIssueAmount( dto.getKeepUamount2() );		//借款金額 = 不列入債限
		csMain.setPayAmount( new BigDecimal(0.0) );			//還款金額 = 0
		csMain.setRemainAmount( new BigDecimal(0.0) );		//未償還餘額 = 0
		csMain.setId( null );
		CentralStatisticsManager.create( csMain );
    }

    @SuppressWarnings("unchecked")
	public List<UserStatisticsMain> query(UserStatisticsMain dto) throws HibernateException
    {
    	Session session = dao.getSession();
        Criteria criteria = session.createCriteria(UserStatisticsMain.class);
        if ((null != dto.getAccountYear()) && (!"".equals(dto.getAccountYear())))
            criteria.add(Expression.eq("accountYear", dto.getAccountYear()));
        if (0 != dto.getBudgetCode()) 
            criteria.add(Expression.eq("budgetCode", dto.getBudgetCode()));
        if (0 != dto.getDebtCode())
            criteria.add(Expression.eq("debtCode", dto.getDebtCode()));
        if ((null != dto.getBoundCode()) && (!"".equals(dto.getBoundCode())))
            criteria.add(Expression.eq("boundCode", dto.getBoundCode()));
        if ((null != dto.getInoutType()) && (!"".equals(dto.getInoutType())))
            criteria.add(Expression.eq("inoutType", dto.getInoutType()));
        criteria.addOrder(Order.asc("accountYear"));
        List<UserStatisticsMain> list = criteria.list();
        session.close();
        return list;
    }

	@SuppressWarnings("unchecked")
	public List<UserStatisticsMain> search(String[] pCols,Object[] pValues,String[] pConds,String[] pOrderby ) throws HibernateException
	{
    	Session session = dao.getSession();
		Criteria criteria = session.createCriteria(UserStatisticsMain.class);
		if(pCols != null && pValues != null && pConds != null)
		{
			for(int i = 0 ; i < pCols.length ; i++)
			{
				if(pCols[i] == null || pValues[i] == null || pConds[i] == null || 
						"".equals(pCols[i]) || "".equals(pValues[i]) || "".equals(pConds[i]))
					continue;
				if(pConds[i].equals("="))
					criteria.add(Expression.eq(pCols[i], pValues[i]));
				else if(pConds[i].equals(">"))
					criteria.add(Expression.gt(pCols[i], pValues[i]));
				else if(pConds[i].equals("<"))
					criteria.add(Expression.lt(pCols[i], pValues[i]));
				else if(pConds[i].equals(">="))
					criteria.add(Expression.ge(pCols[i], pValues[i]));
				else if(pConds[i].equals("<="))
					criteria.add(Expression.le(pCols[i], pValues[i]));
				else if(pConds[i].equals("like"))
					criteria.add(Expression.like(pCols[i], pValues[i]+"%"));
			}
		}
		if(pOrderby != null){
			for(int i = 0 ; i < pOrderby.length ; i++){
				if(pOrderby[i] == null || "".equals(pOrderby[i])) continue;
				criteria.addOrder(Order.asc(pOrderby[i]));
			}
		}
		List tResultList = criteria.list();
		session.close();
		return tResultList;
	}
	
    public void syncDeleteDetail(UserStatisticsMain dto) throws HibernateException
    {
    	String[] clos = {"accountYear","budgetCode","debtCode","boundCode"};
		Object[] values={dto.getAccountYear(),dto.getBudgetCode(),dto.getDebtCode(),dto.getBoundCode()};
		String[] cond={"=","=","=","="};
		String[] orderby={};
		List<CentralStatisticsMain> list = (List<CentralStatisticsMain>) CentralStatisticsManager.search(clos,values,cond,orderby);
		System.out.println( "create:"+list.size() );
		for(CentralStatisticsMain centralStatisticsMain : list )
		{
			CentralStatisticsManager.delete(centralStatisticsMain.getId());
		}	
    	dao.delete(dto.getId());
    }
    public UserStatisticsMainDAO getDao() {
		return dao;
	}

	public void setDao(UserStatisticsMainDAO dao) {
		this.dao = dao;
	}
}
