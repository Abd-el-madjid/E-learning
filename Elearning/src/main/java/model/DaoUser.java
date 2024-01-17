package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoUser {
    private final String url = "jdbc:mysql://localhost:3306/elearning3";
    private final String root = "root";
    private final String password = "04122002";
    //
    private Connection connection;
    private PreparedStatement preparedStatement;

    //
    public DaoUser() {
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

   ///////////////////////////////////////////////////////////////////////////////// 
    
    
    
    
    public boolean checkUser(String email) {
        //
       
        boolean A = false;

        try {
            preparedStatement = connection.prepareStatement("select * from users where user_email=?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            A = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //
        return A;
    }

    //
    public boolean checkClogin(String email, String password) {
        //
     
        try {
            preparedStatement = connection.prepareStatement("select * from users where user_email =? && user_password = ?");
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
    public User getUser(String email) {
        //
        User user = null;

        try {
            preparedStatement = connection.prepareStatement("select user_email ,user_firstname, user_lastname ,user_password ,user_type,  user_sex  from users where user_email=?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user = new User(resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    //
    public String getType(String email) {
        //
     
        String Type = null;

        try {
            preparedStatement = connection.prepareStatement("select user_type from users where user_email=?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Type = resultSet.getString("user_type");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Type;
    }
    /////
    public int getid(String email) {
        //
     
        int id = 0;

        try {
            preparedStatement = connection.prepareStatement("select user_id from users where user_email=?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            id = resultSet.getInt("user_id");
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    //
    public List<User> getUsers() {
        //
        List<User> users = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select user_email ,user_firstname, user_lastname ,user_password ,user_type,  user_sex  from users  where user_type = \"teacher\" or user_type =\"etudiant\"");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
            	User user = new User(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
    public List<User> getEtudiants() {
        //
        List<User> users = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select user_email ,user_firstname, user_lastname ,user_password ,user_type,  user_sex  from users  where  user_type =\"etudiant\"");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
            	User user = new User(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
    public List<User> getTeachers() {
        //
        List<User> users = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select user_email ,user_firstname, user_lastname ,user_password ,user_type,  user_sex  from users  where user_type = \"teacher\" ");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
            	User user = new User(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    //
    public List<User> sortByEmail() {
        //
        return this.getUsers();
    }

    //
    public List<User> sortByName() {
        //
        List<User> users = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select user_email ,user_firstname, user_lastname ,user_password ,user_type,  user_sex from users order by user_name");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
                User user = new User(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    //
    public List<User> sortByType() {
        //
        List<User> users = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select user_email ,user_firstname, user_lastname ,user_password ,user_type,  user_sex from users order by user_type");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
                User user = new User(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    //
    public int getUsersnumb() {
        //
        try {
            preparedStatement = connection.prepareStatement("select COUNT(*) from users");
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //
        return 0;
    }

    //
    public boolean addUser(User user) {
        //
        if (checkUser(user.getEmail())) {
            return false;
        }

        //
        try {

            preparedStatement = connection.prepareStatement("INSERT INTO `elearning3`.`users` (`user_email`, `user_firstname`, `user_lastname`, `user_password`, `user_type`, `user_sex`) values (?,?,?,?,?,?)");
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getFirstname());
            preparedStatement.setString(3, user.getLastname());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getType());
            preparedStatement.setString(6, user.getSex());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //
    public boolean deleteUser(String email) {
        //
       

        if (!checkUser(email)) {
            return false;
        }

        //
        try {

            preparedStatement = connection.prepareStatement("delete from elearning3.users where user_email=?");
            preparedStatement.setString(1, email);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //
    public boolean updateUser(int id,String newemail ,String fname , String lname,String password) {
        //
      
        //
       
        //
      

        //
        try {

            preparedStatement = connection.prepareStatement(
                    "    	UPDATE `elearning3`.`users` SET  `user_firstname` = ?, `user_lastname` =?, `user_password` = ? ,`user_email` = ? where user_id=? ");
            
            preparedStatement.setString(1, fname);
            preparedStatement.setString(2, lname);
            preparedStatement.setString(3, password);

            preparedStatement.setString(4, newemail);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateUser_email(String email,String newemail ) {
        //
      
        //
       
        //
      

        //
        try {

            preparedStatement = connection.prepareStatement(
                    "    	UPDATE `elearning3`.`users` SET  `user_email` = ? where user_email=? ");
            
         
            preparedStatement.setString(1, newemail);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
  
    
    public boolean updateUser_fname(String email,String newfname ) {
        //
      
        //
       
        //
      

        //
        try {

            preparedStatement = connection.prepareStatement(
                    "    	UPDATE `elearning3`.`users` SET  `user_firstname` = ? where user_email=? ");
            
         
            preparedStatement.setString(1, newfname);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateUser_lname(String email,String newlname ) {
        //
      
        //
       
        //
      

        //
        try {

            preparedStatement = connection.prepareStatement(
                    "    	UPDATE `elearning3`.`users` SET  `user_lastname` = ? where user_email=? ");
            
         
            preparedStatement.setString(1, newlname);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateUser_password(String email,String newpass ) {
        //
      
        //
       
        //
      

        //
        try {

            preparedStatement = connection.prepareStatement(
                    "    	UPDATE `elearning3`.`users` SET  `user_password` = ? where user_email=? ");
            
         
            preparedStatement.setString(1, newpass);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}






