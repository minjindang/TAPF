<%@ page language="java" contentType="text/html;charset=MS950" %>
<%@ page import="java.util.*,java.math.BigDecimal,gov.dnt.tame.util.DateUtil" %>
<script>
<%

	//"num="+num+"&capitalAmount="+capitalAmount+"&startDate="+startDate+"&endDate="+endDate+"&debtId="+debtId+";
	Integer num = new Integer(Integer.parseInt(request.getParameter("num")));
	BigDecimal capitalAmount = new BigDecimal(request.getParameter("capitalAmount").replaceAll(",",""));
	//Date startDate = DateUtil.str2Date(request.getParameter("startDate"));
	//Date endDate = DateUtil.str2Date(request.getParameter("endDate"));
	
	BigDecimal rate = new BigDecimal(request.getParameter("rate"));
	Integer debtId = new Integer(Integer.parseInt(request.getParameter("debtId")));
	BigDecimal repayDays = new BigDecimal(request.getParameter("repayDays"));
	System.out.println(num);
	System.out.println(capitalAmount);
	//System.out.println(startDate);
	//System.out.println(endDate);
	System.out.println(debtId);
	System.out.println(repayDays);
	System.out.println(rate);
	System.out.println(capitalAmount.longValue() +"*"+ rate.longValue()+" *"+ repayDays.longValue() +"/365");
	BigDecimal interest = capitalAmount.multiply(rate.divide(new BigDecimal(100))).multiply(repayDays).divide(new BigDecimal(365),6);
	System.out.println(interest);
	//List rate = new tw.gov.nta.debt.common.RateManager().getEffectiveRate(debtId.intValue());
	//BigDecimal interest = new tw.gov.nta.debt.common.InterestCounter().countInterest(startDate,endDate,rate,capitalAmount.doubleValue(),0);
	
	out.print("\t\tparent.MainForm.elements('debtPlanDet["+num+"].interestAmount').value = "+interest.setScale(0,BigDecimal.ROUND_HALF_UP)+"; \r\n");
	out.print("\t\tparent.MainForm.elements('debtPlanDet["+num+"].totalCount').value = "+capitalAmount.add(interest).setScale(0,BigDecimal.ROUND_HALF_UP)+"; \r\n");
%>
</script>