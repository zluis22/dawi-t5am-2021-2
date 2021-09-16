package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {

	public static void main(String[] args) {
		// obtener la conexion a la BD --> según la unidad de persistencia de archivo xml |DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// crea los DAO usango la fabrica
		EntityManager em = fabrica.createEntityManager();
		
		// proceso ... eliminar un usuario
		Usuario u = new Usuario();
		u.setCodigo(20);

		// para regis. act. eli. --> transacciones
		em.getTransaction().begin();
		em.remove(u); //  metodo para eliminar (borrar de la tabla) / cambiar un estado
		em.getTransaction().commit(); // para confirmar registro
		System.out.println("Elimación OK");
		em.close();
			
	}
	
}
