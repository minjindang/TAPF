/* GARA3101.java ����
 �{���ت��GGARA3101
 �{���N���GGARA3101
 �{������G0950602
 �{���@�̡GAvery
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 --------------------------------------------------------
 */
package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara1601Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA1601 extends ExcelReportBaseAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM GARA16_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	protected SQLJob SQL1(Gara1601Form myForm,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select ");
//		�~��
		sqljob.appendSQL("case ");
		sqljob.appendSQL("when (account_year ='088' and year_kind='1' ) then '088' ");
		sqljob.appendSQL("when ((account_year ='088' and year_kind='2') or account_year ='089' ) then '088�W�b��089' ");
		sqljob.appendSQL("else account_year ");
		sqljob.appendSQL("end as account_year,");
		sqljob.appendSQL("case account_kind ");
		sqljob.appendSQL("when '1' then '(�w)' ");
		sqljob.appendSQL("when '2' then '(�M)' ");
		sqljob.appendSQL("when '3' then '(�|�M)' ");
		sqljob.appendSQL("when '4' then '(��)' ");
		sqljob.appendSQL("else '' ");
		sqljob.appendSQL("end as account_kind,");
//		���ŵo��B ���� �B�D�Q�j�س]�B�D�ŰȰ��=>���v�l�B
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and bound_code ='1' and is_account='N'and budget_code<>'3' ) then remain_amount else 0 end)/? as T1 ,");
//		�ɴڡB�����B�D�Q�j�س]�B�D�ŰȰ��=>���v�l�B
		sqljob.appendSQL("sum(case when ( debt_type in ( 'B','C','D') and bound_code ='1' and is_account='N' and budget_code<>'3' ) then remain_amount else 0 end)/?  as T2,");
//		���ŵo��B �A�� �B�D�Q�j�س]�B�D�ŰȰ��=>���v�l�B
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and bound_code ='2' and is_account='N'and budget_code<>'3' )then remain_amount else 0 end)/?  as T3 ,");
//		�ɴڡB�A���B�D�Q�j�س]�B�D�ŰȰ��=>���v�l�B
		sqljob.appendSQL("sum(case when ( debt_type in ( 'B','C','D') and bound_code ='2' and is_account='N' and budget_code<>'3') then remain_amount else 0 end)/?  as T4,");
//		�ٶšB�D�Q�j�س]=>���v�l�B
		sqljob.appendSQL("sum(case when (debt_type in ('F' ) and is_account='N' and budget_code = '3') then remain_amount else 0 end)/?  as T5,");
//		�Q�j�س] =>���v�l�B
		sqljob.appendSQL("sum(case when ( debt_type in ( 'A','B','C','D') and is_account='Y' ) then remain_amount else 0 end)/?  as T6,");
//		�D�Q�j�س]�B�ŰȰ��=>���v�l�B
		sqljob.appendSQL("sum(case when ( debt_type in ( 'A','B','C','D') and is_account='N' and budget_code = '3') then remain_amount else 0 end)/?  as T7,");
//		�D�Q�j�س]�B�D�ŰȰ���B³�����ǰ��=>���v�l�B
		sqljob.appendSQL("sum(case when (is_account='N' and budget_code<>'3'and debt_type in ( 'G')) then remain_amount else 0 end)/?  as T8,");
//		�D�Q�j�س]�B�D�ŰȰ���B�D��~���=>���v�l�B
		sqljob.appendSQL("sum(case when ( is_account='N' and budget_code<>'3' and debt_type in ('H' )) then remain_amount else 0 end)/?  as T9 , null as T10");
//		�s�ͦa�}�o��� �ݽT�{ �٨S�W��t10
		sqljob.appendSQL("from central_statistics_main ");
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		if (null != myForm.getIssueSyear() && null != myForm.getIssueEyear()){
			sqljob.appendSQL("where account_year between ? and ? ");
			sqljob.addParameter(myForm.getIssueSyear());
			sqljob.addParameter(myForm.getIssueEyear());
		}
