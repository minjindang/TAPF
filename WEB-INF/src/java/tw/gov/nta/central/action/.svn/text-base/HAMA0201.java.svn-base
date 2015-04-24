/*
 * 在 2006/2/17 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.LawPercent;
import tw.gov.nta.central.form.Hama0201Form;
/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class HAMA0201 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		//取得 formBean
		Hama0201Form hama0201form = (Hama0201Form) form;
		hama0201form.setModDate( new Date() );
		hama0201form.setUsrid( this.getUserId(request) );
		//使用Service:LawPercent
		//使用 LawPercent.update 更新
		//判斷國稅比例加總有無100
//		BigDecimal totalNation = new BigDecimal("0");
//		BigDecimal totalLocal = new BigDecimal("0");
//		BigDecimal totalInt = new BigDecimal("0");
//		totalNation = totalNation.add(hama0201form.getNationa());
//		totalNation = totalNation.add(hama0201form.getNationb());
//		totalNation = totalNation.add(hama0201form.getNationc());
//		totalLocal = totalLocal.add(hama0201form.getLocala());
//		totalLocal = totalLocal.add(hama0201form.getLocalb());
//		totalLocal = totalLocal.add(hama0201form.getLocalc());
//		
//		totalInt = totalInt.add(hama0201form.getInta());
//		totalInt = totalInt.add(hama0201form.getIntb());
//		totalInt = totalInt.add(hama0201form.getIntc());
		
		boolean isSuccess = true;
		String errorMes = "";
		
//		if( 100 != totalNation.intValue() )
//		{	
//			isSuccess = false;
//			errorMes = errorMes + "國稅總比例需等於100!!\\n" ;	
//		}
//		if( 100 != totalLocal.intValue() )
//		{	
//			isSuccess = false;
//			errorMes = errorMes + "地方稅總比例需等於100!!\\n" ;	
//		}
//		if( 100 != totalInt.intValue() )
//		{	
//			isSuccess = false;
//			errorMes = errorMes + "利息總比例需等於100!!\\n" ;	
//		}
//		if (isSuccess == false)
//		{
//			setAlertMessage(request,errorMes);
//		}
//		else
//		{
		/**調節額程式
		hama0201form.setNationc(new BigDecimal(0));
		hama0201form.setLocalc(new BigDecimal(0));
		hama0201form.setInta(new BigDecimal(0));
		hama0201form.setIntb(new BigDecimal(0));
		hama0201form.setIntc(new BigDecimal(0));
 * 
 */
			LawPercent.update(hama0201form.getLawPercentRef());
			setAlertMessage(request,Messages.SUCCESS_MODIFY);
//		}	
	}
}
