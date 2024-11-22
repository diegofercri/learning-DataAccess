package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entities.Rating;

public class RatingDao {
	public Rating getRatingByRoute(Connection con, int routeId) {
		ResultSet rs;
		Rating rating = new Rating();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "select * from punto where ruta="+routeId;
			rs = st.executeQuery(ordenSql);
			if (rs.next()) {
				rating.setPoints(rs.getInt("PUNTOS"));
				rating.setRoute(rs.getInt("RUTA"));
				rating.setId(rs.getInt("ID"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DAO Error.\n"+e.getMessage());
		}
		return rating;
	}
}
