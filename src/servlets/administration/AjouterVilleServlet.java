package servlets.administration;

import model.beans.Ville;
import model.db.dao.VillesDAO;
import servlets.MyServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AjouterVilleServlet", urlPatterns = "/ajouterVille")
public class AjouterVilleServlet extends MyServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if (isAdminLoggedIn(request)) {
    		String nom = request.getParameter("ville");
    		Ville ville = new Ville();
    		ville.setName(nom);
    		if (new VillesDAO().add(ville)) {
    			System.out.println("ajouterVille : true");
    			try {
    				response.sendRedirect("/accueilAdmin");
    			} catch (IOException e) {
    				e.printStackTrace();
    			}

    		} else {
    			getServletContext().getRequestDispatcher("/espace_admin/ajouter ville.jsp").forward(request, response);
    			System.out.println("ajouterVille : false");
    		}
    	} else
            redirectToLogin(response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isAdminLoggedIn(request)) {
        	getServletContext().getRequestDispatcher("/espace_admin/ajouter ville.jsp").forward(request, response);
        } else
            redirectToLogin(response);
    }
}
