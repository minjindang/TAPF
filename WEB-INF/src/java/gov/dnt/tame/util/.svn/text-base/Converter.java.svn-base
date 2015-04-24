package gov.dnt.tame.util;

import gov.dnt.tame.common.DataSourceFactory;
import gov.dnt.tame.common.LabelValueBean;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kangdainfo.ast.sql.SQLJob;

public class Converter
{
    public static final String RS_CODE_TABLE = "RS9502_DB";
    public static final String OC_CODE_TABLE = "OC9502_DB";
    public static final String FE_CODE_TABLE = "FE9502_DB";

    public static String getAutoComCodeListWithSpaceBySql(String sqlStr,String sInputName,int size)
    {	return getAutoComCodeListWithSpaceBySql(sqlStr,sInputName,"","",size);	}
    public static String getAutoComCodeListWithSpaceBySql(String sqlStr,String sInputName)
    {	return getAutoComCodeListWithSpaceBySql(sqlStr,sInputName,"","",6);	}
    public static String getAutoComCodeListWithSpaceBySql(String sqlStr,String sInputName,String sValue,int size)
    {	return getAutoComCodeListWithSpaceBySql(sqlStr,sInputName,sValue,"",size);	}
    public static String getAutoComCodeListWithSpaceBySql(String sqlStr,String sInputName,String sValue)
    {	return getAutoComCodeListWithSpaceBySql(sqlStr,sInputName,sValue,"",6);	}
    public static String getAutoComCodeListWithSpaceBySql(String sqlStr,String sInputName,String sValue,String sProperties)
    {	return getAutoComCodeListWithSpaceBySql(sqlStr,sInputName,sValue,sProperties,6);	}
    public static String getAutoComCodeListWithSpaceBySql(String sqlStr,String sInputName,String sValue,String sProperties,int size)
    {
    	List<LabelValueBean> codeList = getCodeListWithSpaceBySql(sqlStr);
    	StringBuffer sb = new StringBuffer();
    	if(codeList!=null)
    	{
    		sb.append( "<input TYPE='text'" );
    		sb.append( " name='" + sInputName + "'" );
    		sb.append( " size='" + new Integer(size) + "'" );
    		sb.append( " value='" + sValue + "'");
    		sb.append( sProperties);
    		sb.append( " ONKEYUP=\"autoComplete(this,this.form." + sInputName + "_options,'value',true)\" >");
			sb.append("<SELECT ");
			sb.append(" name='"+sInputName + "_options' ");
			sb.append("onChange='this.form." + sInputName + ".value=this.options[this.selectedIndex].value' " + sProperties.replaceAll("readonly","disabled"));
			sb.append(" >");
			
            for (Iterator<LabelValueBean> it = codeList.iterator(); it.hasNext();)
            {
            	LabelValueBean bean = it.next();
				String name = (String) bean.getLabel();
				String kind = (String) bean.getValuess();
				sb.append("<OPTION VALUE='");
				sb.append(kind);
				sb.append("' ");
				if(( sValue != null ) && ( kind.equalsIgnoreCase(sValue) ))
					sb.append(" selected='true' ");
				sb.append(" />");
				sb.append(name);
			}
			
			sb.append("</SELECT>");
			return sb.toString();
    	}
    	return null;    	
    }

    
    public static String getAutoComCodeListWithSpaceBySql2(String sqlStr,String sInputName,String sTextName,int size)
    {	return getAutoComCodeListWithSpaceBySql2(sqlStr,sInputName,"","",sTextName,size);	}
    public static String getAutoComCodeListWithSpaceBySql2(String sqlStr,String sInputName,String sTextName)
    {	return getAutoComCodeListWithSpaceBySql2(sqlStr,sInputName,"","",sTextName,6);	}
    public static String getAutoComCodeListWithSpaceBySql2(String sqlStr,String sInputName,String sValue,String sTextName,int size)
    {	return getAutoComCodeListWithSpaceBySql2(sqlStr,sInputName,sValue,"",sTextName,size);	}
    public static String getAutoComCodeListWithSpaceBySql2(String sqlStr,String sInputName,String sValue,String sTextName)
    {	return getAutoComCodeListWithSpaceBySql2(sqlStr,sInputName,sValue,"",sTextName,6);	}
    public static String getAutoComCodeListWithSpaceBySql2(String sqlStr,String sInputName,String sValue,String sProperties,String sTextName)
    {	return getAutoComCodeListWithSpaceBySql2(sqlStr,sInputName,sValue,sProperties,sTextName,6);	}
    public static String getAutoComCodeListWithSpaceBySql2(String sqlStr,String sInputName,String sValue,String sProperties,String sTextName,int size)
    {
    	List<LabelValueBean> codeList = getCodeListWithSpaceBySql(sqlStr);
    	StringBuffer sb = new StringBuffer();
    	if(codeList!=null)
    	{
    		sb.append( "<input TYPE='text'" );
    		sb.append( " name='" + sInputName + "'" );
    		sb.append( " size='" + new Integer(size) + "'" );
    		sb.append( " value='" + sValue + "'");
    		sb.append( sProperties);
    		sb.append( " ONKEYUP=\"autoComplete(this,this.form." + sInputName + "_options,'value',true);this.form."+ sTextName + ".value =this.form." + sInputName + "_options.options[this.value].text;\" >");
			sb.append("<SELECT ");
			sb.append(" name='"+sInputName + "_options' ");
			sb.append("onchange=\"this.form." + sInputName + ".value=this.options[this.selectedIndex].value;this.form."+ sTextName + ".value = this.options[this.selectedIndex].text;\" " + sProperties.replaceAll("readonly","disabled"));			
			sb.append(" >");
			
            for (Iterator<LabelValueBean> it = codeList.iterator(); it.hasNext();)
            {
            	LabelValueBean bean = it.next();
				String name = (String) bean.getLabel();
				String kind = (String) bean.getValuess();
				sb.append("<OPTION VALUE='");
				sb.append(kind);
				sb.append("' ");
				if(( sValue != null ) && ( kind.equalsIgnoreCase(sValue) ))
					sb.append(" selected='true' ");
				sb.append(" />");
				sb.append(name);
			}
			
			sb.append("</SELECT>");
			return sb.toString();
    	}
    	return null;    	
    }

    
    
    
    public static String getAutoCompleteCodeListWithSpace(String codeKind, String tableName,String sInputName,int size)
    {	return getAutoCompleteCodeListWithSpace(codeKind,tableName,sInputName,"","",size);	}
    public static String getAutoCompleteCodeListWithSpace(String codeKind, String tableName,String sInputName)
    {	return getAutoCompleteCodeListWithSpace(codeKind,tableName,sInputName,"","",6);	}
    public static String getAutoCompleteCodeListWithSpace(String codeKind, String tableName,String sInputName,String sValue,int size)
    {	return getAutoCompleteCodeListWithSpace(codeKind,tableName,sInputName,sValue,"",size);	}
    public static String getAutoCompleteCodeListWithSpace(String codeKind, String tableName,String sInputName,String sValue)
    {	return getAutoCompleteCodeListWithSpace(codeKind,tableName,sInputName,sValue,"",6);	}
    public static String getAutoCompleteCodeListWithSpace(String codeKind, String tableName,String sInputName,String sValue,String sProperties)
    {	return getAutoCompleteCodeListWithSpace(codeKind,tableName,sInputName,sValue,sProperties,6);	}
    public static String getAutoCompleteCodeListWithSpace(String codeKind, String tableName,String sInputName,String sValue,String sProperties,int size)
    {
    	List<LabelValueBean> codeList = getCodeListWithSpace(codeKind,tableName);
    	StringBuffer sb = new StringBuffer();
    	if(codeList!=null)
    	{
    		sb.append( "<input TYPE=\"text\"" );
    		sb.append( " name=\"" + sInputName + "\"" );
    		sb.append( " size=\"" + new Integer(size) + "\"" );
    		sb.append( " value=\"" + sValue + "\"");
    		sb.append( sProperties);
    		sb.append( " ONKEYUP=\"autoComplete(this,this.form." + sInputName + "_options,'value',true)\" >");
			sb.append("<SELECT ");
			sb.append(" name=\""+sInputName + "_options\" ");
			sb.append("onchange=\"this.form." + sInputName + ".value=this.options[this.selectedIndex].value;\" " + sProperties.replaceAll("readonly","disabled"));
			sb.append(" >");
			System.out.println("1"+sb.toString());
			
            for (Iterator<LabelValueBean> it = codeList.iterator(); it.hasNext();)
            {
            	LabelValueBean bean = it.next();
				String name = (String) bean.getLabel();
				String kind = (String) bean.getValuess();
				sb.append("<OPTION VALUE='");
				sb.append(kind);
				sb.append("' ");
				if(( sValue != null ) && ( kind.equalsIgnoreCase(sValue) ))
					sb.append(" selected=\"true\" ");
				sb.append(" />");
				sb.append(name);
			}
			
			sb.append("</SELECT>");
			return sb.toString();
    	}
    	return null;    	
    }

    
    public static String getAutoCompleteCodeListWithSpace2(String codeKind, String tableName,String sInputName,String sTextName,int size)
    {	return getAutoCompleteCodeListWithSpace2(codeKind,tableName,sInputName,sTextName,"","",size);	}
    public static String getAutoCompleteCodeListWithSpace2(String codeKind, String tableName,String sInputName,String sTextName)
    {	return getAutoCompleteCodeListWithSpace2(codeKind,tableName,sInputName,sTextName,"","",6);	}
    public static String getAutoCompleteCodeListWithSpace2(String codeKind, String tableName,String sInputName,String sTextName,String sValue,int size)
    {	return getAutoCompleteCodeListWithSpace2(codeKind,tableName,sInputName,sTextName,sValue,"",size);	}
    public static String getAutoCompleteCodeListWithSpace2(String codeKind, String tableName,String sInputName,String sTextName,String sValue)
    {	return getAutoCompleteCodeListWithSpace2(codeKind,tableName,sInputName,sTextName,sValue,"",6);	}
    public static String getAutoCompleteCodeListWithSpace2(String codeKind, String tableName,String sInputName,String sTextName,String sValue,String sProperties)
    {	return getAutoCompleteCodeListWithSpace2(codeKind,tableName,sInputName,sTextName,sValue,sProperties,6);	}
    public static String getAutoCompleteCodeListWithSpace2(String codeKind, String tableName,String sInputName,String sTextName,String sValue,String sProperties,int size)
    {
    	List<LabelValueBean> codeList = getCodeListWithSpace(codeKind,tableName);
    	StringBuffer sb = new StringBuffer();
    	if(codeList!=null)
    	{
    		sb.append( "<input TYPE=\"text\"" );
    		sb.append( " name=\"" + sInputName + "\"" );
    		sb.append( " size=\"" + new Integer(size) + "\"" );
    		sb.append( " value=\"" + sValue + "\"");
    		sb.append( sProperties);
    		sb.append( " ONKEYUP=\"autoComplete(this,this.form." + sInputName + "_options,'value',true)\" >");
			sb.append("<SELECT ");
			sb.append(" name=\""+sInputName + "_options\" ");
			sb.append("onchange=\"this.form." + sInputName + ".value=this.options[this.selectedIndex].value;this.form."+ sTextName + ".value = this.options[this.selectedIndex].text;\" " + sProperties.replaceAll("readonly","disabled"));
			
			sb.append(" >");
            for (Iterator<LabelValueBean> it = codeList.iterator(); it.hasNext();)
            {
            	LabelValueBean bean = it.next();
				String name = (String) bean.getLabel();
				String kind = (String) bean.getValuess();
				sb.append("<OPTION VALUE='");
				sb.append(kind);
				sb.append("' ");
				if(( sValue != null ) && ( kind.equalsIgnoreCase(sValue) ))
					sb.append(" selected=\"true\" ");
				sb.append(" />");
				sb.append(name);
			}
			
			sb.append("</SELECT>");
			return sb.toString();
    	}
    	return null;    	
    }

    
    public static String getRadioCodeListBySql(String sqlStr,String sInputName)
    {	return getRadioCodeListBySql(sqlStr,sInputName,"");	}
    public static String getRadioCodeListBySql(String sqlStr,String sInputName,String sValue)
    {	return getRadioCodeListBySql(sqlStr,sInputName,sValue,"");	}
    public static String getRadioCodeListBySql(String sqlStr,String sInputName,String sValue,String sProperties)
    {
    	List codeList = getCodeListBySql(sqlStr);
    	StringBuffer sb = new StringBuffer();
    	if(codeList!=null)
    	{
            for (Iterator it = codeList.iterator(); it.hasNext();)
            {
            	LabelValueBean bean = (LabelValueBean) it.next();
				String label = (String) bean.getLabel();
				String valuess = (String) bean.getValuess();
				sb.append("<INPUT TYPE='radio' ");
				sb.append("NAME='"+sInputName+"' ");
				sb.append("VALUE='"+valuess+"' ");
				if(( sValue != null ) && ( valuess.equalsIgnoreCase(sValue) ))
					sb.append(" checked=true ");
				sb.append(sProperties);
				sb.append(" />");
				sb.append(label);
			}
			return sb.toString();
    	}
    	return null;    	
    }
    
