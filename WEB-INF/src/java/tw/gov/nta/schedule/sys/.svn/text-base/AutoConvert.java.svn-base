package tw.gov.nta.schedule.sys;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class AutoConvert implements Job {

	public AutoConvert()
	{
	}
	  
	public void execute(JobExecutionContext context) throws JobExecutionException
	{
		try{
			tw.gov.nta.conversion.ConvertFile.Convert();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
