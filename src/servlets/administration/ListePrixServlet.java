package servlets.administration;

import model.db.dao.ItiniraireDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "ListePrixServlet", urlPatterns = "/ListePrix")
public class ListePrixServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LinkedList<Object> itiniraires = new ItiniraireDAO().getAll();
        if (itiniraires.size() > 0) {
            request.setAttribute("itiniraires", itiniraires);
            getServletContext().getRequestDispatcher("/espace_admin/liste de prix.jsp").forward(request, response);
        } else
            doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/accueilAdmin").forward(request, response);

    }
}
