package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.UserStatisticsDet;
import tw.gov.nta.sql.UserStatisticsMain;
import tw.gov.nta.surplusage.common.UserStatisticsManager;
import tw.gov.nta.surplusage.form.Gama0501Form;

public class GAMA0504 extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Gama0501Form myForm = (Gama0501Form) form;
		UserStatisticsManager manager = new UserStatisticsManager();
		UserStatisticsMain dto = myForm.getUserStatisticsMain();
		UserStatisticsMain dtoOld = manager.get(myForm.getId());
		dto.setUsrid( this.getUserId( request ) );
		dto.setModDate( new Date() );
		if(dto.getKeepBamount1().doubleValue() != dtoOld.getKeepBamount1().doubleValue() || dto.getKeepUamount1().doubleValue() != dtoOld.getKeepUamount1().doubleValue()
				|| dto.getKeepPamount1().doubleValue() != dtoOld.getKeepPamount1().doubleValue() || dto.getKeepRamount1().doubleValue() != dtoOld.getKeepRamount1().doubleValue()
				|| dto.getKeepBamount2().doubleValue() != dtoOld.getKeepBamount2().doubleValue() || dto.getKeepUamount2().doubleValue() != dtoOld.getKeepUamount2().doubleValue()
				|| dto.getKeepPamount2().doubleValue() != dtoOld.getKeepPamount2().doubleValue() || dto.getKeepRamount2().doubleValue() != dtoOld.getKeepRamount2().doubleValue())
		{
			DecimalFormat decimalFormat = new DecimalFormat("#,###");
			dto.setRemark(dto.getRemark()+DateUtil.date2ROCStr(new Date(),"yyy/mm/dd")+"保留數"+"異動項目:");
			if(dto.getKeepBamount1().doubleValue() != dtoOld.getKeepBamount1().doubleValue())
				dto.setRemark(dto.getRemark()+"公債列入債限原始"+decimalFormat.format(dtoOld.getKeepBamount1())+"改為"+decimalFormat.format(dto.getKeepBamount1())+";");
			if(dto.getKeepUamount1().doubleValue() != dtoOld.getKeepUamount1().doubleValue())
				dto.setRemark(dto.getRemark()+"公債不列入債限原始"+decimalFormat.format(dtoOld.getKeepUamount1())+"改為"+decimalFormat.format(dto.getKeepUamount1())+";");
			if(dto.getKeepPamount1().doubleValue() != dtoOld.getKeepPamount1().doubleValue())
				dto.setRemark(dto.getRemark()+"公債還款金額原始"+decimalFormat.format(dtoOld.getKeepPamount1())+"改為"+decimalFormat.format(dto.getKeepPamount1())+";");
			if(dto.getKeepRamount1().doubleValue() != dtoOld.getKeepRamount1().doubleValue())
				dto.setRemark(dto.getRemark()+"公債未償還金額原始"+decimalFormat.format(dtoOld.getKeepRamount1())+"改為"+decimalFormat.format(dto.getKeepRamount1())+";");
			if(dto.getKeepBamount2().doubleValue() != dtoOld.getKeepBamount2().doubleValue())
				dto.setRemark(dto.getRemark()+"中長借列入債限原始"+decimalFormat.format(dtoOld.getKeepBamount2())+"改為"+decimalFormat.format(dto.getKeepBamount2())+";");
			if(dto.getKeepUamount2().doubleValue() != dtoOld.getKeepUamount2().doubleValue())
				dto.setRemark(dto.getRemark()+"中長借不列入債限原始"+decimalFormat.format(dtoOld.getKeepUamount2())+"改為"+decimalFormat.format(dto.getKeepUamount2())+";");
			if(dto.getKeepPamount2().doubleValue() != dtoOld.getKeepPamount2().doubleValue())
				dto.setRemark(dto.getRemark()+"中長借還款金額原始"+decimalFormat.format(dtoOld.getKeepPamount2())+"改為"+decimalFormat.format(dto.getKeepPamount2())+";");
			if(dto.getKeepRamount2().doubleValue() != dtoOld.getKeepRamount2().doubleValue())
				dto.setRemark(dto.getRemark()+"中長借未償還金額原始"+decimalFormat.format(dtoOld.getKeepRamount2())+"改為"+decimalFormat.format(dto.getKeepRamount2())+";");
			
			if(300 < dto.getRemark().length()){
				int length = 0;
				String remark = new String();
				length = dto.getRemark().length();
				remark = dto.getRemark();
				dto.setRemark(remark.substring(length - 300+1,length)); //取最新的500
			}
		}
		if(new UserStatisticsManager().get(dto.getId()).getUserStatisticsDets().size() == 0){
			dto.setOddKeepBamount1(dto.getKeepBamount1());
			dto.setOddKeepBamount2(dto.getKeepBamount2());
			dto.setOddKeepUamount1(dto.getKeepUamount1());
			dto.setOddKeepUamount2(dto.getKeepUamount2());
		}
		if(null == dto.getAccountType())	
			dto.setAccountType("N");
		else
			dto.setAccountType("Y");
		try{
			manager.update( dto );
		}
		catch(Exception e){
			setAlertMessage(request,Messages.FAILURE_IMPORT+",發生不可預期的錯誤!!");
		}
		
		setAlertMessage(request,Messages.SUCCESS_MODIFY);
	}
}
