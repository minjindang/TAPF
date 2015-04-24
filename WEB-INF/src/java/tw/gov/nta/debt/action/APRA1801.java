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
		sqljob.appendSQL("(case when convert(varchar,b.bond_mark)='��' then '01' else '02' end)");
		sqljob.addParameter(myform.getIssueId());
		sqljob.addParameter(myform.getCloseDate());
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//���o�ϥΪ̱b��
		String usrId = request.getSession().getAttribute("ACCOUNT").toString();
		//���oSQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//���� delete 
		run.update(connection,delTemp(form,usrId));
		//���� insert
		run.update(connection,insTemp(form,usrId));
	}

}



/** �µ{��
	
//���oISSUE_TICKET_DET.TICKET_COUNT���[�`AA
//���oISSUE_TICKET_DET.TICKET_AMOUNT���[�`CC
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
	
	//���oCENTRAL_TRANS_DET.TICKET_COUNT���[�`BB
	//���oCENTRAL_TRANS_DET.TICKET_AMOUNT���[�`DD
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
	//���oSQLRunner
	SQLRunner run = new ConnectionSQLRunner(connection);

    //���o�ϥΪ̱b��
	String usrId = this.getUserId(request);
	//���� delete 
	run.update(connection,delTemp(form,usrId));
	
	MapHandler mh = new MapHandler();
    SQLJob queryJob1 = selTemp1(myForm.getIssueId());
    SQLJob queryJob2 = selTemp2(myForm.getIssueId());
    Map map1 = (Map) run.query(queryJob1,mh);
    Map map2 = (Map) run.query(queryJob2,mh);
    //���o�d�ߵ��GAA
    Long AA = null;
    BigDecimal CC = null ;
    Integer BB = null ;
    BigDecimal DD = null ;
    if ((map1 != null) && (map2 != null))
    {
    	//���o�d�ߵ��GAA
    	AA = (Long) map1.get("AA");
    	//���o�d�ߵ��GCC
    	CC = (BigDecimal) map1.get("CC");
    	//���o�d�ߵ��GBB
    	BB = (Integer) map2.get("BB");
    	//���o�d�ߵ��GDD
    	DD = (BigDecimal) map2.get("DD");
    	
    	//�NAA�PCC�ۭ�,���oTOTAL_AMOUNT AC
	    BigDecimal AC = CC.multiply(BigDecimal.valueOf(AA.longValue()));
	    //�NAA�PCC�ۭ�,���oTOTAL_AMOUNT AC
        BigDecimal BD = DD.multiply(BigDecimal.valueOf(BB.longValue()));
        //�N���o���d�ߵ��GAA BB�۴���o subtractAB
        Integer subtractAB =  AA.intValue()-BB.intValue();
        //�N���o��TOTAL_AMOUNT AC BD �۴���o subtractCD
        BigDecimal subtractCD = AC.subtract(BD);
        //���� insert
        run.update(connection,insertJob(usrId,subtractAB , subtractCD));
    }
    else
    {
    	 run.update(connection,insertJob(usrId,0,BigDecimal.valueOf(((Integer)0).longValue())));
    }
}

*/