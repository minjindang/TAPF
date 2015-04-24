/* Debug.java
 * Created on 2004/11/5
 */
package gov.dnt.tame.util;

import com.kangdainfo.ast.sql.SQLJob;

/**
 * @author Mango_MANGO
 */
public class Debug
{
    public static String out(String s)
    {
        if(s instanceof String )
        {
		    System.out.println(s);
		    return s;
        }
        else
        {
            return null;
        }
    }    
    
    public static void out(String name,String s)
    {
		if( name instanceof String && s instanceof String)
		{
		    System.out.println(name + " = " + out(s));
		}
    }
    
    public static void out(SQLJob job)
    {
        if(job instanceof SQLJob)
        {
            System.out.println("================== ^_^ ===================");
            System.out.println(job.getSQL());
            System.out.println("================== >_< ===================");
            
            Object o[] = job.getParameters();
            for(int i=0; i< o.length ; ++i)
            {
            	System.out.println("parameter " + i + " = " + o[i]);
            }
        }
    }
}
