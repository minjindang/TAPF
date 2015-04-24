/*
 * 在 2006/2/20 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
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

import tw.gov.nta.sql.LawPercentRef;
import tw.gov.nta.sql.TaxactionDet;
import tw.gov.nta.sql.UnitAllocateMain;
import tw.gov.nta.sql.UnitInfoMain;
import tw.gov.nta.sql.UnitPercentDet;
import tw.gov.nta.sql.dao.LawPercentRefDAO;
import tw.gov.nta.sql.dao.TaxactionDetDAO;
import tw.gov.nta.sql.dao.UnitInfoMainDAO;

/**
 * @author Jack Du Taxaction稅款物件 TODO 提供系統操作各期稅款 (年度+月份+類別)資料(新增、修改、查詢)。
 */
public class Taxaction {
	
	/**
	 * 取得最後一資料
	 * @param
	 * @return TaxactionDet
	 * @throws HibernateException
	 */
	public static TaxactionDet getLastDate()throws HibernateException{
		TaxactionDetDAO dao = new TaxactionDetDAO();
		Criteria criteria = dao.getSession().createCriteria(TaxactionDet.class);
		List list = criteria.list();
		TaxactionDet taxactionDet = new TaxactionDet();
        for(Iterator it=list.iterator();it.hasNext();)
        {
        	taxactionDet = (TaxactionDet) it.next();
        }
        return taxactionDet;

	}
	
	/**
	 * 依照傳入參數(year,month,kind)新增至稅款資料檔
	 * @param taxYear 記帳年度
	 * @param taxMonth 記帳月份
	 * @param taxKind 稅款種類
	 * @return 回傳新增後該筆資料主鍵值
	 * @throws HibernateException
	 */
	public static int create(String taxYear,String taxMonth,String taxKind,String usrid) throws HibernateException {
//		TaxactionDetDAO dao = new TaxactionDetDAO();
//		TaxactionDet taxactionDet = new TaxactionDet();
//		taxactionDet.setTaxYear(taxYear);
//		taxactionDet.setTaxMonth(taxMonth);
//		taxactionDet.setTaxKind(taxKind);
//		taxactionDet.setUsrid(usrid);
//		taxactionDet.setCreateDate(new Date());
//		taxactionDet.setModDate(new Date());
//		Integer pk = dao.save(taxactionDet);
//		return pk.intValue();
		return create( taxYear, taxMonth, taxKind,"",
				"","","", usrid);
	}
	
	public static int create(String taxYear,String taxMonth,String taxKind,String monNo,
			String bankno,String monKind,String pname,String usrid) throws HibernateException {
		TaxactionDetDAO dao = new TaxactionDetDAO();
		TaxactionDet taxactionDet = new TaxactionDet();
		taxactionDet.setTaxYear(taxYear);
		taxactionDet.setTaxMonth(taxMonth);
		taxactionDet.setTaxKind(taxKind);
		taxactionDet.setMonNo(monNo);
		taxactionDet.setBankno(bankno);
		taxactionDet.setMonKind(monKind);
		taxactionDet.setPname(pname);
		taxactionDet.setUsrid(usrid);
		taxactionDet.setCreateDate(new Date());
		taxactionDet.setModDate(new Date());
		taxactionDet.setNationRate(new BigDecimal("0"));
		taxactionDet.setLocalRate(new BigDecimal("0"));
		taxactionDet.setIntRate(new BigDecimal("0"));
		taxactionDet.setNationTax(new BigDecimal("0"));
		taxactionDet.setLocalTax(new BigDecimal("0"));
		taxactionDet.setIntTax(new BigDecimal("0"));
		Integer pk = dao.save(taxactionDet);
		return pk.intValue();
	}
	/**
	 * 以年度、月份及類別找出對應的稅款資料
	 * @param taxYear 記帳年度
	 * @param taxMonth 記帳月份
	 * @param taxKind 稅款種類
	 * @return TaxactionDet
	 * @throws HibernateException
	 */
	public static TaxactionDet getByYear(String taxYear,String taxMonth,String taxKind) throws HibernateException
	{
		TaxactionDetDAO dao = new TaxactionDetDAO();
        Criteria criteria = dao.getSession().createCriteria(TaxactionDet.class);
        criteria.add(Expression.eq("taxYear", taxYear));
        criteria.add(Expression.eq("taxMonth", taxMonth));
        criteria.add(Expression.eq("taxKind", taxKind));
        TaxactionDet taxactionDet = null;
        List list = criteria.list();
        for(Iterator it=list.iterator();it.hasNext();)
        {
        	taxactionDet = (TaxactionDet) it.next();
        }
        return taxactionDet;
	}

