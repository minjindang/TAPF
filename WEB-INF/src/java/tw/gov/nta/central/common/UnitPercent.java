/*
 * �b 2006/2/20 �إ�
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ��ɮת��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
package tw.gov.nta.central.common;

import gov.dnt.tame.common.LabelValueBean;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts.upload.FormFile;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import tw.gov.nta.sql.UnitInfoMain;
import tw.gov.nta.sql.UnitPercentDet;
import tw.gov.nta.sql.dao.UnitInfoMainDAO;
import tw.gov.nta.sql.dao.UnitPercentDetDAO;

/**
 * @author Mindy
 * UnitPercent�������t��Ҹ�ƪ���
 * TODO ���Ѩt�ξާ@�������t��Ҹ��(�s�W�B�ק�B�R���B�d��)�@�~�C
 */
public class UnitPercent 
{
	/**
	 * �̷ӶǤJ�Ѽ�(������)�s�W�ܳ������t��Ҹ����
	 * @param unitPercentDet
	 * @return �^�Ƿs�W��ӵ���ƥD���
	 * @throws HibernateException
	 */
	public static int creat(UnitPercentDet unitPercentDet) throws HibernateException
	{
		UnitPercentDetDAO dao = new UnitPercentDetDAO();
		Integer pk = dao.save(unitPercentDet);
		return pk.intValue();
	}

	/**
	 * �R���������t��Ҹ��
	 * @param id
	 * @throws HibernateException
	 */
	public static void delete(int id) throws HibernateException
	{
		UnitPercentDetDAO dao = new UnitPercentDetDAO();
		dao.delete(new Integer(id));
	}

	/**
	 * �H�D��ȶǦ^�ҹ����������t��Ҹ��
	 * @param id
	 * @return UnitPercentDet
	 * @throws HibernateException
	 */
	public static UnitPercentDet get(int id) throws HibernateException
	{
		UnitPercentDetDAO dao = new UnitPercentDetDAO();
		UnitPercentDet unitPercentDet = dao.get(new Integer(id));
		return unitPercentDet;
	}

	/**
	 * �HPK�d�ߩҹ������������t��Ҹ��
	 * @param unitPercentDet
	 * @return List
	 * @throws HibernateException
	 */
	public static UnitPercentDet getByYear(UnitInfoMain unitInfo , String tyear){
		UnitPercentDetDAO dao = new UnitPercentDetDAO();
		Criteria criteria = dao.getSession().createCriteria(UnitPercentDet.class);
		criteria.add(Expression.eq("unitInfo", unitInfo));
		if(tyear.trim().length()==0)
			tyear = getMaxYear(unitInfo);
		criteria.add(Expression.eq("tyear", tyear));
		if(criteria.list().size() > 0 )
			return (UnitPercentDet)criteria.list().get(0);
		else
			return new UnitPercentDet();
	}
	public static UnitPercentDet getByYear(UnitInfoMain unitInfo){
		return getByYear(unitInfo ,"");
	}
	public static String getMaxYear(UnitInfoMain unitInfo) throws HibernateException
	{
		UnitPercentDetDAO dao = new UnitPercentDetDAO();
		Criteria criteria = dao.getSession().createCriteria(UnitPercentDet.class);
		criteria.setProjection(Projections.max("tyear"));
		criteria.add(Expression.eq("unitInfo", unitInfo));
		//criteria.setProjection(Projections.groupProperty("tyear"));
		//criteria.addOrder(Order.asc("tyear"));
		return (String) criteria.list().get(0);
	}
	
//	public static BigDecimal getPercentByYear(UnitPercentDet unitPercentDet,String Year) throws HibernateException
//	{
//		UnitPercentDetDAO dao = new UnitPercentDetDAO();
//		Criteria criteria = dao.getSession().createCriteria(UnitPercentDet.class);
//		criteria.add(Expression.eq("unitInfo", unitPercentDet.getUnitInfo()));
//		criteria.add(Expression.eq("tyear", Year));
//		if(criteria.list().size()!= 0){
//			unitPercentDet = (UnitPercentDet)criteria.list().iterator().next();
//			List list = (List)getByYear(unitPercentDet);
//			if(list != null){
//				for(Iterator it = list.iterator();it.hasNext();){
//					UnitPercentDet dto = (UnitPercentDet)it.next();
//					if(dto != null){
//						return dto.getTpercent();
//					}
//				}
//			}
//		}
//		return null;
//	}
	
