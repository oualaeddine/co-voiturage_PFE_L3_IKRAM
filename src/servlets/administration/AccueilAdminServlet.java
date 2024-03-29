package servlets.administration;

import servlets.MyServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AccueilAdminServlet", urlPatterns = "/accueilAdmin")
public class AccueilAdminServlet extends MyServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isAdminLoggedIn(request)) {
            getServletContext().getRequestDispatcher("/espace_admin/administrateur.jsp").forward(request, response);
        } else
            redirectToLogin(response);
    }
}
