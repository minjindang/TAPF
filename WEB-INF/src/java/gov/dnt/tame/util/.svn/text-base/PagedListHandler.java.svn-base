package gov.dnt.tame.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
/**
 * Sam Hsu's PagerHandler modified to use BeanHandler for bean lists.
 * 
 * @author sam.hsu
 * @author rayt
 */
public class PagedListHandler implements ResultSetHandler
{
	public static final int DEFAULT_PAGE_SIZE = 10;
	public static final int SHORT_PAGE_SIZE = 5;
	
    private int Page, totRow, PageCount, totPage;
    private String suffix = "";
    
    public PagedListHandler(int Page)
    {
    	this(Page, DEFAULT_PAGE_SIZE);
    }

    public PagedListHandler(int Page, int PageCount)
    {
        this.PageCount = PageCount;
        this.Page = Page;
    }

    public int gettotRow()
    {
        return totRow;
    }

    public int gettotPage()
    {
        return totPage;
    }
    private int getRowCount(List list) throws Exception
    {
        try
        {
            int totROW = 0;
            totROW = list.size();
            return totROW;
        }
        catch (Exception e)
        {
            throw new Exception(e.getMessage(), e);
        }
    }

    private int getRowCount(ResultSet RS) throws Exception
    {
        try
        {
            int totROW = 0;
            RS.last();
            totROW = RS.getRow();
            RS.beforeFirst();
            return totROW;
        }
        catch (Exception e)
        {
            throw new Exception(e.getMessage(), e);
        }
    }

    private int getPageCount()
    {
        return (totRow / PageCount) + (((totRow % PageCount) == 0) ? 0 : 1);
    }

    public String getButtonStr()
    {
        String tStr, sStr, nStr;

        if (totPage > 1)
        {
            sStr =
                "<select size=\"1\" name=\"SS\" class=\"formcss\" onChange=\"GoToPage"+getSuffix()+"(this.form, this.value);\">";
            for (int i = 1; i <= totPage; i++)
            {
                if (i == Page)
                    sStr =
                        sStr
                            + "<option value=\""
                            + i
                            + "\" selected>"
                            + i
                            + "</option>";
                else
                    sStr =
                        sStr + "<option value=\"" + i + "\">" + i + "</option>";
            }
            sStr = sStr + "</select>";

            if (1 == Page)
                tStr =
                    "<input type=\"button\" class=\"formcss\" onclick=\"GoToPage"+getSuffix()+"(this.form, "
                        + (Page + 1)
                        + ");\" value=\"下一頁\">&nbsp;"
                        + "<input type=\"button\" class=\"formcss\" onclick=\"GoToPage"+getSuffix()+"(this.form, "
                        + totPage
                        + ");\" value=\"最末頁\">";
            else if (Page == totPage)
                tStr =
                    "<input type=\"button\" class=\"formcss\" onclick=\"GoToPage"+getSuffix()+"(this.form, 1);\" value=\"第一頁\">&nbsp;"
                        + "<input type=\"button\" class=\"formcss\" onclick=\"GoToPage"+getSuffix()+"(this.form, "
                        + (totPage - 1)
                        + ");\" value=\"上一頁\">";
            else
                tStr =
                    "<input type=\"button\" class=\"formcss\" onclick=\"GoToPage"+getSuffix()+"(this.form, 1);\" value=\"第一頁\">&nbsp;"
                        + "<input type=\"button\" class=\"formcss\" onclick=\"GoToPage"+getSuffix()+"(this.form, "
                        + (Page - 1)
                        + ");\" value=\"上一頁\">&nbsp;"
                        + "<input type=\"button\" class=\"formcss\" onclick=\"GoToPage"+getSuffix()+"(this.form, "
                        + (Page + 1)
                        + ");\" value=\"下一頁\">&nbsp;"
                        + "<input type=\"button\" class=\"formcss\" onclick=\"GoToPage"+getSuffix()+"(this.form, "
                        + totPage
                        + ");\" value=\"最末頁\">";

        }
        else
        {
            tStr = "";
            sStr = "";
        }

        if (0 < totRow)
            nStr = "【第" + Page + "/" + totPage + "頁,共" + this.totRow + "筆】";
        else
            nStr = "";

        return tStr + "&nbsp;" + sStr + nStr;
    }
    
    public Object handle(ResultSet rs) throws SQLException
    {
        List<Object> list = new LinkedList<Object>();

        try
        {
        	MapHandler handler = new MapHandler();
        	
            totRow = getRowCount(rs);
            totPage = getPageCount();

            if (0 < totRow)
            {
                if (Page > totPage)
                {
                    Page = totPage;
                }
                if (Page < 0)
                {
                    Page = 1;
                }
                
                if (1 < Page)
                    rs.absolute(PageCount * (Page - 1));

                for (int i = 0; i < PageCount; i++)
                {
                    list.add(handler.handle(rs));
                    if (rs.isLast())
                        break;
                }
            }
            return list;
        }
        catch (SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
        catch (Exception ex)
        {
            throw new SQLException(ex.getMessage());
        }
    }
    /**
     * @return
     */
    public String getSuffix()
    {
        return suffix;
    }

    /**
     * @param string
     */
    public void setSuffix(String string)
    {
        suffix = string;
    }
    
    public int getPage()
    {
    	return Page;
    }

}
