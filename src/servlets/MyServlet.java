package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.User;

import java.io.IOException;

@WebServlet(name = "MyServlet", urlPatterns = "/servlet")
public class MyServlet extends HttpServlet {

    protected boolean isLoggedIn() {
    	HttpSession session = request.getSession(false);
    	User admin = (User) session.getAttribute("admin");

    	if(admin!= null)
    		return true;
        return false;
    }

    protected void redirectToLogin(HttpServletResponse response) throws IOException {
        response.sendRedirect("/accueilAdmin");
    }
}
