package tw.gov.nta.conversion.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import tw.gov.nta.conversion.ConvertFunction;

public class ConvertFunctionTest {

	@Test
	public final void testSolBNDID() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetIdByIssueSerial() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetIssVal() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetBankCode() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetBankCodeFromAccount() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testTraToNum() {
		assertEquals(new BigDecimal(0), ConvertFunction.traToNum("{"));
		assertEquals(new BigDecimal(1), ConvertFunction.traToNum("A"));
		assertNotSame(new BigDecimal(1), ConvertFunction.traToNum("a"));
		assertEquals(new BigDecimal(0), ConvertFunction.traToNum("}"));
		assertEquals(new BigDecimal(-1), ConvertFunction.traToNum("J"));
		//assertEquals(new BigDecimal(-10), ConvertFunction.traToNum("-1"));
	
	}

	@Test
	public final void testTraString() {
		fail("Not yet implemented"); // TODO
	}


	@Test
	public final void testInsTemp() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public final void testTransToCounts() {
		assertEquals(new BigDecimal(30000), ConvertFunction.transToCounts("3000{"));
		assertEquals(new BigDecimal(30003), ConvertFunction.transToCounts("3000C"));
		assertEquals(new BigDecimal(-30003), ConvertFunction.transToCounts("3000L"));
		assertEquals(new BigDecimal(-3), ConvertFunction.transToCounts("0000L"));
		assertEquals(new BigDecimal(0), ConvertFunction.transToCounts("0000{"));
		assertEquals(new BigDecimal(4), ConvertFunction.transToCounts("0000D"));
	}

	
	@Test
	public final void testTransToAmount() {
		assertEquals(new BigDecimal(300000), ConvertFunction.transToAmount("000030000000{"));
		assertEquals(new BigDecimal(-300000), ConvertFunction.transToAmount("000030000000}"));
//		assertEquals(new BigDecimal(30003), ConvertFunction.transToAmount("3000C"));
//		assertEquals(new BigDecimal(-30003), ConvertFunction.transToAmount("3000L"));
//		assertEquals(new BigDecimal(-3), ConvertFunction.transToAmount("0000L"));
//		assertEquals(new BigDecimal(0), ConvertFunction.transToAmount("0000{"));
//		assertEquals(new BigDecimal(4), ConvertFunction.transToAmount("0000D"));
	}
}
