package tw.gov.nta.schedule.sys;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;

import tw.gov.nta.conversion.ConvertFile;

public class QuartzServlet extends GenericServlet {
	public void init(ServletConfig config) throws ServletException
	  {
		try 
	    {
	       SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
	       Scheduler schedPayment = schedFact.getScheduler();
	       schedPayment.start();
	       JobDetail jobDetailPayment = new JobDetail("myPaymentJob",
	    		   schedPayment.DEFAULT_GROUP,
	                                           BatchPayment.class);
	       CronTrigger triggerPayment = new CronTrigger( "myPaymentTrigger",schedPayment.DEFAULT_GROUP); 
	       triggerPayment.setCronExpression("0 0 0 ? * *");
	       schedPayment.scheduleJob(jobDetailPayment, triggerPayment); 
	       
	       //¤U¸ü¥¡¦æÂàÀÉ
	       Scheduler schedConvertFile = schedFact.getScheduler();
	       schedConvertFile.start();
	       JobDetail jobDetailConvertFile = new JobDetail("myConvertFileJob",
	    		   schedConvertFile.DEFAULT_GROUP,
	                                           AutoConvert.class);
	       CronTrigger triggerConvertFile = new CronTrigger( "myConvertFileTrigger",schedConvertFile.DEFAULT_GROUP); 
	       triggerConvertFile.setCronExpression("0 0 14 ? * *");
	       schedConvertFile.scheduleJob(jobDetailConvertFile, triggerConvertFile); 
	       
	     } 
	     catch (Exception ex) 
	     {
	         ex.printStackTrace();
	     }
	  }
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		

	}

}
