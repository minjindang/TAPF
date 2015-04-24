/*
 * �b 2006/2/24 �إ�
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ��ɮת��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
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
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
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
			// TODO �۰ʲ��� catch �϶�
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