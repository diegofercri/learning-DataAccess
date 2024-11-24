package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	public void setRating(Rating rating, Connection con) {
		String ordenSQL;
		ordenSQL = "insert into punto values(?,?,?)";
		PreparedStatement st;
		try {
			st = con.prepareStatement(ordenSQL);
			st.setInt(1, rating.getPoints());
			st.setInt(2, rating.getRoute());
			st.setInt(3, rating.getId());
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			System.out.println("DAO Error on Rating insert.\n"+e.getMessage());
		}

	}
}
