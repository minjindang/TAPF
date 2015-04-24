package tw.gov.nta.surplusage.common;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.MapListHandler;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLRunner;

public class Gara33ReMainList extends ReMainList {

	private List dataList;
	private Map qryMap;
	private String qryYear;
	private String[] otherField = {"item","account_kind","account_year"};
	private String[] issueField = {"TA1","TB1","TA2","TB2","TA3","TA4","TA5"};
	private String[] noPayField = {"SA1","SA2","SA3","SA4","SA5"};

	public Gara33ReMainList(Connection conn,String qryEndYear,BigDecimal unit)throws Exception{
		SQLRunner run = new ConnectionSQLRunner(conn);
		List qryGara33 = (List) run.query(CommonReportSQL.Gara33SQL(qryEndYear,unit,null), new MapListHandler());
		setDataList(countNOPayList(qryGara33,otherField,issueField,noPayField,"account_kind"));
	}
	public Gara33ReMainList(Connection conn,String qryEndYear,BigDecimal unit,String inputType)throws Exception{
		SQLRunner run = new ConnectionSQLRunner(conn);
		List qryGara33 = (List) run.query(CommonReportSQL.Gara33SQL(qryEndYear,unit,inputType), new MapListHandler());
		setDataList(countNOPayList(qryGara33,otherField,issueField,noPayField,"account_kind"));
	}
	/*
	public Gara33ReMainList(List tlist){
		setDataList(countNOPayList(tlist,otherField,issueField,noPayField,"account_kind"));
	}
	*/
	public List getDataList() {
		return dataList;
	}

	public void setDataList(List dataList) {
		this.dataList = dataList;
	}

	public Map getQryMap() {
		return qryMap;
	}

	private void setQryMap(Map qryMap) {
		this.qryMap = qryMap;
	}

	public String getQryYear() {
		return qryYear;
	}

	private void setQryYear(String qryYear) {
		this.qryYear = qryYear;
	}

	public void setQryMap(String qryYear,String qryKind){
		Map tMap = null;
		String accountYear = "";
		String accountKind = "";
		for(Iterator tIterator = dataList.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			accountYear = ((String)tMap.get("account_year")).substring(0,3);
			accountKind = ((String)tMap.get("account_kind"));
			if(accountYear.equals(qryYear) && accountKind.equals(qryKind)){
				setQryMap(tMap);
				setQryYear(qryYear);
				break;
			}
		}
	}
	
	
	
	/**
	 * ���o�U���v�l�B�`��
	 * @param String[] index
	 * 			index = {"1","2","3","4","5"};
	 * 			"1"=�������v�l�B
	 * 			"2"=�A�����v�l�B
	 * 			"3"=�ٶť��v�l�B
	 * 			"4"=�E�G�@�����v�l�B
	 * 			"5"=�ŰȰ�����v�l�B
	 * @return BigDecimal sum
	 */
	public BigDecimal getReMainTotal(){
		String[] index = {"1","2","3","4","5"};
		BigDecimal sum = new BigDecimal(0);
		for(int j = 1 ; j <= index.length ; j++){
			//���v�l�B�X�p
			if (Integer.parseInt(qryYear) >= 91 && Integer.parseInt(index[j-1])==2)
				sum = sum.add(new BigDecimal(0));
			else
				sum = sum.add((BigDecimal)qryMap.get("SA"+index[j-1]));
		}
		return sum;
	}
	
	/**
	 * ���o�U�����v���BSA��쳡��
	 * @param kind
	 * @return 
	 * TA1 �o�� �`�w�� ����
	 * TA2 �o�� �S�O�w�� �A��  91�~�}�l�ŰȤ��C�J�p��
	 * TA3 �o�� �o�� �ٶ�
	 * TA4 �o�� �S�O�w�� �E�G�@
	 * TA5 �o�� �ŰȰ��
	 */
	public BigDecimal getReMainField(int index){
		BigDecimal decimal = new BigDecimal(0);
		if (qryMap != null && qryMap.size()>0)
			decimal=(BigDecimal)qryMap.get("SA"+String.valueOf(index));
		return decimal;
	}
	
	/**
	 * ���o�o�檺�U�����BTA��쳡��
	 * @param kind
	 * @return 
	 * SA1 �o�� �`�w�� ����
	 * SA2 �o�� �S�O�w�� �A��  91�~�}�l�ŰȤ��C�J�p��
	 * SA3 �o�� �o�� �ٶ�
	 * SA4 �o�� �S�O�w�� �E�G�@
	 * SA5 �o�� �ŰȰ��
	 */
	public BigDecimal getIssueFieldA(int index){
		BigDecimal decimal = new BigDecimal(0);
		if (qryMap != null && qryMap.size()>0)
			decimal=(BigDecimal)qryMap.get("TA"+String.valueOf(index));
		return decimal;
	}
	/**
	 * ���o�o�檺�U���ո`���BTB��쳡��
	 * TB?�@����
	 * @param kind
	 * @return
	 */
	public BigDecimal getIssueFieldB(int index){
		BigDecimal decimal = new BigDecimal(0);
		if (qryMap != null && qryMap.size()>0)
			decimal=(BigDecimal)qryMap.get("TB"+String.valueOf(index));
		return decimal;
	}
	/**
	 * ���o��L���
	 * @param kind = ���W��
	 * @return
	 */
	public String getOtherKind(String kind){
		String str = "";
		if (qryMap != null && qryMap.size()>0)
			str=(String)qryMap.get(kind);
		return str;
	}
	
}
