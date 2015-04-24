/* AIRC1001.java 報表
 程式目的：AIRC10
 程式代號：AIRC10
 程式日期：0950309
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportRemainAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Airc1101Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class AIRC1101 extends ExcelReportRemainAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM AIRC11_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	protected SQLJob selTemp(ActionForm form,String usrId){
		Airc1101Form airc1101Form = (Airc1101Form) form;
		SQLJob sqljob = new SQLJob();
		BigDecimal unit = new BigDecimal(airc1101Form.getAmountUnit());
		if(unit.compareTo(new BigDecimal(0))==0)
			unit = new BigDecimal(1);
		
		sqljob.appendSQL("select (select issue_serial from issue_main where issue_main.id = airc11data.bond_code)bond_code,");
		for(int i = 1 ; i <= 8 ; i++){
			sqljob.appendSQL("sum_"+String.valueOf(i)+" / "+unit+" as sum_"+String.valueOf(i)+" ,");
			sqljob.appendSQL("percent_"+String.valueOf(i)+" as percent_"+String.valueOf(i));
			if(i != 8 )
				sqljob.appendSQL(",");
		}
		sqljob.appendSQL(" from airc11data where 1 = 1");
		if(airc1101Form.getLimitDate().equals(null)||!"".equals(airc1101Form.getLimitDate())){
			sqljob.appendSQL(" and bond_date = (select Max(bond_date) from airc11data where bond_date <=?)");
			sqljob.addParameter(new DateUtil().date2Str(airc1101Form.getLimitDate(), "yyyy/MM/dd"));
		}
		System.out.println(sqljob.toString());
		return sqljob;
	}
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		@SuppressWarnings("unused")
		BigDecimal sumTotal = new BigDecimal(0);
		BigDecimal percentTotal = new BigDecimal(0);
		
		List queryList1 = (List) run.query(selTemp(form,usrId), new MapListHandler());
		for(Iterator it = queryList1.iterator();it.hasNext();){
			Map map = (Map)it.next();
			for(int i = 1 ; i <= 8 ; i++){
				sumTotal = sumTotal.add(new BigDecimal(map.get("sum_"+String.valueOf(i)).toString()));
				percentTotal = percentTotal.add(new BigDecimal(map.get("percent_"+String.valueOf(i)).toString()));
			}
			map.put("sum_Total", sumTotal);
			map.put("percent_Total", percentTotal);

			run.update(connection,insTemp("AIRC11_RPT",map));
		}
	}
}
