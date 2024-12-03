package connection;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;


public class ConnectionClass {
	public static Connection connect(){
		// Change credentials please
    	String url="jdbc:oracle:thin:clm13/clm13@80.28.158.14:1521:oradai";
 
        OracleConnectionPoolDataSource ocpds;
        Connection con=null;
       	try {
			ocpds=new OracleConnectionPoolDataSource();
		    ocpds.setURL(url);
		    con=ocpds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connection Error.\n"+e.getMessage());
		}
       	if (con!=null) System.out.println("Successful Connection.");

       	return con;
    }
}
