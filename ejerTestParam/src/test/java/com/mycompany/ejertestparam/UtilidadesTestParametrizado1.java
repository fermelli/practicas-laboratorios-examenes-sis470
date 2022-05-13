package com.mycompany.ejertestparam;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class UtilidadesTestParametrizado1 {

	private int v1;
	private int v2;
	Utilidades utilidades = new Utilidades();

	// constructor
	public UtilidadesTestParametrizado1(int v1, int v2) {
		super();
		this.v1 = v1;
		this.v2 = v2;
	}

	@Parameters
	public static Collection<Object[]> datos() {
		return Arrays.asList(new Object[][] { { 1, 2 }, { 2, 5 }, { 3, -4 } });
	}

	@Test
	public void testSumaNumeros() {
		// when
		int resultado = utilidades.sumaNumeros(v1, v2);
		System.out.println("Los valores son: v1: " + v1 + " v2: " + v2 + " resutaldo: " + resultado);
		// then
		assertEquals(v1 + v2, resultado);
	}

}
