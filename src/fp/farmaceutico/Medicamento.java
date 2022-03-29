package fp.farmaceutico;

import java.time.LocalDate;
import java.util.Objects;


import fp.utiles.Checkers;

public class Medicamento {
	
	//Propiedades
	private String nombreDelMedicamento;
	private TipoMedicamento tipoMedicamento;
	private String codigoDeLaEnfermedad;
	private String farmaceutica;
	private Double puntuacion;
	private Integer indiceSomatico;
	private LocalDate fechaDeCatalogo;

	//Constructores
	public Medicamento(String nombreDelMedicamento, TipoMedicamento tipoMedicamento,String codigoDeLaEnfermedad, String farmaceutica,
			Double puntuacion, Integer indiceSomatico, LocalDate fechaDeCatalogo) {
		//Restricciones
		Checkers.check("La puntuacion debe de ser mayor que 0", puntuacion>0);
		Checkers.check("El índice somático tiene que ser mayor o igual que 1000", indiceSomatico>=1000);
		Checkers.check("La fecha de catálogo tiene que ser posterior al 01/01/2015.", fechaDeCatalogo.isAfter(LocalDate.of(2015, 01, 01)));
		
		//
		
		this.nombreDelMedicamento = nombreDelMedicamento;
		this.tipoMedicamento = tipoMedicamento;
		this.codigoDeLaEnfermedad = codigoDeLaEnfermedad;
		this.farmaceutica = farmaceutica;
		this.puntuacion = puntuacion;
		this.indiceSomatico = indiceSomatico;
		this.fechaDeCatalogo = fechaDeCatalogo;
	}

	//Metodos de las propiedades
	public String getNombreDelMedicamento() {
		return nombreDelMedicamento;
	}

	public TipoMedicamento getTipoMedicamento() {
		return tipoMedicamento;
	}

	public String getFarmaceutica() {
		return farmaceutica;
	}

	public Double getPuntuacion() {
		return puntuacion;
	}

	public Integer getIndiceSomatico() {
		return indiceSomatico;
	}

	public LocalDate getFechaDeCatalogo() {
		return fechaDeCatalogo;
	}

	public void setFechaDeCatalogo(LocalDate fechaDeCatalogo) {
		this.fechaDeCatalogo = fechaDeCatalogo;
	}
	
	//Metodos adicionales
	//a)Representacion como cadena
	@Override
	public String toString() {
		return "Medicamento [El nombre del medicamento es= " + nombreDelMedicamento + " y la farmaceutica es=" + farmaceutica;
	}

	//b)Criterio de igualdad
	@Override
	public int hashCode() {
		return Objects.hash(farmaceutica, fechaDeCatalogo, indiceSomatico, nombreDelMedicamento, puntuacion,
				tipoMedicamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		return Objects.equals(farmaceutica, other.farmaceutica)
				&& Objects.equals(fechaDeCatalogo, other.fechaDeCatalogo)
				&& Objects.equals(indiceSomatico, other.indiceSomatico)
				&& Objects.equals(nombreDelMedicamento, other.nombreDelMedicamento)
				&& Objects.equals(puntuacion, other.puntuacion) && tipoMedicamento == other.tipoMedicamento;
	}
	
	//c)Criterio de orden
	public int compareTo(Medicamento p) {
		int res= this.getNombreDelMedicamento().compareTo(p.nombreDelMedicamento);
		if(res==0) {
			res= this.getFarmaceutica().compareTo(p.farmaceutica);
			
		}
		return res;

	}


}
