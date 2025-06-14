package test;

import datos.Cliente;
import datos.Tecnico;
import datos.Usuario;
import negocio.ClienteABM;
import negocio.UsuarioABM;


public class TestUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Usuario c= UsuarioABM.getInstance().traer(1);
			if(c instanceof Tecnico) {
				System.out.println("Es Tecnico" + c.toString());
			}else {System.out.println("Nono");}
			
			
			
			//System.out.println(c.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
