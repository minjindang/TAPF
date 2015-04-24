
package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
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

public class EARF0103 extends DefaultAction{

	protected String outputXML(ActionForm form, HttpServletRequest request,Connection connection,List tempList) throws IOException, SQLException{

		 AccountQueryForm myForm = (AccountQueryForm) form;
		 
		 Element rootElement = new Element("DOC");      
	     Document document = new Document(rootElement); 
	     
	     //讓xml欄位排序用
	     //此處的欄位名稱必需與EARF01_RPT裡的欄位名稱相同
	     String[] colSequence ={  "datatype"	,"fundkind"		,"budgetkind"	,"specialbudgetno"	
	    		 				 ,"fiscalyear"	,"issueyear"	,"serialno"		,"debttype"	        ,"incredebt"
					    		 ,"debtno"		,"debtname"		,"issuedate"	,"duedate"			
					    		 ,"interestdate" ,"interestno"  ,"issueamount"	
					    		 ,"realamount"	,"diversityamount" ,"costamount"	,"payamount"	,"sharediversityamount"	 ,"sharecostamount"
	     };

	     Object rowValue = null;
	     String rowName = "";
	     
	     for(Iterator rowIterator = tempList.iterator(); rowIterator.hasNext(); ) {
		    Map tempMap = (Map) rowIterator.next();  
		    Element row = new Element("DOC_ROW");
		    for (int i = 0 ;i <colSequence.length ;i++ ){
		    	rowName=colSequence[i];
		    	rowValue=tempMap.get(rowName);
		    		
		    	//如果欄位無值，則不顯示此element
		    	if (null == rowValue)
		    		rowValue = " ";
		    	if (null != rowValue && (rowValue.equals("C") || rowValue.equals("D")))
		    		rowValue = "B";
		    	if(null != rowValue){
			   		Element content = new Element(rowName);
			   		content.addContent(rowValue.toString());
			   		row.addContent(content);
		    	}
		    }
		    rootElement.addContent(row);
		 }

	     //==== 輸出XML文件&寫入LOG檔(GBA_TRANSFORM)============      
	     XMLOutputter outputter = new XMLOutputter();
	     Format format = Format.getPrettyFormat();
	     format.setEncoding("BIG5");
	     outputter.setFormat(format);
	     
	     //設定產出目錄
	     String filePath = "C:/GBA/";
	     
	     //依日期建立目錄(EX:09703)
		String forlderName= filePath+getFolderName(form);
		
		File newForlder = new File(forlderName);
		if ( newForlder.exists() )
		{
		    System.out.println( "newForlder exists!"+newForlder.getAbsolutePath());
		}
		else
		{
		    System.out.println("newForlder not exists!");
			newForlder.mkdir();
		}
		
		/*
		 * 檔案名稱：範例SD09702011710003
		 * 1     S:子系統別
		 * 2     D:處理別
		 * 3-5 YYY：會計年度
		 * 6-7  MM:月份
		 * 8-9  DD:日
		 * 10-16     ：機關編號1710003
		 */
		String fileName = "SD"+myForm.getLastDate()+"1710003";

		//寫入LOG檔(GBA_TRANSFORM)
		insertLog(form,request,connection,forlderName,fileName);
		//以LOG檔的ID為檔名，以避免重覆產出時的檔案覆蓋問題
		String ID = getID(connection);

		ID = ID + fileName;
		
		//產生XML檔
	    FileWriter writer = new FileWriter(forlderName+ID+".XML");
	    outputter.output(document, writer);
	    writer.close();
	    
	    return forlderName+ID+".XML";

	}

	private static String getFolderName(ActionForm form)
	{
		AccountQueryForm myForm = (AccountQueryForm) form;
	
		//以USER選的會計年度、會計月份當資料夾名稱
		String Y="", M="", D="", h="", m="", s="";
		Y = myForm.getAccountYear();
		M = myForm.getMonth();
		return Y + M  + "/";
	}
	
