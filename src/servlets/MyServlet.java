package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MyServlet")
public class MyServlet extends HttpServlet {

    protected boolean isLoggedIn() {
        return true;
    }

    protected void redirectToLogin(HttpServletResponse response) throws IOException {
        response.sendRedirect("/accueilAdmin");
    }
}
