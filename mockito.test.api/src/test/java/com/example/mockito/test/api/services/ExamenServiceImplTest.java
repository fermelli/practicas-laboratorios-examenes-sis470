package com.example.mockito.test.api.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyLong;

import java.util.Collections;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.mockito.test.api.models.Examen;
import com.example.mockito.test.api.repositories.ExamenRepository;
import com.example.mockito.test.api.repositories.PreguntaRepository;

@RunWith(MockitoJUnitRunner.class)
public class ExamenServiceImplTest {
	@Mock
	private ExamenRepository examenRepository;

	@Mock
	private PreguntaRepository preguntaRepository;
	@InjectMocks
	private ExamenServiceImpl examenServiceImpl;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindExamenPorNombre() {
		Mockito.when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);
		String nombreExamen = "Matematicas";
		Optional<Examen> examen = examenServiceImpl.findExamenPorNombre(nombreExamen);
		assertTrue(examen.isPresent());
		assertEquals(nombreExamen, examen.get().getNombre());
	}

	@Test
	public void testFindExamenPorNombreConPreguntas() {
		Mockito.when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);
		Mockito.when(preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
		String nombreExamen = "Matematicas";
		Examen examen = examenServiceImpl.findExamenPorNombreConPreguntas(nombreExamen);
		assertEquals(5, examen.getPreguntas().size());
		assertTrue(examen.getPreguntas().contains("Derivadas"));
	}

	@Test
	public void testFindExamenPorNombreConPreguntasParaExamenQueNoExiste() {
		Mockito.when(examenRepository.findAll()).thenReturn(Collections.emptyList());
		Mockito.when(preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
		String nombreExamen = "Matematicas";
		Examen examen = examenServiceImpl.findExamenPorNombreConPreguntas(nombreExamen);
		assertNull(examen);
		Mockito.verify(examenRepository).findAll();
	}

	@Test
	public void testGuardar() {
		Mockito.when(examenRepository.guardar(any(Examen.class))).thenReturn(Datos.EXAMEN);
		Examen examen = examenServiceImpl.guardar(Datos.EXAMEN);
		assertNotNull(examen.getId());
		assertEquals(4L, examen.getId().longValue());
		assertEquals("Ciencias Naturales", examen.getNombre());
		Mockito.verify(examenRepository).guardar(any(Examen.class));
	}

	@Test
	public void testGuardarConVariasPreguntas() {
		Examen newExamen = Datos.EXAMEN;
		newExamen.setPreguntas(Datos.PREGUNTAS);
		Mockito.when(examenRepository.guardar(any(Examen.class))).thenReturn(Datos.EXAMEN);
		Examen examen = examenServiceImpl.guardar(Datos.EXAMEN);
		assertNotNull(examen.getId());
		assertEquals(4L, examen.getId().longValue());
		assertEquals("Ciencias Naturales", examen.getNombre());
		Mockito.verify(examenRepository).guardar(any(Examen.class));
		Mockito.verify(preguntaRepository).guardarVarias(anyList());
	}

}
