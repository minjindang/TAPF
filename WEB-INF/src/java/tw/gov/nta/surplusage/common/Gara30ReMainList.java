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
	 * 取得發行的各項金額SA欄位部份
	 * @param kind
	 * @return 金額
	 * 
	 * SA1 未償 公債 總預算 甲類
	 * SA2 未償 公債 特別預算 甲類
	 * SA3 未償 公債 特別預算 乙類
	 * SA4 未償 公債 特別預算 九二一
	 * SA5 未償 公債 債務基金
	 * SA6 未償 公債 省債
	 * SA7 未償 公債 新生地開發
	 * SA8 未償 公債 糧食平準基金
	 * SA9 未償 公債 非營業基金
	 * SA10 未償 賒借 甲類
	 * SA11 未償 賒借  乙類
	 * SA12 未償 賒借 九二一等
	 * SA13 未償 賒借 債務基金
	 * SA14 未償 賒借 省債
	 * SA15 未償 賒借 新生地開發
	 * SA16 未償 賒借 糧食平準基金
	 * SA17 未償 賒借 非營業基金
	 * SA18 未償 賒借 非營業基金(非自償)
	 * SA19 未償 公債 非營業基金(非自償)
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
	 * @return 金額
	 * 
	 * TA1 發行 公債 總預算 甲類
	 * TA2 發行 公債 特別預算 甲類
	 * TA3 發行 公債 特別預算 乙類
	 * TA4 發行 公債 特別預算 九二一
	 * TA5 發行 公債 債務基金
	 * TA6 發行 公債 省債
	 * TA7 發行 公債 新生地開發
	 * TA8 發行 公債 糧食平準基金
	 * TA9 發行 公債 非營業基金
	 * TA10 發行 賒借 甲類
	 * TA11 發行 賒借  乙類
	 * TA12 發行 賒借 九二一等
	 * TA13 發行 賒借 債務基金
	 * TA14 發行 賒借 省債
	 * TA15 發行 賒借 新生地開發
	 * TA16 發行 賒借 糧食平準基金
	 * TA17 發行 賒借 非營業基金
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
