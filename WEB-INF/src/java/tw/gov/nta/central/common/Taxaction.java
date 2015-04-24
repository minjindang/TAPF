/*
 * �b 2006/2/20 �إ�
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ��ɮת��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
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
 * @author Jack Du Taxaction�|�ڪ��� TODO ���Ѩt�ξާ@�U���|�� (�~��+���+���O)���(�s�W�B�ק�B�d��)�C
 */
public class Taxaction {
	
	/**
	 * ���o�̫�@���
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
	 * �̷ӶǤJ�Ѽ�(year,month,kind)�s�W�ܵ|�ڸ����
	 * @param taxYear �O�b�~��
	 * @param taxMonth �O�b���
	 * @param taxKind �|�ں���
	 * @return �^�Ƿs�W��ӵ���ƥD���
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
	 * �H�~�סB��������O��X�������|�ڸ��
	 * @param taxYear �O�b�~��
	 * @param taxMonth �O�b���
	 * @param taxKind �|�ں���
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
	 * �H��J���D��Ȥη��J������ȧ�s�|�ڸ��
	 * @param id �D���
	 * @param nationTax ��|���J
	 * @param localTax �a�覬�J
	 * @param intTax �Q�����J
	 * @param fillAmount �����ɪ��B
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
	 * �H��J���D��Ȥζ״ڸ�����ȧ�s�|�ڸ��
	 * @param id
	 * @param monNo �帹
	 * @param bankno �״ڦ渹
	 * @param monKind ����
	 * @param pname �m�W
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
	 * �H�~�סB����B���O��X�k�w���t��Ҷi���|���J�B�a�覬�J�ΧQ�����J�պ�
	 * @param taxYear �~��
	 * @param taxMonth ���
	 * @param taxKind ���O
	 * @param nationTax ��|���J
	 * @param localTax �a�覬�J
	 * @param intTax �Q�����J
	 * @return Double �w�w���I���B�`�M
	 * @throws Exception 
	 */
	public static BigDecimal tryAccount(String taxYear, String taxMonth, String taxKind,
			BigDecimal nationTax,BigDecimal localTax,BigDecimal intTax,String usrId, BigDecimal fillAmount,
			BigDecimal nationRate, BigDecimal localRate, BigDecimal intRate)
			throws Exception {

		LawPercentRefDAO lawPercentRefDAO = new LawPercentRefDAO();
		LawPercentRef lawPercentRef = lawPercentRefDAO.get(1);
		
		//�`�|�� = ��|���J + �a�覬�J + �Q�����J
		/**Chris wu 
		 * �k�w���t��Ҧ��ק�
		 * Nationa--��|
		 * Nationb--��|(�ո`�B)
		 * Nationc--�S���@��
		 * Locala--�Q��
		 * Localb--�Q��(�ո`�B)
		 * Localc--�S���@��
		 * Inta--�S���@��
		 * Intb--�S���@��
		 * Intc--�S���@��
		 */

		// ��|-���ҥ��`�|���J = ��|���J*��|�X���ҥ����/100
		//System.out.println("��|�X���ҥ����:"+lawPercentRef.getNationa().divide(new BigDecimal(100)));
		BigDecimal nationA = nationTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		//System.out.println("��|-���ҥ��`�|���J:"+nationA);
		// �a��-���ҥ��`�|���J = �a�覬�J*�a��|�X���ҥ����/100
		//System.out.println("�a��-���ҥ����:"+lawPercentRef.getLocala().divide(new BigDecimal(100)));
		BigDecimal localA = localTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//		BigDecimal localA = localTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		//System.out.println("�a��-���ҥ��`�|���J:"+localA);
		// �Q��-���ҥ��`�|���J = �Q�����J*�Q���X���ҥ����/100
		//System.out.println("�Q���X���ҥ����:"+lawPercentRef.getInta().divide(new BigDecimal(100)));
		BigDecimal intA = intTax.multiply(lawPercentRef.getInta()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//		BigDecimal intA = intTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		//System.out.println("�Q��-���ҥ��`�|���J:"+intA);

		//���ҥ��`�|���J = ��|-���ҥ��`�|���J + �a��-���ҥ��`�|���J + �Q��-���ҥ��`�|���J
		//BigDecimal totalA = nationA.add(localA).add(intA);
		//System.out.println("���ҥ��`�|���J:"+totalA);

		// ��|-�����`�|���J = ��|���J*��|�X�������/100
		//System.out.println("��|�X�������:"+lawPercentRef.getNationb().divide(new BigDecimal(100)));
		BigDecimal nationB = nationTax.multiply(lawPercentRef.getNationb()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//		BigDecimal nationB = nationTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		//System.out.println("��|-�����`�|���J:"+nationB);
		// �a��-�����`�|���J = �a�覬�J*�a��|�X�������/100
		//System.out.println("�a��|�X�������:"+lawPercentRef.getLocalb().divide(new BigDecimal(100)));
		BigDecimal localB = localTax.multiply(lawPercentRef.getLocalb()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//		BigDecimal localB = localTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		//System.out.println("�a��-�����`�|���J:"+localB);
		// �Q��-�����`�|���J = �Q�����J*�Q���X�������/100
		//System.out.println("�Q���X�������:"+lawPercentRef.getIntb().divide(new BigDecimal(100)));
		BigDecimal intB = intTax.multiply(lawPercentRef.getIntb()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//		BigDecimal intB = intTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		//System.out.println("�Q��-�����`�|���J:"+intB);

		//�����`�|���J = ��|-�����`�|���J + �a��-�����`�|���J + �Q��-�����`�|���J
		//BigDecimal totalB = nationB.add(localB).add(intB);
		//System.out.println("�����`�|���J:"+totalB);

		// ��|-�m���`�|���J = ��|���J*��|�X�m�����/100
		//System.out.println("��|�X�m�����:"+lawPercentRef.getNationc().divide(new BigDecimal(100)));
		BigDecimal nationC = nationTax.multiply(lawPercentRef.getNationc()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//		BigDecimal nationC = nationTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		//System.out.println("��|-�m���`�|���J:"+nationC);
		// �a��-�m���`�|���J = �a�覬�J*�a��|�X�m�����/100
		//System.out.println("�a��|�X�m�����:"+lawPercentRef.getLocalc().divide(new BigDecimal(100)));
		BigDecimal localC = localTax.multiply(lawPercentRef.getLocalc()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//		BigDecimal localC = localTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		//System.out.println("�a��-�m���`�|���J:"+localC);
		// �Q��-�m���`�|���J = �Q�����J*�Q���X�m�����/100
		//System.out.println("�Q���X�m�����:"+lawPercentRef.getIntc().divide(new BigDecimal(100)));
		BigDecimal intC = intTax.multiply(lawPercentRef.getIntc()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//		BigDecimal intC = intTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		//System.out.println("�Q��-�m���`�|���J:"+intC);

		//�m���`�|���J = ��|-�m���`�|���J + �a��-�m���`�|���J + �Q��-�m���`�|���J
		//BigDecimal totalC = nationC.add(localC).add(intC);
		//System.out.println("�m���`�|���J:"+intC);

		BigDecimal fillA = new BigDecimal(0);
		BigDecimal fillB = new BigDecimal(0);
		BigDecimal fillC = new BigDecimal(0);
		if("2".equals(taxKind))
		{
			//���ҥ������ɪ��B = �����ɪ��B*��|�X���ҥ����/100
			fillA = fillAmount.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
			//���������ɪ��B = �����ɪ��B*��|�X�������/100
			fillB = fillAmount.multiply(lawPercentRef.getNationb()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//			fillB = fillAmount.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
			//�m�������ɪ��B = �����ɪ��B*��|�X�m�����/100
			fillC = fillAmount.multiply(lawPercentRef.getNationc()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//			fillC = fillAmount.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		}

		//�I�sUnitAllocate.getByYear(taxYear,taxMonth,taxKind)�O�_�s�b���w���t���B��ơA�Y����Ʀs�b�A�N�Ӹ�ƧR��
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

		//�I�sUnitInfoMainDAO.findAll()��X�Ҧ��������
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
			//�����ɪ��B���W�~�פ��t��v
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
				//���ҥ�
				//System.out.println("���ҥ�:"+unitPercentDet.getTpercent().divide(new BigDecimal(100)));
				allMoney = ((nationA.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(localA.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(intA.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)));
				srcMoney = allMoney;
				//�����ɪ��B
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
				//����
				//System.out.println("����:"+unitPercentDet.getTpercent().divide(new BigDecimal(100)));
				allMoney = ((nationB.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(localB.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(intB.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)));
				srcMoney = allMoney;
				//�����ɪ��B
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
				//�m��
//				System.out.println("�m��:"+unitPercentDet.getTpercent().divide(new BigDecimal(100)));
				allMoney = ((nationC.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(localC.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(intC.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)));
				srcMoney = allMoney;
				//�����ɪ��B
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
			//System.out.println("�`�B:"+allMoney);
			/**
			 * Unit_allocate_main
			 * usrid		�ק�H
			 * modDate		�ק�ɶ�
			 * createDate	�s�W�ɶ�
			 * allMonth		���t�~��
			 * unitInfo		�ҰϥN�X
			 * allMoney		���I���B
			 * srcMoney		�����t���B
			 * allYear		�O�b�~��
			 * monKind		=2 �M�׸ɧU
			 * lastFound	�W�~�ר����t���B(������[���^]���B)
			 * nowFound		���~�������ɼ�
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
	 * �H�~�סB����B���O��X�k�w���t��Ҷi���|���J�B�a�覬�J�ΧQ�����J�պ�
	 * @param taxYear �~��
	 * @param taxMonth ���
	 * @param taxKind ���O
	 * @param nationTax ��|���J
	 * @param localTax �a�覬�J
	 * @param intTax �Q�����J
	 * @return Double �w�w���I���B�`�M
	 * @throws HibernateException
	 */
	public static BigDecimal tryAccountNoUpd(String taxYear, String taxMonth, String taxKind,
			BigDecimal nationTax,BigDecimal localTax,BigDecimal intTax,String usrId,BigDecimal fillAmount,
			BigDecimal nationRate, BigDecimal localRate, BigDecimal intRate)
			throws HibernateException {

		LawPercentRefDAO lawPercentRefDAO = new LawPercentRefDAO();
		LawPercentRef lawPercentRef = lawPercentRefDAO.get(1);
		
		BigDecimal returnDecimal = new BigDecimal(0);
		
		//�`�|�� = ��|���J + �a�覬�J + �Q�����J
		/**Chris wu 
		 * �k�w���t��Ҧ��ק�
		 * Nationa--��|
		 * Nationb--��|(�ո`�B)
		 * Nationc--�S���@��
		 * Locala--�Q��
		 * Localb--�Q��(�ո`�B)
		 * Localc--�S���@��
		 * Inta--�S���@��
		 * Intb--�S���@��
		 * Intc--�S���@��
		 */

		// ��|-���ҥ��`�|���J = ��|���J*��|�X���ҥ����/100
		//System.out.println("��|�X���ҥ����:"+lawPercentRef.getNationa().divide(new BigDecimal(100)));
		BigDecimal nationA = nationTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		//System.out.println("��|-���ҥ��`�|���J:"+nationA);
		// �a��-���ҥ��`�|���J = �a�覬�J*�a��|�X���ҥ����/100
		//System.out.println("�a��-���ҥ����:"+lawPercentRef.getLocala().divide(new BigDecimal(100)));
		BigDecimal localA = localTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100),0,4);
//		BigDecimal localA = localTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		//System.out.println("�a��-���ҥ��`�|���J:"+localA);
		// �Q��-���ҥ��`�|���J = �Q�����J*�Q���X���ҥ����/100
		//System.out.println("�Q���X���ҥ����:"+lawPercentRef.getInta().divide(new BigDecimal(100)));
		BigDecimal intA = intTax.multiply(lawPercentRef.getInta()).divide(new BigDecimal(100),0,4);
//		BigDecimal intA = intTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100),0,4);
		//System.out.println("�Q��-���ҥ��`�|���J:"+intA);

		//���ҥ��`�|���J = ��|-���ҥ��`�|���J + �a��-���ҥ��`�|���J + �Q��-���ҥ��`�|���J
//		BigDecimal totalA = nationA.add(localA).add(intA);
		//System.out.println("���ҥ��`�|���J:"+totalA);

		// ��|-�����`�|���J = ��|���J*��|�X�������/100
		//System.out.println("��|�X�������:"+lawPercentRef.getNationb().divide(new BigDecimal(100)));
		BigDecimal nationB = nationTax.multiply(lawPercentRef.getNationb()).divide(new BigDecimal(100),0,4);
//		BigDecimal nationB = nationTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		//System.out.println("��|-�����`�|���J:"+nationB);
		// �a��-�����`�|���J = �a�覬�J*�a��|�X�������/100
		//System.out.println("�a��|�X�������:"+lawPercentRef.getLocalb().divide(new BigDecimal(100)));
		BigDecimal localB = localTax.multiply(lawPercentRef.getLocalb()).divide(new BigDecimal(100),0,4);
//		BigDecimal localB = localTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		//System.out.println("�a��-�����`�|���J:"+localB);
		// �Q��-�����`�|���J = �Q�����J*�Q���X�������/100
		//System.out.println("�Q���X�������:"+lawPercentRef.getIntb().divide(new BigDecimal(100)));
		BigDecimal intB = intTax.multiply(lawPercentRef.getIntb()).divide(new BigDecimal(100),0,4);
//		BigDecimal intB = intTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100),0,4);
		//System.out.println("�Q��-�����`�|���J:"+intB);

		//�����`�|���J = ��|-�����`�|���J + �a��-�����`�|���J + �Q��-�����`�|���J
//		BigDecimal totalB = nationB.add(localB).add(intB);
		//System.out.println("�����`�|���J:"+totalB);

		// ��|-�m���`�|���J = ��|���J*��|�X�m�����/100
		//System.out.println("��|�X�m�����:"+lawPercentRef.getNationc().divide(new BigDecimal(100)));
		BigDecimal nationC = nationTax.multiply(lawPercentRef.getNationc()).divide(new BigDecimal(100),0,4);
//		BigDecimal nationC = nationTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		//System.out.println("��|-�m���`�|���J:"+nationC);
		// �a��-�m���`�|���J = �a�覬�J*�a��|�X�m�����/100
		//System.out.println("�a��|�X�m�����:"+lawPercentRef.getLocalc().divide(new BigDecimal(100)));
		BigDecimal localC = localTax.multiply(lawPercentRef.getLocalc()).divide(new BigDecimal(100),0,4);
//		BigDecimal localC = localTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		//System.out.println("�a��-�m���`�|���J:"+localC);
		// �Q��-�m���`�|���J = �Q�����J*�Q���X�m�����/100
		//System.out.println("�Q���X�m�����:"+lawPercentRef.getIntc().divide(new BigDecimal(100)));
		BigDecimal intC = intTax.multiply(lawPercentRef.getIntc()).divide(new BigDecimal(100),0,4);
//		BigDecimal intC = intTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100),0,4);
		//System.out.println("�Q��-�m���`�|���J:"+intC);

		//�m���`�|���J = ��|-�m���`�|���J + �a��-�m���`�|���J + �Q��-�m���`�|���J
//		BigDecimal totalC = nationC.add(localC).add(intC);
		//System.out.println("�m���`�|���J:"+intC);

		BigDecimal fillA = new BigDecimal(0);
		BigDecimal fillB = new BigDecimal(0);
		BigDecimal fillC = new BigDecimal(0);
		if("2".equals(taxKind))
		{
			//���ҥ������ɪ��B = �����ɪ��B*��|�X���ҥ����/100
			fillA = fillAmount.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
			//���������ɪ��B = �����ɪ��B*��|�X�������/100
			fillB = fillAmount.multiply(lawPercentRef.getNationb()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//			fillB = fillAmount.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
			//�m�������ɪ��B = �����ɪ��B*��|�X�m�����/100
			fillC = fillAmount.multiply(lawPercentRef.getNationc()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//			fillC = fillAmount.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
		}
		
		//�I�sUnitInfoMainDAO.findAll()��X�Ҧ��������
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
			//�����ɪ��B���W�~�פ��t��v
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
				//���ҥ�
				//System.out.println("���ҥ�:"+unitPercentDet.getTpercent().divide(new BigDecimal(100)));
				allMoney = ((nationA.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(localA.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(intA.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)));
				//�����ɪ��B
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
				//����
				//System.out.println("����:"+unitPercentDet.getTpercent().divide(new BigDecimal(100)));
				allMoney = ((nationB.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(localB.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(intB.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)));
				//�����ɪ��B
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
				//�m��
//				System.out.println("�m��:"+unitPercentDet.getTpercent().divide(new BigDecimal(100)));
				allMoney = ((nationC.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(localC.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(intC.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)));
				//�����ɪ��B
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
			//System.out.println("�`�B:"+allMoney);
			
			returnDecimal = returnDecimal.add(allMoney); 
		}		
		return (null!=returnDecimal?returnDecimal:new BigDecimal(0));
	}
	/**
	 * �մ�ἷ�I���B
	 * �H�~�סB����B���O��X�k�w���t��Ҷi���|���J�B�a�覬�J�ΧQ�����J�պ�
	 * @param taxYear �~��
	 * @param taxMonth ���
	 * @param taxKind ���O
	 * @param nationTax ��|���J
	 * @param localTax �a�覬�J
	 * @param intTax �Q�����J
	 * @return Double �w�w���I���B�`�M
	 * @throws HibernateException
	 */
	public static BigDecimal tryCountAmountUpd(String taxYear, String taxMonth, String taxKind,
			BigDecimal nationTax,BigDecimal localTax,BigDecimal intTax,String usrId, BigDecimal nationRate, 
			BigDecimal localRate, BigDecimal intRate)
			throws HibernateException {

		LawPercentRefDAO lawPercentRefDAO = new LawPercentRefDAO();
		LawPercentRef lawPercentRef = lawPercentRefDAO.get(1);
		
		BigDecimal returnDecimal = new BigDecimal(0);
		
		//�`�|�� = ��|���J + �a�覬�J + �Q�����J
		/**Chris wu 
		 * �k�w���t��Ҧ��ק�
		 * Nationa--��|
		 * Nationb--��|(�ո`�B)
		 * Nationc--�S���@��
		 * Locala--�Q��
		 * Localb--�Q��(�ո`�B)
		 * Localc--�S���@��
		 * Inta--�S���@��
		 * Intb--�S���@��
		 * Intc--�S���@��
		 */

		// ��|-���ҥ��`�|���J = ��|���J*��|�X���ҥ����/100
		BigDecimal nationA = nationTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		// �a��-���ҥ��`�|���J = �a�覬�J*�a��|�X���ҥ����/100
		BigDecimal localA = localTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100),0,4);
//		BigDecimal localA = localTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		// �Q��-���ҥ��`�|���J = �Q�����J*�Q���X���ҥ����/100
		BigDecimal intA = intTax.multiply(lawPercentRef.getInta()).divide(new BigDecimal(100),0,4);
//		BigDecimal intA = intTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100),0,4);
		//System.out.println("�Q��-���ҥ��`�|���J:"+intA);

		// ��|-�����`�|���J = ��|���J*��|�X�������/100
		BigDecimal nationB = nationTax.multiply(lawPercentRef.getNationb()).divide(new BigDecimal(100),0,4);
//		BigDecimal nationB = nationTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		// �a��-�����`�|���J = �a�覬�J*�a��|�X�������/100
		BigDecimal localB = localTax.multiply(lawPercentRef.getLocalb()).divide(new BigDecimal(100),0,4);
//		BigDecimal localB = localTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		// �Q��-�����`�|���J = �Q�����J*�Q���X�������/100
		BigDecimal intB = intTax.multiply(lawPercentRef.getIntb()).divide(new BigDecimal(100),0,4);
//		BigDecimal intB = intTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100),0,4);

		// ��|-�m���`�|���J = ��|���J*��|�X�m�����/100
		BigDecimal nationC = nationTax.multiply(lawPercentRef.getNationc()).divide(new BigDecimal(100),0,4);
//		BigDecimal nationC = nationTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		// �a��-�m���`�|���J = �a�覬�J*�a��|�X�m�����/100
		BigDecimal localC = localTax.multiply(lawPercentRef.getLocalc()).divide(new BigDecimal(100),0,4);
//		BigDecimal localC = localTax.multiply(lawPercentRef.getNationa()).divide(new BigDecimal(100),0,4);
		// �Q��-�m���`�|���J = �Q�����J*�Q���X�m�����/100
		BigDecimal intC = intTax.multiply(lawPercentRef.getIntc()).divide(new BigDecimal(100),0,4);
//		BigDecimal intC = intTax.multiply(lawPercentRef.getLocala()).divide(new BigDecimal(100),0,4);
		
		//�I�sUnitInfoMainDAO.findAll()��X�Ҧ��������
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
				//���ҥ�
				allMoney = ((nationA.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(localA.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(intA.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)));
				allMoney = allMoney.multiply(nationRate.divide(new BigDecimal(100))).setScale(0,BigDecimal.ROUND_HALF_UP);
			}
			else if( "02".equals( unitInfoMain.getGroupid() ) ){
				//����
				allMoney = ((nationB.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(localB.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(intB.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)));
				allMoney = allMoney.multiply(localRate.divide(new BigDecimal(100))).setScale(0,BigDecimal.ROUND_HALF_UP);
			}
			else if( "03".equals( unitInfoMain.getGroupid() ) ){
				//�m��
				allMoney = ((nationC.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(localC.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)).add(intC.multiply(tpercent).setScale(0,BigDecimal.ROUND_HALF_UP)));
				allMoney = allMoney.multiply(intRate.divide(new BigDecimal(100))).setScale(0,BigDecimal.ROUND_HALF_UP);
			}
			
			returnDecimal = returnDecimal.add(allMoney);
		}		
		return (null!=returnDecimal?returnDecimal:new BigDecimal(0));
	}
	/**
	 * ���o�̤j�~�ת����
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
	 * ���o�w���t�L���~��
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
