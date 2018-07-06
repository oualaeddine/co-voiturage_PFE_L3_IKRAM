package servlets.administration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AjouterPrixServlet", urlPatterns = "/ajouterPrix")
public class AjouterPrixServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String depart = request.getParameter("depart");
        String arrive = request.getParameter("arrive");
        String prix = request.getParameter("prix");     
        
        if (new ItiniraireDAO.addItiniraire(depart, arrive, prix)) {
            System.out.println("ajouterPrix : true");
            response.sendRedirect("/administrateur.jsp");

        } else {
            getServletContext().getRequestDispatcher("/ajouter prix.jsp").forward(request, response);
            System.out.println("ajouterPrix : false");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
