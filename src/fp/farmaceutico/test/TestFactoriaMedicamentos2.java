package fp.farmaceutico.test;

import java.util.List;

import fp.farmaceutico.FactoriaMedicamentos2;
import fp.farmaceutico.Medicamento;


public class TestFactoriaMedicamentos2 {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ruta = "data/medicamentos.csv";
		List<Medicamento> lista = FactoriaMedicamentos2.leeFichero(ruta);
		for(Medicamento e:lista) {
			System.out.println(e);
		}

	}

}
