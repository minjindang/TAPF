package tw.gov.nta.conversion.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;

import tw.gov.nta.conversion.ConvertBase;
import tw.gov.nta.conversion.ConvertTPSBF7;

public class ConvertTPSBF7Test extends TestCase {
	
	@Test
	public final void testGetFullFilePath() {
		ConvertTPSBF7 convert = new ConvertTPSBF7();
		convert.initialize();
		assertEquals("D:\\央行轉檔資料\\TPSBF7.txt", convert.getFullFilePath());
	}

	@Test
	public final void testGetReader() {
		ConvertTPSBF7 convert = new ConvertTPSBF7();
		convert.initialize();
		BufferedReader reader = null;
		try {
			//reader = convert.getReader();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			assertNotNull(reader.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public final void testConvert() {
		ConvertTPSBF7 convert = new ConvertTPSBF7();
		convert.initialize();
		convert.convert();
	}

	public final void testInsertData() {
		fail("Not yet implemented"); // TODO
	}

}
