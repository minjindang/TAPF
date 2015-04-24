/* HAMB0101.java
程式目的：HAMB01文字
程式代號：HAMB01
程式日期：0950220
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/

package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.central.form.Hamb0101Form;
import tw.gov.nta.sql.UnitAllocateMain;



/**
 * @author EricChen
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class HAMB0101 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// 取得 formBean
		Hamb0101Form myform = (Hamb0101Form) form;
		//使用Service:UnitAllocate
		//使用 UnitAllocate.getByYear 取得 dao array
		//myform.setMonKind("1"); //測試用 此值為loadpage時取得 才能分別種類
		myform.setModDate(new Date());				//設定修改日期
		myform.setUsrid(this.getUserId(request));	//設定修改的使用者
		List<UnitAllocateMain> list = (List<UnitAllocateMain>)UnitAllocate.getByYearOrderBySeq(myform.getAllYear(),myform.getAllMonth(),myform.getMonKind());
		//return to jsp
		BigDecimal total = new BigDecimal(0);
		myform.setOk(true);//設定是否確認過,預設確認過
		for(Iterator it=list.iterator();it.hasNext();){
			UnitAllocateMain tUnitAllocateMain = (UnitAllocateMain)it.next();
			total = total.add(tUnitAllocateMain.getSrcMoney());
			//若有其中一筆為false,則變為無確認過
			if (!tUnitAllocateMain.isOk())
				myform.setOk(tUnitAllocateMain.isOk());
		}
		request.setAttribute("totalAmount",total);
	    request.setAttribute("collection",list);
	}
}
