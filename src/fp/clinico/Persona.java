package fp.clinico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import fp.utiles.Checkers;

public record Persona(String nombre, String apellidos, String dni, LocalDateTime fechaNacimiento) {
	
		
	public static Persona of(String nombre, String apellidos,String dni,LocalDateTime fechaNacimiento) {
		
		//Restricciones
		Checkers.check("La fecha de nacimiento debe ser anterior a la fecha actual.", fechaNacimiento.isBefore(LocalDateTime.now()));
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

	//"Antonio","Ramirez","49241444Ñ",LocalDateTime.of(1980,Month.APRIL,16,14,20
	public static Persona parse(String text) {
		String[] partes = text.split(",");
		String nc = partes[0];
		String [] partes_nc = nc.split(" "); 
		LocalDate ld = LocalDate.parse(partes[1], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		LocalTime lt = LocalTime.parse(partes[2], DateTimeFormatter.ofPattern("HH:mm"));
		return Persona.of(partes_nc[0], partes_nc[1], "49289154Ñ", LocalDateTime.of(ld,lt));//PREGUNTAR DNI
	}
	
	public Integer edad() {	
		LocalDateTime now = LocalDateTime.now();
		Period p = Period.between(fechaNacimiento.toLocalDate(),now.toLocalDate());
		return  p.getYears();
	}
	
	public String nombre_completo() {
		return String.format("%s %s",this.nombre(),this.apellidos());
	}
	
	public String toString() {//PREGUNTAR		
		String fecha = fechaNacimiento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		String hora = fechaNacimiento().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
		return String.format("%s, de %d, nacido el %s a las %s",nombre_completo(),edad(),fecha,hora);
	}
	
	public int compareTo(Persona p) {
		int res= this.dni.compareTo(p.dni);
		return res;
	}
	


	public static void main(String[] args) {
		Locale.setDefault(new Locale("es", "Es"));
		Persona p = Persona.of("Antonio","Ramirez","49241444Ñ",LocalDateTime.of(1980,Month.APRIL,16,14,20));
		Persona p2 = Persona.parse("Juan Balmez,18-03-2010,02:31,23");
		System.out.println(p);
		System.out.println(p.edad());
		System.out.println(p2);
		System.out.println(p2.edad());
		System.out.println(p.compareTo(p2));
	}
	
	
}


