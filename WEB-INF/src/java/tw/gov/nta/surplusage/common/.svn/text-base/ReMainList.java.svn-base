package tw.gov.nta.surplusage.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReMainList{
	/**GARA33,34使用
	 * 預算數的本年度未償餘額=上一年度的未償餘額(決算數)+本年度的舉借數(預算數)-本年度的還本數(預算數)
	 * 計算累積未償餘額countNOPayList
	 * 傳入值:List tList = SQL查詢 發行額與還本額 歷年明細表
	 * 傳入值:String [] otherField = 不列為計算的欄位
	 * 傳入值:String [] issueField = 各債種發行額欄位
	 * 傳入值:String [] PayField = 各債種還本欄位
	 * 傳入值:String AccountKind = account_kind的欄位名稱(若AccountKind = "noKind" 不分類別計算)
	 * 傳回 List = 計算後的 發行額與未償餘額 歷年明細表
	 */
	@SuppressWarnings("unchecked")
	public List countNOPayList(List tList,String [] otherField,String [] issueField,String [] PayField,String AccountKind){
		List dList = new ArrayList();
		Map tMap = new HashMap();
		Map dMap = new HashMap();
		
		//payAmount未償餘額陣列 [account_kind][未償餘額欄位]
		BigDecimal [][] noPayAmount = new BigDecimal[4][PayField.length];
		//發行數的暫存
		BigDecimal [] tempTotal = new BigDecimal[PayField.length];
		//上年度決算數的暫存
		BigDecimal [] lastAuditIssueAmount = new BigDecimal[PayField.length];
		BigDecimal [] lastAuditPayAmount = new BigDecimal[PayField.length];
		for (int ii = 0 ; ii  < 4 ; ii++ ){
			for (int jj = 0 ; jj < PayField.length ; jj++ ){
				noPayAmount[ii][jj] = new BigDecimal(0);
				tempTotal[jj] = new BigDecimal(0);
				lastAuditIssueAmount[jj] = new BigDecimal(0);
				lastAuditPayAmount[jj] = new BigDecimal(0);
			}
		}
		 
		//何種account_kind的index變數
		int kind = 0;
		
		//哪一個未償餘額欄位的index變數
		int rIndex = 0;
		
		//逐筆記算
		for (Iterator it1 = tList.iterator(); it1.hasNext();){
			tMap = (Map) it1.next();
			dMap = new HashMap();
			/*何種account_kind,得到 payAmount[kind][?]的kind之index值
			 * kind = 0 =>預算數
			 * 		= 1 =>決算數
			 * 		= 2 =>保留數
			 * 		= 3 =>實際數
			 */
			if ("noKind".equals(AccountKind))
				kind=0;
			else
				kind = Integer.parseInt((String)tMap.get(AccountKind))-1;
			
				
			//先寫入其他不列入計算的欄位
			for (int k = 0 ; k < otherField.length ; k++ ){
				dMap.put(otherField[k],tMap.get(otherField[k]));
			}
			
			//清除tempTotal發行數的暫存
			for (int jjj = 0 ; jjj < PayField.length ; jjj++ ){
				tempTotal[jjj] = new BigDecimal(0);
			}
			
			//依各債種計算出總發行數
			for (int j = 0 ; j < issueField.length ; j++ ){
				rIndex = Integer.parseInt(issueField[j].substring(2,issueField[j].length()))-1;
				tempTotal[rIndex] = tempTotal[rIndex].add((tMap.get(issueField[j])!=null)?(BigDecimal)tMap.get(issueField[j]):new BigDecimal(0));
				dMap.put(issueField[j],(BigDecimal)tMap.get(issueField[j]));
			}
			for(int z = 0 ; z < PayField.length ; z++){
				if(kind == 0){
					//預算數的本年度未償餘額=上一年度的未償餘額(X)+本年度的舉借數(預算數)-本年度的還本數(預算數)
					//先取得上年度決算數判斷是否為0,X取預算數反之取決算數
					if(!((String)tMap.get("account_year")).equals("088上半及089")){
						if(Integer.parseInt((String)((Map)tList.get(tList.size()-1)).get("account_year"))>new Date().getYear()-11 ){
							if(Integer.parseInt((String)((Map)tList.get(tList.size()-1)).get("account_year"))-1 <= Integer.parseInt((String)tMap.get("account_year"))){
								if(lastAuditIssueAmount[z].compareTo(new BigDecimal(0)) ==0 && lastAuditPayAmount[z].compareTo(new BigDecimal(0))==0)
									noPayAmount[kind][z] = noPayAmount[kind][z].add(tempTotal[z]).subtract((BigDecimal)tMap.get(PayField[z]));
								else
									noPayAmount[kind][z] = noPayAmount[kind+1][z].add(tempTotal[z]).subtract((BigDecimal)tMap.get(PayField[z]));
							}else
								noPayAmount[kind][z] = noPayAmount[kind+1][z].add(tempTotal[z]).subtract((BigDecimal)tMap.get(PayField[z]));
						}
						else
							noPayAmount[kind][z] = noPayAmount[kind+1][z].add(tempTotal[z]).subtract((BigDecimal)tMap.get(PayField[z]));
					}
					else
						noPayAmount[kind][z] = noPayAmount[kind+1][z].add(tempTotal[z]).subtract((BigDecimal)tMap.get(PayField[z]));
				}
				else
					noPayAmount[kind][z] = noPayAmount[kind][z].add(tempTotal[z]).subtract((BigDecimal)tMap.get(PayField[z]));
				//若當年發行與還本皆為0則未償餘額顯示為0
//				if(tempTotal[z].compareTo(new BigDecimal(0))==0 && ((BigDecimal)tMap.get(PayField[z])).compareTo(new BigDecimal(0))==0)
//					dMap.put(PayField[z],new BigDecimal(0));
//				else
					dMap.put(PayField[z],noPayAmount[kind][z]);
				//dMap.put(PayField[z],noPayAmount[kind][z]);
			}
			
			//或為決算數將資料放進暫存檔
			if(kind == 1){
				for (int i = 0 ; i < PayField.length ; i++ ){
					lastAuditIssueAmount[i] = new BigDecimal(0);
					lastAuditPayAmount[i] = new BigDecimal(0);
				}
				for(int i = 0 ; i < issueField.length ; i++){
					int tempIndex = Integer.parseInt(issueField[i].substring(2,issueField[i].length()))-1;
					lastAuditIssueAmount[tempIndex] = lastAuditIssueAmount[tempIndex].add((tMap.get(issueField[i])!=null)?(BigDecimal)tMap.get(issueField[i]):new BigDecimal(0));
				}
				for(int i = 0 ; i < PayField.length ; i ++){
					lastAuditPayAmount[i] = lastAuditPayAmount[i].add((BigDecimal)tMap.get(PayField[i]));
				}
			}
		/*  mark by Andrew 2006/10/23
			//依各債種將noPayAmount加上今年的發行數
			for (int z = 0 ; z < PayField.length ; z++ ){
				//預算數的本年度未償餘額=上一年度的未償餘額(決算數/預算數)+本年度的舉借數(預算數)-本年度的還本數(預算數)
				if (kind==0){
					if(((BigDecimal)tMap.get(issueField[z])).compareTo(new BigDecimal(0))==0 && ((BigDecimal)tMap.get(PayField[z])).compareTo(new BigDecimal(0))==0)
						noPayAmount[kind][z]=noPayAmount[kind][z].add(new BigDecimal(0));
					else
						noPayAmount[kind][z]=noPayAmount[kind+1][z].add(tempTotal[z]);
				}
				else
					noPayAmount[kind][z] = noPayAmount[kind][z].add(tempTotal[z]);
				
			}
			
			//依各債種將noPayAmount減掉今年的還本數
			for (int i = 0 ; i < PayField.length ; i++ ){
				if(((BigDecimal)tMap.get(issueField[i])).compareTo(new BigDecimal(0))==0 && ((BigDecimal)tMap.get(PayField[i])).compareTo(new BigDecimal(0))==0)
					noPayAmount[kind][i]=noPayAmount[kind][i].subtract(new BigDecimal(0));
				else
					noPayAmount[kind][i]=noPayAmount[kind][i].subtract((BigDecimal)tMap.get(PayField[i]));
				if(tempTotal[i].compareTo(new BigDecimal(0))==0 && ((BigDecimal)tMap.get(PayField[i])).compareTo(new BigDecimal(0))==0)
					dMap.put(PayField[i],new BigDecimal(0));
				else
					dMap.put(PayField[i],noPayAmount[kind][i]);
			}
		*/
		
//		List dList = new ArrayList();
//		Map tMap = new HashMap();
//		Map dMap = new HashMap();
//		
//		//payAmount未償餘額陣列 [account_kind][未償餘額欄位]
//		BigDecimal [][] noPayAmount = new BigDecimal[4][PayField.length];
//		//發行數的暫存
//		BigDecimal [] tempTotal = new BigDecimal[PayField.length];
//		for (int ii = 0 ; ii  < 4 ; ii++ ){
//			for (int jj = 0 ; jj < PayField.length ; jj++ ){
//				noPayAmount[ii][jj] = new BigDecimal(0);
//				tempTotal[jj] = new BigDecimal(0);
//			}
//		}
//		
//		//何種account_kind的index變數
//		int kind = 0;
//		
//		//哪一個未償餘額欄位的index變數
//		int rIndex = 0;
//		
//		//逐筆記算
//		for (Iterator it1 = tList.iterator(); it1.hasNext();){
//			tMap = (Map) it1.next();
//			dMap = new HashMap();
//			/*何種account_kind,得到 payAmount[kind][?]的kind之index值
//			 * kind = 0 =>預算數
//			 * 		= 1 =>決算數
//			 * 		= 2 =>保留數
//			 * 		= 3 =>實際數
//			 */
//			if ("noKind".equals(AccountKind))
//				kind=0;
//			else
//				kind = Integer.parseInt((String)tMap.get(AccountKind))-1;
//			
//			//先寫入其他不列入計算的欄位
//			
//			for (int k = 0 ; k < otherField.length ; k++ ){
//				dMap.put(otherField[k],tMap.get(otherField[k]));
//			}
//			
//			//清除temp
//			for (int jjj = 0 ; jjj < PayField.length ; jjj++ ){
//				tempTotal[jjj] = new BigDecimal(0);
//			}
//			//依各債種計算出總發行數
//			for (int j = 0 ; j < issueField.length ; j++ ){
//				rIndex = Integer.parseInt(issueField[j].substring(2,issueField[j].length()))-1;
//				tempTotal[rIndex] = tempTotal[rIndex].add((BigDecimal)tMap.get(issueField[j]));
//				dMap.put(issueField[j],(BigDecimal)tMap.get(issueField[j]));
//			}
//			//依各債種將noPayAmount加上今年的發行數
//			for (int z = 0 ; z < PayField.length ; z++ ){
//				//預算數的本年度未償餘額=上一年度的未償餘額(決算數)+本年度的舉借數(預算數)-本年度的還本數(預算數)
//				if (kind==0)
//					noPayAmount[kind][z]=noPayAmount[kind+1][z].add(tempTotal[z]);
//				else
//					noPayAmount[kind][z] = noPayAmount[kind][z].add(tempTotal[z]);
//			}
//			
//			//依各債種將noPayAmount減掉今年的還本數
//			for (int i = 0 ; i < PayField.length ; i++ ){
//				noPayAmount[kind][i]=noPayAmount[kind][i].subtract((BigDecimal)tMap.get(PayField[i]));
//				dMap.put(PayField[i],noPayAmount[kind][i]);
//			}
		
			dList.add(dMap);
		}
		return dList;
	}
}