    public static String getRadioCodeList(String codeKind, String tableName,String sInputName)
    {	return getRadioCodeList(codeKind,tableName,sInputName,"");	}
    public static String getRadioCodeList(String codeKind, String tableName,String sInputName,String sValue)
    {	return getRadioCodeList(codeKind,tableName,sInputName,sValue,"");	}
    public static String getRadioCodeList(String codeKind, String tableName,String sInputName,String sValue,String sProperties)
    {
    	List codeList = getCodeList(codeKind,tableName);
    	StringBuffer sb = new StringBuffer();
    	if(codeList!=null)
    	{
            for (Iterator it = codeList.iterator(); it.hasNext();)
            {
            	LabelValueBean bean = (LabelValueBean) it.next();
				String label = (String) bean.getLabel();
				String valuess = (String) bean.getValuess();
				sb.append("<INPUT TYPE='radio' ");
				sb.append("NAME='"+sInputName+"' ");
				sb.append("VALUE='"+valuess+"' ");
				if(( sValue != null ) && ( valuess.equalsIgnoreCase(sValue) ))
					sb.append(" checked=true ");
				sb.append(sProperties);
				sb.append(" />");
				sb.append(label);
			}
			return sb.toString();
    	}
    	return null;    	
    }
    
    public static List<LabelValueBean> getCodeListWithSpaceBySql(String sqlStr)
    {
        if (null != sqlStr)
        {
            List<LabelValueBean> list = getCodeListBySql(sqlStr);
            list.add(0, getEmptyOption());
            return list;
        }
        return null;
    }
    public static List<LabelValueBean> getCodeListWithSpace(String codeKind, String tableName)
    {
        if (null != codeKind)
        {
            List<LabelValueBean> list = getCodeList(codeKind, tableName);
            list.add(0, getEmptyOption());
            return list;
        }
        return null;
    }
    public static List<LabelValueBean> getCodeListBySql(String sqlStr)
    {
        if (null != sqlStr)
            return list(new SQLJob(sqlStr));
        return null;
    }
    public static List<LabelValueBean> getCodeList(String codeKind,String tableName)
    {
        if (null != codeKind)
            return list(listSql(codeKind, tableName));
        return null;
    }
    public static LabelValueBean getEmptyOption()
    {
        LabelValueBean emptyOption = new LabelValueBean();
        emptyOption.setLabel("請選擇");
        emptyOption.setValuess("");
        return emptyOption;
    }
    /**
     * 在LIST中加一空白選項，則TYPE給 "SPACE" ;
     * 		   加一全部選項，則TYPE給 "ALL"
     */
    public static List<LabelValueBean> getCodeKindList(String codeKind, String type,String tableName)
    {
        if (null != codeKind)
        {
            SQLJob listJob = listSql(codeKind, tableName);
            List<LabelValueBean> list = list(listJob);
            if ("SPACE".equals(type))
            {
                list.add(0, new LabelValueBean());
            }
            else if ("ALL".equals(type))
            {
                list.add(0, new LabelValueBean("ALL", "全部"));
            }
            return list;
        }
        return null;
    }
    public static String getCodeName(String codeKind, String codeId,String tableName)
    {
        if (null != codeKind)
        {
            SQLJob sqljob = new SQLJob();
            sqljob.appendSQL("SELECT CODE_ID AS valuess, CODE_NAME AS label ");
            sqljob.appendSQL(" FROM "+tableName);
            sqljob.appendSQL(" WHERE CODE_KIND = ? ");
            sqljob.appendSQL(" AND CODE_ID = ? ");
            sqljob.appendSQL(" ORDER BY CODE_ID ");
            sqljob.addParameter(codeKind);
            sqljob.addParameter(codeId);
            return codeName(sqljob)==null?"":codeName(sqljob);
        }
        return null;
    }
    public static String getCodeNameBySql(String sqlstr)
    {
        SQLJob sqljob = new SQLJob(sqlstr);
        return codeName(sqljob)==null?"":codeName(sqljob);
    }

