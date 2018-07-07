package servlets.administration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.db.dao.VillesDAO;
import model.beans.Ville;


import java.io.IOException;

@WebServlet(name = "AjouterVilleServlet", urlPatterns = "/ajouterVille")
public class AjouterVilleServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("ville");
        Ville ville=new Ville();
        ville.setName(nom);
        if (new VillesDAO().add(ville)) {
            System.out.println("ajouterVille : true");
            try {
                response.sendRedirect("/administrateur.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            getServletContext().getRequestDispatcher("ajouter ville.jsp").forward(request, response);
            System.out.println("ajouterVille : false");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }// TODO: 6/6/2018
}
