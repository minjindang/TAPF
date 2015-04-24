
package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.io.FileUtils;
import org.apache.struts.action.ActionForm;

import org.jdom.*;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class EARF0106 extends DefaultAction{



	
	private void  openXML(ActionForm form,HttpServletResponse response,String id,String folder,String fileName) throws IOException
	{
		
		AccountQueryForm myForm = (AccountQueryForm) form;
		String path = "C:/GBA/"+folder+"/"+id+".XML";
		File file =new File(path);
		byte[] bytes = FileUtils.readFileToByteArray(file);

		response.setContentType("text/xml");
		
		
		//response.setContentType("application/vnd.ms-word");
		response.setHeader("Content-disposition", "attachment; filename="+fileName+".XML"  );

		OutputStream os = response.getOutputStream();
		os.write(bytes);
		os.flush();
		os.close();
		response.flushBuffer();
		
		os.close();
	}
	
	public void executeQuery(ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception {

		//點擊超鏈結後，下載xml檔案
		AccountQueryForm myForm = (AccountQueryForm) form;

		SQLRunner run = new ConnectionSQLRunner(connection);

		
		//取得ID
		String ID = request.getParameter("ID").toString();
		
		//取得資料夾名稱
		String folder = request.getParameter("folder").toString();
		
		//取得檔名
		String fileName = request.getParameter("fileName").toString();
		
		openXML(form,response,ID,folder,fileName);
		
		//setAlertMessage(request,"確認完成");
	}






	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}