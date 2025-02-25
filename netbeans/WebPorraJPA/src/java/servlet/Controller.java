package servlet;

import entities.Apuesta;
import entities.Jornada;
import entities.Porra;
import entities.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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
                List jornadas;
                Usuario usuario;
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
                        q = em.createQuery("SELECT j FROM Jornada j");
                        jornadas = q.getResultList();

                        session.setAttribute("jornadas", jornadas);
                        request.getRequestDispatcher("home.jsp").forward(request, response);
                        break;
                    }
                    case "vajornada": {
                        String jornadaid = request.getParameter("jornada");
                        Jornada jornada = em.find(Jornada.class , Integer.parseInt(jornadaid));
                        
                        request.setAttribute("jornada", jornadaid);
                        session.setAttribute("partidos", jornada.getPartidoList());
                        request.getRequestDispatcher("home.jsp").forward(request, response);
                        break;
                    }
                    case "login": {
                        String dni = request.getParameter("dni");
                        
                        usuario = em.find(Usuario.class, dni);
                        if (usuario==null) {
                            msg = "DNI no registrado en nuestra BD...";
                            request.setAttribute("msg", msg);
                        }
                        else {
                            session.setAttribute("usuario", usuario);
                        }
                        
                        request.getRequestDispatcher("home.jsp").forward(request, response);
                        break;
                    }
                    case "registro": {
                        String dni = request.getParameter("dni");
                        String nombre = request.getParameter("nombre");
                        
                        usuario = em.find(Usuario.class, dni);
                        if (usuario==null) {
                           // registro
                           usuario = new Usuario(dni);
                           usuario.setNombre(nombre);
                           t = em.getTransaction();
                           t.begin();
                           em.persist(usuario);
                           t.commit();
                           msg = "Registrado "+ nombre;
                           session.setAttribute("usuario", usuario);
                        }
                        else {
                            msg = "Este DNI ya existe...";
                        }
                        request.setAttribute("msg", msg);
                        request.getRequestDispatcher("home.jsp").forward(request, response);
                        break;
                    }
                    case "logout": {
                        session.removeAttribute("usuario");
                        request.getRequestDispatcher("home.jsp").forward(request, response);
                        break;
                    }      
                    case "resumen": {
                        String idpartido = request.getParameter("partido");
                        
                        String sql = "select p.goleslocal, p.golesvisitante, count(p) "
                                                                            + "from Porra p where p.partido.idpartido=:idpartido "
                                                                            + "group by p.goleslocal, p.golesvisitante";
                        q = em.createQuery(sql);
                        q.setParameter("idpartido", Integer.valueOf(idpartido));
                        List<Object[]> resultList = q.getResultList();
                        List<Apuesta> apuestas = new ArrayList<>();
                        for (Object[] row : resultList) {
                            apuestas.add(new Apuesta((Integer) row[0], (Integer) row[1], (Long) row[2]));
                        }
                        if (apuestas.size()==0) apuestas = null;
                        session.setAttribute("apuestas", apuestas);
                        
                        request.getRequestDispatcher("apuestas.jsp").forward(request, response);
                        break;
                    }      
                    case "apuesta": {
                        String idpartido = request.getParameter("partido");
                        String goleslocal = request.getParameter("goleslocal");
                        String golesvisi = request.getParameter("golesvisi");
                        usuario = (Usuario) session.getAttribute("usuario");
                        Porra porra = new Porra(usuario.getDni(), Integer.parseInt(idpartido));
                        porra.setGoleslocal(Integer.parseInt(goleslocal));
                        porra.setGolesvisitante(Integer.parseInt(golesvisi));
                        porra.setUsuario(usuario);
                        t = em.getTransaction();
                        t.begin();
                        em.persist(porra);
                        t.commit();
                        msg = "Anotada porra ("+goleslocal+","+golesvisi+") al usuario " + usuario.getNombre();                        
                        request.setAttribute("msg", msg);
                        
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
