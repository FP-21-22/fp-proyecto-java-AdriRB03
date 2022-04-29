package fp.clinico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestEstudioClinicoBucles {
	
	public static void main(String[] args) {
		// 
		
		
		String ruta = "data/estudio_clinico.csv";
//		List<PacienteEstudio> lista = new EstudioClinicoBucles.leeFichero(ruta);
//		for(PacienteEstudio e:lista) {
//			System.out.println(e);
//		}
		
		
		EstudioClinico est = new EstudioClinicoBucles();
//		System.out.println(est.incluyePaciente(null));
//		System.out.println(est.incluyePacientes(null));
//		System.out.println(est.eliminaPaciente(null));
//		System.out.println(est.estaPaciente(null));
//		System.out.println(est.borraEstudio());
		System.out.println(est.of(ruta).todosPacienteSonDelTipo(TipoResidencia.URBANA));
		System.out.println(est.of(ruta).existeAlgunPacienteDelTipo(TipoResidencia.RURAL));
		System.out.println(est.of(ruta).numeroPacientesFactorRiesgo());
		System.out.println(est.of(ruta).edadMediaPacientesConFactorRiesgo());
		System.out.println(est.of(ruta).filtraPacientesPorEdad(21.0));
//		System.out.println(est.agruparPacientesEdadMayorQuePorGenero(null));
		System.out.println(est.of(ruta).numeroPacientesPorGenero());
//		System.out.println(est.edadMediaPacientesPorPorGenero());
		
		
	}
	
	public static List<String> leeFichero1(String nombreFichero){
		//		
		List<String> res = null;
		try {
			res = Files.readAllLines(Paths.get(nombreFichero));
		} catch (IOException e) {
			// 
			e.printStackTrace();
		}		
		return res;
	}

}
