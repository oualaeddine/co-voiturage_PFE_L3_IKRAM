package model.db.dao;

import model.beans.Ville;
import model.db.DAO;
import model.db.DAOInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class VillesDAO extends DAO implements DAOInterface {

    private static final String TABLE_NAME = "villes";

    public LinkedList<Ville> getAll() {
        ResultSet result;
        try {

            result = statement.executeQuery("SELECT * FROM `" + TABLE_NAME + "`;");

            LinkedList<Ville> villes = new LinkedList<>();
            while (result.next()) {
                Ville ville = new Ville();
                ville.setId(result.getInt("id"));
                ville.setName(result.getString("name"));
                System.out.println(ville);
                villes.add(ville);
            }
            return villes;
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
        Ville ville = (Ville) object;
        try {
            statement.execute("insert into `" + TABLE_NAME + "`(name) values ('" + ville.getName() + "')");

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
    public Ville resultSetToObject(ResultSet resultSet) {
        return null;
    }

    public Ville getVilleByName(String villeName) {
        // TODO: 6/7/2018
        return null;
    }
}
