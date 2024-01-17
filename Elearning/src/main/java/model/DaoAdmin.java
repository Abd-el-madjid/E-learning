package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAdmin {
    private final String url = "jdbc:mysql://localhost:3306/elearning2";
    private final String root = "root";
    private final String password = "04122002";
    //
    private Connection connection;
    private PreparedStatement preparedStatement;

    //
    public DaoAdmin() {
        //
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, root, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //
    public boolean testConnection() {
        //
        try {
            DriverManager.getConnection(url, root, password);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkadmin(String email, String password) {
        //
      

        try {
            preparedStatement = connection.prepareStatement("select * from admins where admin_email =? && admin_password = ?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //
    public Admin getAdmin(String email) {
        //
       
        Admin admin = null;

        try {
            preparedStatement = connection.prepareStatement("select * from admins where admin_email=?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            admin = new Admin(resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
    
   
    
}






