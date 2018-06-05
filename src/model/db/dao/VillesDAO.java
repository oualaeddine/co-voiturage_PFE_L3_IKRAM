package model.db.dao;

import model.beans.Ville;
import model.db.DAO;
import model.db.DAOInterface;

import java.sql.ResultSet;
import java.util.LinkedList;

public class VillesDAO extends DAO implements DAOInterface {
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
        Ville ville = (Ville) object;
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
        // TODO Auto-generated method stub
        return null;
    }
}
