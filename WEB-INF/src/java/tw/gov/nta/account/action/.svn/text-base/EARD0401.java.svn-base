/*
 * 在 2006/2/27 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import tw.gov.nta.account.form.AccountQueryForm;
import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;
import org.apache.struts.action.ActionMapping;

/**
 * @author Avery
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class EARD0401 extends DefaultAction{
	

	protected SQLJob qrySQL(ActionForm form){
		AccountQueryForm myForm = (AccountQueryForm) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select issue_kind");
		sqljob.appendSQL("from debt_main,issue_main");
		sqljob.appendSQL("where debt_main.issue_id = issue_main.id and debt_main.id = ? ");
		sqljob.addParameter(myForm.getDebtId());
		System.out.println("SQL::"+sqljob);
		return sqljob;
	}

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection); 
		Map queryMap = (Map) run.query(qrySQL(form), new MapHandler());
		if ( queryMap != null&&!queryMap.isEmpty() ){
			String issueKind= (String)queryMap.get("issue_kind");
			if ("0".equals(issueKind)){
				request.setAttribute("reportType","reportA");
			}else if ("1".equals(issueKind)){
				request.setAttribute("reportType","reportB");
			}else{
				this.setAlertMessage(request,"查無資料");
				request.setAttribute("reportType","failed");
			}
		}
	}

	@Override
	public ActionForward getSuccessForward(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
				return mapping.findForward((String)request.getAttribute("reportType"));
	}
	
	
}
