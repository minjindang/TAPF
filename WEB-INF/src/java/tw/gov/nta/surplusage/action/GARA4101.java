/* DIRA0401.java ����
 �{���ت��GDIRA0401
 �{���N���GDIRA0401
 �{������G0950308
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 --------------------------------------------------------
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

import tw.gov.nta.surplusage.common.Gara33ReMainList;
import tw.gov.nta.surplusage.common.Gara34ReMainList;
import tw.gov.nta.surplusage.form.Gara4101Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA4101 extends ExcelReportRemainAction 
{
	/*
	protected SQLJob insTemp(ActionForm form,String usrId)
	{
		Gara4101Form myForm = (Gara4101Form) form;
		SQLJob  sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO GARA41_RPT (usrid,mod_date,remark,accountYear,remain_amount,GDP_amount,debt_GDP) ");
		sqljob.appendSQL("select ?,?,null,a.account_year,");
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Timestamp(new Date().getTime()));
		sqljob.appendSQL("sum(a.remain_amount) as remain_amount,");
		sqljob.appendSQL("sum(b.GDP_amount) as GDP_amiunt,");
		sqljob.appendSQL("(case when sum(b.GDP_amount) <> 0 then sum(a.remain_amount) / sum(b.GDP_amount) else 0 end) as debt_GDP ");
		sqljob.appendSQL("from central_statistics_main a,nation_debit_main b ");
		sqljob.appendSQL("where a.account_year = b.account_year ");
		if (!"".equals(myForm.getAccountSYear()) && !"".equals(myForm.getAccountEYear())){
			sqljob.appendSQL("and a.account_year between ? and ? ");
			sqljob.addParameter(myForm.getAccountSYear());
			sqljob.addParameter(myForm.getAccountEYear());
		}
		sqljob.appendSQL("and b.nation_code= 24 ");
		sqljob.appendSQL("group by a.account_year ");
		return sqljob;
	}
	*/
//	protected SQLJob SQL1(Gara4101Form myForm,BigDecimal unit)
//	{
//		SQLJob sqljob = new SQLJob();
//		sqljob.appendSQL("select account_year as accountYear,");
//		sqljob.appendSQL("sum(remain_amount)/"+unit+" as remain_amount ");
//		sqljob.appendSQL("from central_statistics_main ");
//		sqljob.appendSQL("where 1=1 and inout_type='0' ");
//		if (!"".equals(myForm.getAccountSYear()) && !"".equals(myForm.getAccountEYear())){
//			sqljob.appendSQL("and account_year between ? and ? ");
//			sqljob.addParameter(myForm.getAccountSYear());
//			sqljob.addParameter(myForm.getAccountEYear());
//		}
//		sqljob.appendSQL("group by account_year ");
//		sqljob.appendSQL("order by account_year ");
//		System.out.println("GARA41-SQL1:"+sqljob.toString());
//		return sqljob;
//	}

	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, 
			Connection connection) throws Exception 
	{
		Gara4101Form myForm = (Gara4101Form) form;
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
//		��J���_�l�~
		Integer startYear = Integer.parseInt(myForm.getAccountSYear());
		//��J�������~
		Integer endYear = Integer.parseInt(myForm.getAccountEYear());
		//���o�ϥΪ̱b��
		String usrId = this.getUserId(request);
		//���oSQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//���� delete 
		run.update(connection,delSQLJob("GARA41_RPT",usrId));
		//���� insert
		//���ograr33���v�l�BList����
		Gara33ReMainList gara33 = new Gara33ReMainList(connection,myForm.getAccountEYear(),unit);
		//���ograr34���v�l�BList����
		Gara34ReMainList gara34 = new Gara34ReMainList(connection,myForm.getAccountEYear(),unit);
		Map tMap = new HashMap();
//		List queryList1 = (List) run.query(SQL1(myForm,unit), new MapListHandler());
//		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
		for(int i=startYear;i<=endYear;i++){
			//tMap = (Map) tIterator.next();
			String accountYear = this.getStrYear(String.valueOf(i));
			String accountKind = getAccountKind(connection,accountYear,"'A'");
			accountKind = getAccountKind(connection,accountYear,"'A'");
			if(Integer.parseInt(accountYear) >= new Date().getYear()-11)
				gara33.setQryMap(accountYear,"1");
			else
				gara33.setQryMap(accountYear,accountKind);
			accountKind = getAccountKind(connection,accountYear,"'C','E'");
			if(Integer.parseInt(accountYear) >= new Date().getYear()-11)
				gara34.setQryMap(accountYear,"1");
			else
				gara34.setQryMap(accountYear,accountKind);
			tMap.putAll(getCommonMap(usrId));
			tMap.put("accountYear",accountYear);
			tMap.put("remain_amount",gara33.getReMainTotal().add(gara34.getReMainTotal()));
			tMap.put("GDP_amount",this.getGDP(connection,accountYear,unit));
			tMap.put("debt_GDP",this.divideCheck((BigDecimal)tMap.get("remain_amount"),(BigDecimal)tMap.get("GDP_amount")));
			run.update(connection,insTemp("GARA41_RPT",tMap));
		}
	}
	
}
