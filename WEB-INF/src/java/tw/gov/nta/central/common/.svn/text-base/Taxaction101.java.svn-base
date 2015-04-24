package tw.gov.nta.central.common;

import gov.dnt.tame.common.LabelValueBean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;

import tw.gov.nta.sql.LawPercentRef101;
import tw.gov.nta.sql.TaxactionDet101;
import tw.gov.nta.sql.UnitAllocateMain;
import tw.gov.nta.sql.UnitInfoMain;
import tw.gov.nta.sql.UnitPercentDet101;
import tw.gov.nta.sql.dao.LawPercentRef101DAO;
import tw.gov.nta.sql.dao.TaxactionDet101DAO;
import tw.gov.nta.sql.dao.UnitInfoMainDAO;
import tw.gov.nta.sql.dao.UnitPercentDet101DAO;

public class Taxaction101 {
	/**
	 * 取得最後一資料
	 * @param
	 * @return TaxactionDet101
	 * @throws HibernateException
	 */
	public static TaxactionDet101 getLastDate()throws HibernateException{
		TaxactionDet101DAO dao = new TaxactionDet101DAO();
		Criteria criteria = dao.getSession().createCriteria(TaxactionDet101.class);
		List list = criteria.list();
		TaxactionDet101 taxactionDet = new TaxactionDet101();
        for(Iterator it=list.iterator();it.hasNext();)
        {
        	taxactionDet = (TaxactionDet101) it.next();
        }
        return taxactionDet;

	}
	
