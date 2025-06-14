package com.grupo25.test;

import com.grupo25.datos.Cliente;
import com.grupo25.datos.Tecnico;
import com.grupo25.datos.Usuario;
import com.grupo25.negocio.UsuarioABM;

public class TestUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Usuario c = UsuarioABM.getInstance().traer(1);
			if(c instanceof Tecnico) {
				System.out.println("Es Tecnico" + c.toString());
			} else {
				System.out.println("Nono");
			}
			
			//System.out.println(c.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
