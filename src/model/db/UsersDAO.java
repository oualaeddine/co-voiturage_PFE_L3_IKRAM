package model.db;

import model.beans.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO extends DAO {

    public boolean exists(String username, String password) {
        User person = new User();
        person.setPassword(password);
        person.setUsername(username);
        ResultSet result;
        try {
            result = statement.executeQuery("SELECT * FROM `users`;");
            while (result.next()) {
                String username_ = result.getString("username");
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
            statement.execute("UPDATE users SET password='" + pwd + "' WHERE id = " + id + ";");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean updatePassword(String pwd, int id) {
        try {
            statement.execute("UPDATE users SET password = '" + pwd + "' WHERE id=" + id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getByEmail(String email) {
        ResultSet result;
        try {
            result = statement.executeQuery("SELECT * FROM users WHERE email='" + email + "';");
            if (result.next()) {
                User client = new User();
                client.setId(result.getInt("id"));
                client.setNom(result.getString("nom"));
                client.setPrenom(result.getString("prenom"));
                client.setEmail(result.getString("email"));
                client.setPassword(result.getString("password"));

                return client;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean createUser(String nom, String prenom, String email, String password) {
        try {
            statement.execute("insert into `users`(nom,prenom,email,password) values ('" + nom + "','" + prenom + "','" + email + "','" + password + "')");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getById(int createur) {
        return null;
    }
}