	/**
	 * 以輸入的主鍵值及歲入資料欄位值更新稅款資料
	 * @param id 主鍵值
	 * @param nationTax 國稅收入
	 * @param localTax 地方收入
	 * @param intTax 利息收入
	 * @param fillAmount 應撥補金額
	 * @throws HibernateException
	 */
	public static void updateformoney(int id,BigDecimal nationTax,BigDecimal localTax,BigDecimal intTax, BigDecimal fillAmount,
			BigDecimal nationRate, BigDecimal localRate, BigDecimal intRate)
			throws HibernateException {
		TaxactionDetDAO dao = new TaxactionDetDAO();
		TaxactionDet taxactionDet = dao.get(new Integer(id));
		taxactionDet.setNationTax(nationTax);
		taxactionDet.setLocalTax(localTax);
		taxactionDet.setIntTax(intTax);
		taxactionDet.setFillAmount(fillAmount);
		taxactionDet.setNationRate(nationRate.setScale(2,BigDecimal.ROUND_HALF_UP));
		taxactionDet.setLocalRate(localRate.setScale(2,BigDecimal.ROUND_HALF_UP));
		taxactionDet.setIntRate(intRate.setScale(2,BigDecimal.ROUND_HALF_UP));
		taxactionDet.setModDate(new Date());
		dao.saveOrUpdate(taxactionDet);
	}

	/**
	 * 以輸入的主鍵值及匯款資料欄位值更新稅款資料
	 * @param id
	 * @param monNo 批號
	 * @param bankno 匯款行號
	 * @param monKind 種類
	 * @param pname 姓名
	 * @throws HibernateException
	 */
	public static void updateforInfo(int id,String monNo,String bankno,String monKind,String pname)
			throws HibernateException {
		TaxactionDetDAO dao = new TaxactionDetDAO();
		TaxactionDet taxactionDet =  dao.get(new Integer(id));
		taxactionDet.setMonNo(monNo);
		taxactionDet.setBankno(bankno);
		taxactionDet.setMonKind(monKind);
		taxactionDet.setPname(pname);
		dao.saveOrUpdate(taxactionDet);
	}

