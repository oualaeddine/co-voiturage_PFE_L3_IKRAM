package servlets.clients;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlets.MyServlet;


@WebServlet(name ="LogoutClientServlet" ,urlPatterns = "/clientLogout")
public class LogoutClientServlet extends MyServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isClientLoggedIn(request)) {
        	getServletContext().getRequestDispatcher("/connexion/connexion.html").include(request, response);
        	HttpSession session=request.getSession(false);
        	session.invalidate();
        } else
            redirectToLoginClient(response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
