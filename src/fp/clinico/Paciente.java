package fp.clinico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import fp.utiles.Checkers;


public record Paciente(Persona persona,String codigoDeIngreso,LocalDateTime fechaYHora) {
	


//	public static Paciente of(String nombre,String apellidos, String dni, LocalDateTime fechaNacimiento, String codigoDeIngreso,LocalDateTime fechaYHora) {
//		//Restricciones
//		
//		//
//		Checkers.check("La fecha y la hora deben de ser anteriores o iguales a la fecha actual", fechaYHora.isBefore(LocalDateTime.now()));
//		
//		return new Paciente(nombre,apellidos,dni,fechaNacimiento,codigoDeIngreso,fechaYHora);//PREGUNTAR
//	}EN ESTE CONSTRUCTOR SALTA UN ERROR PERO NO LOGRO VER DONDE ESTA

	public static Paciente of(Persona persona,String codigoDeIngreso,LocalDateTime fechaYHora) {
		//Restricciones
		
		//
		Checkers.check("La fecha y la hora deben de ser anteriores o iguales a la fecha actual", fechaYHora.isBefore(LocalDateTime.now()));
		
		return new Paciente(persona,codigoDeIngreso,fechaYHora);	
	}
	
	public LocalDate fechaDeIngreso() {
		//TODO
		return null;
	}
	
	public String horaDeIngreso() {
		//TODO
		return null;
	}
	
	public static void main(String[] args) {
		//Paciente p=Paciente.of("Daniel", "Marquez", "49789456Ñ", LocalDateTime.of(2000, Month.MARCH, 2, 17, 30), "547896", LocalDateTime.of(2020, Month.JANUARY, 14, 14, 30));
		Paciente p1= Paciente.of(Persona.of("Alberto", "Marquez", "49258746L", LocalDateTime.of(1980,Month.APRIL,16,14,20)), "2939373", LocalDateTime.of(1990, 4, 21, 12, 30));
		System.out.println(p1);
	}

}