//		where Account_year between Account_syear and Account_eyear
		sqljob.appendSQL("group by case ");
		sqljob.appendSQL("when (account_year ='088' and year_kind='1' ) then '088' ");
		sqljob.appendSQL("when ((account_year ='088' and year_kind='2') or account_year ='089' ) then '088�W�b��089' ");
		sqljob.appendSQL("else account_year end,");
		sqljob.appendSQL("case account_kind ");
		sqljob.appendSQL("when '1' then '(�w)' ");
		sqljob.appendSQL("when '2' then '(�M)' ");
		sqljob.appendSQL("when '3' then '(�|�M)' ");
		sqljob.appendSQL("when '4' then '(��)' ");
		sqljob.appendSQL("else '' end  ");
		sqljob.appendSQL("order by 1 ");

		return sqljob;
	}

	protected SQLJob SQL2(Map pMap,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select budget_amount/? as budget_amount, ");
		sqljob.appendSQL("GNP_amount/? as GNP_amount, ");
		sqljob.appendSQL("GDP_amount/? as GDP_amount ");
		sqljob.appendSQL("From nation_debit_main a , nation_ref b ");
		sqljob.appendSQL("Where a.nation_code = b.id ");
		sqljob.appendSQL("and b.nation_no='TW' ");
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		if(pMap.get("account_year") != null){
			sqljob.appendSQL("and account_year= case ");
			sqljob.appendSQL("when (? ='088�W�b��089'  ) then '089'");
			sqljob.appendSQL("else ? end");
			sqljob.addParameter((String)pMap.get("account_year"));
			sqljob.addParameter((String)pMap.get("account_year"));
		}
		return sqljob;
	}
	
	@SuppressWarnings("unchecked")
	protected Map setRate(Map tMap,String key){
		Map dMap = new HashMap();
		if (((BigDecimal)tMap.get("budget_amount")).intValue() != 0){
			dMap.put(key+"_r1",((BigDecimal)tMap.get("s1")).divide((BigDecimal)tMap.get(key+"_amount"),4,5));
			dMap.put(key+"_r2",(((BigDecimal)tMap.get("t3")).add((BigDecimal)tMap.get("t4"))).divide((BigDecimal)tMap.get(key+"_amount"),4,5));
			dMap.put(key+"_r3",((BigDecimal)tMap.get("t5")).divide((BigDecimal)tMap.get(key+"_amount"),4,5));
			dMap.put(key+"_r4",((BigDecimal)tMap.get("t6")).divide((BigDecimal)tMap.get(key+"_amount"),4,5));
			dMap.put(key+"_r5",((BigDecimal)tMap.get("t7")).divide((BigDecimal)tMap.get(key+"_amount"),4,5));
			dMap.put(key+"_r6",((BigDecimal)tMap.get("t8")).divide((BigDecimal)tMap.get(key+"_amount"),4,5));
			dMap.put(key+"_r7",((BigDecimal)tMap.get("s2")).divide((BigDecimal)tMap.get(key+"_amount"),4,5));
		}
		else{
			dMap.put(key+"_r1",new BigDecimal(0));
			dMap.put(key+"_r2",new BigDecimal(0));
			dMap.put(key+"_r3",new BigDecimal(0));
			dMap.put(key+"_r4",new BigDecimal(0));
			dMap.put(key+"_r5",new BigDecimal(0));
			dMap.put(key+"_r6",new BigDecimal(0));
			dMap.put(key+"_r7",new BigDecimal(0));
		}
		return dMap;
	}
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gara1601Form myForm = (Gara1601Form) form;
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		//���o�ϥΪ̱b��
		String usrId = this.getUserId(request);
		//���oSQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//���� delete 
		run.update(connection,delTemp(form,usrId));
		//���� insert
		List queryList1 = (List) run.query(SQL1(myForm,unit), new MapListHandler());
		Map tMap = null;
		List tTempList = null;
//		tCommonMap.
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tTempList = ((List)run.query(SQL2(tMap,unit),new MapListHandler()));
			if(tTempList != null && tTempList.size() > 0)
				tMap.putAll((Map)tTempList.get(0));
			else {
				tMap.put("budget_amount",new BigDecimal(0));
				tMap.put("GNP_amount",new BigDecimal(0));
				tMap.put("GDP_amount",new BigDecimal(0));
			}
				
			tMap.put("item",(String)tMap.get("account_year")+(String)tMap.get("account_kind"));
			tMap.put("s1",((BigDecimal)tMap.get("t1")).add((BigDecimal)tMap.get("t2")));
			tMap.put("s2",((BigDecimal)tMap.get("t3")).add((BigDecimal)tMap.get("t4")).add((BigDecimal)tMap.get("t5")).add((BigDecimal)tMap.get("t6")).add((BigDecimal)tMap.get("t7")).add((BigDecimal)tMap.get("t8")).add((BigDecimal)tMap.get("t9")));
			tMap.putAll(setRate(tMap,"budget"));
			tMap.putAll(setRate(tMap,"GNP"));
			tMap.putAll(setRate(tMap,"GDP"));
			
			
			
			run.update(connection,insTemp("GARA16_RPT",tMap));
		}

	}
}
