package gov.dnt.tame.util;

import java.math.BigDecimal;

public class StringUtil {
	
	//傳入 1.字串 2.數目 3.符號 4.是否加在前面 false為前面 true為後面  回傳字串	 
	public String addMark(String str,int value,String add,Boolean after)
	{
		StringBuffer newStr = new StringBuffer();
		
		for(int i=0;i<str.length();i++)
		{
			if(after)
			{	
				newStr.append(str.substring(i,i+1));
				for(int j=0;j<value;j++)
				{
					newStr.append(add);
				}
			}
			else
			{
				for(int j=0;j<value;j++)
				{
					newStr.append(add);
				}
				newStr.append(str.substring(i,i+1));
			}	
		}	
		return newStr.toString();
	}
	//傳入BigDecimal的金額 回傳有億和萬的中文字尾數為零者捨去
	public String getROCAmount(BigDecimal money)
	{
		StringBuffer str = new StringBuffer();
		BigDecimal tempMoney = new BigDecimal(0);
		
		if(1 == money.compareTo(new BigDecimal(0)) || 0 == money.compareTo(new BigDecimal(0)))
		{
			tempMoney = money.remainder(new BigDecimal(10000));
			money = money.divide(new BigDecimal(10000),BigDecimal.ROUND_DOWN);
			if(1 == tempMoney.compareTo(new BigDecimal(0)))
			{
				str.append(tempMoney);
			}	
			if(1 == money.compareTo(new BigDecimal(0)))
			{
				tempMoney = money.remainder(new BigDecimal(10000));
				money = money.divide(new BigDecimal(10000),BigDecimal.ROUND_DOWN);
				if(1 == tempMoney.compareTo(new BigDecimal(0)) && 0 != tempMoney.compareTo(new BigDecimal(0)))
				{
					str.insert(0,tempMoney.toString()+"萬");
				}
				if(1 == money.compareTo(new BigDecimal(0)))
				{
					str.insert(0,money.toString()+"億");
				}
			}	

		}	
		return str.toString();
	}
	
	//金額加千分位 傳入BigDecimal回傳String 
	public String addThousandMark(BigDecimal obj)
	{
		try
		{
			StringBuffer newMoney = new StringBuffer();
			String oldMoney = obj.setScale(0,5).toString();
			int amountLength = oldMoney.length() ;
			
			for(int i = amountLength;i>0;i--)
			{		
				newMoney.append(oldMoney.substring((amountLength - i),(amountLength - i + 1)));
				if(((i - 1)%3) == 0 && i!=1)
				{
					newMoney.append(",");
				}
			}
			return newMoney.toString();
		}
		catch (Exception e)
		{
			System.out.println("my amount_decimal error message" + e);
			return new String();
		}       
	}
	
	//金額加千分位 傳入BigDecimal回傳String 
	public String addThousandMark2(BigDecimal obj)
	{
		try
		{
			StringBuffer newMoney = new StringBuffer();
			String oldMoney = obj.setScale(0,1).toString();
			int amountLength = oldMoney.length() ;
			
			for(int i = amountLength;i>0;i--)
			{		
				newMoney.append(oldMoney.substring((amountLength - i),(amountLength - i + 1)));
				if(((i - 1)%3) == 0 && i!=1)
				{
					newMoney.append(",");
				}
			}
			String scaleMoney = obj.subtract(obj.setScale(0,1)).setScale(2,5).toString().substring(1,4);
			return newMoney.toString()+scaleMoney;
		}
		catch (Exception e)
		{
			System.out.println("my amount_decimal error message" + e);
			return new String();
		}       
	}
}
