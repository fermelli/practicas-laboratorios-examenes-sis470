package com.example.mockito.test.api.services;

import java.util.Optional;

import com.example.mockito.test.api.models.Examen;

public interface ExamenService {
	Optional<Examen> findExamenPorNombre(String nombre);

	Examen findExamenPorNombreConPreguntas(String nombre);

	Examen guardar(Examen examen);
}
