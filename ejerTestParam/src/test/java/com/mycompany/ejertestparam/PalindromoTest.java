package com.mycompany.ejertestparam;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PalindromoTest {

	private String cadena;
	private boolean esperado;
	Palindromo palindromo;

	@Before
	public void setUp() throws Exception {
		palindromo = new Palindromo();
	}

	public PalindromoTest(String cadena, boolean esperado) {
		super();
		this.cadena = cadena;
		this.esperado = esperado;
	}

	@Parameters
	public static Collection<Object[]> datos() {
		return Arrays.asList(new Object[][] { { "hola", false }, { "ana", true }, { "Arepera", true },
				{ "rapido", false }, { "Arenera", true }, { "Rotomotor", true } });
	}

	@Test
	public void testBuscaPalindromo() {
		// when
		boolean resultado = palindromo.buscaPalindromo(cadena);
		System.out.println("La cadena es: " + cadena + " resutaldo: " + resultado);
		// then
		assertEquals(esperado, resultado);
	}

}
