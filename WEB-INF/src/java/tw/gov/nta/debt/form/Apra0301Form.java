/* Apra0301Form.java ����
�{���ت��GAPRA03
�{���N���GAPRA03
�{������G0950309
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import java.util.Date;

import gov.dnt.tame.common.SupportForm;

public class Apra0301Form extends SupportForm {
	
	private static final long serialVersionUID = 1L;
	private Date repaySdate ; //�٥��I������_ �}�l
	private Date repayEdate ; //�٥��I������_ ����
	public Date getRepayEdate() {
		return repayEdate;
	}
	public void setRepayEdate(Date repayEdate) {
		this.repayEdate = repayEdate;
	}
	public Date getRepaySdate() {
		return repaySdate;
	}
	public void setRepaySdate(Date repaySdate) {
		this.repaySdate = repaySdate;
	}
	
	

}