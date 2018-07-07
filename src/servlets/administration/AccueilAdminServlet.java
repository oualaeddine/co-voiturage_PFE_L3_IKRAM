package servlets.administration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.db.dao.ItiniraireDAO;

@WebServlet(name = "AccueilAdminServlet", urlPatterns = "/accueilAdmin")
public class AccueilAdminServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String depart = request.getParameter("depart");
        String arrive = request.getParameter("arrive");
        String prix = request.getParameter("prix"); 
        String places = request.getParameter("places");
        String type = request.getParameter("type");
        String upload = request.getParameter("upload"); //ma na3rfch nrécupérer fichier pdf pour le moment raho String :3
        
        if (new ItiniraireDAO().addItiniraire(depart, arrive, prix)) {
            System.out.println("ajout : true");
            try {
                response.sendRedirect("/administrateur.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            getServletContext().getRequestDispatcher("/administrateur.jsp").forward(request, response);
            System.out.println("ajout : false");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
// TODO: 6/6/2018
    }
}
