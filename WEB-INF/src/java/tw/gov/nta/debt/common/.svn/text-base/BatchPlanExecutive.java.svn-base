package tw.gov.nta.debt.common;

import gov.dnt.tame.util.DateUtil;

import java.util.Date;

public class BatchPlanExecutive
{
	public static void main(String[] args)
	{
		try{
			Date today = new Date();
			if (args.length != 0)
			{
				System.out.println(args[0]);
				today = DateUtil.str2Date(args[0]);
			}

			System.out.println("---------------------------------------------");
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
