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
	 * 字串轉日期 string(yyyyMMddhhmmss, yyyMMddhhmmss) -> date
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
	 * 字串轉日期 string(yyyyMMdd, yyyMMdd) -> date
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
	 *日期轉字串 date -> string(yyyyMMdd)
	 */
    public static String date2Str(Date date)
    {
		return YYYYMMDD.format(date);
    }

    /**
	 *日期轉字串  + format yyyy/MM/dd, yyyy-MM-dd
	 *date -> string(yyyy/MM/dd, yyyy-MM-dd)
	 */
    public static String date2Str(Date date, String format)
    {
		return toStr(YYYYMMDD.format(date), format);
    }
    /**
	 * 日期轉民國年月日字串
	 */
	public static String date2ChineseROC(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		Numeral2Chinese nc = new Numeral2Chinese();
		return (nc.format(cal.get(Calendar.YEAR)-1911) + "年"
				+ nc.format(cal.get(Calendar.MONTH)+1) + "月"
				+ nc.format(cal.get(Calendar.DAY_OF_MONTH)) + "日"
				);
	}
	 /**
	 * 日期轉民國年月日字串 數字版
	 */
	public static String date2ChineseROC2(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		return ((cal.get(Calendar.YEAR)-1911) + "年"
				+ (cal.get(Calendar.MONTH)+1) + "月"
				+ (cal.get(Calendar.DAY_OF_MONTH)) + "日"
				);
	}
	/**
	 * 日期轉民國年月日時分秒字串
	 */
	public static String dateTime2ChineseROC(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		Numeral2Chinese nc = new Numeral2Chinese();
		return (nc.format(cal.get(Calendar.YEAR)-1911) + "年"
				+ nc.format(cal.get(Calendar.MONTH)+1) + "月"
				+ nc.format(cal.get(Calendar.DAY_OF_MONTH)) + "日"
				+ nc.format(cal.get(Calendar.HOUR_OF_DAY)) + "時"
				+ nc.format(cal.get(Calendar.MINUTE)) + "分"
				+ nc.format(cal.get(Calendar.SECOND)) + "秒"
						);
	}
	
	
	/**
	 * 日期轉ROC字串 date -> string(yyyMMddhhmmss)
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
	 * 日期轉ROC字串 date -> string(yyyMMdd)
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
     * 日期轉ROC字串 + format yyy/mm/dd, yyy-mm-dd
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
	 * 民國日期
	 * @return String
	 */
	public static String ROCDate()
	{
		return date2ROCStr(new Date());
	}

    /**
     * 民國日期轉西元日期 yyy/MM/dd -> yyyy/MM/dd
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
     * 西元日期轉民國日期 yyyy/MM/dd -> yyy/MM/dd
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
	 * 日期加總天數 date(yyyyMMdd ; yyyMMdd) + day
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
		//天數是單數時，加成二位
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
	 * 傳入 yyymmdd 或 yyyymmdd , 及要增減的 + - year
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
	 * 傳入 yyymmdd 或 yyyymmdd , 及要增減的 + - month
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
	//  函數功能：某一日期加上一定期間的日或月或年
	//  參　　數：sType可以是d(Day),m(Month),y(Year); sNum數值; sdate為日期yyymmdd
	//  傳 回 值：傳回加上特定期間之後的日期
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
            
            //King 原本無判斷大小月，若為31日會自動進位月份，但只限於月份+1時使用
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
	 * 傳入要相減的date取得天數
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
	 * 取得當月最後一天的日期
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
	 * 取得當月最後一天的日期
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
	 * 數字123 轉 國字一二三 加萬千百十
	 * @param str1
	 * @return
	 */
	public static String numToChinese(String str1)
	{
		StringBuffer returnStr = new StringBuffer();
		StringBuffer returnStr2 = new StringBuffer();
		if(0 != str1.length())
		{	
			String[] myChinese = {"零","一","二","三","四","五","六","七","八","九"}; 
			for(int i =0 ;i<str1.length();i++)
			{	
				if("0".equals(str1.substring(i,i+1)) && 0 == i )
				{
					continue;
				}
				returnStr.append(myChinese[Integer.parseInt(str1.substring(i,i+1))]);
			}
			
			String[] words = {"","十","百","千","萬","十萬","百萬","千萬"};	
			for(int i = 1;i<=returnStr.length();i++)
			{		
				int tempvalue = returnStr.length()- i;
				if(!"零".equals(returnStr.substring(i-1,i)))
				{	
						returnStr2.append(returnStr.substring(i-1,i));
						returnStr2.append(words[tempvalue]);
				}	
			}
		}
		return returnStr2.toString();
	}
	
	
    /**
     * 系統日期
     * @return Date
     */
    public static Date date()
    {	return new Date();	}
    /**
     * 系統日期時間
     * @return String YYYMMDDhhmmss
     */
    public static String getSystemDateTime()
    {
		String returnDate = YYYYMMDDhhmmss.format(new Date());
		return toROCStr(returnDate.substring(0,8))+returnDate.substring(8);
    }
    /**
     * 系統日期
     * @return String YYYMMDD
     */
	public static String getSystemDate()
	{	return toROCStr(YYYYMMDDhhmmss.format(new Date()).substring(0,8));	}
    /**
     * 系統時間
     * @return String hhmmss
     */
	public static String getSystemTime()
	{	return YYYYMMDDhhmmss.format(new Date()).substring(8);	}
	
	/**
	 * 
	 * @param startDate 開始日期
	 * @param endDate   結束日期
	 * @return 開始到結束日期相差幾個月 2005/1/1 - 2006/2/15 相差13個月
	 */
	public static int getMonthBetween(Date startDate,Date endDate) {
        int yearBetween = DateUtil.getYear(endDate)- DateUtil.getYear(startDate);
        int monthBetween = DateUtil.getMonth(endDate) - DateUtil.getMonth(startDate);
        int monthPeriod = yearBetween * 12 + monthBetween;
        return monthPeriod;
	}
	
	public static String daycount(Date begDate,Date endDate,String mykey)
	{
		//begDate 起始時間
		//endDate 結束時間
		//mykey A-> 年
		//      B-> 月
		//      C-> 日
		//      D-> 年,月
		//      E-> 年,月,日

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
			rtn = (Math.floor((year2-year1+(mon2-mon1)/12) * 100 + 0.5) / 100)+"年";
		}
		
		if (mykey=="B")
		{
			rtn = Math.floor(((year2-year1)*12+mon2-mon1+(day2-day1)/30)* 100 + 0.5)+"月";
		}
		
		if (mykey=="C")
		{
//			Date begMyDate = new Date(year1, mon1-1, day1);
//			Date endMyDate = new Date(year2, mon2-1, day2);
//			rtn = (DateUtil.getDays(begMyDate,endDate)/86400000+"日");
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
			rtn = ((year2-year1)+"年"+(mon2-mon1)+"月");
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
		
			rtn = ((year2-year1)+"年"+(mon2-mon1)+"月"+(day2-day1)+"日");
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
			rtn = ((year2-year1)+"年"+(day2-day1)+"日");

		}
		return rtn;
	}
}
