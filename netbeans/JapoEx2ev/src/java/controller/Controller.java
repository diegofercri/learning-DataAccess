package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.persistence.EntityManager;
import util.JPAUtil;


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
		String op = request.getParameter("op");
        Query q;
        List alergenos;
		List categorias;
        List platos;
        String msg;
        EntityTransaction t;
		
		// Singleton
		EntityManager em = (EntityManager) session.getAttribute("em");
		if (em==null) {
                    // Create the EntityManager
                        em = JPAUtil.getEntityManagerFactory().createEntityManager();
			session.setAttribute("em", em);
		}
		
		switch (op) {
		case "inicio": {
            q = em.createQuery("select a from Alergeno a");
            alergenos = q.getResultList();
            session.setAttribute("alergenos", alergenos);
            q = em.createQuery("select c from Categoria c");
            categorias = q.getResultList();
            session.setAttribute("categorias", categorias);
            q = em.createQuery("select p from Plato p");
            platos = q.getResultList();
            session.setAttribute("platos", platos);

            request.getRequestDispatcher("home.jsp").forward(request, response);
            break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + op);
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
