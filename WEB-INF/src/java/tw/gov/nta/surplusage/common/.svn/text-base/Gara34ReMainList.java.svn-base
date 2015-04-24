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
	 * 取得各未償餘額總數
	 * @param String[] index
	 * 			index = {"1","2","3","4","5","6","7","8","9","10","11"};
	 * 			"1"=總預算未償餘額
	 * 			"2"=特別預算-戰機未償餘額
	 * 			"3"=特別預算-北二高未償餘額
	 * 			"4"=特別預算-乙類借款未償餘額
	 * 			"5"=特別預算-立法院遷建未償餘額
	 * 			"6"=九二一等未償餘額
	 * 			"7"=省債未償餘額
	 * 			"8"=新生地開發未償餘額
	 * 			"9"=糧食平準基金基金未償餘額
	 * 			"10"=債務基金未償餘額
	 * 			"11"=非營業基金未償餘額
	 * @return BigDecimal sum
	 */
	public BigDecimal getReMainTotal(){
		String[] index = {"1","2","3","4","5","6","7","8","9","10","11"};
		BigDecimal sum = new BigDecimal(0);
		for(int j = 1 ; j <= index.length ; j++){
			//未償餘額合計
			if (Integer.parseInt(qryYear) >= 91 && Integer.parseInt(index[j-1])==4)
				sum = sum.add(new BigDecimal(0));
			else
				sum = sum.add((BigDecimal)qryMap.get("SA"+index[j-1]));
		}
		return sum;
	}
	/**
	 * 取得各未償餘額的各項金額
	 * @param index
	 * @return
	 * SA1 發行 總預算
	 * SA2 發行 特別預算 戰機
	 * SA3 發行 特別預算 北二高
	 * SA4 發行 特別預算 乙類
	 * SA5 發行 特別預算 立院遷建
	 * SA6 發行 特別預算 九二一等
	 * SA7 發行 特別預算 省債
	 * SA8 發行 新生地開發
	 * SA9 發行 特別預算 糧食平準基金
	 * SA10 發行 債務基金
	 * SA11 發行 特別預算 非營業基金
	 */
	public BigDecimal getReMainField(int index){
		BigDecimal decimal = new BigDecimal(0);
		if (qryMap != null && qryMap.size()>0)
			decimal=(BigDecimal)qryMap.get("SA"+String.valueOf(index));
		return decimal;
	}
	
	/**
	 * 取得發行的各項金額
	 * @param index
	 * @return 金額
	 * 
	 * TA1 發行 總預算
	 * TA2 發行 特別預算 戰機
	 * TA3 發行 特別預算 北二高
	 * TA4 發行 特別預算 乙類
	 * TA5 發行 特別預算 立院遷建
	 * TA6 發行 特別預算 九二一等
	 * TA7 發行 特別預算 省債
	 * TA8 發行 新生地開發
	 * TA9 發行 特別預算 糧食平準基金
	 * TA10 發行 債務基金
	 * TA11 發行 特別預算 非營業基金
	 */
	public BigDecimal getIssueFieldA(int index){
		BigDecimal decimal = new BigDecimal(0);
		if (qryMap != null && qryMap.size()>0)
			decimal=(BigDecimal)qryMap.get("TA"+String.valueOf(index));
		return decimal;
	}
	/**
	 * 取得發行的各項金額TB欄位部份
	 * TB?　項目
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
