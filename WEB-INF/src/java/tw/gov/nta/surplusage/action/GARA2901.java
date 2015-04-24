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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.NationDebitMain;
import tw.gov.nta.surplusage.common.Gara33ReMainList;
import tw.gov.nta.surplusage.common.Gara34ReMainList;
import tw.gov.nta.surplusage.form.Gara2901Form;
import tw.gov.nta.system.common.NationCodeManager;
import tw.gov.nta.system.common.NationDebitManager;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA2901 extends ExcelReportRemainAction {

	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception{
		Gara2901Form myForm = (Gara2901Form) form;
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
		run.update(connection,delSQLJob("GARA29_RPT",usrId));
		//���� insert
		
		//���ograr33���v�l�BList����
		//List qryGara33 = (List) run.query(CommonReportSQL.Gara33SQL(myForm.getAccountEyear(),unit), new MapListHandler());
		//Gara33ReMainList gara33 = new Gara33ReMainList(qryGara33);
		Gara33ReMainList gara33 = new Gara33ReMainList(connection,myForm.getAccountEyear(),unit);
		//���ograr34���v�l�BList����
		//List qryGara34 = (List) run.query(CommonReportSQL.Gara34SQL(myForm.getAccountEyear(),unit), new MapListHandler());
		//Gara34ReMainList gara34 = new Gara34ReMainList(qryGara34);
		Gara34ReMainList gara34 = new Gara34ReMainList(connection,myForm.getAccountEyear(),unit);	
		
		String accountYear="";
		String accountKind="";
		
		Map dMap = new HashMap();
		
		//�`�p
		BigDecimal total = new BigDecimal(0);
		//GNP
		BigDecimal gdpAmount = new BigDecimal(0);
		
		//�]�~�ת��j��
		for(int i=startYear;i<=endYear;i++)
		{
			dMap.putAll(getCommonMap(usrId));
			//��l�Ƭ��_�l�~
			accountYear = this.getStrYear(String.valueOf(i));
			//�]�w���ogara33���@�~���
			accountKind = getAccountKind(connection,accountYear,"'A'");
			gara33.setQryMap(accountYear,accountKind);
			//�]�w���ogara34���@�~���
			accountKind = getAccountKind(connection,accountYear,"'C','E'");
			gara34.setQryMap(accountYear,accountKind);
			
			/**
			 *	���� 
			 */
				//�~�קO
				dMap.put("account_year",accountYear);
				//��������
				dMap.put("BA1",gara33.getReMainField(1));
				//�A������
				dMap.put("BA2",gara33.getReMainField(2));
				//�E�G�@.....�έx��
				dMap.put("BA3",gara33.getReMainField(4));
				//�ŰȰ��
				dMap.put("BA4",gara33.getReMainField(5));
				//�X�p
				dMap.put("sum1",gara33.getReMainTotal());
			
			/**
			 * �ɶU
			 */	
				//�����ɴ� = �`�w�� + �Ծ�(�S�O�w��) + �_�G��(�S�O�w��) +�@�ߪk�|(�S�O�w��)
				//73,74�~�T�w���B
				if(i == 73)
					dMap.put("BA5",new BigDecimal("2433000000").divide(unit,4,BigDecimal.ROUND_HALF_UP));
				else if(i == 74)
					dMap.put("BA5",new BigDecimal("2008000000").divide(unit,4,BigDecimal.ROUND_HALF_UP));
				else
					dMap.put("BA5",gara34.getReMainField(1).add(
							gara34.getReMainField(2).add(
							gara34.getReMainField(3).add(
							gara34.getReMainField(5)))));
				
				
				
				//�S�O�w��-�A���ɴڥ��v�l�B
				dMap.put("BA6",gara34.getReMainField(4));
				//�E�G�@�����v�l�B
				dMap.put("BA7",gara34.getReMainField(6));
				//�ٶť��v�l�B
				dMap.put("BA8",gara34.getReMainField(7));
				//�ŰȰ�����v�l�B
				dMap.put("BA9",gara34.getReMainField(10));
				//�s�ͦa�}�o���v�l�B
				dMap.put("BA10",gara34.getReMainField(8));
				//³�����ǰ��������v�l�B
				dMap.put("BA11",gara34.getReMainField(9));				
				//�D��~������v�l�B
				dMap.put("BA12",gara34.getReMainField(11));
				//���v�l�B�`��
				//dMap.put("sum2",gara34.getReMainTotal());
				dMap.put("sum2",((BigDecimal)dMap.get("BA5")).add((BigDecimal)dMap.get("BA6"))
						.add((BigDecimal)dMap.get("BA7")).add((BigDecimal)dMap.get("BA8"))
						.add((BigDecimal)dMap.get("BA9")).add((BigDecimal)dMap.get("BA10"))
						.add((BigDecimal)dMap.get("BA11")).add((BigDecimal)dMap.get("BA12")));
				//���� + �ɶU
				//total = gara33.getReMainTotal().add(gara34.getReMainTotal());
				total = ((BigDecimal)dMap.get("sum1")).add((BigDecimal)dMap.get("sum2"));
				dMap.put("t1",total);
			/**
			 * �`�p�Φʤ���
			 */	
				//GDP
				gdpAmount = this.getGDP(connection,accountYear,unit);
				dMap.put("gdp_amount",gdpAmount);
				//���� �e ��X�`�B %
				dMap.put("T_rate",gara33.getReMainTotal()
						.divide(gdpAmount,4,4));
				//�ɴ� �e ��X�`�B %
				dMap.put("R_rate",gara34.getReMainTotal().divide(gdpAmount,4,4));
				//�`�p �e ��X�`�B %
				dMap.put("Sum_rate",total.divide(gdpAmount,4,4));
				//�s�W��TempTable
				run.update(connection,insTemp("GARA29_RPT",dMap));
				NationDebitMain nationDebitMain = new NationDebitMain();
				nationDebitMain.setAccountYear(accountYear);
				nationDebitMain.setNationCode(NationCodeManager.get(24));
				List list = new NationDebitManager().query(nationDebitMain);
				for(Iterator it = list.iterator() ; it.hasNext() ;){
					nationDebitMain = (NationDebitMain)it.next();
					nationDebitMain.setRemainRate(total.divide(gdpAmount,4,4).multiply(new BigDecimal(100)));
					new NationDebitManager().update(nationDebitMain.getId(), nationDebitMain);
				}
		}	
        SQLJob queryJob1 = selTemp1();
        List queryList1 = (List) run.query(queryJob1, new MapListHandler());
        String remark = "	�T�B";
        for(Iterator it1=queryList1.iterator();it1.hasNext();)
        {
        	Map mapQry1 = (Map) it1.next();
        	remark += (String)mapQry1.get("debit_name")+",";
        }
        request.setAttribute("remark",remark.substring(0,remark.length()-1));
        request.setAttribute("remarkRow",endYear-startYear);
	}

	protected SQLJob selTemp1(){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select debit_name from debit_ref where remark = '90�~�ץH��s�W�S�O�w��'");
		return sqljob;
	}
}
