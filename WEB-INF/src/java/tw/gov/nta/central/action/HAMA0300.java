/**
*
* @author Andrew Sung
* @createDate 2006/6/12
*/
package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.form.Hama0301Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class HAMA0300 extends DefaultAction {
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM HAMA03_RPT");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	protected SQLJob insTemp(ActionForm form,String usrId){
		Hama0301Form myForm = (Hama0301Form)form;	
		SQLJob sqljob = new SQLJob();
		//old Insert Sql
//		sqljob.appendSQL("INSERT INTO HAMA03_RPT ");
//		sqljob.appendSQL(" ( ");
//		sqljob.appendSQL(" USRID, ");
//		sqljob.appendSQL(" MAIN_UNIT_ID, MAIN_UNIT_NAME,GROUP_ID,DET_TPERCENT ");
//		sqljob.appendSQL(" ) ");
//		sqljob.appendSQL("SELECT '"+usrId+"', ");
//		sqljob.appendSQL("MAIN.UNIT_ID,");
//		sqljob.appendSQL("MAIN.UNIT_NAME, ");
//		sqljob.appendSQL("MAIN.GROUPID , ");
//		sqljob.appendSQL("ISNULL((SELECT TPERCENT FROM UNIT_PERCENT_DET WHERE UNIT_INFO_ID = MAIN.ID AND TYEAR = ?),0)");
//		sqljob.appendSQL("FROM UNIT_INFO_MAIN MAIN ");
//		sqljob.appendSQL("ORDER BY MAIN.SEQ_NO,MAIN.UNIT_ID ");
		
		
		//new insert sql
		sqljob.appendSQL("INSERT INTO HAMA03_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MAIN_UNIT_ID, GROUP_ID, ");
		sqljob.appendSQL(" MAIN_UNIT_NAME, DET_TPERCENT1, DET_TPERCENT2, DET_TPERCENT3, ");
		sqljob.appendSQL(" ALLOCATE_MONEY1, ALLOCATE_MONEY2 ");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL("SELECT '"+usrId+"', ");
		sqljob.appendSQL("MAIN.UNIT_ID,");
		sqljob.appendSQL("MAIN.GROUPID , ");
		/**修改0206(單一頁籤)
		sqljob.appendSQL("1 as GROUPID , ");
 		**/
		sqljob.appendSQL("MAIN.UNIT_NAME, ");
		sqljob.appendSQL("ISNULL((SELECT TPERCENT FROM UNIT_PERCENT_DET WHERE UNIT_INFO_ID = MAIN.ID and MAIN.GROUPID='01'AND TYEAR = '"+myForm.getQryYear()+"'),0) as DET_PERCENT1,");
		sqljob.appendSQL("ISNULL((SELECT TPERCENT FROM UNIT_PERCENT_DET WHERE UNIT_INFO_ID = MAIN.ID and MAIN.GROUPID='02'AND TYEAR = '"+myForm.getQryYear()+"'),0) as DET_PERCENT2,");
		sqljob.appendSQL("ISNULL((SELECT TPERCENT FROM UNIT_PERCENT_DET WHERE UNIT_INFO_ID = MAIN.ID and MAIN.GROUPID='03'AND TYEAR = '"+myForm.getQryYear()+"'),0) as DET_PERCENT3,");
		//sqljob.appendSQL("ISNULL((SELECT ALL_MONEY FROM UNIT_ALLOCATE_MAIN WHERE UNIT_INFO_ID = MAIN.ID AND MAIN.GROUPID='01'AND MON_KIND='1' AND ALL_MONTH = (select Max(all_month) from unit_allocate_main)),0) AS ALLOCATE_MONEY1,");
		//配合103年度
		sqljob.appendSQL("ISNULL((SELECT SUM(ALL_MONEY) FROM UNIT_ALLOCATE_MAIN WHERE UNIT_INFO_ID = MAIN.ID AND MAIN.GROUPID='01'AND MON_KIND='1' AND ALL_YEAR = '"+myForm.getQryYear()+"'),0) AS ALLOCATE_MONEY1,");
		//sqljob.appendSQL("ISNULL((SELECT ALL_MONEY FROM UNIT_ALLOCATE_MAIN WHERE UNIT_INFO_ID = MAIN.ID AND MAIN.GROUPID='02'AND MON_KIND='1' AND ALL_MONTH = (select Max(all_month) from unit_allocate_main)),0) AS ALLOCATE_MONEY2 ");
		//配合103年度
		sqljob.appendSQL("ISNULL((SELECT SUM(ALL_MONEY) FROM UNIT_ALLOCATE_MAIN WHERE UNIT_INFO_ID = MAIN.ID AND MAIN.GROUPID='02'AND MON_KIND='1' AND ALL_YEAR = '"+myForm.getQryYear()+"'),0) AS ALLOCATE_MONEY2 ");


		/**修改0206(單一頁籤)
		sqljob.appendSQL("ISNULL((SELECT TPERCENT FROM UNIT_PERCENT_DET WHERE UNIT_INFO_ID = MAIN.ID and MAIN.GROUPID in ('01','02','03') AND TYEAR = '"+myForm.getQryYear()+"'),0) as DET_PERCENT1,");
		sqljob.appendSQL("0 as DET_PERCENT2,");
		sqljob.appendSQL("0 as DET_PERCENT3,");
		sqljob.appendSQL("ISNULL((SELECT ALL_MONEY FROM UNIT_ALLOCATE_MAIN WHERE UNIT_INFO_ID = MAIN.ID AND MAIN.GROUPID in ('01','02','03') AND MON_KIND='1' AND ALL_MONTH = (select Max(all_month) from unit_allocate_main)),0) AS ALLOCATE_MONEY1,");
		sqljob.appendSQL("0 as ALLOCATE_MONEY2");
		**/
		sqljob.appendSQL("FROM UNIT_INFO_MAIN MAIN ");
		sqljob.appendSQL("ORDER BY MAIN.GROUPID,MAIN.SEQ_NO,MAIN.UNIT_ID ");
		
//		sqljob.addParameter(myForm.getQryYear());
		System.out.println(sqljob.toString());
		return sqljob;
	}
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		run.update(connection,insTemp(form,usrId));
	}

}
