package tw.gov.nta.conversion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

public class Conversion {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		DOMParser tParser = new DOMParser();
		Connection tConnection = null;
		BufferedWriter tLoger = null;
		try {
			tLoger = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("log.txt"), true), "UTF-8"));
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println(getTime() + "log檔開啟失敗!!");
			System.exit(0);
		}
		Document tDocument = null;
		Node tDbNode = null;
		NodeList tFileNodeList = null;
		try {
			tParser.parse(new InputSource(new FileInputStream(new File("D:/MyWorks/Workspace/TAPF/conversion/config.xml"))));
			tDocument = tParser.getDocument();
		} catch (Exception e) {
			e.printStackTrace();
			log(tLoger, "參數檔開啟失敗 !!");
			tLoger.flush();
			System.exit(0);
		}

		NamedNodeMap tAttributes = tDbNode.getAttributes();
		String tDriver = getAttributeValue(tAttributes, "driver");
		String tUrl = getAttributeValue(tAttributes, "url");
		String tId = getAttributeValue(tAttributes, "id");
		String tPassword = getAttributeValue(tAttributes, "password");
		try {
			Class.forName(tDriver); 
			tConnection = DriverManager.getConnection(tUrl, tId, tPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log(tLoger, "資料庫連接失敗 !!");
			System.exit(0);
		} catch (ClassNotFoundException e) {
			 System.out.println("找不到驅動程式類別"); 
	         e.printStackTrace(); 
	         log(tLoger, "找不到驅動程式類別 !!");
		}
		Node tFileNode = null;
		String tFilePath = null;
		String tFileName = null;
		for (int i = 0; i < tFileNodeList.getLength(); i++) {
			tFileNode = tFileNodeList.item(i);
			tAttributes = tFileNode.getAttributes();
			tFilePath = getAttributeValue(tAttributes, "path");
			tFileName = getAttributeValue(tAttributes, "fileName");
			try {
				convert(tFileNode, tConnection);
			} catch (Exception e) {
				log(tLoger, "轉換檔案" + tFilePath + "/" + tFileName + "失敗!!");
				e.printStackTrace();
			}
			moveFile(tFilePath + "/" + tFileName, buildDestnationPath(tFilePath) + "/" + tFileName);
			log(tLoger, "轉換檔案" + tFilePath + "/" + tFileName + "成功!!");
		}
		
		
		
	}
	
	public static String buildDestnationPath(String pSourcePath){
		Calendar tCalendar = Calendar.getInstance();
		String tNewPath = pSourcePath + "/" + String.valueOf(tCalendar.get(Calendar.YEAR)) + String.valueOf(tCalendar.get(Calendar.MONTH)+1) + String.valueOf(tCalendar.get(Calendar.DAY_OF_MONTH));
		File tFile = new File(tNewPath);
		tFile.mkdirs();
		return tNewPath;
	}
	
	public static void log(BufferedWriter pLoger, String pLog){
		System.out.println(getTime() + pLog);
		try {
			pLoger.write(getTime() + ":" + pLog);
			pLoger.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("log檔寫入失敗!!");
		}
		
	}
	
	public static String getTime(){
		Calendar tCalendar = Calendar.getInstance();
		return tCalendar.get(Calendar.YEAR) + "年" + tCalendar.get(tCalendar.get(Calendar.MONTH)) + "月" + tCalendar.get(Calendar.DAY_OF_MONTH) + "日-" + tCalendar.get(Calendar.HOUR_OF_DAY) + "時" + tCalendar.get(Calendar.MINUTE) + "分" + tCalendar.get(Calendar.SECOND) + "秒";
	}
	
	public static void convert(Node pFileNode, Connection pConnection) throws Exception{
		NamedNodeMap tAttributes = pFileNode.getAttributes();
		String tClassName = getAttributeValue(tAttributes, "classname");
		String tPath = getAttributeValue(tAttributes, "path");
		String tFileName = getAttributeValue(tAttributes, "fileName");
		ConvertInterface tConverter = (ConvertInterface) Class.forName("tw.gov.nta.conversion." + tClassName).newInstance();
		tConverter.insertData(pConnection, tPath + "/" + tFileName);
	}

	public static String getAttributeValue(NamedNodeMap pNamedNodeMap,String pAttribute) {
		Node tNode = pNamedNodeMap.getNamedItem(pAttribute);
		return tNode == null || "".equals(tNode.getNodeValue().trim()) ? null: tNode.getNodeValue();
	}
	
	public static void moveFile(String pSource, String pDestination) throws IOException{
		File tInputFile = new File(pSource);
		BufferedReader tInputFileReader = new BufferedReader(new InputStreamReader(new FileInputStream(tInputFile),"Big5"));
		BufferedWriter tOutputFileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(pDestination), true), "Big5"));
		String tTemp = tInputFileReader.readLine();
		while ((tTemp =  tInputFileReader.readLine())!=null) {
			tOutputFileWriter.write(tTemp);
			tOutputFileWriter.newLine();
		}
		tOutputFileWriter.flush();
		tInputFile.delete();
	}

}
