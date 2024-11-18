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
import java.util.List;

import conexion.Conexion;
import daos.DaoCategoria;
import daos.DaoProducto;
import daos.DaoPunto;
import entities.Categoria;
import entities.Producto;
import entities.Punto;


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
		ArrayList<Categoria> categorias = null;
		ArrayList<Producto> productos = null;
		Producto producto = null;
		
		con = (Connection)session.getAttribute("con");
		if (con== null) {
			con = Conexion.conecta();
			session.setAttribute("con", con);
		}
		
		String op = request.getParameter("op");
		switch (op) {
			case "inicio": 
				// a trabajarrrrr y obtener los datos necesarios para esta opcion
				categorias = new DaoCategoria().getAllCategories(con);
				// Entregamos a la vista home estos datos en forma de objeto bajo el nombre key
				// Cuidado con la key!!. En la home habra que utilizarla y llamarla IGUAL IGUAL...
				
				session.setAttribute("categorias", categorias);
				request.getRequestDispatcher("categorias.jsp").forward(request, response);
				break;	
			case "dameplatos":
				String idcategoria = request.getParameter("idcategoria");
				String nombrecat = request.getParameter("nombrecat");
				
				productos = new DaoProducto().getProductosByCategoria(con, Integer.parseInt(idcategoria));
				session.setAttribute("nombrecat", nombrecat);
				session.setAttribute("productos", productos);
				request.getRequestDispatcher("platos.jsp").forward(request, response);
				break;		
			case "detail":
				String idproducto = request.getParameter("idproducto");
				producto = new DaoProducto().getProductoById(con, Integer.parseInt(idproducto));
				session.setAttribute("producto", producto);
				request.getRequestDispatcher("detail.jsp").forward(request, response);
				break;	
			case "rating":
				String puntos = request.getParameter("rating");
				producto = (Producto) session.getAttribute("producto");
				new DaoPunto().insertarPuntos(new Punto(0, producto.getId(), Integer.parseInt(puntos)), con);
				producto = new DaoProducto().getProductoById(con, producto.getId());
				session.setAttribute("producto", producto);				
				request.getRequestDispatcher("detail.jsp").forward(request, response);
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
