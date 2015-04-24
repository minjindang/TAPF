/* APRA1101.java ����
 �{���ت��GAPRA11
 �{���N���GAPRA11
 �{������G0950308
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

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

import tw.gov.nta.debt.form.Apra1101Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA1101 extends ExcelReportBaseAction {

	protected SQLJob SQL1(Integer bankId,int Year,int sMonth,int eMonth)
	{
		/*
		Apra1101Form apra1101form = (Apra1101Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("   ");
		sqljob.appendSQL("INSERT INTO APRA11_RPT ( USRID, MOD_DATE, t_flag , pay_period ,debt_name , t1 , t2 ,t3 , t4 , t5 ,t6 ) ");
        //                                         1      2         3        4           5           6   7    8    9   10   11                  
		sqljob.appendSQL(" select '" + usrId + "' , CURRENT_TIMESTAMP , ");//1,2
		sqljob.appendSQL(" (case when p_flag='P' then 1 else 2 end ) t_flag, ");//3
		sqljob.appendSQL(" max(convert(varchar,p_year))+'�~'+(case when p_period='1' then '1��-6��' else '7��-12��' end) pay_period,  ");//4
		sqljob.appendSQL(" max(b.debt_name) as debt_name,  ");//5
		sqljob.appendSQL(" (case when p_flag='P'  then  p_times else 0 end) as t1,  "); //6--�����O
		sqljob.appendSQL(" (case when p_flag='I'  then  p_times else 0 end) as t2,  ");//7--�����O
		sqljob.appendSQL(" sum(i_amt) as T3,  "); //8--���J���
		sqljob.appendSQL(" sum(p_amt) as T4, "); //9--�����g�I�� 
		sqljob.appendSQL(" sum(t_amt) as T5, "); //10--�֭p�g�I�� 
		sqljob.appendSQL(" sum(bal) as T6  "); //11--����l�B 
		sqljob.appendSQL(" from issue_main b,paida c  ");
		sqljob.appendSQL(" where  '0'+substring(c.bond_id,2,2) = b.account_year  ");
		sqljob.appendSQL(" and cast(right(c.bond_id,2) as int)  = b.serial_no  ");
		sqljob.appendSQL(" and substring(c.bond_id,4,1) = b.bond_type  ");
		sqljob.appendSQL(" and debt_type = 'A'  ");
		
		if(null != apra1101form.getBankId() && !apra1101form.getBankId().equals(0))
		{
			sqljob.appendSQL("and c.bank_code = ? ");
			sqljob.addParameter(apra1101form.getBankId());
		}	
		if(null != apra1101form.getCloseSdate())
		{
			sqljob.appendSQL("and p_year >= ? ");
			sqljob.addParameter(DateUtil.date2ROCStr(apra1101form.getCloseSdate()).substring(0,3));
		}	
		if(null != apra1101form.getCloseEdate())
		{
			sqljob.appendSQL("and p_year <= ? ");
			sqljob.addParameter(DateUtil.date2ROCStr(apra1101form.getCloseEdate()).substring(0,3));
		}	
		sqljob.appendSQL(" group by c.p_flag,p_times,p_period ");
		sqljob.appendSQL(" order by 1,2,3 ");
		*/
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select distinct ");
		sqljob.appendSQL("P.BOND_ID,");
		sqljob.appendSQL("P.P_FLAG,");
		sqljob.appendSQL("P.P_TIMES,");
		sqljob.appendSQL("(case when P.P_FLAG='P' then 1 else 2 end ) t_flag,");
		sqljob.appendSQL("convert(varchar,p_year)+'�~'+(case when p_period='1' then '1��-6��' else '7��-12��' end) pay_period,");
		sqljob.appendSQL("(case when P.P_FLAG='P' then P.P_TIMES else 0 end) as t1,");
		sqljob.appendSQL("(case when P.P_FLAG='I'  then P.P_TIMES else 0 end) as t2,");
		sqljob.appendSQL("P.I_AMT as t3,"); 
		sqljob.appendSQL("P.P_AMT as t4,"); 
		sqljob.appendSQL("P.T_AMT as t5,"); 
		sqljob.appendSQL("P.BAL as t6,");
		sqljob.appendSQL("B.BANK_FNAME,");
		sqljob.appendSQL("B.BANK_CODE ");
		sqljob.appendSQL("from PAIDA P, BANKF B ");
		sqljob.appendSQL("where B.BANK_CODE=P.BANK_CODE ");
		sqljob.appendSQL("and B.BANK_CODE="+bankId+" ");
		sqljob.appendSQL("and P.P_YEAR="+Year+" ");
		//sqljob.appendSQL("and P.P_PERIOD=2 ");
		sqljob.appendSQL(getPeriod(sMonth,eMonth));
		sqljob.appendSQL("ORDER BY B.BANK_FNAME,P.BOND_ID,P.P_FLAG, P.P_TIMES ");
		System.out.println("APRA1101-SQL1:"+sqljob);
		return sqljob;
	}
	
	protected String getPeriod(int sMonth , int eMonth){
		String sql = "";
		if (sMonth < 7 && eMonth  < 7){
			sql = "and P.P_PERIOD=1 ";
		}else if (sMonth < 7 && eMonth >= 7){
			sql = "and P.P_PERIOD in (1,2) ";
		}else if (sMonth >= 7 && eMonth >= 7){
			sql = "and P.P_PERIOD=2 ";
		}
		return sql;
	}
	
	public String getPaidaName(String bondID)
	{	
		String bondName = "";
		switch (Integer.parseInt(bondID.substring(3,4))){
		case 1:
			bondName = "�����F������ " + Integer.parseInt(bondID.substring(1,3)) + " �~������ " + Integer.parseInt(bondID.substring(4,6)) + " ��";
			break;
		case 2:
			bondName = "�����F������ " + Integer.parseInt(bondID.substring(1,3)) + " �~�A���� " + Integer.parseInt(bondID.substring(4,6)) + " ��";
			break;
		case 3:
			bondName = "�����F������ " + Integer.parseInt(bondID.substring(1,3)) + " �~���j��q�س]������" + Integer.parseInt(bondID.substring(4,6)) + " ��";
			break;
		case 4:
			bondName = "�����F������ " + Integer.parseInt(bondID.substring(1,3)) + " �~���j��q�س]�A����" + Integer.parseInt(bondID.substring(4,6)) + " ��";
			break;
		}
		return bondName;
	}
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, 
			Connection connection) throws Exception 
	{
		Apra1101Form myForm = (Apra1101Form) form;
		//���o�ϥΪ̱b��
		String usrId = this.getUserId(request);
		//���oSQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//���� delete 
		run.update(connection,delSQLJob("APRA11_RPT",usrId)); 
		//���� insert
		//�w�] sYear��eYear�����~��
		int sYear = Integer.parseInt(DateUtil.date2ROCStr(new Date()).substring(0,3));
		int eYear = Integer.parseInt(DateUtil.date2ROCStr(new Date()).substring(0,3));
		//�w�]sMonth��eMonth�������
		int sMonth = Integer.parseInt(DateUtil.date2ROCStr(new Date()).substring(3,5));
		int eMonth = Integer.parseInt(DateUtil.date2ROCStr(new Date()).substring(3,5));
		//���o�}�l�~��
		if( null != myForm.getCloseSdate() && !"".equals(myForm.getCloseSdate())){
			sYear = Integer.parseInt(DateUtil.date2ROCStr(myForm.getCloseSdate()).substring(0,3));
			sMonth = Integer.parseInt(DateUtil.date2ROCStr(myForm.getCloseSdate()).substring(3,5));
		}
		//���o�����~��
		if( null != myForm.getCloseEdate() && !"".equals(myForm.getCloseEdate())){
			eYear = Integer.parseInt(DateUtil.date2ROCStr(myForm.getCloseEdate()).substring(0,3));
			eMonth = Integer.parseInt(DateUtil.date2ROCStr(myForm.getCloseEdate()).substring(3,5));
		}
		
		for (int i = sYear; i <= eYear; i++){
			int selectSMonth = 1;
			int selectEMonth = 12;
			if (i == sYear ){
				selectSMonth = sMonth;
			}
			if ( i == eYear ){
				selectEMonth = eMonth;
			}
			List queryList1 = (List) run.query(SQL1(myForm.getBankId(),i,selectSMonth,selectEMonth), new MapListHandler());
			Map tMap = null;
			Map dMap = new HashMap();
			for (Iterator it1 = queryList1.iterator(); it1.hasNext();){
				tMap = (Map) it1.next();
				dMap.putAll(getCommonMap(usrId));
				dMap.put("t_flag",String.valueOf(tMap.get("t_flag")));
				dMap.put("pay_period",(String)tMap.get("pay_period"));//--�g�I����
				dMap.put("debt_name",getPaidaName((String)tMap.get("BOND_ID")));//--���ŦW��
				dMap.put("t1",String.valueOf(tMap.get("t1")));//--�����O
				dMap.put("t2",String.valueOf(tMap.get("t2")));//--�����O
				dMap.put("t3",new BigDecimal((Double)tMap.get("t3")));//--���J���
				dMap.put("t4",new BigDecimal((Double)tMap.get("t4")));//--�����g�I��
				dMap.put("t5",new BigDecimal((Double)tMap.get("t5")));//--�֭p�g�I��
				dMap.put("t6",new BigDecimal((Double)tMap.get("t6")));//--����l�B
				run.update(connection,insTemp("APRA11_RPT",dMap));
			}
		}
	}


}
