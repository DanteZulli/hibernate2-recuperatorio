package test;

import java.util.List;

import datos.Tecnico;
import negocio.TecnicoABM;

public class TecnicoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*// Usuario 1 y 2 son Tecnicos
		Tecnico tec = TecnicoABM.getInstance().traer(1);
		System.out.println(tec);*/
		
		//Traigo lista de todos los Tecnicos
		List<Tecnico> lista = TecnicoABM.getInstance().traer();
		 for (Tecnico u : lista) {
		        System.out.println(u);
		    }
		
		
	}

}
