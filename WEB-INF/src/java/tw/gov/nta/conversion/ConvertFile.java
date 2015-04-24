package tw.gov.nta.conversion;

import gov.dnt.tame.util.DateUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.Calendar;
import java.util.GregorianCalendar;

import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class ConvertFile {
	private static void convert(String sourcePath , String targetPath){
		try{
			FileInputStream fin = new FileInputStream(sourcePath+".txt");
			FileOutputStream fout = new FileOutputStream(targetPath+".txt"); 
			byte[] data = new byte[fin.available()]; 
			fin.read(data); 
			fout.write(data); 
			fout.close(); 
			fin.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void Convert() {
		// TODO Auto-generated method stub

		String[] sourceFile = {"TRBTBD"	,"TRBTLNO"	,"TRBPAYP"	,"TPSBF6"	,"TPSBF7",
										"TPSBF8"		,"TBBCF01"		,"TBBCF02"	,"TBBCF03"	,"TBBCF04",
										"TBBCF05"	,"TRB817"		,"TRB821"	,"TRBPASM","TRBST04"};
		//轉檔之前先將之前的檔案複製到備份資料夾
		for(int i = 0 ; i < sourceFile.length ; i ++){
			File file = new File("C:/dntConversion/" + sourceFile[i] + ".txt");
			if(file.exists()){
				String targetPath = "C:/dntConversion/" + sourceFile[i];
				File folder = new File(targetPath);
				if(!folder.isDirectory())
					folder.mkdir();
				Calendar tCalendar = GregorianCalendar.getInstance();
				String yyyymmddhhmmss = DateUtil.date2Str(tCalendar.getTime()) + DateUtil.getHours(tCalendar.getTime()) 
					+ DateUtil.getMinutes(tCalendar.getTime()) + DateUtil.getSeconds(tCalendar.getTime());
				File distFile = new File(targetPath + "/" + sourceFile[i] + "_" + yyyymmddhhmmss + ".txt");
				file.renameTo(distFile);
			}
		}
		
		for(int i = 0 ; i < sourceFile.length;i++){
			String sourcePath = "z:/";
			String targetPath = "C:/dntConversion/";
			sourcePath = sourcePath + sourceFile[i];
			targetPath = targetPath + sourceFile[i];
			convert(sourcePath,targetPath);
		}
		
		//開始處理轉檔作業
		Connection connection =  new IssueMainDAO().getSession().connection();
		//處理TRBTLNO的部份
		ConvertTRBTLNOForPAIDF convertTRBTLNOForPAIDF = new ConvertTRBTLNOForPAIDF();
		convertTRBTLNOForPAIDF.setConnection(connection);
		convertTRBTLNOForPAIDF.initialize();
		convertTRBTLNOForPAIDF.convert();
		//處理TRBST04的部份
		ConvertTRBST04 convertTRBST04 = new ConvertTRBST04();
		convertTRBST04.setConnection(connection);
		convertTRBST04.initialize();
		convertTRBST04.convert();
	}
}
