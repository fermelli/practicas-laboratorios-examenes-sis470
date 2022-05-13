package com.mycompany.ejertestparam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class UtilidadesTestParametrizado3 {
	
	Utilidades utilidades = new Utilidades();

	@Test
	@junitparams.Parameters({"1,3","5,7","3,-3","11,-100"})
	public void testSumaNumeros(int x, int y) {
		// when
		System.out.println("Los parametros son: v1: " + x + " v2: " + y);
		int resultado = utilidades.sumaNumeros(x, y);
		assertEquals(x + y, resultado);
	}

}
