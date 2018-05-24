package model.db;

import model.beans.User;
import util.Util;
import util.enums.UserType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO extends DAO {

    public boolean exists(String username, String password, UserType type) {
        User person = new User();
        person.setPassword(password);
        person.setUsername(username);
        ResultSet result;
        try {
            String table = Util.getStringFromType(type);
            result = statement.executeQuery("SELECT * FROM " + table);
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

}
