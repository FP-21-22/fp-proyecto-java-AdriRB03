package fp.vacunas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public record Vacunacion(LocalDate fecha, String comunidad, Integer pfizer, Integer moderna, Integer astrazeneca, Integer janssen, Integer numeroDePersonas) {

	public static Vacunacion of(LocalDate fecha, String comunidad, Integer pfizer, Integer moderna, Integer astrazeneca, Integer janssen, Integer numeroDePersonas) {
		//RESTRICCIONES
		Checkers.check("La fecha de debe ser posterior al 01/02/2021.", fecha.isBefore(LocalDate.of(2021, 02, 01)));
		
		//
		return new Vacunacion( fecha, comunidad, pfizer, moderna, astrazeneca, janssen, numeroDePersonas); 
	}
	
	public static Vacunacion parse(String text) {
		//"04/01/2021;Andalucía;140295;0;0;0;0"
		String[] aux = text.split(";");
		//
		
		LocalDate fecha = LocalDate.parse(aux[0].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String comunidad = aux[1].trim();
		Integer pfizer= Integer.parseInt(aux[2].trim());
		Integer moderna= Integer.parseInt(aux[3].trim());
		Integer astrazeneca= Integer.parseInt(aux[4].trim());
		Integer janssen= Integer.parseInt(aux[5].trim());
		Integer numeroDePersonas= Integer.parseInt(aux[6].trim());
		Vacunacion res= Vacunacion.of(fecha, comunidad, pfizer, moderna, astrazeneca, janssen, numeroDePersonas);
		return res;

	}
	
	public Integer numeroTotal() {
		int suma=this.pfizer+this.janssen+this.astrazeneca+this.moderna ;
		return suma;
	}
	
	public int compareTo(Vacunacion v) {
		int res= this.comunidad.compareTo(v.comunidad);
		if(res==0) {
			res= this.fecha.compareTo(v.fecha);
			
		}
		return res;
	}
	
	public static void main(String[] args) {
		Vacunacion v2 = Vacunacion.parse("04/01/2021;Andalucía;140295;0;0;0;0");
		System.out.println(v2);
	}
	
}
