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
import daos.CityDao;
import daos.RouteDao;
import entities.City;
import entities.Route;

/**
 * Servlet implementation class Servler
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
		ArrayList<City> citiesList = null;
		ArrayList<City> citiesListWithRoutes = null;
		
		con = (Connection)session.getAttribute("con");
		if (con== null) {
			con = ConnectionClass.connect();
			session.setAttribute("con", con);
		}
		
		String op = request.getParameter("op");
		switch (op) {
			case "start":
				citiesList = new CityDao().getCities(con);
				citiesListWithRoutes = new CityDao().getCitiesWithRoutes(con);
				
				session.setAttribute("citiesList", citiesList);
				session.setAttribute("citiesListWithRoutes", citiesListWithRoutes);
				
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;
			case "sendCityWithRoutes":
				String cityWithRoutes = request.getParameter("cityWithRoutes");
				ArrayList<Route> routesList = new RouteDao().getRoutesByCityId(con, Integer.parseInt(cityWithRoutes));
				City city = new CityDao().getCityById(con, Integer.parseInt(cityWithRoutes));

				session.setAttribute("routesList", routesList);
				session.setAttribute("city", city);

				request.getRequestDispatcher("routes.jsp").forward(request, response);
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
