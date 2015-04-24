/*
 * 在 2006/2/27 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.exchequer.form;

import gov.dnt.tame.common.SupportForm;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class Bira1301Form extends SupportForm  {
	private static final long serialVersionUID = 1L;

	private String bandNo;
	private String bankName;
	
	public String getBandNo() {
		return bandNo;
	}
	public void setBandNo(String bandNo) {
		this.bandNo = bandNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

}
