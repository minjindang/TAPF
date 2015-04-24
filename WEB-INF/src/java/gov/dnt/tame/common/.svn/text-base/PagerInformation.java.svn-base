/* 
 * $$head$$
 */
package gov.dnt.tame.common;

/**
 * @author rayt
 */
public class PagerInformation
{
	public static int DEFAULT_PAGE_SIZE = 10;
    public static int SHORT_PAGE_SIZE = 5;
	
	private int currentPage;
	private int totalPages;
	private int currentOffset;
	private int pageSize;
	
	public PagerInformation (int pageSize, int totalPages, int currentPage)
	{
		if (pageSize < 0)
		{
			throw new AssertionError("pageSize < 0!");
		}
		else if (totalPages < 0)
		{
			throw new AssertionError("totalPage < 0!");
		} else if (currentPage < 0 || currentPage > totalPages)
		{
			throw new AssertionError("0 < currentPage < " + totalPages + " assertion failed");
		}
		
		this.pageSize = pageSize;
		this.totalPages = totalPages;
		this.currentPage = currentPage;
		
		calculateOffset();			 
	}
	
	private void calculateOffset()
	{
		setCurrentOffset((getCurrentPage() - 1) * getPageSize());
	}
	
	/**
	 * @return
	 */
	public int getCurrentOffset()
	{
		return currentOffset;
	}

	/**
	 * @return
	 */
	public int getCurrentPage()
	{
		return currentPage;
	}

	/**
	 * @return
	 */
	public int getTotalPages()
	{
		return totalPages;
	}

	/**
	 * @param i
	 */
	public void setCurrentOffset(int i)
	{
		currentOffset = i;
	}

	/**
	 * @param i
	 */
	public void setCurrentPage(int i)
	{
		currentPage = i;
	}

	/**
	 * @param i
	 */
	public void setTotalPages(int i)
	{
		totalPages = i;
	}

	/**
	 * @return
	 */
	public int getPageSize()
	{
		return pageSize;
	}

	/**
	 * @param i
	 */
	public void setPageSize(int i)
	{
		pageSize = i;
	}
}