	/**
	 * 依照傳入參數(year,month)新增至稅款資料檔
	 * @param taxYear 記帳年度
	 * @param taxMonth 記帳月份
	 * @return 回傳新增後該筆資料主鍵值
	 * @throws HibernateException
	 */
	public static int create(String taxYear,String taxMonth) throws HibernateException {
		return create( taxYear, taxMonth,new BigDecimal(0),new BigDecimal(0),"Y",new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0));
	}
	
	public static int create(String taxYear,String taxMonth,BigDecimal nationTax,BigDecimal intTax
			,String financialCheck,BigDecimal financial,BigDecimal nationRate,BigDecimal localRage
			,BigDecimal intRate,BigDecimal fillAmount , BigDecimal totMon) 
	throws HibernateException {
		TaxactionDet101DAO dao = new TaxactionDet101DAO();
		TaxactionDet101 taxactionDet101 = new TaxactionDet101();
		taxactionDet101.setTaxYear(taxYear);
		taxactionDet101.setTaxMonth(taxMonth);
		taxactionDet101.setNationTax(nationTax);
		taxactionDet101.setIntTax(intTax);
		taxactionDet101.setFinancialCheck(financialCheck);
		taxactionDet101.setFinancial(financial);
		taxactionDet101.setNationRate(nationRate);
		taxactionDet101.setLocalRate(localRage);
		taxactionDet101.setIntRate(intRate);	
		taxactionDet101.setFillAmount(fillAmount);
		taxactionDet101.setTotMon(totMon);
		Integer pk = dao.save(taxactionDet101);
		return pk.intValue();
	}
	/**
	 * 以年度、月份及類別找出對應的稅款資料
	 * @param taxYear 記帳年度
	 * @param taxMonth 記帳月份
	 * @return TaxactionDet101
	 * @throws HibernateException
	 */
	public static TaxactionDet101 getByYear(String taxYear,String taxMonth) throws HibernateException
	{
		TaxactionDet101DAO dao = new TaxactionDet101DAO();
        Criteria criteria = dao.getSession().createCriteria(TaxactionDet101.class);
        criteria.add(Expression.eq("taxYear", taxYear));
        criteria.add(Expression.eq("taxMonth", taxMonth));
        TaxactionDet101 taxactionDet = null;
        List list = criteria.list();
        for(Iterator it=list.iterator();it.hasNext();)
        {
        	taxactionDet = (TaxactionDet101) it.next();
        }
        return taxactionDet;
	}

	/**
	 * 以輸入的主鍵值及歲入資料欄位值更新稅款資料
	 * @param id 主鍵值
	 * @param nationTax 國稅收入
	 * @param financialCheck 財源保障彌補勾選
	 * @param financial 財源保障彌補金額
	 * @param intTax 利息收入
	 * @param fillAmount 應撥補金額
	 * @throws HibernateException
	 */
	public static void updateformoney(int id,BigDecimal nationTax,BigDecimal financial,String financialCheck,BigDecimal intTax, BigDecimal fillAmount,
			BigDecimal nationRate, BigDecimal localRate, BigDecimal intRate,BigDecimal totMon)
			throws HibernateException {
		TaxactionDet101DAO dao = new TaxactionDet101DAO();
		TaxactionDet101 taxactionDet101 = dao.get(new Integer(id));
		taxactionDet101.setNationTax(nationTax);
		taxactionDet101.setFinancial(financial);
		taxactionDet101.setFinancialCheck(financialCheck);
		taxactionDet101.setIntTax(intTax);
		taxactionDet101.setFillAmount(fillAmount);
		taxactionDet101.setTotMon(totMon);
		taxactionDet101.setNationRate(nationRate.setScale(2,BigDecimal.ROUND_HALF_UP));
		taxactionDet101.setLocalRate(localRate.setScale(2,BigDecimal.ROUND_HALF_UP));
		taxactionDet101.setIntRate(intRate.setScale(2,BigDecimal.ROUND_HALF_UP));
		dao.saveOrUpdate(taxactionDet101);
	}

	/**
	 * 調減後撥付金額
	 * 國稅收入(使用者keyin)*地方政府比例(HAMA05) + 財源保障彌補金額(依年度)/12 *調減比率(使用者keyin)+利息收入(使用者keyin)*利息比例(HAMA05)
	 * 
	 */
	public static BigDecimal GetFillAmountTotal(String taxYear,BigDecimal nationTax,BigDecimal intTax
			,BigDecimal nationRate,BigDecimal localRate,BigDecimal intRate,BigDecimal financial){
		UnitInfoMainDAO unitInfoMainDao = new UnitInfoMainDAO();
		List<UnitInfoMain> unitInfoMainList = unitInfoMainDao.findAll();
		BigDecimal total = new BigDecimal(0).setScale(0);
		for(Iterator it=unitInfoMainList.iterator();it.hasNext();)
		{
			UnitInfoMain unitInfoMain = (UnitInfoMain) it.next();
			if("01".equals(unitInfoMain.getGroupid()))//直轄市
				total = total.add(GetFillAmount(taxYear,unitInfoMain,nationTax,intTax,nationRate,financial));
			else if("02".equals(unitInfoMain.getGroupid()))//縣市
				total = total.add(GetFillAmount(taxYear,unitInfoMain,nationTax,intTax,localRate,financial));
			else if("03".equals(unitInfoMain.getGroupid()))//鄉鎮市
				total = total.add(GetFillAmount(taxYear,unitInfoMain,nationTax,intTax,intRate,financial));
		}
		return total;
	}	
	
	
	public static void allocate(String taxYear,String taxMonth ,
			BigDecimal nationTax,BigDecimal intTax ,BigDecimal nationRate,BigDecimal localRate,BigDecimal intRate
			,String userId,BigDecimal lastFound,BigDecimal nowFound , BigDecimal financial) throws Exception{
//		呼叫UnitAllocate.getByYear(taxYear,taxMonth,taxKind)是否存在統籌分配金額資料，若有資料存在，將該資料刪除
		List<UnitAllocateMain> unitAllocateMainList = UnitAllocate.getByYear(taxYear,taxMonth,"1");
		for(Iterator it3=unitAllocateMainList.iterator();it3.hasNext();)
		{
			UnitAllocateMain unitAllocateMain = (UnitAllocateMain) it3.next();
			if( !unitAllocateMain.isOk() )
			{
				UnitAllocate.delete( unitAllocateMain.getId() );
			}
			else if( unitAllocateMain.isOk() ){
				throw new Exception("isChecked");
			}
		}
		//insert
		UnitInfoMainDAO unitInfoMainDao = new UnitInfoMainDAO();
		List<UnitInfoMain> unitInfoMainList = unitInfoMainDao.findAll();
		BigDecimal total = new BigDecimal(0);
		BigDecimal temp = new BigDecimal(0);
		for(Iterator it=unitInfoMainList.iterator();it.hasNext();)
		{
			UnitInfoMain unitInfoMain = (UnitInfoMain) it.next();
			if("01".equals(unitInfoMain.getGroupid())){//直轄市
				temp = InsertToAllocatedMain(taxYear,taxMonth,unitInfoMain,nationTax,intTax,nationRate,userId,lastFound,nowFound	,financial);
				total = total.add(temp);
				System.out.println("Country : " + unitInfoMain.getUnitName() + "  Allocated:" + temp);
			}
			else if("02".equals(unitInfoMain.getGroupid())){//縣市
				temp = InsertToAllocatedMain(taxYear,taxMonth,unitInfoMain,nationTax,intTax,localRate,userId,lastFound,nowFound	,financial);
				total = total.add(temp);
				System.out.println("Country : " + unitInfoMain.getUnitName() + "  Allocated:" + temp);
			}
			else if("03".equals(unitInfoMain.getGroupid())){//鄉鎮市
				temp = InsertToAllocatedMain(taxYear,taxMonth,unitInfoMain,nationTax,intTax,intRate,userId,lastFound,nowFound	,financial);
				total = total.add(temp);
				System.out.println("Country : " + unitInfoMain.getUnitName() + "  Allocated:" + temp);
			}
			
		}
		System.out.println("Total : " + total);
	}
	
	public static BigDecimal InsertToAllocatedMain(String taxYear,String taxMonth ,UnitInfoMain unitInfoMain,
		BigDecimal nationTax,BigDecimal intTax,BigDecimal rate,String usrId,BigDecimal lastFound,BigDecimal nowFound,BigDecimal financial){
		UnitAllocateMain newUnitAllocateMain = new UnitAllocateMain();
		newUnitAllocateMain.setUsrid( usrId );
		newUnitAllocateMain.setModDate( new Date() );
		newUnitAllocateMain.setRemark(null);
		newUnitAllocateMain.setCreateDate( new Date() );
		newUnitAllocateMain.setAllMonth( taxMonth );
		newUnitAllocateMain.setUnitInfo( unitInfoMain );
		newUnitAllocateMain.setAllMoney( GetFillAmount(taxYear,unitInfoMain,nationTax,intTax,rate,financial) );
		newUnitAllocateMain.setSrcMoney( GetAllocatedMoney(taxYear,unitInfoMain,nationTax,intTax,financial) );
		newUnitAllocateMain.setOk(false);
		newUnitAllocateMain.setAllYear( taxYear );
		//1代表普通統籌 2代表專案補助
		newUnitAllocateMain.setMonKind("1");
		newUnitAllocateMain.setFounda( new BigDecimal(0.0));
		newUnitAllocateMain.setFoundb( new BigDecimal(0.0));
		if(null != lastFound && !"".equals(lastFound))
			newUnitAllocateMain.setLastFound(lastFound);
		if(null != nowFound && !"".equals(nowFound))
			newUnitAllocateMain.setNowFound(nowFound);
		UnitAllocate.create(newUnitAllocateMain);	
		return newUnitAllocateMain.getAllMoney();
	}

	/**
	 * 按公式分配金額
	 * 全台分配金額 :國稅收入(使用者keyin)*地方政府比例(HAMA05) + 財源保障彌補金額(依年度)/12 +利息收入(使用者keyin)*利息比例(HAMA05)
	 * 縣市分配金額 :全台分配金額*受分配比例(HAMA06)
	 */
	public static BigDecimal GetAllocatedMoneyTotal(String taxYear,BigDecimal nationTax,BigDecimal intTax,BigDecimal financial){
		//呼叫UnitInfoMainDAO.findAll()找出所有的單位資料
		UnitInfoMainDAO unitInfoMainDao = new UnitInfoMainDAO();
		List<UnitInfoMain> unitInfoMainList = unitInfoMainDao.findAll();
		BigDecimal total = new BigDecimal(0);
		for(Iterator it=unitInfoMainList.iterator();it.hasNext();)
		{
			UnitInfoMain unitInfoMain = (UnitInfoMain) it.next();
			total = total.add(GetAllocatedMoney(taxYear,unitInfoMain,nationTax,intTax,financial));
		}
		return total;
	}
	
	/**
	 * 按公式分配金額 根據縣市
	 * nationTax : 國稅收入
	 * intTax : 利息收入
	 */
	public static BigDecimal GetAllocatedMoney(String taxYear,UnitInfoMain unitInfoMain,BigDecimal nationTax,BigDecimal intTax,BigDecimal financial){
		//結果
		BigDecimal result = new BigDecimal(0);
		try{	
		//宣告
		BigDecimal nationRate = new BigDecimal(0);
		BigDecimal intRate = new BigDecimal(0);
		//BigDecimal unitFinancial = new BigDecimal(0);
		BigDecimal unitTpercent = new BigDecimal(0);
		//HAMA05 取得地方政府比例以及利息比例
		LawPercentRef101DAO tLawPercentRef101DAO = new LawPercentRef101DAO();
		LawPercentRef101 lawPercentRef101 = tLawPercentRef101DAO.get(1);
		nationRate = lawPercentRef101.getNation();//地方政府比例
		if(nationRate != null && !nationRate.equals(new BigDecimal(0)))
			nationRate=nationRate.divide(new BigDecimal(100),2,4);
		intRate = lawPercentRef101.getInterest();;//利息比例
		if(intRate != null && !intRate.equals(new BigDecimal(0)))
			intRate=intRate.divide(new BigDecimal(100),2,4);
		//HAMA06 取得縣市得財源保障彌補金額以及受分配比例
		UnitPercentDet101 unitPercentDet101 =UnitPercent101.getByYear(unitInfoMain,taxYear);
		//if(unitPercentDet101.getFinancial()!= null)
			//unitFinancial = unitPercentDet101.getFinancial().setScale(0,RoundingMode.HALF_UP);//財源保障彌補金額
		if(unitPercentDet101.getTpercent() != null)			
			unitTpercent = unitPercentDet101.getTpercent();//受分配比例
		//國稅收入*地方政府比例*縣市比例
		result = nationTax.multiply(nationRate).multiply(unitTpercent).setScale(0,BigDecimal.ROUND_HALF_UP);
		//+ 財源保障彌補金額/12
		result = result.add(financial.divide(new BigDecimal(12),0,BigDecimal.ROUND_HALF_UP));
		//+ 利息收入 * 利息比例 * 縣市比例
		result = result.add(intTax.multiply(intRate).multiply(unitTpercent).setScale(0,BigDecimal.ROUND_HALF_UP));
		}catch(java.lang.ArithmeticException ex){
			System.out.println("Taxaction101_GetAllocatedMoney:"+ex.getMessage());
		}
		return result;
	}
	
	/**
	 * 按調減撥付後金額 根據縣市
	 * nationTax : 國稅收入
	 * intTax : 利息收入
	 * rate : 調減比率
	 */
	public static BigDecimal GetFillAmount(String taxYear,UnitInfoMain unitInfoMain,BigDecimal nationTax,BigDecimal intTax,BigDecimal rate,BigDecimal financial){
		//結果
		BigDecimal result = new BigDecimal(0).setScale(0);
		try{
		//宣告
		BigDecimal nationRate = new BigDecimal(0).setScale(0);
		BigDecimal intRate = new BigDecimal(0).setScale(0);
		//BigDecimal unitFinancial = new BigDecimal(0).setScale(0);
		BigDecimal unitTpercent = new BigDecimal(0).setScale(0);
		//HAMA05 取得地方政府比例以及利息比例
		LawPercentRef101DAO tLawPercentRef101DAO = new LawPercentRef101DAO();
		LawPercentRef101 lawPercentRef101 = tLawPercentRef101DAO.get(1);
		nationRate = lawPercentRef101.getNation();//地方政府比例
		if(nationRate != null && !nationRate.equals(new BigDecimal(0).setScale(0)))
			nationRate=nationRate.divide(new BigDecimal(100),2,4);
		intRate = lawPercentRef101.getInterest();//利息比例
		if(intRate != null && !intRate.equals(new BigDecimal(0).setScale(0)))
			intRate=intRate.divide(new BigDecimal(100),2,4);
		//HAMA06 取得縣市得財源保障彌補金額以及受分配比例
		UnitPercentDet101 unitPercentDet101 =UnitPercent101.getByYear(unitInfoMain,taxYear);
		//if(unitPercentDet101.getFinancial() != null)
			//unitFinancial = unitPercentDet101.getFinancial().setScale(0,BigDecimal.ROUND_UP);//財源保障彌補金額	
		if(unitPercentDet101.getTpercent() != null)
			unitTpercent = unitPercentDet101.getTpercent();//受分配比例
		//國稅收入*地方政府比例*縣市比例
		result = nationTax.multiply(nationRate).multiply(unitTpercent).setScale(0,BigDecimal.ROUND_HALF_UP);
		// + 財源保障彌補金額/12 * (100- 調減比例)/100(depend on groupId) 
		BigDecimal temp = new BigDecimal(0);
		temp = financial.divide(new BigDecimal(12),0,BigDecimal.ROUND_HALF_UP);//財源保障彌補金額/12
		temp = temp.multiply(new BigDecimal(100).subtract(rate).divide(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_HALF_UP)).setScale(0,BigDecimal.ROUND_HALF_UP);//(100- 調減比例)/100
		result = result.add(temp);
		//System.out.println("Taxaction101_GetFillAmount_Financial : "+financial.divide(new BigDecimal(12),0,RoundingMode.HALF_UP) + "Rate : " + new BigDecimal(100).subtract(rate).divide(new BigDecimal(100)).setScale(2,RoundingMode.HALF_UP) + "Result : " + temp);		
		// + 利息收入 * 利息比例 * 縣市比例
		result = result.add(intTax.multiply(intRate).multiply(unitTpercent).setScale(0,BigDecimal.ROUND_HALF_UP));
		}catch(java.lang.ArithmeticException ex){
			System.out.println("Taxaction101_GetFillAmount:"+ex.getMessage());
		}
		return result;
	}
	
	/**
	 * 取得財源保障彌補金額
	 * taxYear : 年度
	 */
	public static BigDecimal GetFinancialByTaxyear(String taxYear){
		BigDecimal result = new BigDecimal(0).setScale(0);
		UnitPercentDet101DAO tUnitPercentDetDAO = new UnitPercentDet101DAO();
		Criteria sumFinancial = tUnitPercentDetDAO.getSession().createCriteria(UnitPercentDet101.class);
		sumFinancial.setProjection(Projections.sum("financial"));
		sumFinancial.add(Expression.eq("tyear",taxYear));
		result = (BigDecimal)sumFinancial.uniqueResult();
		return result.setScale(0,BigDecimal.ROUND_HALF_UP);
	}
	

	/**
	 * 取得最大年度的資料
	 */
	public static TaxactionDet101 getMaxYearDate() throws HibernateException
	{
		TaxactionDet101DAO dao = new TaxactionDet101DAO();
		//select max(taxYear) from TaxactionDet
		Criteria maxYearCriteria = dao.getSession().createCriteria(TaxactionDet101.class);
		maxYearCriteria.setProjection(Projections.max("taxYear"));
		String year = (String) maxYearCriteria.uniqueResult();
		//select max(taxMonth) from TaxactionDet where taxYear=max(taxYear)
		Criteria maxMonthCriteria = dao.getSession().createCriteria(TaxactionDet101.class);
		maxMonthCriteria.setProjection(Projections.max("taxMonth"));
		maxMonthCriteria.add(Expression.eq("taxYear",year));
		String month = (String) maxMonthCriteria.uniqueResult();
		TaxactionDet101 taxactionDet101 = new TaxactionDet101();
		taxactionDet101.setTaxYear(year);
		taxactionDet101.setTaxMonth(month);
		return taxactionDet101;
	}
	
	
	public static List<LabelValueBean> getAlloted() throws HibernateException
	{
		List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
		TaxactionDet101DAO dao = new TaxactionDet101DAO();
		Session session = dao.getSession();
		StringBuffer queryString = new StringBuffer();
		queryString.append("select taxYear,taxMonth from TaxactionDet101  where nationTax is not null  and intTax is not null group by taxYear,taxMonth");
		//queryString.append(" and taxKind = '"+taxKind+"' group by d.taxYear,d.taxMonth ");
		Query query = session.createQuery(queryString.toString());
		List collection = query.list();
        System.out.println(collection);
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	Object[] obj = (Object[])it.next();
            	labelValueBeanList.add(  new LabelValueBean( obj[0].toString(), obj[1].toString() ) );
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel((String)obj[0].toString()+(String)obj[1].toString());
            	labelValueBean.setValuess((String)obj[0].toString()+(String)obj[1].toString());
            	labelValueBeanList.add(labelValueBean);
            	System.out.println("Alloted_Year_Month===>"+labelValueBean.getValuess());
            }
        }
        session.close();
		return labelValueBeanList;
	}
}
