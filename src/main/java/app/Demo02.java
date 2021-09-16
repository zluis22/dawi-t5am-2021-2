package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {
	
	public static void main(String[] args) {
		// obtener la conexion a la BD --> según la unidad de persistencia de archivo xml |DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// crea los DAO usango la fabrica
		EntityManager em = fabrica.createEntityManager();
		
		// proceso ... actualizar un usuario
		Usuario u = new Usuario();
		u.setCodigo(20);
		u.setNombre("Eren");
		u.setApellido("Jeager");
		u.setUsuario("eren24@gmail.com");
		u.setClave("paloma");
		u.setFnacim("2021/08/24");
		u.setTipo(1);
		u.setEstado(1);
		
		// para regis. act. eli. --> transacciones
		em.getTransaction().begin();
		em.merge(u); //  metodo para actualizar --> si existe el codigo(10) / pero si no existe lo registra
		em.getTransaction().commit(); // para confirmar registro
		System.out.println("Actualización OK");
		em.close();
		
		
	}
	
}
