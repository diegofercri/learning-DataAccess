package controller;

import entities.Movie;
import entities.Person;
import entities.Rating;
import entities.Usuario;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
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
            List<Person> personajes;
            List<Movie> peliculas;
            Usuario usuario;
            EntityTransaction t;
            String msg;
            boolean isPerson;
            Person person;
            // Singleton
            EntityManager em = (EntityManager) session.getAttribute("em");
            if (em==null) {
                // Create the EntityManager
                em = JPAUtil.getEntityManagerFactory().createEntityManager();
                session.setAttribute("em", em);
            }

            switch (op) {
                case "inicio": {
                    // actuar en consecuencia
                    q = em.createQuery("select p from Person p");
                    personajes = q.getResultList();
                    session.setAttribute("personajes", personajes);
                    q = em.createQuery("select m from Movie m");
                    peliculas = q.getResultList();
                    session.setAttribute("peliculas", peliculas);
                    session.setAttribute("isPerson", true);

                    request.getRequestDispatcher("personajes.jsp").forward(request, response);
                    break;
                }
                case "dameperson": {
                    session.setAttribute("isPerson", true);
                    request.getRequestDispatcher("personajes.jsp").forward(request, response);
                    break;                    
                }
                case "damemovie": {
                    session.setAttribute("isPerson", false);
                    request.getRequestDispatcher("peliculas.jsp").forward(request, response);
                    break;                    
                } 
                case "logout": {
                    session.removeAttribute("usuario");
                    isPerson = (boolean)session.getAttribute("isPerson");
                    if (isPerson) {
                        request.getRequestDispatcher("personajes.jsp").forward(request, response);  
                    }
                    else {
                        request.getRequestDispatcher("peliculas.jsp").forward(request, response);
                    }                    
                    break;                    
                }
                case "login": {
                    String dni = request.getParameter("dni");
                    String nombre = request.getParameter("nombre");
                    usuario = em.find(Usuario.class, dni);
                    if (usuario==null){
                        usuario = new Usuario(dni);
                        usuario.setNombre(nombre);
                        t = em.getTransaction();
                        t.begin();
                        em.persist(usuario);
                        t.commit();
                        msg = "Registrado...";
                    }
                    else {
                        msg = "Login ok ...";
                    }
                    request.setAttribute("msg", msg);
                    session.setAttribute("usuario", usuario);
                    isPerson = (boolean)session.getAttribute("isPerson");
                    if (isPerson) {
                        request.getRequestDispatcher("personajes.jsp").forward(request, response);  
                    }
                    else {
                        request.getRequestDispatcher("peliculas.jsp").forward(request, response);
                    }
                    break;                    
                } 
                case "moviestheperson": {
                    String personajeid = request.getParameter("personajeid");
                    person = em.find(Person.class, Integer.parseInt(personajeid));
                    
                    session.setAttribute("person", person);
        
                    request.getRequestDispatcher("movies.jsp").forward(request, response);
                                       
                    break;                    
                }   
                case "rating": {
                    String personajeid = request.getParameter("idpersonaje");
                    String puntos = request.getParameter("rating");
                    usuario = (Usuario)session.getAttribute("usuario");
                    person = em.find(Person.class, Integer.parseInt(personajeid));
                    Rating rating = new Rating(-1);
                    rating.setDni(usuario);
                    rating.setIdperson(person);
                    rating.setPuntos(Integer.parseInt(puntos));
                    t = em.getTransaction();
                    t.begin();
                    em.persist(rating);
                    t.commit();
                    em.refresh(person);
                    request.getRequestDispatcher("personajes.jsp").forward(request, response);
                                       
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
