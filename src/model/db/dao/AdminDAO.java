package model.db.dao;

import model.beans.User;
import model.db.DAO;
import model.db.DAOInterface;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import static util.enums.UserType.ADMIN;

public class AdminDAO extends DAO implements DAOInterface {

    private static String TABLE_NAME = "admins";

    public boolean editProfile(int id, String nom, String prenom, String email, String password, Date dateNaissance, String sexe) {
        try {
            statement.execute("UPDATE `" + TABLE_NAME + "` SET nom = '" + nom + "' , prenom = '" + prenom + "',  email ='" + email + "' ,password ='" + password + "',dateNaissance ='" + dateNaissance + "' , sexe ='" + sexe + "'   WHERE id=" + id + ";");

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @SuppressWarnings("Duplicates")
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

    @Override
    public Object resultSetToObject(ResultSet resultSet) {
        try {
            if (resultSet.next()) {

                User admin = new User();
                admin.setUserType(ADMIN);
                admin.setId(resultSet.getInt("id"));
                admin.setNom(resultSet.getString("nom"));
                admin.setPrenom(resultSet.getString("prenom"));
                admin.setEmail(resultSet.getString("email"));
                admin.setPassword(resultSet.getString("password"));
                admin.setDateNaissance(resultSet.getDate("dateNaissance"));

                return admin;
            } else return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public LinkedList<Object> getAll() {
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


}
