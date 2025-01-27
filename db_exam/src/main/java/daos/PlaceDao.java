package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entities.Place;

public class PlaceDao {
    public ArrayList<Place> getPlaces(Connection con, String category, String province, String fav) {
        ArrayList<Place> placesList = new ArrayList<Place>();
        
        // SQL base query
        String sql = "SELECT * FROM lugar WHERE (categoria LIKE ? OR ? = '%') " +
                     "AND (provincia LIKE ? OR ? = '%') " +
                     "AND (fav LIKE ? OR ? = '%') ORDER BY nombre";

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            // Set parameters for the query
            pst.setString(1, category);
            pst.setString(2, category); // for the OR condition in WHERE clause
            pst.setString(3, province);
            pst.setString(4, province); // for the OR condition in WHERE clause
            pst.setString(5, fav);
            pst.setString(6, fav); // for the OR condition in WHERE clause

            ResultSet rs = pst.executeQuery();
            
            // Process the result set
            while (rs.next()) {
                Place place = new Place();
                place.setId(rs.getInt("ID"));
                place.setName(rs.getString("NOMBRE"));
                place.setImage(rs.getString("IMAGEN"));
                place.setCategory_id(rs.getInt("CATEGORIA"));
                place.setProvince_id(rs.getInt("PROVINCIA"));
                place.setFav(rs.getInt("FAV"));
                
                placesList.add(place);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error in PlaceDao: " + e.getMessage());
        }

        return placesList;
    }

	public void changeFav(int placeid, int fav, Connection con) {
		
		String ordenSQL = "update lugar set fav=? where id=?";
		PreparedStatement st;
		try {
			st = con.prepareStatement(ordenSQL);
			st.setInt(1, fav);
			st.setInt(2, placeid);
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error changing favourite place: \n"+e.getMessage());
		}
	}
}
