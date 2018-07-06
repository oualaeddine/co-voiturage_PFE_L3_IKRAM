package model.db.dao;

public class AdminDAO extends DAO implements DAOInterface{

    private static String TABLE_NAME = "admins";

    public boolean editProfile(String currentEmail, String nom, String prenom,String email, String password,Date dateNaissance,String sexe) {
        try {
            statement.execute("UPDATE `" + TABLE_NAME + "` SET nom = '" + nom + "' , prenom = '"+prenom+"',  email ='"+email+"' ,password ='"+ password +"',dateNaissance ='"+dateNaissance+"' , sexe ='"sexe"'   WHERE email=" + currentEmail+ ";");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
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

                return admin;
            } else return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
