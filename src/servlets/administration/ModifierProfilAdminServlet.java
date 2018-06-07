package servlets.administration;

import model.beans.User;
import model.db.dao.AdminDAO;
import util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ModifierProfilAdminServlet", urlPatterns = "/profil")
public class ModifierProfilAdminServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        new Util();
        Date dateNaissance = Util.getDateFromString(request.getParameter("dateNaissance"));
        String sexe = request.getParameter("sexe");

        HttpSession session = request.getSession(false);
        User admin = (User) session.getAttribute("admin");


        if (new AdminDAO().editProfile(admin.getEmail(), nom, prenom, email, password, dateNaissance, sexe)) {
            System.out.println("Edit : true");
            response.sendRedirect("/accueilAdmin");
        } else {
            getServletContext().getRequestDispatcher("/espace_admin/profil.jsp").forward(request, response);
            System.out.println("Edit : false");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/espace_admin/profil.jsp").forward(request, response);
    }

}
