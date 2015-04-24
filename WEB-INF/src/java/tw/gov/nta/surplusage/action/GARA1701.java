/*
 * �b 2006/2/27 �إ�
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ��ɮת��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.sql.Connection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.debt.GaraNote;
import tw.gov.nta.surplusage.common.GaraNoteManager;
import tw.gov.nta.surplusage.form.Gara0401Form;
import tw.gov.nta.surplusage.form.Gara1701Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

/**
 * @author Jack Du
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class GARA1701 extends ExcelReportBaseAction{

	
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM GARA17_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		//System.out.println(sqljob.toString());
		return sqljob;
	}
	//�`�w��
	protected SQLJob SQL1(ActionForm form){
		Gara1701Form myForm = (Gara1701Form)form;
		SQLJob sqljob = new SQLJob();
		String unit = myForm.getAmountUnit();
		if(unit==null || unit=="")
			unit = "1";
		//20100216 chris wu �[�J���Ŵ��e�v�I
//		sqljob.appendSQL("SELECT B.Debt_NAME as debt_name, SUM(A.CAPITAL_AMOUNT)/"+unit+" as capital");
		sqljob.appendSQL("SELECT B.Debt_NAME as debt_name, (SUM(A.CAPITAL_AMOUNT)-");
		sqljob.appendSQL("isnull((select sum(CAPITAL_AMOUNT) from payment_main where issue_id = B.id and repay_date <> plan_repay_date and repay_date > '2010-01-01'),0)");
		sqljob.appendSQL(")/"+unit+" as capital");
		sqljob.appendSQL("FROM debt_main C , issue_main B , debt_plan_det A ");
		sqljob.appendSQL("WHERE (B.DEBT_TYPE = 'A') AND (C.BUDGET_CODE = '1') AND (C.ISSUE_ID=B.id) ");
		sqljob.appendSQL("and (C.ID = A.DEBT_ID) and A.CAPITAL_AMOUNT > 0");
		if (myForm.getIssueYear()!=null){
			sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,A.Repay_date, 112)-19110000)),7),1,3) = ? ");
			sqljob.addParameter(myForm.getIssueYear());
		}
		sqljob.appendSQL("GROUP BY  B.id,B.Debt_NAME , b.issue_date");
		sqljob.appendSQL("order by b.issue_date");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	//�S�O�w��
	protected SQLJob SQL2(ActionForm form){
		Gara1701Form myForm = (Gara1701Form)form;
		String unit = myForm.getAmountUnit();
		if(unit==null || unit=="")
			unit = "1";
		//20100216 chris wu �[�J���Ŵ��e�v�I
		SQLJob sqljob = new SQLJob();
//		sqljob.appendSQL("SELECT B.Debt_NAME as debt_name, SUM(A.CAPITAL_AMOUNT)/"+unit+" as capital");
		sqljob.appendSQL("SELECT B.Debt_NAME as debt_name, (SUM(A.CAPITAL_AMOUNT)-");
		sqljob.appendSQL("isnull((select sum(CAPITAL_AMOUNT) from payment_main where issue_id = B.id and repay_date <> plan_repay_date and repay_date > '2010-01-01'),0)");
		sqljob.appendSQL(")/"+unit+" as capital");
		sqljob.appendSQL("FROM debt_main C , issue_main B , debt_plan_det A ");
		sqljob.appendSQL("WHERE (B.DEBT_TYPE = 'A') AND (C.BUDGET_CODE = '2') AND (C.ISSUE_ID=B.id) ");
		sqljob.appendSQL("and (C.ID = A.DEBT_ID) and A.CAPITAL_AMOUNT > 0");
		if (myForm.getIssueYear()!=null){
			sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,A.Repay_date, 112)-19110000)),7),1,3) = ? ");
			sqljob.addParameter(myForm.getIssueYear());
		}
		sqljob.appendSQL("GROUP BY  B.id,B.Debt_NAME , b.issue_date");
		sqljob.appendSQL("order by b.issue_date");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	//�ŰȰ��
	protected SQLJob SQL3(ActionForm form){
		Gara1701Form myForm = (Gara1701Form)form;
		String unit = myForm.getAmountUnit();
		if(unit==null || unit=="")
			unit = "1";
		//20100216 chris wu �[�J���Ŵ��e�v�I
		SQLJob sqljob = new SQLJob();
//		sqljob.appendSQL("SELECT B.Debt_NAME as debt_name, SUM(A.CAPITAL_AMOUNT)/"+unit+" as capital");
		sqljob.appendSQL("SELECT B.Debt_NAME as debt_name, (SUM(A.CAPITAL_AMOUNT)-");
		sqljob.appendSQL("isnull((select sum(CAPITAL_AMOUNT) from payment_main where issue_id = B.id and repay_date <> plan_repay_date and repay_date > '2010-01-01'),0)");
		sqljob.appendSQL(")/"+unit+" as capital");
		sqljob.appendSQL("FROM debt_main C , issue_main B , debt_plan_det A ");
		sqljob.appendSQL("WHERE (B.DEBT_TYPE = 'A') AND (C.BUDGET_CODE = '3') AND (C.ISSUE_ID=B.id) ");
		sqljob.appendSQL("and (C.ID = A.DEBT_ID) and A.CAPITAL_AMOUNT > 0");
		if (myForm.getIssueYear()!=null){
			sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,A.Repay_date, 112)-19110000)),7),1,3) = ? ");
			sqljob.addParameter(myForm.getIssueYear());
		}
		sqljob.appendSQL("GROUP BY  B.id,B.Debt_NAME , b.issue_date");
		sqljob.appendSQL("order by b.issue_date");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	//�������ɴ�
	protected SQLJob SQL4(ActionForm form){
		Gara1701Form myForm = (Gara1701Form)form;
		String unit = myForm.getAmountUnit();
		if(unit==null || unit=="")
			unit = "1";
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT B.Debt_NAME as debt_name, SUM(A.CAPITAL_AMOUNT)/"+unit+" as capital");
		sqljob.appendSQL("FROM issue_main B , debt_plan_det A ");
		sqljob.appendSQL("WHERE (B.DEBT_TYPE = 'C') and (B.ID = A.ISSUE_ID) and ");
		sqljob.appendSQL(" A.CAPITAL_AMOUNT > 0 and b.bond_type=2 and a.delete_mark='N'");
		
		//Start==0970619 �ק��s���G257============
		sqljob.appendSQL("and (a.id not in(select plan_id from payment_main)");		
		sqljob.appendSQL("or a.id in (select plan_id from payment_main where substring(right('0000000'+convert(varchar,(convert(varchar,Repay_date, 112)-19110000)),7),1,3) = '"+myForm.getIssueYear()+"'))");
		//End====0970619 �ק��s���G257============
		
		if (myForm.getIssueYear()!=null){
			sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,A.Repay_date, 112)-19110000)),7),1,3) = ? ");
			sqljob.addParameter(myForm.getIssueYear());
		}
		
		sqljob.appendSQL("GROUP BY  B.Debt_NAME");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	//�e�x�W�٬F���Ű�
	protected SQLJob SQL5(ActionForm form){
		SQLJob sqljob = new SQLJob();
		System.out.println(sqljob.toString());
		return sqljob;
	}
	//�DSQL1
//	protected SQLJob SQL1(ActionForm form){
//		Gara1701Form myForm = (Gara1701Form) form;
//		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
//		SQLJob sqljob = new SQLJob();
//		sqljob.appendSQL("select ");
//		//�����F���س]���š��`�w�� =>����,���B
//		sqljob.appendSQL("(case when A. debt_type = 'A' and A.Budget_code = 1 then A.Debt_name else '' end) debt_name_1,");
//		sqljob.appendSQL("Round((case when A. debt_type = 'A' and A.Budget_code = 1 then B. capital_amount else 0 end)/? ,4) as capital_1,");
//		//�����F���س]���šЯS�O�w��=>����,���B
//		sqljob.appendSQL("(case when A. debt_type = 'A' and A.Budget_code = 2 then A.Debt_name else '' end) debt_name_2,");
//		sqljob.appendSQL("Round((case when A. debt_type = 'A' and A.Budget_code = 2 then B. capital_amount else 0 end)/? ,4) as capital_2,");
//		//�����F���س]���šжŰȰ��=>����,���B
//		sqljob.appendSQL("(case when A. debt_type = 'A' and A.Budget_code = 24 then A.Debt_name else '' end) debt_name_3,");
//		sqljob.appendSQL("Round( (case when A. debt_type = 'A' and A.Budget_code = 24 then B. capital_amount else 0 end)/? ,4) as capital_3,");
//		//�������ɴ�=>����,���B
//		sqljob.appendSQL("(case when A. debt_type = 'C' then A.Debt_name else '' end) debt_name_4,");
//		sqljob.appendSQL("Round( (case when A. debt_type = 'C' then B. capital_amount else 0 end)/? ,4) as capital_4,");
//		//�e�x�W�٬F���Ű�=>����,���B
//		sqljob.appendSQL("(case when A. debt_type = 'F' then A.Debt_name else '' end) debt_name_5,");
//		sqljob.appendSQL("Round( (case when A. debt_type = 'F' then B. capital_amount else 0 end)/? ,4) as capital_5 ");
//		sqljob.appendSQL("from issue_main A, payment_main B ");
//		sqljob.appendSQL("where B.issue_id = A.id "); 
//		sqljob.addParameter(unit);
//		sqljob.addParameter(unit);
//		sqljob.addParameter(unit);
//		sqljob.addParameter(unit);
//		sqljob.addParameter(unit);
//		if (myForm.getIssueYear()!=null){
//			sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,B.Repay_date, 112)-19110000)),7),1,3) = ? ");
//			sqljob.addParameter(myForm.getIssueYear());
//		}
//		sqljob.appendSQL("and ((A. debt_type = 'A' and A.Budget_code = 1) or (A. debt_type = 'A' and A.Budget_code = 2) or ");
//		sqljob.appendSQL("(A. debt_type = 'A' and A.Budget_code = 24) or (A. debt_type = 'C') or (A. debt_type = 'F'))");
//		sqljob.appendSQL("order by account_year, issue_serial");
//		System.out.println(sqljob.toString());
//		return sqljob;
//	}
//
//	@SuppressWarnings("unchecked")
//	/**
//	 * ��XdateList����Map
//	 * dateList = SQL1 select�X��List
//	 * fieldIndex = ���@�Ӷź�(debt_name_1,debt_name_2,debt_name_3,debt_name_4,debt_name_5)
//	 * index = �����w�j�M��źت����@�C
//	 * �Ǧ^ ���ƭȪ�Map
//	 */
//	public Map getValueMap(int index,List dateList,int fieldIndex){
//		Map dMap = new HashMap();
//		Map t2Map = new HashMap();
//		//�w�]debt_name_?="",capital_?=0 , index=�Ƕi�Ӫ�index
//		dMap.put("debt_name_"+String.valueOf(fieldIndex),"");
//		dMap.put("capital_"+String.valueOf(fieldIndex),new BigDecimal(0));
//		dMap.put("index",String.valueOf(index));
//		//�]�w�q���@�C�~��j�M
//		int rec=index;
//		
//		//�Yk�w�W�LdateList �h���Φb�j�M
//		if (rec < dateList.size() ){
//			for(int j = rec; j < dateList.size(); j++){
//				t2Map = (Map) dateList.get(j);
//				index++;
//				dMap.put("index",String.valueOf(index));
//				if ( !"".equals(((String)t2Map.get("debt_name_"+String.valueOf(fieldIndex))).trim()) && ((BigDecimal)t2Map.get("capital_"+String.valueOf(fieldIndex))).intValue() != 0 ){
//					dMap.put("debt_name_"+String.valueOf(fieldIndex),((String)t2Map.get("debt_name_"+String.valueOf(fieldIndex))).trim());
//					dMap.put("capital_"+String.valueOf(fieldIndex),(BigDecimal)t2Map.get("capital_"+String.valueOf(fieldIndex)));
//					break;
//				}
//			}
//		}
//		
//		return dMap;
//	}
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		
		Gara1701Form myForm = (Gara1701Form) form;
		GaraNote garaNote = new GaraNoteManager().getGaraNote(myForm.getPath());
		garaNote.setMemo(myForm.getMemo());
		garaNote.setPath(myForm.getPath());
		new GaraNoteManager().confirm(garaNote);
		request.setAttribute("memo",garaNote.getMemo());
		//���o�ϥΪ̱b��
		String usrId = this.getUserId(request);
		//���oSQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//���� delete 
		run.update(connection,delTemp(form,usrId));
		//���� insert
		List queryList1 = (List) run.query(SQL1(form), new MapListHandler());
		List queryList2 = (List) run.query(SQL2(form), new MapListHandler());
		List queryList3 = (List) run.query(SQL3(form), new MapListHandler());
		List queryList4 = (List) run.query(SQL4(form), new MapListHandler());
		List tempList = new LinkedList();
		int maxSize = 0 ;
		int[] size = {queryList1.size(),queryList2.size(),queryList3.size(),queryList4.size()};
		Arrays.sort(size);
		for(int i = 0;i<=size[3];i++){
			Map map1 = new HashMap();
			Map map2 = new HashMap();
			Map map3 = new HashMap();
			Map map4 = new HashMap();
			Map tempMap = new HashMap();
			if(queryList1.size()>i){
				map1 = (Map)queryList1.get(i);
				tempMap.put("debt_name_1", map1.get("debt_name"));
				tempMap.put("capital_1", map1.get("capital"));
			}
			else{
				tempMap.put("debt_name_1", null);
				tempMap.put("capital_1", null);
			}
			if(queryList2.size()>i){
				map2 = (Map)queryList2.get(i);
				tempMap.put("debt_name_2", map2.get("debt_name"));
				tempMap.put("capital_2", map2.get("capital"));
			}
			else{
				tempMap.put("debt_name_2", null);
				tempMap.put("capital_2", null);
			}
			if(queryList3.size()>i){
				map3 = (Map)queryList3.get(i);
				tempMap.put("debt_name_3", map3.get("debt_name"));
				tempMap.put("capital_3", map3.get("capital"));
			}
			else{
				tempMap.put("debt_name_3", null);
				tempMap.put("capital_3", null);
			}
			if(queryList4.size()>i){
				map4 = (Map)queryList4.get(i);
				tempMap.put("debt_name_4", map4.get("debt_name"));
				tempMap.put("capital_4", map4.get("capital"));
			}
			else{
				tempMap.put("debt_name_4", null);
				tempMap.put("capital_4", null);
			}
			run.update(connection,insTemp("GARA17_RPT",tempMap));
		}
