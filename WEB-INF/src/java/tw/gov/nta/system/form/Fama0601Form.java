/*
 * �b 2006/2/22 �إ�
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ��ɮת��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
package tw.gov.nta.system.form;

import gov.dnt.tame.common.SupportForm;

import java.util.Date;
import java.util.Set;

import tw.gov.nta.sql.NationDebitMain;
import tw.gov.nta.sql.NationRef;

/**
 * @author EricChen
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class Fama0601Form extends SupportForm {
	private static final long serialVersionUID = 1L;

		private String qrynationNo;			//��O�N��
		private String qrycontinentNo;		//�w�O�N��
		private String qrynationCname;		//��a����W��
		private String qrynationEname;		//��a�^��W��
		private String qryremark;		//�Ƶ�
		//private String nationNo;		//��O�N��
		//private String continentNo;		//�w�O�N��
		//private String nationCname;		//��a����W��
		//private String nationEname;		//��a�^��W��
		//private String remark;			//�Ƶ�
		//private int id;					//�D���
		//private Date createDate;		//�s�W���
		//private Date modDate;			//�ק���
		//private String usrid;			//�ϥΪ�id
		
		NationRef myDto = new NationRef();
		public NationRef getMyDto() {
			return myDto;
		}
		public void setMyDto(NationRef myDto) {
			this.myDto = myDto;
		}
		public String getQrycontinentNo() {
			return qrycontinentNo;
		}
		public void setQrycontinentNo(String qrycontinentNo) {
			this.qrycontinentNo = qrycontinentNo;
		}
		public String getQrynationCname() {
			return qrynationCname;
		}
		public void setQrynationCname(String qrynationCname) {
			qrynationCname = java.net.URLDecoder.decode(qrynationCname);
			this.qrynationCname = qrynationCname;
		}
		public String getQrynationEname() {
			return qrynationEname;
		}
		public void setQrynationEname(String qrynationEname) {
			qrynationEname = java.net.URLDecoder.decode(qrynationEname);
			this.qrynationEname = qrynationEname;
		}
		public String getQrynationNo() {
			return qrynationNo;
		}
		public void setQrynationNo(String qrynationNo) {
			this.qrynationNo = qrynationNo;
		}
		public String getQryremark() {
			return qryremark;
		}
		public void setQryremark(String qryremark) {
			this.qryremark = qryremark;
		}
		public String getContinentNo() {
			return myDto.getContinentNo();
		}
		public Date getCreateDate() {
			return myDto.getCreateDate();
		}
		public Integer getId() {
			return myDto.getId();
		}
		public Date getModDate() {
			return myDto.getModDate();
		}
		public String getNationCname() {
			return myDto.getNationCname();
		}
		public Set<NationDebitMain> getNationDebitMains() {
			return myDto.getNationDebitMains();
		}
		public String getNationEname() {
			return myDto.getNationEname();
		}
		public String getNationNo() {
			return myDto.getNationNo();
		}
		public String getRemark() {
			return myDto.getRemark();
		}
		public String getUsrid() {
			return myDto.getUsrid();
		}
		public void setContinentNo(String continentNo) {
			myDto.setContinentNo(continentNo);
		}
		public void setCreateDate(Date createDate) {
			myDto.setCreateDate(createDate);
		}
		public void setId(Integer id) {
			myDto.setId(id);
		}
		public void setModDate(Date modDate) {
			myDto.setModDate(modDate);
		}
		public void setNationCname(String nationCname) {
			myDto.setNationCname(nationCname);
		}
		public void setNationDebitMains(Set<NationDebitMain> nationDebitMains) {
			myDto.setNationDebitMains(nationDebitMains);
		}
		public void setNationEname(String nationEname) {
			myDto.setNationEname(nationEname);
		}
		public void setNationNo(String nationNo) {
			myDto.setNationNo(nationNo);
		}
		public void setRemark(String remark) {
			myDto.setRemark(remark);
		}
		public void setUsrid(String usrid) {
			myDto.setUsrid(usrid);
		}
		
}
