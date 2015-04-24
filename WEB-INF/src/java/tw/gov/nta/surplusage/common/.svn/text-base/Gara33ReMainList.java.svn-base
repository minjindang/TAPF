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
	 * 取得各未償餘額總數
	 * @param String[] index
	 * 			index = {"1","2","3","4","5"};
	 * 			"1"=甲類未償餘額
	 * 			"2"=乙類未償餘額
	 * 			"3"=省債未償餘額
	 * 			"4"=九二一等未償餘額
	 * 			"5"=債務基金未償餘額
	 * @return BigDecimal sum
	 */
	public BigDecimal getReMainTotal(){
		String[] index = {"1","2","3","4","5"};
		BigDecimal sum = new BigDecimal(0);
		for(int j = 1 ; j <= index.length ; j++){
			//未償餘額合計
			if (Integer.parseInt(qryYear) >= 91 && Integer.parseInt(index[j-1])==2)
				sum = sum.add(new BigDecimal(0));
			else
				sum = sum.add((BigDecimal)qryMap.get("SA"+index[j-1]));
		}
		return sum;
	}
	
	/**
	 * 取得各項未償金額SA欄位部份
	 * @param kind
	 * @return 
	 * TA1 發行 總預算 甲類
	 * TA2 發行 特別預算 乙類  91年開始債務不列入計算
	 * TA3 發行 發行 省債
	 * TA4 發行 特別預算 九二一
	 * TA5 發行 債務基金
	 */
	public BigDecimal getReMainField(int index){
		BigDecimal decimal = new BigDecimal(0);
		if (qryMap != null && qryMap.size()>0)
			decimal=(BigDecimal)qryMap.get("SA"+String.valueOf(index));
		return decimal;
	}
	
	/**
	 * 取得發行的各項金額TA欄位部份
	 * @param kind
	 * @return 
	 * SA1 發行 總預算 甲類
	 * SA2 發行 特別預算 乙類  91年開始債務不列入計算
	 * SA3 發行 發行 省債
	 * SA4 發行 特別預算 九二一
	 * SA5 發行 債務基金
	 */
	public BigDecimal getIssueFieldA(int index){
		BigDecimal decimal = new BigDecimal(0);
		if (qryMap != null && qryMap.size()>0)
			decimal=(BigDecimal)qryMap.get("TA"+String.valueOf(index));
		return decimal;
	}
	/**
	 * 取得發行的各項調節金額TB欄位部份
	 * TB?　項目
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
	 * 取得其他欄位
	 * @param kind = 欄位名稱
	 * @return
	 */
	public String getOtherKind(String kind){
		String str = "";
		if (qryMap != null && qryMap.size()>0)
			str=(String)qryMap.get(kind);
		return str;
	}
	
}
