package servlets.clients;

import model.beans.User;
import model.db.dao.ClientsDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AuthentificationServlet", urlPatterns = "/login")
public class AuthentificationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null)
            switch (action) {
                case "login": {
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    if (new ClientsDAO().exists(email, password)) {
                        User loggedInUser = new ClientsDAO().getByEmail(email);

                        HttpSession session = request.getSession(true);
                        session.setAttribute("user", loggedInUser);

                        response.sendRedirect("/recherche/rechercher.html");

                        System.out.println("login : true");
                    } else {
                        System.out.println("login : false");
                    getServletContext().getRequestDispatcher("/connexion/connexion.html").forward(request, response);
                    }
                    break;
                }
                case "signup": {
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    String nom = request.getParameter("nom");
                    String prenom = request.getParameter("prenom");
                    if (new ClientsDAO().createClient(nom, prenom, email, password)) {
                        System.out.println("signup : true");
                        User loggedInUser = new ClientsDAO().getByEmail(email);

                        HttpSession session = request.getSession(true);
                        session.setAttribute("user", loggedInUser);

                        response.sendRedirect("/recherche/rechercher.html");
                        
                    } else {
                        getServletContext().getRequestDispatcher("/connexion/connexion.html").forward(request, response);
                        System.out.println("signup : false");
                    }
                    break;
                }
            }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/connexion/connexion.html").forward(request, response);
    }
}
