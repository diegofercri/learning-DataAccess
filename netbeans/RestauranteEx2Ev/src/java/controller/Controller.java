package controller;

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
import model.Alergeno;
import model.Pedido;
import model.Plato;
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
        Query q;
        List alergenos;
        List categorias;
        List platos;

        // Singleton
        EntityManager em = (EntityManager) session.getAttribute("em");
        if (em == null) {
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

            case "filtro": {
                Integer categoriaId = Integer.parseInt(request.getParameter("categoria"));
                q = em.createQuery("select p from Plato p where p.categoria.id = :categoriaId");
                q.setParameter("categoriaId", categoriaId);
                platos = q.getResultList();
                session.setAttribute("platosFiltrados", platos);

                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;
            }

            case "filtroAlergeno": {
                Integer alergenoId = Integer.parseInt(request.getParameter("alergeno"));
                q = em.createQuery("select p from Plato p where :alergeno not member of p.alergenoList");
                q.setParameter("alergeno", em.find(Alergeno.class, alergenoId));
                platos = q.getResultList();
                session.setAttribute("platosFiltrados", platos);

                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;
            }

            case "addToCart": {
            // Añadir un plato al carrito
            Integer platoId = Integer.parseInt(request.getParameter("plato"));
            em = (EntityManager) session.getAttribute("em");
            Plato plato = em.find(Plato.class, platoId);

            // Obtener el carrito de la sesión
            List<Plato> carrito = (List<Plato>) session.getAttribute("carrito");
            if (carrito == null) {
                carrito = new ArrayList<>();
            }
            carrito.add(plato);
            session.setAttribute("carrito", carrito);

            response.sendRedirect("Controller?op=inicio");
            break;
            }

            case "confirmOrder": {
                // Confirmar el pedido y guardarlo en la base de datos
                List<Plato> carrito = (List<Plato>) session.getAttribute("carrito");
                if (carrito != null && !carrito.isEmpty()) {
                    em = (EntityManager) session.getAttribute("em");
                    EntityTransaction tx = em.getTransaction();

                    try {
                        // Iniciar la transacción
                        tx.begin();

                        // Crear un nuevo pedido
                        Pedido pedido = new Pedido();
                        pedido.setMesa(Integer.parseInt(request.getParameter("mesa"))); // Asignar la mesa seleccionada
                        pedido.setPlatoList(carrito); // Asociar los platos del carrito al pedido
                        em.persist(pedido);

                        // Confirmar la transacción
                        tx.commit();
                        session.removeAttribute("carrito"); // Limpiar el carrito
                    } catch (Exception e) {
                        // Rollback solo si la transacción está activa
                        if (tx != null && tx.isActive()) {
                            tx.rollback();
                        }
                        e.printStackTrace();
                    }
                }

                response.sendRedirect("Controller?op=inicio");
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
