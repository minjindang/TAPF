/* APRA08�����F���n�������٥��I���ֵ����B��
�{���ت��GAPRA08
�{���N���GAPRA08
�{������G0950317
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import java.util.Date;

import gov.dnt.tame.common.SupportForm;

public class Apra0801Form extends SupportForm {
		
	private static final long serialVersionUID = 1L;
	private Date closeSdate ; //����_ �}�l
	private Date closeEdate ; //����� ����
	private String year ; //�~��
	private String type ; //�W�b�~�U�b�~
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
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
