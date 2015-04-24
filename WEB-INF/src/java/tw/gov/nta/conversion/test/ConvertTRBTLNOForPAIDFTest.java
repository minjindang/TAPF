package tw.gov.nta.conversion.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import tw.gov.nta.conversion.ConvertTRBTLNOForPAIDF;


public class ConvertTRBTLNOForPAIDFTest extends TestCase{
	private Connection connection = null;
	public final void testGetFullFilePath() {
		ConvertTRBTLNOForPAIDF convert = new ConvertTRBTLNOForPAIDF();
		convert.initialize();
		assertEquals("C:\\dntConversion\\TRBTLNO.txt", convert.getFullFilePath());
	}
//	public final void testGetReader() {
//		ConvertTRBTLNOForPAIDF convert = new ConvertTRBTLNOForPAIDF();
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
		ConvertTRBTLNOForPAIDF convert = new ConvertTRBTLNOForPAIDF();
		convert.initialize();
		convert.convert();
	}
}
