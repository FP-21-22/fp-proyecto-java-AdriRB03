package fp.clinico;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstudioClinicoBucles implements EstudioClinico {
	
	private List<PacienteEstudio> paciente1;

	
	public EstudioClinicoBucles() {
		paciente1 = new ArrayList<PacienteEstudio>();
	}
	
	public EstudioClinicoBucles(List<PacienteEstudio> paciente1) {
		this.paciente1 = new ArrayList<PacienteEstudio>(paciente1);
	}
	
	
	
	@Override
	public Integer numeroPacientes() {
		return paciente1.size();
	}

	@Override
	public void incluyePaciente(PacienteEstudio paciente) {
		this.paciente1.add(paciente);

	}

	@Override
	public void incluyePacientes(Collection<PacienteEstudio> pacientes) {
		this.paciente1.addAll(pacientes);

	}

	@Override
	public void eliminaPaciente(PacienteEstudio paciente) {
		this.paciente1.remove(paciente);

	}

	@Override
	public Boolean estaPaciente(PacienteEstudio paciente) {
		return paciente1.contains(paciente);
	}

	@Override
	public void borraEstudio() {
		this.paciente1.clear();

	}

	@Override
	public EstudioClinico of(String nombreFichero) {
		List<PacienteEstudio> aux = leeFichero(nombreFichero);
		EstudioClinico est = new EstudioClinicoBucles(aux);
		return est;
	}
	

	@Override
	public List<PacienteEstudio> leeFichero(String nombreFichero) {
		List<PacienteEstudio> res = new ArrayList<PacienteEstudio>();		
		List<String> aux = null;
		try {
			aux = Files.readAllLines(Paths.get(nombreFichero));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Hay que saltarse la primera línea
		int cont = 0;
		for(String e:aux) {
			if(cont>0) {
				PacienteEstudio p = PacienteEstudio.parse(e);
				res.add(p);
			}
			cont++;
		}		
		return res;	
	}

	
	@Override//
	public Boolean todosPacienteSonDelTipo(TipoResidencia tipo) {
		Boolean res = true;
		for(PacienteEstudio p:this.paciente1) {
			if(p.equals(tipo)) {
				res = true;
			}else {
				res = false;
			}
		}
		return res;
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		return paciente1.contains(tipo);
	}

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		Integer res = 0;

		for(PacienteEstudio p:this.paciente1) {
			if(p.factorDeRiesgo()) {
				res++;
				
			}
		}
		return res;
	}
    

	
	@Override//
	public Double edadMediaPacientesConFactorRiesgo() {
		Double edadMedia=0.0;
		Double sumaEdadesFactorDeRiesgo= 0.0;
		
		for(PacienteEstudio p:this.paciente1) {
			if(p.factorDeRiesgo()) {
				sumaEdadesFactorDeRiesgo += p.edad();	
				edadMedia = sumaEdadesFactorDeRiesgo/numeroPacientesFactorRiesgo();
				
			}
			
		}
		
		return edadMedia;
	}

	@Override//
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		List<PacienteEstudio> res = new ArrayList<PacienteEstudio>();
		for(PacienteEstudio e:this.paciente1) {
			if(e.edad().equals(edad)) {
				res.add(e);
				
			}
				
			
		}
		return res;
	}

	@Override//
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override//
	public Map<String, Long> numeroPacientesPorGenero() {
		// TODO Auto-generated method stub
		Map<String, Long> res = new HashMap<>();
		for(PacienteEstudio e:this.paciente1) {
			String key = e.genero();
			if(res.containsKey(key)) {
				res.put(key, res.get(key)+1);
				
			}else {
				res.put(key, (long) 1);
				
			}
			break;
				
		}
		return res;
	}

	@Override//
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}
}
