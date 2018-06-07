package servlets.administration;

import model.beans.Ville;
import model.db.dao.VillesDAO;
import servlets.MyServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "ListeVillesServlet", urlPatterns = "/ListeVilles")
public class ListeVillesServlet extends MyServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isAdminLoggedIn(request)) {
        	LinkedList<Ville> villes = new VillesDAO().getAll();
        	if (villes.size() > 0) {
        		request.setAttribute("villes", villes);
        		getServletContext().getRequestDispatcher("/espace_admin/liste de ville.jsp").forward(request, response);
        	} else
        		doGet(request, response);
        } else
            redirectToLogin(response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isAdminLoggedIn(request)) {
        	LinkedList<Ville> villes = new VillesDAO().getAll();
        	request.setAttribute("villes", villes);
        	getServletContext().getRequestDispatcher("/espace_admin/liste de ville.jsp").forward(request, response);
        } else
            redirectToLogin(response);
    }
}
