package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entities.Province;

public class ProvinceDao {
	public ArrayList<Province> getProvinces(Connection con){
		ResultSet rs;
		ArrayList<Province> provincesList = new ArrayList<Province>();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "select * from provincia order by nombre";
			rs = st.executeQuery(ordenSql);
			while (rs.next()) {
				Province province = new Province();
				province.setImage(rs.getString("IMAGEN"));
				province.setName(rs.getString("NOMBRE"));
				province.setId(rs.getInt("ID"));
				
				provincesList.add(province);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error DAO.\n"+e.getMessage());
		}
		return provincesList;
	}
}
