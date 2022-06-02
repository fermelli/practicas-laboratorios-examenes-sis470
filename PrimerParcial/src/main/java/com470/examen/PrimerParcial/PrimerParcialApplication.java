package com470.examen.PrimerParcial;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com470.examen.PrimerParcial.service.NumeroComplejo;

@SpringBootApplication
public class PrimerParcialApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimerParcialApplication.class, args);
		Scanner teclado = new Scanner(System.in);
		int opcion;
		while (true) {
			System.out.println("Menu");
			System.out.println("1. Sumar Complejos");
			System.out.println("2. Restar Complejos");
			System.out.println("3. Salir");
			System.out.print("Ingrese una opción: ");
			opcion = teclado.nextInt();
			if (opcion == 3) {
				System.out.print("Saliendo...");
				break;
			}
			System.out.print("Ingrese primer real (entero): ");
			int real1 = teclado.nextInt();
			System.out.print("Ingrese primer imaginario (entero): ");
			int imaginaria1 = teclado.nextInt();
			System.out.print("Ingrese segundo real (entero): ");
			int real2 = teclado.nextInt();
			System.out.print("Ingrese segundo imaginario (entero): ");
			int imaginaria2 = teclado.nextInt();
			NumeroComplejo numeroComplejo1 = new NumeroComplejo(real1, imaginaria1);
			NumeroComplejo numeroComplejo2 = new NumeroComplejo(real2, imaginaria2);

			NumeroComplejo resultado = null;

			if (opcion == 1) {
				resultado = numeroComplejo1.sumar(numeroComplejo2);
				System.out.print("Suma: ");
			} else if (opcion == 2) {
				resultado = numeroComplejo1.restar(numeroComplejo2);
				System.out.print("Resta: ");
			} else {
				System.out.println("Opción no válida");
			}

			if (resultado != null) {
				System.out.println("" + resultado.getParteReal()
						+ ((resultado.getParteImaginaria() >= 0) ? ("+" + resultado.getParteImaginaria())
								: resultado.getParteImaginaria()) + "i");
			}
		}
	}

}
