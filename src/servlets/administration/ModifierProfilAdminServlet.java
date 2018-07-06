package servlets.administration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ModifierProfilAdminServlet", urlPatterns = "/profil")
public class ModifierProfilAdminServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Date dateNaissance = new Util().getDateFromString(request.getParameter("dateNaissance"));
        String sexe = request.getParameter("sexe");     

        HttpSession session=request.getSession(false);
        User admin =(User)session.getAttribute("admin");

        
        if (new AdminDAO().editProfile(admin.getEmail(), nom, prenom, email, password,dateNaissance,sexe)) {
        	System.out.println("Edit : true");
        	response.sendRedirect("/administrateur.html");
        } else {
            getServletContext().getRequestDispatcher("/profil.html").forward(request, response);
            System.out.println("Edit : false");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
