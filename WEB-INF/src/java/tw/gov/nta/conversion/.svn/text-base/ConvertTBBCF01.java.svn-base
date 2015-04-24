package tw.gov.nta.conversion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;

import tw.gov.nta.sql.debt.BankRef;
import tw.gov.nta.sql.debt.CentralBankRef;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.CentralBankRefDAO;
import tw.gov.nta.system.common.BankCodeManage;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class ConvertTBBCF01 extends ConvertBase {
	private Connection connection = null;
	private CentralBankRefDAO  centralBankRefDao = new CentralBankRefDAO();
	public void setConnection(Connection connection){
		this.connection = connection;
	}
	@Override
	public void deleteTable(Map<String, Object> sourceData) {
//		// TODO Auto-generated method stub
		SQLRunner run = new ConnectionSQLRunner(connection);
		SQLJob sqlJob = new SQLJob();
		sqlJob.appendSQL("DELETE FROM TB0001");
		try {
			run.update(sqlJob);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		//String splitInfo ="B1ACCT:X:10,B1NME1:X:9,chek:X:2,B1PND:X:1,B1FLAG:X:1";
		String splitInfo ="B1ACCT:X:10,B1NME1:X:20";
		setSplitInfo(splitInfo);
		//抓取資料檔案名稱
		setFileName("TBBCF01");
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.conversion.ConvertBase#transIntoTable(java.util.Map)
	 */
	@Override
	public void transIntoTable(Map<String, Object> sourceData) {
		// TODO Auto-generated method stub
		Map<String, Object> tempMap = new HashMap<String, Object>();
		SQLRunner run = new ConnectionSQLRunner(connection);
		try{
				
				String B1ACCT = sourceData.get("B1ACCT").toString().trim();
				String B1NME1 = sourceData.get("B1NME1").toString().trim();
				String B1PND = B1NME1.substring(B1NME1.length()-2,B1NME1.length()-1);
				String B1FLAG = B1NME1.substring(B1NME1.length()-1,B1NME1.length());
				B1NME1= B1NME1.substring(0,B1NME1.length()-4).trim();
				tempMap.put("B1ACCT",B1ACCT);
				tempMap.put("B1NME1",B1NME1);
				tempMap.put("B1PND",B1PND);
				tempMap.put("B1FLAG",B1FLAG);
				run.update(ConvertFunction.insTemp("TB0001", tempMap));
				Session session = centralBankRefDao.getSession();
				Criteria criteria = session.createCriteria(CentralBankRef.class);
				criteria.add(Expression.eq("BankNo", sourceData.get("B1ACCT").toString()));
				List list = criteria.list();
				if(list == null || list.size() == 0){
					CentralBankRef dto = new CentralBankRef();
					dto.setBankNo(tempMap.get("B1ACCT").toString());
					dto.setBankName(tempMap.get("B1NME1").toString());
					dto.setBankType(tempMap.get("B1PND").toString());
					dto.setFreeUnit(tempMap.get("B1FLAG").toString());
					centralBankRefDao.save(dto);
				}
				else{
					for(Iterator it = list.iterator();it.hasNext();){
						CentralBankRef dto = (CentralBankRef)it.next();
						dto.setBankNo(tempMap.get("B1ACCT").toString());
						dto.setBankName(tempMap.get("B1NME1").toString());
						dto.setBankType(tempMap.get("B1PND").toString());
						dto.setFreeUnit(tempMap.get("B1FLAG").toString());
						centralBankRefDao.update(dto);
					}
				}
				String tpsbank = ConvertFunction.getTPSBANK(String.valueOf(Integer.parseInt(sourceData.get("B1ACCT").toString().trim())),"bank_code",connection);
				if(!tpsbank.equals("")){
					Integer id =Integer.parseInt(ConvertFunction.getBankCode(tpsbank, connection));
					if(id.equals(null)){
						BankRef bankRef = new BankCodeManage().get(id);
						bankRef.setBusinessKind(tempMap.get("B1PND").toString())	;
						bankRef.setFreeAmount(tempMap.get("B1FLAG").toString());
					}
				}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
