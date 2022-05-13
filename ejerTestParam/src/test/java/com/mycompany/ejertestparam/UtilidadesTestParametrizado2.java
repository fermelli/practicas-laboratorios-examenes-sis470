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
public class UtilidadesTestParametrizado2 {
	
	@Parameters
	public static List<Object> datos() {
		return Arrays.asList(new Object[][] {
			{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", null}
		});
	}
	
	@Parameter(0)
	public String valor1;
	@Parameter(1)
	public String valor2;
	@Parameter(2)
	public String valor3;
	
	Utilidades utilidades = new Utilidades();

	@Test
	public void testConcatenar() {
		// then
		String resultado = null;
		if(valor1 != null && valor2 != null && valor3 != null) {
			resultado = valor1 + " " + valor2 + " " + valor3;
		}
		assertEquals(resultado, utilidades.concatenar(valor1, valor2, valor3));
	}

}
