package tw.gov.nta.surplusage.common;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.MapListHandler;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLRunner;

public class Gara30ReMainList extends ReMainList {

	private List dataList;
	private Map qryMap;
	private String qryYear;
	private String[] otherField = {"item","account_kind","account_year"};
	private String[] issueField = {"TA1","TA2","TA3","TA4","TA5","TA6","TA7","TA8","TA9","TA10",
									"TA11","TA12","TA13","TA14","TB14","TA15","TB15","TA16","TB16","TA17"};
	private String[] noPayField = {"SA1","SA2","SA3","SA4","SA5","SA6","SA7","SA8","SA9","SA10",
									"SA11","SA12","SA13","SA14","SA15","SA16","SA17","SA18","SA19"};

	public Gara30ReMainList(Connection conn,String qryEndYear,BigDecimal unit)throws Exception{
		SQLRunner run = new ConnectionSQLRunner(conn);
		List qryGara30 = (List) run.query(CommonReportSQL.Gara30SQL(qryEndYear,unit), new MapListHandler());
		setDataList(countNOPayList(qryGara30,otherField,issueField,noPayField,"account_kind"));
	}
	/*
	public Gara30ReMainList(List tlist){
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

	public void setQryMap(Map qryMap) {
		this.qryMap = qryMap;
	}
	
	public String getQryYear() {
		return qryYear;
	}

	public void setQryYear(String qryYear) {
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
	 * ���o�o�檺�U�����BSA��쳡��
	 * @param kind
	 * @return ���B
	 * 
	 * SA1 ���v ���� �`�w�� ����
	 * SA2 ���v ���� �S�O�w�� ����
	 * SA3 ���v ���� �S�O�w�� �A��
	 * SA4 ���v ���� �S�O�w�� �E�G�@
	 * SA5 ���v ���� �ŰȰ��
	 * SA6 ���v ���� �ٶ�
	 * SA7 ���v ���� �s�ͦa�}�o
	 * SA8 ���v ���� ³�����ǰ��
	 * SA9 ���v ���� �D��~���
	 * SA10 ���v ���� ����
	 * SA11 ���v ����  �A��
	 * SA12 ���v ���� �E�G�@��
	 * SA13 ���v ���� �ŰȰ��
	 * SA14 ���v ���� �ٶ�
	 * SA15 ���v ���� �s�ͦa�}�o
	 * SA16 ���v ���� ³�����ǰ��
	 * SA17 ���v ���� �D��~���
	 * SA18 ���v ���� �D��~���(�D���v)
	 * SA19 ���v ���� �D��~���(�D���v)
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
	 * @return ���B
	 * 
	 * TA1 �o�� ���� �`�w�� ����
	 * TA2 �o�� ���� �S�O�w�� ����
	 * TA3 �o�� ���� �S�O�w�� �A��
	 * TA4 �o�� ���� �S�O�w�� �E�G�@
	 * TA5 �o�� ���� �ŰȰ��
	 * TA6 �o�� ���� �ٶ�
	 * TA7 �o�� ���� �s�ͦa�}�o
	 * TA8 �o�� ���� ³�����ǰ��
	 * TA9 �o�� ���� �D��~���
	 * TA10 �o�� ���� ����
	 * TA11 �o�� ����  �A��
	 * TA12 �o�� ���� �E�G�@��
	 * TA13 �o�� ���� �ŰȰ��
	 * TA14 �o�� ���� �ٶ�
	 * TA15 �o�� ���� �s�ͦa�}�o
	 * TA16 �o�� ���� ³�����ǰ��
	 * TA17 �o�� ���� �D��~���
	 */
	public BigDecimal getIssueFieldA(int index){
		BigDecimal decimal = new BigDecimal(0);
			if (qryMap != null && qryMap.size()>0)
				decimal=(BigDecimal)qryMap.get("TA"+String.valueOf(index));
		return decimal;
	}
	
	/**
	 * 
	 * @param kind
	 * @return
	 */
	public String getOtherKind(String kind){
		String str = "";
		if (qryMap != null && qryMap.size()>0)
			str=(String)qryMap.get(kind);
		return str;
	}
}
