package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.Punto;

public class DaoPunto {
	public void insertarPuntos(Punto punto, Connection con) {
		String ordenSQL;
		ordenSQL = "insert into punto values(?,?,?)";
		PreparedStatement st;
		try {
			st = con.prepareStatement(ordenSQL);
			st.setInt(1, punto.getId());
			st.setInt(2, punto.getIdproducto());
			st.setInt(3, punto.getPuntos());
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			System.out.println("Problema al insertar puntos.\n"+e.getMessage());
		}

	}

}
