package com470.examen.PrimerParcial.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NumeroComplejoTest {

	private int real1;
	private int imaginaria1;
	private int real2;
	private int imaginaria2;
	private NumeroComplejo numeroComplejo1;
	private NumeroComplejo numeroComplejo2;

	public NumeroComplejoTest(int real1, int imaginaria1, int real2, int imaginaria2) {
		super();
		this.real1 = real1;
		this.imaginaria1 = imaginaria1;
		this.real2 = real2;
		this.imaginaria2 = imaginaria2;
		this.numeroComplejo1 = new NumeroComplejo(this.real1, this.imaginaria1);
		this.numeroComplejo2 = new NumeroComplejo(this.real2, this.imaginaria2);
	}

	@Parameters
	public static Collection<Object[]> datos() {
		return Arrays.asList(new Object[][] { { 1, 2, 7, 8 }, { 2, 5, 3, 11 }, { 3, -4, 6, 3 }, { 11, 2, 0, 0 },
				{ 100, 8, 4, 4 }, { 3, -3, -11, -1 }, { 0, 3, 10, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 0 }, { 4, 8, -4, -8 },
				{ 1, 1, 1, 1 }, { -3, -2, -10, -20 }, { 6, 3, 2, 3 }, { 1, 2, 3, 4 }, { -3, 3, 1, 1 },
				{ 4, 3, 2, 1 } });
	}

	@Test
	public void testGetParteReal() {
		System.out.println(">> real1: " + this.real1 + " real2: " + this.real2);
		assertEquals(this.real1, numeroComplejo1.getParteReal());
		assertEquals(this.real2, numeroComplejo2.getParteReal());
	}

	@Test
	public void testGetParteImaginaria() {
		System.out.println(">> imaginaria1: " + this.imaginaria1 + " imaginaria2: " + this.imaginaria2);
		assertEquals(this.imaginaria1, numeroComplejo1.getParteImaginaria());
		assertEquals(this.imaginaria2, numeroComplejo2.getParteImaginaria());
	}

	@Test
	public void testSumar() {
		System.out.println("(+) real1: " + this.real1 + " imaginaria1: " + this.imaginaria1 + " real2: " + this.real2
				+ " imaginaria2: " + this.imaginaria2);
		NumeroComplejo resultadoSuma = numeroComplejo1.sumar(numeroComplejo2);
		NumeroComplejo resultadoEsperado = new NumeroComplejo(this.real1 + this.real2,
				this.imaginaria1 + this.imaginaria2);
		assertEquals(resultadoEsperado.getParteReal(), resultadoSuma.getParteReal());
		assertEquals(resultadoEsperado.getParteImaginaria(), resultadoSuma.getParteImaginaria());
	}

	@Test
	public void testRestar() {
		System.out.println("(-) real1: " + this.real1 + " imaginaria1: " + this.imaginaria1 + " real2: " + this.real2
				+ " imaginaria2: " + this.imaginaria2);
		NumeroComplejo resultadoSuma = numeroComplejo1.restar(numeroComplejo2);
		NumeroComplejo resultadoEsperado = new NumeroComplejo(this.real1 - this.real2,
				this.imaginaria1 - this.imaginaria2);
		assertEquals(resultadoEsperado.getParteReal(), resultadoSuma.getParteReal());
		assertEquals(resultadoEsperado.getParteImaginaria(), resultadoSuma.getParteImaginaria());
	}

}
