package tw.gov.nta.conversion.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;

import tw.gov.nta.conversion.ConvertTRBTLNO;

public class ConvertTRBTLNOTest extends TestCase {
	
	
	public final void testGetFullFilePath() {
		ConvertTRBTLNO convert = new ConvertTRBTLNO();
		convert.initialize();
		assertEquals("D:\\央行轉檔資料\\TRBTLNO.txt", convert.getFullFilePath());
	}


//	public final void testGetReader() {
//		ConvertTRBTLNO convert = new ConvertTRBTLNO();
//		convert.initialize();
//		BufferedReader reader = null;
//		try {
//			reader = convert.getReader();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			assertNotNull(reader.readLine());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}


	public final void testConvert() {
		ConvertTRBTLNO convert = new ConvertTRBTLNO();
		convert.initialize();
		convert.convert();
	}

	public final void testInsertData() {
		fail("Not yet implemented"); // TODO
	}

}
