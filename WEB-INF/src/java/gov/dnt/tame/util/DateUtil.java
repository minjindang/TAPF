package gov.dnt.tame.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil
{
    private static SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
    private static SimpleDateFormat YYYYMMDDhhmmss = new SimpleDateFormat("yyyyMMddhhmmss");

    public static int getYear(Date date)
    {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
    }
    
    public static int getMonth(Date date)
    {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
    }

    public static int getDate(Date date)
    {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static int getDay(Date date)
    {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
    }
    
    public static int getHours(Date date)
    {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
    	return cal.get(Calendar.HOUR_OF_DAY);
    }
    
    public static int getMinutes(Date date)
    {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
    	return cal.get(Calendar.MINUTE);
    }
    
    public static int getSeconds(Date date)
    {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
    	return cal.get(Calendar.SECOND);
    }

	/**
	 * �r������ string(yyyyMMddhhmmss, yyyMMddhhmmss) -> date
	 * @param str
	 * @return Date
	 */
	public static Date str2Time(String str)
	{
    	Date date;
		try{
			if( null == str ) throw new Exception("str is null");
			if( "".equals(str) ) throw new Exception("str is blank");
			
        	if (13 == str.length())	str	=	ROCDate2Date(str.substring(0,7))+str.substring(7,13);
       	date = YYYYMMDDhhmmss.parse(str);

		}catch(Exception e){
            return null;
		}
		return date;            
    }

    /**
	 * �r������ string(yyyyMMdd, yyyMMdd) -> date
	 * @param str
	 * @return Date
	 */
	public static Date str2Date(String str)
	{
    	Date date;
		try{
			if( null == str ) throw new Exception("str is null");
			if( "".equals(str) ) throw new Exception("str is blank");
			
        	if (7 == str.length())	str	=	ROCDate2Date(str);
        	date = YYYYMMDD.parse(str);

		}catch(Exception e){
            return null;
		}
		return date;            
    }

    /**
	 *�����r�� date -> string(yyyyMMdd)
	 */
    public static String date2Str(Date date)
    {
		return YYYYMMDD.format(date);
    }

    /**
	 *�����r��  + format yyyy/MM/dd, yyyy-MM-dd
	 *date -> string(yyyy/MM/dd, yyyy-MM-dd)
	 */
    public static String date2Str(Date date, String format)
    {
		return toStr(YYYYMMDD.format(date), format);
    }
    /**
	 * ��������~���r��
	 */
	public static String date2ChineseROC(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		Numeral2Chinese nc = new Numeral2Chinese();
		return (nc.format(cal.get(Calendar.YEAR)-1911) + "�~"
				+ nc.format(cal.get(Calendar.MONTH)+1) + "��"
				+ nc.format(cal.get(Calendar.DAY_OF_MONTH)) + "��"
				);
	}
	 /**
	 * ��������~���r�� �Ʀr��
	 */
	public static String date2ChineseROC2(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		return ((cal.get(Calendar.YEAR)-1911) + "�~"
				+ (cal.get(Calendar.MONTH)+1) + "��"
				+ (cal.get(Calendar.DAY_OF_MONTH)) + "��"
				);
	}
	/**
	 * ��������~���ɤ���r��
	 */
	public static String dateTime2ChineseROC(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		Numeral2Chinese nc = new Numeral2Chinese();
		return (nc.format(cal.get(Calendar.YEAR)-1911) + "�~"
				+ nc.format(cal.get(Calendar.MONTH)+1) + "��"
				+ nc.format(cal.get(Calendar.DAY_OF_MONTH)) + "��"
				+ nc.format(cal.get(Calendar.HOUR_OF_DAY)) + "��"
				+ nc.format(cal.get(Calendar.MINUTE)) + "��"
				+ nc.format(cal.get(Calendar.SECOND)) + "��"
						);
	}
	
	
	/**
	 * �����ROC�r�� date -> string(yyyMMddhhmmss)
	 * @param date
	 * @return String
	 */
	public static String time2ROCStr(Date date)
	{
		try{
			if (null == date) throw new Exception("date is null");
			return toROCStr(YYYYMMDDhhmmss.format(date));
		}catch(Exception e){
			return null;    		
		}
	}

	/**
	 * �����ROC�r�� date -> string(yyyMMdd)
	 * @param date
	 * @return String
	 */
	public static String date2ROCStr(Date date)
	{
		try{
			if (null == date) throw new Exception("date is null");
			return toROCStr(YYYYMMDD.format(date));
		}catch(Exception e){
			return null;    		
		}
	}

    /**
     * �����ROC�r�� + format yyy/mm/dd, yyy-mm-dd
     * date -> string(yyy/MM/dd, yyy-MM-dd)
     * @param date
     * @param format
     * @return String
     */
    public static String date2ROCStr(Date date, String format)
    {
    	try{
    		if( null==date ) throw new Exception("date is null");
			return toROCStr(YYYYMMDD.format(date), format);
    	}catch(Exception e){
    		return null;
    	}
    }

	/**
	 * ������
	 * @return String
	 */
	public static String ROCDate()
	{
		return date2ROCStr(new Date());
	}

    /**
     * ��������褸��� yyy/MM/dd -> yyyy/MM/dd
     * @param date
     * @return String
     */
    public static String ROCDate2Date(String date)
    {
    	try{
    		if(null==date) throw new Exception("date is null");
    		if( 7!=date.length() ) throw new Exception("date is not a vaild string");
    		return toStr(date);
    	}catch(Exception e){
    		return "";
    	}
    }

    /**
     * �褸���������� yyyy/MM/dd -> yyy/MM/dd
     * @param date
     * @return String
     */
    public static String date2ROCDate(String date)
    {
    	try{
    		if(null==date) throw new Exception("date is null");
    		if( 8!=date.length() ) throw new Exception("date is not a vaild string");
    		return toROCStr(date);
    	}catch(Exception e){
    		return "";
    	}
    }

	/**
	 * ����[�`�Ѽ� date(yyyyMMdd ; yyyMMdd) + day
	 */
	public static String dateIncrease(String date, int day)
	{
		String tempDay = "";
		if (8 == date.length())
		{
			tempDay = date.substring(6,8);
		}
		else if (7 == date.length())
		{
			tempDay = date.substring(5,7);
		}
		tempDay = String.valueOf(Integer.parseInt(tempDay) + day);
		//�ѼƬO��ƮɡA�[���G��
		if (1 == tempDay.length())
		{
            tempDay = "0" + tempDay;
		}
		if (8 == date.length())
		{
			tempDay = date.substring(0,6) + tempDay;
		}
		else if (7 == date.length())
		{
			tempDay = date.substring(0,5) + tempDay;
		}
		return tempDay;
	}

    private static String toROCStr(String date)
    {
		StringBuffer sb = new StringBuffer();
    	if ((null != date) && (8 == date.length()))
    	{
			String year = String.valueOf((Integer.parseInt
							(date.substring(0,4)) - 1911));
			if (2 == year.length())
			{
				sb.append("0");
			}
			sb.append(year);
			sb.append(date.substring(4,6));
			sb.append(date.substring(6,8));
		}
		return sb.toString();
	}
    /**
     * by eric chen
     * @param date
     * @return 0950101 12:12:12
     */
    public static String toDateTimeRoc(Date date)
    {
		StringBuffer sb = new StringBuffer();
    	if ((null != date))
    	{
			String year = String.valueOf(Integer.parseInt((date.toString()).substring(0,4))-1911);
			
			if (2 == year.length())
			{
				sb.append("0");
			}
			sb.append(year);
			sb.append(String.valueOf(date).substring(5,7));
			sb.append(String.valueOf(date).substring(8,10));
			sb.append(" ");
			sb.append(String.valueOf(date).substring(11,19));
		}
		return sb.toString();
	}
    private static String toROCStr(String date, String format)
    {
    	String temp = format;
    	if ((null != temp) && (0 != temp.length()))
    	{
	    	if ("/".equals(temp.substring(3,4)))
	    	{
				temp = temp.substring(3,4);
			}
			else
			{
                temp = temp.substring(3,4);
			}
		}

		StringBuffer sb = new StringBuffer();
    	if ((null != date) && (8 == date.length()))
    	{
			String year = String.valueOf((Integer.parseInt
							(date.substring(0,4)) - 1911));
			if (2 == year.length())
			{
				sb.append("0");
			}
			sb.append(year);
			sb.append(temp);
			sb.append(date.substring(4,6));
			sb.append(temp);
			sb.append(date.substring(6,8));
		}
		return sb.toString();
	}

    private static String toStr(String date)
    {
		StringBuffer sb = new StringBuffer();
    	if ((null != date) && (7 == date.length()))
    	{
			String year = String.valueOf((Integer.parseInt
							(date.substring(0,3)) + 1911));
			sb.append(year);
			sb.append(date.substring(3,5));
			sb.append(date.substring(5,7));
		}
		return sb.toString();
	}

    private static String toStr(String date, String format)
    {
    	String temp = format;
    	if ((null != temp) && (0 != temp.length()))
    	{
	    	if ("/".equals(temp.substring(4,5)))
	    	{
				temp = temp.substring(4,5);
			}
			else
			{
                temp = temp.substring(4,5);
			}
		}

		StringBuffer sb = new StringBuffer();
    	if ((null != date) && (8 == date.length()))
    	{
			sb.append(date.substring(0,4));
			sb.append(temp);
			sb.append(date.substring(4,6));
			sb.append(temp);
			sb.append(date.substring(6,8));
		}
		return sb.toString();
	}

	public static Date computeDueDate(Date fromDate, int days)
	{
    	long from = fromDate.getTime();
    	long interval = (long)days * 24 * 60 * 60 * 1000;
    	long due = from + interval;
    	Calendar dueDate = Calendar.getInstance();
    	dueDate.setTimeInMillis(due);
    	return dueDate.getTime();
	}

	/**
	 * �ǤJ yyymmdd �� yyyymmdd , �έn�W� + - year
	 */
	public static String dateFlipYear(String date, int year)
	{
		if(date.length() == 7)
		{
	        date = DateUtil.ROCDate2Date(date);
		}
		Calendar c = Calendar.getInstance();
		c.setTime(DateUtil.str2Date(date));
		c.add(Calendar.YEAR,year);

		return DateUtil.date2ROCStr(c.getTime());
	}

	/**
	 * �ǤJ yyymmdd �� yyyymmdd , �έn�W� + - month
	 */
	public static String dateFlipMonth(String date, int month)
	{
		if(date.length() == 7)
		{
	        date = DateUtil.ROCDate2Date(date);
		}
		Calendar c = Calendar.getInstance();
		c.setTime(DateUtil.str2Date(date));
		c.add(Calendar.MONTH,month);

		return DateUtil.date2ROCStr(c.getTime());
	}

	static public String get(String s){
		if(s==null){
			return "";
		}else{
			return s.trim();
		}
	}
	//  *********************************************
	//  ��ƥ\��G�Y�@����[�W�@�w��������Τ�Φ~
	//  �ѡ@�@�ơGsType�i�H�Od(Day),m(Month),y(Year); sNum�ƭ�; sdate�����yyymmdd
	//  �� �^ �ȡG�Ǧ^�[�W�S�w�������᪺���
	//  *********************************************    
    public static String getDateAdd(String sType, int sNum, String sdate) {
    	String rStr="";
     	if( get(sdate).length()==7){     		
    		GregorianCalendar g1 = new GregorianCalendar();
        	if (get(sType).equals("y")) {
        		g1.set(Integer.parseInt(sdate.substring(0,3))+1911+sNum,Integer.parseInt(sdate.substring(3,5))-1,Integer.parseInt(sdate.substring(5)));        		
        	} else if (get(sType).equals("m")) {
        		g1.set(Integer.parseInt(sdate.substring(0,3))+1911,Integer.parseInt(sdate.substring(3,5))-1+sNum,Integer.parseInt(sdate.substring(5)));
        	} else {
        		g1.set(Integer.parseInt(sdate.substring(0,3))+1911,Integer.parseInt(sdate.substring(3,5))-1,Integer.parseInt(sdate.substring(5))+sNum);
        	}	    	
            StringBuffer sb = new StringBuffer();
            int y = g1.get(GregorianCalendar.YEAR) - 1911;            
            int m = g1.get(GregorianCalendar.MONTH) + 1;
            int d = g1.get(GregorianCalendar.DATE);        
            if (y<=99){ sb.append("0"); }
            sb.append(Integer.toString(y));
            
            //King �쥻�L�P�_�j�p��A�Y��31��|�۰ʶi�����A���u������+1�ɨϥ�
            if (get(sType).equals("m") && Integer.parseInt(sdate.substring(5)) == 31 && d == 1 ){
            	m-=1;
            	d=30;
            }
            if (m<=9){ sb.append("0"); }
            sb.append(Integer.toString(m));
            if (d<=9){ sb.append("0"); }
            sb.append(Integer.toString(d));
            rStr = sb.toString();
     	}
     	return rStr;
    }
	
	/**
	 * �ǤJ�n�۴date���o�Ѽ�
	 * @param startDate
	 * @param endDate
	 * @return Integer
	 */
	public static Integer getDays(Date startDate, Date endDate)
	{ 
		long daterange = endDate.getTime() - startDate.getTime();
		long time = 1000*60 * 60 *24;
		return Long.valueOf(daterange/time).intValue();
	}

	/**
	 * ���o���̫�@�Ѫ����
	 * @param date
	 * @return Date
	 */
	public static Date getLastDateOfMonth(Date date)
	{
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DATE,lastDay);
		return calendar.getTime();
	}

	/**
	 * ���o���̫�@�Ѫ����
	 * @param year
	 * @param month
	 * @return String yyyMMdd
	 */
	public static String getLastDateOfMonth(String year,String month)
	{
		String date = "";
		int yy = Integer.parseInt(year)+1911;
		if(yy<1912) yy += 1911;
		int mm = Integer.parseInt(month)-1;

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(yy, mm, 1);
		
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		int yl = year.length();
		int ml = month.length();
		for(int i=3;i<yl;i++)
		{	year = "0"+year;	}
		
		for(int j=2;j<ml;j++)
		{	month = "0"+month;	}
		
		if( lastDay<10 ) date = "0"+ String.valueOf(lastDay);
		else date = String.valueOf(lastDay);
		return year+month+date;
	}
	/**
	 * �Ʀr123 �� ��r�@�G�T �[�U�d�ʤQ
	 * @param str1
	 * @return
	 */
	public static String numToChinese(String str1)
	{
		StringBuffer returnStr = new StringBuffer();
		StringBuffer returnStr2 = new StringBuffer();
		if(0 != str1.length())
		{	
			String[] myChinese = {"�s","�@","�G","�T","�|","��","��","�C","�K","�E"}; 
			for(int i =0 ;i<str1.length();i++)
			{	
				if("0".equals(str1.substring(i,i+1)) && 0 == i )
				{
					continue;
				}
				returnStr.append(myChinese[Integer.parseInt(str1.substring(i,i+1))]);
			}
			
			String[] words = {"","�Q","��","�d","�U","�Q�U","�ʸU","�d�U"};	
			for(int i = 1;i<=returnStr.length();i++)
			{		
				int tempvalue = returnStr.length()- i;
				if(!"�s".equals(returnStr.substring(i-1,i)))
				{	
						returnStr2.append(returnStr.substring(i-1,i));
						returnStr2.append(words[tempvalue]);
				}	
			}
		}
		return returnStr2.toString();
	}
	
	
    /**
     * �t�Τ��
     * @return Date
     */
    public static Date date()
    {	return new Date();	}
    /**
     * �t�Τ���ɶ�
     * @return String YYYMMDDhhmmss
     */
    public static String getSystemDateTime()
    {
		String returnDate = YYYYMMDDhhmmss.format(new Date());
		return toROCStr(returnDate.substring(0,8))+returnDate.substring(8);
    }
    /**
     * �t�Τ��
     * @return String YYYMMDD
     */
	public static String getSystemDate()
	{	return toROCStr(YYYYMMDDhhmmss.format(new Date()).substring(0,8));	}
    /**
     * �t�ήɶ�
     * @return String hhmmss
     */
	public static String getSystemTime()
	{	return YYYYMMDDhhmmss.format(new Date()).substring(8);	}
	
	/**
	 * 
	 * @param startDate �}�l���
	 * @param endDate   �������
	 * @return �}�l�쵲������ۮt�X�Ӥ� 2005/1/1 - 2006/2/15 �ۮt13�Ӥ�
	 */
	public static int getMonthBetween(Date startDate,Date endDate) {
        int yearBetween = DateUtil.getYear(endDate)- DateUtil.getYear(startDate);
        int monthBetween = DateUtil.getMonth(endDate) - DateUtil.getMonth(startDate);
        int monthPeriod = yearBetween * 12 + monthBetween;
        return monthPeriod;
	}
	
	public static String daycount(Date begDate,Date endDate,String mykey)
	{
		//begDate �_�l�ɶ�
		//endDate �����ɶ�
		//mykey A-> �~
		//      B-> ��
		//      C-> ��
		//      D-> �~,��
		//      E-> �~,��,��

		int year1 = 1911+Integer.parseInt(DateUtil.date2ROCStr(begDate).substring(0,3),10);
		int year2 = 1911+Integer.parseInt(DateUtil.date2ROCStr(endDate).substring(0,3),10);
		int mon1 = Integer.parseInt(DateUtil.date2ROCStr(begDate).substring(3,5),10);
		int mon2 = Integer.parseInt(DateUtil.date2ROCStr(endDate).substring(3,5),10);
		int day1 = Integer.parseInt(DateUtil.date2ROCStr(begDate).substring(5,7),10);
		int day2 = Integer.parseInt(DateUtil.date2ROCStr(endDate).substring(5,7),10);
		int pass = 1;
		
		String rtn = "";
		
		if (mykey=="A")
		{
			rtn = (Math.floor((year2-year1+(mon2-mon1)/12) * 100 + 0.5) / 100)+"�~";
		}
		
		if (mykey=="B")
		{
			rtn = Math.floor(((year2-year1)*12+mon2-mon1+(day2-day1)/30)* 100 + 0.5)+"��";
		}
		
		if (mykey=="C")
		{
//			Date begMyDate = new Date(year1, mon1-1, day1);
//			Date endMyDate = new Date(year2, mon2-1, day2);
//			rtn = (DateUtil.getDays(begMyDate,endDate)/86400000+"��");
			Calendar begMyC = Calendar.getInstance();
			Calendar EbegC = Calendar.getInstance();
			Calendar endMyC = Calendar.getInstance();
			Calendar SbegC = Calendar.getInstance();
			
			begMyC.set(year1,mon1,day1);
			EbegC.set(year1,12,31);
			endMyC.set(year2,mon2,day2);
			SbegC.set(year2,1,1);
			if (year1-year2==0)
			{
				rtn = String.valueOf((endMyC.getTimeInMillis()-begMyC.getTimeInMillis()) / 86400000 + 1 );
			}
			else
			{
				rtn = String.valueOf((EbegC.getTimeInMillis()-begMyC.getTimeInMillis()) / 86400000 + 1 )
					+((endMyC.getTimeInMillis()-SbegC.getTimeInMillis()) / 86400000 + 1 );
			}
		}
		
		if (mykey=="D")
		{
			if (mon2<mon1)
			{
				mon2 = mon2+12;
				year2= year2-1;
			}
			rtn = ((year2-year1)+"�~"+(mon2-mon1)+"��");
		}
		
		if (mykey=="E")
		{
			if (day2<day1)
			{
				if ((mon2==2)||(mon2==4)||(mon2==6)||(mon2==8)||(mon2==9)||(mon2==11)||(mon2==1)&&(pass==1))
				{
					day2 = day2+31;
					mon2 = mon2-1;
					if (mon2==0)
					{
						year2 = year2-1;
						mon2 = 12;	
					}
					pass = 0;
				}
		
				if ((mon2==5)||(mon2==7)||(mon2==10)||(mon2==12)&&(pass==1))
				{
					day2 = day2+30;
					mon2 = mon2-1;
					pass = 0;
				}
		
				if ((mon2==3)&&(pass==1))
				{
					boolean a =((year2%100==0)&&(year2%400!=0)||(year2%4!=0));
					if (a)
					{
						day2 = day2+28;
						mon2 = mon2-1;
					}else{
						day2 = day2+29;
						mon2 = mon2-1;
					}
					pass = 0;
				}
			}
			if (mon2<mon1)
			{
				mon2 = mon2+12;
				year2= year2-1;
			}
		
			rtn = ((year2-year1)+"�~"+(mon2-mon1)+"��"+(day2-day1)+"��");
		}
		if (mykey=="F")
		{

			if (day2<day1)
			{
				if ((mon2==2)||(mon2==4)||(mon2==6)||(mon2==8)||(mon2==9)||(mon2==11)||(mon2==1)&&(pass==1))
				{
					day2 = day2+31;
					mon2 = mon2-1;
					if (mon2==0)
					{
						year2 = year2-1;
						mon2 = 12;	
					}
					pass = 0;
				}
		
				if ((mon2==5)||(mon2==7)||(mon2==10)||(mon2==12)&&(pass==1))
				{
					day2 = day2+30;
					mon2 = mon2-1;
					pass = 0;
				}
		
				if ((mon2==3)&&(pass==1))
				{
					boolean a =((year2%100==0)&&(year2%400!=0)||(year2%4!=0));
					if (a)
					{
						day2 = day2+28;
						mon2 = mon2-1;
					}else{
						day2 = day2+29;
						mon2 = mon2-1;
					}
					pass = 0;
				}
			}
			if (mon2<mon1)
			{
				mon2 = mon2+12;
				year2= year2-1;
			}
			for(int i=mon2;i>mon1;i--)
			{
				if ((i==2)||(i==4)||(i==6)||(i==8)||(i==9)||(i==11)||(i==1)||((i-12)==2)||((i-12)==4)||((i-12)==6)||((i-12)==8)||((i-12)==9)||((i-12)==11)||((i-12)==1))
				{
					day2 = day2+31;
				}
		
				if ((i==5)||(i==7)||(i==10)||(i==12)||((i-12)==5)||((i-12)==7)||((i-12)==10)||((i-12)==12))
				{
					day2 = day2+30;
				}
		
				if ((i==3)||((i-12)==3))
				{
					boolean a =((year2%100==0)&&(year2%400!=0)||(year2%4!=0));
					if (a)
					{
						day2 = day2+28;
					}else{
						day2 = day2+29;
			
					}
				}
			}
			rtn = ((year2-year1)+"�~"+(day2-day1)+"��");

		}
		return rtn;
	}
}
