package com.mycompany.ejertestparam;

import java.util.List;
import org.assertj.core.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TrianguloTest {

	@Parameterized.Parameters
	public static List<Object> datos() {
		return Arrays.asList(new Object[][] { { 1, 1, 1 }, { 1, 1, 2 }, { 1, 1, 3 }, { 1, 2, 1 }, { 1, 2, 2 },
				{ 1, 2, 3 }, { 1, 3, 1 }, { 1, 3, 2 }, { 1, 3, 3 }, { 2, 1, 1 }, { 2, 1, 2 }, { 2, 1, 3 }, { 2, 2, 1 },
				{ 2, 2, 2 }, { 2, 2, 3 }, { 2, 3, 1 }, { 2, 3, 2 }, { 2, 3, 3 }, { 3, 1, 1 }, { 3, 1, 2 }, { 3, 1, 3 },
				{ 3, 2, 1 }, { 3, 2, 2 }, { 3, 2, 3 }, { 3, 3, 1 }, { 3, 3, 2 }, { 3, 3, 3 } });
	}

	@Parameterized.Parameter(0)
	public int valor1;
	@Parameterized.Parameter(1)
	public int valor2;
	@Parameterized.Parameter(2)
	public int valor3;

	Triangulo utils = new Triangulo();

	@Test
	public void testTipoTriangulo() {
		String esperado1 = "Equilatero";
		String esperado2 = "Isoceles";
		String esperado3 = "Escaleno";
		// System.out.println("los parametros son: l1=" + valor1 + " l2=" + valor2 + "
		// l3=" + valor3);
		String resultado = utils.tipoTriangulo(valor1, valor2, valor3);
		if (valor1 == valor2 && valor2 == valor3) {
			// resultado = "Equilatero";
			assertEquals(esperado1, resultado);
		} else if (valor1 == valor2 || valor1 == valor3 || valor2 == valor3) {
			// resultado = "Isoceles";
			assertEquals(esperado2, resultado);
		} else {
			// resultado = "Escaleno";
			assertEquals(esperado3, resultado);
			System.out.println("los parametros son: l1=" + valor1 + " l2=" + valor2 + " l3=" + valor3);
			System.out.println(resultado);
		}

	}

}