	/**
	 * 以年度、月份、類別找出法定分配比例進行國稅收入、地方收入及利息收入試算
	 * @param taxYear 年度
	 * @param taxMonth 月份
	 * @param taxKind 類別
	 * @param nationTax 國稅收入
	 * @param localTax 地方收入
	 * @param intTax 利息收入
	 * @return Double 預定撥付金額總和
	 * @throws Exception 
	 */
	public static BigDecimal tryAccount(String taxYear, String taxMonth, String taxKind,
			BigDecimal nationTax,BigDecimal localTax,BigDecimal intTax,String usrId, BigDecimal fillAmount,
			BigDecimal nationRate, BigDecimal localRate, BigDecimal intRate)
			throws Exception {

		LawPercentRefDAO lawPercentRefDAO = new LawPercentRefDAO();
		LawPercentRef lawPercentRef = lawPercentRefDAO.get(1);
		
		//總稅款 = 國稅收入 + 地方收入 + 利息收入
		/**Chris wu 
		 * 法定分配比例有修改
		 * Nationa--國稅
		 * Nationb--國稅(調節額)
		 * Nationc--沒有作用
		 * Locala--利息
		 * Localb--利息(調節額)
		 * Localc--沒有作用
		 * Inta--沒有作用
		 * Intb--沒有作用
		 * Intc--沒有作用
		 */

		// 國稅-直轄市總稅收入 = 國稅收入*國稅—直轄市比例/100
		//System.out.println("國稅—直轄市比例:"+lawPercentRef.getNationa().divide(new BigDecimal(100)));
		BigDecimal nationA = nationTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		//System.out.println("國稅-直轄市總稅收入:"+nationA);
		// 地方-直轄市總稅收入 = 地方收入*地方稅—直轄市比例/100
		//System.out.println("地方-直轄市比例:"+lawPercentRef.getLocala().divide(new BigDecimal(100)));
		BigDecimal localA = localTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//		BigDecimal localA = localTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		//System.out.println("地方-直轄市總稅收入:"+localA);
		// 利息-直轄市總稅收入 = 利息收入*利息—直轄市比例/100
		//System.out.println("利息—直轄市比例:"+lawPercentRef.getInta().divide(new BigDecimal(100)));
		BigDecimal intA = intTax.multiply(lawPercentRef.getInta()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//		BigDecimal intA = intTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		//System.out.println("利息-直轄市總稅收入:"+intA);

		//直轄市總稅收入 = 國稅-直轄市總稅收入 + 地方-直轄市總稅收入 + 利息-直轄市總稅收入
		//BigDecimal totalA = nationA.add(localA).add(intA);
		//System.out.println("直轄市總稅收入:"+totalA);

		// 國稅-縣市總稅收入 = 國稅收入*國稅—縣市比例/100
		//System.out.println("國稅—縣市比例:"+lawPercentRef.getNationb().divide(new BigDecimal(100)));
		BigDecimal nationB = nationTax.multiply(lawPercentRef.getNationb()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//		BigDecimal nationB = nationTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		//System.out.println("國稅-縣市總稅收入:"+nationB);
		// 地方-縣市總稅收入 = 地方收入*地方稅—縣市比例/100
		//System.out.println("地方稅—縣市比例:"+lawPercentRef.getLocalb().divide(new BigDecimal(100)));
		BigDecimal localB = localTax.multiply(lawPercentRef.getLocalb()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//		BigDecimal localB = localTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		//System.out.println("地方-縣市總稅收入:"+localB);
		// 利息-縣市總稅收入 = 利息收入*利息—縣市比例/100
		//System.out.println("利息—縣市比例:"+lawPercentRef.getIntb().divide(new BigDecimal(100)));
		BigDecimal intB = intTax.multiply(lawPercentRef.getIntb()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//		BigDecimal intB = intTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		//System.out.println("利息-縣市總稅收入:"+intB);

		//縣市總稅收入 = 國稅-縣市總稅收入 + 地方-縣市總稅收入 + 利息-縣市總稅收入
		//BigDecimal totalB = nationB.add(localB).add(intB);
		//System.out.println("縣市總稅收入:"+totalB);

		// 國稅-鄉鎮市總稅收入 = 國稅收入*國稅—鄉鎮市比例/100
		//System.out.println("國稅—鄉鎮市比例:"+lawPercentRef.getNationc().divide(new BigDecimal(100)));
		BigDecimal nationC = nationTax.multiply(lawPercentRef.getNationc()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//		BigDecimal nationC = nationTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		//System.out.println("國稅-鄉鎮市總稅收入:"+nationC);
		// 地方-鄉鎮市總稅收入 = 地方收入*地方稅—鄉鎮市比例/100
		//System.out.println("地方稅—鄉鎮市比例:"+lawPercentRef.getLocalc().divide(new BigDecimal(100)));
		BigDecimal localC = localTax.multiply(lawPercentRef.getLocalc()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//		BigDecimal localC = localTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		//System.out.println("地方-鄉鎮市總稅收入:"+localC);
		// 利息-鄉鎮市總稅收入 = 利息收入*利息—鄉鎮市比例/100
		//System.out.println("利息—鄉鎮市比例:"+lawPercentRef.getIntc().divide(new BigDecimal(100)));
		BigDecimal intC = intTax.multiply(lawPercentRef.getIntc()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//		BigDecimal intC = intTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		//System.out.println("利息-鄉鎮市總稅收入:"+intC);

		//鄉鎮市總稅收入 = 國稅-鄉鎮市總稅收入 + 地方-鄉鎮市總稅收入 + 利息-鄉鎮市總稅收入
		//BigDecimal totalC = nationC.add(localC).add(intC);
		//System.out.println("鄉鎮市總稅收入:"+intC);

		BigDecimal fillA = new BigDecimal(0);
		BigDecimal fillB = new BigDecimal(0);
		BigDecimal fillC = new BigDecimal(0);
		if("2".equals(taxKind))
		{
			//直轄市應撥補金額 = 應撥補金額*國稅—直轄市比例/100
			fillA = fillAmount.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
			//縣市應撥補金額 = 應撥補金額*國稅—縣市比例/100
			fillB = fillAmount.multiply(lawPercentRef.getNationb()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//			fillB = fillAmount.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
			//鄉鎮市應撥補金額 = 應撥補金額*國稅—鄉鎮市比例/100
			fillC = fillAmount.multiply(lawPercentRef.getNationc()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//			fillC = fillAmount.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		}

		//呼叫UnitAllocate.getByYear(taxYear,taxMonth,taxKind)是否存在統籌分配金額資料，若有資料存在，將該資料刪除
		List<UnitAllocateMain> unitAllocateMainList = UnitAllocate.getByYear(taxYear,taxMonth,taxKind);
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

		//呼叫UnitInfoMainDAO.findAll()找出所有的單位資料
		UnitInfoMainDAO unitInfoMainDao = new UnitInfoMainDAO();
		List<UnitInfoMain> unitInfoMainList = unitInfoMainDao.findAll();
		for(Iterator it=unitInfoMainList.iterator();it.hasNext();)
		{
			UnitInfoMain unitInfoMain = (UnitInfoMain) it.next();
			UnitPercentDet unitPercentDet = new UnitPercentDet();
			unitPercentDet.setTyear(taxYear);
			unitPercentDet.setUnitInfo(unitInfoMain);
			List<UnitPercentDet> UnitPercentDetList = UnitPercent.getByYear(unitPercentDet);
			Iterator it2=UnitPercentDetList.iterator();
			while(it2.hasNext()) {
				unitPercentDet = (UnitPercentDet) it2.next();
			}
//			System.out.println(unitInfoMain.getUnitName());
			//應撥補金額為上年度分配比率
			UnitPercentDet unitPercentDet2 = new UnitPercentDet();
			BigDecimal tpercentLast = new BigDecimal(0);
			if("2".equals(taxKind))
			{
				String taxYearLast = String.valueOf(Integer.parseInt(taxYear)-1);
				if(taxYearLast.length() == 2)
					taxYearLast = "0" + taxYearLast;
				unitPercentDet2.setTyear(taxYearLast);
				unitPercentDet2.setUnitInfo(unitInfoMain);
				UnitPercentDetList = UnitPercent.getByYear(unitPercentDet2);
				it2 = UnitPercentDetList.iterator();
				while(it2.hasNext()) {
					unitPercentDet2 = (UnitPercentDet) it2.next();
				}
				if(unitPercentDet2.getTpercent() != null)
					tpercentLast = unitPercentDet2.getTpercent();
			}

			BigDecimal tpercent = new BigDecimal(0);
			BigDecimal allMoney = new BigDecimal(0);
			BigDecimal srcMoney = new BigDecimal(0);
			BigDecimal lastFound = new BigDecimal(0);
			BigDecimal nowFound = new BigDecimal(0);
			if(unitPercentDet.getTpercent() != null)
				tpercent = unitPercentDet.getTpercent();
			if( "01".equals( unitInfoMain.getGroupid() ) ){
				//直轄市
				//System.out.println("直轄市:"+unitPercentDet.getTpercent().divide(new BigDecimal(100)));
				allMoney = ((nationA.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(localA.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(intA.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)));
				srcMoney = allMoney;
				//應撥補金額
				if("2".equals(taxKind) && (null != tpercentLast && !"0".equals(tpercentLast)))
				{
					lastFound = fillA.multiply(tpercentLast).setScale(0,BigDecimal.ROUND_HALF_UP);
					if(lastFound.compareTo(new BigDecimal(0)) == 1)
						nowFound = allMoney.subtract(lastFound);
					else if(lastFound.compareTo(new BigDecimal(0)) == -1){
						nowFound = allMoney;
						allMoney = allMoney.add(lastFound);
					}else
						nowFound = allMoney;
				}else if("1".equals(taxKind) && (null != nationRate && !"0".equals(nationRate))){
					lastFound = allMoney.multiply(nationRate.divide(new BigDecimal(100))).setScale(0,BigDecimal.ROUND_HALF_UP);
					nowFound = allMoney.subtract(lastFound);
				}
			}
			else if( "02".equals( unitInfoMain.getGroupid() ) ){
				//縣市
				//System.out.println("縣市:"+unitPercentDet.getTpercent().divide(new BigDecimal(100)));
				allMoney = ((nationB.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(localB.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(intB.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)));
				srcMoney = allMoney;
				//應撥補金額
				if("2".equals(taxKind) && (null != tpercentLast && !"0".equals(tpercentLast)))
				{
					lastFound = fillB.multiply(tpercentLast).setScale(0,BigDecimal.ROUND_HALF_UP);
					if(lastFound.compareTo(new BigDecimal(0)) == 1)
						nowFound = allMoney.subtract(lastFound);
					else if(lastFound.compareTo(new BigDecimal(0)) == -1){
						nowFound = allMoney;
						allMoney = allMoney.add(lastFound);
					}else
						nowFound = allMoney;
				}else if("1".equals(taxKind) && (null != localRate && !"0".equals(localRate))){
					lastFound = allMoney.multiply(localRate.divide(new BigDecimal(100))).setScale(0,BigDecimal.ROUND_HALF_UP);
					nowFound = allMoney.subtract(lastFound);
				}
			}
			else if( "03".equals( unitInfoMain.getGroupid() ) ){
				//鄉鎮市
//				System.out.println("鄉鎮市:"+unitPercentDet.getTpercent().divide(new BigDecimal(100)));
				allMoney = ((nationC.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(localC.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(intC.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)));
				srcMoney = allMoney;
				//應撥補金額
				if("2".equals(taxKind) && (null != tpercentLast && !"0".equals(tpercentLast)))
				{
					lastFound = fillC.multiply(tpercentLast).setScale(0,BigDecimal.ROUND_HALF_UP);
					if(lastFound.compareTo(new BigDecimal(0)) == 1)
						nowFound = allMoney.subtract(lastFound);
					else if(lastFound.compareTo(new BigDecimal(0)) == -1){
						nowFound = allMoney;
						allMoney = allMoney.add(lastFound);
					}else
						nowFound = allMoney;
				}else if("1".equals(taxKind) && (null != intRate && !"0".equals(intRate))){
					lastFound = allMoney.multiply(intRate.divide(new BigDecimal(100))).setScale(0,BigDecimal.ROUND_HALF_UP);
					nowFound = allMoney.subtract(lastFound);
				}
			}
			else{
				allMoney = new BigDecimal(0);
				srcMoney = new BigDecimal(0);
				lastFound = new BigDecimal(0);
				nowFound = new BigDecimal(0);
			}
			//System.out.println("總額:"+allMoney);
			/**
			 * Unit_allocate_main
			 * usrid		修改人
			 * modDate		修改時間
			 * createDate	新增時間
			 * allMonth		分配年月
			 * unitInfo		轄區代碼
			 * allMoney		撥付金額
			 * srcMoney		受分配金額
			 * allYear		記帳年度
			 * monKind		=2 專案補助
			 * lastFound	上年度受分配金額(應撥補[扣回]金額)
			 * nowFound		本年度應撥補數
			 */
			
			UnitAllocateMain newUnitAllocateMain = new UnitAllocateMain();
			newUnitAllocateMain.setUsrid( usrId );
			newUnitAllocateMain.setModDate( new Date() );
			newUnitAllocateMain.setRemark(null);
			newUnitAllocateMain.setCreateDate( new Date() );
			newUnitAllocateMain.setAllMonth( taxMonth );
			newUnitAllocateMain.setUnitInfo( unitInfoMain );
			newUnitAllocateMain.setAllMoney( allMoney );
			newUnitAllocateMain.setSrcMoney( srcMoney );
			newUnitAllocateMain.setOk(false);
			newUnitAllocateMain.setAllYear( taxYear );
			newUnitAllocateMain.setMonKind( taxKind );
			newUnitAllocateMain.setFounda( new BigDecimal(0.0));
			newUnitAllocateMain.setFoundb( new BigDecimal(0.0));
			if(null != lastFound && !"".equals(lastFound))
				newUnitAllocateMain.setLastFound(lastFound);
			if(null != nowFound && !"".equals(nowFound))
				newUnitAllocateMain.setNowFound(nowFound);
			UnitAllocate.create(newUnitAllocateMain);
		}		
		return UnitAllocate.Account(taxYear,taxMonth,taxKind);
	}
	/**
	 * 以年度、月份、類別找出法定分配比例進行國稅收入、地方收入及利息收入試算
	 * @param taxYear 年度
	 * @param taxMonth 月份
	 * @param taxKind 類別
	 * @param nationTax 國稅收入
	 * @param localTax 地方收入
	 * @param intTax 利息收入
	 * @return Double 預定撥付金額總和
	 * @throws HibernateException
	 */
	public static BigDecimal tryAccountNoUpd(String taxYear, String taxMonth, String taxKind,
			BigDecimal nationTax,BigDecimal localTax,BigDecimal intTax,String usrId,BigDecimal fillAmount,
			BigDecimal nationRate, BigDecimal localRate, BigDecimal intRate)
			throws HibernateException {

		LawPercentRefDAO lawPercentRefDAO = new LawPercentRefDAO();
		LawPercentRef lawPercentRef = lawPercentRefDAO.get(1);
		
		BigDecimal returnDecimal = new BigDecimal(0);
		
		//總稅款 = 國稅收入 + 地方收入 + 利息收入
		/**Chris wu 
		 * 法定分配比例有修改
		 * Nationa--國稅
		 * Nationb--國稅(調節額)
		 * Nationc--沒有作用
		 * Locala--利息
		 * Localb--利息(調節額)
		 * Localc--沒有作用
		 * Inta--沒有作用
		 * Intb--沒有作用
		 * Intc--沒有作用
		 */

		// 國稅-直轄市總稅收入 = 國稅收入*國稅—直轄市比例/100
		//System.out.println("國稅—直轄市比例:"+lawPercentRef.getNationa().divide(new BigDecimal(100)));
		BigDecimal nationA = nationTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		//System.out.println("國稅-直轄市總稅收入:"+nationA);
		// 地方-直轄市總稅收入 = 地方收入*地方稅—直轄市比例/100
		//System.out.println("地方-直轄市比例:"+lawPercentRef.getLocala().divide(new BigDecimal(100)));
		BigDecimal localA = localTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100),0,4);
//		BigDecimal localA = localTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		//System.out.println("地方-直轄市總稅收入:"+localA);
		// 利息-直轄市總稅收入 = 利息收入*利息—直轄市比例/100
		//System.out.println("利息—直轄市比例:"+lawPercentRef.getInta().divide(new BigDecimal(100)));
		BigDecimal intA = intTax.multiply(lawPercentRef.getInta()).divide(new BigDecimal(100),0,4);
//		BigDecimal intA = intTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100),0,4);
		//System.out.println("利息-直轄市總稅收入:"+intA);

		//直轄市總稅收入 = 國稅-直轄市總稅收入 + 地方-直轄市總稅收入 + 利息-直轄市總稅收入
//		BigDecimal totalA = nationA.add(localA).add(intA);
		//System.out.println("直轄市總稅收入:"+totalA);

		// 國稅-縣市總稅收入 = 國稅收入*國稅—縣市比例/100
		//System.out.println("國稅—縣市比例:"+lawPercentRef.getNationb().divide(new BigDecimal(100)));
		BigDecimal nationB = nationTax.multiply(lawPercentRef.getNationb()).divide(new BigDecimal(100),0,4);
//		BigDecimal nationB = nationTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		//System.out.println("國稅-縣市總稅收入:"+nationB);
		// 地方-縣市總稅收入 = 地方收入*地方稅—縣市比例/100
		//System.out.println("地方稅—縣市比例:"+lawPercentRef.getLocalb().divide(new BigDecimal(100)));
		BigDecimal localB = localTax.multiply(lawPercentRef.getLocalb()).divide(new BigDecimal(100),0,4);
//		BigDecimal localB = localTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		//System.out.println("地方-縣市總稅收入:"+localB);
		// 利息-縣市總稅收入 = 利息收入*利息—縣市比例/100
		//System.out.println("利息—縣市比例:"+lawPercentRef.getIntb().divide(new BigDecimal(100)));
		BigDecimal intB = intTax.multiply(lawPercentRef.getIntb()).divide(new BigDecimal(100),0,4);
//		BigDecimal intB = intTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100),0,4);
		//System.out.println("利息-縣市總稅收入:"+intB);

		//縣市總稅收入 = 國稅-縣市總稅收入 + 地方-縣市總稅收入 + 利息-縣市總稅收入
//		BigDecimal totalB = nationB.add(localB).add(intB);
		//System.out.println("縣市總稅收入:"+totalB);

		// 國稅-鄉鎮市總稅收入 = 國稅收入*國稅—鄉鎮市比例/100
		//System.out.println("國稅—鄉鎮市比例:"+lawPercentRef.getNationc().divide(new BigDecimal(100)));
		BigDecimal nationC = nationTax.multiply(lawPercentRef.getNationc()).divide(new BigDecimal(100),0,4);
//		BigDecimal nationC = nationTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		//System.out.println("國稅-鄉鎮市總稅收入:"+nationC);
		// 地方-鄉鎮市總稅收入 = 地方收入*地方稅—鄉鎮市比例/100
		//System.out.println("地方稅—鄉鎮市比例:"+lawPercentRef.getLocalc().divide(new BigDecimal(100)));
		BigDecimal localC = localTax.multiply(lawPercentRef.getLocalc()).divide(new BigDecimal(100),0,4);
//		BigDecimal localC = localTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		//System.out.println("地方-鄉鎮市總稅收入:"+localC);
		// 利息-鄉鎮市總稅收入 = 利息收入*利息—鄉鎮市比例/100
		//System.out.println("利息—鄉鎮市比例:"+lawPercentRef.getIntc().divide(new BigDecimal(100)));
		BigDecimal intC = intTax.multiply(lawPercentRef.getIntc()).divide(new BigDecimal(100),0,4);
//		BigDecimal intC = intTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100),0,4);
		//System.out.println("利息-鄉鎮市總稅收入:"+intC);

		//鄉鎮市總稅收入 = 國稅-鄉鎮市總稅收入 + 地方-鄉鎮市總稅收入 + 利息-鄉鎮市總稅收入
//		BigDecimal totalC = nationC.add(localC).add(intC);
		//System.out.println("鄉鎮市總稅收入:"+intC);

		BigDecimal fillA = new BigDecimal(0);
		BigDecimal fillB = new BigDecimal(0);
		BigDecimal fillC = new BigDecimal(0);
		if("2".equals(taxKind))
		{
			//直轄市應撥補金額 = 應撥補金額*國稅—直轄市比例/100
			fillA = fillAmount.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
			//縣市應撥補金額 = 應撥補金額*國稅—縣市比例/100
			fillB = fillAmount.multiply(lawPercentRef.getNationb()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//			fillB = fillAmount.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
			//鄉鎮市應撥補金額 = 應撥補金額*國稅—鄉鎮市比例/100
			fillC = fillAmount.multiply(lawPercentRef.getNationc()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//			fillC = fillAmount.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		}
		
		//呼叫UnitInfoMainDAO.findAll()找出所有的單位資料
		UnitInfoMainDAO unitInfoMainDao = new UnitInfoMainDAO();
		List<UnitInfoMain> unitInfoMainList = unitInfoMainDao.findAll();
		for(Iterator it=unitInfoMainList.iterator();it.hasNext();)
		{
			UnitInfoMain unitInfoMain = (UnitInfoMain) it.next();
			UnitPercentDet unitPercentDet = new UnitPercentDet();
			unitPercentDet.setTyear(taxYear);
			unitPercentDet.setUnitInfo(unitInfoMain);
			List<UnitPercentDet> UnitPercentDetList = UnitPercent.getByYear(unitPercentDet);
			Iterator it2=UnitPercentDetList.iterator();
			while(it2.hasNext()) {
				unitPercentDet = (UnitPercentDet) it2.next();
			}
//			System.out.println(unitInfoMain.getUnitName());
			//應撥補金額為上年度分配比率
			UnitPercentDet unitPercentDet2 = new UnitPercentDet();
			BigDecimal tpercentLast = new BigDecimal(0);
			if("2".equals(taxKind))
			{
				String taxYearLast = String.valueOf(Integer.parseInt(taxYear)-1);
				if(taxYearLast.length() == 2)
					taxYearLast = "0" + taxYearLast;
				unitPercentDet2.setTyear(taxYearLast);
				unitPercentDet2.setUnitInfo(unitInfoMain);
				UnitPercentDetList = UnitPercent.getByYear(unitPercentDet2);
				it2 = UnitPercentDetList.iterator();
				while(it2.hasNext()) {
					unitPercentDet2 = (UnitPercentDet) it2.next();
				}
				if(unitPercentDet2.getTpercent() != null)
					tpercentLast = unitPercentDet.getTpercent();
			}

			BigDecimal srcMoney = new BigDecimal(0);
			BigDecimal lastFound = new BigDecimal(0);
			BigDecimal nowFound = new BigDecimal(0);
			BigDecimal tpercent = new BigDecimal(0);
			BigDecimal allMoney = new BigDecimal(0);
			if(unitPercentDet.getTpercent() != null)
				tpercent = unitPercentDet.getTpercent();
			if( "01".equals( unitInfoMain.getGroupid() ) ){
				//直轄市
				//System.out.println("直轄市:"+unitPercentDet.getTpercent().divide(new BigDecimal(100)));
				allMoney = ((nationA.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(localA.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(intA.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)));
				//應撥補金額
				if("2".equals(taxKind) && (null != tpercentLast && !"0".equals(tpercentLast)))
				{
					lastFound = fillA.multiply(tpercentLast).setScale(0,BigDecimal.ROUND_HALF_UP);
					if(lastFound.compareTo(new BigDecimal(0)) == 1)
						nowFound = allMoney.subtract(lastFound);
					else if(lastFound.compareTo(new BigDecimal(0)) == -1){
						nowFound = allMoney;
						allMoney = allMoney.add(lastFound);
					}else
						nowFound = allMoney;
				}else if("1".equals(taxKind) && (null != nationRate && !"0".equals(nationRate))){
					lastFound = allMoney.multiply(nationRate.divide(new BigDecimal(100))).setScale(0,BigDecimal.ROUND_HALF_UP);
					nowFound = allMoney.subtract(lastFound);
				}
			}
			else if( "02".equals( unitInfoMain.getGroupid() ) ){
				//縣市
				//System.out.println("縣市:"+unitPercentDet.getTpercent().divide(new BigDecimal(100)));
				allMoney = ((nationB.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(localB.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(intB.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)));
				//應撥補金額
				if("2".equals(taxKind) && (null != tpercentLast && !"0".equals(tpercentLast)))
				{
					lastFound = fillB.multiply(tpercentLast).setScale(0,BigDecimal.ROUND_HALF_UP);
					if(lastFound.compareTo(new BigDecimal(0)) == 1)
						nowFound = allMoney.subtract(lastFound);
					else if(lastFound.compareTo(new BigDecimal(0)) == -1){
						nowFound = allMoney;
						allMoney = allMoney.add(lastFound);
					}else
						nowFound = allMoney;
				}else if("1".equals(taxKind) && (null != localRate && !"0".equals(localRate))){
					lastFound = allMoney.multiply(localRate.divide(new BigDecimal(100))).setScale(0,BigDecimal.ROUND_HALF_UP);
					nowFound = allMoney.subtract(lastFound);
				}
			}
			else if( "03".equals( unitInfoMain.getGroupid() ) ){
				//鄉鎮市
//				System.out.println("鄉鎮市:"+unitPercentDet.getTpercent().divide(new BigDecimal(100)));
				allMoney = ((nationC.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(localC.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(intC.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)));
				//應撥補金額
				if("2".equals(taxKind) && (null != tpercentLast && !"0".equals(tpercentLast)))
				{
					lastFound = fillC.multiply(tpercentLast).setScale(0,BigDecimal.ROUND_HALF_UP);
					if(lastFound.compareTo(new BigDecimal(0)) == 1)
						nowFound = allMoney.subtract(lastFound);
					else if(lastFound.compareTo(new BigDecimal(0)) == -1){
						nowFound = allMoney;
						allMoney = allMoney.add(lastFound);
					}else
						nowFound = allMoney;
				}else if("1".equals(taxKind) && (null != intRate && !"0".equals(intRate))){
					lastFound = allMoney.multiply(intRate.divide(new BigDecimal(100))).setScale(0,BigDecimal.ROUND_HALF_UP);
					nowFound = allMoney.subtract(lastFound);
				}
			}
			//System.out.println("總額:"+allMoney);
			
			returnDecimal = returnDecimal.add(allMoney); 
		}		
		return (null!=returnDecimal?returnDecimal:new BigDecimal(0));
	}
	/**
	 * 調減後撥付金額
	 * 以年度、月份、類別找出法定分配比例進行國稅收入、地方收入及利息收入試算
	 * @param taxYear 年度
	 * @param taxMonth 月份
	 * @param taxKind 類別
	 * @param nationTax 國稅收入
	 * @param localTax 地方收入
	 * @param intTax 利息收入
	 * @return Double 預定撥付金額總和
	 * @throws HibernateException
	 */
	public static BigDecimal tryCountAmountUpd(String taxYear, String taxMonth, String taxKind,
			BigDecimal nationTax,BigDecimal localTax,BigDecimal intTax,String usrId, BigDecimal nationRate, 
			BigDecimal localRate, BigDecimal intRate)
			throws HibernateException {

		LawPercentRefDAO lawPercentRefDAO = new LawPercentRefDAO();
		LawPercentRef lawPercentRef = lawPercentRefDAO.get(1);
		
		BigDecimal returnDecimal = new BigDecimal(0);
		
		//總稅款 = 國稅收入 + 地方收入 + 利息收入
		/**Chris wu 
		 * 法定分配比例有修改
		 * Nationa--國稅
		 * Nationb--國稅(調節額)
		 * Nationc--沒有作用
		 * Locala--利息
		 * Localb--利息(調節額)
		 * Localc--沒有作用
		 * Inta--沒有作用
		 * Intb--沒有作用
		 * Intc--沒有作用
		 */

		// 國稅-直轄市總稅收入 = 國稅收入*國稅—直轄市比例/100
		BigDecimal nationA = nationTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		// 地方-直轄市總稅收入 = 地方收入*地方稅—直轄市比例/100
		BigDecimal localA = localTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100),0,4);
//		BigDecimal localA = localTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		// 利息-直轄市總稅收入 = 利息收入*利息—直轄市比例/100
		BigDecimal intA = intTax.multiply(lawPercentRef.getInta()).divide(new BigDecimal(100),0,4);
//		BigDecimal intA = intTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100),0,4);
		//System.out.println("利息-直轄市總稅收入:"+intA);

		// 國稅-縣市總稅收入 = 國稅收入*國稅—縣市比例/100
		BigDecimal nationB = nationTax.multiply(lawPercentRef.getNationb()).divide(new BigDecimal(100),0,4);
//		BigDecimal nationB = nationTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		// 地方-縣市總稅收入 = 地方收入*地方稅—縣市比例/100
		BigDecimal localB = localTax.multiply(lawPercentRef.getLocalb()).divide(new BigDecimal(100),0,4);
//		BigDecimal localB = localTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		// 利息-縣市總稅收入 = 利息收入*利息—縣市比例/100
		BigDecimal intB = intTax.multiply(lawPercentRef.getIntb()).divide(new BigDecimal(100),0,4);
//		BigDecimal intB = intTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100),0,4);

		// 國稅-鄉鎮市總稅收入 = 國稅收入*國稅—鄉鎮市比例/100
		BigDecimal nationC = nationTax.multiply(lawPercentRef.getNationc()).divide(new BigDecimal(100),0,4);
//		BigDecimal nationC = nationTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		// 地方-鄉鎮市總稅收入 = 地方收入*地方稅—鄉鎮市比例/100
		BigDecimal localC = localTax.multiply(lawPercentRef.getLocalc()).divide(new BigDecimal(100),0,4);
//		BigDecimal localC = localTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		// 利息-鄉鎮市總稅收入 = 利息收入*利息—鄉鎮市比例/100
		BigDecimal intC = intTax.multiply(lawPercentRef.getIntc()).divide(new BigDecimal(100),0,4);
//		BigDecimal intC = intTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100),0,4);
		
		//呼叫UnitInfoMainDAO.findAll()找出所有的單位資料
		UnitInfoMainDAO unitInfoMainDao = new UnitInfoMainDAO();
		List<UnitInfoMain> unitInfoMainList = unitInfoMainDao.findAll();
		for(Iterator it=unitInfoMainList.iterator();it.hasNext();)
		{
			UnitInfoMain unitInfoMain = (UnitInfoMain) it.next();
			UnitPercentDet unitPercentDet = new UnitPercentDet();
			unitPercentDet.setTyear(taxYear);
			unitPercentDet.setUnitInfo(unitInfoMain);
			List<UnitPercentDet> UnitPercentDetList = UnitPercent.getByYear(unitPercentDet);
			Iterator it2=UnitPercentDetList.iterator();
			while(it2.hasNext()) {
				unitPercentDet = (UnitPercentDet) it2.next();
			}
//			System.out.println(unitInfoMain.getUnitName());
			BigDecimal tpercent = new BigDecimal(0);
			BigDecimal allMoney = new BigDecimal(0);
			if(unitPercentDet.getTpercent() != null)
				tpercent = unitPercentDet.getTpercent();
			if( "01".equals( unitInfoMain.getGroupid() ) ){
				//直轄市
				allMoney = ((nationA.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(localA.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(intA.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)));
				allMoney = allMoney.multiply(nationRate.divide(new BigDecimal(100))).setScale(0,BigDecimal.ROUND_HALF_UP);
			}
			else if( "02".equals( unitInfoMain.getGroupid() ) ){
				//縣市
				allMoney = ((nationB.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(localB.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(intB.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)));
				allMoney = allMoney.multiply(localRate.divide(new BigDecimal(100))).setScale(0,BigDecimal.ROUND_HALF_UP);
			}
			else if( "03".equals( unitInfoMain.getGroupid() ) ){
				//鄉鎮市
				allMoney = ((nationC.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(localC.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(intC.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)));
				allMoney = allMoney.multiply(intRate.divide(new BigDecimal(100))).setScale(0,BigDecimal.ROUND_HALF_UP);
			}
			
			returnDecimal = returnDecimal.add(allMoney);
		}		
		return (null!=returnDecimal?returnDecimal:new BigDecimal(0));
	}
	/**
	 * 取得最大年度的資料
	 */
	public static TaxactionDet getMaxYearDate(String kind) throws HibernateException
	{
		TaxactionDetDAO dao = new TaxactionDetDAO();
		//select max(taxYear) from TaxactionDet
		Criteria maxYearCriteria = dao.getSession().createCriteria(TaxactionDet.class);
		maxYearCriteria.setProjection(Projections.max("taxYear"));
		maxYearCriteria.add(Expression.eq("taxKind",kind));
		String year = (String) maxYearCriteria.uniqueResult();
		//select max(taxMonth) from TaxactionDet where taxYear=max(taxYear)
		Criteria maxMonthCriteria = dao.getSession().createCriteria(TaxactionDet.class);
		maxMonthCriteria.setProjection(Projections.max("taxMonth"));
		maxMonthCriteria.add(Expression.eq("taxYear",year));
		maxMonthCriteria.add(Expression.eq("taxKind",kind));
		String month = (String) maxMonthCriteria.uniqueResult();
		TaxactionDet taxactionDet = new TaxactionDet();
		taxactionDet.setTaxYear(year);
		taxactionDet.setTaxMonth(month);
		return taxactionDet;
	}
	
	/**
	 * 取得已分配過之年月
	 * @return
	 * @throws HibernateException
	 */
	public static List<LabelValueBean> getAlloted() throws HibernateException{
		return getAlloted("1");
	}
	public static List<LabelValueBean> getAlloted(String taxKind) throws HibernateException
	{
		List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
		TaxactionDetDAO dao = new TaxactionDetDAO();
		Session session = dao.getSession();
		StringBuffer queryString = new StringBuffer();
		queryString.append("select d.taxYear,d.taxMonth from TaxactionDet d where d.nationTax is not null and d.localTax is not null and d.intTax is not null ");
		queryString.append(" and d.taxKind = '"+taxKind+"' group by d.taxYear,d.taxMonth ");
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
