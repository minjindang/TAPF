package tw.gov.nta.conversion.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import tw.gov.nta.conversion.ConvertTPSBF8;
import junit.framework.TestCase;


public class ConvertTPSBF8Test extends TestCase{
	@Test
	public final void testGetFullFilePath() {
		ConvertTPSBF8 convert = new ConvertTPSBF8();
		convert.initialize();
		assertEquals("C:\\dntConversion\\conversion\\TPSBF8", convert.getFullFilePath());
	}

//	@Test
//	public final void testGetReader() {
//		ConvertTPSBF8 convert = new ConvertTPSBF8();
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

	@Test
	public final void testConvert() {
		ConvertTPSBF8 convert = new ConvertTPSBF8();
		convert.initialize();
		convert.convert();
	}

	public final void testInsertData() {
		fail("Not yet implemented"); // TODO
	}
}
