package gov.dnt.tame.util;

import gov.dnt.tame.common.LabelValueBean;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CombinText {

    public static String getAutoComCodeListWithSpaceBySql(List<LabelValueBean> list,String sInputName)
    {	return getAutoComCodeListWithSpaceBySql(list,sInputName,"","","",6,true);	}
    public static String getAutoComCodeListWithSpaceBySql(List<LabelValueBean> list,String sInputName, boolean hasText)
    {	return getAutoComCodeListWithSpaceBySql(list,sInputName,"","","",6,hasText);	}
    public static String getAutoComCodeListWithSpaceBySql(List<LabelValueBean> list,String sInputName,int size)
    {	return getAutoComCodeListWithSpaceBySql(list,sInputName,"","","",size,true);	}
	public static String getAutoComCodeListWithSpaceBySql(List<LabelValueBean> list,String sInputName,int size, boolean hasText)
    {	return getAutoComCodeListWithSpaceBySql(list,sInputName,"","","",size,hasText);	}
    public static String getAutoComCodeListWithSpaceBySql(List<LabelValueBean> list,String sInputName,String sValue)
    {	return getAutoComCodeListWithSpaceBySql(list,sInputName,sValue,"","",6,true);	}
    public static String getAutoComCodeListWithSpaceBySql(List<LabelValueBean> list,String sInputName,String sValue, boolean hasText)
    {	return getAutoComCodeListWithSpaceBySql(list,sInputName,sValue,"","",6,hasText);	}
	public static String getAutoComCodeListWithSpaceBySql(List<LabelValueBean> list,String sInputName,String sValue,int size)
    {	return getAutoComCodeListWithSpaceBySql(list,sInputName,sValue,"","",size,true);	}
	public static String getAutoComCodeListWithSpaceBySql(List<LabelValueBean> list,String sInputName,String sValue,int size, boolean hasText)
    {	return getAutoComCodeListWithSpaceBySql(list,sInputName,sValue,"","",size,hasText);	}
    public static String getAutoComCodeListWithSpaceBySql(List<LabelValueBean> list,String sInputName,String sValue,String sProperties)
    {	return getAutoComCodeListWithSpaceBySql(list,sInputName,sValue,sProperties,"",6,true);	}
    public static String getAutoComCodeListWithSpaceBySql(List<LabelValueBean> list,String sInputName,String sValue,String sProperties, boolean hasText)
    {	return getAutoComCodeListWithSpaceBySql(list,sInputName,sValue,sProperties,"",6,hasText);	}
    public static String getAutoComCodeListWithSpaceBySql(List<LabelValueBean> list,String sInputName,String sValue,String sProperties, int size)
    {	return getAutoComCodeListWithSpaceBySql(list,sInputName,sValue,sProperties,"",size,true);	}
    public static String getAutoComCodeListWithSpaceBySql(List<LabelValueBean> list, String sInputName, String sValue, String sProperties, int size, boolean hasText)
    {	return getAutoComCodeListWithSpaceBySql(list,sInputName,sValue,sProperties,"",size,hasText);	}    

    public static String getAutoComCodeListWithSpaceBySql(List<LabelValueBean> list, String sInputName, String sValue, String sProperties, String sFunction)
    {	return getAutoComCodeListWithSpaceBySql(list,sInputName,sValue,sProperties,sFunction,6,true);	}
    public static String getAutoComCodeListWithSpaceBySql(List<LabelValueBean> list, String sInputName, String sValue, String sProperties, String sFunction, boolean hasText)
    {	return getAutoComCodeListWithSpaceBySql(list,sInputName,sValue,sProperties,sFunction,6, true);	}
    public static String getAutoComCodeListWithSpaceBySql(List<LabelValueBean> list, String sInputName, String sValue, String sProperties, String sFunction, int size)
    {	return getAutoComCodeListWithSpaceBySql(list,sInputName,sValue,sProperties,sFunction,size, true);	}
    public static String getAutoComCodeListWithSpaceBySql(List<LabelValueBean> list, String sInputName, String sValue, String sProperties, String sFunction, int size, boolean hasText)
    {
    	StringBuffer sb = new StringBuffer();
    	if(list!=null)
    	{
    		sb.append( "<input TYPE=\"text\"" );
    		if(!hasText)
    			sb.append(" style=\"display:none;\"");
    		sb.append( " name=\"" + sInputName + "\"" );
    		sb.append( " size=\"" + new Integer(size) + "\"" );
    		sb.append( " value=\"" + sValue + "\"");
    		sb.append( sProperties);
    		sb.append( " onblur=\"autoComplete(this,this.form." + sInputName + "_options,'value',true);");
    		if( !"".equals( sFunction ) )
    			sb.append(sFunction+";");
			sb.append("\"");
    		sb.append( " ONKEYUP=\"autoComplete(this,this.form." + sInputName + "_options,'value',true)\" >\n");
			sb.append("<SELECT ");
			sb.append(" name='"+sInputName + "_options' ");
			sb.append("onChange=\"this.form." + sInputName + ".value=this.options[this.selectedIndex].value;");
    		if( !"".equals( sFunction ) )
    			sb.append( sFunction+";");
			sb.append("\"");
			sb.append( sProperties.replaceAll("readonly","disabled"));
			sb.append(" >\n");
			list.add(0, new LabelValueBean("","請選擇") );
            for (Iterator<LabelValueBean> it = list.iterator(); it.hasNext();)
            {
            	LabelValueBean bean = it.next();
				String name = (String) bean.getLabel();
				String kind = (String) bean.getValuess();
				sb.append("<OPTION VALUE=\"");
				sb.append(kind);
				sb.append("\" ");
				if(( sValue != null ) && ( kind.equalsIgnoreCase(sValue) ))
					sb.append(" selected=\"true\" ");
				sb.append(" />");
				sb.append(name+"\n");
			}
			
			sb.append("</SELECT>\n");
			return sb.toString();
    	}
    	return "";    	
    }

	public static String getAutoComCodeListWithSpaceBySql2(List<LabelValueBean> list,String sInputName,String sTextName)
	{	return getAutoComCodeListWithSpaceBySql2(list,sInputName,sTextName,"","",6,true);	}
	public static String getAutoComCodeListWithSpaceBySql2(List<LabelValueBean> list,String sInputName,String sTextName, boolean hasText)
	{	return getAutoComCodeListWithSpaceBySql2(list,sInputName,sTextName,"","",6,hasText);	}
	public static String getAutoComCodeListWithSpaceBySql2(List<LabelValueBean> list,String sInputName,String sTextName,int size)
	{	return getAutoComCodeListWithSpaceBySql2(list,sInputName,sTextName,"","",size, true);	}
	public static String getAutoComCodeListWithSpaceBySql2(List<LabelValueBean> list,String sInputName,String sTextName,int size, boolean hasText)
	{	return getAutoComCodeListWithSpaceBySql2(list,sInputName,sTextName,"","",size, hasText);	}
	public static String getAutoComCodeListWithSpaceBySql2(List<LabelValueBean> list,String sInputName,String sValue,String sTextName)
	{	return getAutoComCodeListWithSpaceBySql2(list,sInputName,sValue,"",sTextName,6, true);	}
	public static String getAutoComCodeListWithSpaceBySql2(List<LabelValueBean> list,String sInputName,String sValue,String sTextName, boolean hasText)
	{	return getAutoComCodeListWithSpaceBySql2(list,sInputName,sValue,"",sTextName,6, hasText);	}
	public static String getAutoComCodeListWithSpaceBySql2(List<LabelValueBean> list,String sInputName,String sValue,String sTextName,int size)
	{	return getAutoComCodeListWithSpaceBySql2(list,sInputName,sValue,"",sTextName,size, true);	}
	public static String getAutoComCodeListWithSpaceBySql2(List<LabelValueBean> list,String sInputName,String sValue,String sTextName,int size, boolean hasText)
	{	return getAutoComCodeListWithSpaceBySql2(list,sInputName,sValue,"",sTextName,size, hasText);	}
	public static String getAutoComCodeListWithSpaceBySql2(List<LabelValueBean> list,String sInputName,String sValue,String sProperties,String sTextName)
	{	return getAutoComCodeListWithSpaceBySql2(list,sInputName,sValue,sProperties,sTextName,6, true);	}
	public static String getAutoComCodeListWithSpaceBySql2(List<LabelValueBean> list,String sInputName,String sValue,String sProperties,String sTextName, boolean hasText)
	{	return getAutoComCodeListWithSpaceBySql2(list,sInputName,sValue,sProperties,sTextName,6, hasText);	}
	public static String getAutoComCodeListWithSpaceBySql2(List<LabelValueBean> list,String sInputName,String sValue,String sProperties,String sTextName,int size)
	{	return getAutoComCodeListWithSpaceBySql2(list,sInputName,sValue,sProperties,sTextName,6, true);	}
	public static String getAutoComCodeListWithSpaceBySql2(List<LabelValueBean> list,String sInputName,String sValue,String sProperties,String sTextName,int size, boolean hasText)
	{
    	StringBuffer sb = new StringBuffer();
    	if(list!=null)
    	{
    		sb.append( "<input TYPE='text'" );
    		if(!hasText)
    			sb.append( " style='display=none;'" );
    		sb.append( " name='" + sInputName + "'" );
    		sb.append( " size='" + new Integer(size) + "'" );
    		sb.append( " value='" + sValue + "'");
    		sb.append( sProperties);
    		sb.append( " ONKEYUP=\"autoComplete(this,this.form." + sInputName + "_options,'value',true);this.form."+ sTextName + ".value =this.form." + sInputName + "_options.options[this.value].text;\" >");
			sb.append("<SELECT ");
			sb.append(" name='"+sInputName + "_options' ");
			sb.append("onchange=\"this.form." + sInputName + ".value=this.options[this.selectedIndex].value;this.form."+ sTextName + ".value = this.options[this.selectedIndex].text;\" " + sProperties.replaceAll("readonly","disabled"));			
			sb.append(" >");
			
			list.add(0, new LabelValueBean("","請選擇") );
            for (Iterator<LabelValueBean> it = list.iterator(); it.hasNext();)
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

    public static String getAutoCompleteCodeListWithSpace(String codeKind, String tableName,String sInputName)
    {	return getAutoCompleteCodeListWithSpace(codeKind,tableName,sInputName,"","",6);	}
    public static String getAutoCompleteCodeListWithSpace(String codeKind, String tableName,String sInputName,int size)
    {	return getAutoCompleteCodeListWithSpace(codeKind,tableName,sInputName,"","",size);	}
    public static String getAutoCompleteCodeListWithSpace(String codeKind, String tableName,String sInputName,String sValue)
    {	return getAutoCompleteCodeListWithSpace(codeKind,tableName,sInputName,sValue,"",6);	}
    public static String getAutoCompleteCodeListWithSpace(String codeKind, String tableName,String sInputName,String sValue,int size)
    {	return getAutoCompleteCodeListWithSpace(codeKind,tableName,sInputName,sValue,"",size);	}
    public static String getAutoCompleteCodeListWithSpace(String codeKind, String tableName,String sInputName,String sValue,String sProperties)
    {	return getAutoCompleteCodeListWithSpace(codeKind,tableName,sInputName,sValue,sProperties,6);	}
    public static String getAutoCompleteCodeListWithSpace(String codeKind, String tableName,String sInputName,String sValue,String sProperties,int size)
    {
    	List codeList = getCodeList(codeKind,tableName);
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
			
            for (Iterator it = codeList.iterator(); it.hasNext();)
            {
            	LabelValueBean bean = (LabelValueBean) it.next();
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

    
    public static String getAutoCompleteCodeListWithSpace2(String codeKind, String tableName,String sInputName,String sTextName)
    {	return getAutoCompleteCodeListWithSpace2(codeKind,tableName,sInputName,sTextName,6);	}
    public static String getAutoCompleteCodeListWithSpace2(String codeKind, String tableName,String sInputName,String sTextName,int size)
    {	return getAutoCompleteCodeListWithSpace2(codeKind,tableName,sInputName,sTextName,size);	}
    public static String getAutoCompleteCodeListWithSpace2(String codeKind, String tableName,String sInputName,String sTextName,String sValue)
    {	return getAutoCompleteCodeListWithSpace2(codeKind,tableName,sInputName,sTextName,sValue,6);	}
    public static String getAutoCompleteCodeListWithSpace2(String codeKind, String tableName,String sInputName,String sTextName,String sValue,int size)
    {	return getAutoCompleteCodeListWithSpace2(codeKind,tableName,sInputName,sTextName,sValue,size);	}
    public static String getAutoCompleteCodeListWithSpace2(String codeKind, String tableName,String sInputName,String sTextName,String sValue,String sProperties)
    {	return getAutoCompleteCodeListWithSpace2(codeKind,tableName,sInputName,sTextName,sValue,sProperties,6);	}
    public static String getAutoCompleteCodeListWithSpace2(String codeKind, String tableName,String sInputName,String sTextName,String sValue,String sProperties,int size)
    {
    	List codeList = getCodeList(codeKind,tableName);
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
            for (Iterator it = codeList.iterator(); it.hasNext();)
            {
            	LabelValueBean bean = (LabelValueBean) it.next();
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

    
    public static String getRadioCodeListBySql(List<LabelValueBean> list,String sInputName)
    {	return getRadioCodeListBySql(list,sInputName,"");	}
    public static String getRadioCodeListBySql(List<LabelValueBean> list,String sInputName,String sValue)
    {	return getRadioCodeListBySql(list,sInputName,sValue,"");	}
    public static String getRadioCodeListBySql(List<LabelValueBean> list,String sInputName,String sValue,String sProperties)
    {
    	StringBuffer sb = new StringBuffer();
    	if(list!=null)
    	{
            for (Iterator<LabelValueBean> it = list.iterator(); it.hasNext();)
            {
            	LabelValueBean bean = it.next();
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

    public static List getCodeList(String codeKind,String tableName)
    {
        return new LinkedList();
    }
}
