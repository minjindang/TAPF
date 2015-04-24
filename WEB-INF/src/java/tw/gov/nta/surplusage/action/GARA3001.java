/* GARA30.java ����
 �{���ت��GGARA3001
 �{���N���GGARA3001
 �{������G0950731
 �{���@�̡GAvery.Yeh
 ////////////////////////////////////////////////////////
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 ////////////////////////////////////////////////////////
 */
package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportRemainAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.common.Gara30ReMainList;
import tw.gov.nta.surplusage.form.Gara3001Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA3001 extends ExcelReportRemainAction {

	/*
	protected SQLJob SQL1(Gara3001Form myForm,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select case ");
		sqljob.appendSQL("when (account_year ='088' and year_kind='1' ) then '088' "); 
		sqljob.appendSQL("when ((account_year ='088' and year_kind='2') or account_year ='089' ) then '088�W�b��089' ");
		sqljob.appendSQL("else account_year ");
		sqljob.appendSQL("end + ");
		sqljob.appendSQL("case account_kind ");
		sqljob.appendSQL("when '1' then '(�w)' ");
		sqljob.appendSQL("when '2' then '(�M)' ");
		sqljob.appendSQL("when '3' then '(�O)' ");
		sqljob.appendSQL("when '4' then '(��)' ");
		sqljob.appendSQL("else '' ");
		sqljob.appendSQL("end item ,account_year,account_kind,");
				//�o�� �`�w�� ����
		sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code = '1'   and debt_type = 'A' then  issue_amount  else 0 end)/"+unit+" T1,");
				//�o�� �S�O�w�� ����
		sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code = '2' and is_account ='N'  and debt_type = 'A' then  issue_amount else 0 end)/"+unit+" T2,");
				//�o�� �S�O�w�� �A��
		sqljob.appendSQL("sum(case when bound_code = '2' and  budget_code = '2' and is_account ='N'  and debt_type = 'A' then  issue_amount else 0 end)/"+unit+" T3,");
				//�o�� �S�O�w�� �E�G�@
		sqljob.appendSQL("sum(case when is_account='Y'  and debt_type = 'A' then  issue_amount else 0 end )/"+unit+" T4,");
				//�o�� �ŰȰ��
		sqljob.appendSQL("sum(case when budget_code = '3'  and debt_type = 'A'   then  issue_amount else 0 end)/"+unit+" T5,");
				//���� �`�w�� ����
		sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code in ('1','2','5') and  is_account='N' and debt_type in ('C','E') then  issue_amount  else 0 end)/"+unit+" T6,");
		//sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code in ('1','2') and  is_account='N' and debt_type in ('C','E') then  issue_amount  else 0 end)/"+unit+" T6,");
				//���� �S�O�w�� �A��
		sqljob.appendSQL("sum(case when bound_code = '2'  and is_account ='N'  and debt_type in ('C','E')  then  issue_amount else 0 end)/"+unit+" T7,");
				//���� �S�O�w�� �E�G�@
		sqljob.appendSQL("sum(case when is_account='Y'  and debt_type  in ('C','E') then  issue_amount else 0 end )/"+unit+" T8,");
				//���� �ŰȰ��
		sqljob.appendSQL("sum(case when budget_code = '3'  and debt_type in ('C','E')   then  issue_amount else 0 end)/"+unit+" T9 ");
		sqljob.appendSQL("from Central_statistics_main ");
		//�s�W���~�ű���
		sqljob.appendSQL("where 1=1 and inout_type='0' ");
		//����ܫO�d��
		sqljob.appendSQL("and account_kind <> '3' ");
		//sqljob.appendSQL("where 1=1 ");
		if (!"".equals(myForm.getAccountSyear()) && !"".equals(myForm.getAccountEyear()))
			sqljob.appendSQL("and account_year between " + myForm.getAccountSyear() + " and " + myForm.getAccountEyear() + " ");
		sqljob.appendSQL("group by case ");
		sqljob.appendSQL("when (account_year ='088' and year_kind='1' ) then '088' ");
		sqljob.appendSQL("when ((account_year ='088' and year_kind='2') or account_year ='089' ) then '088�W�b��089' ");
		sqljob.appendSQL("else account_year ");
		sqljob.appendSQL("end + ");
		sqljob.appendSQL("case account_kind ");
		sqljob.appendSQL("when '1' then '(�w)' ");
		sqljob.appendSQL("when '2' then '(�M)' ");
		sqljob.appendSQL("when '3' then '(�O)' ");
		sqljob.appendSQL("when '4' then '(��)' ");
		sqljob.appendSQL("else '' ");
		sqljob.appendSQL("end ,account_kind,account_year");
		sqljob.appendSQL("order by account_year,account_kind ");
		System.out.println("GARA3001-SQL1:"+sqljob);
		return sqljob;
	}
	*/
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gara3001Form myForm = (Gara3001Form) form;
		//��J�����B���
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		//��J���_�l�~
		Integer startYear = Integer.parseInt(myForm.getAccountSyear());
		//��J�������~
		Integer endYear = Integer.parseInt(myForm.getAccountEyear());
		//���o�ϥΪ̱b��
		String usrId = this.getUserId(request);
		//���oSQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//���� delete 
		run.update(connection,delSQLJob("GARA30_RPT",usrId));
		
		//���� insert
		
		
		//���ograr30���v�l�BList����
		//List qryGara30 = (List) run.query(CommonReportSQL.Gara30SQL(myForm.getAccountEyear(),unit), new MapListHandler());
		//Gara30ReMainList gara30 = new Gara30ReMainList(qryGara30);
		Gara30ReMainList gara30 = new Gara30ReMainList(connection,myForm.getAccountEyear(),new BigDecimal(1));
		
		String[] accountKind = {"1","2","4"};
		String qryYear = "";
		Map dMap = new HashMap();
		for (int i = startYear; i <= endYear; i++){
			for (int j = 0; j < accountKind.length; j++){
				qryYear = this.getStrYear(String.valueOf(i));
				//�]�w���ogara30���@�~���
				gara30.setQryMap(qryYear,accountKind[j]);
				//�]�w���ogara34���@�~���
				gara30.setQryMap(qryYear,accountKind[j]);
				
				dMap.putAll(getCommonMap(usrId));
				//�~�קO
				dMap.put("item",gara30.getOtherKind("item"));
				/**
				 * ���� 
				 */
				//��������
				dMap.put("t1",gara30.getIssueFieldA(1));
				//�S�O�w�����
				dMap.put("t2",gara30.getIssueFieldA(2));
				//�S�O�w��A��
				dMap.put("t3",gara30.getIssueFieldA(3));
				//�S�O�w��p�p
				dMap.put("t123_total",gara30.getIssueFieldA(2).add(gara30.getIssueFieldA(3)));
				//�E�G�@.....�έx��
				dMap.put("t4",gara30.getIssueFieldA(4));
				//�ŰȰ��
				dMap.put("t5",gara30.getIssueFieldA(5));
				//�`�p
				dMap.put("t145_total",gara30.getIssueFieldA(1).add(gara30.getIssueFieldA(2)).add(gara30.getIssueFieldA(3)).add(gara30.getIssueFieldA(4)));
				
				
				/**
				 * �ɴ�
				 */
				//�`�w�����
				dMap.put("t6",gara30.getIssueFieldA(10).add(gara30.getIssueFieldA(14)));
				//�S�O�w��A���]�t�S�O�w��Ű�
				dMap.put("t7",gara30.getIssueFieldA(11));
				//�E�G�@
				dMap.put("t8",gara30.getIssueFieldA(12));
				//�ŰȰ��
				dMap.put("t9",gara30.getIssueFieldA(13));
				//�`�p
				if (Integer.parseInt(qryYear) < 91)
					dMap.put("t8910_total",((BigDecimal)dMap.get("t6")).add(((BigDecimal)dMap.get("t7"))).add(((BigDecimal)dMap.get("t8"))));
				else if (Integer.parseInt(qryYear) >= 91)
					dMap.put("t8910_total",((BigDecimal)dMap.get("t6")).add(((BigDecimal)dMap.get("t8"))));
				
				/**
				 * ��~���`�|�ɼ�
				 */
				if (Integer.parseInt(qryYear) < 91)
					dMap.put("t128_total",((BigDecimal)dMap.get("t145_total")).add(((BigDecimal)dMap.get("t8910_total"))).subtract(((BigDecimal)dMap.get("t3")).add(((BigDecimal)dMap.get("t7")))));
				else if (Integer.parseInt(qryYear) >= 91)
					dMap.put("t128_total",((BigDecimal)dMap.get("t145_total")).add(((BigDecimal)dMap.get("t8910_total"))).subtract(((BigDecimal)dMap.get("t3"))));
				dMap.put("t29_total",((BigDecimal)dMap.get("t3")).add(((BigDecimal)dMap.get("t7"))));
				dMap.put("t1314_total",((BigDecimal)dMap.get("t128_total")).add(((BigDecimal)dMap.get("t29_total"))));
//				��(��)�X 090�}�l��uamount
				if (Integer.parseInt(qryYear) < 90)
					dMap.put("budget_amount",this.getYearAmountKind(connection,qryYear,new BigDecimal(1),"1",accountKind[j]));
				else if (Integer.parseInt(qryYear) >= 90)
					dMap.put("budget_amount",this.getYearAmountKind(connection,qryYear,new BigDecimal(1),"2",accountKind[j]));
				BigDecimal t128Total = ((BigDecimal)dMap.get("t128_total"));
				BigDecimal t29Total = ((BigDecimal)dMap.get("t29_total"));
				BigDecimal budgetAmount = ((BigDecimal)dMap.get("budget_amount"));
				
//				dMap.put("Atotal_rate",this.divideCheck(((BigDecimal)dMap.get("t128_total")).divide(unit,0,BigDecimal.ROUND_HALF_UP),((BigDecimal)dMap.get("budget_amount")).divide(unit,0,BigDecimal.ROUND_HALF_UP)));
//				dMap.put("Btotal_rate",this.divideCheck(((BigDecimal)dMap.get("t29_total")).divide(unit,0,BigDecimal.ROUND_HALF_UP),((BigDecimal)dMap.get("budget_amount")).divide(unit,0,BigDecimal.ROUND_HALF_UP)));
//				dMap.put("total_rate",((BigDecimal)dMap.get("Atotal_rate")).add((BigDecimal)dMap.get("Btotal_rate")));
				BigDecimal limitAmount= this.getLimitAmount(connection,qryYear,accountKind[j],new BigDecimal(1),"'A','C'");
				dMap.put("Atotal_rate",this.divideCheck(t128Total.subtract(limitAmount),budgetAmount,8).multiply(new BigDecimal(100)));
				dMap.put("Btotal_rate",this.divideCheck(t29Total,budgetAmount,8).multiply(new BigDecimal(100)));
				dMap.put("total_rate",((BigDecimal)dMap.get("Atotal_rate")).add((BigDecimal)dMap.get("Btotal_rate")));
				String[] column = {"t1","t2","t3","t123_total","t4","t5","t145_total","t6","t7","t8","t9",
						"t8910_total","t128_total","t29_total","t1314_total","budget_amount"};
				for(int columnLength = 0 ; columnLength < column.length ; columnLength ++)
					dMap.put(column[columnLength], ((BigDecimal)dMap.get(column[columnLength])).divide(unit,0,BigDecimal.ROUND_HALF_UP));
				run.update(connection,insTemp("GARA30_RPT",dMap));
			}
		}
        SQLJob queryJob1 = selTemp1();
        List queryList1 = (List) run.query(queryJob1, new MapListHandler());
        String remark = "�E�B90�~��S�O�w��]�A�G";
        for(Iterator it1=queryList1.iterator();it1.hasNext();)
        {
        	Map mapQry1 = (Map) it1.next();
        	remark += (String)mapQry1.get("debit_name")+",";
        }
        request.setAttribute("remark",remark.substring(0,remark.length()-1));
        request.setAttribute("remarkRow",endYear-startYear);
		/*
		List queryList1 = (List) run.query(SQL1(myForm,unit), new MapListHandler());
		Map tMap = null;
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			//��(��)�X 090�}�l��uamount
			if (Integer.parseInt(((String)tMap.get("item")).substring(0,3)) < 90)
				tMap.put("budget_amount",this.getYearAmountKind(connection,((String)tMap.get("item")).substring(0,3),unit,"1",(String)tMap.get("account_kind")));
			else if (Integer.parseInt(((String)tMap.get("item")).substring(0,3)) >= 90)
				tMap.put("budget_amount",this.getYearAmountKind(connection,((String)tMap.get("item")).substring(0,3),unit,"2",(String)tMap.get("account_kind")));
			//���X
			//tMap.put("budget_amount",this.getYearAmountBKind(connection,((String)tMap.get("item")).substring(0,3),unit,(String)tMap.get("account_kind")));
			//�`�p
			tMap.put("t123_total",((BigDecimal)tMap.get("t2")).add((BigDecimal)tMap.get("t3")));
			tMap.put("t145_total",((BigDecimal)tMap.get("t1")).add((BigDecimal)tMap.get("t123_total")).add((BigDecimal)tMap.get("t4")));
			tMap.put("t8910_total",((BigDecimal)tMap.get("t6")).add((BigDecimal)tMap.get("t7")).add((BigDecimal)tMap.get("t8")));
			tMap.put("t128_total",((BigDecimal)tMap.get("t1")).add((BigDecimal)tMap.get("t2")).add((BigDecimal)tMap.get("t6")));
			tMap.put("t29_total",((BigDecimal)tMap.get("t3")).add((BigDecimal)tMap.get("t7")));
			tMap.put("t1314_total",((BigDecimal)tMap.get("t128_total")).add((BigDecimal)tMap.get("t29_total")));
			
			tMap.put("Atotal_rate",this.divideCheck((BigDecimal)tMap.get("t128_total"),(BigDecimal)tMap.get("budget_amount")));
			tMap.put("Btotal_rate",this.divideCheck((BigDecimal)tMap.get("t29_total"),(BigDecimal)tMap.get("budget_amount")));
			tMap.put("total_rate",((BigDecimal)tMap.get("Atotal_rate")).add((BigDecimal)tMap.get("Btotal_rate")));
			run.update(connection,insTemp("GARA30_RPT",tMap));
		}
		*/
	}

	protected SQLJob selTemp1(){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select debit_name from debit_ref where remark = '90�~�ץH��s�W�S�O�w��'");
		return sqljob;
	}
}
