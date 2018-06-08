package servlets.clients;

import model.beans.Trajet;
import model.beans.Ville;
import model.db.dao.ClientsDAO;
import model.db.dao.TrajetsDAO;
import model.db.dao.VillesDAO;
import util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.LinkedList;

@WebServlet(name = "SearchServlet", urlPatterns = "/trajets")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action != null)
            switch (action) {
                case "search": {
                    String depart = request.getParameter("depart");
                    String arrive = request.getParameter("arrive");
                    String date = request.getParameter("date");
                    //lzm ykon voyageur neb3to l servlet resultat les info
                    LinkedList<Trajet> trajets = new TrajetsDAO().getByDate(depart, arrive, date);

                    if (trajets.size() > 0)
                        //getServletContext().getRequestDispatcher("/resultat").forward(request, response);
                        response.getWriter().append("hedi la page lazm tetcrea");
                    else
                        doGet(request, response);
                    break;
                }
                case "add": {
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    String depart = request.getParameter("depart");
                    String arrive = request.getParameter("arriv");
                    String date = request.getParameter("date");

                    ClientsDAO userDAO = new ClientsDAO();
                    if (userDAO.exists(email, password)) {
                        Trajet trajet = new Trajet();
                        trajet.setCreateur(userDAO.getByEmail(email));
                        trajet.setDepart(new VillesDAO().getVilleByName(depart));
                        trajet.setArrive(new VillesDAO().getVilleByName(arrive));
                        Date _date = Util.getDateFromString(date);
                        trajet.setDate(_date);
                        new TrajetsDAO().add(trajet);

                        LinkedList<Trajet> trajets = new TrajetsDAO().getByDate(depart, arrive, date);

                        if (trajets.size() > 0)
                            getServletContext().getRequestDispatcher("/recherche/resultat.jsp").forward(request, response); // hedi la page ey makanch
                        else
                            doGet(request, response);
                    } else
                        doGet(request, response);

                    break;
                }
            }
        else doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/recherche/rechercher.html").forward(request, response);
    }
}