    protected static SQLJob listSql(String codeKind, String tablename)
    {
        return listSql(codeKind,tablename,"");
    }
    protected static SQLJob listSql(String codeKind, String tablename,String condition)
    {
        SQLJob sqljob = new SQLJob();
        sqljob.appendSQL(" SELECT CODE_NO AS valuess, CODE_NAME AS label ");
        sqljob.appendSQL(" FROM " + tablename );
        sqljob.appendSQL(" WHERE KIND_CODE = '"+codeKind+"'");
        sqljob.appendSQL( condition );
        sqljob.appendSQL(" ORDER BY ID ");
        return sqljob;
    }

    private static List<LabelValueBean> list(SQLJob listSql)
    {
        List<LabelValueBean> list = null;
        try
        {
            DataSource ds = DataSourceFactory.getDataSource();
            QueryRunner run = new QueryRunner(ds);
            ResultSetHandler lrsh =
                new BeanListHandler(
                    Class.forName("gov.dnt.tame.common.LabelValueBean"));
            list =
                (List<LabelValueBean>) (run.query(listSql.getSQL(), listSql.getParameters(), lrsh));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return list;
    }
    private static String codeName(SQLJob valueSql)
    {
        LabelValueBean labelvaluebean = null;
        try
        {
            DataSource ds = DataSourceFactory.getDataSource();
            QueryRunner run = new QueryRunner(ds);
            ResultSetHandler rsh =
                new BeanHandler(
                    Class.forName("gov.dnt.tame.common.LabelValueBean"));
            labelvaluebean =
                (LabelValueBean) (run
                    .query(valueSql.getSQL(), valueSql.getParameters(), rsh));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        if (null != labelvaluebean)
        {
            return labelvaluebean.getLabel();
        }
        else
        {
            return null;
        }
    }

    public static String toShortName(String eName)
    {
        String shortName = null;
        String tempShortName = null;
        //   String[] eShortName = new String[3];
        try
        {
            shortName = eName.toUpperCase();
            shortName = shortName.replaceAll("[^A-Z0-9\\s]*", "");
            shortName = shortName.replaceAll("\\s+", " ");
            shortName = shortName.replaceAll("^THE ", "");
            //		eShortName[0] = shortName.substring(0, shortName.indexOf(" "));
            //		tempShortName = shortName.substring(shortName.indexOf(" ")+1, shortName.length());
            //        eShortName[1] = tempShortName.substring(0, tempShortName.indexOf(" "));
            //	    tempShortName = tempShortName.substring(tempShortName.indexOf(" ")+1, tempShortName.length());
            //	    eShortName[2] = tempShortName.substring(0, tempShortName.indexOf(" "));
            String eShortName[] = shortName.split(" ");
            int i = 0;
            int j = 0;
            if (eShortName.length >= 3)
            {
                for (j = 0; j < 3; j++)
                {
                    int size = eShortName[j].length();
                    if (size > 6)
                    {
                        eShortName[j] = eShortName[j].substring(0, 6);
                    }
                    else
                    {
                        for (i = 0; i < 6 - size; i++)
                        {
                            eShortName[j] = eShortName[j] + " ";
                        }
                    }
                }
                shortName = eShortName[0] + eShortName[1] + eShortName[2];
            }
            else if (eShortName.length == 2)
            {
                for (j = 0; j < 2; j++)
                {
                    int size = eShortName[j].length();
                    if (size > 6)
                    {
                        eShortName[j] = eShortName[j].substring(0, 6);
                    }
                    else
                    {
                        for (i = 0; i < 6 - size; i++)
                        {
                            eShortName[j] = eShortName[j] + " ";
                        }
                    }
                }
                shortName = eShortName[0] + eShortName[1] + "      ";
            }
            else if (eShortName.length == 1)
            {
                for (j = 0; j < 1; j++)
                {
                    int size = eShortName[j].length();
                    if (size > 6)
                    {
                        eShortName[j] = eShortName[j].substring(0, 6);
                    }
                    else
                    {
                        for (i = 0; i < 6 - size; i++)
                        {
                            eShortName[j] = eShortName[j] + " ";
                        }
                    }
                }
                shortName = eShortName[0] + "      " + "      ";
            }
            return shortName;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new AssertionError(e);
        }
    }

    public static String getVerifyObject(String sObjectName,String readonly,String caseID,String caseKind,String OC3001ID) throws SQLException, NamingException
    {
    	String comment = "";
    	String result = "";
    	String checked1 = "";
    	String checked2= "";
    	List list = CommonFun.getList("Select * From OC3003_DB Where CASEID = "+ caseID +" and CASE_KIND = '" + caseKind + "' and OC3001ID = '" + OC3001ID + "'");
    	Map param = null;
		for (Iterator it = list.iterator();it.hasNext();)
		{
			param = (Map) it.next();
			result = param.get("CHECK_RESULT")==null?"":param.get("CHECK_RESULT").toString();
			comment = param.get("CHECK_COMMENT")==null ?"":param.get("CHECK_COMMENT").toString();
		}	

     	if ("Y".equals(result))
     			checked1 = "checked";
     	else if ("N".equals(result))
     			checked2 = "checked";
     	

		
		String flag = " ";
    	if ("Y".equals(readonly))
    		flag = "disabled ";
    	
    	
    	
    	StringBuffer sb = new StringBuffer();
    	if ("N".equals(readonly))
    		sb.append("<input type=\"hidden\" name=\"K" + sObjectName + "\" value=\"" + OC3001ID + "\">");
    	sb.append("<table class='table_1' width='100%'> ");
    	sb.append("<tr> ");
    	sb.append("<td class='table_item' >審核</td> ");
    	sb.append("<td class='table_td'> ");
    	sb.append("<INPUT TYPE='RADIO' NAME='R"+ sObjectName +"' VALUE='Y' " + flag + checked1 +" id='" + sObjectName + "1'><label for='" + sObjectName + "1'>核准</label>");
    	sb.append("<INPUT TYPE='RADIO' NAME='R"+ sObjectName +"' VALUE='N' "+ flag + checked2 +" id='" + sObjectName + "2'><label for='" + sObjectName + "2'>不核准</label>");
    	sb.append("</td> ");
    
    	
    	sb.append("<td class='table_item' >意見</td> ");
    	sb.append("<td class='table_td' > ");
    	
    	String sInputName = "iAudit";
    	List<LabelValueBean> codeList = getCodeListWithSpace("42","OC9502_DB");
    	if(codeList!=null)
    	{
			sb.append("<SELECT ");
			sb.append(" name=\""+sInputName + "_options\" ");
			sb.append("onchange=\"this.form."+ "M" + sObjectName + ".value = this.options[this.selectedIndex].text;\" " + "disabled=" + readonly);
			sb.append(" >");
			
            for (Iterator<LabelValueBean> it = codeList.iterator(); it.hasNext();)
            {
            	LabelValueBean bean = it.next();
				String name = (String) bean.getLabel();
				String kind = (String) bean.getValuess();
				sb.append("<OPTION VALUE='");
				sb.append(kind);
				sb.append("' ");
				sb.append(" />");
				sb.append(name);
			}
			
			sb.append("</SELECT>");

    	}
    	sb.append("</td> ");
    	
    	
    	sb.append("</tr> ");
    	sb.append("<tr> ");
    	sb.append("<td class='table_item'>意見</td> ");
    	sb.append("<td class='table_td' colspan='3'> ");
    	sb.append("<TEXTAREA NAME='M"+ sObjectName +"' COLS='100' ROWS='2' "+ flag+">"+ comment +"</TEXTAREA> ");
    	sb.append("</td> ");
    	sb.append("</tr> ");
    	sb.append("</table> ");
		return sb.toString();
    }
        
}