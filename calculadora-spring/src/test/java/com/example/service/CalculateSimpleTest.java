package com.example.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.example.model.OperationModel;

public class CalculateSimpleTest {

	CalculateSimple calculator;

	@Before
	public void setUp() throws Exception {
		calculator = new CalculateSimple();
	}

	@Test
	public void testAdd() {
		OperationModel operationModel = new OperationModel(5, 4);
		int expectResult = 9;
		int result = calculator.add(operationModel);
		assertEquals(expectResult, result);
	}

	@Test
	public void testSubtract() {
		OperationModel operationModel = new OperationModel(2, -9);
		int expectResult = 11;
		int result = calculator.subtract(operationModel);
		assertEquals(expectResult, result);
	}

	@Test
	public void testMultiply() {
		OperationModel operationModel = new OperationModel(3, 3);
		int expectResult = 9;
		int result = calculator.multiply(operationModel);
		assertEquals(expectResult, result);
	}

	@Test
	public void testDivide() {
		OperationModel operationModel = new OperationModel(30, 10);
		double expectResult = 3.0;
		double result = calculator.divide(operationModel);
		assertEquals(expectResult, result, 0.001);
	}
	
	@Test
	public void testDivideDividendo0() {
		OperationModel operationModel = new OperationModel(0, 10);
		double expectResult = 0;
		double result = calculator.divide(operationModel);
		assertEquals(expectResult, result, 0.001);
	}
	
	@Test
	public void testDivideDivisor0() {
		OperationModel operationModel = new OperationModel(10, 0);
		double expectResult = 0;
		double result = calculator.divide(operationModel);
		assertEquals(expectResult, result, 0.001);
	}

	@Test
	public void testFactorialOperationModel() {
		OperationModel operationModel = new OperationModel(5);
		int expectResult = 120;
		int result = calculator.factorial(operationModel);
		assertEquals(expectResult, result);
	}

	@Test
	public void testFibonacciOperationModel0() {
		OperationModel operationModel = new OperationModel(0);
		int expectResult = 0;
		int result = calculator.fibonacci(operationModel);
		assertEquals(expectResult, result);
	}
	
	@Test
	public void testFibonacciOperationModel() {
		OperationModel operationModel = new OperationModel(7);
		int expectResult = 13;
		int result = calculator.fibonacci(operationModel);
		assertEquals(expectResult, result);
	}

	@Test
	public void testSqrt() {
		OperationModel operationModel = new OperationModel(100);
		double expectResult = 10;
		double result = calculator.sqrt(operationModel);
		assertEquals(expectResult, result, 0.001);
	}

	@Test
	public void testPower() {
		OperationModel operationModel = new OperationModel(4);
		double expectResult = 16;
		double result = calculator.power(operationModel);
		assertEquals(expectResult, result, 0.001);
	}

	@Test
	public void testClearSimple() {
		OperationModel operationModel = new OperationModel(10, 10);
		int expectResult = 0;
		calculator.clearSimple(operationModel);
		assertEquals(expectResult, operationModel.getA());
		assertEquals(expectResult, operationModel.getB());
	}

	@Test
	public void testClearAdvanced() {
		OperationModel operationModel = new OperationModel(10);
		int expectResult = 0;
		calculator.clearAdvanced(operationModel);
		assertEquals(expectResult, operationModel.getC());
	}

}
