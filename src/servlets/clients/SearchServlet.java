package servlets.clients;

import model.beans.Trajet;
import model.beans.User;
import model.beans.Ville;
import model.db.dao.ClientsDAO;
import model.db.dao.TrajetsDAO;
import model.db.dao.VillesDAO;
import servlets.MyServlet;
import util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.LinkedList;

@WebServlet(name = "SearchServlet", urlPatterns = "/trajets")
public class SearchServlet extends MyServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action != null)
            switch (action) {
                case "search": {
                    //Vérifier ida raho voyageur
                	String villeDepart = request.getParameter("depart");
                    String villeArrivee = request.getParameter("arrivee");
                    String date = request.getParameter("date");
                    String heure = request.getParameter("time");
                    
                    LinkedList<Trajet> trajets = new TrajetsDAO().getByDate(villeDepart, villeArrivee, date,heure);

                    if (trajets.size() > 0) {
                    	request.setAttribute("trajets", trajets);
                     	getServletContext().getRequestDispatcher("/resultat").forward(request, response);
                        //response.getWriter().append("hedi la page lazm tetcrea");
                    }else
                        doGet(request, response);               
                    break;
                }
                case "add": { 
                    //Vérifier ida raho conducteur

                	HttpSession session = request.getSession(false);
                	User user = (User) session.getAttribute("user");
                	
                    String villeDepart = request.getParameter("depart");
                    String villeArrivee = request.getParameter("arrivee");
                    Float prix = Float.parseFloat(request.getParameter("prix"));
                    String nombrePlaces = request.getParameter("places");
                    String typeVéhicule = request.getParameter("type");
                    Date date = Util.getDateFromString(request.getParameter("date"));
                    Time heure = Time.valueOf(request.getParameter("time"));

                    ClientsDAO userDAO = new ClientsDAO();
                    
                    Trajet trajet = new Trajet();
                    
                    trajet.setDepart(new VillesDAO().getVilleByName(villeDepart));
                    trajet.setArrive(new VillesDAO().getVilleByName(villeArrivee));
                    trajet.setPrix(prix);
                    trajet.setTypeVéhicule(typeVéhicule);
                    trajet.setDate(date);
                    trajet.setEtat(true); 
                    trajet.setCreateur(user);
                    trajet.setNombrePlaces(Integer.parseInt(nombrePlaces));
                    trajet.setHeure(heure);
                 
                    if (new TrajetsDAO().add(trajet)) {
            			System.out.println("proposer : true");
            			try {
            				response.sendRedirect("/home");
            			} catch (IOException e) {
            				e.printStackTrace();
            			}

            		} else {
            			getServletContext().getRequestDispatcher("/home").forward(request, response);
            			System.out.println("false : false");
            		}

                    
                    
                break;
                }
            }
        else doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/recherche/rchercher trajet.jsp").forward(request, response);
    }
}
