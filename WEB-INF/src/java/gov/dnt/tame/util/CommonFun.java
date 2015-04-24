package gov.dnt.tame.util;

import gov.dnt.tame.common.BaseDAO;
import gov.dnt.tame.common.DataSourceFactory;
import gov.dnt.tame.common.LabelValueBean;
import gov.dnt.tame.common.SQLRunnerDAO;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.sql.DataSource;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunnerException;

public abstract class CommonFun
{
	/**
	 * �b������� asdf1234 - > �����������
	 */
	public static String unicodeTrans(String big)
	{
		String[] starts={"��", "��", "��", "��", "��", "��", "��",
					  "��", "��", "��", "�@",
					  "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
					  "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
					  "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
					  "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
					  "��", "��", "��", "��", "��", "��", "��", "��", "�@", "�A",
					  "�B","�C"};
		String[] ends= {"0", "1","2", "3", "4", "5", "6",
					 "7", "8", "9", " ",
					 "A", "B", "C", "D", "E","F", "G", "H", "I", "J",
					 "K", "L", "M", "N", "O","P", "Q", "R", "S", "T",
					 "U", "V", "W", "X", "Y","Z", "a", "b", "c", "d",
					 "e", "f", "g", "h", "i", "j", "k", "l", "m","n",
					 "o", "p", "q", "r", "s", "t", "u", "v", "w","x",
					 "y","z"};

		String words = "";
		int i = big.length();
		String str = "";
		int position = 0;

		for(int j=0;j<i;j++)
		{
			boolean method = false;
			words =  big.substring(j,j+1);

			for(int y=0;y<ends.length;y++)
			{
				if(words.equals(ends[y]))
				{
					 position = y;
					 method = true;
				}
			}
			if(method)
			{
				words = starts[position];
			}
			str += words;
		}
		return str.trim();
	}

