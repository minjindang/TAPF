package tw.gov.nta.debt.common;

import java.util.Calendar;
import java.util.Date;

public class DayCount {
	
	public static String dayCount(Date begDate,Date endDate,String mykey)
	{
		//begDate 起始時間
		//endDate 結束時間
		//mykey A-> 年
		//      B-> 月
		//      C-> 日
		//      D-> 年,月
		//      E-> 年,月,日
		Calendar begCal = Calendar.getInstance();
		begCal.setTime(begDate);
		int year1 = begCal.get(Calendar.YEAR) - 1900;
		int mon1 = begCal.get(Calendar.MONTH) + 1;
		int day1 = begCal.get(Calendar.DAY_OF_MONTH);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);
		int year2 = endCal.get(Calendar.YEAR) - 1900;
		int mon2 = endCal.get(Calendar.MONTH) + 1;
		int day2 = endCal.get(Calendar.DAY_OF_MONTH);
		
		String rtn = "";
		
		if ("A".equals(mykey))
		{
			rtn = (Math.floor((year2-year1+(mon2-mon1)/12) * 100 + 0.5) / 100)+"年";
		}
		
		if ("B".equals(mykey))
		{
			rtn = Math.floor(((year2-year1)*12+mon2-mon1+(day2-day1)/30)* 100 + 0.5)+"月";
		}
		
		if ("C".equals(mykey))
		{
//			rtn = ((endDate.getTime() - begDate.getTime())/86400000+"日");
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
		
		if ("D".equals(mykey))
		{
			if (mon2<mon1)
			{
				mon2 = mon2+12;
				year2= year2-1;
			}
			rtn = ((year2-year1)+"年"+(mon2-mon1)+"月");
		}
		
		if ("E".equals(mykey))
		{
			if (day2<day1) 
			{
				if ((mon2==2)||(mon2==4)||(mon2==6)||(mon2==8)||(mon2==9)||(mon2==11)||(mon2==1))
				{
					day2 = day2+31;
					mon2 = mon2-1;
					if (mon2==0)
					{
						year2 = year2-1;
						mon2 = 12;
					}
				}
		
				if ((mon2==5)||(mon2==7)||(mon2==10)||(mon2==12))
				{
					day2 = day2+30;
					mon2 = mon2-1;
				}
		
				if (mon2==3)
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
				}
			}
			if (mon2<mon1)
			{
				mon2 = mon2+12;
				year2= year2-1;
			}
		
			rtn = ((year2-year1)+"年"+(mon2-mon1)+"月"+(day2-day1)+"日");
		}
		return rtn;
	}


}
