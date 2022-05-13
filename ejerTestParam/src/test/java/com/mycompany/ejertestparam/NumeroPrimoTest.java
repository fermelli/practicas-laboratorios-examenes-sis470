package com.mycompany.ejertestparam;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NumeroPrimoTest {
	
	@Parameters
	public static List<Object> datos() {
		return Arrays.asList(new Object[][] {
			{5, true}, {9, false}, {11, true}, {15, false}
		});
	}
	
	@Parameter(0)
	public int numero;
	@Parameter(1)
	public boolean esperado;
	
	NumeroPrimo numeroPrimo = new NumeroPrimo();

	@Test
	public void testValidate() {
		System.out.println("EL valor esperado para: " + numero + " es: " + esperado);
		// then
		assertEquals(esperado, numeroPrimo.validate(numero));
	}

}