	protected void insertLog(ActionForm form, HttpServletRequest request,Connection connection,String path,String filename) throws SQLException{
		AccountQueryForm myForm = (AccountQueryForm) form;
		SQLRunner run = new ConnectionSQLRunner(connection);
		SQLJob sqljob = new SQLJob();
		
		String usrId = this.getUserId(request);
		new Timestamp( new Date().getTime() ) ;

		sqljob.appendSQL(" INSERT INTO GBA_TRANSFORM  ");
		sqljob.appendSQL("   (TRANSDATE  ,PATH  ,FOLDER  ,FILENAME  ,TRANSUSR  ,MOD_USR  ,MOD_DATE    )  ");
		sqljob.appendSQL("   VALUES");
		sqljob.appendSQL("   (?          ,?     ,?       ,?         ,?         ,?        ,?           ) ");
		sqljob.addParameter(new Timestamp( new Date().getTime() ) );  //TRANSDATE
		sqljob.addParameter(path);   //PATH
		sqljob.addParameter(myForm.getAccountYear()+myForm.getMonth());   //FOLDER
		sqljob.addParameter(filename);  //FILENAME
		sqljob.addParameter(usrId);  //TRANSUSR
		sqljob.addParameter(usrId);  //MOD_USR
		sqljob.addParameter(new Timestamp( new Date().getTime() ));  //MOD_DATE

		run.update(connection,sqljob);	
	}

	protected String getID(Connection connection) throws SQLException{
		//取得log檔的最大id
		String maxID = "";
		SQLRunner run = new ConnectionSQLRunner(connection);
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL(" SELECT MAX(ID) as ID FROM  GBA_TRANSFORM  ");
		
		Map map = (Map) run.query(sqljob, new MapHandler());
		
		if(null!=map && !map.isEmpty()){
			maxID = map.get("ID").toString();			
			
		}
		
		return maxID;
	}
	
	private void  openXML(ActionForm form,HttpServletResponse response,String fileName) throws IOException
	{
		
		AccountQueryForm myForm = (AccountQueryForm) form;
		File file =new File(fileName);
		byte[] bytes = FileUtils.readFileToByteArray(file);

		response.setContentType("text/xml");
		
		if ("0".equals(myForm.getIp()))
			response.setHeader("Content-disposition", "attachment; filename="+"SD"+myForm.getLastDate()+"1710003"+".XML"  );
		if ("1".equals(myForm.getIp()))
			response.setHeader("Content-disposition", "attachment; filename="+"SD"+myForm.getLastDate()+"1710003S"+".XML");

		OutputStream os = response.getOutputStream();
		os.write(bytes);
		os.flush();
		os.close();
		response.flushBuffer();

//		out.clear();
//		out = pageContext.pushBody();

	}
	
	public void executeQuery(ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception {

		AccountQueryForm myForm = (AccountQueryForm) form;

		//取得earf0101物件，以共用method
		EARF0101 earf0101 = new EARF0101();
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);

		//取得XML所需之資料tempList
		List tList = null;//從各大table中撈出來的資料，未經整理的資料
		ArrayList tempList = new ArrayList();;//經過整理的資料
		//若 i為0，則查發行的SQL，若為1，則查還本付息

		//若opening為0，則查尋一般公債GBA
		if ("0".equals(myForm.getOpening()))
			tList = (List) run.query(earf0101.getSql(form), new MapListHandler());////一般公債GBA
		else if ("1".equals(myForm.getOpening()))
			tList = (List) run.query(earf0101.getOpeningSQL(form), new MapListHandler());//期初公債GBA

		for(Iterator tIterator = tList.iterator(); tIterator.hasNext(); )
		{
			Map tMap = (Map) tIterator.next();  

			Map dMap = earf0101.enCode(form,tMap,connection);
			tempList.add(dMap);
		}
//		for (int i = 0 ;i <=1 ;i++){
//			//若 i為0，則查發行的SQL，若為1，則查還本付息
//			tList = (List) run.query(earf0101.getSql(form,i), new MapListHandler());
//			System.out.println("tList.size = "+tList.size());
//			for(Iterator tIterator = tList.iterator(); tIterator.hasNext(); )
//			{
//				Map tMap = (Map) tIterator.next();  
//
//				Map dMap = earf0101.enCode(form,tMap,connection);
//				tempList.add(dMap);
//			}
//		}
		//產生XML至目錄中，並寫入log檔
		String fileName = outputXML(form,request,connection,tempList);
		
		//將XML檔下載至USER端
		openXML(form,response,fileName);
		
		//setAlertMessage(request,"確認完成");
	}

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		// TODO Auto-generated method stub
		
	}

}