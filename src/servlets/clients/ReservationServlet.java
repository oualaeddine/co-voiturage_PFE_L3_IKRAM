package servlets.clients;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets.MyServlet;

@WebServlet(name="/ReservationServlet" , urlPatterns = "/reserver")
public class ReservationServlet extends MyServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isClientLoggedIn(request)) {
        	getServletContext().getRequestDispatcher("").forward(request, response);
    	} else
            redirectToLoginClient(response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if (isClientLoggedIn(request)) {
	        	getServletContext().getRequestDispatcher("").forward(request, response);
		 } else
	            redirectToLoginClient(response);	
	}
}
