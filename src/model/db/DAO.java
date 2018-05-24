package model.db;

import com.mysql.jdbc.Statement;

public class DAO {

    protected Statement
            statement;


    public DAO() {
        statement = (Statement) DbConnector.getStatment();
    }
}
