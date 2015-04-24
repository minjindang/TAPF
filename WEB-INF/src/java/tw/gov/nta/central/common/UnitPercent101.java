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
import tw.gov.nta.sql.UnitPercentDet101;
import tw.gov.nta.sql.dao.UnitInfoMainDAO;
import tw.gov.nta.sql.dao.UnitPercentDet101DAO;

/**
 * @author Powen Hsueh
 * UnitPercent101�������t��Ҹ�ƪ���
 * TODO ���Ѩt�ξާ@�������t��Ҹ��(�s�W�B�ק�B�R���B�d��)�@�~�C
 */
public class UnitPercent101 {
	/**
	 * �̷ӶǤJ�Ѽ�(������)�s�W�ܳ������t��Ҹ����
	 * @param unitPercentDet101
	 * @return �^�Ƿs�W��ӵ���ƥD���
	 * @throws HibernateException
	 */
	public static int creat(UnitPercentDet101 unitPercentDet101) throws HibernateException
	{
		UnitPercentDet101DAO dao = new UnitPercentDet101DAO();
		Integer pk = dao.save(unitPercentDet101);
		return pk.intValue();
	}

	/**
	 * �R���������t��Ҹ��
	 * @param id
	 * @throws HibernateException
	 */
	public static void delete(int id) throws HibernateException
	{
		UnitPercentDet101DAO dao = new UnitPercentDet101DAO();
		dao.delete(new Integer(id));
	}

	/**
	 * �H�D��ȶǦ^�ҹ����������t��Ҹ��
	 * @param id
	 * @return UnitPercentDet101
	 * @throws HibernateException
	 */
	public static UnitPercentDet101 get(int id) throws HibernateException
	{
		UnitPercentDet101DAO dao = new UnitPercentDet101DAO();
		UnitPercentDet101 unitPercentDet101 = dao.get(new Integer(id));
		return unitPercentDet101;
	}

	/**
	 * �HPK�d�ߩҹ������������t��Ҹ��
	 * @param unitPercentDet101
	 * @return List
	 * @throws HibernateException
	 */
	public static UnitPercentDet101 getByYear(UnitInfoMain unitInfo , String tyear){
		UnitPercentDet101DAO dao = new UnitPercentDet101DAO();
		Criteria criteria = dao.getSession().createCriteria(UnitPercentDet101.class);
		criteria.add(Expression.eq("unitInfo", unitInfo));
		if(tyear.trim().length()==0)
			tyear = getMaxYear(unitInfo);
		criteria.add(Expression.eq("tyear", tyear));
		if(criteria.list().size() > 0 )
			return (UnitPercentDet101)criteria.list().get(0);
		else
			return new UnitPercentDet101();
	}
	
	public static UnitPercentDet101 getByYear(UnitInfoMain unitInfo){
		return getByYear(unitInfo ,"");
	}
	
