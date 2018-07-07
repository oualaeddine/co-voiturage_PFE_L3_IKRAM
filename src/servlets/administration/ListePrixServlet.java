package servlets.administration;

import model.beans.Itiniraire;
import model.db.dao.ItiniraireDAO;
import servlets.MyServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "ListePrixServlet", urlPatterns = "/ListePrix")
public class ListePrixServlet extends MyServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isLoggedIn()) {
        	LinkedList<Itiniraire> itiniraires = new ItiniraireDAO().getAll();
        	request.setAttribute("itiniraires", itiniraires);
        	getServletContext().getRequestDispatcher("/espace_admin/liste de prix.jsp").forward(request, response);
        } else
            redirectToLogin(response);
    }
}
