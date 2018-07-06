package servlets.clients;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeServlet",urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        getServletContext().getRequestDispatcher("").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
