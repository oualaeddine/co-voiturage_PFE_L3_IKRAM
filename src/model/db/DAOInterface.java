package model.db;

import java.sql.ResultSet;

public interface DAOInterface {

    Object getById(int id);

    boolean add(Object object);

    boolean delete(Object object);

    boolean edit(Object object);

    Object resultSetToObject(ResultSet resultSet);
}
