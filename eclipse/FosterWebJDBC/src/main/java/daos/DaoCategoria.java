package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Categoria;

public class DaoCategoria {
	public ArrayList<Categoria> getAllCategories(Connection con){
		ResultSet rs;
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();

		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT * from categoria order by nombre";
			rs = st.executeQuery(ordenSql);
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("ID"));
				categoria.setNombre(rs.getString("NOMBRE"));
				categoria.setDescripcion(rs.getString("DESCRIPCION"));
				categoria.setGuarnicion(rs.getString("GUARNICION"));
				categorias.add(categoria);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error DAO.\n"+e.getMessage());
		}
		return categorias;
	}

}
