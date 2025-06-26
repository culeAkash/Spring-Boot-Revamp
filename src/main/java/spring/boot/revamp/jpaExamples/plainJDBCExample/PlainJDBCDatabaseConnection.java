package spring.boot.revamp.jpaExamples.plainJDBCExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PlainJDBCDatabaseConnection {

    public Connection getConnection(){
        try{
            // Load the driver for the RDBMS
            Class.forName("org.h2.Driver");

            // return the connection with DB
            return DriverManager.getConnection("jdbc:h2:mem:userDB","sa","");
        } catch (ClassNotFoundException | SQLException ex) {
            // handle exception
        }
        return null;
    }
}
