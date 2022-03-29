package fp.farmaceutico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class FactoriaMedicamentos extends Medicamento {
	


	

	public FactoriaMedicamentos(String nombreDelMedicamento, TipoMedicamento tipoMedicamento,
			String codigoDeLaEnfermedad, String farmaceutica, Double puntuacion, Integer indiceSomatico,
			LocalDate fechaDeCatalogo) {
		super(nombreDelMedicamento, tipoMedicamento, codigoDeLaEnfermedad, farmaceutica, puntuacion, indiceSomatico,
				fechaDeCatalogo);
		// TODO Auto-generated constructor stub
	}

	public static FactoriaMedicamentos parseaMedicamento(String text) {
		  //“efavirenz,Anatomico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019”
	String[] aux = text.split(",");
	//
	String nombreDelMedicamento = aux[0].trim();
	TipoMedicamento tipoMedicamento= TipoMedicamento.valueOf(aux[1].trim().toUpperCase());
	String codigoDeLaEnfermedad = aux[2].trim();
	String farmaceutica = aux[3].trim();
	Double puntuacion= Double.parseDouble(aux[4].trim());
	Integer indiceSomatico= Integer.parseInt(aux[5].trim());
	LocalDate fechaDeCatalogo = LocalDate.parse(aux[6].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
			FactoriaMedicamentos res = new FactoriaMedicamentos( nombreDelMedicamento,  tipoMedicamento,codigoDeLaEnfermedad,  farmaceutica,
					 puntuacion,  indiceSomatico,  fechaDeCatalogo);
			return res;
		  
	  }


	
	
		
			//“efavirenz,Anatomico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019”
}
	
	
