package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Aima0101MForm;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;
import tw.gov.nta.system.common.CodeDetManage;

public class AIMA0100C extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		//get FormBean
		Aima0101MForm actionForm = (Aima0101MForm) form;
		if(null == actionForm.getAccountYear())
			actionForm.setAccountYear(DateUtil.date2ROCStr(new Date()).substring(0,3));
		if(actionForm.getAccountYear().length() < 3)
			actionForm.setAccountYear("00" + actionForm.getAccountYear());
		if(actionForm.getAccountYear().length() < 2)
				actionForm.setAccountYear("0" + actionForm.getAccountYear());
		if(request.getParameter("mod")==null || !request.getParameter("mod").equals("true")){
			if (actionForm.getAccountYear() != null || !actionForm.getAccountYear().equals(""))
			{
				String hqlStr = "select Max(serialNo) from IssueMain where 1=1";
				hqlStr += " and accountYear ='"+actionForm.getAccountYear()+"'";
				hqlStr += " and bondType ='"+actionForm.getBondType()+"'";
				hqlStr += " and debtType ='A'";
				hqlStr += " and bondKind = '1'";
				Session tSession = new IssueMainDAO().getSession();
				Query query = tSession.createQuery(hqlStr);
				if(query.list().get(0) == null)
					actionForm.setSerialNo("01");
				else{
					Integer serialNo = Integer.parseInt(query.list().get(0).toString());
					if(serialNo < 10)
						actionForm.setSerialNo("0"+(serialNo+1));
					else
						actionForm.setSerialNo(String.valueOf(serialNo+1));
				}
			}
		}
		else{
			IssueMain tIssueMian = new IssueManager().getBean(actionForm.getIssueMainId());
			if(actionForm.getAccountYear().equals(tIssueMian.getAccountYear())){
				actionForm.setSerialNo(tIssueMian.getSerialNo());
			}
			else{
				if (actionForm.getAccountYear() != null || !actionForm.getAccountYear().equals(""))
				{
					String hqlStr = "select Max(serialNo) from IssueMain where 1=1";
					hqlStr += " and accountYear ='"+actionForm.getAccountYear()+"'";
					hqlStr += " and bondType ='"+actionForm.getBondType()+"'";
					hqlStr += " and debtType ='A'";
					hqlStr += " and bondKind = '1'";
					Session tSession = new IssueMainDAO().getSession();
					Query query = tSession.createQuery(hqlStr);
					if(query.list().get(0) == null)
						actionForm.setSerialNo("01");
					else{
						Integer serialNo = Integer.parseInt(query.list().get(0).toString());
						if(serialNo < 10)
							actionForm.setSerialNo("0"+(serialNo+1));
						else
							actionForm.setSerialNo(String.valueOf(serialNo+1));
					}
				}
			}
		}
		if (actionForm.getBondType().equals("2")){
			actionForm.setIssueSerial(actionForm.getAccountYear()+"-S"+actionForm.getSerialNo());
		}else{
			actionForm.setIssueSerial(actionForm.getAccountYear()+"-"+actionForm.getSerialNo());
		}

		//Avery 計算,期滿開付日,到期日期,首次付息日期,首次還本日期
		if(actionForm.getIssueInterval() != null && actionForm.getIssueDate() != null)
		{
			Date issueDate = actionForm.getIssueDate();

			Calendar tCalendar = computeDate( issueDate );
			tCalendar.roll(Calendar.YEAR, actionForm.getIssueInterval());
			actionForm.setFinishDate(tCalendar.getTime());
			actionForm.setFirstRepayDate(tCalendar.getTime());
			
			Calendar t1Calendar = computeDate( tCalendar.getTime() );
			t1Calendar.add(Calendar.DATE,-1);
			if(t1Calendar.getTime().getDay()== 0)
				t1Calendar.add(t1Calendar.DATE,-2);
			if(t1Calendar.getTime().getDay() == 6)
				t1Calendar.add(t1Calendar.DATE,-1);
			actionForm.setDueDate(t1Calendar.getTime());
			
			Calendar t2Calendar = computeDate( issueDate );
			t2Calendar.add(Calendar.YEAR,1);
			actionForm.setFirstInterestDate(t2Calendar.getTime());
			actionForm.setCashDueDate(new Date());
		}
		//計算付息次數
		if (actionForm.getIssueInterval() != null)
			actionForm.setInterestAlternate(actionForm.getIssueInterval());
		if(actionForm.getRepayAlternate() == null)
			actionForm.setRepayAlternate(1);
		if (actionForm.getBondSellStatus() == null)
			actionForm.setBondSellStatus("N");
		
		//String codeName = CodeDetManage.getCodeName("BT",aima0101MForm.getBondType()).substring(0,CodeDetManage.getCodeName("BT",aima0101MForm.getBondType()).indexOf("("))+CodeDetManage.getCodeName("BT",aima0101MForm.getBondType()).substring(CodeDetManage.getCodeName("BT",aima0101MForm.getBondType()).indexOf(")"),CodeDetManage.getCodeName("BT",aima0101MForm.getBondType()).substring(0,CodeDetManage.getCodeName("BT",aima0101MForm.getBondType()).indexOf("("));
		String codeName = (actionForm.getBondType()!= null)?CodeDetManage.getCodeName("BT",actionForm.getBondType()):CodeDetManage.getCodeName("BT","");
		if(!codeName.equals(""))
			codeName = codeName.substring(0,codeName.indexOf("("))+codeName.substring(codeName.indexOf(")")+1,codeName.length());
		actionForm.setDebtName(actionForm.getAccountYear()+"年度"+codeName+"第"+actionForm.getSerialNo()+"期中央政府建設公債");

		if (actionForm.getAverageRate() == null)
			actionForm.setAverageRate(new BigDecimal("0").setScale(3,BigDecimal.ROUND_HALF_UP));
	}
	
	private Calendar computeDate(Date date)
	{
		Calendar tCalendar = GregorianCalendar.getInstance();
		tCalendar.setTime(date);
		return tCalendar;
	}
}
