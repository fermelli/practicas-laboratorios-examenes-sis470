package com.example.mockito.test.api.services;

import java.util.Arrays;
import java.util.List;

import com.example.mockito.test.api.models.Examen;

public class Datos {

	public final static List<Examen> EXAMENES = Arrays.asList(new Examen(1L, "Matematicas"), new Examen(2L, "Lenguaje"),
			new Examen(3L, "Historia"));

	public final static List<String> PREGUNTAS = Arrays.asList("Aritmetica", "Integrales", "Derivadas", "Trigonometria",
			"Razones y proporciones");

	public final static Examen EXAMEN = new Examen(4L, "Ciencias Naturales");

}
