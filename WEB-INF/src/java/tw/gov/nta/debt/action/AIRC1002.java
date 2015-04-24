/* AIRC1002.java ����
 �{���ت��GAIRC10
 �{���N���GAIRC10
 �{������G0950308
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.PageSize;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.ExcelReportAction;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.debt.form.Airc0901Form;
import tw.gov.nta.debt.form.Airc1001Form;
import tw.gov.nta.system.common.CodeDetManage;

public class AIRC1002 extends JacobReportAction {

	private final static String PROGRAM_ID = "AIRC10";
	protected ReportManager getReportManager(ActionForm form,
			HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	protected String getProgramId(HttpServletRequest request) {
		return PROGRAM_ID;
	}
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Airc1001Form airc1001Form = (Airc1001Form) form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		String AmountUnit = airc1001Form.getAmountUnit();
		String AmountUnitLabel = "";
		String queryYear = "";
		String kind = request.getParameter("kind");
		
		/**
		�p��ܺ����G����
		���X������D�G�����n���Ũ������H���R�J�`��
		�p��ܺ����G��w��
		���X������D�G�n����w�������H���R�J�`��
		**/
		if("B".equals(kind))
			map.put("A2","�n����w�������H���R�J�`��");
		else
			map.put("A2","�����n���Ũ������H���R�J�`��");
		
		if(!airc1001Form.getLimitSDate().equals(""))
			queryYear = queryYear+airc1001Form.getLimitSDate().substring(0, 3)+"�~"+airc1001Form.getLimitSDate().substring(3, 5)+"��";
		if(!airc1001Form.getLimitEDate().equals(""))
			queryYear = queryYear+"��"+airc1001Form.getLimitEDate().substring(0, 3)+"�~"+airc1001Form.getLimitEDate().substring(3, 5)+"��";
		//if (AmountUnit.equals("0"))
			//AmountUnit ="1";
		//�]���ϥηs��SQL�A���ƭȤw���B�z�A�אּ�bEXCEL�B�z�A�ñN��]�w������
		map.put("A3",queryYear);
		//map.put("N6","�s�x��"+CodeDetManage.getCodeName("BU",AmountUnit));
		
		List dataList = (List)request.getAttribute("dataList");
		if(dataList != null){
			int startRow = 10;
			for(int i = 0 ; i < dataList.size() ; i ++){
				Map dataMap = (Map)dataList.get(i);
				map.put("A"+startRow,String.valueOf(dataMap.get("year_month")));
				map.put("B"+startRow,String.valueOf(dataMap.get("sum_1")));
				map.put("D"+startRow,String.valueOf(dataMap.get("sum_2")));
				map.put("F"+startRow,String.valueOf(dataMap.get("sum_3")));
				map.put("H"+startRow,String.valueOf(dataMap.get("sum_4")));
				map.put("J"+startRow,String.valueOf(dataMap.get("sum_5")));
				map.put("L"+startRow,String.valueOf(dataMap.get("sum_6")));
				map.put("N"+startRow,String.valueOf(dataMap.get("sum_7")));
				map.put("P"+startRow,String.valueOf(dataMap.get("sum_8")));
				map.put("R"+startRow,String.valueOf(dataMap.get("sum_9")));
				map.put("T"+startRow,String.valueOf(dataMap.get("sum_10")));
			}
		}
		return map;
	}
	
}