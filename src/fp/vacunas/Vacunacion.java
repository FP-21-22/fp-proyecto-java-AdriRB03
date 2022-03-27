package fp.vacunas;

import java.time.LocalDate;

import fp.utiles.Checkers;

public record Vacunacion(LocalDate fecha, String comunidad, Integer pfizer, Integer moderna, Integer astrazeneca, Integer janssen, Integer numeroDePersonas) {

	public static Vacunacion of(LocalDate fecha, String comunidad, Integer pfizer, Integer moderna, Integer astrazeneca, Integer janssen, Integer numeroDePersonas) {
		//RESTRICCIONES
		Checkers.check("La fecha de debe ser posterior al 01/02/2021.", fecha.isBefore(LocalDate.of(2021, 02, 01)));
		
		//
		return new Vacunacion( fecha, comunidad, pfizer, moderna, astrazeneca, janssen, numeroDePersonas); 
	}
	
	//"“04/01/2021;Andalucía;140295;0;0;0;0"
	public static Vacunacion parse(String text) {
//		String[] partes = text.split(",");
//		String nc = partes[0];
//		String [] partes_nc = nc.split(" ");
//		LocalDate ld = LocalDate.parse(partes[1], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//		return Vacunacion.of(ld, partes_nc[0], Integer.parseInt(text), Integer.parseInt(text), Integer.parseInt(text), Integer.parseInt(text), Integer.parseInt(text));
		return null;////He intentado hacer el parse pero me sale eror por eso esta comentado.
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
		Vacunacion v = Vacunacion.of(LocalDate.of(2015, 6, 24), "Murcia", 2, 3, 6, 1, 4);
		Vacunacion v2 = Vacunacion.parse("04/01/2021;Andalucía;140295;0;0;0;0");
		System.out.println(v);
		System.out.println(v2);
	}
	
}
