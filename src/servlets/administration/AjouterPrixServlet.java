package servlets.administration;

import model.beans.Trajet;
import model.db.dao.TrajetsDAO;
import model.db.dao.VillesDAO;
import servlets.MyServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AjouterPrixServlet", urlPatterns = "/ajouterPrix")
public class AjouterPrixServlet extends MyServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isAdminLoggedIn(request)) {
        	String depart = request.getParameter("depart");
        	String arrive = request.getParameter("arrive");
        	String prix = request.getParameter("prix");
        	String places = request.getParameter("places");
        	String type = request.getParameter("type");

        	VillesDAO villesDAO = new VillesDAO();
        	
        	Trajet trajet=new Trajet();
        	trajet.setDepart(villesDAO.getVilleByName(depart));
        	trajet.setArrive(villesDAO.getVilleByName(arrive));
        	trajet.setPrix(Float.parseFloat(prix));
        	trajet.setNombrePlaces(Integer.parseInt(places));
        	trajet.setTypeVéhicule(type);
        	
        	if (new TrajetsDAO().add(trajet)) {
        		System.out.println("ajouter : true");
        		try {
        			response.sendRedirect("/HomeServlet");
        		} catch (IOException e) {
        			e.printStackTrace();
        		}

        	} else {
        		getServletContext().getRequestDispatcher("").forward(request, response);// makanch la page hedi
        		System.out.println("ajouter : false");
        	}
        } else
            redirectToLogin(response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isAdminLoggedIn(request)) {
        	getServletContext().getRequestDispatcher("/espace_admin/ajouter prix.jsp").forward(request, response);
        } else
            redirectToLogin(response);
    }
}
