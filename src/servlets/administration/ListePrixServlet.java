package servlets.administration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListePrixServlet", urlPatterns = "/ListePrix")
public class ListePrixServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        LinkedList<Itiniraire> itiniraires = new ItiniraireDAO().getAll();
        if (itiniraires.size() > 0) {
    		request.setAttribute("itiniraires", itiniraires);	
            getServletContext().getRequestDispatcher("/liste de prix.jsp").forward(request, response);
        } else
            doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        getServletContext().getRequestDispatcher("/administrateur.jsp").forward(request, response);

    }
}
