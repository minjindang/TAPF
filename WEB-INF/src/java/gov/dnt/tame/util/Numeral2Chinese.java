/* Numeral2Chinese.java
 * Created on 2004/9/16
 * ���ԧB�Ʀr�त��r
 * example : 2 -> �G
 * 			 23 -> �G�Q�T
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
		String[] power={"", "�Q", "��", "�d", "�U", "�Q", "��", "�d", "��",
		        		"�Q", "��", "�d", "��"};
		String[] nums= {"", "�@","�G", "�T", "�|", "��", "��",
					 	"�C", "�K", "�E"};
		String zeroStr = "�s";

		// �t��, 0-->�s, 10-->�Q, ����_��, �ҥH�����Ǧ^��
		if (num < 0) return "";
		else if (num == 0) return zeroStr;
		else if (num == 10) return power[1];

		StringBuffer sb = new StringBuffer();
		String numStr = new Integer(num).toString();
		
		// �N�r�����, 123-->321, �q�᩹�e parse
		numStr = new StringBuffer(numStr).reverse().toString();
		int length = numStr.length();
		for (int i=0; i<length; i++)
		{
			int ch = Character.digit(numStr.charAt(i), 10);
			if (ch == 0)
			{
			    /**
			     * sb.length() != 0 ��ܱq�Ӧ�ƶ}�l�즹��Ƴ��O 0,
			     * sb.indexOf(power[0]) != 0 ��ܤW�@��Ƭ�0,
			     * ��2�ر��p�����[�W "�s"
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
