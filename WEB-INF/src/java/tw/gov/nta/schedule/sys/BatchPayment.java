package tw.gov.nta.schedule.sys;

import gov.dnt.tame.util.DateUtil;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import tw.gov.nta.debt.common.PlanExecutive;

public class BatchPayment implements Job {

	public BatchPayment()
	{
	}
	  
	public void execute(JobExecutionContext context) throws JobExecutionException
	{
		try{
			Date today = new Date();
			
			//today = DateUtil.str2Date(today);

			System.out.println(today);

			tw.gov.nta.sql.base._BaseRootDAO.initialize();
			PlanExecutive pe = new PlanExecutive();
			pe.executePlan( today );
			tw.gov.nta.sql.base._BaseRootDAO.closeCurrentThreadSessions();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
