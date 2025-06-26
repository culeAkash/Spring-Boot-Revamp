package spring.boot.revamp.jpaExamples.plainJDBCExample;

import java.sql.*;

public class PlainJDBCUserDAO {

    public void createTable(){
        try {
            // get the connection to DB
            Connection connection = new PlainJDBCDatabaseConnection().getConnection();
            Statement statementQuery = connection.createStatement();
            // create query to be executed
            String sql = "CREATE TABLE users(user_id INT AUTO_INCREMENT PRIMARY KEY, user_name VARCHAR(100), age INT)";
            statementQuery.executeQuery(sql);
        } catch (SQLException e) {
            // handle exception
        }finally {
            // close DB connection and Statement object
        }
    }

    public void createUser(String userName,int age){
        try{
            // get the connection to DB
            Connection connection = new PlainJDBCDatabaseConnection().getConnection();
            String sql = "INSERT INTO users(user_name,age) VALUES (?,?)";
            PreparedStatement preparedStatementQuery = connection.prepareStatement(sql);
            preparedStatementQuery.setString(1,userName);
            preparedStatementQuery.setInt(2,25);
            preparedStatementQuery.executeQuery();
        } catch (SQLException e) {
            // handle exception
        }finally {
            // close DB connection and Statement object
        }

    }

    public String getAllUsers(){
        try{
            // get the connection to DB
            Connection connection = new PlainJDBCDatabaseConnection().getConnection();
            String sql = "SELECT * FROM users";
            PreparedStatement preparedStatementQuery = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatementQuery.executeQuery();
            String userDetails = "";
            while(resultSet.next()){
                userDetails = resultSet.getInt("user_id") + ":"
                        + resultSet.getString("user_name") + ":"
                        + resultSet.getInt("age");
                System.out.println(userDetails);
            }
            return userDetails;
        } catch (SQLException e) {
            // handle exception
            System.out.println(e.getMessage());
        }finally {
            // close DB connection and Statement object
        }
        return null;
    }
}