	/**
	 * �H�~�׬d�ߩҹ������������t��Ҹ��
	 * @param unitPercentDet
	 * @return List
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public static List<UnitPercentDet> getByYear(UnitPercentDet unitPercentDet) throws HibernateException
	{
		UnitPercentDetDAO dao = new UnitPercentDetDAO();
		Criteria criteria = dao.getSession().createCriteria(UnitPercentDet.class);

		if ((null != unitPercentDet.getUnitInfo()) && (!"".equals(unitPercentDet.getUnitInfo())))
			criteria.add(Expression.eq("unitInfo", unitPercentDet.getUnitInfo()));
		if ((null != unitPercentDet.getTyear()) && (!"".equals(unitPercentDet.getTyear())))
			criteria.add(Expression.eq("tyear", unitPercentDet.getTyear()));
		criteria.addOrder(Order.asc("tyear"));
		return criteria.list();
	}

	/**
	 * �H�~�׬d�ߩҹ������������t��Ҹ��(����)
	 * @param unitPercentDet
	 * @param pagenum
	 * @param PAGE_SIZE
	 * @return List
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public static List<UnitPercentDet> getByYear(UnitPercentDet unitPercentDet,int pagenum,int PAGE_SIZE) throws HibernateException
	{
		UnitPercentDetDAO dao = new UnitPercentDetDAO();
		Criteria criteria = dao.getSession().createCriteria(UnitPercentDet.class);
        criteria.setMaxResults(PAGE_SIZE);
        criteria.setFirstResult(PAGE_SIZE*pagenum);
		if ((null != unitPercentDet.getUnitInfo()) && (!"".equals(unitPercentDet.getUnitInfo())))
			criteria.add(Expression.eq("unitInfo", unitPercentDet.getUnitInfo()));
		if ((null != unitPercentDet.getTyear()) && (unitPercentDet.getTyear().trim().length()>0))
			criteria.add(Expression.eq("tyear", unitPercentDet.getTyear()));
		criteria.addOrder(Order.asc("tyear"));
		return criteria.list();
	}

	/**
	 * �N�ҫ��w������ɦs��Unit_percent_det�����
	 * @param tyear
	 * @param file
	 * @throws Exception
	 */
	public static void importData(String tyear,List list)
	{
		UnitPercentDet unitPercentDet = new UnitPercentDet();
		unitPercentDet.setTyear( tyear );
		System.out.println(tyear);
		List unitPercentDetList = getByYear(unitPercentDet);
		//�R���즳���
		for(Iterator it=unitPercentDetList.iterator();it.hasNext();)
		{
			UnitPercentDet unitPercentDets = (UnitPercentDet) it.next();
			delete(unitPercentDets.getId());
		}

		UnitInfoMainDAO unitInfoMainDAO = new UnitInfoMainDAO();
		List unitInfoMainList = unitInfoMainDAO.findAll();
		for(Iterator it=unitInfoMainList.iterator();it.hasNext();)
		{
			UnitInfoMain unitInfoMain = (UnitInfoMain) it.next();
			if(unitInfoMain!=null)
			{
				for(Iterator it2=list.iterator();it2.hasNext();)
				{
					Map parm = (LinkedHashMap) it2.next();
		
					if( unitInfoMain.getUnitName().trim().equals( parm.get("name") ) )
					{
//						System.out.println("===="+"�פJ�a�W:"+parm.get("name")+",�פJ����:"+((String) parm.get("name")).length()+"====");
						UnitPercentDet newUnitPercentDet = new UnitPercentDet();
						newUnitPercentDet.setUnitInfo( unitInfoMain );
						newUnitPercentDet.setCreateDate( new Date() );
						newUnitPercentDet.setModDate( new Date() );
						newUnitPercentDet.setUsrid("TAPF");
						newUnitPercentDet.setTyear( tyear );
			

						if (!parm.get("percent1").toString().equals("0E-16"))
						{
//							System.out.println("���ҥ� & �m�� : "+parm.get("name")+",���t���:"+parm.get("percent1")+",���t���B�G"+parm.get("money1"));
							newUnitPercentDet.setTpercent( ((BigDecimal) parm.get("percent1")) );
							
						}
						else if(parm.get("percent1").toString().equals("0E-16"))
						{
//							System.out.println("����:"+parm.get("name")+",���t���:"+parm.get("percent2")+",���t���B�G"+parm.get("money2"));
							newUnitPercentDet.setTpercent( ((BigDecimal) parm.get("percent2")) );
						}
						
//						newUnitPercentDet.setTpercent( ((BigDecimal) parm.get("value")) );
						
						
						creat(newUnitPercentDet);
					}
				}
			}
		}
    }
	
