package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Jugador;

public class DaoJugador {

	public ArrayList<Jugador> getJugadoresByEquipo(Connection con, int idequipo) {
		ResultSet rs;
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT * from Jugador where equipo = "+idequipo+" order by nombre";
			rs = st.executeQuery(ordenSql);
			while (rs.next()) {
				Jugador jugador = new Jugador();
				jugador.setId(rs.getInt("id"));
				jugador.setEquipo(rs.getInt("equipo"));
				jugador.setNombre(rs.getString("nombre"));
				jugador.setImagen(rs.getString("imagen"));
				jugador.setLink(rs.getString("link"));
				jugador.setPais(rs.getString("pais"));
				jugador.setEstatura(rs.getInt("estatura"));
				jugador.setEdad(rs.getInt("edad"));
				jugador.setLikes(rs.getInt("likes"));
				
				jugadores.add(jugador);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error DAO.\n"+e.getMessage());
		}
		return jugadores;
	}
	
	public void darLike(int idjugador, Connection con) {
		String ordenSQL = "update JUGADOR set LIKES=LIKES+1 where ID=?";
		PreparedStatement st;
		try {
			st = con.prepareStatement(ordenSQL);
			st.setInt(1, idjugador);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
