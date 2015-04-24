package gov.dnt.tame.util;

import java.util.List;

public class PagedProcesser
{
	public static final int DEFAULT_PAGE_SIZE = 10;
	public static final int SHORT_PAGE_SIZE = 5;

    public PagedProcesser(int Page)
    {
    	this(Page, DEFAULT_PAGE_SIZE);
    }
    private int Page, PageCount;

    public PagedProcesser(int Page, int PageCount)
    {
        this.PageCount = PageCount;
        this.Page = Page;
    }

	public String getButtonStr(List list)
    {
		int totPage = (list.size() / this.PageCount) + (((list.size() % this.PageCount) == 0) ? 0 : 1);
		int totRow = list.size();
        String tStr, sStr, nStr;
        if (totPage > 1)
        {
			sStr	=	"<select size=\"1\" name=\"SS\" class=\"formcss\" onChange=\"GoToPage(this.form, this.value-1);\">\n";
			for (int i = 1; i <= totPage; i++)
			{
				sStr	+=	"<option value=\""+i+"\" " + ((i == Page)?"selected":"") + ">"+i+"</option>\n";
			}
			sStr	+=	"</select>\n";

			if (1 == Page)
			{
				tStr	=	"<input type=\"button\" class=\"formcss\" onclick=\"GoToPage(this.form,"	+	(Page)		+	");\" value=\"下一頁\">&nbsp;\n";
   				tStr	+=	"<input type=\"button\" class=\"formcss\" onclick=\"GoToPage(this.form,"	+	(totPage-1)	+	");\" value=\"最末頁\">\n";
            }
			else if (Page == totPage)
			{
				tStr	=	"<input type=\"button\" class=\"formcss\" onclick=\"GoToPage(this.form,0);\" value=\"第一頁\">&nbsp;\n";
				tStr	+=	"<input type=\"button\" class=\"formcss\" onclick=\"GoToPage(this.form,"	+	(totPage-2)	+	");\" value=\"上一頁\">\n";
            }
			else
			{
				tStr	=	"<input type=\"button\" class=\"formcss\" onclick=\"GoToPage(this.form,0);\" value=\"第一頁\">&nbsp;\n";
				tStr	+=	"<input type=\"button\" class=\"formcss\" onclick=\"GoToPage(this.form,"	+	(Page - 2)	+	");\" value=\"上一頁\">&nbsp;\n";
				tStr	+=	"<input type=\"button\" class=\"formcss\" onclick=\"GoToPage(this.form,"	+	(Page)	+	");\" value=\"下一頁\">&nbsp;\n";
				tStr	+=	"<input type=\"button\" class=\"formcss\" onclick=\"GoToPage(this.form,"	+	(totPage-1)		+	");\" value=\"最末頁\">\n";
			}
        }
		else
		{
			tStr = "";
			sStr = "";
		}

        if (0 < totRow)
            nStr = "【第" + Page + "/" + totPage + "頁,共" + totRow + "筆】";
        else
            nStr = "";

        return tStr + "&nbsp;" + sStr + nStr;
    }
}