//		List queryList1 = (List) run.query(SQL1(form), new MapListHandler());
//		Map tMap = new HashMap();
//		Map t1Map = new HashMap();
//		//�����U�źؤw�j�M����@�C
//		int [] index = {0,0,0,0,0};
//		for(int i = 0; i < queryList1.size(); i++){
//			//tMap = (Map) queryList1.get(i);
//			//��Jusrid,mod_date,remark
//			tMap.putAll(getCommonMap(usrId));
//			
//			//��X�C�ضźظ��
//			for (int k = 1; k <= index.length; k++){
//				t1Map = new HashMap();
//				t1Map = getValueMap(index[k-1],queryList1,k);
//				tMap.put("debt_name_"+String.valueOf(k),(String)t1Map.get("debt_name_"+String.valueOf(k)));
//				tMap.put("capital_"+String.valueOf(k),(BigDecimal)t1Map.get("capital_"+String.valueOf(k)));
//				index[k-1] = Integer.parseInt((String)t1Map.get("index"));
//			}
//			//�����Ҭ��ŭȤ��g�JtempTable
//			if (!"".equals((String)tMap.get("debt_name_1")) || ((BigDecimal)tMap.get("capital_1")).intValue() != 0  ||
//					!"".equals((String)tMap.get("debt_name_2")) || ((BigDecimal)tMap.get("capital_2")).intValue() != 0 ||
//					!"".equals((String)tMap.get("debt_name_3")) || ((BigDecimal)tMap.get("capital_3")).intValue() != 0 ||
//					!"".equals((String)tMap.get("debt_name_4")) || ((BigDecimal)tMap.get("capital_4")).intValue() != 0 ||
//					!"".equals((String)tMap.get("debt_name_5")) || ((BigDecimal)tMap.get("capital_5")).intValue() != 0
//					){
//				run.update(connection,insTemp("GARA17_RPT",tMap));
//			}
//		}
	}
}