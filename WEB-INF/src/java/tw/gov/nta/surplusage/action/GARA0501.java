/**
 * @author Avery
 * @create 2006/06/01
 */

package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportRemainAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.NationDebitMain;
import tw.gov.nta.sql.debt.GaraNote;
import tw.gov.nta.surplusage.common.Gara33ReMainList;
import tw.gov.nta.surplusage.common.Gara34ReMainList;
import tw.gov.nta.surplusage.common.GaraNoteManager;
import tw.gov.nta.surplusage.form.Gara0401Form;
import tw.gov.nta.system.common.NationCodeManager;
import tw.gov.nta.system.common.NationDebitManager;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA0501 extends ExcelReportRemainAction
{

	protected SQLJob SQL1(Gara0401Form myForm,BigDecimal unit){
		SQLJob sqljob = new SQLJob();

		sqljob.appendSQL("select  account_year,");
		//��~���|�ɤ��ŵo��� -91�~�װ_�ư��A��
		sqljob.appendSQL("sum(case when ( account_year < 091 and debt_type = 'A' and bound_code in ('1','2') and budget_code in ('1','2') and account_type='Y' )  then  isnull(issue_amount,0) ");
		sqljob.appendSQL("when ( account_year>=091 and debt_type = 'A' and bound_code = '1' and budget_code in ('1','2')  and account_type='Y' )  then  isnull(issue_amount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as AA1 ,");
		//��~���|�ɭɴڵo���(�`�w��ίS�O�w��)-91�~�װ_�ư��A��
		//sqljob.appendSQL("sum(case when ( debt_type IN ('C','E') and budget_code in ('1','2') and account_type='Y' )  then  isnull(issue_amount,0) else 0 end)/"+unit+"  as AA3 ,");
		sqljob.appendSQL("sum(case when ( account_year<091 and debt_type IN ('C','E') and bound_code  in ('1','2')  and budget_code in ('1','2') and account_type='Y' )  then  isnull(issue_amount,0) ");
		sqljob.appendSQL("when ( account_year>=091 and debt_type IN ('C','E') and bound_code  in ('1')  and budget_code in ('1','2') and account_type='Y' )  then  isnull(issue_amount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+"  as AA2 ,");
		//��~���|�ɦC�J�ŭ�
		//sqljob.appendSQL("sum(case when ( is_debt='Y' and account_type='Y' )  then isnull(issue_amount,0)  else 0 end )/"+unit+"  as AA5 ,");
		sqljob.appendSQL("sum(case when ( account_year<091 and is_debt='Y' and bound_code in ('1','2')  and budget_code in ('1','2') and account_type='Y' )  then  isnull(issue_amount,0) ");
		sqljob.appendSQL("when ( account_year>=091 and is_debt='Y' and bound_code = '1'  and budget_code in ('1','2') and account_type='Y' )  then  isnull(issue_amount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+"  as AA3 ,");
		//��~���|�ɤ��C�J�ŭ�	
		//sqljob.appendSQL("sum(case when ( is_debt='N' and account_type='Y' )  then isnull(issue_amount,0)  else 0 end )/"+unit+"  as AA6 ,");
		sqljob.appendSQL("sum(case when ( account_year<091 and is_debt='N' and bound_code in ('1','2')  and budget_code in ('1','2') and account_type='Y' )  then  isnull(issue_amount,0) ");
		sqljob.appendSQL("when ( account_year>=091 and is_debt='N' and bound_code = '1'  and budget_code in ('1','2') and account_type='Y' )  then  isnull(issue_amount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+"  as AA4 ");
		
		sqljob.appendSQL("from central_statistics_main ");
		if (!"".equals(myForm.getEndYear())){
			sqljob.appendSQL("where account_year between 0 and ? +0 ");
			sqljob.addParameter(myForm.getEndYear());
		}
		sqljob.appendSQL(" group by account_year");
		sqljob.appendSQL(" order by account_year ");
        System.out.println("GARA0501-SQL:"+sqljob);
 		return sqljob;
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception{	
		/*
		 *t1��~�פ��ŵo����B 
		 *t2��~�׭ɴڼ��B
		 *t3��~���|�ɦX�p//�C�J���v����
		 *t4��~���|�ɦX�p//���C�J���v����
		 *t5��~�׶Űȥ��v�l�B--����
		 *t6��~�׶Űȥ��v�l�B//�ɴڡB�`�w��ίS�O�w��
		 *t7��~�׶Űȥ��v�l�B//�ɴڡB�D��~���(�D���v��)
		 */
		Gara0401Form myForm = (Gara0401Form) form;
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		//���o�ϥΪ̱b��
		String usrId = this.getUserId(request);
		//���oSQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//���� delete 
		run.update(connection,delSQLJob("GARA05_RPT",usrId));
		//���� insert
		List queryList1 = (List) run.query(SQL1(myForm,unit), new MapListHandler());
		
		
		//���ograr33���v�l�BList����
		//List qryGara33 = (List) run.query(CommonReportSQL.Gara33SQL(myForm.getEndYear(),unit), new MapListHandler());
		//Gara33ReMainList gara33 = new Gara33ReMainList(qryGara33);
		Gara33ReMainList gara33 = new Gara33ReMainList(connection,myForm.getEndYear(),unit);
		//���ograr34���v�l�BList����
		//List qryGara34 = (List) run.query(CommonReportSQL.Gara34SQL(myForm.getEndYear(),unit), new MapListHandler());
		//Gara34ReMainList gara34 = new Gara34ReMainList(qryGara34);
		Gara34ReMainList gara34 = new Gara34ReMainList(connection,myForm.getEndYear(),unit);
		
		Map tMap = null;
		Map dMap = new HashMap();
		String accountYear="";
		String accountKind="";
		BigDecimal perGNP = new BigDecimal(0);
		//��(��)�X�`�B-�t�ư��ŭ�
		BigDecimal yearAmountKind1 = new BigDecimal(0);
		//��(��)�X�`�B-���t�ư��ŭ�(�w)
		BigDecimal yearAmountKind2AK1 = new BigDecimal(0);
		//��(��)�X�`�B-���t�ư��ŭ�(�M)
		BigDecimal yearAmountKind2AK2 = new BigDecimal(0);
//		��(��)�X�`�B-�t�ư��ŭ�(�w)
		BigDecimal yearAmountKind1AK1 = new BigDecimal(0);
		//��(��)�X�`�B-�t�ư��ŭ�(�M)
		BigDecimal yearAmountKind1AK2 = new BigDecimal(0);
		
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			dMap.putAll(getCommonMap(usrId));
			accountYear = (String)tMap.get("account_year");
			//�]�w���ogara33���@�~���
			accountKind = getAccountKind(connection,accountYear,"'A'");
			if(Integer.parseInt(accountYear) >= new Date().getYear()-11)
				gara33.setQryMap(accountYear,"1");
			else
				gara33.setQryMap(accountYear,accountKind);
			//�]�w���ogara34���@�~���
			accountKind = getAccountKind(connection,accountYear,"'C','E'");
			if(Integer.parseInt(accountYear) >= new Date().getYear()-11)
				gara34.setQryMap(accountYear,"1");
			else
				gara34.setQryMap(accountYear,accountKind);
			
			
			//�~��
			dMap.put("account_year",(String)tMap.get("account_year"));
			//t1��~�פ��ŵo����B
			dMap.put("t1",(BigDecimal)tMap.get("AA1"));
			//t2��~�׭ɴڼ��B
			dMap.put("t2",(BigDecimal)tMap.get("AA2"));
			//t3��~���|�ɦX�p--�C�J���v����
			dMap.put("t3",(BigDecimal)tMap.get("AA3"));
			//t4��~���|�ɦX�p--���C�J���v����
			dMap.put("t4",(BigDecimal)tMap.get("AA4"));
			//t5��~�׶Űȥ��v�l�B--����
			dMap.put("t5",gara33.getReMainTotal());
			//t6��~�׶Űȥ��v�l�B//�ɴڡB�`�w��ίS�O�w��
			if(Integer.parseInt(accountYear)==73)
				dMap.put("t6",new BigDecimal("2433000000").divide(unit));
			else if(Integer.parseInt(accountYear)==74)
				dMap.put("t6",new BigDecimal("2008000000").divide(unit));
			else
				dMap.put("t6",gara34.getReMainTotal());
			//t7��~�׶Űȥ��v�l�B//�ɴڡB�D��~���(�D���v��)
			dMap.put("t7",new BigDecimal(0));
			//s1�ɴڦX�p
			dMap.put("s1",((BigDecimal)dMap.get("t6")).add((BigDecimal)dMap.get("t7")));
			//s2�X�p
			dMap.put("s2",((BigDecimal)dMap.get("s1")).add((BigDecimal)dMap.get("t5")));
			
			/*��(��)�X�`�B-���t�ư��ŭ�
			 *user�n�D93�~����,�Ф��X�@�w,�M�@����(��)�X�`�B-���t�ư��ŭ�
			 *93�~�e�����@�w,�M�@����(��)�X�`�B-���t�ư��ŭ�
			 */
			dMap.put("budget_amount",this.getYearAmount(connection,(String)dMap.get("account_year"),unit,"2"));
			//��(��)�X�`�B-���t�ư��ŭ�(�w)
			yearAmountKind2AK1 = this.getYearAmountKind(connection,(String)dMap.get("account_year"),unit,"2","1");
			//��(��)�X�`�B-���t�ư��ŭ�(�M)
			yearAmountKind2AK2 = this.getYearAmountKind(connection,(String)dMap.get("account_year"),unit,"2","2");
			yearAmountKind1AK1 = this.getYearAmountKind(connection,(String)dMap.get("account_year"),unit,"1","1");
			yearAmountKind1AK2 = this.getYearAmountKind(connection,(String)dMap.get("account_year"),unit,"1","2");
			//��~���|�ɼ�/��(��)�X�`�B-���t�ư��ŭ�
			dMap.put("p1",this.divideCheck((BigDecimal)dMap.get("t3"),(BigDecimal)dMap.get("budget_amount")).multiply(new BigDecimal(100)));
			//��(��)�X�`�B-�t�ư��ŭ�
			yearAmountKind1 = this.getYearAmount(connection,(String)dMap.get("account_year"),unit,"1");
			//���v�l�B/��(��)�X-�t�ư��ŭ�
			if(Integer.parseInt(accountYear)==89)
				dMap.put("p2",this.divideCheck((BigDecimal)dMap.get("s2"),yearAmountKind1).multiply(new BigDecimal(1.5)).multiply(new BigDecimal(100)));
			else
				dMap.put("p2",this.divideCheck((BigDecimal)dMap.get("s2"),yearAmountKind1).multiply(new BigDecimal(100)));
			//���v�l�B/�e�T�~��GNP
			perGNP = this.getPerGNP(connection,(String)dMap.get("account_year"),unit);
			dMap.put("perGNP_amount",this.divideCheck((BigDecimal)dMap.get("s2"),perGNP).multiply(new BigDecimal(100)));
			if (!"".equals(myForm.getStartYear())) {
				if (Integer.parseInt((String) dMap.get("account_year")) >= Integer.parseInt(myForm.getStartYear())){
					if(Integer.parseInt((String) dMap.get("account_year")) >= 93){
						dMap.put("budget_amount",yearAmountKind2AK1);
						dMap.put("p1",this.divideCheck((BigDecimal)dMap.get("t3"),(BigDecimal)dMap.get("budget_amount")).multiply(new BigDecimal(100)));
						dMap.put("p2",this.divideCheck((BigDecimal)dMap.get("s2"),yearAmountKind1AK1).multiply(new BigDecimal(100)));
						dMap.put("yearAmount_Kind","(�w)");
						upNationDebitMain(accountYear , (BigDecimal)dMap.get("p1"),(BigDecimal)dMap.get("p2"));
						run.update(connection,insTemp("GARA05_RPT",dMap));
						dMap.put("budget_amount",yearAmountKind2AK2);
						dMap.put("p1",this.divideCheck((BigDecimal)dMap.get("t3"),(BigDecimal)dMap.get("budget_amount")).multiply(new BigDecimal(100)));
						dMap.put("p2",this.divideCheck((BigDecimal)dMap.get("s2"),yearAmountKind1AK2).multiply(new BigDecimal(100)));
						dMap.put("yearAmount_Kind","(�M)");
						run.update(connection,insTemp("GARA05_RPT",dMap));
						
					}else{
						run.update(connection,insTemp("GARA05_RPT",dMap));
						upNationDebitMain(accountYear , (BigDecimal)dMap.get("p1"),(BigDecimal)dMap.get("p2"));
					}
				}
			}
			else{
				if(Integer.parseInt((String) dMap.get("account_year")) >= 93){
					dMap.put("budget_amount",yearAmountKind2AK1);
					dMap.put("p1",this.divideCheck((BigDecimal)dMap.get("t3"),(BigDecimal)dMap.get("budget_amount")).multiply(new BigDecimal(100)));
					dMap.put("p2",this.divideCheck((BigDecimal)dMap.get("s2"),yearAmountKind1AK1).multiply(new BigDecimal(100)));
					run.update(connection,insTemp("GARA05_RPT",dMap));
					upNationDebitMain(accountYear , (BigDecimal)dMap.get("p1"),(BigDecimal)dMap.get("p2"));
					dMap.put("budget_amount",yearAmountKind2AK2);
					dMap.put("p1",this.divideCheck((BigDecimal)dMap.get("t3"),(BigDecimal)dMap.get("budget_amount")).multiply(new BigDecimal(100)));
					dMap.put("p2",this.divideCheck((BigDecimal)dMap.get("s2"),yearAmountKind1AK2).multiply(new BigDecimal(100)));
					run.update(connection,insTemp("GARA05_RPT",dMap));
				}else{
					run.update(connection,insTemp("GARA05_RPT",dMap));
					upNationDebitMain(accountYear , (BigDecimal)dMap.get("p1"),(BigDecimal)dMap.get("p2"));
				}
			}
		}

		GaraNote garaNote = new GaraNoteManager().getGaraNote(myForm.getPath());
		garaNote.setMemo(myForm.getMemo());
		garaNote.setPath(myForm.getPath());
		new GaraNoteManager().confirm(garaNote);
		request.setAttribute("memo",garaNote.getMemo());
	}
	private void upNationDebitMain(String accountYear , BigDecimal caseRate , BigDecimal remainPayRate){
		NationDebitMain nationDebitMain = new NationDebitMain();
		nationDebitMain.setAccountYear(accountYear);
		nationDebitMain.setNationCode(NationCodeManager.get(24));
		List list = new NationDebitManager().query(nationDebitMain);
		for(Iterator it = list.iterator() ; it.hasNext() ;){
			nationDebitMain = (NationDebitMain)it.next();
			nationDebitMain.setCaseRate(caseRate);
			nationDebitMain.setRemainPayRate(remainPayRate);
			new NationDebitManager().update(nationDebitMain.getId(), nationDebitMain);
		}
	}
}