package tw.gov.nta.central.action;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;
import org.hibernate.Criteria;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import tw.gov.nta.central.common.NationalDebtDueDateMainController;
import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.central.form.Rama0101Form;
import tw.gov.nta.sql.TaxactionDet;
import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;
import tw.gov.nta.sql.NationalDebtDueDateMain;
import tw.gov.nta.sql.dao.NationalDebtDueDateMainDAO;
public class RAMA0100 extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// 取得 formBean
		Rama0101Form myForm = (Rama0101Form) form;	
		myForm.setCurrentUserDeptId(NationalDebtDueDateMainController.getCurrentUserDeptId(this.getUserId(request),connection));
		//for(String s : myForm.getRepayDate()){
			////System.out.println(s);
		//}
		String userDeptId = NationalDebtDueDateMainController.getCurrentUserDeptId(this.getUserId(request),connection);
		List collection = NationalDebtDueDateMainController.getNationalDebtDueDateList();//getNationalDebtDueDateList(userDeptId);
		
		request.setAttribute("collection",collection);
		//request.setAttribute("CurrentUserId",this.getUserId(request));
		//System.out.println("AAA" + getCurrentUserDeptId(this.getUserId(request),connection));
		request.setAttribute("CurrentUserDeptId",NationalDebtDueDateMainController.getCurrentUserDeptId(this.getUserId(request),connection));
		//myForm.setMyDto(Taxaction.getMaxYearDate("1"));
		//myForm.setTaxKind("1");
		//myForm.setMonKind("");
		//TaxactionDet myDet = new TaxactionDet();
		///myDet = Taxaction.getByYear(myForm.getTaxYear(),myForm.getTaxMonth(),myForm.getTaxKind());
		//if(myDet != null)
			//myForm.setMyDto(myDet);
		///tw.gov.nta.sql.base._BaseRootDAO.initialize();
		//NationalDebtExecutive ne = new NationalDebtExecutive();
		//ne.executePlan();
		//tw.gov.nta.sql.base._BaseRootDAO.closeCurrentThreadSessions();
	}
	
	public List getNationalDebtDueDateList(String userDeptId) {
		NationalDebtDueDateMainDAO nationalDebtDueDateMainDAO = new NationalDebtDueDateMainDAO();
        Criteria tCriteria = nationalDebtDueDateMainDAO.getSession().createCriteria(NationalDebtDueDateMain.class);
        List resultList = new java.util.ArrayList();
        for(java.util.Iterator i =tCriteria.list().iterator();i.hasNext();)
        {
        	//1.第三組人員(dept=8)但秘書室資料未填
        	//2.會計室人員(dept=2)且第三組人員已填但秘書室人員未填
        	//3.秘書室人員(dept=1暫訂)且第三組人員及會計室人員已填
        	//4.第三組人員(dept=8)但秘書室資料已填
        	//5.會計室人員(dept=2)但第三組人員未填
        	//6.會計室人員(dept=2)且第三組人員已填且秘書室人員已填
        	NationalDebtDueDateMain n = (NationalDebtDueDateMain)i.next();
        	
        	
        	//System.out.println(n.getRepayDate() + "_" + gov.dnt.tame.util.DateUtil.date2ROCStr(n.getRepayDate()));
        	//n.setRepayDate(gov.dnt.tame.util.DateUtil.date2ROCStr(n.getRepayDate()));
        	//第三組人員
        	if(userDeptId.equals("8"))
        	{
        		if(n.getSecretaryDate() ==null)
        			n.setState(1);
        		else
        			n.setState(4);
        	}
        	//會計室人員
        	else if(userDeptId.equals("2"))
        	{
        		if(n.getRepayHandle() ==null && n.getRepayNumber() == null)
        			n.setState(5);
        		else 
        		{
        			if(n.getSecretaryDate() ==null)
            			n.setState(2);
            		else
            			n.setState(6);
        		}
        	}
        	//秘書室人員
        	else if(userDeptId.equals("1"))
        	{
        		if((n.getRepayHandle() !=null || n.getRepayNumber() != null) && (n.getAccountDate() !=null || n.getAccountNumber() != null || n.getFundNumber() != null))
        			n.setState(3);
        	}
        	resultList.add(n);
        }
        return resultList;
	}
	
}
