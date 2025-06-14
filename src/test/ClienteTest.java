package test;

import java.util.List;
import datos.Cliente;
import negocio.ClienteABM;

public class ClienteTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Cliente c= ClienteABM.getInstance().traer(1001);
			System.out.println(c);
			
			/*List<Cliente> lista = ClienteABM.getInstance().traer();
			
			 for (Cliente u : lista) {
			        System.out.println(u);
			    }*/
			
			//System.out.println(c.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
