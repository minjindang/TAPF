/**
 * @author AndrewSung
 * @date 2006/3/10
 */

package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import tw.gov.nta.debt.form.Apra1801Form;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA1801 extends DefaultAction
{

	protected SQLJob delTemp(ActionForm form,String usrId)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM APRA18_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	protected SQLJob insTemp(ActionForm form,String usrId)
	{
		Apra1801Form myform = (Apra1801Form)form;
		SQLJob sqljob = new SQLJob();		
		sqljob.appendSQL("INSERT INTO APRA18_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, TICKET_COUNT, TOTAL_AMOUNT ");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL("select '" + usrId + "' , sum(total_pcs) , sum(total_amt)");
		sqljob.appendSQL("from debt_main a, paidc b");
		sqljob.appendSQL("where a.issue_id = ? ");
		sqljob.appendSQL("and b.new_update <= ? ");
		sqljob.appendSQL("and a.remark = convert(varchar,b.bond_code) + ");
		sqljob.appendSQL("(case when len(convert(varchar,b.bond_period))=1 then '0'+convert(varchar,b.bond_period) else convert(varchar,b.bond_period) end) + ");
		sqljob.appendSQL("(case when convert(varchar,b.bond_mark)='甲' then '01' else '02' end)");
		sqljob.addParameter(myform.getIssueId());
		sqljob.addParameter(myform.getCloseDate());
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//取得使用者帳號
		String usrId = request.getSession().getAttribute("ACCOUNT").toString();
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		run.update(connection,insTemp(form,usrId));
	}

}



/** 舊程式
	
//取得ISSUE_TICKET_DET.TICKET_COUNT的加總AA
//取得ISSUE_TICKET_DET.TICKET_AMOUNT的加總CC
protected SQLJob selTemp1(Integer issuId){
	SQLJob sqljob = new SQLJob();

	sqljob.appendSQL("SELECT SUM(B.TICKET_COUNT) AS AA,");
	sqljob.appendSQL("SUM(B.TICKET_AMOUNT) AS CC");
	sqljob.appendSQL("FROM ISSUE_MAIN A,ISSUE_TICKET_DET B");
	sqljob.appendSQL("WHERE A.ID=B.ISSUE_ID");
	sqljob.appendSQL("AND A.ISSUE_KIND='1'");
	sqljob.appendSQL("AND A.DEBT_TYPE='A'");
	sqljob.appendSQL("AND A.ID="+issuId);
	sqljob.appendSQL("GROUP BY B.TICKET_COUNT,B.TICKET_AMOUNT");
	System.out.println(sqljob.toString());
	return sqljob;
}
	
	//取得CENTRAL_TRANS_DET.TICKET_COUNT的加總BB
	//取得CENTRAL_TRANS_DET.TICKET_AMOUNT的加總DD
protected SQLJob selTemp2(Integer issuId){
	SQLJob sqljob = new SQLJob();
	
	sqljob.appendSQL("SELECT SUM(B.TICKET_COUNT) AS BB,");
	sqljob.appendSQL("SUM(B.TICKET_AMOUNT) AS DD");
	sqljob.appendSQL("FROM ISSUE_MAIN A,CENTRAL_TRANS_DET B,");
	sqljob.appendSQL(" CENTRAL_TRANS_PAY P");
	sqljob.appendSQL("WHERE A.ID=B.ISSUE_ID");
	sqljob.appendSQL("AND A.ISSUE_KIND='1'");
	sqljob.appendSQL("AND A.DEBT_TYPE='A'");
	sqljob.appendSQL("AND A.ID=P.ISSUE_ID");
	sqljob.appendSQL("AND P.ID=B.ISSUE_ID");
	sqljob.appendSQL("AND B.ISSUE_ID="+issuId);
	sqljob.appendSQL("GROUP BY B.TICKET_COUNT");
	System.out.println(sqljob.toString());
	return sqljob;
}

protected SQLJob insertJob(String usrId,Integer subtractAB,BigDecimal subtractCD){
	SQLJob sqljob = new SQLJob();
	sqljob.appendSQL("INSERT INTO APRA18_RPT ");
	sqljob.appendSQL(" ( ");
	sqljob.appendSQL(" USRID, TICKET_COUNT, TOTAL_AMOUNT ");
	sqljob.appendSQL(" ) ");
	sqljob.appendSQL(" values (?, ? ,?) ");
	sqljob.addParameter(usrId);
	sqljob.addParameter(subtractAB);
	sqljob.addParameter(subtractCD);
	System.out.println(sqljob.toString());
	return sqljob;
}

public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
	Apra1801Form myForm = (Apra1801Form)form;
	//取得SQLRunner
	SQLRunner run = new ConnectionSQLRunner(connection);

    //取得使用者帳號
	String usrId = this.getUserId(request);
	//執行 delete 
	run.update(connection,delTemp(form,usrId));
	
	MapHandler mh = new MapHandler();
    SQLJob queryJob1 = selTemp1(myForm.getIssueId());
    SQLJob queryJob2 = selTemp2(myForm.getIssueId());
    Map map1 = (Map) run.query(queryJob1,mh);
    Map map2 = (Map) run.query(queryJob2,mh);
    //取得查詢結果AA
    Long AA = null;
    BigDecimal CC = null ;
    Integer BB = null ;
    BigDecimal DD = null ;
    if ((map1 != null) && (map2 != null))
    {
    	//取得查詢結果AA
    	AA = (Long) map1.get("AA");
    	//取得查詢結果CC
    	CC = (BigDecimal) map1.get("CC");
    	//取得查詢結果BB
    	BB = (Integer) map2.get("BB");
    	//取得查詢結果DD
    	DD = (BigDecimal) map2.get("DD");
    	
    	//將AA與CC相乘,取得TOTAL_AMOUNT AC
	    BigDecimal AC = CC.multiply(BigDecimal.valueOf(AA.longValue()));
	    //將AA與CC相乘,取得TOTAL_AMOUNT AC
        BigDecimal BD = DD.multiply(BigDecimal.valueOf(BB.longValue()));
        //將取得之查詢結果AA BB相減取得 subtractAB
        Integer subtractAB =  AA.intValue()-BB.intValue();
        //將取得之TOTAL_AMOUNT AC BD 相減取得 subtractCD
        BigDecimal subtractCD = AC.subtract(BD);
        //執行 insert
        run.update(connection,insertJob(usrId,subtractAB , subtractCD));
    }
    else
    {
    	 run.update(connection,insertJob(usrId,0,BigDecimal.valueOf(((Integer)0).longValue())));
    }
}

*/