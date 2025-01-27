package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Route;

public class RouteDao {
	public ArrayList<Route> getRoutesByCityId(Connection con, int cityId){
		ResultSet rs;
		ArrayList<Route> routesList = new ArrayList<Route>();
		Statement st;
		try {
			st = con.createStatement();
			String orderSql = "select * from ruta where ciudad="+cityId+" order by nombre";
			rs = st.executeQuery(orderSql);
			while (rs.next()) {
				Route route = new Route();
				route.setLink(rs.getString("LINK"));
				route.setDescription(rs.getString("DESCRIPCION"));
				route.setImage(rs.getString("IMAGEN"));
				route.setName(rs.getString("NOMBRE"));
				route.setCity(rs.getInt("CIUDAD"));
				route.setId(rs.getInt("ID"));
				
				Statement st2 = con.createStatement();
				String secondOrderSql = "SELECT round(avg(puntos)) rating from punto where ruta="+rs.getInt("ID");
				ResultSet rs2 = st2.executeQuery(secondOrderSql);
				if (rs2.next()) {
					route.setRating(rs2.getInt("rating"));
				}
				
				routesList.add(route);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DAO Error.\n"+e.getMessage());
		}
		return routesList;
	}
}
