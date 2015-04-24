package tw.gov.nta.system.common;

import java.io.InputStream;
import java.net.URL;
 
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
 
public class DownloadFileAction extends Action{
 
   @Override
   public ActionForward execute(ActionMapping mapping, ActionForm form,
     HttpServletRequest request, HttpServletResponse response)
     throws Exception {
     response.setContentType("application/vnd.ms-excel");
     response.setHeader("Content-Disposition","attachment;filename=Unit_Allocate_Main_sample.xls");
 
     try 
     {
        URL url = getServlet().getServletContext()
                       .getResource("/excel/Unit_Allocate_Main_sample.xls");
        InputStream in = url.openStream();
        ServletOutputStream out = response.getOutputStream();
 
        byte[] outputByte = new byte[4096];
        //copy binary content to output stream
        while(in.read(outputByte, 0, 4096) != -1){
        	out.write(outputByte, 0, 4096);
        }
        in.close();
        out.flush();
        out.close();
 
     }catch(Exception e){
    	e.printStackTrace();
   }
 
   return null;
  }
}