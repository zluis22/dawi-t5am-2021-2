package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_productos")
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Producto2 {

		@Id
		private String idprod;
		private String descripcion;
		private int stock;
		private double precio;
		private int idcategoria;
		private int estado;
		
		
		
		
		
	

}
