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

import connection.ConnectionClass;
import daos.CategoryDao;
import daos.PlaceDao;
import daos.ProvinceDao;
import entities.Category;
import entities.Place;
import entities.Province;

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
		ArrayList<Place> placesList = null;
		ArrayList<Category> categoriesList = null;
		ArrayList<Province> provincesList = null;
		String category = null;
		String province = null;
		String fav = null;
		
		con = (Connection)session.getAttribute("con");
		if (con== null) {
			con = ConnectionClass.connect();
			session.setAttribute("con", con);
		}
		
		String op = request.getParameter("op");
		switch (op) {
			case "start":
				category = "%";
				province = "%";
				fav = "%";
				
				placesList = new PlaceDao().getPlaces(con, category, province, fav);
				categoriesList = new CategoryDao().getCategories(con);
				provincesList = new ProvinceDao().getProvinces(con);
				
				session.setAttribute("category", category);
				session.setAttribute("province", province);
				session.setAttribute("fav", fav);
				session.setAttribute("placesList", placesList);
				session.setAttribute("categoriesList", categoriesList);
				session.setAttribute("provincesList", provincesList);
				
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;
				
			case "filterByCategory":
			    category = request.getParameter("category");
			    if (category == null || category.isEmpty()) category = "%";
			    
			    session.setAttribute("category", category);
			    province = (String) session.getAttribute("province");
			    fav = (String) session.getAttribute("fav");

			    placesList = new PlaceDao().getPlaces(con, category, province, fav);
			    session.setAttribute("placesList", placesList);

			    request.getRequestDispatcher("home.jsp").forward(request, response);
			    break;
			    
				
			case "filterByProvince":
				province = request.getParameter("province");
			    if (province == null || province.isEmpty()) province = "%";
			    
			    session.setAttribute("province", province);
			    category = (String) session.getAttribute("category");
			    fav = (String) session.getAttribute("fav");

			    placesList = new PlaceDao().getPlaces(con, category, province, fav);
			    session.setAttribute("placesList", placesList);

			    request.getRequestDispatcher("home.jsp").forward(request, response);
			    break;
			    
				
			case "filterByFav":
			    fav = (String) session.getAttribute("fav");
			    
			    if (fav.equals("%")) {
			        fav = "1";
			    } else {
			        fav = "%";
			    }
			    
			    session.setAttribute("fav", fav);
			    category = (String) session.getAttribute("category");
			    province = (String) session.getAttribute("province");
			    
			    placesList = new PlaceDao().getPlaces(con, category, province, fav);
			    session.setAttribute("placesList", placesList);
			    
			    request.getRequestDispatcher("home.jsp").forward(request, response);
			    break;
			case "changefav":
				String placeid = request.getParameter("placeid");
				String newfav = request.getParameter("newfav");
				new PlaceDao().changeFav(Integer.parseInt(placeid), Integer.parseInt(newfav), con);

			    category = (String) session.getAttribute("category");
			    province = (String) session.getAttribute("province");
				fav = (String)session.getAttribute("fav");
				
			    placesList = new PlaceDao().getPlaces(con, category, province, fav);
				session.setAttribute("placesList", placesList);
				
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
