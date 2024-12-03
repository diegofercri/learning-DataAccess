package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Category;

public class CategoryDao {
	public ArrayList<Category> getCategories(Connection con){
		ResultSet rs;
		ArrayList<Category> categoriesList = new ArrayList<Category>();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "select * from categoria order by nombre";
			rs = st.executeQuery(ordenSql);
			while (rs.next()) {
				Category category = new Category();
				category.setImage(rs.getString("IMAGEN"));
				category.setName(rs.getString("NOMBRE"));
				category.setId(rs.getInt("ID"));
				
				categoriesList.add(category);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error DAO.\n"+e.getMessage());
		}
		return categoriesList;
	}
}
