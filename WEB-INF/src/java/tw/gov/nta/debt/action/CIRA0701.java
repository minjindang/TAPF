/* CIRA0701.java ����
 �{���ت��GCIRA07
 �{���N���GCIRA07
 �{������G0950308
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Cira0701Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class CIRA0701 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM CIRA07_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Cira0701Form cira0701Form = (Cira0701Form) form;
		SQLJob sqljob = new SQLJob();
		
		Integer startYear = Integer.parseInt(cira0701Form.getStartYear()) + 1911;
		Integer endYear = Integer.parseInt(cira0701Form.getEndYear()) + 1911 ;
		
		for(int i = startYear ; i<= endYear ; i++)
		{
			StringBuffer str1 = new StringBuffer();
			StringBuffer str2 = new StringBuffer();
			StringBuffer str3 = new StringBuffer();
			StringBuffer str4 = new StringBuffer();
			StringBuffer str5 = new StringBuffer();
			
			/**
			 * �~�쥼�v�l�B
			 */
			str1.append(" (select isnull(sum(issue_amount),cast(0 as int))/");
			str1.append(cira0701Form.getBaseUnit());
			str1.append(" from issue_main where debt_type = 'C'" );
			str1.append("   and Year(issue_date) < ");
			str1.append(i);
			str1.append(" ) ");
			str1.append(" - ");
			str1.append(" (select isnull(sum(A.capital_amount),cast(0 as int))/");
			str1.append(cira0701Form.getBaseUnit());
			str1.append(" from payment_main A , issue_main B ");
			str1.append(" where B.debt_type = 'C' and A.issue_id = B.id and Year(A.repay_date) < ");
			str1.append(i);
			str1.append(" ) ");
			
			/**
			 * ��~�׭ɴ��`�B
			 */
			str2.append(" select isnull(sum(issue_amount),cast(0 as int))/");
			str2.append(cira0701Form.getBaseUnit());
			str2.append(" from issue_main where debt_type = 'C' and Cast(account_year as int) = ");
			str2.append(i - 1911);
			
			/**
			 * ��~���v�٥���
			 */
			str3.append(" select isnull(sum(A.capital_amount),cast(0 as int))/");
			str3.append(cira0701Form.getBaseUnit());
			str3.append(" from payment_main A, issue_main B ");
			str3.append(" where B.debt_type = 'C' and A.issue_id = B.id and Year(A.repay_date) = ");
			str3.append(i);
			
			/**
			 * �~�����v�l�B
			 */
			
			str4.append("isnull(("+str1+"),cast(0 as int)) + isnull(("+str2+"),cast(0 as int)) - isnull(("+str3+"),cast(0 as int)) ");
			
			/**
			 * ��~���|�ɥ����Q�v
			 */
			str5.append(" select case isnull(sum(issue_amount),cast(0 as int)) when 0 then 0 else sum( isnull(issue_amount,cast(0 as int)) * isnull(average_rate,cast(0 as int)) ) / isnull(sum(issue_amount),cast(0 as int)) end ");
			str5.append(" from issue_main" );
			str5.append(" where debt_type = 'C' and Cast(account_year as int) = ");
			str5.append(i - 1911);

			sqljob.appendSQL("INSERT INTO CIRA07_RPT ");
			sqljob.appendSQL(" ( ");
			sqljob.appendSQL(" USRID , MOD_DATE , Account_year , Amount1 ," +
							 " Amount2 , Amount3 , Amount4 , Average_rate )" );
			sqljob.appendSQL("Select top 1 '"+usrId+"', CURRENT_TIMESTAMP , ");
			
			if((startYear-1911) < 100)
			{	
				sqljob.appendSQL("0"+ Integer.toString(i - 1911));
			}
			else
			{
				sqljob.appendSQL(Integer.toString(i - 1911));
			}	
			sqljob.appendSQL(",("+str1+")");
			sqljob.appendSQL(",("+str2+")");
			sqljob.appendSQL(",("+str3+")");
			sqljob.appendSQL(",("+str4+")");
			sqljob.appendSQL(",("+str5+")/100 ");
			sqljob.appendSQL(" from issue_main ");
		}	

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
