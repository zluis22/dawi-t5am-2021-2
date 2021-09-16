package app;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo08 {
	// SEMANA 03 - Dia 9
	public static void main(String[] args) {
		// obtener la conexion a la BD --> según la unidad de persistencia de archivo xml |DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// crea los DAO usango la fabrica
		EntityManager em = fabrica.createEntityManager();
		
		// validar un Usuario según su usuario y clave
		String sql = "select u from Usuario u where u.usuario = :xusr and u.clave= :xcla";
		
		TypedQuery<Usuario> query = em.createQuery(sql, Usuario.class);
		query.setParameter("xusr", "U002@gmail.com");
		query.setParameter("xcla", "10003");
		
		Usuario u = null;
		try {
			u = query.getSingleResult();
		} catch (Exception e) {
			
		}
				
		if(u == null) {
			System.out.println("Codigo no existe");
		}else {
			System.out.println("Bienvenido : " + u.getNombre());
			System.out.println(u);
		}
		em.close();
	}	
	
}
