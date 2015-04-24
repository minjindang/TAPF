/* APRA07中央政府實體公債還本付息核結數額表
程式目的：APRA07
程式代號：APRA07
程式日期：0950317
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import java.util.Date;

import gov.dnt.tame.common.SupportForm;

public class Apra0701Form extends SupportForm {
	private static final long serialVersionUID = 1L;
	
	private Date closeSdate ; //日期起 開始
	private Date closeEdate ; //日期迄 結束
	public Date getCloseEdate() {
		return closeEdate;
	}
	public void setCloseEdate(Date closeEdate) {
		this.closeEdate = closeEdate;
	}
	public Date getCloseSdate() {
		return closeSdate;
	}
	public void setCloseSdate(Date closeSdate) {
		this.closeSdate = closeSdate;
	}
	
	
}
