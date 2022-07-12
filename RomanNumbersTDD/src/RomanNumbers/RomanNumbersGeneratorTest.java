package RomanNumbers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RomanNumbersGeneratorTest {

	@Test
	public void testPassInvalidArgument() {
		RomanNumbers romanNumbers = new RomanNumbers();
		int number = 0;
		try {
			romanNumbers.generate(number);
		} catch (Exception e) {
			assertEquals("No se puede obtener numero romano de " + number, e.getMessage());
		}
	}
	
	@Test
	public void testGeneratesRomanNumeralsBetween1And10() {
		RomanNumbers romanNumbers = new RomanNumbers();
		String result = romanNumbers.generate(10);
		assertEquals("X", result);
	}
	
	@Test
	public void testGeneratesRomanNumeralsBetween11And39() {
		RomanNumbers romanNumbers = new RomanNumbers();
		String result = romanNumbers.generate(39);
		assertEquals("XXXIX", result);
	}
	
	@Test
	public void testGeneratesRomanNumeralsBetween40And49() {
		RomanNumbers romanNumbers = new RomanNumbers();
		String result = romanNumbers.generate(49);
		assertEquals("XLIX", result);
	}
	
	@Test
	public void testGeneratesRomanNumeralsBetween50And89() {
		RomanNumbers romanNumbers = new RomanNumbers();
		String result = romanNumbers.generate(89);
		assertEquals("LXXXIX", result);
	}
	
	@Test
	public void testGeneratesRomanNumeralsBetween90And99() {
		RomanNumbers romanNumbers = new RomanNumbers();
		String result = romanNumbers.generate(99);
		assertEquals("XCIX", result);
	}
	
	@Test
	public void testGeneratesRomanNumeralsBetween100And189() {
		RomanNumbers romanNumbers = new RomanNumbers();
		String result = romanNumbers.generate(189);
		assertEquals("CLXXXIX", result);
	}
	
	@Test
	public void testGeneratesRomanNumerals200() {
		RomanNumbers romanNumbers = new RomanNumbers();
		String result = romanNumbers.generate(200);
		assertEquals("CC", result);
	}
}
