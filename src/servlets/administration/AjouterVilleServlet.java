package servlets.administration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AjouterVilleServlet", urlPatterns = "/ville")
public class AjouterVilleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("").forward(request, response);
    }// TODO: 6/6/2018

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }// TODO: 6/6/2018
}
