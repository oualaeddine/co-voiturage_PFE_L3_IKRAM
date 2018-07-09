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
            statement.execute("UPDATE `" + TABLE_NAME + "` SET password = '" + pwd + "' WHERE id=" + id + ";");
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


    public boolean createClient(String nom, String prenom, String email, String password, String type) {
        try {
            statement.execute("insert into `" + TABLE_NAME + "`(nom,prenom,email,password,type) values ('" + nom + "','" + prenom + "','" + email + "','" + password+ "','" + type + "')");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public LinkedList<User> getAll() {
        ResultSet result;
        try {
            result = statement.executeQuery("SELECT * FROM `" + TABLE_NAME + "`;");

            LinkedList<User> clients = new LinkedList<>();
            while (result.next()) {
                clients.add((User) resultSetToObject(result));
            }
            return clients;
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                client.setTypeClient(resultSet.getString("type"));

                return client;
            } else return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

	public boolean isVoyageur(User user) {
		if(getById(user.getId()).getTypeClient().equals("voyageur"))
			return true;
		return false;
	}

	public boolean isConducteur(User user) {
		if(getById(user.getId()).getTypeClient().equals("conducteur"))
			return true;
		return false;
	}
}
