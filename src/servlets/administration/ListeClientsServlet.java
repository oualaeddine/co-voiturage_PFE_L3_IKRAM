package servlets.administration;

import model.beans.User;
import model.db.dao.ClientsDAO;
import servlets.MyServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "ListeClientsServlet", urlPatterns = "/ListeClients")
public class ListeClientsServlet extends MyServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LinkedList<User> clients = new ClientsDAO().getAll();
        request.setAttribute("clients", clients);
        getServletContext().getRequestDispatcher("/espace_admin/liste utilisateur.jsp").forward(request, response);
    }
}
