package test;

import datos.Comentario;
import negocio.ComentarioABM;

public class ComentarioTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Comentario com = ComentarioABM.getInstance().traer(1);
		System.out.println(com);
		
		
	}

}
