package com.mycompany.ejertestparam;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class CalculadoraTest {

	Calculadora calculadora;
	
	@Before
	public void setUp() throws Exception {
		calculadora = new Calculadora();
	}

	@Test
	@junitparams.Parameters({"1,3","5,7","3,-3","11,-100"})
	public void testSuma(int a, int b) {
		System.out.println("(suma) Los parametros son: a: " + a + " b: " + b);
		int resultado = calculadora.suma(a, b);
		assertEquals(a + b, resultado);
	}

	@Test
	@junitparams.Parameters({"3,3","88,33","11,-10","-11,-1", "0,0"})
	public void testResta(int a, int b) {
		System.out.println("(resta) Los parametros son: a: " + a + " b: " + b);
		int resultado = calculadora.resta(a, b);
		assertEquals(a - b, resultado);
	}

	@Test
	@junitparams.Parameters({"7,11","3,1","0,0","-2,-1", "3,0"})
	public void testMultimplicacion(int a, int b) {
		System.out.println("(multiplicación) Los parametros son: a: " + a + " b: " + b);
		int resultado = calculadora.multimplicacion(a, b);
		assertEquals(a * b, resultado);
	}

	@Test
	@junitparams.Parameters({"3,6","1,33","5,0","-4,-1", "0,0"})
	public void testDivision(int a, int b) {
		System.out.println("(división) Los parametros son: a: " + a + " b: " + b);
		try {
			int resultado = calculadora.division(a, b);
			assertEquals(a / b, resultado);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertEquals("No se puede dividir entre 0", e.getMessage());
		}
		
		
	}

}
