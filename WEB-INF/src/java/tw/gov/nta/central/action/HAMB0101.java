/* HAMB0101.java
�{���ت��GHAMB01��r
�{���N���GHAMB01
�{������G0950220
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
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
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class HAMB0101 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// ���o formBean
		Hamb0101Form myform = (Hamb0101Form) form;
		//�ϥ�Service:UnitAllocate
		//�ϥ� UnitAllocate.getByYear ���o dao array
		//myform.setMonKind("1"); //���ե� ���Ȭ�loadpage�ɨ��o �~����O����
		myform.setModDate(new Date());				//�]�w�ק���
		myform.setUsrid(this.getUserId(request));	//�]�w�ק諸�ϥΪ�
		List<UnitAllocateMain> list = (List<UnitAllocateMain>)UnitAllocate.getByYearOrderBySeq(myform.getAllYear(),myform.getAllMonth(),myform.getMonKind());
		//return to jsp
		BigDecimal total = new BigDecimal(0);
		myform.setOk(true);//�]�w�O�_�T�{�L,�w�]�T�{�L
		for(Iterator it=list.iterator();it.hasNext();){
			UnitAllocateMain tUnitAllocateMain = (UnitAllocateMain)it.next();
			total = total.add(tUnitAllocateMain.getSrcMoney());
			//�Y���䤤�@����false,�h�ܬ��L�T�{�L
			if (!tUnitAllocateMain.isOk())
				myform.setOk(tUnitAllocateMain.isOk());
		}
		request.setAttribute("totalAmount",total);
	    request.setAttribute("collection",list);
	}
}
