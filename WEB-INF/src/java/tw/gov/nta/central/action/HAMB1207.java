package tw.gov.nta.central.action;
import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.central.form.Hamb1201Form;
import tw.gov.nta.sql.UnitAllocateMain;
import tw.gov.nta.sql.UnitInfoMain;
public class HAMB1207 extends DefaultAction  {
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		//¨ú±o formBean
		Hamb1201Form hamb1201form = (Hamb1201Form) form;
		UnitAllocateMain unitAllocateMain = new UnitAllocateMain();
		unitAllocateMain.setAllYear( hamb1201form.getQryAllYear() );
		unitAllocateMain.setAllMonth( hamb1201form.getQryAllMonth() );
		UnitInfoMain unitInfoMain = new UnitInfoMain();
		unitInfoMain.setUnitId( hamb1201form.getQryUnitId() );
		unitInfoMain.setUnitName( hamb1201form.getQryUnitName() );
		unitAllocateMain.setUnitInfo( unitInfoMain );
		unitAllocateMain.setMonKind("1");
		hamb1201form.setQryTotal( UnitAllocate.Account(hamb1201form.getQryAllYear(),hamb1201form.getQryAllMonth(),"1") );
		List collection = UnitAllocate.getForFound(unitAllocateMain);
		request.setAttribute("collection",collection);
	}
}
