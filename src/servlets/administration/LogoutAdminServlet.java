package servlets.administration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlets.MyServlet;

import java.io.IOException;

@WebServlet(name = "LogoutAdminServlet",urlPatterns = "/logout")
public class LogoutAdminServlet extends MyServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isLoggedIn()) {
        	HttpSession session=request.getSession(false);
        	session.invalidate();
        	getServletContext().getRequestDispatcher("/connexion.html").include(request, response);
        } else
            redirectToLogin(response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
