package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Categoria;
import entities.Producto;

public class DaoProducto {

	public ArrayList<Producto> getProductosByCategoria(Connection con, int idcategoria){
		ResultSet rs;
		ArrayList<Producto> productos = new ArrayList<Producto>();

		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT * from Producto where categoriaid = "+idcategoria+" order by titulo";
			rs = st.executeQuery(ordenSql);
			while (rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt("ID"));
				producto.setTitulo(rs.getString("TITULO"));
				producto.setBody(rs.getString("BODY"));
				producto.setCategoriaid(rs.getInt("CATEGORIAID"));
				producto.setImagen(rs.getString("IMAGEN"));
				producto.setFondo(rs.getString("FONDO"));
				producto.setSumario(rs.getString("SUMARIO"));
				
				productos.add(producto);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error DAO.\n"+e.getMessage());
		}
		return productos;
	}
	public Producto getProductoById(Connection con, int idproducto){
		ResultSet rs;
		Producto producto = null;

		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT * from Producto where id = "+idproducto;
			rs = st.executeQuery(ordenSql);
			if (rs.next()) {
				producto = new Producto();
				producto.setId(rs.getInt("ID"));
				producto.setTitulo(rs.getString("TITULO"));
				producto.setBody(rs.getString("BODY"));
				producto.setCategoriaid(rs.getInt("CATEGORIAID"));
				producto.setImagen(rs.getString("IMAGEN"));
				producto.setFondo(rs.getString("FONDO"));
				producto.setSumario(rs.getString("SUMARIO"));
				ordenSql = "SELECT round(avg(puntos)) estrellitas from Punto where idproducto = "+idproducto;
				rs = st.executeQuery(ordenSql);
				if (rs.next()) {
					producto.setStar(rs.getInt("ESTRELLITAS"));
				}
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error DAO.\n"+e.getMessage());
		}
		return producto;
	}


}
