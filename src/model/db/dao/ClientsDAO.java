package model.db.dao;

import model.beans.User;
import model.db.DAO;
import model.db.DAOInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import static util.enums.UserType.CLIENT;

public class ClientsDAO extends DAO implements DAOInterface {

    private static String TABLE_NAME = "utilisateurs";


    public boolean exists(String username, String password) {
        User person = new User();
        person.setPassword(password);
        person.setUsername(username);
        ResultSet result;
        try {
            result = statement.executeQuery("SELECT * FROM `" + TABLE_NAME + "`;");
            while (result.next()) {
                String username_ = result.getString("email");
                String password_ = result.getString("password");
                if (person.getUsername().equals(username_) && person.getPassword().equals(password_))
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean changePassword(int id, String pwd) {
        try {
            statement.execute("UPDATE `" + TABLE_NAME + "` SET password='" + pwd + "' WHERE id = " + id + ";");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean updatePassword(String pwd, int id) {
        try {
            statement.execute("UPDATE `" + TABLE_NAME + "` SET password = '" + pwd + "' WHERE id=" + id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getByEmail(String email) {
        ResultSet result;
        try {
            result = statement.executeQuery("SELECT * FROM `" + TABLE_NAME + "` WHERE email='" + email + "';");
            return (User) resultSetToObject(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean createClient(String nom, String prenom, String email, String password) {
        try {
            statement.execute("insert into `" + TABLE_NAME + "`(nom,prenom,email,password) values ('" + nom + "','" + prenom + "','" + email + "','" + password + "')");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public LinkedList getAll() {
        return null;
    }

    public User getById(int id) {
        ResultSet result;
        try {
            result = statement.executeQuery("SELECT * FROM `" + TABLE_NAME + "` WHERE id=" + id + ";");
            return (User) resultSetToObject(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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


    /**
     * @param resultSet le resultSet contenant le client
     * @return un objet client
     */
    @Override
    public Object resultSetToObject(ResultSet resultSet) {
        try {
            if (resultSet.next()) {

                User client = new User();
                client.setUserType(CLIENT);
                client.setId(resultSet.getInt("id"));
                client.setNom(resultSet.getString("nom"));
                client.setPrenom(resultSet.getString("prenom"));
                client.setEmail(resultSet.getString("email"));
                client.setPassword(resultSet.getString("password"));

                return client;
            } else return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
