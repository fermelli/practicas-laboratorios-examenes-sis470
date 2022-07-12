package com.example.mockito.test.api.repositories;

import java.util.List;

import com.example.mockito.test.api.models.Examen;

public interface ExamenRepository {
	Examen guardar(Examen examen);

	List<Examen> findAll();
}
