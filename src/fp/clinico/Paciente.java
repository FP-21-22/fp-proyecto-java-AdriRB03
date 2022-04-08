package fp.clinico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;


public record Paciente(Persona persona,String nombre, String apellidos, String dni, LocalDate fechaNacimiento,String codigoDeIngreso,LocalDateTime fechaYHora) {
	

	public static Paciente of(Persona persona,String codigoDeIngreso,LocalDateTime fechaYHora) {
		//Restricciones
		
		//
		Checkers.check("La fecha y la hora deben de ser anteriores o iguales a la fecha actual", fechaYHora.isBefore(LocalDateTime.now()));
		
		return new Paciente(persona,null,null,null,null,codigoDeIngreso,fechaYHora);	
	}
	
	public static Paciente of(String nombre,String apellidos, String dni, LocalDate fechaNacimiento, String codigoDeIngreso,LocalDateTime fechaYHora) {
		//Restricciones
		
		//
		Checkers.check("La fecha y la hora deben de ser anteriores o iguales a la fecha actual", fechaYHora.isBefore(LocalDateTime.now()));
		
		return new Paciente(null,nombre,apellidos,dni,fechaNacimiento,codigoDeIngreso,fechaYHora);//PREGUNTAR
	}


	
	public DateTimeFormatter fechaDeIngreso() {
		DateTimeFormatter res = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return res;
	}
	
	public DateTimeFormatter horaDeIngreso() {
		DateTimeFormatter res = DateTimeFormatter.ofPattern("HH:mm");
		return res;
		
	}
	
	public static void main(String[] args) {
		Paciente p1= Paciente.of("miguel", "alvarez lopez", "49878745Ñ", LocalDate.of(1945, 5, 4), "154264", LocalDateTime.of(1990, 5, 4, 14, 55));
		System.out.println(p1);
		System.out.println(p1.horaDeIngreso());
		System.out.println(p1.fechaDeIngreso());
	}

}

