/* Dima0101Form.java
程式目的：DIMA01
程式代號：DIMA01
程式日期：095023
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.shortterm.form;

import gov.dnt.tame.common.SupportForm;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.debt.common.ContractBankManager;
import tw.gov.nta.sql.dao.BudgetRefDAO;
import tw.gov.nta.sql.debt.BankRef;
import tw.gov.nta.sql.debt.ContractBankMain;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DefaultBankRef;
import tw.gov.nta.sql.debt.dao.BankRefDAO;
import tw.gov.nta.sql.debt.dao.ContractBankMainDAO;
import tw.gov.nta.system.common.BankCodeManage;

/**
 * @author EricChen
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class Dima0101Form extends SupportForm {

	private static final long serialVersionUID = 1L;

		private String qrycontractyear;		//年度 查詢用
		private String qrybankcode;			//銀行編號 查詢用
		private BigDecimal enableborrow;	//目前可借額度
		private int bankId;
		private int qryBankId;

		ContractBankMain myConBean = new ContractBankMain();
//		BankRef myBankBean = new DefaultBankRef();
		
		
		public Integer getSourceId() {
			return myConBean.getSourceId();
		}
		public void setSourceId(Integer sourceId) {
			myConBean.setSourceId(sourceId);
		}
		public List getBankList (){
			StringBuffer hqlStr = new StringBuffer("select bankRef from BankRef bankRef where bankRef.belongToBankId = 0");
	        Session session = new ContractBankMainDAO().getSession();
			Query query = session.createQuery(hqlStr.toString());
			List list = query.list();
			List collection = new LinkedList();
			for(Iterator it = list.iterator();it.hasNext();){
				BankRef dto = (BankRef)it.next();
				Map map = new HashMap();
				map.put("id", dto.getId());
				String name = "";
				name = dto.getBankCode()+"  "+dto.getBankName();
				map.put("name", name);
				collection.add(map);
			}
			
			return collection;
		}
		public List getSourcList() {
			StringBuffer hqlStr = new StringBuffer("select contractBankMain from ContractBankMain contractBankMain where contractBankMain.id = contractBankMain.sourceId");
	        if(bankId !=0)
	        	hqlStr = hqlStr.append(" and contractBankMain.bank.id ="+bankId);
			Session session = new ContractBankMainDAO().getSession();
			Query query = session.createQuery(hqlStr.toString());
			
			List list = query.list();
			List collection = new LinkedList();
			for(Iterator it = list.iterator();it.hasNext();){
				ContractBankMain dto = (ContractBankMain)it.next();
				Map map = new HashMap();
				map.put("id", dto.getId());
				String name = "";
				name = dto.getContractYear()+"年度"+dto.getBank().getBankName();
				map.put("name", name);
				collection.add(map);
			}
			
			return collection;
		}
		public BankRef getBank() {
			return myConBean.getBank();
		}
		public BigDecimal getBorrowAmount() {
			return myConBean.getBorrowAmount();
		}
		public BigDecimal getContractAmount() {
			return myConBean.getContractAmount();
		}
		public Date getContractDate() {
			return myConBean.getContractDate();
		}
		public String getContractYear() {
			return myConBean.getContractYear();
		}
		public Integer getId() {
			return myConBean.getId();
		}
		public Date getModDate() {
			return myConBean.getModDate();
		}
		public String getUserid() {
			return myConBean.getUserid();
		}
		public void setBank(BankRef bank) {
			myConBean.setBank(bank);
		}
		public void setBorrowAmount(BigDecimal borrowAmount) {
			myConBean.setBorrowAmount(borrowAmount);
		}
		public void setContractAmount(BigDecimal contractAmount) {
			myConBean.setContractAmount(contractAmount);
		}
		public void setContractDate(Date contractDate) {
			myConBean.setContractDate(contractDate);
		}
		public void setContractYear(String contractYear) {
			myConBean.setContractYear(contractYear);
		}
		public void setId(Integer id) {
			myConBean.setId(id);
		}
		public void setModDate(Date modDate) {
			myConBean.setModDate(modDate);
		}
		public void setUserid(String userid) {
			myConBean.setUserid(userid);
		}
		public int getBankId() {
			return bankId;
		}
		public void setBankId(int bankId) {
			this.bankId = bankId;
		}
		public BigDecimal getEnableborrow() {
			return enableborrow;
		}
		public void setEnableborrow(BigDecimal enableborrow) {
			this.enableborrow = enableborrow;
		}
		public String getQrybankcode() {
			return qrybankcode;
		}
		public void setQrybankcode(String qrybankcode) {
			this.qrybankcode = qrybankcode;
		}
		public String getQrycontractyear() {
			return qrycontractyear;
		}
		public void setQrycontractyear(String qrycontractyear) {
			this.qrycontractyear = qrycontractyear;
		}
		public ContractBankMain getMyConBean() {
			return myConBean;
		}
		public void setMyConBean(ContractBankMain myConBean) {
			this.myConBean = myConBean;
		}
		public int getQryBankId() {
			return qryBankId;
		}
		public void setQryBankId(int qryBankId) {
			this.qryBankId = qryBankId;
		}
		
}
