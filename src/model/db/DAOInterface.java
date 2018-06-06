package model.db;

import java.sql.ResultSet;
import java.util.LinkedList;

public interface DAOInterface {
    LinkedList<Object> getAll();

    Object getById(int id);

    boolean add(Object object);

    boolean delete(Object object);

    boolean edit(Object object);

    Object resultSetToObject(ResultSet resultSet);
}
