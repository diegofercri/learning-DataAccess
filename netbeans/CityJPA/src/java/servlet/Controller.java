package servlet;

import entities.Ciudad;
import entities.Punto;
import entities.Ruta;
import java.io.IOException;
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
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String op = request.getParameter("op");
        List<Ciudad> ciudades;
        List<Ciudad> ciudadesConRutas;
        List<Ruta> rutas;
        Ciudad ciudad;
        Ruta ruta;
        Query q;
        EntityTransaction t;
        // Singleton
        EntityManager em = (EntityManager) session.getAttribute("em");
        if (em == null) {
            // Create the EntityManager
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            session.setAttribute("em", em);
        }

        switch (op) {
            case "inicio": {
                q = em.createNamedQuery("Ciudad.findAll");
                ciudades = q.getResultList();
                ciudadesConRutas = new ArrayList<>();
                for (Ciudad myciudad : ciudades) {
                    if (!myciudad.getRutaList().isEmpty()) {
                        ciudadesConRutas.add(myciudad);
                    }
                }
                session.setAttribute("ciudades", ciudades);
                session.setAttribute("ciudadesConRutas", ciudadesConRutas);
                request.getRequestDispatcher("ciudades.jsp").forward(request, response);
                break;
            }
            case "damerutas": {
                int ciudadId = Integer.parseInt(request.getParameter("ciudadId"));         
                ciudad = em.find(Ciudad.class, ciudadId);
                for (Ruta myruta : ciudad.getRutaList()) {
                    int suma = 0;
                    int media = 0;
                    if (myruta.getPuntoList().size()>0) {
                        for (Punto punto : myruta.getPuntoList()) {
                            suma += punto.getPuntos();
                        }
                        media = Math.round(suma / myruta.getPuntoList().size());
                    }
                    myruta.setMedia(media);
                }
                session.setAttribute("ciudad", ciudad);
                session.setAttribute("rutas", ciudad.getRutaList());
                request.getRequestDispatcher("rutas.jsp").forward(request, response);
                break;
            }
            case "puntuar": {
                int puntos = Integer.parseInt(request.getParameter("puntos"));
                int rutaId = Integer.parseInt(request.getParameter("ruta"));
                ruta = em.find(Ruta.class, rutaId);
                Punto punto = new Punto(-1);
                punto.setPuntos(puntos);
                punto.setRuta(ruta);
                t = em.getTransaction();
                t.begin();
                em.persist(punto);
                t.commit();
                em.refresh(ruta);
                ciudad = em.find(Ciudad.class, ruta.getCiudad().getId());
                for (Ruta myruta : ciudad.getRutaList()) {
                    int suma = 0;
                    int media = 0;
                    if (myruta.getPuntoList().size()>0) {
                        for (Punto mypunto : myruta.getPuntoList()) {
                            suma += mypunto.getPuntos();
                        }
                        media = Math.round(suma / myruta.getPuntoList().size());
                    }
                    myruta.setMedia(media);
                }
                session.setAttribute("ciudad", ciudad);
                session.setAttribute("rutas", ciudad.getRutaList());
                request.getRequestDispatcher("rutas.jsp").forward(request, response);
                break;
            }
            default:
                throw new IllegalArgumentException("Unexpected value: " + op);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