	/**
	 * �N�ҫ��w������ɦs��Unit_percent_det�����
	 * @param tyear
	 * @param file
	 * @return 
	 * @throws Exception
	 */
	public static Boolean checkDate(List list)
	{
		Boolean isImport = true;

		UnitInfoMainDAO unitInfoMainDAO = new UnitInfoMainDAO();
		List unitInfoMainList = unitInfoMainDAO.findAll();
		
		for(Iterator it=unitInfoMainList.iterator();it.hasNext();)
		{
			UnitInfoMain unitInfoMain = (UnitInfoMain) it.next();
			if(unitInfoMain!=null)
			{
				for(Iterator it2=list.iterator();it2.hasNext();)
				{
					Map parm = (LinkedHashMap) it2.next();
										
					//�P�_�O�_�b����Ҧ����t���
					if( unitInfoMain.getUnitName().trim().equals( parm.get("name") ) && !(parm.get("percent2") == null))
					//�ק��0980205
//					if( unitInfoMain.getUnitName().trim().equals( parm.get("name")))
					{
						if (!parm.get("percent1").toString().equals("0E-16") && !parm.get("percent2").toString().equals("0E-16"))
//						if (parm.get("percent1").toString().equals("0E-16"))
						{
							isImport = false;
							return isImport;
						}
					}
				}
			}
		}
		
		return isImport;
		
	}

	/**
	 * �N�ҫ��w���~�ת��������t��Ҹ�ơA�ÿ�X���ɮפW
	 * @param tyear
	 * @param file
	 * @throws Exception
	 */
	public static void exportData(String tyear,FormFile file)
            throws Exception
	{
		System.out.println("tyear========>"+ tyear);       
		System.out.println("fileName========>"+ file.getFileName());
    }
	
	/**
	 * @param file
	 * @return List
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static List parseExcel(FormFile file) throws FileNotFoundException, IOException
	{
		List<LinkedHashMap> list = new LinkedList<LinkedHashMap>();
		POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		
		//Ū��excel��sheet
		for(int i=0;i<wb.getNumberOfSheets();i++)
		{
		    HSSFSheet sheet = wb.getSheetAt(i);
		    
		    //�v��Ū��sheet�������
		    for(Iterator it=sheet.rowIterator();it.hasNext();)
		    {
		    	HSSFRow row = (HSSFRow) it.next();
		    	Map<String,Object> map = new LinkedHashMap<String,Object>();
		    	for(int j=0;j<row.getRowNum();j++)
		    	{
		    		HSSFCell cell = row.getCell((short)j);
		    		
		    		if (cell != null)
				    {
		    			
						switch( cell.getCellType() )
						{
							case HSSFCell.CELL_TYPE_STRING:
								String name = cell.getStringCellValue();
//								if( 3<name.length() )
//									name = name.substring( name.length()-3,name.length() );
								map.put("name",name.trim());
								System.out.println("name �G " + map.get("name"));
								break;
							case HSSFCell.CELL_TYPE_NUMERIC:

								//map.put("value", (new BigDecimal(cell.getNumericCellValue())).setScale(10,BigDecimal.ROUND_CEILING).multiply( new BigDecimal(100) ));
								if (cell.getCellNum() == 1)
								{
									map.put("percent1", (new BigDecimal(cell.getNumericCellValue())).setScale(16,BigDecimal.ROUND_CEILING));
									System.out.println("percent1.cell.getNumericCellValue �G  " + cell.getNumericCellValue());
									System.out.println("percent1 �G " + map.get("percent1"));
								}
								//��@���ҡA�n�����U�C�T�q��if
								if (cell.getCellNum() == 2)
								{
									map.put("money1", (new BigDecimal(cell.getNumericCellValue())).setScale(16,BigDecimal.ROUND_CEILING));
									System.out.println("money1 �G " + map.get("money1"));
								}
								
								if (cell.getCellNum() == 3)
								{
									map.put("percent2", (new BigDecimal(cell.getNumericCellValue())).setScale(16,BigDecimal.ROUND_CEILING));
									System.out.println("percent2.cell.getNumericCellValue �G " + cell.getNumericCellValue());
									System.out.println("percent2 �G " + map.get("percent2"));
								}
								
								if (cell.getCellNum() == 4)
								{
									map.put("money2", (new BigDecimal(cell.getNumericCellValue())).setScale(16,BigDecimal.ROUND_CEILING));
									System.out.println("money2 �G " + map.get("money2"));
								}
								
								break;							
							default:
								break;
				    	}
				    }
				}
				if( null != map.get("name") )
					list.add((LinkedHashMap) map);
		    }
		}
		return list;
	}
	public static List<LabelValueBean> getYearLabelList() throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
        UnitPercentDetDAO dao = new UnitPercentDetDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(UnitPercentDet.class);
        //criteria.setProjection(Projections.projectionList().add(Projections.property("allYear")).add(Projections.property("allMonth")));
        criteria.setProjection(Projections.groupProperty("tyear"));
        criteria.addOrder(Order.desc("tyear"));
        List collection = criteria.list();
        System.out.println(collection);
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	//UnitPercentDet dto = (UnitPercentDet) it.next();
            	String year = (String)it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(year);
            	labelValueBean.setValuess(year);
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;
	}
}
