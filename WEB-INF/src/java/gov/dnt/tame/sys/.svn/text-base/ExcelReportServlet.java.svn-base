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

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Variant;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class ExcelReportServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	
	private static ActiveXComponent axc ;
	
	public void init() throws ServletException {
    	try {
    		System.out.println("jacob initialize");
    		ComThread.Release();
    		ComThread.startMainSTA();
    		System.out.println("jacob initialize finish");
    	} catch (HibernateException e) {
			// TODO 自動產生 catch 區塊
			e.printStackTrace();
		}
	}
	public static ActiveXComponent getActiveXComponent() {
		if (axc==null || axc.m_pDispatch == 0) {
			axc = new ActiveXComponent("Excel.Application");
		}
		return axc;
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		if (axc !=null) {
			axc.invoke("Quit", new Variant[] {});
			axc.safeRelease();
		}
		ComThread.quitMainSTA();
		System.out.println("jacob release");
		super.destroy();

	}
}