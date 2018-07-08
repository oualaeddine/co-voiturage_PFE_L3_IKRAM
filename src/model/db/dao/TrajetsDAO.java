package model.db.dao;

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
                trajets.add((Trajet) resultSetToObject(result));
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
            statement.execute("insert into `trajets`(etat,depart,desti,createur,date,prix,nombrePlaces,typeVéhicule) values " +
                    "('disponible" +
                    "','" + trajet.getDepart().getId() +
                    "','" + trajet.getArrive().getId() +
                    "','" + trajet.getCreateur().getId() +
                    "','" + trajet.getDate() +
                    "','" + trajet.getPrix() +
                    "','" + trajet.getNombrePlaces() +
                    "','" + trajet.getTypeVéhicule() + ")");
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
                float prix = resultSet.getFloat("prix");
                int nombrePlaces = resultSet.getInt("nombrePlaces");
                String typeVéhicule = resultSet.getString("typeVéhicule");

                VillesDAO villesDAO = new VillesDAO();
                Ville v_depart = (Ville) villesDAO.getById(depart);
                Ville v_arrive = (Ville) villesDAO.getById(arrive);           

                Trajet trajet = new Trajet();
                trajet.setArrive(v_arrive);
                trajet.setCreateur(new ClientsDAO().getById(createur));
                trajet.setDate(date);
                trajet.setDepart(v_depart);
                trajet.setEtat(etat);
                trajet.setId(id);
                trajet.setNombrePlaces(nombrePlaces);
                trajet.setPrix(prix);
                trajet.setTypeVéhicule(typeVéhicule);

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
                trajets.add((Trajet) resultSetToObject(result));
            }
            return trajets;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
