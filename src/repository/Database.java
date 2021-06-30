package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static final String DB_URL = "jdbc:h2:./db/Database";
    public static final String DB_Driver = "org.h2.Driver";

    public Database() throws ClassNotFoundException{
        Class.forName(DB_Driver);
    }

    public static Connection getConnection() throws SQLException {

//        try {
//            Class.forName(DB_Driver);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        return DriverManager.getConnection(DB_URL);
    }

}
