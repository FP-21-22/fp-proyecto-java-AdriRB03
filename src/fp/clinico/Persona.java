package fp.clinico;

import java.time.LocalDate;

import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import fp.utiles.Checkers;

public record Persona(String nombre, String apellidos, String dni, LocalDate fechaNacimiento) {
		
	public static Persona of(String nombre, String apellidos,String dni,LocalDate fechaNacimiento) {
		
		//Restricciones
		Checkers.check("La fecha de nacimiento debe ser anterior a la fecha actual.", fechaNacimiento.isBefore(LocalDate.now()));
		Checkers.check("El DNI tiene que ser de tamaño 9", dni.length()==9);
		boolean todosNumeros = true;
		for(int i =0; i<8 ;i++) {
			todosNumeros = Character.isDigit(dni.charAt(i));
			if (!todosNumeros) {
				break;
			}
		}
		Checkers.check("El dni tiene que tener nueve numeros", todosNumeros);
		Checkers.check("El ultimo digito tiene que ser un caracter", Character.isAlphabetic(dni.charAt(8)));
		
		return new Persona(nombre, apellidos, dni, fechaNacimiento);
	}


	public static Persona parse(String text) {
		//“Juan, García Rodríguez, 12755078Z, 20/03/1965”
		String[] aux = text.split(",");
		//
		String nombre = aux[0].trim();
		String apellidos = aux[1].trim();
		String dni = aux[2].trim();
		LocalDate fechaNacimiento = LocalDate.parse(aux[3].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		//
		Persona res = Persona.of(nombre, apellidos, dni, fechaNacimiento);
		return res;
		
	}
	
	public Integer edad() {	
		LocalDate hoy = LocalDate.now();
		Period p = Period.between(fechaNacimiento, hoy);
		return  p.getYears();

	}
	

	public int compareTo(Persona p) {
		int res= this.dni.compareTo(p.dni);
		return res;
	}
	


	public static void main(String[] args) {
		Locale.setDefault(new Locale("es", "Es"));
		Persona p2 = Persona.parse("Juan, García Rodriguez, 49089145L, 20/03/1965");
		System.out.println(p2);
		System.out.println(p2.edad());
	}
	
	
}


