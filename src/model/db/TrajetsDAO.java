package model.db;

import model.beans.Trajet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class TrajetsDAO extends DAO {

    public boolean ajouterTrajet(Trajet trajet) {
        try {
            statement.execute("insert into `trajets`(etat,depart,desti,createur) values " +
                    "('disponible" +
                    "','" + trajet.getDepart() +
                    "','" + trajet.getDesti() +
                    "'," + trajet.getCreateur().getId() + ")");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public LinkedList<Trajet> getByDate(String depart, String arrive, String date) {
        ResultSet result;
        try {
            result = statement.executeQuery("SELECT * FROM trajets " +
                    " WHERE date ='" + date + "' " +
                    " and depart ='" + depart + "' " +
                    " and etat ='disponible' " +
                    " and desti ='" + arrive + "';");
            LinkedList<Trajet> trajets = new LinkedList<>();
            while (result.next()) {
                Trajet trajet = new Trajet();
                trajet.setId(result.getInt("id"));
                trajet.setDepart(result.getString("nom"));
                trajet.setDesti(result.getString("prenom"));
                trajet.setCreateur(new UsersDAO().getById(Integer.parseInt(result.getString("createur"))));
                trajet.setDate(result.getDate("date"));
                trajets.add(trajet);
            }
            return trajets;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
