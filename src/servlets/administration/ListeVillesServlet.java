package servlets.administration;

import model.beans.Ville;
import model.db.dao.VillesDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "ListeVillesServlet", urlPatterns = "/ListeVilles")
public class ListeVillesServlet extends HttpServlet {
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        LinkedList<Object> villes = new VillesDAO().getAll();
	        if (villes.size() > 0) {
	    		request.setAttribute("villes", villes);	
	            getServletContext().getRequestDispatcher("/liste de ville.jsp").forward(request, response);
	        } else
	            doGet(request, response);
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        getServletContext().getRequestDispatcher("/administrateur.html").forward(request, response);

	    }
}