	public static String getMaxYear(UnitInfoMain unitInfo) throws HibernateException
	{
		UnitPercentDet101DAO dao = new UnitPercentDet101DAO();
		Criteria criteria = dao.getSession().createCriteria(UnitPercentDet101.class);
		criteria.setProjection(Projections.max("tyear"));
		criteria.add(Expression.eq("unitInfo", unitInfo));
		return (String) criteria.list().get(0);
	}
	
	
	/**
	 * �H�~�׬d�ߩҹ������������t��Ҹ��
	 * @param unitPercentDet101
	 * @return List
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public static List<UnitPercentDet101> getByYear(UnitPercentDet101 unitPercentDet101) throws HibernateException
	{
		UnitPercentDet101DAO dao = new UnitPercentDet101DAO();
		Criteria criteria = dao.getSession().createCriteria(UnitPercentDet101.class);
		if ((null != unitPercentDet101.getUnitInfo()) && (!"".equals(unitPercentDet101.getUnitInfo())))
			criteria.add(Expression.eq("unitInfo", unitPercentDet101.getUnitInfo()));
		if ((null != unitPercentDet101.getTyear()) && (!"".equals(unitPercentDet101.getTyear())))
			criteria.add(Expression.eq("tyear", unitPercentDet101.getTyear()));
		criteria.addOrder(Order.asc("tyear"));
		return criteria.list();
	}

	/**
	 * �H�~�׬d�ߩҹ������������t��Ҹ��(����)
	 * @param unitPercentDet101
	 * @param pagenum
	 * @param PAGE_SIZE
	 * @return List
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public static List<UnitPercentDet101> getByYear(UnitPercentDet101 unitPercentDet101,int pagenum,int PAGE_SIZE) throws HibernateException
	{
		UnitPercentDet101DAO dao = new UnitPercentDet101DAO();
		Criteria criteria = dao.getSession().createCriteria(UnitPercentDet101.class);
        criteria.setMaxResults(PAGE_SIZE);
        criteria.setFirstResult(PAGE_SIZE*pagenum);
		if ((null != unitPercentDet101.getUnitInfo()) && (!"".equals(unitPercentDet101.getUnitInfo())))
			criteria.add(Expression.eq("unitInfo", unitPercentDet101.getUnitInfo()));
		if ((null != unitPercentDet101.getTyear()) && (unitPercentDet101.getTyear().trim().length()>0))
			criteria.add(Expression.eq("tyear", unitPercentDet101.getTyear()));
		criteria.addOrder(Order.asc("tyear"));
		return criteria.list();
	}

	/**
	 * �N�ҫ��w������ɦs��Unit_percent_det_101�����
	 * @param tyear
	 * @param file
	 * @throws Exception
	 */
	public static void importData(String tyear,List list)
	{
		UnitPercentDet101 unitPercentDet101 = new UnitPercentDet101();
		unitPercentDet101.setTyear( tyear );
		List unitPercentDet101List = getByYear(unitPercentDet101);
		//�R���즳���
		for(Iterator it=unitPercentDet101List.iterator();it.hasNext();)
		{
			UnitPercentDet101 unitPercentDets101 = (UnitPercentDet101) it.next();
			delete(unitPercentDets101.getId());
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
						UnitPercentDet101 newUnitPercentDet101 = new UnitPercentDet101();
						newUnitPercentDet101.setUnitInfo( unitInfoMain );
						newUnitPercentDet101.setModDate( new Date() );
						newUnitPercentDet101.setUsrid("TAPF");
						newUnitPercentDet101.setTyear( tyear );

						//if (!parm.get("percent1").toString().equals("0E-16"))
						//{
							
							newUnitPercentDet101.setTpercent( ((BigDecimal) parm.get("percent1")) );
						//}						
						//else if(parm.get("percent1").toString().equals("0E-16"))
						//{
							//System.out.println("����:"+parm.get("name")+",���t���:"+parm.get("percent2")+",���t���B�G"+parm.get("money2"));
							//newUnitPercentDet101.setTpercent( ((BigDecimal) parm.get("percent2")) );
						//}
						if(parm.get("money1") != null)
							newUnitPercentDet101.setFinancial( ((BigDecimal) parm.get("money1")) );
						else
							newUnitPercentDet101.setFinancial(BigDecimal.ZERO);
						//System.out.println("���ҥ� & �m�� : "+newUnitPercentDet101.getUnitInfo()+",���t���:"+newUnitPercentDet101.getTpercent()+",���t���B�G"+newUnitPercentDet101.getFinancial());
//						newUnitPercentDet.setTpercent( ((BigDecimal) parm.get("value")) );
						
						
						creat(newUnitPercentDet101);
					}
				}
			}
		}
    }
	
	/**
	 * �N�ҫ��w������ɦs��Unit_percent_det_101�����
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
									//System.out.println("percent1.cell.getNumericCellValue �G  " + cell.getNumericCellValue());
									//System.out.println("percent1 �G " + map.get("percent1"));
								}
								//��@���ҡA�n�����U�C�T�q��if
								else if (cell.getCellNum() == 2)
								{
									map.put("money1", (new BigDecimal(cell.getNumericCellValue())).setScale(16,BigDecimal.ROUND_CEILING));
									//System.out.println("money1 �G " + map.get("money1"));
								}
								
								//if (cell.getCellNum() == 3)
								//{
									//map.put("percent2", (new BigDecimal(cell.getNumericCellValue())).setScale(16,BigDecimal.ROUND_CEILING));
									//System.out.println("percent2.cell.getNumericCellValue �G " + cell.getNumericCellValue());
									//System.out.println("percent2 �G " + map.get("percent2"));
								//}
								
								//if (cell.getCellNum() == 4)
								//{
									//map.put("money2", (new BigDecimal(cell.getNumericCellValue())).setScale(16,BigDecimal.ROUND_CEILING));
									//System.out.println("money2 �G " + map.get("money2"));
								//}
								
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
        UnitPercentDet101DAO dao = new UnitPercentDet101DAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(UnitPercentDet101.class);
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
