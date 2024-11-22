package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Bici;

public class DaoBici {
	public ArrayList<Bici> getBicis(Connection con, String marca,String order, String fav){
		ResultSet rs;
		ArrayList<Bici> listaBicis = new ArrayList<Bici>();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "select b.id,foto, marca, descripcion, precio, fav, nombre from bici b, marca m"+
							  " where marca = m.id and marca like '"+marca+"' and fav like '"+fav+"' order by "+order;
			rs = st.executeQuery(ordenSql);
			while (rs.next()) {
				Bici bici = new Bici();
				bici.setId(rs.getInt("ID"));
				bici.setFoto(rs.getString("FOTO"));
				bici.setMarca(rs.getInt("MARCA"));
				bici.setNombreMarca(rs.getString("NOMBRE"));
				bici.setDescripcion(rs.getString("DESCRIPCION"));
				bici.setPrecio(rs.getFloat("PRECIO"));
				bici.setFav(rs.getInt("FAV"));
				
				listaBicis.add(bici);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error DAO.\n"+e.getMessage());
		}
		return listaBicis;
	}
	public void changeFav(int idbici, int fav, Connection con) {
		
		String ordenSQL = "update bici set fav=? where id=?";
		PreparedStatement st;
		try {
			st = con.prepareStatement(ordenSQL);
			st.setInt(1, fav);
			st.setInt(2, idbici);
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al cambiar fav\n"+e.getMessage());
		}
	}

}


