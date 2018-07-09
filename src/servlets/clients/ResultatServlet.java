package servlets.clients;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets.MyServlet;

import java.io.IOException;

@WebServlet(name = "ResultatServlet", urlPatterns = "/resultat")
public class ResultatServlet extends MyServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if (isClientLoggedIn(request)) {
    		getServletContext().getRequestDispatcher("/recherche/tajet dispo.jsp").forward(request, response);
    	} else
            redirectToLoginClient(response);
    	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	if (isClientLoggedIn(request)) {
    		// getServletContext().getRequestDispatcher("").forward(request, response);
    		response.getWriter().append("hedi la page lazm tetcrea");
    	} else
            redirectToLoginClient(response);
    	}
}
