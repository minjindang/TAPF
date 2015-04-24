/* HAMB0703.java
 程式目的：HAMB07文字
 程式代號：HAMB07
 程式日期：0950222
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */

package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.central.form.Hamb0701Form;
import tw.gov.nta.sql.UnitAllocateMain;

public class HAMC0703 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		// 查詢清單進入維護畫面要帶的值
		Hamb0701Form myform = (Hamb0701Form) form;
		UnitAllocateMain myInfo = new UnitAllocateMain();
		myInfo = UnitAllocate.getBean(myform.getId());
		myform.setMyUMain(myInfo); 
		String hours = "00";
		String mins =  "00";
		String secs =  "00";
		
		if(null != myInfo.getRecvDate())
		{
			hours = String.valueOf( DateUtil.getHours( myInfo.getRecvDate() ) );
			mins =  String.valueOf( DateUtil.getMinutes( myInfo.getRecvDate() ) );
			secs =  String.valueOf( DateUtil.getSeconds( myInfo.getRecvDate() ) );
		}
		if(hours.length()< 2)
		{
			hours = "0" + hours;
		}
		if(mins.length()< 2)
		{
			mins = "0" + mins;
		}
		if(secs.length()< 2)
		{
			secs = "0" + secs;
		}
		myform.setHouMinSec(hours+mins+secs);//時間格式
	}

}
