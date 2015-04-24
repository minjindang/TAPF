/* APRA06中央政府債務基金專戶轉帳支付授權書
程式目的：APRA06
程式代號：APRA06
程式日期：0950317
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import java.util.Date;

import gov.dnt.tame.common.SupportForm;

public class Apra0601Form extends SupportForm {
		
	private static final long serialVersionUID = 1L;
	private String repayDate ; //還本付息年月
	private String showType;
	public String getRepayDate() {
		return repayDate;
	}

	public void setRepayDate(String repayDate) {
		this.repayDate = repayDate;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}
	
	
	
}
