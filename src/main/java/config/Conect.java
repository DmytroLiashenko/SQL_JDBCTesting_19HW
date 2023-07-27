package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conect {


    private Connection collection;
    public Connection newConnection() throws SQLException {
        if(collection==null){
            collection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306","root","Tutupuh911");
        }
        return collection;
    }

    public Conect() throws SQLException {
        newConnection();
    }
}
