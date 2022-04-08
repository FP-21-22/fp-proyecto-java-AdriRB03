package fp.farmaceutico.test;

import java.time.LocalDate;

import fp.farmaceutico.FactoriaMedicamentos;
import fp.farmaceutico.Medicamento;
import fp.farmaceutico.TipoMedicamento;

public class TestFactoriaMedicamentos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactoriaMedicamentos m = FactoriaMedicamentos.parseaMedicamento("efavirenz,Anatomico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019");
		System.out.println(m);
	}

}
