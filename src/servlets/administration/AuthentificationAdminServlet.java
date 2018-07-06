package servlets.administration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AuthentificationAdminServlet", urlPatterns = "/authentification")
public class AuthentificationAdminServlet extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
	                    String email = request.getParameter("email");
	                    String password = request.getParameter("password");
	                   
	                    if (new AdminDAO().exists(email, password)) {
	                        User loggedInAdmin = new AdminDAO().getByEmail(email);

	                        HttpSession session = request.getSession(true);
	                        session.setAttribute("admin", loggedInAdmin);

	                        response.sendRedirect("/administrateur.html");

	                        System.out.println("login : true");
	                    } else {
	                        System.out.println("login : false");
	                    getServletContext().getRequestDispatcher("/espace_admin/connexion.html").forward(request, response);
	                    }
	    }


	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        getServletContext().getRequestDispatcher("/espace_admin/connexion.html").forward(request, response);
	    }

}
