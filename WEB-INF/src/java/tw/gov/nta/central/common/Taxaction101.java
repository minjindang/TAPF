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
	 * ���o�̫�@���
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
	 * �̷ӶǤJ�Ѽ�(year,month)�s�W�ܵ|�ڸ����
	 * @param taxYear �O�b�~��
	 * @param taxMonth �O�b���
	 * @return �^�Ƿs�W��ӵ���ƥD���
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
	 * �H�~�סB��������O��X�������|�ڸ��
	 * @param taxYear �O�b�~��
	 * @param taxMonth �O�b���
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
	 * �H��J���D��Ȥη��J������ȧ�s�|�ڸ��
	 * @param id �D���
	 * @param nationTax ��|���J
	 * @param financialCheck �]���O�����ɤĿ�
	 * @param financial �]���O�����ɪ��B
	 * @param intTax �Q�����J
	 * @param fillAmount �����ɪ��B
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
	 * �մ�ἷ�I���B
	 * ��|���J(�ϥΪ�keyin)*�a��F�����(HAMA05) + �]���O�����ɪ��B(�̦~��)/12 *�մ��v(�ϥΪ�keyin)+�Q�����J(�ϥΪ�keyin)*�Q�����(HAMA05)
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
			if("01".equals(unitInfoMain.getGroupid()))//���ҥ�
				total = total.add(GetFillAmount(taxYear,unitInfoMain,nationTax,intTax,nationRate,financial));
			else if("02".equals(unitInfoMain.getGroupid()))//����
				total = total.add(GetFillAmount(taxYear,unitInfoMain,nationTax,intTax,localRate,financial));
			else if("03".equals(unitInfoMain.getGroupid()))//�m��
				total = total.add(GetFillAmount(taxYear,unitInfoMain,nationTax,intTax,intRate,financial));
		}
		return total;
	}	
	
	
	public static void allocate(String taxYear,String taxMonth ,
			BigDecimal nationTax,BigDecimal intTax ,BigDecimal nationRate,BigDecimal localRate,BigDecimal intRate
			,String userId,BigDecimal lastFound,BigDecimal nowFound , BigDecimal financial) throws Exception{
//		�I�sUnitAllocate.getByYear(taxYear,taxMonth,taxKind)�O�_�s�b���w���t���B��ơA�Y����Ʀs�b�A�N�Ӹ�ƧR��
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
			if("01".equals(unitInfoMain.getGroupid())){//���ҥ�
				temp = InsertToAllocatedMain(taxYear,taxMonth,unitInfoMain,nationTax,intTax,nationRate,userId,lastFound,nowFound	,financial);
				total = total.add(temp);
				System.out.println("Country : " + unitInfoMain.getUnitName() + "  Allocated:" + temp);
			}
			else if("02".equals(unitInfoMain.getGroupid())){//����
				temp = InsertToAllocatedMain(taxYear,taxMonth,unitInfoMain,nationTax,intTax,localRate,userId,lastFound,nowFound	,financial);
				total = total.add(temp);
				System.out.println("Country : " + unitInfoMain.getUnitName() + "  Allocated:" + temp);
			}
			else if("03".equals(unitInfoMain.getGroupid())){//�m��
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
		//1�N���q���w 2�N��M�׸ɧU
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
	 * ���������t���B
	 * ���x���t���B :��|���J(�ϥΪ�keyin)*�a��F�����(HAMA05) + �]���O�����ɪ��B(�̦~��)/12 +�Q�����J(�ϥΪ�keyin)*�Q�����(HAMA05)
	 * �������t���B :���x���t���B*�����t���(HAMA06)
	 */
	public static BigDecimal GetAllocatedMoneyTotal(String taxYear,BigDecimal nationTax,BigDecimal intTax,BigDecimal financial){
		//�I�sUnitInfoMainDAO.findAll()��X�Ҧ��������
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
	 * ���������t���B �ھڿ���
	 * nationTax : ��|���J
	 * intTax : �Q�����J
	 */
	public static BigDecimal GetAllocatedMoney(String taxYear,UnitInfoMain unitInfoMain,BigDecimal nationTax,BigDecimal intTax,BigDecimal financial){
		//���G
		BigDecimal result = new BigDecimal(0);
		try{	
		//�ŧi
		BigDecimal nationRate = new BigDecimal(0);
		BigDecimal intRate = new BigDecimal(0);
		//BigDecimal unitFinancial = new BigDecimal(0);
		BigDecimal unitTpercent = new BigDecimal(0);
		//HAMA05 ���o�a��F����ҥH�ΧQ�����
		LawPercentRef101DAO tLawPercentRef101DAO = new LawPercentRef101DAO();
		LawPercentRef101 lawPercentRef101 = tLawPercentRef101DAO.get(1);
		nationRate = lawPercentRef101.getNation();//�a��F�����
		if(nationRate != null && !nationRate.equals(new BigDecimal(0)))
			nationRate=nationRate.divide(new BigDecimal(100),2,4);
		intRate = lawPercentRef101.getInterest();;//�Q�����
		if(intRate != null && !intRate.equals(new BigDecimal(0)))
			intRate=intRate.divide(new BigDecimal(100),2,4);
		//HAMA06 ���o�����o�]���O�����ɪ��B�H�Ψ����t���
		UnitPercentDet101 unitPercentDet101 =UnitPercent101.getByYear(unitInfoMain,taxYear);
		//if(unitPercentDet101.getFinancial()!= null)
			//unitFinancial = unitPercentDet101.getFinancial().setScale(0,RoundingMode.HALF_UP);//�]���O�����ɪ��B
		if(unitPercentDet101.getTpercent() != null)			
			unitTpercent = unitPercentDet101.getTpercent();//�����t���
		//��|���J*�a��F�����*�������
		result = nationTax.multiply(nationRate).multiply(unitTpercent).setScale(0,BigDecimal.ROUND_HALF_UP);
		//+ �]���O�����ɪ��B/12
		result = result.add(financial.divide(new BigDecimal(12),0,BigDecimal.ROUND_HALF_UP));
		//+ �Q�����J * �Q����� * �������
		result = result.add(intTax.multiply(intRate).multiply(unitTpercent).setScale(0,BigDecimal.ROUND_HALF_UP));
		}catch(java.lang.ArithmeticException ex){
			System.out.println("Taxaction101_GetAllocatedMoney:"+ex.getMessage());
		}
		return result;
	}
	
	/**
	 * ���մ�I����B �ھڿ���
	 * nationTax : ��|���J
	 * intTax : �Q�����J
	 * rate : �մ��v
	 */
	public static BigDecimal GetFillAmount(String taxYear,UnitInfoMain unitInfoMain,BigDecimal nationTax,BigDecimal intTax,BigDecimal rate,BigDecimal financial){
		//���G
		BigDecimal result = new BigDecimal(0).setScale(0);
		try{
		//�ŧi
		BigDecimal nationRate = new BigDecimal(0).setScale(0);
		BigDecimal intRate = new BigDecimal(0).setScale(0);
		//BigDecimal unitFinancial = new BigDecimal(0).setScale(0);
		BigDecimal unitTpercent = new BigDecimal(0).setScale(0);
		//HAMA05 ���o�a��F����ҥH�ΧQ�����
		LawPercentRef101DAO tLawPercentRef101DAO = new LawPercentRef101DAO();
		LawPercentRef101 lawPercentRef101 = tLawPercentRef101DAO.get(1);
		nationRate = lawPercentRef101.getNation();//�a��F�����
		if(nationRate != null && !nationRate.equals(new BigDecimal(0).setScale(0)))
			nationRate=nationRate.divide(new BigDecimal(100),2,4);
		intRate = lawPercentRef101.getInterest();//�Q�����
		if(intRate != null && !intRate.equals(new BigDecimal(0).setScale(0)))
			intRate=intRate.divide(new BigDecimal(100),2,4);
		//HAMA06 ���o�����o�]���O�����ɪ��B�H�Ψ����t���
		UnitPercentDet101 unitPercentDet101 =UnitPercent101.getByYear(unitInfoMain,taxYear);
		//if(unitPercentDet101.getFinancial() != null)
			//unitFinancial = unitPercentDet101.getFinancial().setScale(0,BigDecimal.ROUND_UP);//�]���O�����ɪ��B	
		if(unitPercentDet101.getTpercent() != null)
			unitTpercent = unitPercentDet101.getTpercent();//�����t���
		//��|���J*�a��F�����*�������
		result = nationTax.multiply(nationRate).multiply(unitTpercent).setScale(0,BigDecimal.ROUND_HALF_UP);
		// + �]���O�����ɪ��B/12 * (100- �մ���)/100(depend on groupId) 
		BigDecimal temp = new BigDecimal(0);
		temp = financial.divide(new BigDecimal(12),0,BigDecimal.ROUND_HALF_UP);//�]���O�����ɪ��B/12
		temp = temp.multiply(new BigDecimal(100).subtract(rate).divide(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_HALF_UP)).setScale(0,BigDecimal.ROUND_HALF_UP);//(100- �մ���)/100
		result = result.add(temp);
		//System.out.println("Taxaction101_GetFillAmount_Financial : "+financial.divide(new BigDecimal(12),0,RoundingMode.HALF_UP) + "Rate : " + new BigDecimal(100).subtract(rate).divide(new BigDecimal(100)).setScale(2,RoundingMode.HALF_UP) + "Result : " + temp);		
		// + �Q�����J * �Q����� * �������
		result = result.add(intTax.multiply(intRate).multiply(unitTpercent).setScale(0,BigDecimal.ROUND_HALF_UP));
		}catch(java.lang.ArithmeticException ex){
			System.out.println("Taxaction101_GetFillAmount:"+ex.getMessage());
		}
		return result;
	}
	
	/**
	 * ���o�]���O�����ɪ��B
	 * taxYear : �~��
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
	 * ���o�̤j�~�ת����
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
