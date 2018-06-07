package servlets.administration;

import model.beans.User;
import model.db.dao.AdminDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AuthentificationAdminServlet", urlPatterns = "/authentification")
public class AuthentificationAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (new AdminDAO().exists(email, password)) {
            User loggedInAdmin = new AdminDAO().getByEmail(email);

            HttpSession session = request.getSession(true);
            session.setAttribute("admin", loggedInAdmin);

            response.sendRedirect("/accueilAdmin");

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
