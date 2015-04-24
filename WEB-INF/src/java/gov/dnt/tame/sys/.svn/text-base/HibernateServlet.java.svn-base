/*
 * 在 2006/2/24 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package gov.dnt.tame.sys;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.hibernate.HibernateException;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class HibernateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	public void init() throws ServletException {
    	try {
    		System.out.println("hibernate initialize");
    		tw.gov.nta.sql.base._BaseRootDAO.initialize();
    		System.out.println("hibernate initialize finish");
    	} catch (HibernateException e) {
			// TODO 自動產生 catch 區塊
			e.printStackTrace();
		}
	}
}