/*
 * 在 2006/2/22 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
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
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class Fama0601Form extends SupportForm {
	private static final long serialVersionUID = 1L;

		private String qrynationNo;			//國別代號
		private String qrycontinentNo;		//洲別代號
		private String qrynationCname;		//國家中文名稱
		private String qrynationEname;		//國家英文名稱
		private String qryremark;		//備註
		//private String nationNo;		//國別代號
		//private String continentNo;		//洲別代號
		//private String nationCname;		//國家中文名稱
		//private String nationEname;		//國家英文名稱
		//private String remark;			//備註
		//private int id;					//主鍵值
		//private Date createDate;		//新增日期
		//private Date modDate;			//修改日期
		//private String usrid;			//使用者id
		
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
