package com.mycompany.ejertestparam;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FibonacciTest {

	private int lim;
	private String serie;
	Fibonacci fibo = new Fibonacci();

	public FibonacciTest(int lim, String serie) {
		super();
		this.lim = lim;
		this.serie = serie;
	}
	
	@Parameters
	public static Collection<Object[]> datos() {
		return Arrays.asList(new Object[][] { { 1, "0,1,1" }, { 5, "0,1,1,2,3,5" }, { 3, "0,1,1,2,3" } });
	}

	@Test
	public void testBibonacci() {
		// when
		String serieResultante = fibo.bibonacci(lim); 
		System.out.println("El limite es: " + lim + " serie: " + serie);
		// then
		assertEquals(serie, serieResultante);
	}

}
