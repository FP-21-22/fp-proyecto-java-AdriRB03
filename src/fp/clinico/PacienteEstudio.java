package fp.clinico;

import fp.utiles.Checkers;


public record PacienteEstudio(String id, String genero, Double edad, Boolean hipertension, Boolean enfermedadDelCorazon, TipoResidencia tipoDeResidencia, Double nivelMedioDeGlucosa) {
	

	public static PacienteEstudio of(String id, String genero, Double edad, Boolean hipertension, Boolean enfermedadDelCorazon, TipoResidencia tipoDeResidencia, Double nivelMedioDeGlucosa) {
		//RESTRICCIONES
		Checkers.check("La edad tiene que ser mayor o igual que cero y menor o igual que 130", edad>=0 && edad <=130);
		Checkers.check("El nivel medio de glucosa tiene que ser mayor o igual que cero.", nivelMedioDeGlucosa>=0);
		
		//
		
		return new PacienteEstudio(id,genero,edad,hipertension,enfermedadDelCorazon,tipoDeResidencia,nivelMedioDeGlucosa);
	}
	//"6306;Male;80;false;false;URBANA;83.84"
	public static PacienteEstudio parse(String text) {
//		String[] partes = text.split(",");
//		String nc = partes[0];
//		String [] partes_nc = nc.split(" "); 
//		String t = text.substring(1, text.length()-1);
//		String[] parte = t.split(",");
//		return PacienteEstudio.of(partes_nc[0], partes_nc[1], Double.parseDouble(parte[0]), Boolean.parseBoolean(parte[3]), Boolean.parseBoolean(parte[4]), TipoResidencia.RURAL, Double.parseDouble(parte[1]));
	return null;//He intentado hacer el parse pero me sale eror por eso esta comentado.
	}
	
	public Boolean factorDeRiesgo() {
		if(hipertension==true && edad>=40.) {
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {//PREGUNTAR		

		return String.format("%s es el id de la persona con %f años.",id,edad);
	}
	
	public int compareTo(PacienteEstudio p) {
		int res= this.edad.compareTo(p.edad);
		if(res==0) {
			res= this.id.compareTo(p.id);
			
		}
		return res;
	}
	
	public static void main(String[] args) {
		PacienteEstudio p = PacienteEstudio.of("1532", "Male", 110., true, false, TipoResidencia.URBANA,230.);
		PacienteEstudio p2 = PacienteEstudio.parse("6306;Male;80.;false;false;URBANA;83.84");
		System.out.println(p);
		System.out.println(p.factorDeRiesgo());
		System.out.println(p.toString());
		System.out.println(p2);
	}
}
