package fp.farmaceutico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

 
public class FactoriaMedicamentos2  {
	public static List<Medicamento> leeFichero(String nombreFichero) {
		// TODO Auto-generated method stub
		List<Medicamento> res = new ArrayList<Medicamento>();		
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
				FactoriaMedicamentos m = FactoriaMedicamentos.parseaMedicamento(e);
				res.add(m);
			}
			cont++;
		}		
		return res;		
}
	

}
