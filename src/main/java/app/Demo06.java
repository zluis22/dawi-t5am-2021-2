package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import model.Usuario;

public class Demo06 {

	public static void main(String[] args) {
		// obtener la conexion a la BD --> según la unidad de persistencia de archivo xml |DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// crea los DAO usango la fabrica
		EntityManager em = fabrica.createEntityManager();
		
		// proceso ... listado de usuario
		System.out.println("Listado de los Usuarios");
		
		// string SQL = "select * from tb_usuarios" ; // <-- JDBC
		String sql = "select u from Usuario u"; // <-- JPA
		
		List<Usuario> lstUsuarios = em.createQuery(sql, Usuario.class).getResultList();
			
		System.out.println("Cantidad de Usuarios :" + lstUsuarios.size());
		for (Usuario u : lstUsuarios) {
			System.out.println(">>>" + u);
		}	
		
		// proceso ... listado de usuario
				System.out.println("Listado de los Usuarios x tipo");
				
				// string SQL = "select * from tb_usuarios" ; // <-- JDBC
				String sql2 = "select u from Usuario u where u.tipo = :xtipo"; // <-- JPA
				
				List<Usuario> lstUsuarios2 = em.createQuery(sql2, Usuario.class).setParameter("xtipo", 1).getResultList();
					
				System.out.println("Cantidad de Usuarios :" + lstUsuarios2.size());
				for (Usuario u : lstUsuarios2) {
					System.out.println(">>>" + u);
				}	
		
		em.close();
	}
	
}
