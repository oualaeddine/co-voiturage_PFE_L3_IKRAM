package model.db.dao;

import model.beans.Itiniraire;
import model.beans.Ville;
import model.db.DAO;
import model.db.DAOInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class ItiniraireDAO extends DAO implements DAOInterface {

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
                int depart = resultSet.getInt("ville_depart");
                int arrive = resultSet.getInt("ville_depart");
                float prix = resultSet.getInt("prix");

                VillesDAO villesDAO = new VillesDAO();
                Ville v_depart = (Ville) villesDAO.getById(depart);
                Ville v_arrive = (Ville) villesDAO.getById(arrive);

                Itiniraire itiniraire = new Itiniraire();
                itiniraire.setArrive(v_arrive);
                itiniraire.setDepart(v_depart);
                itiniraire.setPrix(prix);
                itiniraire.setId(id);

                return itiniraire;
            } else return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
