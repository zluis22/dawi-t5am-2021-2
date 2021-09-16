package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {

	public static void main(String[] args) {
		// obtener la conexion a la BD --> según la unidad de persistencia de archivo xml |DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// crea los DAO usango la fabrica
		EntityManager em = fabrica.createEntityManager();
		
		// proceso ... obtener / buscar un usuario
		Usuario u = em.find(Usuario.class, 20); // devuelve un objeto usuario segun la PK(llave primaria)
		
		if(u == null) {
			System.out.println("Codigo no existe");
		}else {
			System.out.println("Bienvenido : " + u.getNombre());
			System.out.println(u);
		}
		em.close();
	}
}
