package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.City;

public class CityDao {
	
	public City getCityById(Connection con, int id) {
		ResultSet rs;
		City city = new City();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "select * from ciudad where id="+id;
			rs = st.executeQuery(ordenSql);
			if (rs.next()) {
				city.setLink(rs.getString("LINK"));
				city.setImage(rs.getString("IMAGEN"));
				city.setName(rs.getString("NOMBRE"));
				city.setId(rs.getInt("ID"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DAO Error.\n"+e.getMessage());
		}
		return city;
	}
	
	public ArrayList<City> getCities(Connection con){
		ResultSet rs;
		ArrayList<City> citiesList = new ArrayList<City>();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "select * from ciudad order by nombre";
			rs = st.executeQuery(ordenSql);
			while (rs.next()) {
				City city = new City();
				city.setMap(rs.getString("MAPA"));
				city.setLink(rs.getString("LINK"));
				city.setDescription(rs.getString("DESCRIPCION"));
				city.setImage(rs.getString("IMAGEN"));
				city.setName(rs.getString("NOMBRE"));
				city.setId(rs.getInt("ID"));
				
				citiesList.add(city);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DAO Error.\n"+e.getMessage());
		}
		return citiesList;
	}
	
	public ArrayList<City> getCitiesWithRoutes(Connection con){
		ResultSet rs;
		ArrayList<City> citiesWithRoutesList = new ArrayList<City>();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "select * from ciudad where id in (select distinct ciudad from ruta) order by nombre";
			rs = st.executeQuery(ordenSql);
			while (rs.next()) {
				City city = new City();
				city.setName(rs.getString("NOMBRE"));
				city.setId(rs.getInt("ID"));
				
				citiesWithRoutesList.add(city);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DAO Error.\n"+e.getMessage());
		}
		return citiesWithRoutesList;
	}
}
