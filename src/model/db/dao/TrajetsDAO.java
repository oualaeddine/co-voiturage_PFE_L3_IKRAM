package model.db.dao;

import model.beans.Itiniraire;
import model.beans.Trajet;
import model.beans.User;
import model.beans.Ville;
import model.db.DAO;
import model.db.DAOInterface;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class TrajetsDAO extends DAO implements DAOInterface {

    private static String TABLE_NAME = "trajets";

    public LinkedList<Trajet> getAll() {
        ResultSet result;
        try {
            result = statement.executeQuery("SELECT * FROM `" + TABLE_NAME + "`;");

            LinkedList<Trajet> trajets = new LinkedList<>();
            while (result.next()) {
                int id = result.getInt("id");
                boolean etat = result.getBoolean("etat");
                int depart = result.getInt("depart");
                int arrive = result.getInt("desti");
                int createur = result.getInt("createur");
                Date date = result.getDate("date");

                VillesDAO villesDAO = new VillesDAO();
                Ville v_depart = (Ville) villesDAO.getById(depart);
                Ville v_arrive = (Ville) villesDAO.getById(arrive);

                ItiniraireDAO ItiniraireDAO = new ItiniraireDAO();
                Itiniraire itiniraire = (Itiniraire) ItiniraireDAO.getByVille(v_depart, v_arrive);

                Trajet trajet = new Trajet();
                trajet.setId(id);
                trajet.setItiniraire(itiniraire);
                trajet.setEtat(etat);
                trajet.setCreateur(new ClientsDAO().getById(id));
                trajet.setDate(date);
                trajets.add(trajet);
            }
            return trajets;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public boolean add(Object object) {
        Trajet trajet = (Trajet) object;
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

    @Override
    public boolean delete(Object object) {
        return false;
    }

    @Override
    public boolean edit(Object object) {
        return false;
    }

    @Override
    public Object resultSetToObject(ResultSet resultSet) {
        try {
            if (resultSet.next()) {

                int id = resultSet.getInt("id");
                boolean etat = resultSet.getBoolean("etat");
                int depart = resultSet.getInt("depart");
                int arrive = resultSet.getInt("desti");
                int createur = resultSet.getInt("createur");
                Date date = resultSet.getDate("date");

                VillesDAO villesDAO = new VillesDAO();
                Ville v_depart = (Ville) villesDAO.getById(depart);
                Ville v_arrive = (Ville) villesDAO.getById(arrive);

                ItiniraireDAO ItiniraireDAO = new ItiniraireDAO();
                Itiniraire itiniraire = (Itiniraire) ItiniraireDAO.getByVille(v_depart, v_arrive);

                Trajet trajet = new Trajet();
                trajet.setId(id);
                trajet.setItiniraire(itiniraire);
                trajet.setEtat(etat);
                trajet.setCreateur(new ClientsDAO().getById(id));
                trajet.setDate(date);

                return trajet;
            } else return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
                trajet.setCreateur(new ClientsDAO().getById(Integer.parseInt(result.getString("createur"))));
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
