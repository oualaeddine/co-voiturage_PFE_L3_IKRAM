package servlets.clients;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets.MyServlet;

import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = {"/home", ""})
public class HomeServlet extends MyServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if (isClientLoggedIn(request)) {
            doGet(request, response);
    	} else
            redirectToLoginClient(response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if (isClientLoggedIn(request)) {
            getServletContext().getRequestDispatcher("/accueil/index.html").forward(request, response);
    	} else
            redirectToLoginClient(response);
    }
}
