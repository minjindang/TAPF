/*
 * �b 2007/8/27 �إ�
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ��ɮת��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
package tw.gov.nta.account.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.account.form.AccountQueryForm;
import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

/**
 * @author Mulder
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class EARE1002 extends ExcelReportBaseAction {
	
	private final static String TEMP_TABLE_NAME = "EARE10_RPT";
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EARE10_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
 	
	protected SQLJob SQL(AccountQueryForm form){
		
		AccountQueryForm myForm = (AccountQueryForm) form;
		SQLJob sqljob = new SQLJob();
		//�d�����
		sqljob.appendSQL("select right(i.account_year,2) +'�~��'+ b.code_name + '����' + ");
		sqljob.appendSQL("c.debit_name + f.budget_name  as GROUP_YEAR,");
		sqljob.appendSQL("(Select t.debt_id From issue_exchange_ticket_det t ");
		sqljob.appendSQL("where t.debt_id = d.id group by t.debt_id ) as ISSUE_EXCHAGE, ");
		sqljob.appendSQL("i.debt_name as GROUP_DEBT_NAME, ");
		sqljob.appendSQL("i.issue_kind as ISSUE_KIND ");
		//�d�߸�ƪ�
		sqljob.appendSQL("from issue_main i, debt_main d, debit_ref c, code_det b, budget_ref f");
		//�d�߱���
		sqljob.appendSQL("where i.debt_type = 'A' ");
		sqljob.appendSQL("and i.id = d.issue_id  ");		
		if (!"".equals(myForm.getAccountYear()))	{
			sqljob.appendSQL("and i.account_year < ?");
			sqljob.addParameter(myForm.getAccountYear());
		}		
		sqljob.appendSQL("and i.cash_due_date > '"+new Timestamp(new Date().getTime())+"'");
		sqljob.appendSQL("and c.id = i.debt_code and i.bond_kind = b.id and i.budget_code = f.id");
		sqljob.appendSQL("order by i.ISSUE_DATE");
		System.out.println(sqljob.toString());
		System.out.println(myForm.getAccountYear());
		return sqljob;
	}	

	protected static String sort(int num){

	    int cont1 = Integer.parseInt(String.valueOf(num).substring(0,1));
	    int cont2 = 0;
	    String i = "";
	    String j = "";
	    if (num > 10){
	    	cont2 = Integer.parseInt(String.valueOf(num).substring(1,2));
	    	
			switch(cont2) {
	        case 0: 
	            j = "�Q"; 
	            break; 
	        case 1: 
	            j = "�@"; 
	            break; 
	        case 2: 
	            j = "�G"; 
	            break;
	        case 3: 
	            j = "�T"; 
	            break;
	        case 4: 
	            j = "�|"; 
	            break;
	        case 5: 
	            j = "��"; 
	            break;
	        case 6: 
	            j = "��"; 
	            break;
	        case 7: 
	            j = "�C"; 
	            break;
	        case 8: 
	            j = "�K"; 
	            break;
	        case 9: 
	            j = "�E"; 
	            break;
	        case 10: 
	            j = "�Q"; 
	            break;
	        default: 
	            System.out.println(j); 
			}
	    }	    	

		switch(cont1) { 
        case 0: 
            i = ""; 
            break; 
        case 1: 
            i = "�@"; 
            break; 
        case 2: 
            i = "�G"; 
            break;
        case 3: 
            i = "�T"; 
            break;
        case 4: 
            i = "�|"; 
            break;
        case 5: 
            i = "��"; 
            break;
        case 6: 
            i = "��"; 
            break;
        case 7: 
            i = "�C"; 
            break;
        case 8: 
            i = "�K"; 
            break;
        case 9: 
            i = "�E"; 
            break;
        case 10: 
            i = "�Q"; 
            break;
        default: 
            System.out.println(i); 
		}
				
		return i+j;
	
	}
	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		
		//���o�ϥΪ̱b��
		String usrId = this.getUserId(request);
		//���oSQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//���� delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );		
		
		SQLJob sqljob = SQL((AccountQueryForm)form);		
		List tList = (List) run.query(sqljob, new MapListHandler());		
		Map tMap = null;
		
		int i = 0;
		int j = 0;
		String test = "";
		
		for(Iterator tIterator = tList.iterator(); tIterator.hasNext(); ){		
			
			tMap = (Map) tIterator.next();
			Map dMap = new HashMap();
			Map cMap = new HashMap();
			
			if (tMap.get("GROUP_YEAR").equals(request.getAttribute("check"))){
				j = j + 1;
				dMap.put("GROUP_YEAR","         ("+sort(j)+")"  +(String)tMap.get("GROUP_DEBT_NAME"));
			}
			else{
				i = i +1;
				j = 1;
				cMap.put("GROUP_YEAR",sort(i) + "�B" + (String)tMap.get("GROUP_YEAR"));
				run.update(connection,insTemp(TEMP_TABLE_NAME,cMap));
				dMap.put("GROUP_YEAR","         (�@)" +(String)tMap.get("GROUP_DEBT_NAME"));
			}
			run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
			
			if (!(boolean)test.equals(tMap.get("ISSUE_EXCHAGE")) && (boolean)(tMap.get("ISSUE_KIND").equals("1"))) {
				dMap.put("GROUP_YEAR","                  (1)���Ū� - �g�I��(�Ų��Φ�)");
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));			
				dMap.put("GROUP_YEAR","                  (2)�v�I�����Q�����Ӥ����(�Ų��Φ�)");
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));			
				dMap.put("GROUP_YEAR","                  (3)���Ū� - �g�I��(�n���Φ�)");
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));			
				dMap.put("GROUP_YEAR","                  (4)�v�I�����Q�����Ӥ����(�n���Φ�)");
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
			}
			
			if ((boolean)test.equals(tMap.get("ISSUE_EXCHAGE")) && (boolean)tMap.get("ISSUE_KIND").equals("1")) {
				dMap.put("GROUP_YEAR","                  (1)���Ū� - �g�I��(�Ų��Φ�)");
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));			
				dMap.put("GROUP_YEAR","                  (2)�v�I�����Q�����Ӥ����(�Ų��Φ�)");
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
			}
			
			if ((boolean)tMap.get("ISSUE_KIND").equals("0") && !(boolean)test.equals(tMap.get("ISSUE_EXCHAGE"))) {
				dMap.put("GROUP_YEAR","                  (1)���Ū� - �g�I��(�n���Φ�)");
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));			
				dMap.put("GROUP_YEAR","                  (2)�v�I�����Q�����Ӥ����(�n���Φ�)");
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
			}
			
			request.setAttribute("check", tMap.get("GROUP_YEAR"));
		}	
	}
}

