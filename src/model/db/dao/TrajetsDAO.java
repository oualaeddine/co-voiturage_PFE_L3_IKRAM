package model.db.dao;

import model.beans.Trajet;
import model.db.DAO;
import model.db.DAOInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class TrajetsDAO extends DAO implements DAOInterface {

    @Override
    public LinkedList getAll() {
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

    @Override
    public Object resultSetToObject(ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }

}
