package servlets.administration;

import model.beans.User;
import model.db.dao.ClientsDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "ListeClientsServlet", urlPatterns = "/ListeClients")
public class ListeClientsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LinkedList<Object> clients = new ClientsDAO().getAll();
        if (clients.size() > 0) {
            request.setAttribute("clients", clients);
            getServletContext().getRequestDispatcher("/liste utilisateur.jsp").forward(request, response);
        } else
            doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/administrateur.html").forward(request, response);

    }
}