	/**
	 * ��ܪ���
	 */
	public static String toStraight(String str, int lengthPerLine)
	{
		// �N "\n" ����, �̨C����״��������Ӽƪ� "�@"
		int left = 0;
		int right = 0;
		while ((right = str.indexOf("\n")) > 0)
		{
			String temp = str.substring(left, right);
			for (int k=right%lengthPerLine; k<lengthPerLine && k!=0; k++)
				temp = temp + "�@";
			temp = temp + str.substring(right+1, str.length());
			str = temp;
		}
		// �ઽ��
		int strLength = str.length();
		int loop = strLength/lengthPerLine;
		StringBuffer sb = new StringBuffer();
		for (int j=0; j<lengthPerLine; j++)
		{
			for (int i=loop; i>=0; i--)
			{
				int count = i*lengthPerLine+j;
				if (count >= strLength)
					sb.append("�@");
				else
					sb.append(str.charAt(count));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	public static String int2Chinese(int num)
	{
		String[] power={"", "�Q", "��", "�d", "�U", "�Q", "��", "�d", "��", "�Q", "��", "�d", "��"};
		String[] nums= {"", "�@","�G", "�T", "�|", "��", "��", "�C", "�K", "�E"};
		String zeroStr = "�s";

		// �t��, 0-->�s, 10-->�Q, ����_��, �ҥH�����Ǧ^��
		if (num < 0)	return "";
		else if (num == 0)	return zeroStr;
		else if (num == 10)	return power[1];

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
				// sb.length() != 0 ��ܱq�Ӧ�ƶ}�l�즹��Ƴ��O 0,
				// sb.indexOf(power[0]) != 0 ��ܤW�@��Ƭ�0,
				// ��2�ر��p�����[�W "�s"
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

    /**
     * Format a good code into xxxx.xx.xx.xx- format with a trailing dash.
     * For example, 1234567890 will be formatted to 1234.56.78.90-.
     * 
     * @param goodsNo		good code
     * @return				good code formated as xxxx.xx.xx.xx-
     */
    public static String addGoodsMask(String goodsNo)
    {
        return addGoodsMask(goodsNo, "-");
    }
    /**
     * Format a good code into xxxx.xx.xx.xx plus a suffix.
     * For example, 1234567890 with suffix "-" will be formatted
     * to 1234.56.78.90-.
     * 
     * @param goodsNo		good code
     * @param suffix		suffix to append to the formatted good code
     * @return				good code formated as xxxx.xx.xx.xx-
     */
    public static String addGoodsMask(String goodsNo, String suffix)
    {
        if (goodsNo == null)	return null;

        StringBuffer sb = null;
        goodsNo = goodsNo.trim();

        if (goodsNo.length() < 4)
        {
            return goodsNo;
        }
        if (goodsNo.length() == 4)
        {
            return (goodsNo + ".");
        }
        else if (goodsNo.length() > 4)
        {
            sb = new StringBuffer(goodsNo.substring(0, 4));
            sb.append(".");
            if (goodsNo.length() == 5)
            {
                sb.append(goodsNo.substring(4, 5));
                return (sb.toString());
            }
            else if (goodsNo.length() >= 6)
            {
                sb.append(goodsNo.substring(4, 6));
                sb.append(".");
                if (goodsNo.length() == 6)
                {
                    return (sb.toString());
                }
                else if (goodsNo.length() == 7)
                {
                    sb.append(goodsNo.substring(6, 7));
                    return (sb.toString());
                }
                else if (goodsNo.length() >= 8)
                {
                    sb.append(goodsNo.substring(6, 8));
                    sb.append(".");
                    if (goodsNo.length() == 8)
                    {
                        return (sb.toString());
                    }
                    else if (goodsNo.length() == 9)
                    {
                        sb.append(goodsNo.substring(8, 9));
                        return (sb.toString());
                    }
                    else
                    {
                        sb.append(goodsNo.substring(8, 10));
                        sb.append(suffix);
                    }
                }
            }
        }
        return (sb.toString());
    }
    
    /**
     * Ouput javascript code for dynamic calendar
     * 
     * @param textName		date cloumn name
     * @param num			multi date cloumn index
     * @return				dynamic calendar
     */
	public static String addCalendar(String textName)
	{	return addCalendar(textName,0);	}
	public static String addCalendar(String textName,Integer num)
	{
		if( null == textName || "" == textName )	return null;

        String realName = "";
        if( "".equals(num) )
			realName	=	textName.substring(5,textName.length()-1);
        else
			realName	=	num.toString();

        StringBuffer sb = null;
        sb=new StringBuffer("\r\n<script language=\"JavaScript\" type=\"text/javascript\">\r\n");
        sb.append("<!--\r\n");
        sb.append("fooCalendar_"+realName+" = new dynCalendar('fooCalendar_"+realName+"', 'calendarCallback_"+realName+"', '/tapf/assets/images/calendar/');\r\n");
        sb.append("function calendarCallback_"+realName+"(date, month, year)\r\n");
        sb.append("{\r\n");
        sb.append("if(year-1911 < 100) {year = '0' + (year-1911)} else {year = ''+(year-1911)} ;\r\n");
        sb.append("if(month < 10) month = '0' + month ;\r\n");
        sb.append("if(date < 10) date = '0' + date ;\r\n");
        sb.append("document.MainForm.elements['"+textName+"'].value = year + month + date;\r\n");
        //sb.append("document.MainForm.elements['"+textName+"'].onblur();\r\n");
        sb.append("}\r\n");
        sb.append("//-->\r\n");
        sb.append("</script>\r\n");
        return (sb.toString());
    }

    /**
     * Return the Check Number for a given good code.
     * @param goodCode		good code with at least 10 characters long
     * @return				check number if good code's length is
     * 						greater than or equal to 10
     * 						"" is returned the condition does not satisfy.
     */
    public static String getCheckNo(String goodCode)
    {
        // will good code's length be greater than 10?
        if (goodCode == null || ("").equals(goodCode.trim()) || goodCode.length() > 10)
        {
            return "";
        }
        int a[] = new int[10];
        int b[] = new int[6];
        for (int i = 0; i < a.length; i++)
        {
            a[i] = getIntegerFromString(goodCode, i);
        }
        String firstPass =
            String.valueOf(
                (a[0] * 10000 + a[2] * 1000 + a[4] * 100 + a[6] * 10 + a[8])
                    * 2);
        for (int i = 0; i < b.length - firstPass.length(); i++)
        {
            b[i] = 0;
        }
        for (int i = 0; i < firstPass.length(); i++)
        {
            b[b.length - firstPass.length() + i] =
                getIntegerFromString(firstPass, i);
        }
        int secondPass =
            (a[1]
                + a[3]
                + a[5]
                + a[7]
                + a[9]
                + b[1]
                + b[2]
                + b[3]
                + b[4]
                + b[5])
                % 10;
        return (secondPass == 0 ? "0" : String.valueOf(10 - secondPass));
    }
    /**
     * Returns parsed integer value from a string's character.
     * For example, from a string "1234567890" with position "1"
     * will return integer value 2. 
     * 
     * @param s				string to check
     * @param pos			position of the character to parse
     * @return				parsed integer for the character,
     * @throws NumberFormatException
     * @throws IndexOutOfBoundsException
     */
    private static int getIntegerFromString(String s, int pos)
        throws NumberFormatException, IndexOutOfBoundsException
    {
        if (pos >= s.length())
        {
            throw new IndexOutOfBoundsException();
        }
        return Integer.parseInt("" + s.charAt(pos));
    }

    /**
     * Set Elixir report properties.
     * 
     * @param prop
     * @param datasource
     * @param SQLStr
     */

    public static String strPad(String s, int len, char ch, boolean left)
    {
        StringBuffer strBuf = new StringBuffer();
        if (s == null)
        {
            s = "";
        }
        if (!left)
        {
            strBuf.append(s);
            while (strBuf.toString().getBytes().length < len)
            {
                strBuf.append(ch);
            }
        }
        else
        {
            while (strBuf.toString().getBytes().length < len - s.length())
            {
                strBuf.append(ch);
            }
            strBuf.append(s);
        }
        return strBuf.toString();
    }
    public static String strPadR(String s, int len, char ch)
    {
        return strPad(s, len, ch, false);
    }
    public static String strPadR(String s, int len)
    {
        return strPadR(s, len,' ');
    }
    public static String strPadL(String s, int len, char ch)
    {
        return strPad(s, len, ch, true);
    }

    //  when the value is null or empty, return an empty string
    public static String TrimString(String temp)
    {
        if (null == temp || "null".equals(temp))
        {
            return "";
        }
        else
            return temp;
    }
    
    private static BaseDAO getDAO(Connection conn)
    {
    	return new SQLRunnerDAO(new ConnectionSQLRunner(conn));
    }

	public static List getList(String sql) throws SQLException, NamingException
	{	return getList( DataSourceFactory.getDataSource() ,sql);	}
	public static List getList(DataSource ds,String sql) throws SQLException, NamingException
	{
		Connection conn = null;
		SQLJob sqlJob = new SQLJob(sql);
		try{
			conn = ds.getConnection();
			List list = getDAO(conn).selectList(sqlJob);
			return list;
		}catch (SQLRunnerException e){
			e.printStackTrace();
			throw new AssertionError(e);
		}finally {
			conn.close();
		}
	}

	public static Map getMap(String sql) throws SQLException, NamingException
	{	return getMap( DataSourceFactory.getDataSource() ,sql);	}
	public static Map getMap(DataSource ds,String sql) throws SQLException, NamingException
	{
		Connection conn = null;
		SQLJob sqlJob = new SQLJob(sql);
		try{
			conn = ds.getConnection();
			Map map = getDAO(conn).selectMap(sqlJob);
			return map;
		}catch (SQLRunnerException e){
			e.printStackTrace();
			throw new AssertionError(e);
		}finally {
			conn.close();
		}
	}

	public static String getTitle(String programId) throws SQLException, NamingException
	{
		Connection conn = null;
    	SQLJob sqlJob = new SQLJob();
        try{
        	conn = DataSourceFactory.getDataSource().getConnection();
        	sqlJob.appendSQL("select NAME,PATH from PM0003_DB WHERE PATH=?");
    		sqlJob.addParameter(programId);
            Map map = getDAO(conn).selectMap(sqlJob);
            return (String) map.get("NAME")+"["+map.get("PATH")+"]";
        }catch (SQLRunnerException e){
        	e.printStackTrace();
            return programId;
        }finally {
        	conn.close();
        }
    }
	
    /* �b���w�r�ꤤ�ɻ��Y�Ǧr���A�w�]�O�ɦb�r�ꪺ�k��
     * EX:"1"-->"000001" => stringOfChar("1",6,"0","L")
     * EX:"Test"-->"Test******" => stringOfChar("Test",10,"*")
     */
    public static String stringOfChar(String val,int totalLen,String addChar)
    {
    	return stringOfChar(val,totalLen,addChar,"R");
    }
    public static String stringOfChar(String val,int totalLen,String addChar,String flag)
    {
    	StringBuffer tempStr = new StringBuffer();
    	for (int i = 0; i < (totalLen - val.length()) ; i++)
    	{
    		tempStr.append(addChar);
    	}
    	if ("L".equals(flag))
    		return (tempStr.toString() + val);
    	else 
    		return (val + tempStr.toString());
    }
	
    public static String iso2Big5(String s) throws UnsupportedEncodingException
	{
    	return new String(s.getBytes("ISO-8859-1"), "Big5");
	}
    
    /**
     * �ϥ�confirm�T�{�O�_�~�����w����L���ʧ@
     * @param list<LabelValueBean>
     * @param kindg = �Hvaluess�Ϊ�label���ˬd��
     * @param arrayName = ����JavaScript���}�C�W��
     * @param functionName=����JavaScript��function�W��
     * @param msgText=confirm���T����r
     * @return �����ˬd�}�C���ˬdfunction
     */
    public static String checkOfConfirm(List<LabelValueBean> list,String kind,String arrayName,String functionName,String msgText)
	{
		List<LabelValueBean> checkList = list;
		StringBuffer sb = null;
		String str = null;
		sb=new StringBuffer("\r\n<script language=\"JavaScript\" type=\"text/javascript\">\r\n");
	    sb.append("<!--\r\n");
	    sb.append("var "+arrayName+"=new Array("+checkList.size()+");\r\n");
		for (int i = 0 ; i < checkList.size() ; i++){
			LabelValueBean beanMap = checkList.get(i);
			if (kind.equals("valuess"))
				str= beanMap.getValuess();
			else
				str = beanMap.getLabel();
			//System.out.println("Avery==>"+str);
			sb.append(arrayName+"["+i+"]='"+str+"';\r\n");
		}
		
		sb.append("function "+functionName+"(chkString)\r\n");
		sb.append("{\r\n");
		sb.append("var checkBoolean = false;\r\n");
		sb.append("for (var i = 0; i < "+arrayName+".length; i++)\r\n");
		sb.append("{\r\n");
		sb.append("if ("+arrayName+"[i]==chkString){\r\n");
		sb.append("checkBoolean = true;\r\n");
		sb.append("break;\r\n");
		sb.append("}\r\n");
		sb.append("}\r\n");
		sb.append("if (checkBoolean == true){\r\n");
		sb.append("if(!confirm('"+msgText+"')){\r\n");
		sb.append("return false;\r\n");
		sb.append("}\r\n");
		sb.append("}\r\n");
		sb.append("return true;\r\n");
		sb.append("}\r\n");
		sb.append("//-->\r\n");
	    sb.append("</script>\r\n");
        return (sb.toString());
    }
    
    /**
     * �ϥ�alert���ܤw����L���ʧ@
     * @param list<LabelValueBean>
     * @param kind = �Hvaluess�Ϊ�label���ˬd��
     * @param arrayName = ����JavaScript���}�C�W��
     * @param functionName = ����JavaScript��function�W��
     * @param msgText = alert���T����r
     * @return
     */
    public static String checkOfAlert(List<LabelValueBean> list,String kind,String arrayName,String functionName,String msgText)
	{
		List<LabelValueBean> checkList = list;
		StringBuffer sb = null;
		String str = null;
		sb=new StringBuffer("\r\n<script language=\"JavaScript\" type=\"text/javascript\">\r\n");
	    sb.append("<!--\r\n");
	    sb.append("var "+arrayName+"=new Array("+checkList.size()+");\r\n");
		for (int i = 0 ; i < checkList.size() ; i++){
			LabelValueBean beanMap = checkList.get(i);
			if (kind.equals("valuess"))
				str= beanMap.getValuess();
			else
				str = beanMap.getLabel();
			sb.append(arrayName+"["+i+"]='"+str+"';\r\n");
		}
		sb.append("function "+functionName+"(chkString)\r\n");
		sb.append("{\r\n");
		sb.append("var checkBoolean = false;\r\n");
		sb.append("for (var i = 0; i < "+arrayName+".length; i++)\r\n");
		sb.append("{\r\n");
		sb.append("if ("+arrayName+"[i]==chkString){\r\n");
		sb.append("checkBoolean = true;\r\n");
		sb.append("break;\r\n");
		sb.append("}\r\n");
		sb.append("}\r\n");
		sb.append("if (checkBoolean == true){\r\n");
		sb.append("alert(\""+msgText+"\");\r\n");
		sb.append("return false;\r\n");
		sb.append("}\r\n");
		sb.append("return true;\r\n");
		sb.append("}\r\n");
		sb.append("//-->\r\n");
	    sb.append("</script>\r\n");
        return (sb.toString());
    }
}
