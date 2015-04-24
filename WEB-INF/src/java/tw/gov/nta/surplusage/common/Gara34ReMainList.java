package tw.gov.nta.surplusage.common;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.MapListHandler;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLRunner;

public class Gara34ReMainList extends ReMainList {

	private List dataList;
	private Map qryMap;
	private String qryYear;
	private String[] otherField = {"account_year","account_kind_name","account_kind"};
	private String[] issueField = {"TA1","TB1","TC1","TA2","TA3","TA4","TA5","TA6","TA7","TB7","TA8","TB8","TA9","TB9","TA10","TA11"};
	private String[] noPayField = {"SA1","SA2","SA3","SA4","SA5","SA6","SA7","SA8","SA9","SA10","SA11"};

	public Gara34ReMainList(Connection conn,String qryEndYear,BigDecimal unit)throws Exception{
		SQLRunner run = new ConnectionSQLRunner(conn);
		List qryGara34 = (List) run.query(CommonReportSQL.Gara34SQL(qryEndYear,unit,null), new MapListHandler());
		setDataList(countNOPayList(qryGara34,otherField,issueField,noPayField,"account_kind"));
	}
	public Gara34ReMainList(Connection conn,String qryEndYear,BigDecimal unit,String inputType)throws Exception{
		SQLRunner run = new ConnectionSQLRunner(conn);
		List qryGara34 = (List) run.query(CommonReportSQL.Gara34SQL(qryEndYear,unit,inputType), new MapListHandler());
		setDataList(countNOPayList(qryGara34,otherField,issueField,noPayField,"account_kind"));
	}
	/*
	public Gara34ReMainList(List tlist){
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
			accountYear = ((String)tMap.get("account_year")).substring(((String)tMap.get("account_year")).length()-3,((String)tMap.get("account_year")).length());
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
	 * 			index = {"1","2","3","4","5","6","7","8","9","10","11"};
	 * 			"1"=�`�w�⥼�v�l�B
	 * 			"2"=�S�O�w��-�Ծ����v�l�B
	 * 			"3"=�S�O�w��-�_�G�����v�l�B
	 * 			"4"=�S�O�w��-�A���ɴڥ��v�l�B
	 * 			"5"=�S�O�w��-�ߪk�|�E�إ��v�l�B
	 * 			"6"=�E�G�@�����v�l�B
	 * 			"7"=�ٶť��v�l�B
	 * 			"8"=�s�ͦa�}�o���v�l�B
	 * 			"9"=³�����ǰ��������v�l�B
	 * 			"10"=�ŰȰ�����v�l�B
	 * 			"11"=�D��~������v�l�B
	 * @return BigDecimal sum
	 */
	public BigDecimal getReMainTotal(){
		String[] index = {"1","2","3","4","5","6","7","8","9","10","11"};
		BigDecimal sum = new BigDecimal(0);
		for(int j = 1 ; j <= index.length ; j++){
			//���v�l�B�X�p
			if (Integer.parseInt(qryYear) >= 91 && Integer.parseInt(index[j-1])==4)
				sum = sum.add(new BigDecimal(0));
			else
				sum = sum.add((BigDecimal)qryMap.get("SA"+index[j-1]));
		}
		return sum;
	}
	/**
	 * ���o�U���v�l�B���U�����B
	 * @param index
	 * @return
	 * SA1 �o�� �`�w��
	 * SA2 �o�� �S�O�w�� �Ծ�
	 * SA3 �o�� �S�O�w�� �_�G��
	 * SA4 �o�� �S�O�w�� �A��
	 * SA5 �o�� �S�O�w�� �߰|�E��
	 * SA6 �o�� �S�O�w�� �E�G�@��
	 * SA7 �o�� �S�O�w�� �ٶ�
	 * SA8 �o�� �s�ͦa�}�o
	 * SA9 �o�� �S�O�w�� ³�����ǰ��
	 * SA10 �o�� �ŰȰ��
	 * SA11 �o�� �S�O�w�� �D��~���
	 */
	public BigDecimal getReMainField(int index){
		BigDecimal decimal = new BigDecimal(0);
		if (qryMap != null && qryMap.size()>0)
			decimal=(BigDecimal)qryMap.get("SA"+String.valueOf(index));
		return decimal;
	}
	
	/**
	 * ���o�o�檺�U�����B
	 * @param index
	 * @return ���B
	 * 
	 * TA1 �o�� �`�w��
	 * TA2 �o�� �S�O�w�� �Ծ�
	 * TA3 �o�� �S�O�w�� �_�G��
	 * TA4 �o�� �S�O�w�� �A��
	 * TA5 �o�� �S�O�w�� �߰|�E��
	 * TA6 �o�� �S�O�w�� �E�G�@��
	 * TA7 �o�� �S�O�w�� �ٶ�
	 * TA8 �o�� �s�ͦa�}�o
	 * TA9 �o�� �S�O�w�� ³�����ǰ��
	 * TA10 �o�� �ŰȰ��
	 * TA11 �o�� �S�O�w�� �D��~���
	 */
	public BigDecimal getIssueFieldA(int index){
		BigDecimal decimal = new BigDecimal(0);
		if (qryMap != null && qryMap.size()>0)
			decimal=(BigDecimal)qryMap.get("TA"+String.valueOf(index));
		return decimal;
	}
	/**
	 * ���o�o�檺�U�����BTB��쳡��
	 * TB?�@����
	 * @param index
	 * @return
	 */
	public BigDecimal getIssueKindB(int index){
		BigDecimal decimal = new BigDecimal(0);
		if (qryMap != null && qryMap.size()>0)
			decimal=(BigDecimal)qryMap.get("TB"+String.valueOf(index));
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
