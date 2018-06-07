package servlets;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.User;

import java.io.IOException;

@WebServlet(name = "MyServlet", urlPatterns = "/servlet")
public class MyServlet extends HttpServlet {

    protected boolean isAdminLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        User admin = (User) session.getAttribute("admin");

        return admin != null;
    }

    protected boolean isClientLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        User client = (User) session.getAttribute("client");

        return client != null;
    }

    protected void redirectToLogin(HttpServletResponse response) throws IOException {
        response.sendRedirect("/accueilAdmin");
    }
}
