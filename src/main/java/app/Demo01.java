package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {
	
	public static void main(String[] args) {
		// obtener la conexion a la BD --> según la unidad de persistencia de archivo xml |DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// crea los DAO usango la fabrica
		EntityManager em = fabrica.createEntityManager();
		
		// proceso ... registrar un nuevo usuario
		Usuario u = new Usuario();
		u.setCodigo(10);
		u.setNombre("Eren");
		u.setApellido("Ackerman");
		u.setUsuario("takakae@gmail.com");
		u.setClave("12345");
		u.setFnacim("2021/08/24");
		u.setTipo(1);
		u.setEstado(1);
		
		// para regis. act. eli. --> transacciones
		em.getTransaction().begin();
		em.persist(u); // metodo para registrar
		em.getTransaction().commit(); // para confirmar registro
		System.out.println("Registro OK");
		em.close();
		
		
	}
	
}
