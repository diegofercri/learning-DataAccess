package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import conexion.Conexion;
import daos.DaoBici;
import daos.DaoMarca;
import entities.Bici;
import entities.Marca;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection con = null;
		ArrayList<Bici> bicis = null;
		ArrayList<Marca> marcas = null;
		String marca = null;
		String order = null;
		String fav = null;
		
		con = (Connection)session.getAttribute("con");
		if (con== null) {
			con = Conexion.conecta();
			session.setAttribute("con", con);
		}
		
		String op = request.getParameter("op");
		switch (op) {
			case "inicio":
				marca = "%";
				order = null;
				fav = "%";
				
				bicis = new DaoBici().getBicis(con, marca, order, fav);
				marcas = new DaoMarca().getMarcas(con);
				
				session.setAttribute("marca", marca);
				session.setAttribute("order", order);
				session.setAttribute("fav", fav);
				session.setAttribute("bicis", bicis);
				session.setAttribute("marcas", marcas);
				
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;	
			case "vamarca":
				marca = request.getParameter("marca");
				session.setAttribute("marca", marca);
				order = (String)session.getAttribute("order");
				fav = (String)session.getAttribute("fav");
				bicis = new DaoBici().getBicis(con, marca, order, fav);
				session.setAttribute("bicis", bicis);
				
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;	
			case "vaorder":
				order = request.getParameter("order");
				session.setAttribute("order", order);
				marca = (String)session.getAttribute("marca");
				fav = (String)session.getAttribute("fav");
				bicis = new DaoBici().getBicis(con, marca, order, fav);
				session.setAttribute("bicis", bicis);
				
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;	
			case "vafav":
				fav = (String)session.getAttribute("fav");
				if (fav.equals("%")) 
					fav = "1";
				else
					fav = "%";
				session.setAttribute("fav", fav);
				marca = (String)session.getAttribute("marca");
				order = (String)session.getAttribute("order");
				bicis = new DaoBici().getBicis(con, marca, order, fav);
				session.setAttribute("bicis", bicis);
				
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;	
			case "changefav":
				String idbici = request.getParameter("idbici");
				String newfav = request.getParameter("newfav");
				new DaoBici().changeFav(Integer.parseInt(idbici), Integer.parseInt(newfav), con);
				
				marca = (String)session.getAttribute("marca");
				order = (String)session.getAttribute("order");
				fav = (String)session.getAttribute("fav");
				bicis = new DaoBici().getBicis(con, marca, order, fav);
				session.setAttribute("bicis", bicis);
				
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;					
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
