package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto2;

public class Prod2Demo01 {
	
	public static void main(String[] args) {
		// obtener la conexion a la BD --> según la unidad de persistencia de archivo xml |DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// crea los DAO usango la fabrica
		EntityManager em = fabrica.createEntityManager();
		
		// proceso ... registrar un nuevo usuario
		Producto2 p = new Producto2();
		//p.setIdprod("P0050");
		//p.setDescripcion("Prueba");
		//p.setStock(10);
		//p.setIdcategoria(1);
		//p.setPrecio(0.99);
		
		// para regis. act. eli. --> transacciones
		em.getTransaction().begin();
		em.persist(p); // metodo para registrar
		em.getTransaction().commit(); // para confirmar registro
		System.out.println("Registro OK");
		em.close();
		
		
	}
	
}
