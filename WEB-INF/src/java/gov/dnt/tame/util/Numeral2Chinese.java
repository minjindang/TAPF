/* Numeral2Chinese.java
 * Created on 2004/9/16
 * 阿拉伯數字轉中文字
 * example : 2 -> 二
 * 			 23 -> 二十三
 */
package gov.dnt.tame.util;

/**
 * @author Anson Tsai
 */
public class Numeral2Chinese
{
    private int num;
    
    public Numeral2Chinese()
    {
        super();
    }
    
    public Numeral2Chinese(int num)
    {
        this.num = num;
    }
    
    public String toFormat(int num)
    {
        return format(num);
    }
    
    public String toFormat()
    {
        int num = this.num;
        return format(num);
    }
    
    public String format(int num)
    {
		String[] power={"", "十", "百", "千", "萬", "十", "百", "千", "億",
		        		"十", "百", "千", "兆"};
		String[] nums= {"", "一","二", "三", "四", "五", "六",
					 	"七", "八", "九"};
		String zeroStr = "零";

		// 負數, 0-->零, 10-->十, 比較奇怪, 所以直接傳回值
		if (num < 0) return "";
		else if (num == 0) return zeroStr;
		else if (num == 10) return power[1];

		StringBuffer sb = new StringBuffer();
		String numStr = new Integer(num).toString();
		
		// 將字串反轉, 123-->321, 從後往前 parse
		numStr = new StringBuffer(numStr).reverse().toString();
		int length = numStr.length();
		for (int i=0; i<length; i++)
		{
			int ch = Character.digit(numStr.charAt(i), 10);
			if (ch == 0)
			{
			    /**
			     * sb.length() != 0 表示從個位數開始到此位數都是 0,
			     * sb.indexOf(power[0]) != 0 表示上一位數為0,
			     * 此2種情況不須加上 "零"
			     */
				if (sb.length() != 0 && sb.indexOf(zeroStr) != 0)
					sb.insert(0, zeroStr);
			}
			else
			{
				sb.insert(0, power[i]);
				sb.insert(0, nums[ch]);
			}
		}
		return sb.toString();        
    }
}
