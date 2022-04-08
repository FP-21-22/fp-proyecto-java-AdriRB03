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
		String[] aux = text.split(";");
		//
		String id = aux[0].trim();
		String genero = aux[1].trim();
		Double edad = Double.parseDouble(aux[2].trim());
		Boolean hipertension = Boolean.parseBoolean(aux[3].trim());
		Boolean enfermedadDelCorazon = Boolean.parseBoolean(aux[4].trim());
		TipoResidencia tipoDeResidencia = TipoResidencia.valueOf(aux[5].trim().toUpperCase());
		Double nivelMedioDeGlucosa = Double.parseDouble(aux[6].trim());
		
		
		PacienteEstudio res= PacienteEstudio.of(id, genero, edad, hipertension, enfermedadDelCorazon, tipoDeResidencia, nivelMedioDeGlucosa);
		return res;
	}
	
	public Boolean factorDeRiesgo() {
		if(hipertension==true && edad>=40.) {
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {		

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
		PacienteEstudio p2 = PacienteEstudio.parse("6306;Male;80.;false;false;URBANA;83.84");
		System.out.println(p2);
	}
}
